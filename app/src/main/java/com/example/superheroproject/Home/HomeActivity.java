package com.example.superheroproject.Home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.superheroproject.Adapters.SuperHeroAdapter;
import com.example.superheroproject.Home.api.DataHeroes;
import com.example.superheroproject.R;
import com.example.superheroproject.utils.DialogProgressLottie;
import com.example.superheroproject.utils.ResourceProvider;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements IHomeView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recyclerHeroes)
    RecyclerView recyclerViewHeroes;
    @BindView(R.id.pullToRefresh)
    SwipeRefreshLayout pullToRefresh;
    @BindView(R.id.simpleSearchView)
    SearchView simpleSearchView;
    @BindView(R.id.imgNoHero)
    ImageView imgNoHero;
    @BindView(R.id.txtHeroes)
    TextView txtHeroes;
    @BindView(R.id.txtDialogSelect)
    TextView txtDialogSelect;
    private IHomeViewPresenter iHomeViewPresenter;
    private SuperHeroAdapter superHeroAdapter;
    private DialogProgressLottie dialogProgressLottie;
    private ArrayList<DataHeroes> dataHeroesArrayList = new ArrayList<DataHeroes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        dialogProgressLottie = new DialogProgressLottie(this);
        iHomeViewPresenter = new HomePresenter(this, new ResourceProvider(this.getResources()));
        dialogProgressLottie.showDialogProgress();
        iHomeViewPresenter.getSuperHeroes(0);
        pullToRefresh.setColorSchemeColors(getResources().getColor(R.color.colorAzulOscuroD));
        pullToRefresh.setOnRefreshListener(this);

        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    iHomeViewPresenter.getSuperHeroes(0);
                    simpleSearchView.clearFocus();
                    dialogProgressLottie.showDialogProgress();
                }
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                iHomeViewPresenter.getSuperHeroesByName(query);
                simpleSearchView.clearFocus();
                dialogProgressLottie.showDialogProgress();
                return false;
            }
        });

    }

    @Override
    public void retornoHeroes(ArrayList<DataHeroes> dataHeroesArrayList) {
        //Aqui pintamos el adaptador
        mostrarElementos(true);
        superHeroAdapter = new SuperHeroAdapter(this, dataHeroesArrayList);
        recyclerViewHeroes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewHeroes.setAdapter(superHeroAdapter);
        dialogProgressLottie.CloseDialog();
    }

    private void mostrarElementos(boolean validador) {
        if (validador) {
            txtHeroes.setVisibility(View.GONE);
            recyclerViewHeroes.setVisibility(View.VISIBLE);
            imgNoHero.setVisibility(View.GONE);
            txtDialogSelect.setVisibility(View.VISIBLE);
        } else {
            txtHeroes.setVisibility(View.VISIBLE);
            txtDialogSelect.setVisibility(View.GONE);
            recyclerViewHeroes.setVisibility(View.GONE);
            imgNoHero.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void mostrarErrorEjecucion(String mensajeError) {
        Toast.makeText(this, mensajeError, Toast.LENGTH_SHORT).show();
        dialogProgressLottie.CloseDialog();
        mostrarElementos(false);
    }

    @Override
    public void mostrarMensajeObligatorio(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        dialogProgressLottie.CloseDialog();
    }

    @Override
    public void retornoHeroesPorNombre(ArrayList<DataHeroes> datosHeroesArrayList) {
        mostrarElementos(true);
        dataHeroesArrayList = datosHeroesArrayList;
        superHeroAdapter = new SuperHeroAdapter(this, dataHeroesArrayList);
        recyclerViewHeroes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewHeroes.setAdapter(superHeroAdapter);
        dialogProgressLottie.CloseDialog();
    }

    @Override
    public void retornoHeroesPorNombreNull() {
        mostrarElementos(false);
        dialogProgressLottie.CloseDialog();
        dialogProgressLottie.CloseDialog();
    }

    @Override
    public void onRefresh() {
        dialogProgressLottie.showDialogProgress();
        iHomeViewPresenter.getSuperHeroes(1);
        pullToRefresh.setRefreshing(false);
    }



}
