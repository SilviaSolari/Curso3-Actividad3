package com.example.petagram;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import static android.graphics.Color.RED;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    private ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false); //asocia layout con RecyclerView
        return new MascotaViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada view //
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        if (position%2==0)
            mascotaViewHolder.imgFoto.setBackgroundColor(Color.LTGRAY);
        else
            mascotaViewHolder.imgFoto.setBackgroundColor(Color.DKGRAY);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikeCV.setText(mascota.getLike() +"");

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mascota.setLike(mascota.getLike()+1);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista de contactos
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private TextView tvLikeCV;
        private TextView tvNombreCV;
        private ImageView imgFoto;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombrePerroCV);
            tvLikeCV = (TextView) itemView.findViewById(R.id.tvLikeCV);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnHuesoBlanco);

        }
    }
}