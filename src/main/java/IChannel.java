import org.eclipse.jetty.websocket.api.Session;

/**
 * Created by Matthew on 2017-01-22.
 */
public interface IChannel {
    void addUser(Session session, User user);
    User removeUser(Session session);
    boolean isExistUser(Session session);
    void broadcastMessage(Session session, String message);
    User searchUser(Session session);
    boolean removalPermission();
}
