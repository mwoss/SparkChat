import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Matthew on 2017-01-13.
 */
public class UserChannel extends Channel{
    //chanel craeted by user
    public UserChannel(String userNameChannel){
        super(userNameChannel);
    }
    @Override
    public void addUser(Session session, User user){
        super.addUser(session,user);
        this.serverMessage(user.nickName + " joined the channel");

    }
    @Override
    public void broadcastMessage(Session session, String message) {
        String sender = this.searchUser(session).nickName;
        this.broadcastMessage(sender,message);
    }

    private void serverMessage(String message){
        this.broadcastMessage("Server",message);
    }

    private void broadcastMessage(String sender, String msg){
        this.users.keySet().stream().filter(Session::isOpen).forEach(x -> {
            try{
                x.getRemote()
                        .sendString(String.valueOf(new JSONObject()
                                .put("userMessage",this.createHtmlMessageFromSender(sender,msg))
                                .put("userList",this.users.values())));

            }catch(IOException | JSONException e){
                System.err.println("Problem with getRemote or JSON object");
            }
        });
    }
    @Override
    public User removeUser(Session session){
        User user = super.removeUser(session);
        this.serverMessage(user.nickName + " left channel");
        return user;
    }

}
