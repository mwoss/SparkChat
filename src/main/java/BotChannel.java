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
    private String getHour(){
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
    private String botResponde(){
        return null;
    }
}
