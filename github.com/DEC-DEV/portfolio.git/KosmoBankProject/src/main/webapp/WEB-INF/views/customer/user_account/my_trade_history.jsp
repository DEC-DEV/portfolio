<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 거래내역 조회</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Work+Sans&display=swap" rel="stylesheet">
<style>

div > table th,td{
font-family: 'Work Sans', sans-serif;
font-size: 18px;
}
table th,td{
font-family: 'Work Sans', sans-serif;
font-size: 18px;
}
body{
color:black;
}
#trade_history_tbl{
width: 100%;
text-align: center;

}
</style>
</head>
<script type="text/javascript">
$(function(){
	$("#select_trade_history").click(function(){
		var date_start = $("#date_start").val();
		var date_end = $("#date_end").val()
		var account_num = '${list.get(0).account_num }';
		if(date_start == "" || date_end == ""){
			swal("조회기간을 설정해주세요",{
				icon: "error"
			});
		}else{
			$.ajax({
			    type		: "POST",
			    url 		: "${path}/select_trade_history.do?${_csrf.parameterName}=${_csrf.token}",
			    data		: {
			    	"date_start":date_start,
			    	"date_end":date_end,
			    	"account_num":account_num
			    }, 
			    dataType: 'text',
			    success : function(data) {
			    	console.log(data)
			    	$("#ajax").html(data); 	
			    },
			    error : function(error) {
			    	alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			    }
			});
		}
	});
});
</script>
<body style="color:black">
	    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar & Hero Start -->
   <!-- Spinner End -->
	        <!-- Main Content -->
	<div class="container py-5 px-lg-5">
        <!-- Navbar & Hero Start -->
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
             <div class="container px-lg-5">
                <div class="row justify-content-center">
                    <div class="col-lg-7"  >
                        <div class="section-title position-relative text-center pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
                        	<h6 class="position-relative d-inline text-primary ps-4">kosmosBank</h6>
                            <h2 class="mt-2" style="font-family: 'Work Sans', sans-serif;color: black">거래내역 조회</h2>
                        </div>
                	</div >
		                <!-- Page Heading -->
		                 <!-- 계좌조회 table -->
		                <div class="card-header_num py-3" style="margin-top: 100px">
		                    <table style="width: 100%; padding: 1em; height: 7em; border:2px solid; text-align: center" >
		                        <tr>
		                            <th style="width:10%"> 출금계좌번호 </th>
		                            <td style="font-size:25px;">${list.get(0).account_num }</td>
		                        </tr>
		                        <tr>
		                            <th style=" width:20%">조회기간</th>
		                            <td style=" width:20%">
		                            	<input type="date" id="date_start" style="padding:10px;">
		                            	<input type="date" id="date_end"  style="padding:10px;">
		                            </td>
		                            <td style="width:20%">
		                            	<input type="button" id="select_trade_history" class="btn btn-secondary" value="조회" style="color:white">
		                            </td>
		                        </tr>
		                        
		                    </table>
		                </div>
		                <div  style="padding: 2rem">
		                <span style="padding-left: 1rem;"><strong>거래 내역</strong></span>
		                <hr>
		                <div id="ajax" class="result_ajax" style="position: relative;" > <!-- ajax 사용시 값이 변화해야하는 div -->
		                    <table id="trade_history_tbl" cellpadding="10em" cellspacing="20em" style=""> 
		                      <tr style="height: 30px;padding-top: 3em; padding-bottom: 3em">
		                      	<td style="text-align: center;" colspan="2"><h5 style="font-size:15px">입금합계(건수)</h5></td>
		                      	<td style="text-align: center" colspan="2"> <input type="text" style="text-align: center;color:#384B7D" class="form-control"  value="${list.get(0).i_cnt }" readonly></td>
		                      	<td style="text-align: center" colspan="2" ><h5 style=" font-size:15px">출금합계(건수)</h5></td>
		                      	<td style="text-align: center" colspan="2"><input type="text" style="text-align: center;color:#9D2E2E" class="form-control"  value="${list.get(0).t_cnt }" readonly></td>
		                      </tr>
		                      <tr style="height:2em;background-color:#9cb6ed;color:white">
		                          <th>거래일자</th>
		                          <th>거래시간</th>
		                          <th>보낸 사람 명</th>
		                          <th style="color:#9D2E2E">출금(원)</th>
		                          <th style="color:#384B7D">입금(원)</th>
		                          <th>내용</th>
		                          <th>잔액(원)</th>
		                      </tr>
		                     <c:forEach items="${list }" var="item">
			                      <tr>
			                          <td>${item.transfer_date }</td>
			                          <td>${item.transfer_time }</td>
			                          <td>${item.sender_name }</td>
			                          <td>
			                          	<c:if test="${item.in_out == '출금' }">
			                          		${item.money }
			                          	</c:if>
			                          </td>
			                           <td>
			                          	<c:if test="${item.in_out == '입금' }">
			                          		${item.money }
			                          	</c:if>
			                          	<c:if test="${item.in_out =='추가납부' }">
								       		${item.money }
								       	</c:if>
			                          </td>
			                          <td>
			                          	<c:if test="${item.in_out == '출금' }">
			                          		${item.out_comment }
			                          	</c:if>
			                          	<c:if test="${item.in_out == '입금' }">
			                          		${item.in_comment }
			                          	</c:if>
									  </td>
			                          <td> ${item.transfer_balance } </td>
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
    <!-- Content Wrapper -->

        <footer>
        	<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        </footer>
   </div>
        <!-- Navbar & Hero End -->
</body>
</html>