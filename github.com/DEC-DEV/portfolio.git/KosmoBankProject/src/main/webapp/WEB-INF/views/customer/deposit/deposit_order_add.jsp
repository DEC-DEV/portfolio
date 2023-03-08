<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %> 
<c:set var="now" value="<%=new java.util.Date() %>" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title> 정기예금 설명 </title>
    <!-- Custom fonts for this template-->
    <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">
        <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${path}/resources/customer/lib/wow/wow.min.js"></script>
    <script src="${path}/resources/customer/lib/easing/easing.min.js"></script>
    <script src="${path}/resources/customer/lib/waypoints/waypoints.min.js"></script>
    <script src="${path}/resources/customer/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${path}/resources/customer/lib/isotope/isotope.pkgd.min.js"></script>
    <script src="${path}/resources/customer/lib/lightbox/js/lightbox.min.js"></script>
	<script src="https://unpkg.com/dayjs@1.8.21/dayjs.min.js"></script>
    <!-- Template Javascript -->
    <script src="${path}/resources/customer/js/main.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	/* 날짜 데이터 포맷  */
	function dateFormat(date) {
	    let month = date.getMonth() + 1;
	    let day = date.getDate();
	    let hour = date.getHours();
	    let minute = date.getMinutes();
	    let second = date.getSeconds();
	
	    month = month >= 10 ? month : '0' + month;
	    day = day >= 10 ? day : '0' + day;
	    hour = hour >= 10 ? hour : '0' + hour;
	    minute = minute >= 10 ? minute : '0' + minute;
	    second = second >= 10 ? second : '0' + second;
	
	    return date.getFullYear() + '-' + month + '-' + day + ' ';
	}   

	/* JQUERY 사용 */
	$(document).ready(function() {
		let end_date = document.getElementById('y_end_date').value;
		var date = new Date();
		var get_Month = date.getMonth()+1;
		/* var get_Date = date.getDay(); */
		var get_Year = date.getFullYear();
		var max_Value;
		var yyyy,mm,d;
		var MMM;
		//입력받은 개월수와 현재의 date값과 더한다
		yyyy = get_Year;
		mm = get_Month + parseInt(end_date);
		dd = date.getDate();
		if(mm > 12){
			MMM = Math.round(mm / 12);
			mm = mm % 12;
			yyyy = yyyy + MMM;
		}
		max_Value = yyyy+'-'+mm+'-'+dd;
		/* date.setMonth(end_date + (get_Month+1)); */
		console.log("yyyy : " , yyyy);
		console.log("mm : " , mm);
		console.log("dd : ", dd);
		console.log("MMM : ", MMM);
		console.log("end_date : " , end_date);
		
		console.log("max_Value : ", max_Value);
		//계산된 값을 form에 input
		$('input[name=y_end_date]').attr('value', max_Value);
	});
	
	$(function(){
		$('#btn_application').click(function(){
			let balance = $("#y_balance").val();
			if(balance == "") {
				swal("실패!","예치 금액을 입력해주세요", "error");
				$("#y_balance").focus;
				return false;
			}
			$('#deposit_application').submit(); 
		});
		
		$("#btn_cancle").click(function(){
			window.history.back();
		});
	});
</script>    
<body>
	<!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/customer/header.jsp" %>
	<!-- header 끝 -->
	<!-- Page Wrapper -->
    <div id="wrapper" style="margin-top: 50px;">

     <!-- Begin Page Content -->
      <div class="container-xxl py-5">
            <div class="container px-lg-5">
                <div class="row justify-content-center">
                    <div class="col-lg-7" style="padding-top:80">
                        <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="position-relative d-inline text-primary ps-4">Kosmos Bank</h6>
                            <h2 class="mt-2">예금 가입 신청</h2>
                        </div>
                        
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
                            <form name="deposit_application" id="deposit_application" action="${path}/deposit_application.do" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                              <div class="form-group">
							    <label for="y_name">예금 상품명</label>
							    <input type="text" class="form-control" id="y_name" name="y_name" value="${dto.y_name}" readonly>
							  </div>
							 
                              <div class="form-group">
							    <label for="selectAccount">조회계좌</label>
							    <select class="form-control" id="account_num" name="account_num" style="background-color:white">
							       <c:forEach items="${list}" var="dto">
							      	<option value="${dto.account_num}">${dto.account_num}</option>
							       </c:forEach>
							    </select>
							  </div>
							  
							  <div class="form-group">
							      <label for="y_type">예금 금리</label>
							    <input type="number" class="form-control" id="y_interest_rate" name="y_interest_rate" value="${dto.y_interest_rate}">
							  </div>
							  <div class="form-group">
							    <label for="y_type">예금 종류</label>
							   	 <select class="form-control" id="y_type" name="y_type">
									<c:if test="${dto.y_type eq '0' }">				   	 
							   	 	<option value="${dto.y_type}"> 보통 </option>
							   	 	</c:if>	
							  	 	<c:if test="${dto.y_type eq '1' }">							
							   	 	<option value="${dto.y_type}"> 저축</option>
							   	 	</c:if>	
							   	 </select>
							  </div>
							  <div class="form-group">
							    <label for="balance">예치 금액(원)</label>
							    <input type="number" class="form-control" id="y_balance" name="y_balance">
							  </div>
							  <div class="form-group">
							    <label for="y_end_date">만기일</label>
							    <input type="text" class="form-control" id="y_end_date" name="y_end_date" value="${dto.y_end_date}" readonly="readonly">
							  </div>
							  <div style="text-align:center; padding:20 0 20 0">
							  <button type="button" id="btn_application" name="btn_application" class="btn btn-primary">신청</button>
							  <button type="button" id="btn_cancle" name="btn_cancle" class="btn btn-primary">취소</button>
							  </div>
							</form>
							
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact End -->
     <!-- end Page Content -->
    </div>
    <!-- End of Content Wrapper -->
    <!-- footer 시작 -->
	<%@include file = "/WEB-INF/views/common/customer/footer.jsp" %>
	<!-- footer 끝 -->