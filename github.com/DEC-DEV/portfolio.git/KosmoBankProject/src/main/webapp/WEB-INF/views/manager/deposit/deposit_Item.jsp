<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>COSMO 예금</title>
	
	<!-- Custom fonts for this template -->
    <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<!-- <link href="css/savingsitem.css" rel="stylesheet"> -->
	
    <!-- Custom styles for this page -->
    <link href="${path}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body id="page-top">

	<!-- Page Wrapper -->
    <div id="wrapper">	
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    
    
	 <!-- Content Wrapper -->
     <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
		
		  <!-- Begin Page Content -->
          <div class="container-fluid" style="padding-left:150; padding-right:150">

              <!-- Page Heading -->
              <div style="padding-top:50">
                  <h1 class="h3 mb-2 text-gray-800">예금상품</h1>
              </div>
              
              <hr>
                    
              <br><br>
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary"></h6>
                        </div>
              <div class="savings">
				<div class="card-body">
	               <div class="table-responsive">
	               	 <!-- Content Row -->
                    <div class="row">
                        <!-- Border Left Utilities -->
                        <div class="col-lg-6">
                            <div class="card mb-4 py-3 border-bottom-primary">
                                <div class="card-body">
                                    <table>
                                  		<tr>
	                              			<th style=width:100px;>청년희망</th>
	                              			<td>5.0%</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>가입</th>
	                              			<td>우리종합금융</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>금리</th>
	                              			<td>기본 2.00% (12개월)</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>특판</th>
	                              			<td>(금리) 기본금리 연 1.80%에 우대금리 최고 연 8.20% 적용해 연 10.00% 금리 제공</td>
                              			</tr>
                              			
                              			<tr align="center">
	                              			<td colspan="2">
	                              			<a href="#" class="btn btn-primary btn-icon-split btn-sm">
	                              				<span class="icon text-white-50">
	                                          	<i class="fas fa-check"></i>
	                                      		</span>
	                                      		<span class="text">가입하기</span>
	                                  		</a>
	                                  		</td>
                                  		</tr>
                                    </table>
                                </div>
                            </div>

                            <div class="card mb-4 py-3 border-bottom-primary">
                                <div class="card-body">
                                    <table>
                                  		<tr>
	                              			<th style=width:100px;>청년희망</th>
	                              			<td>5.0%</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>가입</th>
	                              			<td>우리종합금융</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>금리</th>
	                              			<td>기본 2.00% (12개월)</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>특판</th>
	                              			<td>(금리) 기본금리 연 1.80%에 우대금리 최고 연 8.20% 적용해 연 10.00% 금리 제공</td>
                              			</tr>
                              			
                              			<tr align="center">
	                              			<td colspan="2">
	                              			<a href="#" class="btn btn-primary btn-icon-split btn-sm">
	                              				<span class="icon text-white-50">
	                                          	<i class="fas fa-check"></i>
	                                      		</span>
	                                      		<span class="text">가입하기</span>
	                                  		</a>
	                                  		</td>
                                  		</tr>
                                    </table>
                                </div>
                            </div>

                            <div class="card mb-4 py-3 border-bottom-primary">
                                <div class="card-body">
                                    <table>
                                  		<tr>
	                              			<th style=width:100px;>청년희망</th>
	                              			<td>5.0%</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>가입</th>
	                              			<td>우리종합금융</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>금리</th>
	                              			<td>기본 2.00% (12개월)</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>특판</th>
	                              			<td>(금리) 기본금리 연 1.80%에 우대금리 최고 연 8.20% 적용해 연 10.00% 금리 제공</td>
                              			</tr>
                              			
                              			<tr align="center">
	                              			<td colspan="2">
	                              			<a href="#" class="btn btn-primary btn-icon-split btn-sm">
	                              				<span class="icon text-white-50">
	                                          	<i class="fas fa-check"></i>
	                                      		</span>
	                                      		<span class="text">가입하기</span>
	                                  		</a>
	                                  		</td>
                                  		</tr>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- Border Bottom Utilities -->
                        <div class="col-lg-6">

                            <div class="card mb-4 py-3 border-bottom-primary">
                                <div class="card-body">
                                    <table>
                                  		<tr>
	                              			<th style=width:100px;>청년희망</th>
	                              			<td>5.0%</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>가입</th>
	                              			<td>우리종합금융</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>금리</th>
	                              			<td>기본 2.00% (12개월)</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>특판</th>
	                              			<td>(금리) 기본금리 연 1.80%에 우대금리 최고 연 8.20% 적용해 연 10.00% 금리 제공</td>
                              			</tr>
                              			
                              			<tr align="center">
	                              			<td colspan="2">
	                              			<a href="#" class="btn btn-primary btn-icon-split btn-sm">
	                              				<span class="icon text-white-50">
	                                          	<i class="fas fa-check"></i>
	                                      		</span>
	                                      		<span class="text">가입하기</span>
	                                  		</a>
	                                  		</td>
                                  		</tr>
                                    </table>
                                </div>
                            </div>

                            <div class="card mb-4 py-3 border-bottom-primary">
                                <div class="card-body">
                                    <table>
                                  		<tr>
	                              			<th style=width:100px;>청년희망</th>
	                              			<td>5.0%</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>가입</th>
	                              			<td>우리종합금융</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>금리</th>
	                              			<td>기본 2.00% (12개월)</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>특판</th>
	                              			<td>(금리) 기본금리 연 1.80%에 우대금리 최고 연 8.20% 적용해 연 10.00% 금리 제공</td>
                              			</tr>
                              			
                              			<tr align="center">
	                              			<td colspan="2">
	                              			<a href="#" class="btn btn-primary btn-icon-split btn-sm">
	                              				<span class="icon text-white-50">
	                                          	<i class="fas fa-check"></i>
	                                      		</span>
	                                      		<span class="text">가입하기</span>
	                                  		</a>
	                                  		</td>
                                  		</tr>
                                    </table>
                                </div>
                            </div>

                            <div class="card mb-4 py-3 border-bottom-primary">
                                <div class="card-body">
                                    <table>
                                  		<tr>
	                              			<th style=width:100px;>청년희망</th>
	                              			<td>5.0%</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>가입</th>
	                              			<td>우리종합금융</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>금리</th>
	                              			<td>기본 2.00% (12개월)</td>
                              			</tr>
                              			
                              			<tr>
	                              			<th>특판</th>
	                              			<td>(금리) 기본금리 연 1.80%에 우대금리 최고 연 8.20% 적용해 연 10.00% 금리 제공</td>
                              			</tr>
                              			
                              			<tr align="center">
	                              			<td colspan="2">
	                              			<a href="#" class="btn btn-primary btn-icon-split btn-sm">
	                              				<span class="icon text-white-50">
	                                          	<i class="fas fa-check"></i>
	                                      		</span>
	                                      		<span class="text">가입하기</span>
	                                  		</a>
	                                  		</td>
                                  		</tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
	               </div>
	           </div>
	         </div>
	       </div>
		</div>
		</div>
			<!-- Footer -->
	       <%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</div>
	</div>
</body>
</html>