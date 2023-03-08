<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 펀드 남은기간 구현 -->
<!-- 1초 = 1000(msc)
    1분 = 1000 * 60 
    1시간 = 1000 * 60 * 60
    1일 = 1000 * 60 * 60 * 24 -->

<script type="text/javascript">
var test='<c:out value="${dto.f_end_date}"/>';
var end_date = test + " 00:00:00";
console.log('test : ', test);

var dday = new Date(end_date).getTime();
setInterval(function() {
  var today = new Date().getTime();
  var gap = dday - today;
  var day = Math.ceil(gap / (1000 * 60 * 60 * 24));
  var hour = Math.ceil((gap % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var min = Math.ceil((gap % (1000 * 60 * 60)) / (1000 * 60));
  var sec = Math.ceil((gap % (1000 * 60)) / 1000);

  document.getElementById("count").innerHTML = day + "일 ";
}, 1000);
</script>

<!-- <script>
$(function() {
   $("#btnbuy").click(function() {
      if(confirm("후원하시겠습니까?")) {
         document.form1.action="${path}/fundbuy.do";
         document.form1.submit();
      }
   });
});
</script> -->
</head>
<body>
     <div class="container-xxl position-relative p-0">
      <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
        <div class="container px-lg-5" style="padding-top:150">
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                       <h6 class="position-relative d-inline text-primary ps-4">KosmosBank</h6>
                        <h2 class="mt-2">펀드상세</h2>
                    </div>
               </div >
            <!-- Main Content -->
           <div class="container my-5 px-lg-5">
            <form name="form1" action="${path}/fund_buy.do?${_csrf.parameterName}=${_csrf.token}">
               <strong class="mt-2" style="color:black">펀드 상세 보기 </strong>
               <hr/>
               <span id="f_category" name="f_category"> [ 펀드 종목 ] ${dto.f_category} </span>
               <h3 class="mt-2" name="title" >${dto.f_title}</h3>
               <table style="width:100%; text-align: center; margin-left: 20px;">
                  <tr >
                     <td rowspan="6">
                        <img class="img-fluid rounded w-100" src="${dto.f_filename}" name="img">
                     </td>
                  </tr>
                 <tr>
                    <td>
                        <span style="display:block;">모인금액</span>
                        <h3 class="mt-2">
                           <fmt:formatNumber value="${price}"></fmt:formatNumber>원
                        </h3>
                        <h5>
                           <fmt:formatNumber value="${(price / dto.f_target_money) * 100}" pattern="0"></fmt:formatNumber>%
                        </h5>
                     </td>
                 </tr>
                 <tr>
                    <td>
                        <span style="display:block;">남은기간</span>
                        <h3 class="mt-2" id="count">
                        <%-- <fmt:formatNumber value=""></fmt:formatNumber> --%>
                        </h3>
                     </td>
                 </tr>
                 <tr>
                    <td>
                        <span style="display:block;">후원자</span>
                        <h3 class="mt-2">
                           ${total} 명
                        </h3>
                     </td>
                 </tr>
                  <tr>
                     <td>
                        <strong></strong>
                        <p class="card-header" style="color:black">
                        목표 금액 :  ${dto.f_target_money}원
                        <br> 펀딩 기간: ${dto.f_start_date} ~ ${dto.f_end_date}
                        </p>
                     </td>
                  </tr>
                  <tr>
                     <td colspan="3" style="text-align: right">
                        <input class="btn btn btn-primary" type="submit" id="btnbuy" name="btnbuy" value="후원하기">
                        <input type="hidden" name="f_num" value="${dto.f_num}">
                        <input type="hidden" name="end_date" id="end_date" value="${dto.f_end_date}">
                        <!-- <a onclick="load('fund_buy.do')">후원하기</a> -->
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