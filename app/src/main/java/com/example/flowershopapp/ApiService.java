package com.example.flowershopapp;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/flowers")
    Call<List<Flower>> getFlowers();
}