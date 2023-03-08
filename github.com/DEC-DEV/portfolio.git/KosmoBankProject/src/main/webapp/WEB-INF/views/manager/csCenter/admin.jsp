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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script type="text/javascript">
    // 서버의 admin의 서블릿으로 웹 소켓을 한다.
    var webSocket = new WebSocket("ws://192.168.219.101:8088/bank/admin");
    // 운영자에서의 open, close, error는 의미가 없어서 형태만 선언
    webSocket.onopen = function(message) { };
    webSocket.onclose = function(message) { };
    webSocket.onerror = function(message) { };
    // 서버로 부터 메시지가 오면
    webSocket.onmessage = function(message) {
      // 메시지의 구조는 JSON 형태로 만들었다.
      let node = JSON.parse(message.data);
      // 메시지의 status는 유저의 접속 형태이다.
      // visit은 유저가 접속했을 때 알리는 메시지다.
      if(node.status === "visit") {
        // 위 템플릿 div를 취득한다.
        let form = $(".template").html();
        // div를 감싸고 속성 data-key에 unique키를 넣는다.
        form = $("<div class='float-left'></div>").attr("data-key",node.key).append(form); 
        // body에 추가한다.
        $("#area").prepend(form);
      // message는 유저가 메시지를 보낼 때 알려주는 메시지이다.
      } else if(node.status === "message") {
        // key로 해당 div영역을 찾는다.
        let $div = $("[data-key='"+node.key+"']");
        // console영역을 찾는다.
        let log = $div.find(".console").val();
        // 아래에 메시지를 추가한다.
        $div.find(".console").val(log + node.message + "\n");
        var sd = $div.find(".console").prop('scrollHeight');
        $div.find(".console").scrollTop(sd);

      // bye는 유저가 접속을 끊었을 때 알려주는 메시지이다.
      } else if(node.status === "bye") {
        // 해당 키로 div를 찾아서 dom을 제거한다.
        $("[data-key='"+node.key+"']").remove();
      }
    };
    // 전송 버튼을 클릭하면 발생하는 이벤트
    $(document).on("click", ".sendBtn", function(){
      // div 태그를 찾는다.
      let $div = $(this).closest(".float-left");
      // 메시지 텍스트 박스를 찾아서 값을 취득한다.
      let message = $div.find(".message").val();
      // 유저 key를 취득한다.
      let key = $div.data("key");
      // console영역을 찾는다.
      let log = $div.find(".console").val();
      // 아래에 메시지를 추가한다.
      $div.find(".console").val(log + "(me) => " + message + "\n");
      var sd = $div.find(".console").prop('scrollHeight');
      $div.find(".console").scrollTop(sd);
      
      // 텍스트 박스의 값을 초기화 한다.
      $div.find(".message").val("");
      // 웹소켓으로 메시지를 보낸다.
      webSocket.send(key+"#####"+message);
    });
    // 텍스트 박스에서 엔터키를 누르면
    $(document).on("keydown", ".message", function(){
      // keyCode 13은 엔터이다.
      if(event.keyCode === 13) {
        // 버튼을 클릭하는 트리거를 발생한다.
        $(this).closest(".float-left").find(".sendBtn").trigger("click");
        // form에 의해 자동 submit을 막는다.
        return false;
      }
      return true;
    });
  </script>
  
<style>
  /* 여러 채팅창 간의 간격과 배열 위치*/
  .float-left{
    float:left;
    margin: 5px;
  }
</style>    
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
			       	<h1 class="h3 mb-2 text-gray-800" style="padding-top: 50">채팅상담</h1>
		       		
					<!-- DataTales Example -->
	              	<div class="card shadow mb-4">
	              		<div class="card-header py-3">
	                    	<h6 class="m-0 font-weight-bold text-primary">채팅방</h6>
						</div>
	                  	<div class="card-body">
	                      	<div class="wrap">
								<!-- 메인 컨텐츠 시작 -->
								<div class="area" id=area>
								</div>
								<!-- 유저가 접속할 때마다 이 템플릿으로 채팅창을 생성한다. -->
								<div class="template" style="display:none">
								    <!-- 서버와 메시지를 주고 받는 콘솔 텍스트 영역 -->
								    <textarea rows="10" cols="50" class="console" disabled="disabled"></textarea>
								    <br />
								    <form>
										<!-- 메시지 텍스트 박스 -->
								      	<input type="text" class="message" onkeydown="if(event.keyCode === 13) return false;">
								      	<!-- 전송 버튼 -->
								      	<input value="Send" type="button" class="sendBtn">
								    </form>
							  	</div>
							<!-- 소스를 간단하게 하기 위하 Jquery를 사용했습니다. -->
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