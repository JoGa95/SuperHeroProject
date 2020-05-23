package com.example.superheroproject.Home.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface APIHeroes {

    @Headers("Content-Type: application/json")
    @GET("{token}/{id}")
    Call<DataHeroes> getSuperHeroes(@Path("token")String token, @Path("id") int id);

    @Headers("Content-Type: application/json")
    @GET("{token}/search/{name}")
    Call<DataHeroesName> getSuperHeroesByName(@Path("token")String token, @Path("name") String nombre);
}
