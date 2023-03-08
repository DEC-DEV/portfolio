package com.spring.bank.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;  // 수정
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;
import com.spring.bank.dao.AccountDAOImpl;
import com.spring.bank.dao.AndroidDAO;

import com.spring.bank.dao.TransferDAO;
import com.spring.bank.dao.TransferDAOImpl;

import com.spring.bank.dao.ItemDAO;

import com.spring.bank.dto.AccountDTO;
import com.spring.bank.dto.CustomerDTO;

import com.spring.bank.dto.TransferDTO;
import com.spring.bank.service.AccountTransferServiceImpl;

import com.spring.bank.dto.Deposit_itemDTO;
import com.spring.bank.dto.FundDTO;
import com.spring.bank.dto.Loans_itemDTO;
import com.spring.bank.dto.Savings_itemDTO;
import com.spring.bank.dto.TransferDTO;


@Controller
public class AndroidController {
   // private Logger log = Logger.getLogger(this.getClass());
   private static final Logger log = LoggerFactory.getLogger(AndroidController.class);

   @Autowired
   AndroidDAO mainDao;

   @Autowired
   AccountDAOImpl AccountDAO;
   
   @Autowired
   TransferDAOImpl TransferDAO;

   @Autowired
   BCryptPasswordEncoder passwordEncoder;   // 비밀번호 암호화 클래스

	@Autowired
	ItemDAO itemDao;

//  OCR
//	@Autowired 
//	private CloudVisionTemplate cloudVisionTemplate;
//	
//	@Autowired
//	private ResourceLoader resourceLoader;

	@RequestMapping("android/androidSignIn")
	@ResponseBody  // 웹(스프링)에서 안드로이드로 값(json)을 전달하기 위한 어노테이션
	public Map<String, String> androidSignIn(HttpServletRequest req){
		log.info("androidSignIn()");
		// 안드로이드에서 전달한 값
		String id = req.getParameter("id");
		String password = req.getParameter("password");
      System.out.println("android id => " + id);
      System.out.println("android pwd => " + password);

      Map<String, String> in = new HashMap<String, String>();
      in.put("id", id);

      //로그인
      // JSONObject out = new JSONObject();
      String encryptPassword = mainDao.pwdCheck(id);

      int pwdCnt = 0;
      if(passwordEncoder.matches(password, encryptPassword)) {
         pwdCnt = 1;
      }

      String authority = null;
      if(pwdCnt == 1) {
         authority = mainDao.authorityCheck(id);
      }

      Map<String, String> out = new HashMap<String, String>();
      if(authority != null && pwdCnt == 1) {
         log.info("로그인 성공: " + authority);
         out.put("id", id);   // key는 CustomerDTO의 멤버변수와 일치
      } else {
         log.info("로그인 실패");
         out.put("id", null);
      }

      return out;
/*
INFO : spring.mvc.gsonEx.AndroidController - androidSignIn()
android id => hong
android pwd => 1234
id : hong
authority : ROLE_USER
INFO : spring.mvc.gsonEx.AndroidController - 로그인 성공: ROLE_USER
*/

   }


   // 앱 마이페이지
   @ResponseBody
   @RequestMapping("android/androidMyPageMain")
   public Map<String, Object> androidMyPageMain(HttpServletRequest req) {
      log.info("androidMyPageMain()");

      // 안드로이드에서 전달한 id값
      String id = req.getParameter("id");

      System.out.println("id : " + id);

      // 회원정보 조회
      CustomerDTO customer = mainDao.getMemberInfo(id);

      System.out.println("customer : " + customer);

      Map<String, Object> map = new HashMap<String, Object>();
      map.put("data1", customer.getName());
      map.put("data2", 0);
      map.put("data3", 0);
      map.put("data4", 0);
      map.put("customer", customer);

      return map;
   }



//   // 앱 로그인
//   @ResponseBody  // 웹(스프링)에서 안드로이드로 값(json)을 전달하기 위한 어노테이션
//   @RequestMapping("android/androidSignIn")
//   public Map<String, String> androidSignIn(HttpServletRequest req){
//      log.info("androidSignIn()");
//
//      // 안드로이드에서 전달한 값
//      String id = req.getParameter("id");
//      String pwd = req.getParameter("pwd");
//
//      Map<String, String> in = new HashMap<String, String>();
//      in.put("member_id", id);
//      in.put("member_pwd", pwd);
//      //로그인
//      String step = mainDao.confirmIdPwd(in);
//
//      // 웹에서 안드로이드로 전달할 값
//      Map<String, String> out = new HashMap<String, String>();
//      if(step != null) {
//         log.info("로그인 성공: " + step);
//         out.put("member_id", id);
//      } else {
//         log.info("로그인 실패");
//         out.put("member_id", null);
//      }
//
//      return out;
//   }
//
//
//   // 앱 마이페이지
//   @ResponseBody
//   @RequestMapping("androidMyPageMain")
//   public Map<String, Object> androidMyPageMain(HttpServletRequest req) {
//      log.info("androidMyPageMain()");
//
//      // 안드로이드에서 전달한 id값
//      String id = req.getParameter("id");
//
//      System.out.println("id : " + id);
//
//      // 회원정보 조회
//      Member m = mainDao.getMemberInfo(id);
//
//      System.out.println("m : " + m);
//
//      Map<String, Object> map = new HashMap<String, Object>();
//      map.put("data1", m.getMember_name());
//      map.put("data2", 0);
//      map.put("data3", 0);
//      map.put("data4", 0);
//      map.put("member", m);
//
//      return map;
//   }
//


   // 앱 계좌등록
   @ResponseBody
   @RequestMapping("android/androidRegAccount")
   public Map<String, String> androidRegAccount(HttpServletRequest req) {
      log.info("androidRegAccount()");

      Random ran = new Random();
      AccountDTO dto = new AccountDTO();

      // 안드로이드에서 전달한 id값
      String id = req.getParameter("customerID");
      String name = req.getParameter("account_name");
      String account_pwd = req.getParameter("account_password");
      String bank_name = req.getParameter("bank_name");

      // 계좌 번호
      int account_num1 =(int)(Math.random() * (9999 - 1000 + 1)) + 1000;
      int account_num2 =(int)(Math.random() * (9999 - 1000 + 1)) + 1000;
      System.out.println(account_num1);
      String account_num = account_num1 +"-"+account_num2;
      System.out.println(account_num);

      // dto에 저장
      dto.setId(id); // 아이디 저장
      dto.setName(name); // 이름 저장
      dto.setBank_name(bank_name);
      dto.setAccount_password(account_pwd); // 비밀번호 저장
      dto.setAccount_num(account_num); // 계좌번호 난수 저장

      int insertCnt = AccountDAO.Account_add( dto );
      Map<String,Object> map = new HashMap<String,Object>();
      account_num = AccountDAO.account_recent_select(id);
      map.put("insertCnt", insertCnt);
      map.put("account_num", account_num);

      Map<String, String> out = new HashMap<String, String>();
      if(insertCnt == 1) {
         log.info("등록 성공");
         out.put("result", "Success");   // key는 CustomerDTO의 멤버변수와 일치
      } else {
         log.info("등록 실패");
         out.put("result", null);
      }

      return out;
   }
// ocr
   @ResponseBody
   @RequestMapping("android/androidOcr")
   public static Map<String, Object> detectText(HttpServletRequest req) throws IOException {
      // TODO(developer): Replace these variables before running the sample.
      String filePath2 = req.getParameter("file"); // 사용 안함
      String filePath = "C:\\Users\\KOSMO\\Desktop\\test.jpg";
      System.out.println("filePath : " + filePath);
      //String filePath = "C:\\Users\\KOSMO\\Desktop\\test.jpg";
      Map<String, Object> map = detectText(filePath);
      System.out.println("위에서 받은 map 값 : " + map);
      
      return map;
   }
   
   // ocr2
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
   /*
   //보유 계좌 조회 androidAccountList
   @ResponseBody
   @RequestMapping("android/androidAccountList")
   public Map<String, String> androidAccountList(HttpServletRequest req) {
      log.info("androidAccountList()");

      AccountDTO dto = new AccountDTO();

      // 안드로이드에서 전달한 id값
      String id = req.getParameter("id");
      System.out.println("전달 받은 id 확인 : " + id);


      List<AccountDTO> list = AccountDAO.Account_All_selected(id);

      for(int i = 0; i < list.size(); i++) {

      }


      return list;
   }
   */
   
   //대출 상품 조회
   @ResponseBody
   @RequestMapping("android/loansList")
   public List<Loans_itemDTO> loansList(HttpServletRequest req) {
      log.info("loansList");
      
      List<Loans_itemDTO> list = itemDao.loans_Item();
      
      System.out.println("list" + list);
      return list;
   }
   

   //보유 계좌 조회 androidAccountList
   @ResponseBody
   @RequestMapping("android/androidAccountList")
   public List<AccountDTO> androidAccountList(HttpServletRequest req) {
      log.info("androidAccountList()");

      AccountDTO dto = new AccountDTO();

      // 안드로이드에서 전달한 id값
      String id = req.getParameter("id");
      System.out.println("전달 받은 id 확인 : " + id);

      List<AccountDTO> list = AccountDAO.Account_All_selected(id);
      System.out.println("list 확인 : " + list);

      return list;
   }



   // 계좌이체
   @ResponseBody
   @RequestMapping("android/androidTransfer")
   public Map<String, String> androidTransfer(HttpServletRequest req) {
      System.out.println("androidTransfer()");
      
      //전달받은 값 확인
      String account_num = req.getParameter("account_num2").trim();   // (이체하는)출금계좌번호   
      String account_num2 = req.getParameter("account_num").trim();   // (이체하는)입금계좌번호
      int money = Integer.parseInt(req.getParameter("money").trim());   // 이체할 금액
      int balance = Integer.parseInt(req.getParameter("balance"));   // 출금계좌잔액
      System.out.println("account_num : " + account_num);
      System.out.println("account_num2 : " + account_num2);
      System.out.println("money : " + money);
      System.out.println("balance : " + balance);
     
      
      Map<String, Object> map = new HashMap<String, Object>();
      balance = balance - money;
      map.put("balance", balance);
      map.put("account_num", account_num);
       
      // dao 호출 <!--3.  (보낸사람) 이체시 -된 계좌의 잔액  -->   
      int result = TransferDAO.account_transfer_send(map);
      System.out.println("result 확인 : " + result);
      
      // 받는 사람의 잔액 불러오기
      int balance2 = TransferDAO.call_balance(account_num2);
      AccountDTO dto = AccountDAO.android_accountInfo(account_num);
      Map<String, Object> map2 = new HashMap<String, Object>();
      balance2 = balance2 + money;
      map2.put("balance2", balance2);
      map2.put("account_num2", account_num2);
      
      // 받는 사람 계좌로 이체
      int result1 = TransferDAO.accoount_transfer_receive(map2); 
      System.out.println("result1 확인 : " + result1);
 
// 아이디 이름 확인
      System.out.println("아이디 이름 확인 : "+dto.toString() );
      Map<String, String> out = new HashMap<String, String>();
         if(result == 1 && result1 == 1) {
            log.info("등록 성공");
            out.put("result", "Success");
            out.put("id",dto.getId());// key는 CustomerDTO의 멤버변수와 일치
            out.put("name",dto.getName());
         } else {
            log.info("등록 실패");
            out.put("result", null);
         }

       return out;
   }
	
	/*
	//보유 계좌 조회 androidAccountList
	@ResponseBody
	@RequestMapping("android/androidAccountList")
	public Map<String, String> androidAccountList(HttpServletRequest req) {
		log.info("androidAccountList()");

		AccountDTO dto = new AccountDTO();

		// 안드로이드에서 전달한 id값
		String id = req.getParameter("id");
		System.out.println("전달 받은 id 확인 : " + id);


		List<AccountDTO> list = AccountDAO.Account_All_selected(id);

		for(int i = 0; i < list.size(); i++) {

		}


		return list;
	}
	*/

	
	// 펀드 리스트
	   @ResponseBody
	   @RequestMapping("android/androidFundList")
	   public List<FundDTO> androidFundList(HttpServletRequest req) {
	      log.info("androidFundList()");

	      FundDTO dto = new FundDTO();

	      // 안드로이드에서 전달한 id값
	      String id = req.getParameter("id");
	      System.out.println("전달 받은 id 확인 : " + id);

	      List<FundDTO> list = mainDao.fund_list(id);
	      System.out.println("list 확인 : " + list);

	      return list;
	   }
	   
	   //적금 상품 조회
	   @ResponseBody
	   @RequestMapping("android/savingsList")
	   public List<Savings_itemDTO> savingsList(HttpServletRequest req) {
	      log.info("savingsList");
	      
	      List<Savings_itemDTO> list = itemDao.savings_Item();
	      
	      System.out.println("list" + list);
	      return list;
	   }
	   
	   //예금 상품 조회
	   @ResponseBody
	   @RequestMapping("android/depositList")
	   public List<Deposit_itemDTO> depositList(HttpServletRequest req) {
	      log.info("depositList");
	      
	      List<Deposit_itemDTO> list = itemDao.deposit_Item();
	      
	      System.out.println("list" + list);
	      return list;
	   }
	// 회원가입
	   @ResponseBody
	   @RequestMapping("android/androidJoin")
	   public Map<String, Object> androidJoin(HttpServletRequest req) {
	      log.info("androidJoin()");
	      
	      String id = req.getParameter("id");
	      String password = req.getParameter("password");
	      System.out.println("암호화 전의 비밀번호 : " + password);
	      
	      String encryptPassword = passwordEncoder.encode(password);
	      System.out.println("암호화 후의 비밀번호 : " + encryptPassword);
	      
	      String name = req.getParameter("name");
	      String zipcode = req.getParameter("zipcode");
	      String address = req.getParameter("address");
	      String address_detail = req.getParameter("address_detail");
	      String phone = req.getParameter("phone");
	      String email = req.getParameter("email");
	      
	      CustomerDTO dto = new CustomerDTO();
	      dto.setId(id);
	      dto.setPassword(encryptPassword);
	      dto.setName(name);
	      dto.setZipcode(zipcode);
	      dto.setAddress(address);
	      dto.setAddress_detail(address_detail);
	      dto.setPhone(phone);
	      dto.setEmail(email);
	      
	      int insertCnt = mainDao.join(dto);
	      System.out.println("insertCnt : " + insertCnt);
	      
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("insertCnt", insertCnt);
	      
	      return map;
	   }
	   
		// 계좌 해지
		@ResponseBody
		@RequestMapping("android/accountCancel")
		public Map<String, Object> accountCancel(HttpServletRequest req) {
			// 계좌번호 받음
			String account_num = req.getParameter("account_num");
			// 비밀번호 받음
			String pwd = req.getParameter("account_password");
			String id = req.getParameter("id");
			System.out.println("확인 : "+account_num + pwd);
			Map<String,String> accountChk = new HashMap<String,String>();
			accountChk.put("account_num", account_num.trim());
			accountChk.put("account_pwd", pwd.trim());
			// 계좌 해지 처리
			int insertCnt = AccountDAO.account_pwd_chk(accountChk);
			System.out.println("계좌 해지 처리 : "+insertCnt);
			
			Map<String, Object> out = new HashMap<String, Object>();
			if(insertCnt == 1) {
				log.info("해지 성공");
				AccountDAO.my_sleep_account(account_num);
				Map<String,String> map = new HashMap<String,String>();
				map.put("id", id);
				map.put("account_num", account_num);
				// 계좌 상세 조회 페이지로 이동
				// 거래 내역 정보 
				List<TransferDTO> tlist = AccountDAO.my_trade_history(account_num);
				for( TransferDTO dto : tlist) {
					System.out.println(dto.getAccount_num());
					System.out.println(dto.getMoney());
				}

				// 계좌정보 전달 ( 계좌 1건의 정보를 조회)
				AccountDTO dto = AccountDAO.account_info_selected(account_num);

				// 값들을 넘김
				out.put("state",dto.getAccount_state());
				out.put("tlist",tlist);
				out.put("result", "Success"); 
				out.put("account_num",account_num);// key는 CustomerDTO의 멤버변수와 일치
				out.put("insertCnt",insertCnt);
				
			} else {
				log.info("해지 실패");
				out.put("result", "fail");
				out.put("insertCnt",insertCnt);
			}
			return out;
		}
		
		@ResponseBody
		@RequestMapping("android/androidDetail")
		public List<TransferDTO> accountDetail(HttpServletRequest req) {
			Map<String, Object> out = new HashMap<String, Object>();
			String account_num = req.getParameter("account_num");
			System.out.println("account_num : "+account_num);
			// 계좌정보 전달 ( 계좌 1건의 정보를 조회)
			AccountDTO dto = AccountDAO.account_info_selected(account_num);
			List<TransferDTO> tlist = AccountDAO.my_trade_history(account_num);
			for( TransferDTO tdto : tlist) {
				System.out.println(tdto.getAccount_num());
				System.out.println(tdto.getMoney());
			}
			// 거래내역정보 전달
			out.put("tlist", tlist);
			// 값들을 넘김
			
			return tlist;
		}
	
	

}

