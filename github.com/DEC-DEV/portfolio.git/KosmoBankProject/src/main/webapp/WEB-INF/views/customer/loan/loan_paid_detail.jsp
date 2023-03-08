<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html lang="en">
<!-- 김현우 -->
<head>
<meta charset="utf-8">
<title>대출 상환 페이지</title>
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

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#send").click(function(){ // 비번 입력 확인 후 비밀번호 체크 메서드
			let password = $("#accountPassword").val();
			
			if(password == "") {
				swal("이봐요!","계좌 비밀번호를 입력해주세요.", "error");
				$("#accountPassword").focus();
				return false;
			}
			loan_password_check();
		});
	});
	function loan_password_check(){
		var param = {
				"accountPassword" : $('#accountPassword').val(),
				"selectAccount" : $('#account_num').val()
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
							<h6 class="position-relative d-inline text-primary ps-4">Kosmos
								Bank</h6>
							<h2 class="mt-2">${d_name} ${d_count}회차 납부</h2>
						</div>
						<div class="wow fadeInUp" data-wow-delay="0.3s">
							<form action="${path}/loan_paid.do" name="form1" id="form1" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<input type="hidden" name="d_repay" id="d_repay" value="${d_repay}">
							<input type="hidden" name="d_count" id="d_count" value="${d_count}">
								<div class="row g-3">
								
										<div class="col-12">
											<div class="form-group">
												<label for="d_num">대출 번호</label> <input type="number"
													class="form-control" id="d_num" name="d_num" value="${d_num}"
													readonly>
											</div>
										</div>
										
										<div class="col-12">
											<div class="form-group">
												<label for="d_name">대출 상품명</label> <input type="text"
													class="form-control" id="d_name" name="d_name" value="${d_name}"
													readonly>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="account_num">출금계좌선택</label> <select
													class="form-control" id="account_num" name="account_num"
													style="background-color: white">
													<c:forEach var="account" items="${dto}">
														<option>${account.account_num}</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="accountPassword">계좌 비밀번호</label> <input
													type="password" class="form-control" id="accountPassword" name="accountPassword">
											</div>
										</div>

										<div style="width: 25%" class="form-check form-check-inline">
											<label for="OriginalAmount" style="padding-left: 25">${d_count}차
												납입원금</label> <input type="number" class="form-control"
												id="OriginalAmount" name="OriginalAmount" value="${originRepay}" readonly>
										</div>
										+
										<div style="width: 25%" class="form-check form-check-inline">
											<label for="Interest" style="padding-left: 25">${d_count}차 납입이자</label>
											<input type="number" class="form-control" id="Interest"
												name="Interest" value="${interestRepay}" readonly>
										</div>
										=
										<div style="width: 25%" class="form-check form-check-inline">
											<label for="returnAmount" style="padding-left: 25">${d_count}차
												총 상환액</label> <input type="number" class="form-control"
												name="returnAmount" id="returnAmount" value="${totalRepay}" readonly>
										</div>
										
										<div class="col-12">
											<div class="form-group">
												<label for="remaining">납부 후 남은 대출금</label> <input
													type="number" class="form-control" id="remaining" name="remaining"
													value="${remainAmount}" readonly>
											</div>
										</div>

										<div class="col-12">
											<div class="form-group">
												<label for="loanActivationDate">${d_count}차 납부 기준일</label> <input
													type="text" class="form-control" id="loanActivationDate" name="loanActivationDate"
													value="${returnDate}" readonly>
											</div>
										</div>
										
									<div style="text-align: center; padding: 40 0 10 0">
										<button type="button" class="btn btn-primary" id="send">상환하기</button>
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