<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <table id="trade_history_tbl" cellpadding="10em" cellspacing="20em" style=""> 
   <tr style="height: 30px;">
   	<td style="text-align: center" colspan="2"><h5 style="font-family: 'Work Sans', sans-serif;font-size:20px">입금합계(건수)</h5></td>
   	<td style="text-align: center" colspan="2"> <input type="text" style="text-align: center;color:#384B7D" class="form-control"  value="${list.get(0).i_cnt }" readonly></td>
   	<td style="text-align: center" colspan="2" ><h5 style="font-family: 'Work Sans', sans-serif;font-size:20px">출금합계(건수)</h5></td>
   	<td style="text-align: center" colspan="2"><input type="text" style="text-align: center;color:#9D2E2E" class="form-control"  value="${list.get(0).t_cnt }" readonly></td>
   </tr>
   <tr>
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