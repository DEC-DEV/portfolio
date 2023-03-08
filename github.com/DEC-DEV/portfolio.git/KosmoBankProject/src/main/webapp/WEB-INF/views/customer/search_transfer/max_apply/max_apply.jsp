<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmosBank - 한도변경 </title>
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
     th {
  	color: #333;
  	}
  th,td {
  padding-bottom: 15px;
  }
   </style>

 <script>
 
 // 한도조회 버튼 클릭시
 $(function(){
	$("#btnLimit").click(function(){
		select_limit();
	});
 });
 
 
 
// 선택 계좌의 한도를 불러와라  
  function select_limit() {
	 var value = $("#accountList option:selected").val();

    $.ajax({
       type: "POST",
       url: "${path}/max_apply_call.do?${_csrf.parameterName}=${_csrf.token}",
       data: "account_num=" + value,
       success: function(result) {
          $('#limit').html(result);
       },
       error: function(error) {
          alert('select_limit - 오류');
       }
      
    });
   
    document.getElementById('account').value = value;
 }
 
 // 한도오바됬슈
 $(function(){
	$("#btnApply").click(function(){
		 if ( Number($("#number").val()) > Number(document.getElementById("limit2").value/ 10)) {
			 swal('\n신청한도 초과 입니다 ! \n\n최대 현재 한도금액의 10%  까지 추가신청 가능합니다. ',{
				 icon: "error"
			 });
		// 비번체크 컨트롤러	
		 } else {
			 document.mainform.action="${path}/max_apply_ck.do?${_csrf.parameterName}=${_csrf.token}";
			 document.mainform.submit();
		 }
		 console.log('한도:',document.getElementById('limit2').value/10);
	});
 });
 
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

		<!-- 메인 컨텐츠 시작 -->
          <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
              <h6 class="position-relative d-inline text-primary ps-4"> KosmosBank</h6>
              <h2 class="mt-2"> 한도변경 </h2>
              	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
          </div>
		<div id="title2">계좌정보선택</div>
		<hr id="hr" width="80%" />
	 
		<table id="table" align="center" width="50%">
			<tr>
				<th width="300px">계좌번호</th>
				<td style="display:flex;">
					<select name="accountList" id="accountList" class="form-select">
					  <c:forEach var="item" items="${list}">
				    	 <option value="${item.account_num }">
				    	      ${item.account_num }
				    	 </option>
				      </c:forEach>
				    </select>  
				    <input type="button" value="한도조회" id="btnLimit"  class="btn" style="background:#fce08b;color:#333;margin-left:10px;">
				</td>
			</tr>
		</table>
		
		<!-- 한도를 출력할 영역 -->
    	 <div id="limit"></div>
  
		<div id="title2">이체한도 변경</div>
		<hr id="hr" width="80%" />
		<form  method="post" name="mainform">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<table align="center" width="50%">
				<tr>
					<th width="300px">계좌번호</th>
					<td>
						<!-- getElementById -->
				    	<input id="account" name="account_num" class="form-control" value="" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th width="300px">신청한도</th>
					<td><input type="number" id="number" class="form-control" name="number" value=""  placeholder="금액 입력"></td>
				</tr>
				<tr>
					<th width="300px">계좌 비밀번호</th>
					<td><input type="password" name="account_password" class="form-control" placeholder="비밀번호" maxlength="4"></td>
				</tr>
			</table>
			
			<div align="center">
			<!-- 쿼리먼저 타게끔 뭐였찡? -->
				<input type="button" value="신청하기 " id="btnApply" class="btn fw-bold" style="background:#d3dbf1;color:#0b7bed;">
				<input type="reset" value="취소" class="btn fw-bold" style="background:#ecd8d6;color:#e90101;">
			</div>
	    </form>
		</div><br><br><br><br><br><br><br><br><br><br>
		
		<!-- 메인 컨텐츠 끝 -->
		
 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
</body>

</html>