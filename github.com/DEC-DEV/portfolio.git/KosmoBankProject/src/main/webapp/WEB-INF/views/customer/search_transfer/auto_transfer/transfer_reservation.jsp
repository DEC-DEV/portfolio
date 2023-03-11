<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>KosmosBank </title>
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
    <link href="${path}/customerlib/animate/animate.min.css" rel="stylesheet">
    <link href="${path}/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path}/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path}/resources/customer/css/bootstrap.min.css" rel="stylesheet">
    <!-- Template Stylesheet -->
    <link href="${path}/resources/customer/css/style.css" rel="stylesheet">
    <!-- select Stylesheet -->
    <link href="${path}/resources/customer/css/join.css" rel="stylesheet">
    <!-- google calender css, js -->
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/locales-all.min.js'></script>
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/main.min.js'></script>
	<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/main.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/LICENSE.txt" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/package.json" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/README.md" rel="stylesheet">
     <!-- google calender css, js -->
    <script>
     document.addEventListener('DOMContentLoaded', function () {
            $(function () {
                var request = $.ajax({
                	type:'GET',
                    url: '${path}/trasnfer_ajax.do', 
            		contentType:'application/json; charset=UTF-8',
                    dataType: 'json'
                });
                
                request.done(function(data) {
                console.log(data); 
                    var calendarEl = document.getElementById('calendar');
                    var calendar = new FullCalendar.Calendar(calendarEl, {
                        initialDate: '2022-05-09',
                        initialView: 'dayGridMonth',
                      
                        headerToolbar: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'dayGridMonth,timeGridWeek'
                        },
                        editable: true,	//수정
                        selectable: true, //선택
                        droppable: true,  //드래그
                        nowIndicator:true,
                        drop: function (arg) {
                         	//drag function
                            if (document.getElementById('drop-remove').checked) {
                                arg.draggedEl.parentNode.removeChild(arg.draggedEl);
                            }
                        },
                     
                        events: data
                    });
                    calendar.render();
                });
                request.fail(function( jqXHR, textStatus ) {
                    alert( "Request failed: " + textStatus );
                });
            });
        });
     </script>
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
  	#calendar{
  	width:60%;
  	margin:20px auto;
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
      </div>
        <!-- Full Screen Search End -->
       	<!-- UserLoginFailureHandler 에서 msg 넘김 -->
		<c:if test="${errorMsg != null}">
			<script type="text/javascript">
				alert("${errorMsg}");
			</script>
		</c:if>
		<!-- 메인 컨텐츠 시작 -->
	      <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s" style="padding-top:100px">
                   <h6 class="position-relative d-inline text-primary ps-4"> KosmosBank</h6>
                   <h2 class="mt-2"> 자동이체확인 </h2>
                   	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
          </div>
		<!-- main Calender 시작 -->
			<div id='calendar'>
			</div>
		<!-- 메인 컨텐츠 끝 -->
 		<%@ include file="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
</body>

</html>