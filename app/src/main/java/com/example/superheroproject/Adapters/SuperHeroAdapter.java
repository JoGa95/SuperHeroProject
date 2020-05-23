package com.example.superheroproject.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superheroproject.Home.DetailSuperHero.DetailSuperHero;
import com.example.superheroproject.Home.api.DataHeroes;
import com.example.superheroproject.R;
import com.example.superheroproject.utils.DialogProgressLottie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder> {
    private Context mContext;
    private List<DataHeroes> superHeroes;

    public SuperHeroAdapter(@NonNull Context context, @NonNull ArrayList<DataHeroes> objects) {
        this.mContext = context;
        this.superHeroes = objects;
    }

    @NonNull
    @Override
    public SuperHeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.mContext).inflate(R.layout.item_heroes,parent,false);
        return new SuperHeroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroViewHolder holder, final int position) {
        final DataHeroes dataHeroes = superHeroes.get(position);
        Picasso.get().load(dataHeroes.getImages().getUrl()).error(R.drawable.notfound).into(holder.imgHero);
        holder.txtNombreHeroe.setText(dataHeroes.getName());
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    public class SuperHeroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtNombreHeroe;
        private ImageView imgHero;
        private CardView cardView;
        public SuperHeroViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreHeroe     =    itemView.findViewById(R.id.txtNomHero);
            imgHero     =    itemView.findViewById(R.id.imgHero);
            cardView =  itemView.findViewById(R.id.cardView);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            DataHeroes dataHeroes = superHeroes.get(getAdapterPosition());
            Intent intent = new Intent(mContext, DetailSuperHero.class);
            intent.putExtra("superHeroDetail", dataHeroes);
            ((Activity) mContext).finish();
            mContext.startActivity(intent);

        }
    }
}

