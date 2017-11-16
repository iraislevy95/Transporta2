package com.example.iraisyishar.transporta2;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BuscarRuta extends AppCompatActivity {

    Button btnBuscar;
    ArrayList<Ruta> rutas = new ArrayList<Ruta>();
    ListView listV;
    EditText etBuscarRuta;
    ItemRutaAdapter adapter;
    boolean justPressed;

    String URL = "http://transporta2.cf/api/Routes";
    String accessTkn = "?access_token=LnAdVWNd3R8W9tNwQLPD2Ce6KehgtfCK07LDMjw9qFKjvBG5hhwqCF2Y2vxgLM82";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_ruta);

        justPressed = false;
        etBuscarRuta = (EditText)findViewById(R.id.etBuscarRuta);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        listV = (ListView)findViewById(R.id.listRutas);
        adapter = new ItemRutaAdapter(BuscarRuta.this,rutas);
        listV.setAdapter(adapter);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                justPressed = true;
                rutas = resBusqueda(etBuscarRuta.getText().toString());
                adapter.setItems(rutas);
            }
        });

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    private ArrayList<Ruta> resBusqueda(final String numRuta){

        final ArrayList<Ruta> encontrado = new ArrayList<Ruta>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (URL+accessTkn,new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("","Respuesta Volley:" + response.toString());
                        Log.d("Busca","esta cadena:" + numRuta);

                        JSONArray jsonArray = response;
                        encontrado.clear();
                        for(int i=0; i<jsonArray.length(); i++){
                            Log.d("Entro encontrados->"+encontrado.size(),"elementos->" + jsonArray.length());
                            try{
                                JSONObject elemento = jsonArray.getJSONObject(i);
                                if((!numRuta.isEmpty()) && (elemento.getString("number").startsWith(numRuta))){
                                    encontrado.add(new Ruta(
                                            elemento.getString("number"),
                                            elemento.getString("origin"),
                                            elemento.getString("destination"),
                                            elemento.getString("id")));
                                        Log.d("Agregado","" + encontrado.size());
                                }

                            }catch (JSONException e) {
                                    Log.e("", "Error de parsing: "+ e.getMessage());
                            }

                        }
                        if(encontrado.isEmpty() && !numRuta.isEmpty())
                            encontrado.add(new Ruta(":(","No se encontró ninguna","intenta de nuevo",""));

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("", "Error:" + error.getMessage());
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonArrayRequest);


        return  encontrado;
    }

    public void justClicked(){
        if(justPressed){
            Log.d("Se presiono","jusPressed");
            hideSoftKeyboard();
            justPressed = false;
        }
    }

    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
