import org.eclipse.jetty.websocket.api.Session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static j2html.TagCreator.*;

/**
 * Created by Matthew on 2017-01-13.
 */
public class Channel implements IChannel{
    private final String channelName;
    Map<Session,User> users = new ConcurrentHashMap<>();

    public Channel(String channelName){
        this.channelName = channelName;
    }

    //Builds a HTML element with a sender-name, a message, and a timestamp,
    public String createHtmlMessageFromSender(String sender, String message) {
        return article().with(
                b(sender + " says:"),
                p(message),
                span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
        ).render();
    }
    @Override
    public void addUser(Session session, User user) {
        this.users.put(session,user);
    }

    @Override
    public User removeUser(Session session) {
        User user = searchUser(session);
        this.users.remove(session);
        return user;

    }

    @Override
    public boolean isExistUser(Session session) {
        return this.users.containsKey(session);
    }

    @Override
    public User searchUser(Session session){
        return this.users.get(session);
    }

    @Override
    public void broadcastMessage(Session session, String message) {

    }

    @Override
    public boolean removalPermission() {
        return this.users.isEmpty();
    }

    public String chName(){
        return this.channelName;
    }

    @Override
    public String toString(){
        return this.channelName;
    }

}
