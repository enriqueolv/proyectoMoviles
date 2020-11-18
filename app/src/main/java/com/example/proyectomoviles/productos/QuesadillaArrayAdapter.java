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

public class QuesadillaArrayAdapter extends ArrayAdapter<Quesadilla> {
    private ArrayList<Quesadilla> dataSet;
    Context mContext;

    //View lookup cache
    private static class ViewHolder{
        TextView txtNumQuesadilla;
        TextView txtIngrediente;
        TextView txtSalsa;
        TextView txtQueso;
    }

    public QuesadillaArrayAdapter(ArrayList<Quesadilla> data, Context context){
        super(context, R.layout.view_quesadilla, data);
        this.dataSet = data;
        this.mContext = context;
    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Quesadilla dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.view_quesadilla, parent, false);
            viewHolder.txtNumQuesadilla = (TextView) convertView.findViewById(R.id.viewQuesadilla_textViewNumQuesadilla);
            viewHolder.txtIngrediente = (TextView) convertView.findViewById(R.id.viewQuesadilla_textViewIngrediente);
            viewHolder.txtSalsa = (TextView) convertView.findViewById(R.id.viewQuesadilla_textViewSalsa);
            viewHolder.txtQueso = (TextView) convertView.findViewById(R.id.viewQuesadilla_textViewQueso);

            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.txtNumQuesadilla.setText("Num. Quesadilla: " + Integer.toString(position + 1));
        viewHolder.txtIngrediente.setText(dataModel.getIngrediente());
        if(dataModel.getTipo_salsa() == 0){
            viewHolder.txtSalsa.setText("Verde");
        }else{
            viewHolder.txtSalsa.setText("Roja");
        }

        if (dataModel.getQueso()){
            viewHolder.txtQueso.setText("Con queso");
        }else{
            viewHolder.txtQueso.setText("");
        }

        return convertView;
    }
}
