package com.moringaschool.ebeautyparlor.services;

import com.moringaschool.ebeautyparlor.Constants;

import com.moringaschool.ebeautyparlor.models.Parlor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SalonService {
    public static void findBeautyParlors(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.SALON_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SALON_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Parlor> processResults(Response response) {
        ArrayList<Parlor> parlors = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject salonJSON = new JSONObject(jsonData);
            JSONArray beautyParlorJSON = salonJSON.getJSONArray("beautyparlor");
            if (response.isSuccessful()) {
                for (int i = 0; i < beautyParlorJSON.length(); i++) {
                    JSONObject beautyparlorJSON = beautyParlorJSON.getJSONObject(i);
                    String name = beautyparlorJSON.getString("name");
                    String phone = beautyparlorJSON.optString("phone");
                    String website = beautyparlorJSON.getString("website");
                    double rating = beautyparlorJSON.getDouble("rating");
                    String imageUrl = beautyparlorJSON.getString("imageUrl");
                    String categories =beautyparlorJSON .getString("categories") ;
                    String address =beautyparlorJSON .getString("address") ;

                    Parlor  parlor = new Parlor(name, phone, website, rating,
                            imageUrl, categories,address);
                    parlors.add(parlor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parlors;
    }
}

