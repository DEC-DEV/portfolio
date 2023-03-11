<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500&family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="${path }/resources/customer/lib/animate/animate.min.css"
	rel="stylesheet">
<link
	href="${path }/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="${path }/resources/customer/lib/lightbox/css/lightbox.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="${path }/resources/customer/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Template Stylesheet -->
<link href="${path }/resources/customer/css/style.css" rel="stylesheet">
<!-- 날짜 계산시 원하는 형식으로 변환하기 위한 스크립트 -->
<script type="text/javascript">
Date.prototype.format = function (f) {
    if (!this.valueOf()) return " ";
    var weekKorName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var weekKorShortName = ["일", "월", "화", "수", "목", "금", "토"];
    var weekEngName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    var weekEngShortName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    var d = this;
    return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi, function ($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear(); // 년 (4자리)
            case "yy": return (d.getFullYear() % 1000).zf(2); // 년 (2자리)
            case "MM": return (d.getMonth() + 1).zf(2); // 월 (2자리)
            case "dd": return d.getDate().zf(2); // 일 (2자리)
            case "KS": return weekKorShortName[d.getDay()]; // 요일 (짧은 한글)
            case "KL": return weekKorName[d.getDay()]; // 요일 (긴 한글)
            case "ES": return weekEngShortName[d.getDay()]; // 요일 (짧은 영어)
            case "EL": return weekEngName[d.getDay()]; // 요일 (긴 영어)
            case "HH": return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2); // 시간 (12시간 기준, 2자리)
            case "mm": return d.getMinutes().zf(2); // 분 (2자리)
            case "ss": return d.getSeconds().zf(2); // 초 (2자리
            case "a/p": return d.getHours() < 12 ? "오전" : "오후"; // 오전/오후 구분
            default: return $1;
        }
    });
};
String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };
String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };
Number.prototype.zf = function (len) { return this.toString().zf(len); };
</script>
<script type="text/javascript">
	// 대출기간 값 가져오기
	var addingYear;
	$(function(){
		$('#loanPeriod').change(function(){
			//alert(this.value);
			addingYear = Number(this.value) / 12;
			
			/* let date = new Date();
			console.log("date : ", date.format('yyyy-MM-dd'));
			
			let date2 = date.format('yyyy-MM-dd'); // date타입을 다음 형식으로 변환
			let yyyy = Number(date2.substr(0,4)) + addingYear; // date2를 년도 부분만 추출 후 addingYear에 해당하는 값을 더해줌
			let mm = Number(date2.substr(5,2)); // date2를 달만 추출
			let dd = Number(date2.substr(8,2)); // date2를 일만 추출
			console.log("yyyy : ", yyyy); // 2022
			console.log("mm : ", mm); // 4
			console.log("dd : ", dd ); // 21
			console.log("-----"); */
			
		});
	});
	
	var startDate
	$(function(){
		$('#loanActivationDate').change(function(){
			//alert(this.value);
			
			startDate = this.value; // 대출실행일(date)에서 선택한 값을 변수에 초기화 
			console.log("startDate : ", startDate);
			
			let yyyy2 = Number(startDate.substr(0,4)) + addingYear; // startDate의 년도 부분만 추출 후 addingYear에 해당하는 값을 더해줌
			let mm2 = Number(startDate.substr(5,2)); // month만 추출
			let dd2 = Number(startDate.substr(8,2)); // day만 추출
			console.log("yyyy2 : ", yyyy2);
			console.log("mm2 : ", mm2);
			console.log("dd2 : ", dd2 );
			console.log("---------------------");
			
			let expire = yyyy2 + "-" + 0 + mm2 + "-" + dd2; // 분리한 문자열들을 합침
			console.log("expire : ", expire);
			
			$('input[name=loanExpirationDate]').attr('value', expire);
		});
	});
	
	
	
	
	/* var expire = startDate.serFullYear(startDate.getFullYear() + addingYear);
	console.log("expire : ", expire);
	console.log(startDate.getFullYear()); */
	
</script>
<!-- ajax -->
<script type="text/javascript">
	$(function(){
		$("#calc").click(function(){
			calculate();
		});
	});
	function calculate() {
		var param = {
			"loanOriginAmount" : $('#loanOriginAmount').val(),
			"loanPeriod" : $('#loanPeriod').val(),
			"loanInterestRate" : $('#loanInterestRate').val(),
			"returnMethod" : $('#returnMethod').val(),
		};
			$.ajax({
				type: "post",
				url: "${path}/loan_apply_calculate.do?${_csrf.parameterName}=${_csrf.token}",
				data: param,
				success: function(result) {
					$('#calc_result').html(result);
				},
				error: function(){
					alert("상환액 계산 실패!");
				}
			});

// 		$.ajax({
// 			type: "post",
// 			url: "${path}/loan_apply_calculate.do?${_csrf.parameterName}=${_csrf.token}",
// 			data: param,
// 			success: function(result) {
// 				$('#calc_result').html(result);
// 			},
// 			error: function(){
// 				alert("상환액 계산 실패!");
// 			}
// 		});

	}
</script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#send").click(function(){ // 비번 입력 확인 후 비밀번호 체크 메서드
			let password = $("#accountPassword").val();
			
			if(password == "") {
				swal("실패!","계좌 비밀번호를 입력해주세요.", "error");
				$("#accountPassword").focus();
				return false;
			}
			loan_password_check();
		});
	});
	function loan_password_check(){
		var param = {
				"accountPassword" : $('#accountPassword').val(),
				"selectAccount" : $('#selectAccount').val()
			};
		$.ajax({
			type: "post",
			url: "${path}/loan_password_check.do?${_csrf.parameterName}=${_csrf.token}",
			data: param,
			success: function(result) {
				console.log("result : ", result);
				if(result == 'incorrect') {
					swal("실패!","비밀번호가 일치하지 않습니다.", "error");
					return false;
				} else if(result == 'correct') {
					loan_apply_insert();
				}
			},
			error: function(){
				swal("","뭔가가 잘못됐어", "warning");
			}
		});
	}
	function loan_apply_insert() { // 비밀번호 일치시 대출정보 insert 하는 메서드
		swal("대출신청이 완료되었습니다!","마이페이지에서 확인해주세요.", "success");
		
		$('#form1').submit();
		// 버튼 id 달라야함
		/* let myForm = document.getElementById("form1");
		myForm.action="${path}/loan_apply_insert.do?${_csrf.parameterName}=${_csrf.token}"; */
	}
</script>
</head>
<body>
	<div class="container-xxl bg-white p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-grow text-primary"
				style="width: 3rem; height: 3rem;" role="status">
				<span class="sr-only">Loading...</span>
			</div>
		</div>
		<!-- Spinner End -->


		<!-- header 시작 -->
		<%@ include file="/WEB-INF/views/common/customer/header.jsp"%>
		<!-- header 끝 -->

		<!-- Navbar & Hero Start -->
		<div class="container-xxl position-relative p-0">
			<%@ include file="/WEB-INF/views/common/customer/header.jsp"%>
			<!-- header에 container 색이 들어가지 않도록 class name 수정 container-xxl bg-primary py-5 hero-header mb-5 에서 container-xxl py-5 hero-header mb-5 [ung] -->
		</div>
		<!-- Navbar & Hero End -->

		<!-- Full Screen Search Start -->
		<div class="modal fade" id="searchModal" tabindex="-1">
			<div class="modal-dialog modal-fullscreen">
				<div class="modal-content"
					style="background: rgba(29, 29, 39, 0.7);">
					<div class="modal-header border-0">
						<button type="button" class="btn bg-white btn-close"
							data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div
						class="modal-body d-flex align-items-center justify-content-center">
						<div class="input-group" style="max-width: 600px;">
							<input type="text"
								class="form-control bg-transparent border-light p-3"
								placeholder="Type search keyword">
							<button class="btn btn-light px-4">
								<i class="bi bi-search"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Full Screen Search End -->


		<!-- Contact Start -->
		<div class="container-xxl py-5">
			<div class="container px-lg-5">
				<div class="row justify-content-center">
					<div class="col-lg-7" style="padding-top: 80">
						<div
							class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp"
							data-wow-delay="0.1s">
							<h6 class="position-relative d-inline text-primary ps-4">KosmosBank</h6>
							<h2 class="mt-2">${product_dto.d_name}</h2>
						</div>
						<div class="wow fadeInUp" data-wow-delay="0.3s">
							<form action="${path}/loan_apply_insert.do" name="form1" id="form1" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								<div class="row g-3">
										<div class="col-12">
											<div class="form-group">
												<label for="productName">대출 상품명</label> <input type="text"
													class="form-control" id="productName" name="productName" value="${product_dto.d_name}"
													readonly>
											</div>
										</div>
										<div class="col-12">
											<div class="form-group">
												<label for="customerId">아이디</label> <input type="text"
													class="form-control" id="customerId" name="customerId" value="${account_list[0].id}"
													readonly>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="customerName">이름</label> <input type="text"
													class="form-control" id="customerName" name="customerName" value="${account_list[0].name}" readonly>
											</div>
										</div>


										<div class="col-12">
											<div class="form-group">
												<label for="selectAccount">계좌선택</label> <select
													class="form-control" id="selectAccount" name="selectAccount"
													style="background-color: white">
													<c:forEach var="account" items="${account_list}">
														<option>${account.account_num}</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="accountPassword">계좌 비밀번호</label> <input
													type="password" class="form-control" id="accountPassword" name="accountPassword" maxlength="4">
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="loanPeriod">대출기간(년)</label> <select
													class="form-control" id="loanPeriod" name="loanPeriod"
													style="background-color: white">
													<option value="">선택하세요</option>
													<option value="12">12개월(1년)</option>
													<option value="24">24개월(2년)</option>
													<option value="36">36개월(3년)</option>
													<option value="48">48개월(4년)</option>
													<option value="60">60개월(5년)</option>
												</select>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="loanActivationDate">대출 실행일</label> <input
													type="date" class="form-control" id="loanActivationDate" name="loanActivationDate"
													onchange="loanActivationDate">
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="loanExpirationDate">대출 만기일</label> <input
													type="text" class="form-control" id="loanExpirationDate" 
													name="loanExpirationDate" value="" readonly>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="returnMethod">상환 방법</label> <input
													type="text" class="form-control" id="returnMethod" name="returnMethod"
													value="${product_dto.d_repay}" readonly>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="loanOriginAmount">대출원금</label> <input
													type="number" class="form-control" id="loanOriginAmount" name="loanOriginAmount"
													placeholder="원 단위로 입력 하세요.">
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="loanInterestRate">대출금리(%)</label> <input
													type="number" class="form-control" id="loanInterestRate" name="loanInterestRate"
													value="${product_dto.d_interest_rate}" step="any" readonly />
													
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="redemptionRate">중도상환수수료율</label> <input
													type="number" class="form-control" id="redemptionRate" name="redemptionRate"
													value="${product_dto.d_prepayment_fee}" step="0.01" readonly />
											</div>
										</div>

										<div class="col-12">
											<div style="text-align: center; padding: 20 0 20 0">
												<button type="button" class="btn btn-primary"
												name="calc" id="calc">상환액 계산</button>
											</div>
										</div>
									<div id="calc_result">
										please click "상환액 계산"
									</div>
									

									<div style="text-align: center; padding: 40 0 10 0">
										<button type="button" class="btn btn-primary" id="send">신청하기</button>
										<button type="button" class="btn btn-primary" id="reset">초기화</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Contact End -->


		<!-- Footer Start -->
		<%@ include file="/WEB-INF/views/common/customer/footer.jsp"%>
		<!-- Footer End -->


		<!-- Back to Top -->
		<a href="#"
			class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i
			class="bi bi-arrow-up"></i></a>
	</div>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="${path }/resources/customer/lib/wow/wow.min.js"></script>
	<script src="${path }/resources/customer/lib/easing/easing.min.js"></script>
	<script
		src="${path }/resources/customer/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${path }/resources/customer/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${path }/resources/customer/lib/isotope/isotope.pkgd.min.js"></script>
	<script
		src="${path }/resources/customer/lib/lightbox/js/lightbox.min.js"></script>

	<!-- Template Javascript -->
	<script src="${path }/resources/customer/js/main.js"></script>
</body>

</html>