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
    <link href="${path }/resources/customer/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path }/resources/customer/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${path }/resources/customer/css/style.css" rel="stylesheet">
    <link href="${path }/resources/customer/css/sb-admin-2.css" rel="stylesheet">
    <link href="${path }/resources/customer/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/css/table.css" rel="stylesheet">
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

            <div class="container-xxl py-5 bg-primary hero-header mb-5">
                <div class="container my-5 py-5 px-lg-5">
                    <div class="row g-5 py-5">
                        <div class="col-lg-6 text-center text-lg-start">
                            <h1 class="text-white mb-4 animated zoomIn">????????????</h1>
                            <p class="text-white pb-3 animated zoomIn">????????????????????????</p>
                        </div>
                        <div class="col-lg-6 text-center text-lg-start">
                            <img class="img-fluid" src="${path }/resources/customer/img/hero.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
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

		<!-- ??????????????? ?????? -->
		<div class="card shadow mb-4" style="padding-left:500; padding-right:500">
                        <div class="card-header py-3">
                            <span><strong style="color:blue">?????? ?????? ??????</strong></span> <!-- 5?????? ????????? el????????? ???????????? count??? ????????? -->
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table-bordered" id="dataTable">
                                    <tr>
                                    	<td>???????????????</td>
                                    	<td><input type="text" value="??????????????????" readonly></td>
                                    </tr>
                                    <tr>
                                    	<td>?????????</td>
                                    	<td><input type="text" value="guest" readonly></td>
                                    </tr>
                                    <tr>
                                    	<td>??????</td>
                                    	<td><input type="text" value="?????????" readonly></td>
                                    </tr>
                                    <tr>
                                    	<td>??????</td>
                                    	<td>
                                    		<select>
                                    			<option value="??????">????????????</option>
                                    			<option value="000-000-000">000-000-000</option>
                                    			<option value="001-001-001">001-001-001</option>
                                    			<option value="001-002-002">001-002-002</option>
                                    		</select>
                                    	</td>
                                    </tr>
                                    <tr>
                                    	<td>??????????????????</td>
                                    	<td><input type="password"></td>
                                    </tr>
                                    <tr>
                                    	<td>????????????</td>
                                    	<td>
                                    		<select>
                                    			<option value="??????">????????????</option>
                                    			<option value="12??????">12??????</option>
                                    			<option value="24??????">24??????</option>
                                    			<option value="36??????">36??????</option>
                                    		</select>
                                    	</td>
                                    </tr>
                                    <tr>
                                    	<td>???????????????</td>
                                    	<td><input type="date"></td>
                                    </tr>
                                    <tr>
                                    	<td>???????????????</td>
                                    	<td>2230.12.31</td>	<!-- ??????????????? ????????? ?????? ???????????? ???????????? ?????? ?????? -->
                                    </tr>
                                    <tr>
                                    	<td>????????????</td>
                                    	<td>
                                    		<select>
                                    			<option value="??????">????????????</option>
                                    			<option value="??????????????????">??????????????????</option>
                                    			<option value="?????????????????????">?????????????????????</option>
                                    			<option value="??????????????????">36??????????????????</option>
                                    		</select>
                                    	</td>
                                    </tr>
                                    <tr>
                                    	<td>????????????</td>
                                    	<td><input type="number" placeholder="??? ????????? ?????? ?????????."></td>
                                    </tr>
                                    <tr>
                                    	<td>????????????</td>
                                    	<td><input type="number" value="4.5" readonly></td>
                                    </tr>
                                    <tr>
                                    	<td>????????????????????????</td>
                                    	<td><input type="number" value="0.7" readonly></td>
                                    </tr>
                                    <tr>
                                    	<td colspan="2" style="text-align:center"><input type="button" class="btn btn-secondary btn-icon-split" value="????????? ??????"></td>
                                    </tr>
                                    <tr>
                                    	<td>??? ??????</td>
                                    	<td><input type="number" value="1712000" readonly></td>
                                    </tr>
                                    <tr>
                                    	<td>??? ????????????</td>
                                    	<td><input type="number" value="1890100" readonly></td>
                                    </tr>
                                </table>
                                <table class="table table-bordered" id="dataTable" width="50%" cellspacing="0">
                                	<tr>
                                		<td>1??? ????????????</td> + 
                                		<td>1??? ????????????</td> + 
                                		<td>1??? ?????????</td>
                                	</tr>
                                	<tr>
                                		<td><input type="number" value="1789000" readonly></td>
                                		<td><input type="number" value="2870000" readonly></td>
                                		<td><input type="number" value="4659000" readonly></td>
                                	</tr>
                                	<tr>
                                		<td colspan="3" style="text-align:center">
                                			<input type="button" value="??????">
                                			<input type="button" value="?????????">
                                		</td>
                                	</tr>
                                </table>
                            </div>
                        </div>
                    </div>
        
        <!-- ??????????????? ??? -->



 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
</body>

</html>