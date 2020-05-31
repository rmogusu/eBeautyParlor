package com.moringaschool.ebeautyparlor.services;

import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class SalonService {
    public static void findBeautyParlor(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();
    }
}
