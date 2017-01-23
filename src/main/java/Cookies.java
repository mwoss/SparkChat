import java.net.HttpCookie;
import java.util.List;

/**
 * Created by Matthew on 2017-01-22.
 */
public class Cookies {

    String iterOverCookiesAndFind(List<HttpCookie> cookies, String name){
        for(HttpCookie iter : cookies){
            if(iter.getName().equals(name))
                return iter.getValue();
        }
        return "";
    }
    String getNickName(List<HttpCookie> cookies){
        return this.iterOverCookiesAndFind(cookies,"username");
    }
    String getChannelName(List<HttpCookie> cookies){
        return this.iterOverCookiesAndFind(cookies,"channelName");
    }
}
