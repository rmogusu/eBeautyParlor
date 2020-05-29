package com.moringaschool.ebeautyparlor;


import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Services {
    public static void findBeautyParlor(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.API_KEY)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}



