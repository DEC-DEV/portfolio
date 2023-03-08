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
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${path}/resources/css/loanList.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">
	<!-- header start -->
        <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
    <!-- header end -->
  
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
                    <h1 style="color:#d97953; font-weight:800; font-size:40">대출계좌 상세조회</h1>               
                </div>
                
                <hr>
                
                <br><br>

                 <div class="card shadow mb-4" style="padding-top: 1rem;">
                    <div class="card-header py-3">
                        <span style="padding-left: 1rem;"><strong style="font-size: 2em;">대출이자 조회/납부</strong></span>
                        <hr>
                    </div>
                 <!-- 계좌조회 table -->
                <div class="table account" style="width: 60%;">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <tr>
                            <th>조회계좌</th>
                            <td> 
                                <div class="input-group mb-3"></div>
                                <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
                                <ul class="dropdown-menu">
                                  <li><a class="dropdown-item" href="#">Action</a></li>
                                  <li><a class="dropdown-item" href="#">Another action</a></li>
                                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                                  <li><hr class="dropdown-divider"></li>
                                  <li><a class="dropdown-item" href="#">Separated link</a></li>
                                </ul>
                            </div>
                            </td>
                        </tr>
                        <tr>
                            <th>이자 실행번호</th>
                            <td>1</td>
                        </tr>
                        <tr>
                           <td colspan="2"><button type="button" class="btn btn-primary" style="padding-left: 1em; padding-right: 1em; font-size: 1.5em; transform: translate(300%);" >조회</button></td>
                        </tr>
                      
                    </table>
                </div>
               
               
                <div style="padding-top: 8rem;">
                <span style="padding-left: 1rem;"><strong style="font-size: 2em;">대출이자 조회/납부</strong></span>
                <hr>
                <div class="card-body">
                <div class="table-responsive" style="position: relative; align-content:center; width: 60%;" > <!-- ajax 사용시 값이 변화해야하는 div -->
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> 
                      <tr>
                          <th style="text-align: left; font-weight: bold;" >거래일자</th>
                          <td> 416,666(원)</td>
                      </tr>
                      <tr>
                        <th style="text-align: left; font-weight: bold;">출금 계좌번호</th>
                          <td>1111-1111-1111</td>
                      </tr>
                      <tr>
                        <th style="text-align: left; font-weight: bold;">비밀번호</th>
                        <td><input type="password"> </td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="button" class="btn btn-primary" style="padding-left: 1em; padding-right: 1em; font-size: 1.5em; transform: translate(300%);">납부</button></td>
                     </tr>
                   
                   
                   </table>
                  </div>  
                  </div>
                </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

   	<!-- footer start -->
		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
		<!-- footer end -->        

    </div>
    <!-- End of Content Wrapper -->
    	

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up">맨위로</i>
    </a>


</body>
</html>