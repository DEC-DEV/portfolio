<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>KOSMOS 적금</title>
	
	<!-- Custom fonts for this template -->
    <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">
    
    <!-- <link href="table2.css" rel="stylesheet"> -->

    <!-- Custom styles for this page -->
    <link href="${path}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
<script type="text/javascript">

var sel_flie;

$(document).ready(function(){
   $("#f_filename").on("change",handleImgFileSelect);
});

function handleImgFileSelect(e){
   var files = e.target.files;
   var filesArr = Array.prototype.slice.call(files);
   
   filesArr.forEach(function(f){

   sel_file = f;
   
   var reader = new FileReader();
   reader.onload = function(e) {
      $("#imgsrc").attr("src",e.target.result);
      }
   reader.readAsDataURL(f);
   });
   
}
</script>

<!-- <script>
$(function() { // 페이지가 로딩되면
	$("#btndel").click(function() {
			location.href="${path}/fund_delete.ad?${_csrf.parameterName}=${_csrf.token}";
	});
});

</script> -->
</head>

<body id="page-top">

	<!-- Page Wrapper -->
    <div id="wrapper">	
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    
    
	 <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

		
		
		  <!-- Begin Page Content -->
          <div class="container-fluid" style="padding-left:150; padding-right:150">

              <!-- Page Heading -->
              <div style="padding-top:50">
                  <h1 class="h3 mb-2 text-gray-800">펀드내용 상세보기</h1>
              </div>
              
              
              <!-- DataTales Example -->
              <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">펀드내용상세</h6>
                        </div>
              <div class="savings">
				<div class="card-body">
	               <div class="table-responsive">
	               	<form action="${path}/fund_update_action.ad?${_csrf.parameterName}=${_csrf.token}" method="post"" enctype="multipart/form-data">
	                   <table style="width:1000px" align="center" border="1" class="table table-bordered" id="dataTable" cellspacing="0">
	                     <tr>
	                     	<th>펀드번호</th>
	                        <td>
	                        	<input type="text" value="${dto.f_num}" id="f_num" name="f_num">
	                        </td>
	                     </tr> 
	                     
	                     <tr>
	                     	<th>펀드명</th>
	                        <td>
	                        	<input type="text" value="${dto.f_title}" id="f_title" name="f_title">
	                        </td>
	                     </tr>
	                     
	                     <tr>
	                     	<th>회원아이디</th>
	                        <td>
	                        	<input type="text" value="${dto.id}" id="id" name="id">
	                        </td>
	                     </tr>
	                     
	                     <tr>
	                        <th >펀드상품이미지</th>
	                        <td>
	                        	<img src="${dto.f_filename}" width="300px" id="imgsrc">
	                        </td>
	                     </tr> 
	                     
	                     <tr>
	                     	<td></td>
	                        <td>
	                        	<input type="file" name="f_filename" id="f_filename" size="10" value="${dto.f_filename}" placeholder="이미지 입력" accept="image/*">
	                        </td>
                    	</tr> 
	                     
	                     <tr>
	                     	<th>펀드내용</th>
	                        <%-- <td><textarea rows="5" cols= 50 placeholder="상세 설명 입력" value="${dto.f_content}"></textarea></td> --%>
	                        <td><input type="text" value="${dto.f_content}" id="f_content" name="f_content"></td>
	                     </tr>
	                      
	                      <tr>
	                        <th>펀딩시작일</th>
	                        <td>
	                        	<input type="date" value="${dto.f_start_date}" id="f_start_date" name="f_start_date">
	                        </td>
	                      </tr>
	                    
	                  
	                     <tr>
	                        <th>펀딩종료일</th>
	                        <td>
	                        	<input type="date" value="${dto.f_end_date}" id="f_end_date" name="f_end_date">
	                        </td>
	                     </tr>
	                     
	                     <tr>
							<th>목표금액</th>
							<td><input type="number" value="${dto.f_target_money}" id="f_target_money" name="f_target_money"></td>
						</tr>
	                     
	                     <tr>
	                        <th>모금계좌</th>
							<td><input type="text" value="${dto.f_account}" id="f_account" name="f_account"></td>
	                     </tr>
	                     
	                     <tr>
		                     <th>펀드종목</th>
		                     <td><input type="text" value="${dto.f_category}" id="f_category" name="f_category"></td>
	                     </tr>
	                     
	                     <tr>
		                     <th>등록자이름</th>
		                     <td><input type="text" value="${dto.f_name}" id="f_name" name="f_name"></td>
	                     </tr>
	                     
	                     <tr>
		                     <th>등록자연락처</th>
		                     <td><input type="text" value="${dto.f_phone}" id="f_phone" name="f_phone"></td>
	                     </tr>
	                     
	                     <tr>
		                     <th>등록자이메일</th>
		                     <td><input type="text" value="${dto.f_email}" id="f_email" name="f_email"></td>
	                     </tr>
	                                    
	                    <tr align="center">
                           <th colspan="2">
							 <!-- <a href="#" class="btn btn-primary btn-icon-split btn-sm">
                                 <span class="text">수정</span>
                             </a>
                                   
                             <a href="#" class="btn btn-primary btn-icon-split btn-sm">
                                 <span class="text">삭제</span>
                             </a> -->
                             <input type="submit"  value="수정" id="btnEdit"> 
                           	 <input type="button" id="btndel" value="삭제" onclick="window.location='${path}/fund_delete.ad?f_num=${dto.f_num}&pageNum=${paging.pageNum}'">
                             <input type="hidden" name="hiddenf_num" value="${dto.f_num}">
             				 <input type="hidden" name="pageNum" value="${pageNum}">
              	    		 <input type="hidden" name="hiddenf_filename" value="${dto.f_filename}">
							</th> 
	                    </tr>                       
	                 </table>
	                 </form>
	               </div>
	           </div>
	         </div>
	       </div>
		</div>
		</div>
			<!-- Footer -->
	       <%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</div>
	</div>
</body>
</html>