package com.example.spacextrackerapp.network;

import com.example.spacextrackerapp.model.FlightItemDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
   // @POST("https://api.spacexdata.com/v3/launches")

    @GET("launches")
    Call<List<FlightItemDetails>> getLaunches();

}
