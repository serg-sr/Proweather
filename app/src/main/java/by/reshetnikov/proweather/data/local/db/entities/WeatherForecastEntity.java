package by.reshetnikov.proweather.data.local.db.entities;


import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;

@Entity(active = true)
public class WeatherForecastEntity {
    @Id(autoincrement = true)
    private long Id;
    @Index
    @NotNull
    private String cityId;
    private double temperature;
    private int humidity;
    private int pressure;
    private double windSpeed;
    private double windDegrees;
    @Unique
    private Date date;
    private int weatherConditionId;
    private String weatherMain;
    private String weatherDescription;
    private String iconCode;
    private double snow;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 196281143)
    private transient WeatherForecastEntityDao myDao;

    @Generated(hash = 1749487465)
    public WeatherForecastEntity(long Id, @NotNull String cityId,
                                 double temperature, int humidity, int pressure, double windSpeed,
                                 double windDegrees, Date date, int weatherConditionId,
                                 String weatherMain, String weatherDescription, String iconCode,
                                 double snow) {
        this.Id = Id;
        this.cityId = cityId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
        this.date = date;
        this.weatherConditionId = weatherConditionId;
        this.weatherMain = weatherMain;
        this.weatherDescription = weatherDescription;
        this.iconCode = iconCode;
        this.snow = snow;
    }

    @Generated(hash = 629385542)
    public WeatherForecastEntity() {
    }

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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

    public double getWindDegrees() {
        return this.windDegrees;
    }

    public void setWindDegrees(double windDegrees) {
        this.windDegrees = windDegrees;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWeatherConditionId() {
        return this.weatherConditionId;
    }

    public void setWeatherConditionId(int weatherConditionId) {
        this.weatherConditionId = weatherConditionId;
    }

    public String getWeatherMain() {
        return this.weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return this.weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getIconCode() {
        return this.iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public double getSnow() {
        return this.snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1787193760)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWeatherForecastEntityDao()
                : null;
    }
}
