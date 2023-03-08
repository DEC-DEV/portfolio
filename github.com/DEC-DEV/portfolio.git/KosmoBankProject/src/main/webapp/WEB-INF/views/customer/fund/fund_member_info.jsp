<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> KosmosBank</title>

<!-- <script type="text/javascript">
	$(function() {
		$("#keyword").keyup(function() {	/* 키워드 입력이 끝났을 때 */
			var id = $("#id").val();	/* input 태그에서 입력한 키워드 */
			var f_account = $("#f_account").val();
			var f_money = $("#f_money").val();
			var f_date = $("#f_date").val();
			
			$.ajax({
				url: '${contextPath}/fund_member_info.do',
				type: 'POST',
				data: 'id=' + id,
					  'f_account=' + f_account,
					  'f_money=' + f_money,
					  'f_date=' + f_date,
				success: function(result) {	// 콜백함수, result에 결과
					$('#display').html(result);	// 결과출력
				},
				error: function() {
					alert('오류');
				}
			});
		});
	});
</script> -->
</head>
<body>


</body>
</html>