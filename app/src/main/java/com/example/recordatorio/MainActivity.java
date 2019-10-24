package com.example.recordatorio;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView fecha;
    DatePicker simpleDatePicker;
    Button buttonFecha,buttonRecordatorio;
    int day,month,year;
    LocalDate today;
    String cadena;
    Calendar c;
    int diferencia;
    int days;
    int num_dia;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha=findViewById(R.id.textViewFecha);
        buttonFecha=findViewById(R.id.buttonFecha);
        buttonRecordatorio=findViewById(R.id.buttonRecordatorio);





        buttonFecha.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {


               c=Calendar.getInstance();
                day=c.get(Calendar.DAY_OF_MONTH);
                month=c.get(Calendar.MONTH);
                year=c.get(Calendar.YEAR);

                dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        fecha.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
                    }
                },day,month,year);
                dpd.show();


            }
        });



        buttonRecordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendarNow= Calendar.getInstance();
                days=calendarNow.get(Calendar.DAY_OF_YEAR);

                Calendar calendar=Calendar.getInstance();
                calendar.set(year,month,day);
                num_dia=calendar.get(Calendar.DAY_OF_YEAR);

                /*Calendar c = Calendar.getInstance();
                c.set(año, mes, dia);
                num_dia = Calendar.DAY_OF_YEAR;
                String d = Integer.valueOf(num_dia).toString();
                tvdias.setText(d);*/


                diferencia=days-num_dia;


              if(diferencia==0 )
              {

                          cadena = "Felicita al cumpleñero/a, hoy es su cumple";

              }

              else{
                   cadena="Quedan "+diferencia+" para que sea el cumpleaños";
              }

                Toast.makeText(MainActivity.this,"Dias "+diferencia+"DAYS:"+days+"NUM_dia"+num_dia,Toast.LENGTH_LONG).show();
            //  simpleDatePicker.

               /* Intent intento=new Intent(Intent.ACTION_SEND);
                intento.setType("text/plain");
                intento.putExtra(Intent.EXTRA_TEXT,cadena);
                intento.setPackage("com.whatsapp");
                if(getPackageManager().getLaunchIntentForPackage("com.whatsapp")!=null){
                    startActivity(intento);

                }
                else{
                    Toast.makeText(MainActivity.this,"Instala WhatsApp",Toast.LENGTH_LONG).show();
                }*/

            }
        });




    }



}
