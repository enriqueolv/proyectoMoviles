package com.example.proyectomoviles.productos;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemCatalogoTipoBebida implements Parcelable {
    int id;
    String tipo;

    public ItemCatalogoTipoBebida(){}
    public ItemCatalogoTipoBebida(int id, String tipo){}

    protected ItemCatalogoTipoBebida(Parcel in) {
        id = in.readInt();
        tipo = in.readString();
    }

    public static final Creator<ItemCatalogoTipoBebida> CREATOR = new Creator<ItemCatalogoTipoBebida>() {
        @Override
        public ItemCatalogoTipoBebida createFromParcel(Parcel in) {
            return new ItemCatalogoTipoBebida(in);
        }

        @Override
        public ItemCatalogoTipoBebida[] newArray(int size) {
            return new ItemCatalogoTipoBebida[size];
        }
    };

    //GETTERS
    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(tipo);
    }
}
