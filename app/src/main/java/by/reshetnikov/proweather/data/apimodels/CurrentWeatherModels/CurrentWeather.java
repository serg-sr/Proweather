package by.reshetnikov.proweather.data.apimodels.CurrentWeatherModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.reshetnikov.proweather.data.apimodels.Clouds;
import by.reshetnikov.proweather.data.apimodels.Coordinates;
import by.reshetnikov.proweather.data.apimodels.Main;
import by.reshetnikov.proweather.data.apimodels.Rain;
import by.reshetnikov.proweather.data.apimodels.Snow;
import by.reshetnikov.proweather.data.apimodels.Sys;
import by.reshetnikov.proweather.data.apimodels.Weather;
import by.reshetnikov.proweather.data.apimodels.Wind;

public class CurrentWeather {

    @SerializedName("coord")
    @Expose
    public Coordinates coordinates;

    @SerializedName("weather")
    @Expose
    public List<Weather> weather;

    @SerializedName("main")
    @Expose
    public Main main;

    @SerializedName("wind")
    @Expose
    public Wind wind;

    @SerializedName("clouds")
    @Expose
    public Clouds clouds;

    @SerializedName("rain")
    @Expose
    public Rain rain;

    @SerializedName("snow")
    @Expose
    public Snow snow;

    //  Time of data calculation, unix, UTC
    @SerializedName("dt")
    @Expose
    public int dt;

    @SerializedName("sys")
    @Expose
    public Sys sys;

    // City ID
    @SerializedName("id")
    @Expose
    public int id;

    // City name
    @SerializedName("name")
    @Expose
    public String name;
}