<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body style="color:black">
<script type="text/javascript">
if( ${sessionScope.customerID == null}){
	alert("로그인 후 이용 부탁드립니다");
	window.location.href="${path}/login.do"
} 
if('${account_sleep}' ==1 ){
	alert("해지 처리가 완료되었습니다");
}
	// jquery 시작
$(function(){
	$(".account_menu").click(function(){
		var account_type = $(this).val();
		/* AJAX */
		$.ajax({
	          url : '${path}/account_type.do?${_csrf.parameterName}=${_csrf.token}',
	          type : 'POST',    //get,put은 사용한 상태. rest에 의해서 put(update니까)Json.stringify(url)
	          dataType: 'text',
	          data : {
	        	  "account_type":account_type
	        	  },
	          success : function (data) {
	              $("#ajax").html(data);
	          },
	          error : function(error) {
			    	alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			 }
		 });
	});
	$("#account_list").change(function(){
		var account_num = $(this).val();
		$.ajax({
	          url : '${path}/select_account_history.do?${_csrf.parameterName}=${_csrf.token}',
	          type : 'POST',    //get,put은 사용한 상태. rest에 의해서 put(update니까)Json.stringify(url)
	          dataType: 'json',
	          data : {
	        	  "account_num":account_num
	        	  },
	          success : function (data) {
	        	  console.log(data.in_out_date);
	              $("#account_history").text(data.history)
	              $("#account_state").text(data.account_state)
	              $("#account_trade_history").text(data.in_out_date)
	          },
	          error : function(error) {
			    	alert( " error = " + error);
			 }
		 });
	});
	$("#account_sorting").change(function(){
		var type= $(this).val();
		alert(type);
		$.ajax({
	          url : '${path}/my_account_sorting.do?${_csrf.parameterName}=${_csrf.token}',
	          type : 'POST',    //get,put은 사용한 상태. rest에 의해서 put(update니까)Json.stringify(url)
	          dataType: 'text',
	          data : {
	        	  "type": type
	        	  },
	          success : function (data) {
	        	  console.log(data)
	        	  $("#ajax").html(data);
	          },
	          error:function(request, status, error){
	        	alert("error:"+error+"code:"+request.status+"\n"+"message:"+request.responseText+"\n");		
			 }
		 });
	});
});
	
</script>
        <!-- Spinner End -->
 	<div class="container-xxl position-relative p-0">
        <!-- Navbar & Hero Start -->
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
             <div class="container px-lg-5">
                <div class="row justify-content-center">
                    <div class="col-lg-7"  >
                        <div class="section-title position-relative text-center pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
                        	<h6 class="position-relative d-inline text-primary ps-4">kosmoBank</h6>
                            <h2 class="mt-2">계좌 조회</h2>
                        </div>
                 </div >
		        <!-- Main Content -->
		        <div class="container py-5 px-lg-5">
		                <!-- Page Heading -->
		                 <!-- 계좌조회 table -->
		                <div class="card-header_num py-3">
		                    <table style=" padding: 1em; height: 7em; border:2px solid; width:100%; text-align: center; font-size:20px"  cellpadding="10em" cellspacing="20em">
		                        <tr>
		                            <td>
										<select id="account_list">
				                        	<c:forEach items="${list }" var="item">
													<option>${item.account_num }</option>
				                            </c:forEach>
										</select>		                            	
		                            </td>
		                            <td style="width: 30%; text-align: left">최종 접속일자 :
			                            	<span id="account_history">${list.get(0).history }</span>
		                            </td>
		                         </tr> 
		                        <tr>
		                            <td style="width: 30%;">계좌 상태 :
			                            <span id="account_state">${list.get(0).account_state }</span>
		                            </td>
		                        
		                            <td style="width: 30%; text-align: left">최종 거래일자 :
			                            <span id="account_trade_history">	${list.get(0).IN_OUT_DATE }</span>
		                             </td>
		                        </tr>
		                        
		                    </table>
		                </div>
		               
		                <div class="navbar navbar-expand-lg px-4 px-lg-5 py-3 py-lg-0" id="navbarCollapse" 
		                style="padding-top: 1em; display:flex; justify-content:space-between; background-color:#9cb6ed;color:white;" >
                            <button class="btn account_menu" style="color:white;font-size:20px;" value="전체계좌" >전쳬계좌</button>
                          	<button class="btn account_menu" style="color:white;font-size:20px;" value="입/출금">입/출금</button>
                           	<button class="btn account_menu" style="color:white;font-size:20px;" value="대출">대출</button>
                            <button class="btn account_menu" style="color:white;font-size:20px;" value="적금">적금</button>
                            <button class="btn account_menu" style="color:white;font-size:20px;" value="예금">예금</button>
                            <button class="btn account_menu" style="color:white;font-size:20px;" value="정지/휴면/해지">해지/휴면/정지</button>
		                 <hr>
		                </div>
		                <div  style="padding: 2rem">
		                <span style="padding-left: 1rem;"><strong>전체 계좌 조회</strong></span>
		             	<select id="account_sorting" style="margin:10px">
		             		<option selected>계좌번호</option>
		             		<option>생성일</option>
		             	</select>
		                <hr>
		                <div id="ajax" class="result_ajax" style="position: relative;" > <!-- ajax 사용시 값이 변화해야하는 div -->
		                    <table cellpadding="10em" cellspacing="20em" style="width: 100%;text-align: center"> 
		                      <tr>
		                          <th>계좌명</th>
		                          <th>계좌종류</th>
		                          <th>계좌번호</th>
		                          <th>계좌상태</th>
		                          <th>계좌생성일</th>
		                          <th>잔액(원)</th>
		                          <th>계좌이체내역</th>
		                      </tr>
		                      <c:forEach items="${list }" var="item">
			                      <tr>
			                          <td>${item.account_name }</td>
			                          <td>${item.account_type }</td>
			                          <td><a href="${path }/my_trade_history.do?account_num=${item.account_num }">${item.account_num }</a></td>
			                          <td>${item.account_state }</td>
			                          <td>${item.new_date }</td>
			                          <td>${item.balance }</td>
			                          <td>${item.IN_OUT_DATE }</td>
			                      </tr>
		                      </c:forEach>
		                   </table>
		                  </div>  
		                </div>
		             </div>
		            <!-- /.container-fluid -->
		        </div>
        <!-- End of Main Content -->
             <footer>
        	<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        	</footer>
        	</div>
        </div>
    <!-- Content Wrapper -->
</body>
</html>