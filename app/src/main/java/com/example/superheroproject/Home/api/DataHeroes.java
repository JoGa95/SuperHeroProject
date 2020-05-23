package com.example.superheroproject.Home.api;

import com.example.superheroproject.Home.entities.Biography;
import com.example.superheroproject.Home.entities.Images;
import com.example.superheroproject.Home.entities.Work;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataHeroes implements Serializable {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("biography")
    @Expose
    private Biography biography;
    @SerializedName("work")
    @Expose
    private Work work;
    @SerializedName("image")
    @Expose
    private Images image;

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Images getImages() {
        return image;
    }

    public void setImages(Images images) {
        this.image = images;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
