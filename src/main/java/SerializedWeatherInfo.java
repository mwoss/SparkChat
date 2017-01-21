import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthew on 2017-01-20.
 */
public class SerializedWeatherInfo {
    @SerializedName("id")
    public int id;

    @SerializedName("main")
    public String main;

    @SerializedName("description")
    public String description;

    @SerializedName("icon")
    public String iconLink;
}
