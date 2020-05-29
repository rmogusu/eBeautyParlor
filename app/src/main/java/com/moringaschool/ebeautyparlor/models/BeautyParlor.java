package com.moringaschool.ebeautyparlor.models;

import java.util.ArrayList;

public class BeautyParlor {
    private String mName;
    private String mPhone;
    private String mWebsite;
    private double mRating;
    private String mImageUrl;
    private ArrayList<String> mAddress = new ArrayList<>();

    private ArrayList<String> mService = new ArrayList<>();

    public BeautyParlor(String name, String phone, String website,
                      double rating, String imageUrl, ArrayList<String> address,
                       ArrayList<String> service) {
        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        this.mRating = rating;
        this.mImageUrl = imageUrl;
        this.mAddress = address;
        this.mService  = service ;
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
        return mService;
    }
}

