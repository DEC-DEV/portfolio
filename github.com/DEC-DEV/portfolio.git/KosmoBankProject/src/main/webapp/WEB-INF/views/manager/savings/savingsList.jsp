
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

	<title>KOSMOS 적금</title>
	
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
                  <h1 class="h3 mb-2 text-gray-800">적금상품목록</h1>
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
	                <input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}">
	                   <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                       
                           <tr>
                               <th>적금이름</th>
                               <th>상품요약</th>
                               <th>금리</th>
                               <th>종류</th>
                               <th>최소기간</th>
                               <th>최대기간</th>
                               <th>등록일</th>
                           </tr>
                           
                             <c:forEach var="dto" items="${list}">
                           <tr>
                               <td>${dto.i_name}</td>
                               <td>${dto.i_summary}</td>
                               <td>${dto.i_rate}</td>
                               <c:if test="${dto.i_type eq '0'}">
                              	 <td>단리</td>
                               </c:if>
                               <c:if test="${dto.i_type eq '1'}">
                             	  <td>복리</td>
                               </c:if>
                               <td>${dto.i_min_date}</td>
                               <td>${dto.i_max_date}</td>
                               <td><fmt:formatDate value="${dto.i_date}" pattern="YY.MM.dd"/></td>
                               <th colspan="2">
                           
								<a class="btn btn-primary btn-icon-split btn-sm"  onclick="window.location='savings_update.ad?i_no=${dto.i_no}&pageNum=${paging.pageNum}'">
                                     <span class="text">수정</span>
                                 </a>
                                 
                                 <a class="btn btn-primary btn-icon-split btn-sm" onclick="window.location='savings_delete.ad?i_no=${dto.i_no}&pageNum=${paging.pageNum}'">
                                     <span class="text">삭제</span>
                                 </a>
								</th>
                          	 </tr>
                            </c:forEach>   
                         
                   	<tr>
                   		<td colspan="11" align="center">
                        <!-- 페이징 처리 -->
                        <!-- 이전 버튼 활성화 여부 -->
                        <c:if test="${paging.startPage > 10}">
                           <a href="${path}/savingsList.ad?pageNum=${paging.prev}" style="color: black">[이전]</a>
                        </c:if> 
                        
                        <!-- 페이지번호 처리 -->
                        <c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
                           <a href="${path}/savingsList.ad?pageNum=${num}"  style="color: black">${num}</a>
                        </c:forEach>
                        
                        <!-- 다음 버튼 활성화 여부 -->
                        <c:if test="${paging.endPage < paging.pageCount}">
                           <a href="${path}/savingsList.ad?pageNum=${paging.next}"  style="color: black">[다음]</a>
                        </c:if>
                     </td>
                  </tr>   
	                   </table>
	               </div>
	           </div>
	         </div>
	       </div>
		</div>
		</div>
			<!-- Footer -->
	       <%@ include file="/WEB-INF/views/common/footer.jsp" %>
	       <!-- Footer -->
		</div>
	</div>
</body>
</html>