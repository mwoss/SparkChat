import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.get;
public class Chat {

    private Map<String,IChannel> channelMap = new ConcurrentHashMap<>();
    private Cookies cookies = new Cookies();
    public String mainChannelName = "MainChannel";
    public Chat(){
        createMainChs();
        initChannels();
    }
    private void createMainChs(){
        channelMap.put(mainChannelName, new MainChannel());
        channelMap.put("ChannelBot",new BotChannel());
    }
    private void initChannels(){
        get("/channels", (req, res) -> getChJSON());
    }
    private String getChJSON(){
        try {
            return String.valueOf(new JSONObject().put("channelList", channelMap.values()));
        } catch (JSONException e) {
            System.err.println("Problem with JSON put");
            return "";
        }
    }

    public void onConnectSession(Session session){
        String chName = this.cookies.getChannelName(session.getUpgradeRequest().getCookies());
        String nickName = this.cookies.getNickName(session.getUpgradeRequest().getCookies());
        if(!nickName.isEmpty() && !chName.isEmpty()){
            User user = new User(nickName);
            if(!this.channelMap.containsKey(chName))
                this.channelMap.put(chName,new UserChannel(chName));

            this.channelMap.get(chName).addUser(session,user);
        }
        else{
            session.close();
        }
    }

    public void onCloseSession(Session session){
        this.channelMap.values()
                .stream()
                .filter(var -> var.isExistUser(session))
                .forEach(var ->
                {var.removeUser(session);
                    if(var.removalPermission())
                        this.channelMap.remove(var.toString());
                });
    }

    public void onMessageSession(Session session, String msg){
        this.channelMap.values()
                .stream()
                .filter(var -> var.isExistUser(session))
                .forEach(var -> var.broadcastMessage(session,msg));
    }
}
