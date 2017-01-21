/**
 * Created by Matthew on 2017-01-20.
 */
public class Weather {
    //here gonna be stored refactored data ftom json aobut weather
    //useing api from online forcast to show actaul weather
    public String cityName;
    public String info;
    public String temp;
    public String pressure;
    public String humidity;

    public Weather(String city, String info, String temp, String ps, String hmt){
        this.cityName = city;
        this.info = info;
        this.temp = temp;
        this.pressure = ps;
        this.humidity = hmt;
    }

    @Override
    public String toString(){
        return "Actual weather in " + this.cityName +
                " description: " + this.info +
                " | temperature: " + this.temp +
                " | pressure: " + this.pressure +
                " | humidity: " + this.humidity;
    }
}

