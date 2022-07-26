package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rv;
    private Button btnFavs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rv = (RecyclerView) findViewById(R.id.rvPets);

        llenarLista();
        inicializarAdaptador();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        btnFavs = (Button) findViewById(R.id.btnFavs);
        btnFavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarFavoritos();
            }
        });

    }

    private void llenarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Scooby", R.drawable.dog_1, 5));
        mascotas.add(new Mascota("Firulais", R.drawable.dog_2, 3));
        mascotas.add(new Mascota("Pepe", R.drawable.dog_3, 2));
        mascotas.add(new Mascota("Rocky", R.drawable.dog_4, 10));
        mascotas.add(new Mascota("Felix", R.drawable.cat_1, 5));
        mascotas.add(new Mascota("Tom", R.drawable.cat_2, 10));
        mascotas.add(new Mascota("Kitty", R.drawable.cat_3, 2));
        mascotas.add(new Mascota("Fiona", R.drawable.cat_4, 4));
    }

    private void inicializarAdaptador(){
        PetAdapter adapter = new PetAdapter(mascotas);
        rv.setAdapter(adapter);
    }

    private void mostrarFavoritos(){
        Intent i = new Intent(MainActivity.this, MascotasFavoritas.class);
        startActivity(i);
    }


}