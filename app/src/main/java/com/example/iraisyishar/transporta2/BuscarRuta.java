package com.example.iraisyishar.transporta2;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class BuscarRuta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_ruta);

        ListView listV = (ListView)findViewById(R.id.listRutas);
        ArrayList<Ruta> rutas = resBusqueda();
        ItemRutaAdapter adapter = new ItemRutaAdapter(this,rutas);

        listV.setAdapter(adapter);

    }

    private ArrayList<Ruta> resBusqueda(){
        //PETICION Y PARSEO DE RUTAS... DESPUES
        ArrayList<Ruta> encontrado = new ArrayList<Ruta>();
        //EJEMPLO
        encontrado.add(new Ruta("622","Cucei","Rio de Janeiro"));
        encontrado.add(new Ruta("258","Centro","Santa Ana"));
        encontrado.add(new Ruta("258-A","Centro","Santa Ana"));

        return  encontrado;
    }
}
