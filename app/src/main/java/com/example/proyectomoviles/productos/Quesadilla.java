package com.example.proyectomoviles.productos;

import android.os.Parcel;
import android.os.Parcelable;

public class Quesadilla implements Parcelable {
    private String ingrediente;
    private int tipo_salsa;
    private boolean queso;


    public Quesadilla(){}

    public Quesadilla(String ingrediente, int tipo_salsa, boolean queso) {
        this.ingrediente = ingrediente;
        this.tipo_salsa = tipo_salsa;
        this.queso = queso;
    }


    protected Quesadilla(Parcel in) {
        ingrediente = in.readString();
        tipo_salsa = in.readInt();
        queso = in.readByte() != 0;
    }

    public static final Creator<Quesadilla> CREATOR = new Creator<Quesadilla>() {
        @Override
        public Quesadilla createFromParcel(Parcel in) {
            return new Quesadilla(in);
        }

        @Override
        public Quesadilla[] newArray(int size) {
            return new Quesadilla[size];
        }
    };

    //GETTERS
    public String getIngrediente() {return ingrediente;}
    public int getTipo_salsa() {return tipo_salsa;}
    public boolean getQueso() {return queso;}
    //SETTERS
    public void setIngrediente(String ingrediente) {this.ingrediente = ingrediente;}
    public void setTipo_salsa(int tipo_salsa) {this.tipo_salsa = tipo_salsa;}
    public void setQueso(boolean queso) {this.queso = queso;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ingrediente);
        dest.writeInt(tipo_salsa);
        dest.writeByte((byte) (queso ? 1 : 0));
    }
}
