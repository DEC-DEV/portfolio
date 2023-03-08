<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>고객센터</title>

    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
    <script>
		$(function () { // 페이지가 로드되면
			// 자동으로 댓글 목록을 호출
			comment_list();
			
			//목록으로 이동
			$('#btnList').click(function () { /*등록 버튼 클릭시 작동, 주의사항 : input type = "button"*/
				location.href="${path}/counsel_list_search.ad?${_csrf.parameterName}=${_csrf.token}"
			});
			
			//삭제처리
			$('#btnEdit').click(function () { /*등록 버튼 클릭시 작동, 주의사항 : input type = "button"*/
				/* alert("btnEdit"); */
				var con_test = confirm("정말로 삭제하시겠습니까? ");
				if (con_test == true) {
					document.form1.action="${path}/counsel_delete_action.ad?${_csrf.parameterName}=${_csrf.token}"
					document.form1.submit();
				}
				
			});
			
			//댓글쓰기 버튼
			$('#btnSave').click(function () { /*댓글 쓰기 버튼 클릭시 작동*/
				comment_add();
			});
		});
		
		//댓글쓰기
		function comment_add() {
			//게시글번호, 작성자, 글내용을 파라미터로 넘김
			var param = {
				"board_num" : $('#boardNum').val(),
				"writer" : $('#writer').val(),
				"content" : $('#comment_content').val()
			}
			$.ajax({
				type: "POST",
				url: "${path}/counsel_coment_add.ad?${_csrf.parameterName}=${_csrf.token}",
				data: param,
				success: function() { //댓글쓰기가 완료되었을때 서버에서 콜백함수 호출
					$('#writer').val(""); //입력한 내용 지우기
					$('#content').val(""); //입력한 내용 지우기
					comment_list(); // 댓글목록 새로고침
				},
				error: function(error) {
					alert('comment_add - 오류');
				}
			});
		}
		
		//댓글목록
		function comment_list() {
			$.ajax({
				type: "POST",
				url: "${path}/counsel_coment_list_search.ad?${_csrf.parameterName}=${_csrf.token}",
				data: "num=${dto.b_num}",
				success: function(result) {
					$('#commentList').html(result);
				},
				error: function(error) {
					alert('comment_list - 오류');
				}
			});
		}
	</script>
</head>

<body id="page-top">

	<!-- sub_menu_admin 시작 -->
	<!-- sub_menu_admin 끝 -->
	
	 <!-- Page Wrapper -->
    <div id="wrapper">
		<!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/header.jsp" %>
		<!-- header 끝 -->
	
		<!-- Content Wrapper -->
	   	<div id="content-wrapper" class="d-flex flex-column">	
	   	
	   		<!-- Main Content -->
	    	<div id="content">							
	
			    <!-- Begin Page Content -->
		        <div class="container-fluid" style="padding-left:150; padding-right:150">
		       
			        <!-- Page Heading -->
			       	<h1 class="h3 mb-2 text-gray-800" style="padding-top: 50">고객센터 글 상세보기</h1>
		       		
					<!-- DataTales Example -->
	              	<div class="card shadow mb-4">
	              		<div class="card-header py-3">
	                    	<h6 class="m-0 font-weight-bold text-primary">고객센터 글 상세보기</h6>
						</div>
	                  	<div class="card-body">
	                      	<div class="table-responsive">
	                        	<form action="" name="form1">
	                        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		                            <table class="table table-hover">
									  <thead>
									    <tr>
										    <th class="col-md-1">작성자</th>
										    <td class="col-md-1">${dto.b_name}</td>
										    <th class="col-md-1">작성일</th>
										    <td class="col-md-1">${dto.b_date}</td>
									    </tr>
									    <tr>
									    	<th class="col-md-1">글제목</th>
									    	<td class="col-md-1">${dto.b_title}</td>
									    	<td colspan="2" class="col-md-1" style="text-align:center">
									    		<input type="hidden" name="boardNum" id="boardNum" value="${dto.b_num}">
									    		<input type="button" class="btn btn-primary" value="삭제" id="btnEdit">
									    	</td>
									    </tr>
									  </thead>
									  <tbody>
									    <tr>
									    	<td colspan="4"><textarea cols="125" rows="10" readonly style="border:none">${dto.b_content}</textarea></td>
									    </tr>
									    <tr>
									    	<td colspan="4" style="text-align:center"><input type="button" class="btn btn-primary" value="목록으로" id="btnList"></td>
									    </tr>
									  </tbody>
									  <tfoot>
									  	<tr>
									  	</tr>
									  	<tr>
											<td colspan="1" class="col-md-1">
												<input id="writer" name="writer" placeholder="이름을 입력">
											</td>
											<td colspan="3" class="col-md-1">
												<button id="btnSave" type="button" class="btn btn-primary" style="text-align:left">확인</button>
											</td>
										</tr>
										<tr>
											<td colspan="4"><textarea id="comment_content" name="comment_content" cols="125" rows="3" style="border:none" placeholder="댓글 내용 입력"></textarea></td>
										</tr>							  
									  </tfoot>
									</table>
								</form>
								<!-- 댓글 목록을 출력할 영역 -->
								<div id="commentList">
									댓글 목록 영역						
								</div>
	              			</div>
	                    </div>
					</div>
				</div>
			<!-- /.container-fluid -->
			</div>
		<!--컨텐츠 끝 -->
		</div>
	</div>
	<!-- footer 시작 -->
	<%@ include file ="/WEB-INF/views/common/footer.jsp" %>
	<!-- footer 끝 -->


</body>
</html>