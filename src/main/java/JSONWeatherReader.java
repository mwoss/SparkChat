import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Matthew on 2017-01-20.
 */
public class JSONWeatherReader {
    //using openweather api to get info about weather
    //using gson to store data to weatherinfo and weathertemp by serializeddata
    private JsonElement data;
    public Weather weather;
    private final String apiKey = "83d28b738b2ea179816e95b1d46572af";

    public JSONWeatherReader(String cityName){
        String weatherURL = urlLink(cityName);
        HttpURLConnection request = openHttpURLConnection(weatherURL);

        JsonParser jsonParser = new JsonParser();
        JsonElement root = null;
        try{
            root = jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
        }catch (IOException e){
            System.err.println("Gson or json data error");
        }
        this.data = root;
        this.weather = getWeatherDiscription(cityName);

    }
    public Weather getWeatherDiscription(String cityName){
        Gson dataRead = new Gson();
        JsonElement weather = data.getAsJsonObject().get("weather").getAsJsonArray().get(0);
        JsonElement temperature = data.getAsJsonObject().get("main");

        SerializedWeatherInfo weatherInfo = dataRead.fromJson(weather,SerializedWeatherInfo.class);
        SerializedWeatherTemp weatherTemp = dataRead.fromJson(temperature,SerializedWeatherTemp.class);

        return new Weather(cityName, weatherInfo.description, weatherTemp.temp, weatherTemp.pressure, weatherTemp.humidity);
    }
    private String urlLink(String cityName){
        String result="http://api.openweathermap.org/data/2.5/weather?q=";
        result += cityName;
        result += "&appid=" + this.apiKey;
        return result;
    }
    private HttpURLConnection openHttpURLConnection(String str) {
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
