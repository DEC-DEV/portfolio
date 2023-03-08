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
    <link href="${path }/resources/customer/img/favicon.ico" rel="icon">
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500&family=Roboto:wght@400;500;700&display=swap"
        rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap"
        rel="stylesheet">
    <!-- noto sans 폰트 추가 -->

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <style>
        .nav-link {
            color: #000;
        }
    </style>
</head>

<body>
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner"
            class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar & Hero Start -->
        <div class="container-xxl position-relative p-0">
         <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>

            <!-- main start -->
            <div class="hero-header mb-5">
                <div class="container py-5 px-lg-5"
                    style="max-width: inherit;background:#ffef6b; padding-top: 4rem !important;padding-bottom: 4rem !important;">
                    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"
                                class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="container-sm d-flex align-items-center g-5"
                                    style="padding-left: 0; padding-right: 0;">
                                    <div class="col-lg-6 text-lg-start">
                                        <h1 class="fw-bold animated fadeInUp"
                                            style="font-family: 'Noto Sans KR', sans-serif;font-size: 3.8rem;letter-spacing: -4px;">
                                            KOSMOS 뱅크
                                        </h1>
                                        <p class="animated fadeInDown"
                                            style="padding-top:10px;color:#666;font-size: 1.1rem;letter-spacing: -1px;">
                                            한 사람, 한 사람을 위해 시작한 은행이<br>더 많은 사람들이 찾는 모두의 은행이 되었습니다
                                        </p>

                                        <a href="${path }/account_add.do" class="btn btn-primary w-30 animated fadeInDown"
                                            style="background: #0082cd;border-color: #0082cd;font-family: 'Noto Sans KR', sans-serif;font-size: 14px;border-radius: 50px;padding: 10px 16px;margin-top: 40px;">
                                            계좌 생성 하기 </a>
                                    </div>
                                    <div class="col-lg-6 text-center" style="background:#ffef6b">
                                        <img class="img-fluid" src="${path }/resources/img/main-bg3.jpg" alt="" style="width:70%;">
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container-sm d-flex align-items-center g-5"
                                    style="padding-left: 0; padding-right: 0;">
                                    <div class="col-lg-6 text-lg-start">
                                        <h1 class="fw-bold animated fadeInUp"
                                            style="font-family: 'Noto Sans KR', sans-serif;font-size: 3.8rem;letter-spacing: -4px;">
                                            네이버웹툰 재혼 황후 디퓨저, 나비에와 하인리의 향기
                                        </h1>
                                        <p class="animated fadeInDown"
                                            style="padding-top:10px;color:#666;font-size: 1.1rem;letter-spacing: -1px;">
                                            웹소설에서 웹툰까지 시리즈 누적 조회수 1억에 빛나는 걸작!  많은 분들의 머리와 가슴을 뜨겁게 만든 로맨스 판타지 <재혼 황후> 의 두 주인공, 나비에와 하인리를 표현한 향기로운 디퓨저로 찾아왔습니다.
                                        </p>

                                        <a href="#" class="btn btn-primary w-30 animated fadeInDown"
                                            style="background: #0082cd;border-color: #0082cd;font-family: 'Noto Sans KR', sans-serif;font-size: 14px;border-radius: 50px;padding: 10px 16px;margin-top: 40px;">
                                            펀드신청하기 </a>
                                    </div>
                                    <div class="col-lg-6 text-center" style="background:#ffef6b">
                                        <img class="img-fluid" src="${path }/resources/img/fund/fashion1.webp" alt="" style="width:70%;">
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container-sm d-flex align-items-center g-5"
                                    style="padding-left: 0; padding-right: 0;">
                                    <div class="col-lg-6 text-lg-start">
                                        <h1 class="fw-bold animated fadeInUp"
                                            style="font-family: 'Noto Sans KR', sans-serif;font-size: 3.8rem;letter-spacing: -4px;">
                                             KOSMO 전세금안심 대출
                                        </h1>
                                        <p class="animated fadeInDown"
                                            style="padding-top:10px;color:#666;font-size: 1.1rem;letter-spacing: -1px;">
                                           주택도시보증공사의 전세자금대출특약보증과 전세보증금반환보증의 결합상품으로 보증서를 
                                           담보로 전세대출 지원하고 반환보증을 통해 임대차계약 만료 시 전세보증금을 안전하게 반환하여 대출금을 상환할 수 있습니다
                                        </p>
                                    		<a href="#" class="btn btn-primary w-30 animated fadeInDown"
                                            style="background: #0082cd;border-color: #0082cd; font-family: 'Noto Sans KR', sans-serif;font-size: 14px;border-radius: 50px;padding: 10px 16px;margin-top: 40px;">
                                          	  대출 신청하기 </a>
										</div>
                                       <div class="col-lg-6 text-center" style="background:#ffef6b">
                                         <img class="img" src="${path }/resources/img/loans/loans_main.png" alt="" style="height: 346px">
                                       </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                            data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                            data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
			 <%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        </div>

        <!-- Navbar & Hero End -->


        <!-- Full Screen Search Start -->
        <div class="modal fade" id="searchModal" tabindex="-1">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" style="background: rgba(29, 29, 39, 0.7);">
                    <div class="modal-header border-0">
                        <button type="button" class="btn bg-white btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center justify-content-center">
                        <div class="input-group" style="max-width: 600px;">
                            <input type="text" class="form-control bg-transparent border-light p-3"
                                placeholder="Type search keyword">
                            <button class="btn btn-light px-4"><i class="bi bi-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  
    </div>
</body>

</html>