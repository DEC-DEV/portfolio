<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> KosmosBank </title>

</head>
<body>
	 <%-- <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>

             <div class="container-xxl py-5 hero-header mb-5">
                 <div class="container bg-primary my-5 py-5 px-lg-5">
                    <div class="row g-5 py-5">
                        <div class="col-lg-6 text-center text-lg-start">
                            <h1 class="text-white mb-4 animated zoomIn">펀드 리스트</h1>
                        </div>
                    </div>
                </div > 
            </div >
            <div class="container-xxl py-5">
            <div class="container px-lg-5">
                <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                    <h3 class="position-relative d-inline text-primary ps-4"> fund_list </h3>
                    <a href="https://www.wadiz.kr/web/wreward/main?keyword=&endYn=ALL&order=recommend">참고 사이트[ 와디즈 ] </a>
                </div>
                
                 <div class="row mt-n2 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="col-12 text-center">
                        <ul class="list-inline mb-5" id="portfolio-flters">
                            <li class="btn px-3 pe-4 active" data-filter="*">All</li>
                            <li class="btn px-3 pe-4" data-filter=".cookies">건강</li>
                            <li class="btn px-3 pe-4" data-filter=".painting">테크/가전</li>
                            <li class="btn px-3 pe-4" data-filter=".painting">패션/잡화</li>
                            <li class="btn px-3 pe-4" data-filter=".painting">푸드</li>
                            <li class="btn px-3 pe-4" data-filter=".painting">홈리빙</li>
                        </ul>
                    </div>
                </div>  --%>
                
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
            
        
        <%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
			       
</body>
</html>