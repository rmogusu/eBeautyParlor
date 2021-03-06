
package com.moringaschool.ebeautyparlor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class BeautyParlor {

    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("phone")
    @Expose
     String phone;
    @SerializedName("website")
    @Expose
    String website;
    @SerializedName("rating")
    @Expose
    Double rating;
    @SerializedName("imageUrl")
    @Expose
     String imageUrl;
    @SerializedName("address")
    @Expose
    String address;
    @SerializedName("categories")
    @Expose
    String categories;
    @SerializedName("latitude")
    @Expose
    String latitude;
    @SerializedName("longitude")
    @Expose
     String longitude;
    @SerializedName("id")
    @Expose
    Integer id;
    private String pushId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BeautyParlor() {
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
    public BeautyParlor(String name, String phone, String website, Double rating, String imageUrl,String categories, String address, String latitude, String longitude, Integer id) {
        super();
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categories =categories;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
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
    public  String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories= categories;
    }
    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
