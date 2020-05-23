package com.example.superheroproject.Home.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Biography implements Serializable {

    @SerializedName("full-name")
    @Expose
    private String fullname;
    @SerializedName("alter-egos")
    @Expose
    private String alteregos;
    @SerializedName("aliases")
    @Expose
    private List<String> aliases;
    @SerializedName("place-of-birth")
    @Expose
    private String placeofbirth;
    @SerializedName("first-appearance")
    @Expose
    private String firstappearance;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("alignment")
    @Expose
    private String alignment;


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAlteregos() {
        return alteregos;
    }

    public void setAlteregos(String alteregos) {
        this.alteregos = alteregos;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}
