package by.reshetnikov.proweather.WeatherModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    // Rain volume for the last 3 hours
    @SerializedName("3h")
    @Expose
    public int rainVolume;

}