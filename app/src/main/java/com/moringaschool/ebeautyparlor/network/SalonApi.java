package com.moringaschool.ebeautyparlor.network;

import com.moringaschool.ebeautyparlor.SalonBusinessesSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SalonApi {
    @GET("beautyparlor")
    Call<SalonBusinessesSearchResponse> getBeautyParlor(
            @Query("location") String location,
            @Query("term") String term
    );
}
