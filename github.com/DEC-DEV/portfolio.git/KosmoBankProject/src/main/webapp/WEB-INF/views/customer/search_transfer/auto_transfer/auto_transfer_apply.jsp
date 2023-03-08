<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmosBank </title>
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
    <link href="${path}/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path}/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path}/resources/customer/css/bootstrap.min.css" rel="stylesheet">
    <!-- Template Stylesheet -->
    <link href="${path}/resources/customer/css/style.css" rel="stylesheet">
    <!-- select Stylesheet -->
    <link href="${path}/resources/customer/css/join.css" rel="stylesheet">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <style>
    #header{
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
<script>
	$(function() {
		$("#btn_add").click(function(){
			
			let out_date = $("#jd_out_date").val();
			let regist_date = $("#jd_regist_date").val();
			let end_date = $("#jd_end_date").val();
			let auto_money = $("#jd_auto_money").val();
			let bank_name = $("#jd_bank_name").val();
			let account = $("#jd_account").val();
			
			if(out_date == "") {
				swal("실패!","이체 지정일을 선택해주세요.", "error");
				$("#jd_out_date").focus();
				return false;
			}
			
			if(regist_date == "") {
				swal("실패!","이체 시작일을 선택해주세요.", "error");
				$("#jd_regist_date").focus();
				return false;
			}
			
			if(end_date == "") {
				swal("실패!","이체 종료일을 선택해주세요.", "error");
				$("#jd_end_date").focus();
				return false;
			}
			
			if(auto_money == "") {
				swal("실패!","이체 금액을 입력해주세요.", "error");
				$("#jd_auto_money").focus();
				return false;
			}
			
			if(bank_name == "") {
				swal("실패!","이체 은행을 입력해주세요.", "error");
				$("#jd_bank_name").focus();
				return false;
			}
			
			if(account == "") {
				swal("실패!","이체 계좌번호를 선택해주세요.", "error");
				$("#jd_account").focus();
				return false;
			}
			
			document.auto_transfer.submit();
		});
		
		$("#btn_cancle").click(function(){
			window.history.back();
		});
	});
</script>
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
		<div class="container-xxl py-5">
           <div class="container px-lg-5">
               <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
                   <h6 class="position-relative d-inline text-primary ps-4"> KosmosBank</h6>
                   <h2 class="mt-2"> 자동이체신청 </h2>
                   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
               </div>
       	</div>
       </div>  
		<div id="title2">약정정보입력</div>
		<hr id="hr" width="80%" />
		<form name="auto_transfer" id="auto_transfer" action="${path}/auto_transfer_add.do" method="post">		
			<input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}">
			<table id="table" align="center" width="50%">
			<tr>
				<th>약정구분</th>
				<td><input type="radio" name="jd_type" id="jd_type" value="0" checked > 약정
					<input type="radio" name="jd_type" id="jd_type" value="1"> 정정
				</td>
			</tr>
			<tr>
				<th width="300px">출금계좌</th>
				<td>
					<select name="account_num" id="account_num" class="form-control">
					<c:forEach items="${list}" var="dto">
				      <option value="${dto.account_num}">${dto.account_num}</option>
				    </c:forEach>
				    </select> 
				</td>
			</tr>
			<tr>
				<th width="300px">이체지정일</th>
				<td>
					<input type="date" name="jd_out_date" id="jd_out_date" class="form-control">
				</td>
			</tr>
			<tr>
				<th width="300px" >이체시작일</th>
				<td><input type="date" width="150px" name="jd_regist_date" id="jd_regist_date" class="form-control"></td>
			</tr>
			<tr>
				<th width="300px" >이체종료일</th>
				<td><input type="date" width="200px" name="jd_end_date" id="jd_end_date" class="form-control"></td>
			</tr>
			<tr>
				<th width="300px" >이체금액</th>
				<td><input type="number" placeholder="이체금액 입력" name="jd_auto_money" id="jd_auto_money" class="form-control"></td>
			</tr>
			<tr>
				<th width="300px" >이체은행</th>
				<td><input type="text" placeholder="이체 은행 입력" name="jd_bank_name" id="jd_bank_name" class="form-control"></td>
			</tr>
			<tr>
				<th width="300px" >입금계좌번호</th>
				<td><input type="text" placeholder="계좌번호 입력" name="jd_account" id="jd_account" class="form-control"></td>
			</tr>
		
			</table>
		</form>	
		<br><br><br>
		<div align="center">
			<button type="button" class="btn-lg btn-primary" id="btn_add">신청하기</button>
			<button type="button" class="btn-lg btn-primary" id="btn_cancle">취소하기</button>
		</div><br><br><br><br><br><br><br><br><br><br>
		<!-- 메인 컨텐츠 끝 -->
		
 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
   </div>
</body>

</html>