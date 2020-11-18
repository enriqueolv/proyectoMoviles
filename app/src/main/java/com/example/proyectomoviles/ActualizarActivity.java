package com.example.proyectomoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActualizarActivity extends AppCompatActivity {
    Button boton_insertar, boton_regresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        init_botones();
    }


    private void init_botones(){
        boton_regresar = (Button) findViewById(R.id.button_regresar_ACT_actualizar);
        boton_regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                //intent.putExtra("arrayTacos", arrayTacos);
                startActivity(intent);
            }
        });
    }
}