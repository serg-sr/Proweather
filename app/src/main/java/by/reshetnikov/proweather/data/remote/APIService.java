package by.reshetnikov.proweather.data.remote;

import java.util.Map;

import by.reshetnikov.proweather.data.models.CurrentWetherModels.CurrentWeather;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface APIService {

    @GET("data/2.5/weather")
    Observable<CurrentWeather> getCurrentWeather(@QueryMap Map<String, String> options);

    @GET("data/2.5/forecast")
    Observable<CurrentWeather> getForecastWeather(@QueryMap Map<String, String> options);

}
