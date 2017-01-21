import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthew on 2017-01-20.
 */
public class SerializedWeatherTemp {
    @SerializedName("temp")
    public String temp;

    @SerializedName("pressure")
    public String pressure;

    @SerializedName("humidity")
    public String humidity;

    @SerializedName("temp_min")
    public String tempMin;

    @SerializedName("temp_max")
    public String tempMax;
}
