package com.example.superheroproject.Home;

import androidx.annotation.Nullable;
import com.example.superheroproject.Home.api.APIHeroes;
import com.example.superheroproject.Home.api.DataHeroes;
import com.example.superheroproject.Home.api.DataHeroesName;
import com.example.superheroproject.services.RetrofitClient;
import com.example.superheroproject.utils.ResourceProvider;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractor implements IHomeProvider{
    private IHomeObtainer iHomeObtainer;
    private APIHeroes apiHeroesService;
    private ResourceProvider resourceProvider;
    private String token;

    public HomeInteractor(HomePresenter homePresenter, ResourceProvider resourceProvider) {
        this.iHomeObtainer = homePresenter;
        this.resourceProvider = resourceProvider;
        this.token = this.resourceProvider.getTokenAcces();
    }

    @Override
    public void getSuperHeroes(int id) {
        try {
            String url = resourceProvider.getUrlHeroes();

            apiHeroesService = RetrofitClient.getAPIHeroesService(url);
            apiHeroesService.getSuperHeroes(this.token, id).enqueue(new Callback<DataHeroes>() {
                @Override
                public void onResponse(@Nullable retrofit2.Call<DataHeroes> call, @Nullable Response<DataHeroes> response) {

                    if (response != null && response.isSuccessful()) {
                        DataHeroes responseBody = response.body();
                        if (responseBody != null) {
                            iHomeObtainer.retornoHeroes(responseBody);
                        } else {
                            iHomeObtainer.mostrarErrorEjecucion(resourceProvider.getMensajeError());
                        }
                    }
                }
                @Override
                public void onFailure(@Nullable retrofit2.Call<DataHeroes> call, @Nullable Throwable t) {
                    iHomeObtainer.mostrarErrorEjecucion(resourceProvider.getMensajeError());
                }
            });
        } catch (Exception ex){
            iHomeObtainer.mostrarErrorEjecucion(resourceProvider.getMensajeError());
        }
    }

    @Override
    public void getSuperHeroesByName(String nombre) {
        try {
            String url = resourceProvider.getUrlHeroes();

            apiHeroesService = RetrofitClient.getAPIHeroesService(url);
            apiHeroesService.getSuperHeroesByName(this.token, nombre).enqueue(new Callback<DataHeroesName>() {
                @Override
                public void onResponse(@Nullable retrofit2.Call<DataHeroesName> call, @Nullable Response<DataHeroesName> response) {

                    if (response != null && response.isSuccessful()) {
                        DataHeroesName responseBody = response.body();
                        if (responseBody != null) {
                            iHomeObtainer.retornoHeroesPorNombre(responseBody.getResults());
                        } else {
                            iHomeObtainer.mostrarErrorEjecucion(resourceProvider.getMensajeError());
                        }
                    }
                }
                @Override
                public void onFailure(@Nullable retrofit2.Call<DataHeroesName> call, @Nullable Throwable t) {
                    iHomeObtainer.mostrarErrorEjecucion(resourceProvider.getMensajeError());
                }
            });
        } catch (Exception ex){
            iHomeObtainer.mostrarErrorEjecucion(resourceProvider.getMensajeError());
        }
    }
}
