package com.example.proyectomoviles.productos;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemCatalogoSalsaQuesadilla implements Parcelable {
    int id;
    String salsa;

    public ItemCatalogoSalsaQuesadilla(){}
    public ItemCatalogoSalsaQuesadilla(int id, String salsa){}

    protected ItemCatalogoSalsaQuesadilla(Parcel in) {
        id = in.readInt();
        salsa = in.readString();
    }

    public static final Creator<ItemCatalogoSalsaQuesadilla> CREATOR = new Creator<ItemCatalogoSalsaQuesadilla>() {
        @Override
        public ItemCatalogoSalsaQuesadilla createFromParcel(Parcel in) {
            return new ItemCatalogoSalsaQuesadilla(in);
        }

        @Override
        public ItemCatalogoSalsaQuesadilla[] newArray(int size) {
            return new ItemCatalogoSalsaQuesadilla[size];
        }
    };

    //GETTERS
    public int getId() {
        return id;
    }
    public String getSalsa() {
        return salsa;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }
    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

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
