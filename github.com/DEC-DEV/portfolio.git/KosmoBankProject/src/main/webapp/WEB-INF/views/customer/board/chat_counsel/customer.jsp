<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html lang="en">
<!-- 김현우 -->
<head>
    <meta charset="utf-8">
    <title>상담글 리스트 조회</title>
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
    <link href="${path }/resources/customer/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="${path }/resources/customer/lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path }/resources/customer/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${path }/resources/customer/css/style.css" rel="stylesheet">
<script type="text/javascript">
    // 서버의 broadsocket의 서블릿으로 웹 소켓을 한다.
    <c:set var="id" value="${customerID}" />
    
    var id = '<c:out value="${id}"/>';
    
    var webSocket = new WebSocket("ws://192.168.219.101:8088/bank/broadsocket");
    // 콘솔 텍스트 영역
    var messageTextArea = document.getElementById("messageTextArea");
    // 접속이 완료되면
    webSocket.onopen = function(message) {
      // 콘솔에 메시지를 남긴다.
      document.getElementById("messageTextArea").value += "Server connect...\n";
    };
    // 접속이 끝기는 경우는 브라우저를 닫는 경우이기 떄문에 이 이벤트는 의미가 없음.
    webSocket.onclose = function(message) { };
    // 에러가 발생하면
    webSocket.onerror = function(message) {
      // 콘솔에 메시지를 남긴다.
      document.getElementById("messageTextArea").value += "error...\n";
    };
    // 서버로부터 메시지가 도착하면 콘솔 화면에 메시지를 남긴다.
    webSocket.onmessage = function(message) {
    document.getElementById("messageTextArea").value += "(관리자) => " + message.data + "\n";
    document.getElementById("messageTextArea").scrollTop = document.getElementById("messageTextArea").scrollHeight;
    };
    // 서버로 메시지를 발송하는 함수
    // Send 버튼을 누르거나 텍스트 박스에서 엔터를 치면 실행
    function sendMessage() {
      // 텍스트 박스의 객체를 가져옴
      let message = document.getElementById("textMessage");
      // 콘솔에 메세지를 남긴다.
      document.getElementById("messageTextArea").value += id + " => " + message.value + "\n";
      // 소켓으로 보낸다.
      webSocket.send(id + " : " + message.value);
      // 텍스트 박스 추기화
      message.value = "";
      document.getElementById("messageTextArea").scrollTop = document.getElementById("messageTextArea").scrollHeight;
    }
    // 텍스트 박스에서 엔터를 누르면
    function enter() {
      // keyCode 13은 엔터이다.
      if(event.keyCode === 13) {
        // 서버로 메시지 전송
        sendMessage();
        // form에 의해 자동 submit을 막는다.
        return false;
      }
      return true;
    }
</script>    
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


        <!-- header 시작 -->
		<%@ include file ="/WEB-INF/views/common/customer/header.jsp" %>
		<!-- header 끝 -->


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


        <!-- Contact Start -->
        <div class="container-xxl py-5">
            <div class="container px-lg-5" style="max-width:100%">
                <div class="row justify-content-center">
                    <div class="col-lg-7" style="padding-top:80">
                        <div class="section-title position-relative text-center mb-5 pb-2 wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="position-relative d-inline text-primary ps-4">Kosmos Bank</h6>
                            <h2 class="mt-2">채팅 상담</h2>
                        </div>
                        <div class="wow fadeInUp" data-wow-delay="0.3s">
							<div class="wrap" align="center">
							  <!-- 채팅 영역 -->
							  <!-- 서버와 메시지를 주고 받는 콘솔 텍스트 영역 -->
							  <textarea id="messageTextArea" rows="10" cols="50" disabled="disabled"></textarea>
							  <br />
							  <form>
							    <!-- 텍스트 박스에 채팅의 내용을 작성한다. -->
							    <input id="textMessage" type="text" onkeydown="return enter()">
							    <!-- 서버로 메시지를 전송하는 버튼 -->
							    <input onclick="sendMessage()" value="Send" type="button">
							  </form>
							<!-- 메인 컨텐츠 끝 -->
							
							</div>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact End -->
        

        <!-- Footer Start -->
        <%@ include file ="/WEB-INF/views/common/customer/footer.jsp" %>
        <!-- Footer End -->
		

        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up"></i></a>
    </div>
    

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${path }/resources/customer/lib/wow/wow.min.js"></script>
    <script src="${path }/resources/customer/lib/easing/easing.min.js"></script>
    <script src="${path }/resources/customer/lib/waypoints/waypoints.min.js"></script>
    <script src="${path }/resources/customer/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="${path }/resources/customer/lib/isotope/isotope.pkgd.min.js"></script>
    <script src="${path }/resources/customer/lib/lightbox/js/lightbox.min.js"></script>

    <!-- Template Javascript -->
    <script src="${path }/resources/customer/js/main.js"></script>
</body>

</html>