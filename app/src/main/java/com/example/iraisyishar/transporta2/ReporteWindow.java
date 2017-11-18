package com.example.iraisyishar.transporta2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import org.json.JSONException;
import org.json.JSONObject;

public class ReporteWindow extends AppCompatActivity {

    Button btnUbicacion, btnCrear;
    RadioButton rbLimpio, rbSucio, rbMuySucio;
    RadioButton rbVacio, rbRegular, rbLleno, rbHastaPTM;
    CheckBox chbAmable, chbNoParada, chbManejaMal;
    EditText etNumUnidad, etRuta;

    Reporte reporte;
    int limpieza,llenado;
    boolean amable, noParada, manejaMal;
    String numRuta, numUnidad;

    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        btnUbicacion = (Button)findViewById(R.id.btnUbicacion);
        btnCrear = (Button)findViewById(R.id.btnCrear);

        etNumUnidad = (EditText)findViewById(R.id.etNumUnidad);
        etRuta = (EditText)findViewById(R.id.etNumRuta);

        rbLimpio = (RadioButton)findViewById(R.id.rbLimpio);
        rbSucio = (RadioButton)findViewById(R.id.rbSucio);
        rbMuySucio = (RadioButton)findViewById(R.id.rbMuySucio);

        rbVacio = (RadioButton)findViewById(R.id.rbVacio);
        rbRegular = (RadioButton)findViewById(R.id.rbRegular);
        rbLleno = (RadioButton)findViewById(R.id.rbLleno);
        rbHastaPTM = (RadioButton)findViewById(R.id.rbHastaPTM);

        chbAmable = (CheckBox)findViewById(R.id.chbAmable);
        chbNoParada = (CheckBox)findViewById(R.id.chbNoParada);
        chbManejaMal = (CheckBox)findViewById(R.id.chbManejaMal);

        alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.dismiss();
                            }
                        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numRuta = etRuta.getText().toString();
                numUnidad = etNumUnidad.getText().toString();

                if(rbLimpio.isChecked()){
                    limpieza = Reporte.LIMPIO;
                }
                else if(rbSucio.isChecked()){
                    limpieza = Reporte.SUCIO;
                }
                else if(rbMuySucio.isChecked()){
                    limpieza = Reporte.MUY_SUCIO;
                }
                else{
                    alertDialogBuilder.setMessage("Olvidaste decirnos qué tan limpio está!");
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    return;
                }

                if(rbVacio.isChecked()){
                    llenado = Reporte.VACIO;
                }
                else if(rbRegular.isChecked()){
                    llenado = Reporte.REGULAR;
                }
                else if(rbLleno.isChecked()){
                    llenado = Reporte.LLENO;
                }
                else if(rbHastaPTM.isChecked()){
                    llenado = Reporte.HASTA_SU_PTM;
                }
                else{
                    alertDialogBuilder.setMessage("Primero dinos qué tan lleno viene");
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    return;
                }

                if(chbAmable.isChecked()) amable=true;
                else amable = false;

                if(chbManejaMal.isChecked()) manejaMal = true;
                else manejaMal = false;

                if(chbNoParada.isChecked()) noParada = true;
                else noParada = false;



                if((!numRuta.isEmpty()) && (!numUnidad.isEmpty())){
                    reporte = new Reporte(numRuta,numUnidad,amable,manejaMal,noParada,limpieza,llenado);
                    JSONObject j = obtenerJSONreporte(reporte);
                    Log.d("Agregado","y enviado" );
                }
                else{
                    alertDialogBuilder.setMessage("Ups! Antes debes decirnos en qué camión estás");
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }

            }
        });


        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    protected JSONObject obtenerJSONreporte(Reporte r){
        JSONObject json = new JSONObject();
        try {
            json.put("route",r.getRuta());
            json.put("unitNumber",r.getNumUnidad());
            json.put("cleanness",r.getLimpieza());
            json.put("fullness",r.getLlenado());
            json.put("isKind",r.getAmable());
            json.put("notStop",r.getNoDaParada());
            json.put("badDriver",r.getManejaMal());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  json;
    }
}
