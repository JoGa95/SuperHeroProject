package com.example.superheroproject.utils;

import android.content.res.Resources;

import com.example.superheroproject.R;

public class ResourceProvider {
    private Resources resources;

    public  ResourceProvider( Resources resources){
        this.resources=resources;
    }

    public String getUrlHeroes() {
        return "https://superheroapi.com/api/";
    }

    public String getMensajeError() {
        return resources.getString(R.string.msj_error);
    }

    public String getMensajeObligatorio(String campo) {
        String mensaje = resources.getString(R.string.msj_requerido);
        mensaje = mensaje.replace("{campo}", campo);
        return mensaje;
    }

    public String getTokenAcces() {
        return "10156112965520834";
    }
}
