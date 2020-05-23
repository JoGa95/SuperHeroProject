package com.example.superheroproject.Home;

import com.example.superheroproject.Home.api.DataHeroes;

import java.util.ArrayList;

public interface IHomeView {
    void retornoHeroes(ArrayList<DataHeroes> dataHeroes);

    void mostrarErrorEjecucion(String mensajeError);

    void mostrarMensajeObligatorio(String nombre_de_heroe);

    void retornoHeroesPorNombre(ArrayList<DataHeroes> dataHeroesArrayList);

    void retornoHeroesPorNombreNull();
}
