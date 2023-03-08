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

    <title>KOSMOS 고객관리</title>

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

	$(function(){
		$('#search').click(function(){
			//alert('검색');
			var keyword = $("#keyword").val();
			var col = $("select[name='col']").val();
			console.log(keyword);
			console.log(col);
			if(col != "none") {
				location.href = "account_search.ad?col=" + col + "&keyword=" + keyword;
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
		    <h1 class="h3 mb-2 text-gray-800">계좌정보</h1>
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
                  			<option value="account_type">계좌 종류</option>
                  			<option value="account_num">계좌 번호</option>
                  			<option value="name">이름</option>
                  			<option value="id">아이디</option>
                  			
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
	                           		<th>계좌종류</th>
	                               	<th>계좌번호</th>
	                               	<th>이름</th>
	                               	<th>아이디</th>
	                               	<th>한도</th>
	                               	<th>생성일</th>
	                               	<th>비밀번호변경</th>
	                               	<th>계좌상태</th>
	                               	<th>한도변경</th>
	                           </tr>
	                           
	                           <!-- 데이터 값 for문 시작 -->
	                           
	                           <c:forEach var="dto" items="${list}">
	                           <tr height="20">
 	                                <td>${dto.account_type}</td>
	                                <td>${dto.account_num}</td>
	                                <td>${dto.name}</td>
	                                <td>${dto.id}</td>
	                                <td><fmt:formatNumber value="${dto.account_limit}" pattern="#,##0" />원</td>
	                                <td>${dto.new_date}</td>
	                                <td>
	                                <form style="display: hidden" action="${path}/account_password_update.ad" method="post" id="form1">
		            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                                	<input type="hidden" id="account_num" name="account_num" value="${dto.account_num}">
	                                	<input type="hidden" id="id" name="id" value="${dto.id}">
	                                	
	                                	<input type="type" maxlength="4" size="4" id="account_password" name="account_password" value="${dto.account_password}">
	                                	<input class="btn btn-primary btn-sm" type="submit" value="변경">
	                                	
	                                </form>
									</td>
	                                <td>
	                                <form style="display: hidden" action="${path}/account_state.ad" method="post" id="form2">
	                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                                	<input type="hidden" id="account_num" name="account_num" value="${dto.account_num }">
	                                	
	                               		<select class="input" name="account_state" id="account_state" required>
	                               			<option <c:if test="${dto.account_state == '정상'}"> selected</c:if> value="정상">정상</option>
	                               			<option <c:if test="${dto.account_state == '해지'}"> selected</c:if> value="해지">해지</option>
	                               			<option <c:if test="${dto.account_state == '휴면'}"> selected</c:if> value="휴면">휴면</option>
	                               			<option <c:if test="${dto.account_state == '정지'}"> selected</c:if> value="정지">정지</option>
	                               		</select>
	                               		
	                               		<input class="btn btn-primary btn-sm" type="submit" value="변경">
	                            
	                                    </a>
	                                </form> 
	                                </td>
	                                <td colspan="2">
	                                <form style="display: hidden" action="${path}/account_limit_ok.ad" method="post" id="form3">
		            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		            				<input type="hidden" id="account_num" name="account_num" value="${dto.account_num}">
	                                <input type="text" id="account_limit" name="account_limit"  maxlength="9" size="9" placeholder="한도금액입력" >
                                	<input class="btn btn-primary btn-sm" type="submit" value="승인">
                                	<input type="button" class="btn btn-primary btn-sm" value="거절">
	                                </form>
									</td>
	                           	</tr>
	                           <!-- for문 끝 -->
	                           </c:forEach>
	                          
		                           <tr>
					                    <td colspan="9" align="center">
					                       <!-- 페이징 처리 -->
					                       <!-- 이전버튼 활성화 여부 -->
											<c:if test="${paging.startPage > 10}">
												<a href="${path}/account_info.ad?pageNum=${paging.prev}">[이전]</a>
											</c:if>
											<!-- 페이징 번호처리 -->
											<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
												<a href="${path}/account_info.ad?pageNum=${num}">${num}</a>
											</c:forEach>
											<!-- 다음버튼 활성화 여부 -->
											<c:if test="${paging.endPage < paging.pageCount}">
												<a href="${path}/account_info.ad?pageNum=${paging.next}">[다음]</a>
											</c:if>
					                    </td>
				                    </tr>
							<!-- 게시글 반복문 종료 -->
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