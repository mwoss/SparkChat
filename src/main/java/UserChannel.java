import org.eclipse.jetty.websocket.api.Session;

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

    }
    @Override
    public boolean removalPermission(){
        return false;
    }
    @Override
    public void broadcastMessage(Session session, String message) {

    }

    private void serverMessage(Session session, String message){

    }

    private void broadcastMessage(String sender, String msg, Session session){

    }

}
