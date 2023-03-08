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

    <title>KOSMO_BANK</title>

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
                    <h1 style="color:#d97953; font-weight:1000; font-size:60">계좌조회</h1>
                    <br>
                    <a href="#">개인</a> > <a href="#" > 조회 </a> > <a href="#"> 계좌조회</a> 
                </div>
                
                <hr>
                
                <br><br>

                 <div class="card shadow mb-4" style="padding-top: 1rem;">
                    <div class="card-header py-3">
                        <span style="padding-left: 1rem;"><strong>계좌조회</strong></span>
                        <hr>
                    </div>
                 <!-- 계좌조회 table -->
                <div class="table account">
                    <table style="width: 100%; padding: 1em; height: 4em; background-color:gainsboro;" >
                        <tr>
                            <td>출금계좌번호 : 1111-1111-1111</td>
                            <td>최종 접속일자 : 2022-04-14</td>
                            <td>계좌 상태 : 정상</td>
                        </tr>
                        <tr>
                            <td>최종 거래일자 : 2022-04-14 09:20</td>
                            <td></td>
                            <td></td>
                        </tr>
                        
                    </table>
                </div>
               
                <div class="collapse navbar-collapse" id="navbarCollapse" style="width: 100rem; padding-top: 1em; display:flex; justify-content: space-between;" >
                        
                          <a href="index.html" class="nav-item nav-link" style="padding-left: 10em;">입/출금</a>
                                                
                            <a href="about.html" class="nav-item nav-link" style="padding-left: 10em;">대출</a>
                      
                            <a href="service.html" class="nav-item nav-link" style="padding-left: 10em;">적금</a>
                                            
                            <a href="project.html" class="nav-item nav-link" style="padding-left: 10em;">펀드</a>
                        
                            <a href="contact.html" class="nav-item nav-link" style="padding-left: 10em;">예금</a>
                       
                            <a href="contact.html" class="nav-item nav-link" style="padding-left: 10em;">졍지/휴면</a>
                       
                            <a href="contact.html" class="nav-item nav-link" style="padding-left: 10em;">전쳬계좌</a>
                    
                  <hr>
                </div>
                <div style="padding-top: 8rem;">
                <span style="padding-left: 1rem;"><strong>예금 계좌</strong></span>
                <hr>
                <div class="result_ajax" style="position: relative; left: 50%; transform: translate(-25%);" > <!-- ajax 사용시 값이 변화해야하는 div -->
                    <table cellpadding="10em" cellspacing="20em"> 
                      <tr>
                          <th>상품명</th>
                          <th>예금상태</th>
                          <th>계좌번호</th>
                          <th>예금 금리</th>
                          <th>예금 종류</th>
                          <th>예치 금액</th>
                          <th>예금 가입일</th>
                          <th>예금 만기일</th>
                      </tr>
                      <tr>
                          <td>가족 예금</td>
                          <td>운영중</td>
                          <td>1111-1111-1111</td>
                          <td>3.4%</td>
                          <td>정기</td>
                          <td>100,000,000</td>
                          <td>2021-04-27</td>
                          <td>2022-04-14 16:20</td>
                      </tr>
                      
                       <tr>
                          <td>KOS 첫예금</td>
                          <td>운영중</td>
                          <td>1111-1111-2222</td>
                          <td>6.4%</td>
                          <td>단기</td>
                          <td>100,000,000</td>
                          <td>2021-04-27</td>
                          <td>2022-04-14 16:20</td>
                      </tr>
                   </table>
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