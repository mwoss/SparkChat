import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Matthew on 2017-01-20.
 */
public class JSONWatherReader {

    //using openweather api to get info about weather
    //using gson to store data to weatherinfo and weathertemp by serializeddata
    private static HttpURLConnection openHttpURLConnection(String str) {
        try {
            URL test = new URL(str);
            HttpURLConnection request = (HttpURLConnection) test.openConnection();
            request.connect();
            return request;
        } catch (IOException e) {
            System.out.println("JSON error");
        }
        return null;
    }
}
