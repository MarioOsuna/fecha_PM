package com.example.recordatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView DisplayDate;
    DatePicker simpleDatePicker;
    Button buttonFecha,buttonRecordatorio;
    int day,month,year;
    String cadena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonFecha=findViewById(R.id.buttonFecha);
        buttonRecordatorio=findViewById(R.id.buttonRecordatorio);



        buttonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.simpleDatePicker);
                simpleDatePicker.setSpinnersShown(false);
                simpleDatePicker.setVisibility(View.VISIBLE);

                 day = simpleDatePicker.getDayOfMonth();
                 month = simpleDatePicker.getMonth();
                 year = simpleDatePicker.getYear();


            }
        });



        buttonRecordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(day==22 && month==10 && year == 2019 )
              {

                          cadena = "Felicita al cumpleñero, hoy es su cumple";

              }

              else{
                  //cadena=;
              }
            //  simpleDatePicker.

                Intent intento=new Intent(Intent.ACTION_SEND);
                intento.setType("text/plain");
                intento.putExtra(Intent.EXTRA_TEXT,cadena);
                intento.setPackage("com.whatsapp");
                if(getPackageManager().getLaunchIntentForPackage("com.whatsapp")!=null){
                    startActivity(intento);

                }
                else{
                    Toast.makeText(MainActivity.this,"Instala WhatsApp",Toast.LENGTH_LONG).show();
                }

            }
        });

        /* buttonCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(Intent.ACTION_SEND);
                intento.setType("text/plain");
                intento.putExtra(Intent.EXTRA_TEXT,editTextcompartir.getText().toString());
                intento.setPackage("com.whatsapp");
               if(getPackageManager().getLaunchIntentForPackage("com.whatsapp")!=null){
                   startActivity(intento);

               }
               else{
                   Toast.makeText(MainActivity.this,"Instala WhatsApp",Toast.LENGTH_LONG).show();
               }
          }
        });*/


    }


}
