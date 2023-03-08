<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> KosmosBank</title>

<script type="text/javascript">
$(function() {
	$('#all').click(function() {
		
		$.ajax({
			url: "${path}/fund_all_list.do?${_csrf.parameterName}=${_csrf.token}",	/* 컨트롤러 이동 : 플젝명/url */
			type: 'post',
			success: function(result) {	/* 콜백함수 - 전송 성공시 결과가 result에 전달된다. */
				$("#category").html(result); // 결과출력
			},
			error: function() {
				alert('오류');
			}
		});
	});
});

$(function() {
	$('#health').click(function() {
		let param = {
			f_category : "건강"
		}
		$.ajax({
			url: "${path}/fund_health_list.do?${_csrf.parameterName}=${_csrf.token}",	/* 컨트롤러 이동 : 플젝명/url */
			type: 'post',
			data: param,
			success: function(result) {	/* 콜백함수 - 전송 성공시 결과가 result에 전달된다. */
				$("#category").html(result); // 결과출력
			},
			error: function() {
				alert('오류');
			}
		});
	});
});

$(function() {
	$('#tech').click(function() {
		let param = {
			f_category : "테크/가전"
		}
		$.ajax({
			url: "${path}/fund_tech_list.do?${_csrf.parameterName}=${_csrf.token}",	/* 컨트롤러 이동 : 플젝명/url */
			type: 'post',
			data: param,
			success: function(result) {	/* 콜백함수 - 전송 성공시 결과가 result에 전달된다. */
				$("#category").html(result); // 결과출력
			},
			error: function() {
				alert('오류');
			}
		});
	});
});

$(function() {
	$('#fashion').click(function() {
		let param = {
			f_category : "패션/잡화"
		}
		$.ajax({
			url: "${path}/fund_fashion_list.do?${_csrf.parameterName}=${_csrf.token}",	/* 컨트롤러 이동 : 플젝명/url */
			type: 'post',
			data: param,
			success: function(result) {	/* 콜백함수 - 전송 성공시 결과가 result에 전달된다. */
				$("#category").html(result); // 결과출력
			},
			error: function() {
				alert('오류');
			}
		});
	});
});

$(function() {
	$('#food').click(function() {
		let param = {
			f_category : "푸드"
		}
		$.ajax({
			url: "${path}/fund_food_list.do?${_csrf.parameterName}=${_csrf.token}",	/* 컨트롤러 이동 : 플젝명/url */
			type: 'post',
			data: param,
			success: function(result) {	/* 콜백함수 - 전송 성공시 결과가 result에 전달된다. */
				$("#category").html(result); // 결과출력
			},
			error: function() {
				alert('오류');
			}
		});
	});
});

$(function() {
	$('#home-living').click(function() {
		let param = {
			f_category : "홈리빙"
		}
		$.ajax({
			url: "${path}/fund_home_list.do?${_csrf.parameterName}=${_csrf.token}",	/* 컨트롤러 이동 : 플젝명/url */
			type: 'post',
			data: param,
			success: function(result) {	/* 콜백함수 - 전송 성공시 결과가 result에 전달된다. */
				$("#category").html(result); // 결과출력
			},
			error: function() {
				alert('오류');
			}
		});
	});
});
</script>
</head>
<body>
	 <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>

             <div class="container-xxl py-5 hero-header mb-5">
                <!-- <div class="container bg-primary my-5 py-5 px-lg-5">
                    <div class="row g-5 py-5">
                        <div class="col-lg-6 text-center text-lg-start">
                            <h1 class="text-white mb-4 animated zoomIn">펀드 리스트</h1>
                        </div>
                    </div>
                </div >  -->
            </div >
            <div class="container-xxl py-5">
            <div class="container px-lg-5">
                <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                	<h6 class="position-relative d-inline text-primary ps-4">kosmosBank</h6>
                    <h3 class="mt-2"> 펀드 목록 </h3>
                    <!-- <a href="https://www.wadiz.kr/web/wreward/main?keyword=&endYn=ALL&order=recommend">참고 사이트[ 와디즈 ] </a> -->
                </div>
                
                 <div class="row mt-n2 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="col-12 text-center">
                        <ul class="list-inline mb-5" id="portfolio-flters">
                            <li class="btn px-3 pe-4 active" data-filter="*" id="all">All</li>
                            <li class="btn px-3 pe-4" id="health">건강</li>
                            <li class="btn px-3 pe-4" data-filter=".painting" id="tech">테크/가전</li>
                            <li class="btn px-3 pe-4" data-filter=".painting" id="fashion">패션/잡화</li>
                            <li class="btn px-3 pe-4" data-filter=".painting" id="food">푸드</li>
                            <li class="btn px-3 pe-4" data-filter=".painting" id="home-living">홈리빙</li>
                        </ul>
                    </div>
                </div> 
                
                <div class="row g-4 portfolio-container" id="category">
                 <c:forEach var="dto" items="${list}">
                    <div class="col-lg-4 col-md-6 portfolio-item cookies wow zoomIn" data-wow-delay="0.3s">
                    	<form method="post">
                        <div class="position-relative rounded overflow-hidden">
                            <img class="img w-100" src="${dto.f_filename}" alt="" height="400px;" width="200px">
                            <div class="portfolio-overlay">
                                <a class="btn btn-light" href="${path }/resources/img/fund/cookie.avif" data-lightbox="portfolio"><i class="fa fa-plus fa-2x text-primary"></i></a>
                                <div class="mt-auto">
                                   <small class="text-white" id="f_category" name="f_category" value="${dto.f_category}"><i class="fa fa-folder me-2" id="f_category"></i>${dto.f_category}</small>
                                    <a class="h5 d-block text-white mt-1 mb-0" href="${path }/fund_detail.do?f_num=${dto.f_num}&pageNum=${paging.pageNum}&f_category=${dto.f_category}">${dto.f_title}</a>
                                </div>
                            </div>
                        </div>
                         </form>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
	</div>		       
</body>
</html>