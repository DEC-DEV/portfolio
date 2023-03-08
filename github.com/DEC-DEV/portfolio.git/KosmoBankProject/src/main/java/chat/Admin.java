package chat;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/admin")
public class Admin {
	  private static Session admin = null;
	  // 운영자 유저가 접속을 하면 발생하는 이벤트 함수
	  @OnOpen
	  public void handleOpen(Session userSession) {
	    // 기존에 운영자 유저의 소켓이 접속중
	    if (admin != null) {
	      try {
	        admin.close();
	      } catch (IOException e) {

	      }
	    }
	    admin = userSession;
	    for(String key : BroadSocket.getUserKeys()) {
	      visit(key);
	    }
	  }
	  // 운영자 유저가 메시지를 보내면 발생하는 이벤트
	  @OnMessage
	  public void handleMessage(String message, Session userSession) throws IOException {
	    String[] split = message.split("#####", 2);
	    String key = split[0];
	    String msg = split[1];
	    BroadSocket.sendMessage(key, msg);
	  }

	  // 접속이 끊기면 위 운영자 세션을 null 처리한다.
	  @OnClose
	  public void handleClose(Session userSession) {
	    admin = null;
	  }
	  // 운영자 유저로 메시지를 보내는 함수
	  private static void send(String message) {
	    if (admin != null) {
	      try {
	        admin.getBasicRemote().sendText(message);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	  // 일반 유저가 접속했을 때, 운영자 유저에게 알리는 함수
	  public static void visit(String key) {
	    send("{\"status\":\"visit\", \"key\":\"" + key + "\"}");
	  }
	  // 일반 유저가 메시지를 보낼 때, 운영자 유저에게 알리는 함수
	  public static void sendMessage(String key, String message) {
	    send("{\"status\":\"message\", \"key\":\"" + key + "\", \"message\":\"" + message + "\"}");
	  }
	  // 일반 유저가 접속을 끊을 때, 운영자 유저에게 알리는 함수
	  public static void bye(String key) {
	    send("{\"status\":\"bye\", \"key\":\"" + key + "\"}");
	  }
}
