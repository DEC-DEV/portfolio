<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<body>
<script type="text/javascript">
	if( '${sessionScope.customerID}' == null){
		alert("로그인 후 이용 부탁드립니다");
		window.location.href="${path}/login.do"
	}
</script>
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar & Hero Start -->
        <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>

            <div class="container-xxl py-5 hero-header mb-5">
               <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
                   <h6 class="position-relative d-inline text-primary ps-4"> KosmosBank</h6>
                   <h2 class="mt-2"> 대출계좌조회 </h2>
                   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
               </div>
                
		        <!-- Main Content -->
		        <div class="container my-5 py-5 px-lg-5">
		                <!-- Page Heading -->
		                <hr>
		                 <div class="" style="padding-top: 1rem;">
		                   	<h3 class="mt-2">대출계좌조회</h3>
		                   </div>
		               
		                <div  style="padding: 2rem">
		                <span style="padding-left: 1rem;">총 <strong style="color:blue">${count}</strong>건의 계좌를 조회하였습니다.</span>
		                <hr>
		                <div class="result_ajax" style="position: relative;" > <!-- ajax 사용시 값이 변화해야하는 div -->
		                    <table cellpadding="10em" cellspacing="20em" style="width: 100%"> 
		                      <tr style="text-align:center">
		                          <th style="width:10%">상환번호</th>
		                          <th style="width:10%">대출번호</th>
		                          <th style="width:20%">상환일</th>
		                          <th style="width:10%">대출유형</th>
		                          <th style="width:10%">상환금액</th>
		                          <th style="width:10%">상환잔액</th>
		                          <th style="width:10%">이체번호</th>
		                          <th style="width:20%">출금계좌번호</th>
		                      </tr>
		                      <c:forEach items="${list }" var="item">
			                      <tr style="text-align:center">
			                          <td>${item.d_his_num}</td>
			                          <td>${item.d_num}</td>
			                          <td>${item.d_his_date}</td>
			                          <td>${item.d_his_type}</td>
			                          <td>${item.d_his_amount}</td>
			                          <td>${item.d_his_balance}</td>
			                          <td>${item.transfer_num}</td>
			                          <td>${item.d_account_type}</td>
			                      </tr>
		                      </c:forEach>
		                   </table>
		                  </div>  
		                </div>
		                </div>
		            <!-- /.container-fluid -->
		
		        </div>
        <!-- End of Main Content -->
            </div>
             <footer>
        	<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        	</footer>
        </div>
    <!-- Content Wrapper -->
</body>
</html>