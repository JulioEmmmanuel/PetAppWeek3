package com.example.petapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    private ArrayList<Mascota> mascotas;

    public PetAdapter(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_animal, parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.tvName.setText(mascota.getName());
        holder.tvLikes.setText(Integer.toString(mascota.getLikes()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String likes = holder.tvLikes.getText().toString();
                int numLikes = Integer.parseInt(likes);

                if(!mascota.isButtonClicked()) {
                    numLikes += 1;
                    holder.btnLike.setBackground(view.getResources().getDrawable(R.drawable.bone_active));
                    mascota.setButtonClicked(true);
                } else {
                    numLikes -= 1;
                    holder.btnLike.setBackground(view.getResources().getDrawable(R.drawable.bone_icon));
                    mascota.setButtonClicked(false);
                }

                holder.tvLikes.setText(Integer.toString(numLikes));

            }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private TextView tvName;
        private TextView tvLikes;
        private Button btnLike;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            btnLike = (Button) itemView.findViewById(R.id.btnLike);
        }
    }

}
