package by.reshetnikov.proweather.data.network.openweathermap.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationModel {

    // LocationModel ID
    @SerializedName("locationId")
    @Expose
    private int locationId;

    // LocationModel name
    @SerializedName("name")
    @Expose
    private String name;

    // LocationModel geo location
    @SerializedName("coord")
    @Expose
    private OWMCoordinates coordinates;

    // Country code (GB, JP etc.)
    @SerializedName("country")
    @Expose
    private String country;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return coordinates.getLatitude();
    }

    public double getLongitude() {
        return coordinates.getLongitude();
    }

    public void setCoordinates(OWMCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}