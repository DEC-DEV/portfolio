<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmoBank</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500&family=Roboto:wght@400;500;700&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="customer/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path }/resources/customer/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${path }/resources/customer/css/style.css" rel="stylesheet">
    
    <!-- select Stylesheet -->
    <link href="${path }/resources/customer/css/join.css" rel="stylesheet">
    <style>
    #header{
    background-color: #4e73df;
    float: left;
    width: 100%;
    height: 200px;
    
    }
    
    #title{
    color: white;
    margin-left:50px;
    vertical-align: middle;
    font-size: 35;
    }
    
    #title2{
    margin-left:120px;
    font-size: 20px;
    color:black;
    
    
    }
    
    #hr{
     margin-left:120px;
     size:"2";  
     color:"gray";   
     
    }
    th {
  	color: #333;
  	}
  th,td {
  padding-bottom: 15px;
  }
    
  
</style>

<script>
// ???????????? ?????? ?????????
$(function(){
	$("#btnSearch").click(function(){
		select_limit();
	});
});

//?????? ????????? ????????? ????????????  
function select_limit() {
	 var value = $("#accountList option:selected").val();
  $.ajax({
     type: "POST",
     url: "${path}/savings_add_paid2.do?${_csrf.parameterName}=${_csrf.token}",
     data: "account_num=" + value,
     success: function(result) {
        $('#list').html(result);
     },
     error: function(error) {
        alert('select_limit - ??????');
     }
  });
  document.getElementById('account').value = value;
}

// ????????????????????????
$(function(){
	$("#btnPay").click(function(){
		 if ( ($("#addMoney").val()) > (document.getElementById("i_summary").value/ 10)) {
			 swal('\???????????? ?????? ?????? ????????? ! \n\n?????? ?????? ????????????????????? 10%  ?????? ???????????? ???????????????. ',{
				 icon: "error"
			 });

		// ???????????? ????????????	
		 } else {
			 document.mainform.action="${path}/savings_add_paidAction.do?${_csrf.parameterName}=${_csrf.token}";
			 document.mainform.submit();
		 }
		 console.log('??????:',document.getElementById('i_summary').value/10);
	});
});
</script>
    
</head>

<body style="background:#fff;">
    <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar & Hero Start -->
        <div class="container-xxl position-relative p-0">
           <%@ include file="/WEB-INF/views/common/customer/header.jsp" %>
        <!-- Navbar & Hero End -->


        <!-- Full Screen Search Start -->
        <div class="modal fade" id="searchModal" tabindex="-1">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" style="background: rgba(29, 29, 39, 0.7);">
                    <div class="modal-header border-0">
                        <button type="button" class="btn bg-white btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center justify-content-center">
                        <div class="input-group" style="max-width: 600px;">
                            <input type="text" class="form-control bg-transparent border-light p-3" placeholder="Type search keyword">
                            <button class="btn btn-light px-4"><i class="bi bi-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	<form method="post" name="mainform">
		<!-- ?????? ????????? ?????? -->
         <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
             <h6 class="position-relative d-inline text-primary ps-4"> KosmosBank</h6>
             <h2 class="mt-2"> ?????????????????? </h2>
             	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
         </div>

		<div id="title2">?????? ?????? ??????</div>
		<hr id="hr" width="80%" />
		<table id="table" align="center" width="50%">
			<tr>
				<th width="300px">????????????</th>
				<td style="display:flex;">
					<select name="accountList" id="accountList" class="form-select">
					   <c:forEach var="item" items="${list}">
					      <option value="${item.account_num}">
					       		${item.account_num}
					      </option>
				       </c:forEach>
				    </select>
				    <input type="button" value="????????????" id="btnSearch" class="btn" style="background:#fce08b;color:#333;margin-left:10px;"> 
				    <%--  <input type="hidden" name="account_num" value="${list.account_num}"> --%>
				</td>
			</tr>
		</table>
		
		<!-- aJAx????????? -->
		<div id="list"></div>
			
		<table id="table" align="center" width="50%">
			<tr>
				<th width="300px">?????? ????????????</th>
				<td><input type="number" name="addMoney" id="addMoney" class="form-control" value=""></td>

			</tr>
			<tr>
				<th width="300px">?????? ????????????</th>
				<td><input type="password" name="account_password" class="form-control" placeholder="????????????" maxlength="4"></td>
			</tr>
		</table>
		<input type="hidden" name="account_num" id="account" class="form-control" value="">	

		<div align="center">
			<input type="button" value="????????????" id="btnPay" class="btn fw-bold" style="background:#d3dbf1;color:#0b7bed;">
			<input type="reset" value="??????" class="btn fw-bold" style="background:#ecd8d6;color:#e90101;">
		</div>
      </form>                          
		<!-- ?????? ????????? ??? -->
		
 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
</body>

</html>