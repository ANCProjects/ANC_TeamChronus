package team.chronus.amona.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@AutoValue
public abstract class Venue {

    public abstract Integer id();
    public abstract String name();
    public abstract Double lat();
    public abstract Double lon();
    public abstract Boolean repinned();
    public abstract String address_1();
    public abstract String city();
    public abstract String country();
    public abstract String localized_country_name();


    public static Builder builder() {
        return new AutoValue_Venue.Builder();
    }

    public static TypeAdapter<Venue> typeAdapter(Gson gson) {
        return new AutoValue_Venue.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Integer id);
        public abstract Builder name(String name);
        public abstract Builder lat(Double lat);
        public abstract Builder lon(Double lon);
        public abstract Builder repinned(Boolean repinned);
        public abstract Builder address_1(String address_1);
        public abstract Builder city(String city);
        public abstract Builder country(String country);
        public abstract Builder localized_country_name(String localized_country_name);

        public abstract Venue build();
    }



//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("lat")
//    @Expose
//    private Double lat;
//    @SerializedName("lon")
//    @Expose
//    private Double lon;
//    @SerializedName("repinned")
//    @Expose
//    private Boolean repinned;
//    @SerializedName("address_1")
//    @Expose
//    private String address1;
//    @SerializedName("city")
//    @Expose
//    private String city;
//    @SerializedName("country")
//    @Expose
//    private String country;
//    @SerializedName("localized_country_name")
//    @Expose
//    private String localizedCountryName;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getLat() {
//        return lat;
//    }
//
//    public void setLat(Double lat) {
//        this.lat = lat;
//    }
//
//    public Double getLon() {
//        return lon;
//    }
//
//    public void setLon(Double lon) {
//        this.lon = lon;
//    }
//
//    public Boolean getRepinned() {
//        return repinned;
//    }
//
//    public void setRepinned(Boolean repinned) {
//        this.repinned = repinned;
//    }
//
//    public String getAddress1() {
//        return address1;
//    }
//
//    public void setAddress1(String address1) {
//        this.address1 = address1;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getLocalizedCountryName() {
//        return localizedCountryName;
//    }
//
//    public void setLocalizedCountryName(String localizedCountryName) {
//        this.localizedCountryName = localizedCountryName;
//    }
}
