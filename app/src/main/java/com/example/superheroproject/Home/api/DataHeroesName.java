package com.example.superheroproject.Home.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class DataHeroesName {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("results")
    @Expose
    private ArrayList<DataHeroes> results;


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ArrayList<DataHeroes> getResults() {
        return results;
    }

    public void setResults(ArrayList<DataHeroes> results) {
        this.results = results;
    }


}
