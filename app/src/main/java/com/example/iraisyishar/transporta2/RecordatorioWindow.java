package com.example.iraisyishar.transporta2;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class RecordatorioWindow extends AppCompatActivity {

    Spinner spRuta;
    Button btnHora;
    TextView tvHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorio);

        spRuta = (Spinner)findViewById(R.id.spRuta);
        btnHora = (Button)findViewById(R.id.btnHora);
        tvHora = (TextView)findViewById(R.id.tvHora);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Rutas, android.R.layout.simple_spinner_item);
        spRuta.setAdapter(adapter);

        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current time
                final Calendar c = Calendar.getInstance();
                final int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);


                TimePickerDialog timePickerDialog = new TimePickerDialog(RecordatorioWindow.this,
                        new TimePickerDialog.OnTimeSetListener(){
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                if(minute<10 && hourOfDay>10) tvHora.setText(hourOfDay + ":0" + minute);
                                else if(hourOfDay<10 && minute>10)tvHora.setText( "0" + hourOfDay + ":" + minute);
                                else if(hourOfDay<10 && minute<10)tvHora.setText( "0" + hourOfDay + ":0" + minute);
                                else tvHora.setText(hourOfDay + ":" + minute);

                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });
    }
}
