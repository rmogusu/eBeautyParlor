package com.moringaschool.ebeautyparlor.models;

import org.parceler.Parcel;

@Parcel
public class Parlor {

    String website;
     String address;
    String name;
    String phone;
    double rating;
    String imageUrl;
    String categories;
    private String pushId;
    public Parlor () {}
    public Parlor(String name, String phone, String website,
                      double rating, String imageUrl,  String address,
                       String  categories) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
        this.address = address;
        this.imageUrl = imageUrl;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return  website;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public  String getAddress() {
        return address;
    }

    public  String getCategories() {
        return categories;
    }
    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
