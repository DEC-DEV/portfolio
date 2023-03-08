<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmosBank - 자동이체 문자서비스</title>
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
    <link href="customerlib/animate/animate.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path }/resources/customer/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${path }/resources/customer/css/style.css" rel="stylesheet">
    
    <!-- select Stylesheet -->
    <link href="${path }/resources/customer/css/join.css" rel="stylesheet">
    <style>
    #header{
    background-color: #4e73df;
    float: left;
    width: 100%;
    height: 200px;
    
    }
    
    #title{
    color: white;
    margin-left:50px;
    vertical-align: middle;
    font-size: 35;
    }
    
    #title2{
    margin-left:120px;
    font-size: 20px;
    color:black;
    
    
    }
    
    #hr{
     margin-left:120px;
     size:"2";  
     color:"gray";   
     noshade;  
    }
    
  
    </style>
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
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
        <!-- Navbar & Hero End -->


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
        
       	<!-- UserLoginFailureHandler 에서 msg 넘김 -->
		<c:if test="${errorMsg != null}">
			<script type="text/javascript">
				alert("${errorMsg}");
			</script>
		</c:if>

		<!-- 메인 컨텐츠 시작 -->
		<div id="header"><br><br><br>
			<div id="title">자동이체 문자서비스</div>
		</div>
		<br><br><br><br><br><br><br><br><br><br>
		<div id="title2">자동이체 내역 SMS 통지서비스 신청/해지</div>
		<hr id="hr" width="80%" />
		<table id="table" align="center" width="50%">
			<tr>
				<th width="300px">서비스 받을 계좌번호</th>
				<td>
					<select name="accountList">
				      <option value="account1">332-383-985843</option>
				      <option value="account2">493-238-149484</option>
				    </select> 
				</td>
			</tr>
			<tr>
				<th width="300px">통지휴대폰</th>
				<td>
					010-3333-4444
				</td>
			</tr>
			<tr>
				<th width="300px">요금제</th>
				<td>
					정액제 월 1000원 (1000원미만 건당 20원)			
				</td>
			</tr>
			<tr>
				<th width="300px">수수료 결제 계좌</th>
				<td>
				<select name="accountList2">
				      <option value="account1">332-383-985843</option>
				      <option value="account2">493-238-149484</option>
				</select> 
				</td>
			</tr>
			<tr>
				<th width="300px">신청일</th>
				<td>2022-04-17 14:51:44</td>
			</tr>
			<br><br><br>
			<tr align="center">
				<td colspan="2">
				<input type="checkbox" name="agreement">  
				개인정보 수집 이용 동의(필수)
				<input type="button" value="약관 읽기">
				</td>
			</tr>
			
		</table>
			
		
		<br><br><br>
		<div align="center">
			<button type="submit">신청하기</button>
			<button type="submit">취소</button>
		</div><br><br><br><br><br><br><br><br><br><br>
                                  
		
		
		
		
		
		
		<!-- 메인 컨텐츠 끝 -->
		
 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
</body>

</html>