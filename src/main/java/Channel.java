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
    private String channelName;
    Map<Session,User> users = new ConcurrentHashMap<>();

    public Channel(String channelName){
        this.channelName = channelName;
    }

    //Builds a HTML element with a sender-name, a message, and a timestamp,
    private static String createHtmlMessageFromSender(String sender, String message) {
        return article().with(
                b(sender + " says:"),
                p(message),
                span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
        ).render();
    }
    @Override
    public void addUser(Session session, User user) {

    }

    @Override
    public User removeUser(Session session) {
        return null;
    }

    @Override
    public boolean isExistUser(Session session) {
        return false;
    }

    @Override
    public void broadcastMessage(Session session, String message) {

    }
    @Override
    public User searchUser(Session session){
        return null;
    }
}
