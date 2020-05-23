package com.example.superheroproject.Home;
import com.example.superheroproject.Home.api.DataHeroes;
import com.example.superheroproject.utils.ResourceProvider;
import java.util.ArrayList;

public class HomePresenter implements IHomeObtainer, IHomeViewPresenter{
    private IHomeView iHomeView;
    private IHomeProvider iHomeProvider;
    private ResourceProvider resourceProvider;
    private ArrayList<DataHeroes> dataHeroesArrayList = new ArrayList<>();
    private int posicionInicialArray = 0;
    private int incremento = 10;
    private int incrementoExceso = 0;


    HomePresenter(IHomeView vista, ResourceProvider resourceProvider){
        this.iHomeView = vista;
        this.resourceProvider = resourceProvider;
        iHomeProvider = new HomeInteractor(this, this.resourceProvider);

    }

    @Override
    public void getSuperHeroes(int opcion) {
        if (incrementoExceso == 0) {
            dataHeroesArrayList.clear();
        }
        //Se valida si la cantida a incrementar no a excedido el limite de id's de la API.
        int cantidadIncremento = (incrementoExceso > 0 ? incrementoExceso : incremento);
        //Se aumenta a la posicion la cantidad a incrementar
        posicionInicialArray += cantidadIncremento;
        int inicioCiclo = opcion == 0 ? 1 : (posicionInicialArray - cantidadIncremento);
        for (int i = inicioCiclo; i <= posicionInicialArray; i++) {
            iHomeProvider.getSuperHeroes(i);
        }
    }

    @Override
    public void getSuperHeroesByName(String nombre) {
        if (!nombre.isEmpty()) {
            iHomeProvider.getSuperHeroesByName(nombre);
        } else {
            iHomeView.mostrarMensajeObligatorio(this.resourceProvider.getMensajeObligatorio("Nombre de Heroe"));
        }
    }

    @Override
    public void retornoHeroes(DataHeroes dataHeroes) {
        if (dataHeroes.getId() != null) {
            dataHeroesArrayList.add(dataHeroes);
        } else {
            posicionInicialArray = 0;
            incrementoExceso = 10 - dataHeroesArrayList.size();
            getSuperHeroes(0);
        }
        if (dataHeroesArrayList.size() == incremento) {
            incrementoExceso = 0;
            iHomeView.retornoHeroes(dataHeroesArrayList);
        }
    }

    @Override
    public void mostrarErrorEjecucion(String mensajeError) {
        iHomeView.mostrarErrorEjecucion(mensajeError);
    }

    @Override
    public void retornoHeroesPorNombre(ArrayList<DataHeroes> dataHeroesArrayList) {
        if (dataHeroesArrayList != null) {
            iHomeView.retornoHeroesPorNombre(dataHeroesArrayList);
        } else {
            iHomeView.retornoHeroesPorNombreNull();
        }
    }
}
