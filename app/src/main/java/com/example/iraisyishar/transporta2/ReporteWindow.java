package com.example.iraisyishar.transporta2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class ReporteWindow extends AppCompatActivity {

    Button btnUbicacion, btnCrear;
    RadioButton rbLimpio, rbSucio, rbMuySucio;
    RadioButton rbVacio, rbRegular, rbLleno, rbHastaPTM;
    CheckBox chbAmable, chbNoParada, chbManejaMal;

    Reporte reporte;
    int limpieza;
    int llenado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        btnUbicacion = (Button)findViewById(R.id.btnUbicacion);
        btnCrear = (Button)findViewById(R.id.btnCrear);

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

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
