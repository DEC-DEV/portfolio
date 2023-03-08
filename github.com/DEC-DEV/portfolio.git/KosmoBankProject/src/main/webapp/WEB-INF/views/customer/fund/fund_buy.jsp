<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> KosmosBank</title>


<script>
$(document).ready(function(){
    //체크박스 전체 선택&해제
    $('#ck_all').click(function(){
         if($("#ck_all").prop("checked")){   // #ck_all 체크하면
            $("input[type=checkbox]").prop("checked",true); // 모두 체크
        }else{
            $("input[type=checkbox]").prop("checked",false); // 체크 x
        }
    });
});
</script>

<!-- 카카오페이 결제 테스트용 iamport js 불러오기 -->
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
$(function () {
   $("#btnbuy").click(function () {
      var IMP = window.IMP; // 생략가능
      var f_money = $("#f_money").val()
      IMP.init('imp61314098'); 
      // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
      // ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
      IMP.request_pay({
         pg: 'kakao',
         pay_method: 'card',
         merchant_uid: 'merchant_' + new Date().getTime(),
         /* 
          *  merchant_uid에 경우 
          *  https://docs.iamport.kr/implementation/payment
          *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
          */
         name: '펀드명 : ${title}',
         // 결제창에서 보여질 이름
         // name: '주문명 : ${auction.a_title}',
         // 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
         amount: $("#f_money").val(),
         // amount: ${bid.b_bid},
         // 가격 
         buyer_name: '이름',
         // 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
         // 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
         buyer_postcode: '123-456',
         }, function (rsp) {
            console.log(rsp);
         if (rsp.success) {
            var msg = '결제가 완료되었습니다.';
            msg += '결제 금액 : ' + rsp.paid_amount;
            var result = 1;
            // success.submit();
            // 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
            // 자세한 설명은 구글링으로 보시는게 좋습니다.
         } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            var result = 0;
         }
         if(result ===1){
	         window.location.href='${path}/fund_buyaction.do?${_csrf.parameterName}=${_csrf.token}&f_num='+${f_num}+'&f_money='+f_money
         }else{
        	 swal('결제에 실패 하였습니다',{
        		 icon: "error"
        	 });
        	 window.location.href='${path}/fund_detail.do?f_num=${f_num}';
         }
      });
   });
});   


</script>
</head>
<body>
     <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
               <div class="container px-lg-5">
                   <div class="row justify-content-center" style="padding-top:150">
                       <div class="col-lg-7">
                           <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                              <h6 class="position-relative d-inline text-primary ps-4">KosmosBank</h6>
                               <h2 class="mt-2">펀드 구매</h2>
                           </div>
                       </div >
              <!-- Main Content -->
              <div class="container my-5 px-lg-5" style="padding-top: 0px;">
                 <div class="" style="padding-top: 1rem;">
                     <h3 class="mt-2"> 펀드구매</h3>
                     <span>펀드구매는 KOSMOS뱅크 계좌만 가능합니다.</span>
                  </div>
                  <div class="" style="padding-top: 1rem;">
                     <h3 class="mt-2"> 약관동의 및 약관확인 </h3>
                     <span>펀드구매 등 금융거래를 위하여 관련 법류과 규정에 따라 동의 및 확인이 필요합니다.</span>
                     <!-- 약관 table -->
                     <div>
                       <button id="account_chk1" class="btn py-sm-3 px-sm-5 rounded-pill mb-4" style="color: black"><strong class="fs-customer-5">펀드거래기본 약관</strong></button>
                       <a id="account_chk2" class="btn py-sm-3 px-sm-5 rounded-pill mb-4" style="color: black"><strong class="fs-customer-5">개인신용정보의 제공활용동의</strong></a>
                    </div>
                      <div class="card-header_num py-3">
                          <form action="${path }/account_addAction.do" name="account_add" onsubmit="return account_add_Chk()">
                             <table style="width: 100%; padding: 1em; height: 4em;" >
                                <tr >
                                   <td colspan="2"><strong class="fs-customer-5">통장약관</strong></td>
                                </tr>
                                 <tr>
                                     <td>펀드구매 약관 전체 동의</td>
                                     <!-- 전체 동의 클릭시 아래 약관들 체크됨 -->
                                     <td>
                                        <input id="terms_all" type="checkbox" value="전체 동의">
                                     </td>
                                 </tr> 
                                 <tr>
                                     <td>펀드거래기본 약관</td>
                                     <td><input id="terms_1" type="checkbox" value="약관 동의"></td>
                                 </tr>
                                 <tr>
                                     <td>전자금융거래이용에 관한 기본약관</td>
                                     <td><input id="terms_2" type="checkbox" value="약관 동의"></td>
                                 </tr>
                                 <tr>
                                     <td>적립식펀드 자동이체서비스약관</td>
                                     <td><input id="terms_3" type="checkbox" value="약관 동의"></td>
                                 </tr>
                                 <tr>
                                    <td>개인신용정보의 제공활용동의</td>
                                     <td><input id="terms_4" type="checkbox" value="약관 동의"></td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <input id="ck_all" type="checkbox">
                                        본인은 위 안내에 대해 확인하고 이해합니다
                                    </td>
                                 </tr>
                             </table>
                         </form>  
                      </div>
                  </div>
              </div>
                  <div id="title2"></div>
                  <div class="container my-5 px-lg-5" style="padding-top: 0px;">
                  <hr id="hr" width="80%" />
                  <form style="margin:3em" action="${path}/fund_buyaction.do?${_csrf.parameterName}=${_csrf.token}">
                  <table id="table" align="center" width="50%">
                     <tr>
                        <th width="300px">회원아이디</th>
                        <td><input type="text" class="form-control" placeholder="회원아이디" id="id" name="id" value="${sessionScope.customerID}"></td>
                     </tr>
                     <tr>
                        <th width="300px">회원명</th>
                        <td><input type="text" class="form-control" placeholder="회원이름" id="name" name="name" value="${name}" readonly></td>
                     </tr>
                     <tr>
                        <th width="300px">매수금액</th>
                        <td><input type="text" class="form-control" placeholder="매수금액" id="f_money" name="f_money" required></td>
                     </tr>
                     
                     <tr style="margin: 20px;">
                        <td colspan="2" align="center">
                           <input class="btn btn btn-primary" type="button" id="btnbuy" name="btnbuy" value="후원하기">
                           <input type="hidden" name="f_num" value="${f_num}">
                           <%-- <input class="btn btn btn-primary" type="button" id="btnbuy" name="btnbuy" value="후원하기">
                           <input type="hidden" name="f_num" value="${dto.f_num}"> --%>
                        </td>
                     </tr>
                  </table>
                  </form>
                  </div>
                  <%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
                  </div>
              </div>
            </div>  

</body>
</html>