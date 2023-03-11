<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function goBack() {
		window.history.back();	//뒤로 이동
	}
</script>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>COSMO 적금</title>
	
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
    
    <!-- header 시작 -->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <!-- header 끝 -->	
	 <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
		  <!-- Begin Page Content -->
          <div class="container-fluid" style="padding-left:150; padding-right:150">
              <!-- Page Heading -->
              <div style="padding-top:30; padding-bottom: 2.5em;">
                  <h1 class="h3 mb-2 text-gray-800">적금상품등록</h1>
              </div>
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">적금상품등록</h6>
                        </div>
             <div class="savings">
				<div class="card-body">
				 <form action="${path}/savings_add_action.ad?${_csrf.parameterName}=${_csrf.token}" method="post" name="savings_item_add">
	               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	               <div class="table-responsive">
	                   <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           <tr>
                               <th style=width:300px;>적금 상품명</th>
                               <td><input type="text" name="i_name" id="i_name"></td>
                           </tr>
                           <tr>
                               <th style=width:300px;>적금상품 요약</th>
                              <td><input type="text" name="i_summary" id="i_summary" size="40"></td>
                           </tr>
                           <tr>
                               <th style=width:300px;>적금 적용 금리(%)</th>
                               <td>
	                               <select  name="i_rate" id="i_rate">
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
                               <th style=width:300px;>적용 금리 종류</th>
   								<td>
   									<select name="i_type" id="i_type">
   										<option value="0">단리</option>
   										<option value="1">복리</option>
   									</select>
   								</td>
                           </tr>
                           <tr>
                               <th style=width:300px;>최소 적금 기간(12개월~)</th>
                               <td><input type="text" name="i_min_date" id="i_min_date"></td>
                           </tr>
                           <tr>
                               <th style=width:300px;>최대 적금 기간(36개월)</th>
                               <td><input type="text" name="i_max_date" id="i_max_date"></td>
                           </tr>
                       	   <tr>
                               <th style=width:300px;>자동 이체일</th>
                              <td><select name="i_auto_date" id="i_auto_date">
									<option value="5">5일</option>
									<option value="10">10일</option>
									<option value="15">15일</option>
									<option value="20">20일</option>
									<option value="25">25일</option>
   								  </select>
   							  </td>
                           </tr>
                           <tr>
                               <th style=width:300px;>유의사항</th>
                               <td>
  									<textarea rows="5" cols= 50 placeholder="유의 사항 입력" name="i_notice" id="i_notice"></textarea>
  								</td>
                           </tr>                           
                           <tr align="center">
								<th colspan="2">
									 <a class="btn btn-primary btn-icon-split btn-sm">
                                       	<input type="submit" value="등록">
                                    </a>
                                    <a class="btn btn-primary btn-icon-split btn-sm" onclick="goBack();">
                                        <input type="reset" value="취소">
                                    </a>
								</th>
							</tr>
	                   </table>
	               </div>
	              </form>
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