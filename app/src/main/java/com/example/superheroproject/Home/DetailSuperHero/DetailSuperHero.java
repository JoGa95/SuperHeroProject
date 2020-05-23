package com.example.superheroproject.Home.DetailSuperHero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.superheroproject.Home.HomeActivity;
import com.example.superheroproject.Home.api.DataHeroes;
import com.example.superheroproject.R;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailSuperHero extends AppCompatActivity {
    private Bundle detailSuperHero;
    private DataHeroes dataHeroes;
    @BindView(R.id.txtDetNombre)
    TextView txtDetNombre;
    @BindView(R.id.txtDetAlterego)
    TextView txtDetAlterego;
    @BindView(R.id.txtDetPrimeraAp)
    TextView txtDetPrimeraAp;
    @BindView(R.id.txtDetPublicadoPor)
    TextView txtDetPublicadoPor;
    @BindView(R.id.txtDetTrabajaEn)
    TextView txtDetTrabajaEn;
    @BindView(R.id.txtDetUbicacionTrabajo)
    TextView txtDetUbicacionTrabajo;
    @BindView(R.id.imgHeroDetail)
    ImageView imgHeroDetail;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_super_hero);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_detail));
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresaActividad();
            }
        });
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.detailSuperHero = this.getIntent().getExtras();

        dataHeroes = (DataHeroes) this.detailSuperHero.getSerializable("superHeroDetail");
        mostrarDetalle(dataHeroes);
    }

    private void mostrarDetalle(DataHeroes dataHeroes) {
        Picasso.get().load(dataHeroes.getImages().getUrl()).error(R.drawable.notfound).into(imgHeroDetail);
        txtDetNombre.setText(dataHeroes.getBiography().getFullname());
        txtDetAlterego.setText(dataHeroes.getBiography().getAlteregos());
        txtDetPrimeraAp.setText(dataHeroes.getBiography().getFirstappearance());
        txtDetPublicadoPor.setText(dataHeroes.getBiography().getPublisher());
        txtDetTrabajaEn.setText(dataHeroes.getWork().getOccupation());
        txtDetUbicacionTrabajo.setText(dataHeroes.getWork().getBase());
    }

    @Override
    public void onBackPressed() {
        regresaActividad();
    }

    private void regresaActividad() {
        finish();
        Intent intent = new Intent(DetailSuperHero.this, HomeActivity.class);
        startActivity(intent);
    }
}
