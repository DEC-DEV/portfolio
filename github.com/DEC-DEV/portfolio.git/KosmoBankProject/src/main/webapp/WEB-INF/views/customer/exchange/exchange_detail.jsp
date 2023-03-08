<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmosBank - 환율 정보 </title>
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
    <link href="customerlib/animate/animate.min.css" rel="stylesheet">
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
     noshade;  
     
    }
    
    #table{
    	width:60%;
    	border: 1px solid #c3c3c3;
    	font-size:12pt; 
    	font-family:고딕체;
    }
    
    #table tr, td, th{
    	border: 1px solid #c3c3c3;
    }
  
  	th{
  	background-color: #4E73DF;
  	color:white;
  	}
  	
  	td{
  	color:black;
  	}
  	
  	
    </style>
</head>

<body>
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
        <!-- Full Screen Search End -->
        
       	<!-- UserLoginFailureHandler 에서 msg 넘김 -->
		<c:if test="${errorMsg != null}">
			<script type="text/javascript">
				alert("${errorMsg}");
			</script>
		</c:if>

		<!-- 메인 컨텐츠 시작 -->
		<div class="container-xxl py-5">
            <div class="container px-lg-5">
                <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
                    <h6 class="position-relative d-inline text-primary ps-4"> KosmosBank</h6>
                    <h2 class="mt-2">  환율 정보 </h2>
                </div>
        	</div>
        </div>
		<!-- <div id="header"><br><br><br>
			<div id="title">환율 정보</div>
		</div>
		<br><br><br><br><br><br><br><br><br><br>
		<div id="title2">환율 </div> -->
		<hr id="hr" width="90%"  /><br><br>
		<table id="table" align="center">
			<tr id="tr" align="center">
				<th>통화명</th>
				<th>매매기준율</th>
				<th>사실 때</th>
				<th>파실 때</th>
				<th>보내실 때</th>
				<th>받으실 때</th>
				<th>미화환산율</th>
			</tr >
			<c:forEach var="dto" items="${exchangeList}">
			<tr align="center" height="50">
				<td style="color:navy"><b>${dto.column1}</b></td>
				<td><b>${dto.column2}</b></td>
				<td style="color:red"><b>${dto.column3}</b></td>
				<td style="color:blue"><b>${dto.column4}</b></td>
				<td style="color:red">${dto.column5}</td>
				<td style="color:blue">${dto.column6}</td>
				<td>${dto.column7}</td>
				
			</tr>
			</c:forEach>
		</table>
		
			
		
		</div><br><br><br><br><br><br><br><br><br><br>
                                  
		<!-- 메인 컨텐츠 끝 -->
		
 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
</body>

</html>