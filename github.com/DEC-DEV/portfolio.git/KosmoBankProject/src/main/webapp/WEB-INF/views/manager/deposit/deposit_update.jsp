<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function goBack() {
		window.history.back();	//뒤로 이동
	}
	$(function(){
		$("#y_interest_rate").val( ${dto.y_interest_rate} ).prop("selected",true);
	})
</script>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>KOSMO 예금</title>
	
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
              <div style="padding-top:30; padding-bottom: 2.5em;" >         
                      <h1 class="h3 mb-2 text-gray-800">예금상품 수정</h1>
              </div>
              
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">예금상품 수정</h6>
                        </div>
              <div class="savings">
				<div class="card-body">
				 <form action="${path}/deposit_update_action.ad?${_csrf.parameterName}=${_csrf.token}" method="post" name="deposit_item_add">
	               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	               <input type="hidden" name="y_no" value="${dto.y_no }"/>
	             <!--    <input type="hidden" name="${dto.y_no}" id="${dto.y_no}"> -->
	               <div class="table-responsive">
	                   <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           <tr>
                               <th style=width:300px;>예금 상품명</th>
                               <td><input type="text" name="y_name" id="y_name" value="${dto.y_name}"></td>
                               
                           </tr>
                           <tr>
                               <th style=width:300px;>예금상품 한줄요약</th>
                              <td><input type="text" name="y_summary" id="y_summary" size="40" value="${dto.y_summary}"></td>
                               
                           </tr>
                           
                           <tr>
                               <th style=width:300px;>예금 적용 금리(%)</th>
                               <td>
                               <select  name="y_interest_rate" id="y_interest_rate">
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
                               <th style=width:300px;>적용 종류</th>
   								<td>
   									<select name="y_type" id="y_type">
	   									<option <c:if test="${dto.y_type eq '0'}"> selected </c:if> value="${dto.y_type}">자유 거치식</option>
	   									<option <c:if test="${dto.y_type eq '1'}"> selected </c:if> value="${dto.y_type}">적립식</option>
   									</select>
   								</td>
                           </tr>
                           
                           <tr>
                               <th style=width:300px;>최대 예금 기간(~36개월)</th>
                               <td><input type="text" name="y_start_date" id="y_start_date" value="${dto.y_start_date}" max="36"></td>
                               
                           </tr>
                           
                           <tr>
                               <th style=width:300px;>최소 예금 기간(1개월~)</th>
                               <td><input type="text" name="y_end_date" id="y_end_date" value="${dto.y_end_date}"></td>
                               
                           </tr>
                       	   <tr>
                               <th style=width:300px;>최소 예치 금액</th>
                               <td><input type="text" name="y_min_price" id="y_min_price" value="${dto.y_min_price}"></td>
                           </tr>
                           
                           <tr>
                               <th style=width:300px;>유의사항</th>
                               <td>
  									<textarea rows="5" cols= 50 placeholder="${dto.y_notice}" name="y_notice" id="y_notice" ></textarea>
  								</td>
                           </tr>                           
                                                      
                           <tr align="center">
								<th colspan="2">
									 <a href="#" class="btn btn-primary btn-icon-split btn-sm">
                                       	<input type="submit" value="수정">
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