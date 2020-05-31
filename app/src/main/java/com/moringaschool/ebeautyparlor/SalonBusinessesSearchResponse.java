
package com.moringaschool.ebeautyparlor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalonBusinessesSearchResponse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String  website;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SalonBusinessesSearchResponse() {
    }

    /**
     * 
     * @param website
     * @param address
     * @param phone
     * @param imageUrl
     * @param latitude
     * @param name
     * @param rating
     * @param id
     * @param longitude
     */
    public SalonBusinessesSearchResponse(String name, String phone, String website, Double  rating, String imageUrl, String address, String latitude, String longitude, Integer id) {
        super();
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Double  getRating() {
        return rating;
    }

    public void setRating(Double  rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}