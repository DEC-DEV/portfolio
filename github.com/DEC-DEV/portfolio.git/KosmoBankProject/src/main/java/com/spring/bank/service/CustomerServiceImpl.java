package com.spring.bank.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;
import com.spring.bank.dao.CustomerDAO;
import com.spring.bank.dto.CustomerDTO;
import com.spring.bank.dto.LoansDTO;
import com.spring.bank.util.EmailChkHandler;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired //=@Inject
	CustomerDAO dao;

	@Autowired
    BCryptPasswordEncoder passwordEncoder;   // 비밀번호 암호화 클래스

	// 아이디중복환인 처리
	@Override
	public void confirmIdAction(HttpServletRequest req, Model model) {
		System.out.println("서비스 confirmIdAction - 중복확인처리");

		//3. 화면으로부터 입력값을 받는다.
		String strId = req.getParameter("id");

		//5. 중복확인 처리
		int selectCnt = dao.idCheck(strId);

		//6. jsp로 처리 결과 전달 (request나 session으로 전달)
		model.addAttribute("id", strId);
		model.addAttribute("selectCnt", selectCnt);
	}
	
	// 신분증 인식
	@Override
	public void readIdCard(HttpServletRequest req, Model model, MultipartHttpServletRequest reqs) throws IOException {
		System.out.println("서비스 readIdCard - 신분증 인식");
		
		// 파일 parameter로 받음
		MultipartFile file = reqs.getFile("file");
		System.out.println("file : " + file);
		
		// 저장경로 지정
		String saveDir = req.getSession().getServletContext().getRealPath("/resources/upload/");
		
		// 저장경로
		String realDir = "C:\\Users\\Kosmo\\git\\BankProjectKosmoLast\\KosmoBankProject\\src\\main\\webapp\\resources\\upload\\";
		
		try {
			// 파일 경로에 원래 파일이름을 달아준다
			file.transferTo(new File(saveDir + file.getOriginalFilename()));
			
			FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// api에 보낼 파일 이름
		String filePath = req.getSession().getServletContext().getRealPath("resources/upload") + file.getOriginalFilename();
		System.out.println("filePath의 이름 : " + filePath);
		
		// api 호출
		Map<String, Object> map = detectText(filePath);
		
		System.out.println("name : " + map.get("name"));
		System.out.println("address1 : " + map.get("address1"));
		System.out.println("address2 : " + map.get("address2"));
		
		model.addAttribute("name", map.get("name"));
		model.addAttribute("address1", map.get("address1"));
		model.addAttribute("address2", map.get("address2"));
	}
	
	// ocr api 실행 메서드
	public static Map<String, Object> detectText(String filePath) throws IOException {
		List<AnnotateImageRequest> requests = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();

		ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
		AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);

		// Initialize client that will be used to send requests. This client only needs
		// to be created
		// once, and can be reused for multiple requests. After completing all of your
		// requests, call
		// the "close" method on the client to safely clean up any remaining background
		// resources.
		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();
			List<String> list = new ArrayList<>();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.format("Error: %s%n", res.getError().getMessage());
				}

				// For full list of available annotations, see http://g.co/cloud/vision/docs
				for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
					System.out.format("Text: %s%n", annotation.getDescription());
					//System.out.format("Position : %s%n", annotation.getBoundingPoly()); // 텍스트 좌표값
					list.add(annotation.getDescription());
					System.out.println("llst : " + list);
				}
			}
			String listValue = list.get(0);
			System.out.println("리스트 추출 값 : " + listValue);
			
			String name = listValue.substring(6, 9);
			System.out.println("name : " + name);
			String address1 = listValue.substring(27, 43);
			System.out.println("address1 : " + address1);
			String address2 = listValue.substring(46, 56);
			System.out.println("address2 : " + address2);
			
			// 맵에 담기
			map.put("name", name);
			map.put("address1", address1);
			map.put("address2", address2);
		}
		return map;
	}
	

	// 회원가입 처리
	@Override
	public void joinAction(HttpServletRequest req, Model model) {

		System.out.println("서비스 signInAction - 회원가입처리");

		//3단계. 화면으로부터 입력받은 값을 받아서 dto에 담는다.
		//dto 생성
		CustomerDTO dto = new CustomerDTO();

		dto.setId(req.getParameter("id"));

		// 비밀번호 암호화 - 시큐리티
	    String password = req.getParameter("password");
	    System.out.println("암호화 전의 비밀번호 : " + password);

	    // BCryptPasswordEncoder.encode() : 비밀번호 암호화 메서드
	    String encryptPassword = passwordEncoder.encode(password);
	    System.out.println("암호화 후의 비밀번호 : " + encryptPassword);

		dto.setPassword(encryptPassword);
		dto.setName(req.getParameter("name"));
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setAddress(req.getParameter("address"));
		dto.setAddress_detail((req.getParameter("address_detail")));
		//hp은 필수가 아니므로 null 값이 들어올 수 있으므로 값이 존재할 때만 처리
		String hp = "";
		String strHp1 = req.getParameter("hp1");
		String strHp2 = req.getParameter("hp2");
		String strHp3 = req.getParameter("hp3");
		if(!strHp1.equals("") && !strHp2.equals("") && !strHp3.equals("")) {
			hp = strHp1 + "-" + strHp2 + "-" + strHp3;
		}

		dto.setPhone(hp);

		String email = "";
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		email = email1 + "@" + email2;
		dto.setEmail(email);

		// 시큐리티
		String key = EmailChkHandler.getKey();
	    dto.setKey(key);

		// 5단계. 회원가입 처리
		int insertCnt = dao.insertCustomer(dto);
		System.out.println("서비스 insertCnt : " + insertCnt);

		// 시큐리티
	    // 시큐리티 - 가입성공시 이메일인증을 위해 이메일 전송
	    if(insertCnt == 1) {
	       dao.sendEmail(email, key);   // email은 반드시 가입한 구글계정 이메일
	    }

		// 6단계. jsp 결과 처리 전달(request나 session으로 처리 결과를 저장 후에 전달)
		model.addAttribute("insertCnt", insertCnt);

	}

	// 이메일 인증 후 권한(enabled) update - 시큐리티
	@Override
	public void emailChkAction(HttpServletRequest req, Model model) {
		System.out.println("service - emailChkAction");
		String key = req.getParameter("key");
		int selectCnt = dao.selectKey(key);
		if(selectCnt == 1) {
			int insertCnt = dao.updateGrade(key);
			model.addAttribute("insertCnt", insertCnt);
		}
	}


	// 로그인 처리
	@Override
	public void loginAction(HttpServletRequest req, Model model) {
		System.out.println("서비스 loginAction - 로그인 처리");

		String strId = req.getParameter("id");
		String strPassword = req.getParameter("password");

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("strId", strId);
		map.put("strPassword", strPassword);


		// 5단계. 로그인 처리
		int selectCnt = dao.idPasswordChk(map);
		System.out.println("서비스 selectCnt : " + selectCnt);

		if(selectCnt == 1) {
			// 로그인 성공시 세션 ID를 설정
			HttpSession session = req.getSession();
			session.setAttribute("customerID", strId);

			//req.getSession().setAttribute("customerID", strId);
		}

		// 6단계. jsp 결과 처리 전달(request나 session으로 처리 결과를 저장 후에 전달)
		model.addAttribute("selectCnt", selectCnt);
	}

	@Override
	public void update_login_history(HttpServletRequest req, Model model) {
		String id = (String)req.getSession().getAttribute("customerID");
		System.out.println("update_login_history-service : "+ id);
		dao.update_login_history(id);
		
	}
}
