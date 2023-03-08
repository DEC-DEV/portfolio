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
	<title>KOSMOS 펀드</title>
	
	<!-- Custom fonts for this template -->
    <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="${path }/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
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
			document.form1.action="${path}/fund_approve_action.ad?${_csrf.parameterName}=${_csrf.token}";
			document.form1.submit();
		}
	});
	
	$("#btnno").click(function() {
		if(confirm("거절하시겠습니까?")) {
			document.form1.action="${path}/fund_delete_action.ad?${_csrf.parameterName}=${_csrf.token}";
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
          <div class="container-fluid" style="padding-left:150; padding-right:150">

              <!-- Page Heading -->
              <div style="padding-top:50">
                  <h1 class="h3 mb-2 text-gray-800">펀드 승인/거절</h1>
              </div>
              
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">펀드 승인/거절</h6>
                        </div>
              <div class="">
				<div class="card-body">
	               <div class="table-responsive">
	               <form name="form1" method="post">
   					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                   <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           <tr>
                           		<th><input type="checkbox" id="ck_all"></th>
                               <th>펀드명</th>
                               <th>펀드내용</th>
                               <th>펀딩시작일</th>
                               <th>펀딩종료일</th>
                               <th>목표금액</th>
                               <th>모금계좌</th>
                               <th>승인여부</th>
                           </tr>
                           <c:forEach var="dto" items="${list}">
                           <tr>
                           	   <td><input type="checkbox" name="item" id="item" value="${dto.f_num},${dto.id}"></td>
                               <td><a href="${path}/fund_detail.ad?f_num=${dto.f_num}&pageNum=${paging.pageNum}">${dto.f_title}</a></td>
                               <td>${dto.f_content}</td>
                               <td>${dto.f_start_date}</td>
                               <td>${dto.f_end_date}</td>
                               <td>${dto.f_target_money}</td>
                               <td>${dto.f_account}</td>
                               <td>${dto.f_approve}</td>
                               <!-- <th colspan="2">
									 <a herf="" class="btn btn-primary btn-icon-split btn-sm">
                                        <span class="text"><input type="button" id="btnok" value="승인"></span>
                                    </a>
                                    
                                    <a herf="" class="btn btn-primary btn-icon-split btn-sm">
                                        <span class="text"><input type="button" id="btnno" value="거절"></span>
                                    </a>
								</th> -->
                           </tr>
                            </c:forEach>
                            
                           <tr>
   								<th colspan="8" align="center">
   								<div class="links">
										<!-- 페이징 처리 -->
										<!-- 이전버튼 활성화 여부 -->
										<c:if test="${paging.startPage > 10}">
											<a href="${path}/fund_approve.ad?pageNum=${paging.prev}&${_csrf.parameterName}=${_csrf.token}">[이전]</a>
										</c:if>
										<!-- 페이징 번호처리 -->
										<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
											<a href="${path}/fund_approve.ad?pageNum=${num}&${_csrf.parameterName}=${_csrf.token}">${num}</a>
										</c:forEach>
										<!-- 다음버튼 활성화 여부 -->
										<c:if test="${paging.endPage < paging.pageCount}">
											<a href="${path}/fund_approve.ad?pageNum=${paging.next}&${_csrf.parameterName}=${_csrf.token}">[다음]</a>
										</c:if>
									</div>
   									<input class="btn btn-primary float-right" type="button" id="btnno" value="거절">
   									<input class="btn btn-primary float-right" type="button" id="btnok" value="승인">
   								</th>
   							</tr>
   							
	   						<!-- <tr>
								<td colspan="4" align="center">
									
								</td>
							</tr> -->
                          
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