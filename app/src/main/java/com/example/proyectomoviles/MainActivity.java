package com.example.proyectomoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button boton_insertar, boton_visualizar, boton_eliminar, boton_actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_botones();
    }


    private void init_botones(){
        boton_insertar = (Button) findViewById(R.id.button_insertar_ACT_main);
        boton_insertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Insertar2Activity.class);
                //intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });

        boton_visualizar = (Button) findViewById(R.id.button_visualizar_ACT_main);
        boton_visualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), VisualizarActivity.class);
                //intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });

        boton_eliminar = (Button) findViewById(R.id.button_eliminar_ACT_main);
        boton_eliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), EliminarActivity.class);
                //intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });

        boton_actualizar = (Button) findViewById(R.id.button_actualizar_ACT_main);
        boton_actualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), ActualizarActivity.class);
                //intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });
    }


}