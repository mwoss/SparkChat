import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;

/**
 * Created by Matthew on 2017-01-13.
 */
public class Main { // przenisc do klasy chat

    public static void main(String[] args) {
        Map<String,IChannel> channelMap = new ConcurrentHashMap<>();
        String mainChannelName = "MainChannel";
        channelMap.put(mainChannelName, new MainChannel());
        channelMap.put("MooBot", new BotChannel());
        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
        webSocket("/chat", ChatWebSocketHandler.class);
        init();
    }
}
