package by.reshetnikov.proweather.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;

import java.util.Calendar;
import java.util.Date;

import by.reshetnikov.proweather.ProWeatherApp;
import by.reshetnikov.proweather.R;

public final class WeatherStateIconUtil {

    private WeatherStateIconUtil() {
    }

    public static Drawable getIcon(int iconCode) {
        return getIcon(iconCode, System.currentTimeMillis());
    }

    public static Drawable getIcon(int iconCode, long dateTime) {
        boolean isDay = isDayTime(dateTime);
        Context context = ProWeatherApp.getAppContext();
        return AppCompatResources.getDrawable(context, getIconCode(iconCode, isDay));
    }

    public static Drawable getIcon(int iconCode, boolean isDay) {
        Context context = ProWeatherApp.getAppContext();
        return AppCompatResources.getDrawable(context, getIconCode(iconCode, isDay));
    }

    private static boolean isDayTime(long dateTime) {
        Date date = new Date(dateTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int startDayHours = 6;
        int startNightHours = 21;
        return calendar.get(Calendar.HOUR_OF_DAY) >= startDayHours && calendar.get(Calendar.HOUR_OF_DAY) < startNightHours;

    }

    // 2xx
    private static int getThunderstormCodes(int iconCode, boolean isDay) {
        return R.drawable.ic_lightning_and_drizzle_cloud;
    }

    // 3xx
    private static int getDrizzleCodes(int iconCode, boolean isDay) {
        return R.drawable.ic_hard_rain;
    }

    // 5xx
    private static int getRainCodes(int iconCode, boolean isDay) {
        if (iconCode == 500)
            return R.drawable.ic_rain_and_cloud;
        if (iconCode >= 501 && iconCode <= 504) {
            if (isDay)
                return R.drawable.ic_sun_and_cloud_with_rain;
            return R.drawable.ic_rainy_cloud_and_moon_24dp;
        }
        if (iconCode == 511)
            return R.drawable.ic_hardrain_cloud;
        if (iconCode >= 520)
            return R.drawable.ic_hard_rain;
        return R.drawable.ic_hard_rain;
    }

    // 6xx
    private static int getSnowCodes(int iconCode, boolean isDay) {
        return R.drawable.ic_snow_cloud;
    }

    // 7xx
    private static int getAtmosphereCodes(int iconCode, boolean isDay) {
        return R.drawable.ic_foggy_day;
    }

    // 8xx
    private static int getClearCodes(int iconCode, boolean isDay) {
        if (iconCode == 800) {
            if (isDay)
                return R.drawable.ic_sunny_day;
            return R.drawable.ic_half_moon_and_stars_24dp;
        }
        if (iconCode == 801) {
            if (isDay)
                return R.drawable.ic_cloud_with_sun_24dp;
            return R.drawable.ic_cloud_and_half_moon_24dp;
        }
        if (iconCode == 802)
            return R.drawable.ic_cloudy_sky_24dp;
        return R.drawable.ic_cloudy_sky_24dp;
    }

    // 9xx
    private static int getExtremeCodes(int iconCode, boolean isDay) {
        return R.drawable.ic_tornado;
    }

    private static int getIconCode(int iconCode, boolean isDay) {
        int thunderStormCode = 200;
        int drizzleCode = 300;
        int rainCode = 500;
        int snowCode = 600;
        int atmosphereCode = 700;
        int clearSkyCodes = 800;
        int extremeCode = 900;

        if (iconCode >= thunderStormCode && iconCode < drizzleCode)
            return getThunderstormCodes(iconCode, isDay);
        if (iconCode >= drizzleCode && iconCode < rainCode)
            return getDrizzleCodes(iconCode, isDay);
        if (iconCode >= rainCode && iconCode < snowCode)
            return getRainCodes(iconCode, isDay);
        if (iconCode >= snowCode && iconCode < atmosphereCode)
            return getSnowCodes(iconCode, isDay);
        if (iconCode >= atmosphereCode && iconCode < clearSkyCodes)
            return getAtmosphereCodes(iconCode, isDay);
        if (iconCode >= clearSkyCodes && iconCode < extremeCode)
            return getClearCodes(iconCode, isDay);
        return getExtremeCodes(iconCode, isDay);
    }
}
