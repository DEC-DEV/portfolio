<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script src="${path }/resources/customer/js/pdfobject.js"></script>
<meta charset="UTF-8">
<title> 계좌개설 </title>
<script type="text/javascript">
$(function(){
	// 전체 체크 구현
	$("#terms_all").on("click",function(){
		$("#terms_1").attr("checked",true);
		$("#terms_2").attr("checked",true);
		$("#terms_3").attr("checked",true);
		$("#terms_4").attr("checked",true);
		if(!$("#terms_all").is(':checked') ) {
			$("#terms_1").attr("checked",false);
			$("#terms_2").attr("checked",false);
			$("#terms_3").attr("checked",false);
			$("#terms_4").attr("checked",false);
			$("#terms_approve").attr("checked",false);
		}else{
			$("#terms_all").attr("checked",true);
			$("#terms_1").attr("checked",true);
			$("#terms_2").attr("checked",true);
			$("#terms_3").attr("checked",true);
			$("#terms_4").attr("checked",true);
			$("#terms_approve").attr("checked",true);
		}
	});
	
	$("#terms_approve").on("click",function(){
			$("#terms_1").attr("checked",true);
			$("#terms_2").attr("checked",true);
			$("#terms_3").attr("checked",true);
			$("#terms_4").attr("checked",true);
		if(!$("#terms_approve").is(':checked') ) {
			$("#terms_1").attr("checked",false);
			$("#terms_2").attr("checked",false);
			$("#terms_3").attr("checked",false);
			$("#terms_4").attr("checked",false);
			$("#terms_approve").attr("checked",false);
		}else{
			$("#terms_all").attr("checked",true);
			$("#terms_1").attr("checked",true);
			$("#terms_2").attr("checked",true);
			$("#terms_3").attr("checked",true);
			$("#terms_4").attr("checked",true);
			$("#terms_approve").attr("checked",true);
		}
	});
	$("#account_chk1").click(function(){
		window.open("${path}/account_add_manage.do","여신예금약관","width=700px,height=800px")
		
	});
	$("#account_chk2").click(function(){
		window.open("${path}/account_product_manage.do","상품약관","width=700px,height=800px")
	})
});

function account_add_Chk(){
	// 비밀번호 공백 여부 확인
	if(!document.account_add.account_password.value ){
		swal("비밀번호 입력 부탁드립니다!", {
		       icon: "error" 
	     });
		document.account_add.account_password.focus();
		return false;
	}
	// 약관에 동의 되어 있으면 action으롱 ㅣ동
	if( $("#terms_approve").is(":checked") ){
		return true;
	}else{
		// 약관 동의 하지 않았을 경우
		swal("이용약관에 동의 후 계좌 신청 부탁드립니다.", {
		       icon: "error" 
	     });
		$("#terms_approve").focus();
		return false;
	}
	
};
</script>
</head>
<body>
	 <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
	            <div class="container px-lg-5">
	                <div class="row justify-content-center">
	                    <div class="col-lg-7" style="padding-top:150">
	                        <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
	                        	<h6 class="position-relative d-inline text-primary ps-4">KosmosBank</h6>
	                            <h2 class="mt-2">계좌 개설</h2>
	                        </div>
                 </div >
		        <!-- Main Content -->
		        <div class="container  px-lg-5" style="padding-top: 0px;">
		        	<div class="" style="padding-top: 1rem;">
		               <h3 class="mt-2"> 비대면 계좌 가입</h3>
		               <span>계좌가입은 KOSMOS뱅크 계좌만 가능합니다.</span>
		            </div>
		            <div class="" style="padding-top: 1rem;">
		               <h3 class="mt-2"> 약관동의 및 금리확인 </h3>
		               <span>상품가입 등 금융거래를 위하여 관련 법류과 규정에 따라 동의 및 확인이 필요합니다.</span>
		               <!-- 약관 table -->
		               <div>
				           <button id="account_chk1" class="btn py-sm-3 px-sm-5 rounded-pill mb-4" style="color: black"><strong class="fs-customer-5">은행여신거래기본 약관</strong></button>
				           <a id="account_chk2" class="btn py-sm-3 px-sm-5 rounded-pill mb-4" style="color: black"><strong class="fs-customer-5">KOSMOS뱅크 통장 금리안내</strong></a>
			           </div>
		                <div class="card-header_num py-3">
		                    <form action="${path }/account_addAction.do" name="account_add" onsubmit="return account_add_Chk()">
			                    <table style="width: 100%; padding: 1em; height: 4em;" >
			                    	<tr >
			                    		<td colspan="2"><strong class="fs-customer-5">통장약관</strong></td>
			                    	</tr>
			                        <tr>
			                            <td>통장개설 약관 전체 동의</td>
			                            <!-- 전체 동의 클릭시 아래 약관들 체크됨 -->
			                            <td>
			                            	<input id="terms_all" type="checkbox" value="전체 동의">
			                            </td>
			                        </tr> 
			                        <tr>
			                            <td>예금거래기본 약관</td>
			                            <td><input id="terms_1" type="checkbox" value="약관 동의"></td>
			                        </tr>
			                        <tr>
			                            <td>입출긍이 자유로운 예금 약관</td>
			                            <td><input id="terms_2" type="checkbox" value="약관 동의"></td>
			                        </tr>
			                        <tr>
			                            <td>비과세 종합저축 특약</td>
			                            <td><input id="terms_3" type="checkbox" value="약관 동의"></td>
			                        </tr>
			                        <tr>
			                        	<td>KOSMOS뱅크 통장 특약</td>
			                        	 <td><input id="terms_4" type="checkbox" value="약관 동의"></td>
			                        </tr>
			                        <tr>
			                        	<td>
			                        		<input id="terms_approve" type="checkbox">
			                        		 본인은 위 안내에 대해 확인하고 이해합니다
			                        	</td>
			                        </tr>
			                        <tr style="text-align: center; border-bottom : 1px solid">
			                        	<td >예금주명</td>
			                        	<td>
			                        		<input type="text" name="account_name" class="btn py-sm-3 px-sm-5" value="${dto.getName() }" readonly >
			                        	</td>
			                        </tr>
			                         <tr style="text-align: center;border-bottom : 1px solid">
			                         	<td style="border-bottom : 1px solid">은행명</td>
			                        	<td>
			                        		<input type="text" name="account_bank_name" class="btn py-sm-3 px-sm-5" value="KOSMOS뱅크" readonly >
			                        	</td>
			                        </tr>
			                          <tr style="text-align: center;border-bottom : 1px solid">
			                         	<td style="border-bottom : 1px solid"> 비밀번호 </td>
			                         	<td>
			                         		<input type="password" name="account_password" class="btn py-sm-3 px-sm-5" maxlength="4">
			                         	</td>
			                        </tr>     
			                         <tr style="text-align: center">
			                         	<td colspan="2">
			                         		<input style="color:white" type="submit" class="btn btn-secondary py-sm-3 px-sm-5" value="확인">
			                         		<input style="color: white" type="button" class="btn btn-secondary py-sm-3 px-sm-5" value="취소" onclick="history.back()">
			                         	</td>
			                        </tr>
			                    </table>
			                </form>  
		                </div>
		            </div>
		        </div>
		        </div>
           	<footer>
        		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        	</footer>
        	</div>
       </div>
</body>
</html>