package com.moringaschool.ebeautyparlor.models;

import java.util.ArrayList;

public class BeautyParlor {
    private String mName;
    private String mPhone;
    private String mWebsite;
    private double mRating;
    private String mImageUrl;
    private String mZipcode;
    private String mEmail;
    private ArrayList<String> mAddress = new ArrayList<>();

    private ArrayList<String> mCategory = new ArrayList<>();

    public BeautyParlor(String name, String phone, String website,
                      double rating, String imageUrl, ArrayList<String> address,
                       ArrayList<String> category,String email,String zipcode) {
        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        this.mRating = rating;
        this.mImageUrl = imageUrl;
        this.mAddress = address;
        this.mCategory  = category;
        this.mEmail =email;
        this.mZipcode =zipcode;
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

    public ArrayList<String> getAddress() {
        return mAddress;
    }
    public ArrayList<String> getService () {
        return mCategory;
    }
    public String getZipcode() {
        return mZipcode;
    }

    public String getEmail() {
        return mEmail;
    }
}

