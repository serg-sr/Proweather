package by.reshetnikov.proweather.presentation.location.locationmanager.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.reshetnikov.proweather.data.db.model.LocationEntity;
import by.reshetnikov.proweather.presentation.location.locationmanager.callback.LocationsDiffUtilCallback;
import by.reshetnikov.proweather.presentation.location.locationmanager.listener.OnLocationClickedListener;
import by.reshetnikov.proweather.presentation.location.locationmanager.listener.OnLocationRemovedListener;
import by.reshetnikov.proweather.presentation.location.locationmanager.listener.OnLocationsOrderChangedListener;
import by.reshetnikov.proweather.presentation.location.locationmanager.viewholder.LocationViewHolder;
import timber.log.Timber;

public class LocationsRecyclerViewAdapter extends RecyclerView.Adapter<LocationViewHolder> implements LocationsViewAdapterContract {

    private final static boolean DETECT_MOVES = false;
    private List<LocationEntity> locations = new ArrayList<>();
    private OnLocationsOrderChangedListener orderChangedListener = null;
    private OnLocationRemovedListener locationRemovedListener = null;
    private OnLocationClickedListener locationClickedListener = null;

    public LocationsRecyclerViewAdapter() {
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LocationViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onViewRecycled(LocationViewHolder holder) {
        super.onViewRecycled(holder);
        Timber.d("onViewRecycled(), holder pos = " + holder.getAdapterPosition());
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        LocationEntity location;
        try {
            location = getLocationAtPosition(position);
        } catch (IndexOutOfBoundsException e) {
            Timber.e("No such position at list, size is " + locations.size(), e);
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (locationClickedListener != null)
                    locationClickedListener.onLocationItemClicked(location);
                else
                    Timber.w("locationClickedListener is null");
            }
        });
        holder.setLocationName(location.getLocationName());
        holder.setCircleCountryCode(TextUtils.isEmpty(location.getCountryCode()) ? "?" : location.getCountryCode());
        int firstPosition = 0;
        boolean isCurrent = location.getPosition() == firstPosition;
        holder.markAsCurrent(isCurrent);
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    @Override
    public void updateView(List<LocationEntity> updatedLocations) {
        Timber.d("updateView(), called");
        LocationsDiffUtilCallback diffCallback = new LocationsDiffUtilCallback(this.locations, updatedLocations);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback, DETECT_MOVES);
        Timber.d("updateView(), changed locations size from " + diffCallback.getOldListSize() + " to " + diffCallback.getNewListSize());
        locations.clear();
        locations.addAll(updatedLocations);
        diffResult.dispatchUpdatesTo(this);
        locations = updatedLocations;
        Timber.d("updateView(), ends");
    }

    @Override
    public LocationEntity getLocation(int position) {
        return locations.get(position);
    }

    @Override
    public void addLocation(LocationEntity location) {
        int position = locations.size();
        locations.add(position, location);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, locations.size());
    }

    @Override
    public void moveLocationItem(int fromPosition, int toPosition, boolean saveChanges) {
        if (saveChanges && orderChangedListener != null) {
            orderChangedListener.onOrderChange(fromPosition, toPosition);
            return;
        }
        Collections.swap(locations, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void removeLocation(int position) {
        Timber.d("removeLocation(), called");
        if (locationRemovedListener != null) {
            locationRemovedListener.onRemove(getLocationAtPosition(position));
        }

        Timber.d("removeLocation(), ends");
    }

    @Override
    public void setOnLocationsOrderChangedListener(OnLocationsOrderChangedListener listener) {
        this.orderChangedListener = listener;
    }

    @Override
    public void setOnLocationRemovedListener(OnLocationRemovedListener listener) {
        this.locationRemovedListener = listener;
    }

    @Override
    public void setOnLocationClickedListener(OnLocationClickedListener listener) {
        this.locationClickedListener = listener;
    }

    private LocationEntity getLocationAtPosition(int position) {
        Timber.d("getLocationAtPosition() #" + position);
        for (LocationEntity model : locations) {
            Timber.d("Location position #" + model.getPosition());
            if (model.getPosition() == position)
                return model;
        }
        //TODO: remove exception throw
        throw new IndexOutOfBoundsException("Position " + position + " was not found at list (size of " + locations.size() + ")");
    }
}