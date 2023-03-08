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
	<title>대출상품 등록 </title>
	
	<!-- Custom fonts for this template -->
    <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">

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
                  <h1 class="h3 mb-2 text-gray-800">대출상품등록</h1>
              </div>
              
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">대출상품등록</h6>
                        </div>
              <div class="savings">
				<div class="card-body">
	               <div class="table-responsive">
	               <form action="${path }/loan_pro_add_action.ad?${_csrf.parameterName}=${_csrf.token}" name="form">
	                   <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           <tr>
                           		<th>대출상품명</th>
                           		<td><input type="text" class="form-control" id="d_name" name="d_name"></td>
                           	</tr>
                           	
                           	<tr>
                           		<th>대출 금리</th>
                           		<td>
                                <select class="form-control" id="d_interest_rate" name="d_interest_rate">
							      <option value="1">1.0</option>
							      <option value="2">2.0</option>
							      <option value="3">3.0</option>
							      <option value="4">4.0</option>
							      <option value="5">5.0</option>
							      <option value="6">6.0</option>
							      <option value="7">7.0</option>
							      <option value="8">8.0</option>
							      <option value="9">9.0</option>
							      <option value="10">10.0</option>
							      <option value="11">11.0</option>
							      <option value="12">12.0</option>
							    </select>
							    </td>
                           	</tr>
                           	
                           	<tr>
                           		<th>대출상환방법</th>
                           		<td>
                                <select class="form-control" id="d_repay" name="d_repay">
							        <option value="원금균등상환">원금균등상환</option>
							        <option value="만기일시상환">만기일시상환</option>
							    </select>
							    </td>
                           	</tr>
                           	
                           	<tr>
                           		<th>최소대출금액</th>
                           		<td><input type="number" class="form-control" id="d_min_price" name="d_min_price"></td>
                           	</tr>
                           	
                           	<tr>
                           		<th>최대대출금액</th>
                           		<td><input type="number" class="form-control" id="d_max_price" name="d_max_price"></td>
                           	</tr>
                           	
                           	<tr>
                           		<th>최소대출기간(년)</th>
                           		<td><input type="number" class="form-control" id="d_min_date" name="d_min_date"></td>
                           	</tr>
                           	
                           	<tr>
                           		<th>최대대출기간(년)</th>
                           		<td><input type="number" class="form-control" id="d_max_date" name="d_max_date"></td>
                           	</tr>
                           	
                           	<tr>
                           		<th>중도상환수수료율(%)</th>
                           		<td><input type="number" class="form-control" id="d_prepayment_fee" name="d_prepayment_fee"></td>
                           	</tr>
                           	
                           	<tr>
                           		<th>상품 설명</th>
                           		<td><input type="text" class="form-control" id="d_explanation1" name="d_explanation1"></td>
                           	</tr>
                               
                            <tr>
                               <th colspan="2" align="center">
                                    <button type="submit" class="btn btn-primary float-right">등록</button>
								</th>
                           </tr>
	                   </table>
	                   </form>
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