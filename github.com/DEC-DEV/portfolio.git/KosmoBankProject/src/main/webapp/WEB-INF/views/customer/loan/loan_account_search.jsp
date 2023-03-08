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

            <div class="container-xxl  hero-header mb-5">
		            <div class="container px-lg-5">
		                <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
		                    <h6 class="position-relative d-inline text-primary ps-4"> KosmosBank</h6>
		                    <h2 class="mt-2">  대출계좌 조회 </h2>
		                </div>
		        	</div>
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
		                      <tr>
		                          <th style="width:5%">대출번호</th>
		                          <th style="width:15%">대출상품명</th>
		                          <th style="width:10%">계좌번호</th>
		                          <th style="width:5%">대출상태</th>
		                          <th style="width:15%">대출원금</th>
		                          <th style="width:5%">대출기간</th>
		                          <th style="width:10%">상환방법</th>
		                          <th style="width:5%">대출금리(%)</th>
		                          <th style="text-align:left; width:10%">대출잔액</th>
		                          <th style="width:10%">대출시작일</th>
		                          <th style="width:5%">회차</th>
		                          <th colspan="2" style="width:10%; text-align:center">버튼</th>
		                      </tr>
		                      <c:forEach items="${list }" var="item">
			                      <tr>
			                          <td>${item.d_num }</td>
			                          <td>${item.d_name }</td>
			                          <td>${item.account_num }</td>
			                          <c:if test="${item.d_state == 0 }">
			                          	<td>승인대기</td>
			                          </c:if>
			                          <c:if test="${item.d_state == 1 }">
			                          	<td>정상</td>
			                          </c:if>
			                          <td><fmt:formatNumber value="${item.d_amount }" pattern="#,###"/></td> <!-- 금액 콤마 붙여서 표시 -->
			                          <td>${item.d_month }</td>
			                          <td>${item.d_repay }</td>
			                          <td>${item.d_rate }</td>
			                          <td>${item.d_balance }</td>
			                          <td>${item.d_start_date}</td>
			                          <td>${item.d_count }회차</td>
			                          <td style="text-align:center">
			                          	<input type="button" class="btn btn-primary" value="상환예정표" onclick="location.href='${path}/loan_paid_plan.do?d_num=${item.d_num}&d_amount=${item.d_amount}&d_rate=${item.d_rate}&d_month=${item.d_month}&d_name=${item.d_name}&d_repay=${item.d_repay}&d_start_date=${item.d_start_date}&d_count=${item.d_count}&d_name=${item.d_name}'">
			                          </td>
			                          <td>
			                          	<input type="button" class="btn btn-primary" value="상환내역" onclick="location.href='${path}/loan_paid_history.do?d_num=${item.d_num}'">
			                          </td>
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