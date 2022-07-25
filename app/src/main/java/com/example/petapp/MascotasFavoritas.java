package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv = (RecyclerView) findViewById(R.id.rvFavoritePets);
        llenarLista();
        inicializarAdaptador();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

    }

    private void llenarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Rocky", R.drawable.dog_4, 10));
        mascotas.add(new Mascota("Tom", R.drawable.cat_2, 10));
        mascotas.add(new Mascota("Scooby", R.drawable.dog_1, 5));
        mascotas.add(new Mascota("Fiona", R.drawable.cat_4, 4));
        mascotas.add(new Mascota("Firulais", R.drawable.dog_2, 3));
    }

    private void inicializarAdaptador(){
        PetAdapter adapter = new PetAdapter(mascotas);
        rv.setAdapter(adapter);
    }

}