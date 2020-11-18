package com.example.proyectomoviles.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectomoviles.MainActivity;
import com.example.proyectomoviles.R;

public class FragTacosACTInsertar extends Fragment {
    Button boton_insertar, boton_regresar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_frag_tacos_act_insertar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init_botones();
    }

    public void init_botones(){
        boton_regresar = (Button) getView().findViewById(R.id.button_regresar_ACT_insertar_FRAG_taco);
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
