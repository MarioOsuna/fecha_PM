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
    Button buttonFecha,buttonRecordatorio;
    int day,month,year;
    String cadena;
    Calendar c;
    int diferencia;
    int days;
    int num_dia=0;
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
                        day=mDay;
                        month=mMonth;

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
                calendar.set(2019,month,day);
                num_dia=calendar.get(Calendar.DAY_OF_YEAR);


                diferencia=days-num_dia;


              if(diferencia==0 )
              {

                          cadena = "Felicita al cumpleñero/a, hoy es su cumple";

              }

              else {
                  if(diferencia<0)
                      diferencia=num_dia-days;


                   cadena="Quedan "+diferencia+" días para que sea el cumpleaños";
              }



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




    }



}
