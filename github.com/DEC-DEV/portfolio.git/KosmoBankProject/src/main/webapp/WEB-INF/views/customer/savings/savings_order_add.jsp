<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title> 정기적금 설명 </title>
    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${path }/css/sb-admin-2.min.css" rel="stylesheet">
    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${path}/resources/customer/lib/wow/wow.min.js"></script>
    <script src="${path}/resources/customer/lib/easing/easing.min.js"></script>
    <script src="${path}/resources/customer/lib/waypoints/waypoints.min.js"></script>
    <script src="${path}/resources/customer/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${path}/resources/customer/lib/isotope/isotope.pkgd.min.js"></script>
    <script src="${path}/resources/customer/lib/lightbox/js/lightbox.min.js"></script>
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
		let end_date = document.getElementById('i_max_date').value;
		var date = new Date();
		var get_Month = date.getMonth()+1;
		var get_Date = date.getDate();
		var get_Year = date.getFullYear();
		var max_Value;
		var yyyy,mm,d;
		var MMM;
		//입력받은 개월수와 현재의 date값과 더한다
		yyyy = get_Year;
		mm = get_Month + parseInt(end_date);
		dd = get_Date;
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
		$('input[name=i_end_date]').attr('value', max_Value);
	});
	
	$(function(){
		$('#btn_application').click(function(){
			
			let money = $("#i_money").val();
			let base_money = $("#balance").val();
			
			
			if(base_money == "") {
				swal("실패!", "신청 기본금액을 입력해주세요", "error");
				$("balance").focus();
				return false;
			}
			
			if(money == "") {
				swal("실패!","자동 이체 금액을 입력해주세요", "error");
				$("#i_money").focus;
				return false;
			}
			$('#savings_application').submit();
			
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
                            <h2 class="mt-2">적금 가입 신청</h2>
                        </div>
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
                            <form name="savings_application" id="savings_application" action="${path}/savings_application.do" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                              <div class="form-group">
							    <label for="i_name">적금 상품명</label>
							    <input type="text" class="form-control" id="i_name" name="i_name" value="${dto.i_name}" readonly>
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
							      <label for="i_rate">적금 금리</label>
							    <input type="number" class="form-control" id="i_rate" name="i_rate" value="${dto.i_rate}" readonly="readonly">
							  </div>
							  <div class="form-group">
							    <label for="i_type">적금 종류</label>
							   	 <select class="form-control" id="i_type" name="i_type">
							   	 <c:if test="${dto.i_type eq '0'}">
							   	 	<option value="${dto.i_type}"> 단리 </option>
							   	 </c:if>	
							   	 <c:if test="${dto.i_type eq '1'}">
							   	 	<option value="${dto.i_type}"> 복리</option>
							   	 </c:if>	
							   	 </select>
							  </div>
							    <label for="i_method">적금 종류</label>
							   <select class="form-control" id="i_method" name="i_method">
							   	 	<option value="0"> 자유적금 </option>
							   	 	<option value="1"> 정기적금 </option>
							   	 </select>
							  <div class="form-group">
							  <label for="i_money"> 신청 기본 금액</label>
							    <input type="number" class="form-control" id="balance" name="balance">
							  </div>
							   <div class="form-group">
							  <label for="i_money">자동 이체 금액</label>
							    <input type="number" class="form-control" id="i_money" name="i_money">
							  </div>
							  <div class="form-group">
							    <label for="i_auto_date">이체 지정일(일)</label>
							    <input type="text" class="form-control" id="i_auto_date" name="i_auto_date" value="${dto.i_auto_date}" readonly="readonly">
							  </div>
							  <div class="form-group">
							    <label for="i_end_date">만기일</label>
							    <input type="text" class="form-control" id="i_end_date" name="i_end_date" value="" readonly="readonly">
							    <input type="hidden" id="i_max_date" value="${dto.i_max_date}">
							  </div>
							  <div style="text-align:center; padding:20 0 20 0">
							  <button type="button" id="btn_application" name="btn_application" class="btn btn-primary">신청</button>
							  <button type="button" id="btn_cancle" name="btn_cancle" class="btn btn-primary">취소</button>
							  </div>
							  
							  <div class="savings_price">
							  
							  
							  </div>
							</form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact End -->
     <!-- end Page Content -->
     <!-- end Page Content -->
    </div>
    <!-- End of Content Wrapper -->
    <!-- footer 시작 -->
	<%@include file = "/WEB-INF/views/common/customer/footer.jsp" %>
	<!-- footer 끝 -->