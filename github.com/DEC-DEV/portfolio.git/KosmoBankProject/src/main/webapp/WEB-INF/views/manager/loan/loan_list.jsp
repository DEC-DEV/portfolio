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
	<title>대출 신청내역 상세 </title>
	
	<!-- Custom fonts for this template -->
    <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="${path}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<script>
$(document).ready(function(){
    //체크박스 전체 선택&해제
    $('#ck_all').click(function(){
         if($("#ck_all").prop("checked")){	// #ck_all 체크하면
            $("input[type=checkbox]").prop("checked",true); // 모두 체크
        }else{
            $("input[type=checkbox]").prop("checked",false); // 체크 x
        }
    });
});

</script>

<script>
$(function() { // 페이지가 로딩되면
	$("#btnok").click(function() {
		if(confirm("승인하시겠습니까?")){
			document.form1.action="${path}/loan_approve_action.ad?${_csrf.parameterName}=${_csrf.token}";
			document.form1.submit();
		}
	});
	
	$("#btnno").click(function() {
		if(confirm("거절하시겠습니까?")) {
			document.form1.action="${path}/loan_delete_action.ad?${_csrf.parameterName}=${_csrf.token}";
			document.form1.submit();
		}
	});
});
</script>
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
          <div class="container-fluid"  style="padding-left:150; padding-right:150">

              <!-- Page Heading -->
              <div style="padding-top:50">
                  <h1 class="h3 mb-2 text-gray-800">대출신청내역상세</h1>
              </div>
              
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">대출신청내역상세</h6>
                        </div>
              <div class="savings">
				<div class="card-body">
	               <div class="table-responsive">
	                <form name="form1" method="post">
	                   <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           <tr>
                           	   <th><input type="checkbox" id="ck_all"></th>
                           	   <th>대출번호</th>
                               <th>대출상품명</th>
                               <th>연결계좌번호</th>
                               <th>대출실행일</th>
                               <th>대출만기일</th>
                               <th>대출기간</th>
                               <th>상환방법</th>
                               <th>대출금리</th>
                               <th>대출상태</th>
                           </tr>
                           
                           <c:forEach var="dto" items="${list}">
                           <tr>
                           	   <td><input type="checkbox" name="item" id="item" value="${dto.d_num},${dto.d_name}"></td>
                           	   <td>${dto.d_num}</td>
                               <td><a href="${path}/loan_list_detail.ad?d_num=${dto.d_num}&pageNum=${paging.pageNum}">${dto.d_name}</a></td>
                               <td>${dto.account_num}</td>
                               <td>${dto.d_start_date}</td>
                               <td>${dto.d_end_date}</td>
                               <td>${dto.d_month}</td>
                               <td>${dto.d_repay}</td>
                               <td>${dto.d_rate}</td>
                               <c:if test="${dto.d_state == 0 }">
	                          	 <td>승인대기</td>
	                           </c:if>
	                           <c:if test="${dto.d_state == 1 }">
	                          	 <td>승인완료</td>
	                           </c:if>
	                           <c:if test="${dto.d_state == 2 }">
	                          	 <td>승인거절</td>
	                           </c:if>
                           </tr>
                           </c:forEach>
                           
                           <tr>
   								<td colspan="10" align="center">
   									<input class="btn btn-primary float-right" type="button" id="btnno" value="거절">
   									<input class="btn btn-primary float-right" type="button" id="btnok" value="승인">
   								</td>
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