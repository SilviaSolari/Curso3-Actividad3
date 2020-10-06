package com.example.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        inicializarListaMascotas();

        rvMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        inicializaAdaptador();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Subir una imagen", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Don",R.drawable.miprimerperro,3200));
        mascotas.add(new Mascota("Fer",R.drawable.misegundoperro,2415));
        mascotas.add(new Mascota("Lucy",R.drawable.mitercerperro, 1916));
        mascotas.add(new Mascota("Pit",R.drawable.micuartoperro,1514));
        mascotas.add(new Mascota("Horus",R.drawable.miquintoperro,4900));
        mascotas.add(new Mascota("Zeus",R.drawable.misextoperro,3600));
        mascotas.add(new Mascota("Zote Zote",R.drawable.miseptimoperro,2250));
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mFavoritos:
                Intent intent = new Intent(MainActivity.this, MascotaFavorita.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                Toast.makeText(getApplicationContext(),"Diseñado por Silvia Solari",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}