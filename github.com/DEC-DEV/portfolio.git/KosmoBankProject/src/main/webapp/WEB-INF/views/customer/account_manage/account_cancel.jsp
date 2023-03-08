<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 계좌 해지 </title>

<script type="text/javascript">
$(function(){
	
	if('${param.pwdError}' == 1){
		swal("비밀번호가 틀렸습니다",{
			icon: 'error'
		});
	}
	
	$("#account_num").change(function(){
		var num = account_num.options[account_num.selectedIndex].value;
		$.ajax({
		    type		: "POST",
		    url 		: "${path}/account_cancel_balance.do?${_csrf.parameterName}=${_csrf.token}",
		    data		: "account_num="+ num, 
		    contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		    success 	: function(data) {
		    	$("#account_balance").attr("value",data);
		    },
		    error		: function(error) {
		    	console.log(error);
		    }
		});
	})
});
function account_cancel_chk(){
	if( $("#account_balance").val() > 0){
		swal("계좌 금액이 존재하는 계좌는 해지 할 수 없습니다", {
		       icon: "error" 
	     });
		return false;
	}
	
}

	
</script>
</head>
<body>
	 <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
	            <div class="container px-lg-5">
	                <div class="row justify-content-center">
	                    <div class="col-lg-7" >
	                        <div style="padding-top: 100px;" class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
	                        	<h6 class="position-relative d-inline text-primary ps-4">kosmosBank</h6>
	                            <h2 class="mt-2">계좌 해지</h2>
	                        </div>
                 		</div >
		        <!-- Main Content -->
		        <div class="container px-lg-5" style="padding-top: 0px;">
		        <h3 class="mt-2">
		        	안내 및 유의 사항
		        </h3>
		        	<div class="card" style="padding: 20px;">
		        		<br/>
					'영업점 창구 신규한 예,적금 비대면 해지 서비스'를 원치 않는 고객님께서는 영업점을 방문하시어 '창구신규 예,적금 비대면 해지 제한' 등록을 하시기 바랍니다.
					창구에서 신규된 일부상품(주택청약관련상품, 양도성예금(증서발행),표지,어음,환매채,국공채,금융채,ELD)는 비대면 해지가 불가능합니다.
					영업점 창구 신규한 상품 중 원금기준 5천만원 초과하는 상품을 중도/만기해지하는 경우에는 KosmosBank 영업점에서만 해지 처리 가능합니다.
					해지 시 추가인증이 필요하므로 연락처 등의 정보를 최신상태로 유지하시기 바랍니다.
					미래시점의 해지예상금을 조회할 수 있습니다.
					담보로 설정된 예금에 대하여 5개 이하의 대출을 받은 경우에 한하여 상계처리 가능합니다.(한도대출 제외)
					중도해지 우대이율 상품의 경우 반드시 영업점에 방문하여 증빙서류 제출 후 중도해지 하여야 합니다.(단, 별도 증빙서류 필요한 상품에 한함)
					만 19세 미만 미성년자는 영업점에서 법정대리인 또는 친권자(부 또는 모)의 동의에 의한 해지만 가능합니다.
					긴급한 자금 필요 시 중도해지의 불이익 없이 예적금 담보롤 즉시 대출이 가능합니다.(일부상품제외) 해지 신청하는 상품으로 가계대출 우대금리를 적용 받으신 경우, 해지 시 우대받은 이율만큼 금리가 인상될 수 있습니다
					자세한 내용은 대출 신청하신 영업점에 문의 바랍니다.
					만기 전 해지할 경우 약정한 이자율보다 낮은 중도해지 이자율이 적용되오니 유의하여 주시기 바랍니다. 우대이자율은 만기해지계좌에 한해 지급하오니 유의하시기 바랍니다
					정기적립식 상품의 경우 매월 신규해당일에 월 저축금액이 불입되지 않을 경우 만기일이 변경되어 중도해지 처리될 수 있습니다.
					<br/>
					</div>
					<form style="margin:3em" action="${path }/account_cancelAction.do" method="post" onsubmit="return account_cancel_chk()">
					 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						<table style="text-align: center;width: 100%;">
							<tr>
								<th style="width:20%; text-align: right">
									조회 계좌번호 선택 
								</th>
								<td>
									<select id="account_num" name="account_num"title="계좌를 선택해주세요" >
									  <option selected> 계좌를 선택하세요 </option>
									  <c:forEach items="${list }" var="item">
									  <option> ${item.account_num }</option>
								      </c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<th style="width: 20%;text-align: right; ">
									계좌 비밀번호
								</th>
								<td >
									<input type="password" class="btn" id="account_pwd" name="account_pwd" style="border-bottom: 3px solid black;" maxlength="4">
								</td>
							</tr>
							<tr>
								<th style="width: 20%;text-align: right; ">
									잔액 
								</th>
								<td  >
							 		<input type="text" style="border-bottom: 3px solid black;" class="btn" id="account_balance" style="color:black; height:30px;"  value="" readonly >
								</td>
							</tr>
							<tr style="margin: 5px;">
								<td colspan="2" >
									<input style="color: white" id="account_cancel" type="submit" class="btn btn-secondary" value="계좌해지" >
								</td>
							</tr>
						</table>
					</form>
		        </div>
		        </div>
		       <%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
			</div>
		</div>
</body>
</html>