package com.example.proyectomoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.proyectomoviles.productos.Bebida;
import com.example.proyectomoviles.productos.BebidaArrayAdapter;
import com.example.proyectomoviles.productos.ItemCatalogoSalsaQuesadilla;
import com.example.proyectomoviles.productos.ItemCatalogoSalsaTaco;
import com.example.proyectomoviles.productos.ItemCatalogoTipoBebida;
import com.example.proyectomoviles.productos.Quesadilla;
import com.example.proyectomoviles.productos.QuesadillaArrayAdapter;
import com.example.proyectomoviles.productos.Taco;
import com.example.proyectomoviles.productos.TacoArrayAdapter;
import com.example.proyectomoviles.xmlManager.XMLManager;

import java.util.ArrayList;

public class VisualizarActivity extends AppCompatActivity {
    ArrayList<Taco> arrayTacos;
    ArrayList<Quesadilla> arrayQuesadillas;
    ArrayList<Bebida> arrayBebidas;

    ArrayList<ItemCatalogoSalsaTaco> catalogo_salsa_taco;
    ArrayList<ItemCatalogoSalsaQuesadilla> catalogo_salsa_quesadilla;
    ArrayList<ItemCatalogoTipoBebida> catalogo_tipo_bebida;

    ListView listView;

    RadioButton radio_tacos, radio_quesadillas, radio_bebidas;
    Button boton_visualizar, boton_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        arrayTacos = XMLManager.descargar_lista_tacos(getApplicationContext());
        arrayQuesadillas = XMLManager.descargar_lista_quesadillas(getApplicationContext());
        arrayBebidas = XMLManager.descargar_lista_bebidas(getApplicationContext());

        init_botones();

    }

    private void init_botones(){

        radio_tacos = findViewById(R.id.radioButton_tacos_ACT_visualizar);
        radio_quesadillas = findViewById(R.id.radioButton_quesadillas_ACT_visualizar);
        radio_bebidas = findViewById(R.id.radioButton_bebidas_ACT_visualizar);

        boton_visualizar = (Button) findViewById(R.id.button_visualizar_ACT_visualizar);
        boton_visualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(radio_tacos.isChecked()){
                    listView = (ListView) findViewById(R.id.listView_lista_ACT_visualizar);
                    TacoArrayAdapter adapter = new TacoArrayAdapter(arrayTacos, getApplicationContext());
                    listView.setAdapter(adapter);

                }else if(radio_quesadillas.isChecked()){
                    listView = (ListView) findViewById(R.id.listView_lista_ACT_visualizar);
                    QuesadillaArrayAdapter adapter = new QuesadillaArrayAdapter(arrayQuesadillas, getApplicationContext());
                    listView.setAdapter(adapter);

                }else if(radio_bebidas.isChecked()){
                    listView = (ListView) findViewById(R.id.listView_lista_ACT_visualizar);
                    BebidaArrayAdapter adapter = new BebidaArrayAdapter(arrayBebidas, getApplicationContext());
                    listView.setAdapter(adapter);

                }
            }
        });

        boton_regresar = (Button) findViewById(R.id.button_regresar_ACT_visualizar);
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