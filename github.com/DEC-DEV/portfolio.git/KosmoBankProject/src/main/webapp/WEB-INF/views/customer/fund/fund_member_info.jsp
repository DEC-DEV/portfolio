<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> KosmosBank</title>

<!-- <script type="text/javascript">
	$(function() {
		$("#keyword").keyup(function() {	/* Ű���� �Է��� ������ �� */
			var id = $("#id").val();	/* input �±׿��� �Է��� Ű���� */
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
				success: function(result) {	// �ݹ��Լ�, result�� ���
					$('#display').html(result);	// ������
				},
				error: function() {
					alert('����');
				}
			});
		});
	});
</script> -->
</head>
<body>


</body>
</html>