import org.eclipse.jetty.websocket.api.Session;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Matthew on 2017-01-13.
 */
public class BotChannel extends Channel {
    // bot channel
    //givin certain info after typin command preceded by slash
    //all commend by type /help
    public BotChannel(){
        super("ChannelBot");
    }
    private String getActualTime(){
        String timeStamp = new SimpleDateFormat("HHmmss")
                .format(Calendar.getInstance().getTime());
        return "Actual time: " + timeStamp;
    }
    private String getActualData(){
        String dataStamp = new SimpleDateFormat("yyyyMMdd")
                .format(Calendar.getInstance().getTime());
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH)
                .format(Calendar.getInstance().getTime());
        return "Today is " + dayOfWeek + " " + dataStamp;
    }
    private String botResponde(String msg){
        String data = msg.trim();
        switch(data){
            case "/help":
                return "Available commends:\n" +
                        "/time - return actual time\n" +
                        "/date - return actual date\n" +
                        "/weather [City Name] - return short weather info about city of your choice";
            case "/time":
                return getActualTime();
            case "/date":
                return getActualData();
            case "greeting":
                return "Hello. I am moobot. To ask me for something use available commands. You might see all by write down \"/help\" in chat";
            default:
                if(data.substring(0,8).equals("/weather")){
                    String city = data.substring(8);
                    JSONWeatherReader weather = new JSONWeatherReader(city);
                    return weather.weather.toString();
                }
                return "Unknown command, write /help to get all available options";
        }

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

    private void botMessage(Session session, String message){

    }

    private void broadcastMessage(String sender, String msg, Session session){

    }
}
