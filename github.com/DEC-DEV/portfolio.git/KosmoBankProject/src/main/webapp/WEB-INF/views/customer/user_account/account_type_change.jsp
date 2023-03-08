<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
 <table cellpadding="10em" cellspacing="20em" style="width: 100%; text-align: center"> 
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