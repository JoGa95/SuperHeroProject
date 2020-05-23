package com.example.superheroproject.Home;

import com.example.superheroproject.Home.api.DataHeroes;

import java.util.ArrayList;

public interface IHomeObtainer {
    void retornoHeroes(DataHeroes dataHeroes);

    void mostrarErrorEjecucion(String mensajeError);

    void retornoHeroesPorNombre(ArrayList<DataHeroes> responseBody);
}
