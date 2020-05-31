package com.moringaschool.ebeautyparlor.services;

import com.moringaschool.ebeautyparlor.Constants;
import com.moringaschool.ebeautyparlor.models.BeautyParlor;

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
    public static void findBeautyParlor(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.SALON_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SALON_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                //.header("Authorization",Constants.API_KEY)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
   }
    public ArrayList<BeautyParlor> processResults(Response response){
        ArrayList<BeautyParlor> beautyParlors = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            JSONObject salonJSON = new JSONObject(jsonData);
            JSONArray businessesJSON = salonJSON.getJSONArray("businesses");
            if (response.isSuccessful()){
                for (int i = 0; i < businessesJSON.length(); i++){
                    JSONObject beautyparlorJSON = businessesJSON.getJSONObject(i);
                    String name = beautyparlorJSON.getString("name");
                    String phone = beautyparlorJSON.optString("display_phone", "Phone not available");
                    String website = beautyparlorJSON.getString("url");
                    double rating = beautyparlorJSON.getDouble("rating");
                    String imageUrl = beautyparlorJSON.getString("image_url");
                    double latitude = beautyparlorJSON.getJSONObject("coordinates").getDouble("latitude");
                    double longitude = beautyparlorJSON.getJSONObject("coordinates").getDouble("longitude");
                    ArrayList<String> address = new ArrayList<>();
                    JSONArray addressJSON = beautyparlorJSON.getJSONObject("location").getJSONArray("display_address");
                    for (int y = 0; y < addressJSON.length(); y++){
                        address.add(addressJSON.get(y).toString());
                    }
                    ArrayList<String> categories = new ArrayList<>();
                    JSONArray categoriesJSON = beautyparlorJSON.getJSONArray("categories");
                    for (int y = 0; y < categoriesJSON.length(); y++){
                        categories.add(categoriesJSON.getJSONObject(y).getString("title"));
                    }
                    BeautyParlor  beautyParlor = new BeautyParlor(name, phone, website, rating,
                            imageUrl, address, latitude, longitude, categories) ;
                    beautyParlors.add(beautyParlor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beautyParlors;
    }
}

