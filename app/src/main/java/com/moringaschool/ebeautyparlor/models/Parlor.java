package com.moringaschool.ebeautyparlor.models;

import org.parceler.Parcel;

@Parcel
public class Parlor {
    private String mName;
    private String mPhone;
    private String mWebsite;
    private double mRating;
    private String mImageUrl;
    private String mAddress;

    private String mCategories;

    public Parlor(String name, String phone, String website,
                      double rating, String imageUrl,  String address,
                       String  categories) {
        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        this.mRating = rating;
        this.mImageUrl = imageUrl;
        this.mAddress = address;
        this.mCategories = categories;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return  mWebsite;
    }

    public double getRating() {
        return mRating;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public  String getAddress() {
        return mAddress;
    }

    public  String getCategories() {
        return mCategories;
    }
}
