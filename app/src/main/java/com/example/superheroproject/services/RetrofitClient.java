package com.example.superheroproject.services;

import com.example.superheroproject.Home.api.APIHeroes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public RetrofitClient() {}

    private static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static APIHeroes getAPIHeroesService(String url_heroes) {
        return getClient(url_heroes).create(APIHeroes.class);
    }

}
