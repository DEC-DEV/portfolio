<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	if( '${sessionScope.customerID}' == null){
		alert("로그인 후 이용 부탁드립니다");
		window.location.href="${path}/login.do"
	};
	
	let query = window.location.search;
	let param = new URLSearchParams(query);
	let d_count = param.get('d_count');
	
	$(document).ready(function() {
		$("#button1").click(function() {
			let tdArr = new Array(); // 배열 선언
			let ts = $("#table1 tr"); // table1의 모든 tr 값을 변수에 초기화
			let tr = ts.eq(d_count); //  d_count의값(회차)과 일치하는 tr을 변수에 초기화
			let td = tr.children(); // 변수 tr의 자식(td)들을 변수 td에 초기화
			
			console.log("값 : ", tr.text());
			console.log("td값 : ", td.text());
			
			td.each(function(i){
				tdArr.push(td.eq(i).text()); // for문을 돌리면서 배열에 td의 값들을 차례로 대입
			});
			console.log("배열에 담긴 값 : ", tdArr);
			
			// 금액의 콤마(,) 제거 후 Mapping
			// 회차
			let index = tdArr[0];
			// 월납입원금
			let test1 = tdArr[1];
			let monthlyOrigin = test1.replace(/,/g, "");
			// 월납입이자
			let test2 = tdArr[2];
			let monthlyInterest = test2.replace(/,/g, "");
			// 월총상환금
			let test3 = tdArr[3];
			let monthlyTotal = test3.replace(/,/g, "");
			// 대출 잔액
			let test4 = tdArr[4];
			let remaining = test4.replace(/,/g, "");
			// 상환예정일
			let planDate = tdArr[5];
			// 대출상품명 -> 위의 d_count 가져올 때 가져왔음
			let d_name = param.get('d_name');
			// 대출 번호
			let d_num = param.get('d_num');
			// 상환방법
			let d_repay = param.get('d_repay');
			
			window.location.href="${path}/loan_paid_detail.do?index=" + index + "&d_name=" + d_name + 
					"&d_num=" + d_num + "&monthlyOrigin=" + monthlyOrigin + "&d_repay=" + d_repay +
					"&monthlyInterest=" + monthlyInterest + "&monthlyTotal=" + monthlyTotal +
					"&remaining=" + remaining + "&planDate=" + planDate + "&${_csrf.parameterName}=${_csrf.token}";
			
		});
	});
	
	$(document).ready(function(){
		$('#button2').click(function(){
			let d_num = param.get('d_num');
			window.location.href="${path}/loan_cancel.do?d_num=" + d_num
		});
	});
	
	
	
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
                   <h2 class="mt-2"> 대출 상환 예정표 </h2>
                   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
               </div>
		        <!-- Main Content -->
		        <div class="container my-5 py-5 px-lg-5">
		                <!-- Page Heading -->
		                <hr>
		                 <div class="" style="padding-top: 1rem;">
		                   	<h3 class="mt-2">${d_name}</h3>
		                   </div>
		               
		               
		                <div  style="padding: 2rem">
		                <span style="padding-left: 1rem;"><strong>${list[1].d_count}회차 납부</strong></span>
		                <hr>
		                <div class="result_ajax" style="position: relative;" > <!-- ajax 사용시 값이 변화해야하는 div -->
		                    <table id="table1" cellpadding="10em" cellspacing="20em" style="width: 100%"> 
		                      <tr>
		                          <th>회차</th>
		                          <th>월납입원금</th>
		                          <th>월납입이자</th>
		                          <th>월총상환금</th>
		                          <th>대출 잔액</th>
		                          <th>상환예정일</th>
		                          <th>상환여부</th>
		                      </tr>
		                      <c:forEach items="${list }" var="item">
		                      <c:set var="key" value="1" />
			                      <tr>
			                          <td>${item.index}</td>
			                          <td><fmt:formatNumber value="${item.originRepay}" pattern="#,###"/></td>
			                          <td><fmt:formatNumber value="${item.interestRepay}" pattern="#,###"/></td>
			                          <td><fmt:formatNumber value="${item.totalRepay}" pattern="#,###"/></td>
			                          <td><fmt:formatNumber value="${item.remainAmount}" pattern="#,###"/></td>
			                          <td>${item.returnDate}</td>
			                          <c:set var="count" value="${item.d_count}"></c:set>
			                          <c:if test="${item.index lt count}">
			                          	<td>상환완료</td>
			                          </c:if>
			                          <c:if test="${item.index eq count}">
			                          	<td style="color:blue; font-weight:bold">상환대상</td>
			                          </c:if>
			                          <c:if test="${item.index gt count}">
			                          	<td>상환예정</td>
			                          </c:if>
			                      </tr>
			                      <c:set var="key" value="${key + 1}" />
		                      </c:forEach>
		                      <tr>
		                      	<td colspan="5" style="text-align:center;">
		                      		<input type="button" class="btn btn-primary" value="상환하기" id="button1">
		                      		<input type="button" class="btn btn-primary" value="해지하기" id="button2">
		                      	</td>
		                      </tr>
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