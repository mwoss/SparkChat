import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;

/**
 * Created by Matthew on 2017-01-13.
 */
public class Main { // przenisc do klasy chat
    public static Map<String,IChannel> channelMap = new ConcurrentHashMap<>();
    public static String mainChannelName = "MainChannel";
    public static void main(String[] args) {
        channelMap.put(mainChannelName, new MainChannel());
        channelMap.put("MooBot", new BotChannel());
        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
        webSocket("/chat", ChatWebSocketHandler.class);
        init();
    }
}
