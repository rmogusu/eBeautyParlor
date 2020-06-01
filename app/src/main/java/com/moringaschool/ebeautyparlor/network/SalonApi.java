package com.moringaschool.ebeautyparlor.network;

import com.moringaschool.ebeautyparlor.models.BeautyParlor;

import java.util.List;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SalonApi {
    @GET("beautyparlor")
Call<List<BeautyParlor>> getBeautyParlor(
        @Query("location") String location,
        @Query("term") String term);

}
