package com.example.proyectomoviles.productos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectomoviles.R;

import java.util.ArrayList;

public class BebidaArrayAdapter extends ArrayAdapter<Bebida> {
    private ArrayList<Bebida> dataSet;
    Context mContext;

    //View lookup cache
    private static class ViewHolder{
        TextView txtNumBebida;
        TextView txtSabor;
        TextView txtTipo;
    }

    public BebidaArrayAdapter(ArrayList<Bebida> data, Context context){
        super(context, R.layout.view_bebida, data);
        this.dataSet = data;
        this.mContext = context;
    }

    private int lastPösition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Bebida dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.view_bebida, parent, false);
            viewHolder.txtNumBebida = (TextView) convertView.findViewById(R.id.viewBebida_textViewNumBebida);
            viewHolder.txtSabor = (TextView) convertView.findViewById(R.id.viewBebida_textViewSabor);
            viewHolder.txtTipo = (TextView) convertView.findViewById(R.id.viewBebida_textViewTipo);

            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPösition = position;

        viewHolder.txtNumBebida.setText("Num. Bebida: " + Integer.toString(position + 1));
        viewHolder.txtSabor.setText(dataModel.getSabor());
        switch (dataModel.getTipo()){
            case 0:
                viewHolder.txtTipo.setText("Refresco");
                break;
            case 1:
                viewHolder.txtTipo.setText("Jugo");
                break;
            case 2:
                viewHolder.txtTipo.setText("Agua");
                break;
            default:
                viewHolder.txtTipo.setText("Sin definir");
                break;
        }
        return convertView;
    }
}
