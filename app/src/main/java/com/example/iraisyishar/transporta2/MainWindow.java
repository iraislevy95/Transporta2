package com.example.iraisyishar.transporta2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainWindow extends AppCompatActivity {

    Button btnBuscaRuta, btnRecordatorio, btnReporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        btnBuscaRuta = (Button)findViewById(R.id.btnBuscaRuta);
        btnRecordatorio = (Button)findViewById(R.id.btnRecordatorio);
        btnReporte = (Button)findViewById(R.id.btnReporte);

        btnRecordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, RecordatorioWindow.class);
                startActivity(intent);
            }
        });

        btnBuscaRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, BuscarRuta.class);
                startActivity(intent);
            }
        });

        btnReporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, ReporteWindow.class);
                startActivity(intent);
            }
        });

    }
}
