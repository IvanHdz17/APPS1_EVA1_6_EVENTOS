package com.example.eva1_6_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnListener, btnClaseAnonima, btnClase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListener = findViewById(R.id.btnListener);
        btnClaseAnonima = findViewById(R.id.btnClaseAnonima);
        btnClase = findViewById(R.id.btnClase);

        btnListener.setOnClickListener(this);
        btnClaseAnonima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "EVENTO POR CLASE ANONIMA", Toast.LENGTH_SHORT).show();
                //Contexto: Recursos graficos de la actividad
                //Otra forma de obtenerlo: getApplicationContext()
            }
        });

        MiClaseOnClick objClick = new MiClaseOnClick();
        objClick.setContext(this);
        btnClase.setOnClickListener(objClick);
        //X objX; //Declaracion
        //objX = new X(); //Instanciacion o darle memoria al objeto
    }

 //LISTENERS (INTERFACES) SON OBJETOS, IMPLEMENTAN UN METODO (RESPUESTA AL EVENTO)
    //USANDO LA PROPIEDAD android:onclick DEL WIDGET
    // SINTAXIS: public void NOMBREDELMETODO(view arg){

    public void miClick(View arg){
        //MOSTRAR UN MENSAJE (TOAST: MENSAJE BREVE)
        //this = MainActivity
        Toast.makeText(this, "EVENTO POR ONCLICK XML", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "EVENTO POR ONCLICK LISTENER", Toast.LENGTH_SHORT).show();
    }
}

