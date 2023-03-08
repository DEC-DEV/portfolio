<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmosBank</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500&family=Roboto:wght@400;500;700&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${path }/resources/customer/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path }/resources/customer/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${path }/resources/customer/css/style.css" rel="stylesheet">
    
    <!-- select Stylesheet -->
    <link href="${path }/resources/customer/css/join.css" rel="stylesheet">
    
    <!-- join.js 추가 -->
	<script src="${path}/resources/customer/js/join.js" crossorigin="anonymous"></script>
	
	<!-- 주소찾기 -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">
		function execPostCode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	               // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	               var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	               var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	
	               // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	               // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	               if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                   extraRoadAddr += data.bname;
	               }
	               // 건물명이 있고, 공동주택일 경우 추가한다.
	               if(data.buildingName !== '' && data.apartment === 'Y'){
	                  extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	               }
	               // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	               if(extraRoadAddr !== ''){
	                   extraRoadAddr = ' (' + extraRoadAddr + ')';
	               }
	               // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	               if(fullRoadAddr !== ''){
	                   fullRoadAddr += extraRoadAddr;
	               }
	
	               console.log(data.zonecode);
	               console.log(fullRoadAddr);
	               
	               
	               // 우편번호와 주소 정보를 해당 필드에 넣는다.
	               document.getElementById('addr1').value = data.zonecode; //5자리 새우편번호 사용
	               document.getElementById('addr2').value = fullRoadAddr;
	               
	               /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
	               document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
	               document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
	           }
	        }).open();
	    }
	</script>
	<!-- 신분증 파일 업로드 자바 스크립트 -->
	<script type="text/javascript">
	function card() {
		var form = document.getElementById("joinform");
		form.action="${path}/idCardOcr.do?${_csrf.parameterName}=${_csrf.token}";
		form.method="post";
		form.submit();
	}
	</script>
</head>

<body>
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar & Hero Start -->
        <div class="container-xxl position-relative p-0">
        <!-- Full Screen Search Start -->
        <div class="modal fade" id="searchModal" tabindex="-1">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" style="background: rgba(29, 29, 39, 0.7);">
                    <div class="modal-header border-0">
                        <button type="button" class="btn bg-white btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center justify-content-center">
                        <div class="input-group" style="max-width: 600px;">
                            <input type="text" class="form-control bg-transparent border-light p-3" placeholder="Type search keyword">
                            <button class="btn btn-light px-4"><i class="bi bi-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Full Screen Search End -->
		  <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>

		<div class="container-xxl py-5">
            <div class="container px-lg-5">
                <div class="row justify-content-center">
                    <div class="col-lg-7" style="padding-top:80">
                        <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="position-relative d-inline text-primary ps-4">Kosmos Bank</h6>
                            <h2 class="mt-2">회원 정보 입력</h2>
                        </div>
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
                            <form name="joinform" id="joinform" action="${path}/joinAction.do?${_csrf.parameterName}=${_csrf.token}" method="post" onsubmit="return signInCheck();" enctype="multipart/form-data">
                            <input type="hidden" name="hiddenId" value="0">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <div class="row g-3">
                                    <div class="col-md-9">
                                        <div class="form-floating">
                                            <input type="text" class="form-control" id="id" name="id" size="20" placeholder="아이디">
                                            <label for="id">ID</label>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-floating">
                                            <button class="btn btn-primary w-100 py-3" type="button" onclick="confirmId();">중복확인</button>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input type="password" class="form-control" id="password" name="password" size="20" placeholder="비밀번호">
                                            <label for="password">Password</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating">
                                            <input type="password" class="form-control" id="repassword" name="repassword" size="20" placeholder="비밀번호 확인">
                                            <label for="repassword">Repassword</label>
                                        </div>
                                    </div>
                                    
                                    <c:if test="${name != null}">
	                                   	<div class="col-12">
	                                        <div class="form-floating">
	                                            <input type="text" class="form-control" id="name" name="name" size="20" value="${name}">
	                                            <label for="name">Name</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-md-12">
	                                        <div class="form-floating">
	                                            <input type="text" class="form-control" id="addr1" name="zipcode" placeholder="zipcode" readonly="readonly">
	                                            <label for="zipcode">Zipcode</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-12">
	                                        <div class="form-floating">
	                                            <input type="text" class="form-control" id="addr2" name="address" placeholder="address" value="${address1}">
	                                            <label for="address">Address</label>
	                                        </div>
	                                    </div>
	                                    <div class="col-12">
	                                        <div class="form-floating">
	                                            <input type="text" class="form-control" id="address_detail" name="address_detail" value="${address2}">
	                                            <label for="address_detail">Address_detail</label>
	                                        </div>
	                                    </div>
                                    </c:if>
                                    
                                    <c:if test="${name == null}">
											<div class="col-9">
												<div class="form-floating">
													<input type="text" class="form-control" id="name"
														name="name" size="20" placeholder="Your Name"> <label
														for="name">Name</label>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-floating">
													<input type="file" class="form-control" id="file"
														name="file" size="20" accept="image/*" onchange="card();">
													<label for="file">신분증</label>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-floating">
													<input type="text" class="form-control" id="addr1"
														name="zipcode" placeholder="zipcode" readonly="readonly">
													<label for="zipcode">Zipcode</label>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-floating">
													<button class="btn btn-primary w-100 py-3" type="button"
														onclick="execPostCode();">우편번호</button>
												</div>
											</div>

											<div class="col-12">
												<div class="form-floating">
													<input type="text" class="form-control" id="addr2"
														name="address" placeholder="address" readonly="readonly">
													<label for="address">Address</label>
												</div>
											</div>
											<div class="col-12">
												<div class="form-floating">
													<input type="text" class="form-control" id="address_detail"
														name="address_detail" placeholder="address_detail">
													<label for="address_detail">Address_detail</label>
												</div>
											</div>
										</c:if>
                                    
                                    <div class="col-md-4">
                                        <div class="form-floating">
                                            <input type="text" class="form-control" id="hp1" name="hp1" placeholder="" maxlength="3">
                                            <label for="hp1">Phone</label>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-floating">
                                            <input type="text" class="form-control" id="hp2" name="hp2" placeholder="" maxlength="4">
                                            <label for="hp2"></label>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-floating">
                                            <input type="text" class="form-control" id="hp3" name="hp3" placeholder="" maxlength="4">
                                            <label for="hp3"></label>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-floating">
                                            <input type="text" class="form-control" id="email1" name="email1" placeholder="email">
                                            <label for="email1">Email</label>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-floating">
                                            <input type="text" class="form-control" id="email2" name="email2" placeholder="email">
                                            <label for="email2">Email</label>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="optionbox"> 
	                                        <select name="email3" class="py-3" onchange="selectEmailChk();">
										         <option value="0">선택</option>
										         <option value="naver.com">네이버</option>
										         <option value="gmail.com">구글</option>
										         <option value="daum.net">다음</option>
										     </select> 
									     </div>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-primary w-100 py-3" type="submit">회원가입</button>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-primary w-100 py-3" type="reset">초기화</button>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-primary w-100 py-3" type=button onclick="window.history.back();">가입취소</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
</body>

</html>