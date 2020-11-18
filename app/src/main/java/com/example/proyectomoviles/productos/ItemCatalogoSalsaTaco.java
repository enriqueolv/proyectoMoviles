package com.example.proyectomoviles.productos;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemCatalogoSalsaTaco implements Parcelable {
    int id;
    String salsa;

    public ItemCatalogoSalsaTaco(){}
    public ItemCatalogoSalsaTaco(int id, String salsa){}

    protected ItemCatalogoSalsaTaco(Parcel in) {
        id = in.readInt();
        salsa = in.readString();
    }

    public static final Creator<ItemCatalogoSalsaTaco> CREATOR = new Creator<ItemCatalogoSalsaTaco>() {
        @Override
        public ItemCatalogoSalsaTaco createFromParcel(Parcel in) {
            return new ItemCatalogoSalsaTaco(in);
        }

        @Override
        public ItemCatalogoSalsaTaco[] newArray(int size) {
            return new ItemCatalogoSalsaTaco[size];
        }
    };

    //GETTERS
    public int getId() {return id;}
    public String getSalsa() {return salsa;}

    //SETTERS
    public void setId(int id) {this.id = id;}
    public void setSalsa(String salsa) {this.salsa = salsa;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(salsa);
    }
}
