package com.moringaschool.ebeautyparlor;


import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class Services {
    public static void findBeautyParlor(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
    }


}
