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

    <title>KOSMOS_BANK</title>

    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${path }/resources/css/loanList.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<%@ include file="/WEB-INF/views/common/customer/header.jsp" %>

    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Begin Page Content -->
                <div class="container-fluid" style="padding-left:150; padding-right:150">

                    <!-- Page Heading -->
                    <div style="padding-top:50">
                        <h1 style="color:#d97953; font-weight:1000; font-size:60">대출상품 리스트</h1>
                        <h4>스마트하게 당신을 돕는, KOSMO 대출몰</h4>
                    </div>
                    
                    <hr>
                    
                    <br><br>

                    <!-- DataTales Example -->
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <span>전체  <strong style="color:blue">5</strong>건의 상품이 있습니다. </span> <!-- 5건은 나중에 el태그로 리스트의 count로 대체됨 -->
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <tr>
                                            <th>선택</th>
                                            <th>상품명</th>
                                            <th>상품종류</th>
                                            <th>금리</th>
                                            <th>가입/상담</th>
                                        </tr>
                                    <tbody>
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td><a href="${path }/loan_pro_detail.do">KOSMOS 전세대출</a></td>
                                            <td>서민전세대출</td>
                                            <td>고정금리</td>
                                            <td>
                                            	<a href="${path }/loan_pro_detail.do" class="btn btn-secondary btn-icon-split">
                                        			<span class="icon text-white-50">
                                            			<i class="fas fa-arrow-right"></i>
                                       				</span>
                                        			<span class="text">채팅상담</span>
                                   				</a>	
                                   			</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td><a href="${path }/loan_pro_detail.do">KOSMO 개꿀대출</a></td>
                                            <td>서민금융대출</td>
                                            <td>변동금리</td>
                                            <td>
                                            	<a href="${path }/loan_pro_detail.do" class="btn btn-secondary btn-icon-split">
                                        			<span class="icon text-white-50">
                                            			<i class="fas fa-arrow-right"></i>
                                       				</span>
                                        			<span class="text">채팅상담</span>
                                   				</a>	
                                   			</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td><a href="${path }/loan_pro_detail.do">KOSMO 희망대출</a></td>
                                            <td>서민금융대출</td>
                                            <td>고정금리</td>
                                            <td>
                                            	<a href="${path }/loan_pro_detail.do" class="btn btn-secondary btn-icon-split">
                                        			<span class="icon text-white-50">
                                            			<i class="fas fa-arrow-right"></i>
                                       				</span>
                                        			<span class="text">채팅상담</span>
                                   				</a>	
                                   			</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td><a href="${path }/loan_pro_detail.do">KOSMO 정기대출</a></td>
                                            <td>서민금융대출</td>
                                            <td>고정금리</td>
                                            <td>
                                            	<a href="${path }/loan_pro_detail.do" class="btn btn-secondary btn-icon-split">
                                        			<span class="icon text-white-50">
                                            			<i class="fas fa-arrow-right"></i>
                                       				</span>
                                        			<span class="text">채팅상담</span>
                                   				</a>	
                                   			</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox"></td>
                                            <td><a href="${path }/loan_pro_detail.do">KOSMO 불행대출</a></td>
                                            <td>서민청년대출</td>
                                            <td>고정금리</td>
                                            <td>
                                            	<a href="${path }/loan_pro_detail.do" class="btn btn-secondary btn-icon-split">
                                        			<span class="icon text-white-50">
                                            			<i class="fas fa-arrow-right"></i>
                                       				</span>
                                        			<span class="text">채팅상담</span>
                                   				</a>	
                                   			</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up">맨위로</i>
    </a>

    



</body>

</html>