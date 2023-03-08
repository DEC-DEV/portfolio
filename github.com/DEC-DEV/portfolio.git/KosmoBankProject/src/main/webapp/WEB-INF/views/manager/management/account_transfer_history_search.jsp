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

    <title>KOSMOS 계좌이체 목록</title>

    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
    
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	/* function btnSearch(){
		alert('검색');
	}; */
	$(function(){
		$('#search').click(function(){
			//alert('검색');
			var keyword = $("#keyword").val();
			var col = $("select[name='col']").val();
			console.log(keyword);
			console.log(col);
			if(col != "none") {
				location.href = "account_transfer_history_search.ad?col=" + col + "&keyword=" + keyword;
			} else {
				alert("분류 선택을 하세요.");
			}
		});
	});
	
</script>


<body id="page-top">

	<!-- sub_menu_admin 시작 -->
	<!-- sub_menu_admin 끝 -->
	
	 <!-- Page Wrapper -->
    <div id="wrapper">
    

	<!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/header.jsp" %>
	<!-- header 끝 -->							

		<!-- Begin Page Content -->
         <div class="container-fluid"  style="padding-left:150; padding-right:150">
       
			<!-- Page Heading -->
			<div style="padding-top:50">
			    <h1 class="h3 mb-2 text-gray-800">계좌 이체 내역 조회</h1>
			</div>
			<div class="card shadow mb-4">
				<div class="card-header py-3">
				    <h6 class="m-0 font-weight-bold text-primary"></h6>
				</div>
		        <!-- Topbar Search -->
		        <br>
		        <form
		            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" style="text-align:right;">
		            <div class="input-group">
     		            <select name="col">
                  			<option value="account_num">계좌 번호</option>
                  			<option value="in_out">입금/출금</option>
                  			<option value="id">아이디</option>
                  			<option value="recipient_name">받은 사람</option>
                  			<option value="sender_name">보낸 사람</option>
                  			<option value="transfer_num">거래 번호</option>
                  		</select>
		                <input type="text" id="keyword" name="keyword" class="form-control bg-light border-0 small" placeholder="검색 정보 입력"
		                    aria-label="Search" aria-describedby="basic-addon2">
		                <div class="input-group-append">
		                    <button id="search" class="btn btn-primary" type="button">
		                        <i class="fas fa-search fa-sm"></i>
		                    </button>
		                </div>
		            </div>
		        </form>
              	<div class="savings">
					<div class="card-body">
		            	<div class="table-responsive">
		                	<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" style="text-align: center;">
	                        	<tr>
	                            	<th>거래 번호</th>
	                           		<th>계좌 번호</th>
	                           		<th>아이디</th>
	                           		<th>입/출금</th>
	                           		<th>금액</th>
	                           		<th>받는 사람</th>
	                           		<th>받는 사람 표시내용</th>
	                           		<th>보낸 사람</th>
	                           		<th>보낸 사람 표시내용</th>
	                               	<th>거래일시</th>
	                           	</tr>
	                            <!-- 데이터 값 for문 시작 -->
	                            <c:if test="${list != null }">
	                            <c:forEach var="dto" items="${list}">
	                           	<tr>
 	                                <td>${dto.transfer_num}</td>
 	                                <td>${dto.account_num}</td>
	                                <td>${dto.id}</td>
	                                <td>${dto.in_out}</td>
	                                <td><fmt:formatNumber value="${dto.money}" pattern="#,##0" />원</td>
	                                <td>${dto.recipient_name}</td>
	                                <td>${dto.in_comment}</td>
 	                                <td>${dto.sender_name}</td>
	                                <td>${dto.out_comment}</td>
	                                <td>${dto.in_out_date}</td>

	                           	</tr>
	                          	</c:forEach>
	                          	</c:if>
	                          	<!-- for문 끝 -->
	                          	<%-- <tr>
				                    <td colspan="7" align="center">
				                       <!-- 페이징 처리 -->
				                       <!-- 이전버튼 활성화 여부 -->
										<c:if test="${paging.startPage > 10}">
											<a href="${path}/account_transfer_history_search.ad?pageNum=${paging.prev}">[이전]</a>
										</c:if>
										<!-- 페이징 번호처리 -->
										<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
											<a href="${path}/account_transfer_history_search.ad?pageNum=${num}">${num}</a>
										</c:forEach>
										<!-- 다음버튼 활성화 여부 -->
										<c:if test="${paging.endPage < paging.pageCount}">
											<a href="${path}/account_transfer_history_search.ad?pageNum=${paging.next}">[다음]</a>
										</c:if>
				                    </td>
			                    </tr> --%>
	                   		</table>
	               		</div>
	           		</div>
         		</div>
       		</div>		
		</div>
	</div>
	
	<!--컨텐츠 끝 -->

	<!-- footer 시작 -->
	<%@ include file ="/WEB-INF/views/common/footer.jsp" %>
	<!-- footer 끝 -->


</body>
</html>
