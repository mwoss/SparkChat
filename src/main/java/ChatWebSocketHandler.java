import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

@WebSocket
public class ChatWebSocketHandler {

    Chat newChat = new Chat();
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        this.newChat.onConnectSession(session);
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        this.newChat.onCloseSession(session);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) {
        this.newChat.onMessageSession(session,message);
    }

}
