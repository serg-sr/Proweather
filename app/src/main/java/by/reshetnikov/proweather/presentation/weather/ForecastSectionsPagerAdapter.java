package by.reshetnikov.proweather.presentation.weather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import by.reshetnikov.proweather.presentation.forecast.ForecastFragment;
import by.reshetnikov.proweather.presentation.nowforecast.NowForecastFragment;

/**
 * Created by SacRahl on 8/3/2017.
 */

public class ForecastSectionsPagerAdapter extends FragmentPagerAdapter {
    public ForecastSectionsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NowForecastFragment.newInstance(position + 1);
            case 1:
                return ForecastFragment.newInstance(position + 1);
        }
        return NowForecastFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "NOW";
            case 1:
                return "FORECAST";
        }
        return null;
    }
}