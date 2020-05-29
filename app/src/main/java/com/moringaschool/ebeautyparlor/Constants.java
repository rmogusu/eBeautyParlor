package com.moringaschool.ebeautyparlor;


import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class Constants {
    public static final String BASE_URL = "https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest";
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String LOCATION_QUERY_PARAMETER = "location";
    private static final String APPLICATION_NAME = "ebeautyparlor";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

}
