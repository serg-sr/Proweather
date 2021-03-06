package by.reshetnikov.proweather.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by s-reshetnikov.
 */
@Entity
public class DailyForecastEntity {

    @Id
    private Long date;
    private int locationId;
    private int minTemperature;
    private int maxTemperature;
    private int humidity;
    private int pressure;
    private double windSpeed;
    private int windDegrees;
    private int weatherConditionId;
    private int morningTemperature;
    private int dayTemperature;
    private int eveningTemperature;
    private int nightTemperature;

    @Generated(hash = 1289438299)
    public DailyForecastEntity(Long date, int locationId, int minTemperature,
                               int maxTemperature, int humidity, int pressure, double windSpeed,
                               int windDegrees, int weatherConditionId, int morningTemperature,
                               int dayTemperature, int eveningTemperature, int nightTemperature) {
        this.date = date;
        this.locationId = locationId;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
        this.weatherConditionId = weatherConditionId;
        this.morningTemperature = morningTemperature;
        this.dayTemperature = dayTemperature;
        this.eveningTemperature = eveningTemperature;
        this.nightTemperature = nightTemperature;
    }

    @Generated(hash = 994273881)
    public DailyForecastEntity() {
    }

    public int getLocationId() {
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Long getDate() {
        return this.date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return this.pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDegrees() {
        return this.windDegrees;
    }

    public void setWindDegrees(int windDegrees) {
        this.windDegrees = windDegrees;
    }

    public int getWeatherConditionId() {
        return this.weatherConditionId;
    }

    public void setWeatherConditionId(int weatherConditionId) {
        this.weatherConditionId = weatherConditionId;
    }

    public int getMorningTemperature() {
        return this.morningTemperature;
    }

    public void setMorningTemperature(int morningTemperature) {
        this.morningTemperature = morningTemperature;
    }

    public int getDayTemperature() {
        return this.dayTemperature;
    }

    public void setDayTemperature(int dayTemperature) {
        this.dayTemperature = dayTemperature;
    }

    public int getEveningTemperature() {
        return this.eveningTemperature;
    }

    public void setEveningTemperature(int eveningTemperature) {
        this.eveningTemperature = eveningTemperature;
    }

    public int getNightTemperature() {
        return this.nightTemperature;
    }

    public void setNightTemperature(int nightTemperature) {
        this.nightTemperature = nightTemperature;
    }
}