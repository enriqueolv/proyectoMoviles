package com.example.proyectomoviles.productos;

import android.os.Parcel;
import android.os.Parcelable;

public class Bebida implements Parcelable {
    private String sabor;
    private int tipo;

    public Bebida(){}

    public Bebida(String sabor, int tipo){
        this.sabor = sabor;
        this.tipo = tipo;
    }

    protected Bebida(Parcel in) {
        sabor = in.readString();
        tipo = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sabor);
        dest.writeInt(tipo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Bebida> CREATOR = new Creator<Bebida>() {
        @Override
        public Bebida createFromParcel(Parcel in) {
            return new Bebida(in);
        }

        @Override
        public Bebida[] newArray(int size) {
            return new Bebida[size];
        }
    };

    //GETTERS
    public String getSabor() {return sabor;}
    public int getTipo() {return tipo;}

    //SETTERS
    public void setSabor(String sabor) {this.sabor = sabor;}
    public void setTipo(int tipo) {this.tipo = tipo;}
}
