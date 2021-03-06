package by.reshetnikov.proweather.presentation.location.locationmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.reshetnikov.proweather.R;
import by.reshetnikov.proweather.data.db.model.LocationEntity;
import by.reshetnikov.proweather.presentation.location.locationmanager.listener.OnAutoCompleteLocationSearchListener;
import timber.log.Timber;

public class AutoCompleteLocationsAdapter extends BaseAdapter implements Filterable {

    @BindView(R.id.tv_dropdown_location)
    TextView tvLocation;
    @BindView(R.id.tv_dropdown_country_code)
    TextView tvCountyCode;
    private WeakReference<Context> contextRef;
    private List<LocationEntity> results = new ArrayList<>();
    private OnAutoCompleteLocationSearchListener listener;

    public AutoCompleteLocationsAdapter(Context context) {
        this.contextRef = new WeakReference<>(context);
    }

    public void setOnPerformSearchListener(OnAutoCompleteLocationSearchListener listener) {
        this.listener = listener;
    }

    public void updateSearchResults(List<LocationEntity> locations) {
        results = locations;
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_autocomplete_location, parent, false);
        }
        ButterKnife.bind(this, convertView);
        LocationEntity location = (LocationEntity) getItem(position);
        tvLocation.setText(location.getLocationName());
        tvCountyCode.setText(location.getCountryCode());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    Timber.d("performFiltering() in getFilter(): " + constraint.toString());
                    AutoCompleteLocationsAdapter.this.loadLocations(constraint.toString());
                    filterResults.values = results;
                    filterResults.count = results.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0 && constraint != null) {
                    Timber.d("performFiltering() in getFilter(): " + constraint.toString());
                    AutoCompleteLocationsAdapter.this.results = (List<LocationEntity>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }

    private void loadLocations(String searchText) {
        if (listener != null) {
            listener.performSearch(searchText);
        }

    }

    private Context getContext() {
        if (contextRef != null) {
            return contextRef.get();
        }
        throw new NullPointerException("Context is null!!!");
    }
}




