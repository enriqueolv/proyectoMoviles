package com.example.proyectomoviles.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.proyectomoviles.productos.Taco;

import java.util.ArrayList;

public class BDManager {

    public static void registrarListaDeTacosEnBD(Context context, ArrayList<Taco> arrayTacos){
        ConexionSQLiteOpenHelper conn = new ConexionSQLiteOpenHelper(context, Utilidades.BD_TACOS, null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        //Limpio la base de datos antes de agregar una nueva lista descargada
        db.execSQL("DELETE FROM " + Utilidades.TABLA_TACOS);

        for(int i=0; i<arrayTacos.size(); i++){
            Taco taco_actual = arrayTacos.get(i);

            ContentValues contentValues = new ContentValues();
            contentValues.put(Utilidades.CAMPO_ID, i);
            contentValues.put(Utilidades.CAMPO_CARNE, taco_actual.getCarne());
            contentValues.put(Utilidades.CAMPO_TIPO_SALSA, taco_actual.getTipo_salsa());
            contentValues.put(Utilidades.CAMPO_LIMON, taco_actual.getLimon());
            contentValues.put(Utilidades.CAMPO_CILANTRO, taco_actual.getCilantro());
            contentValues.put(Utilidades.CAMPO_CEBOLLA, taco_actual.getCebolla());

            Long idResultante = db.insert(Utilidades.TABLA_TACOS, Utilidades.CAMPO_ID, contentValues);
        }
        toast(context, "Todos los tacos añadidos a la BD", Toast.LENGTH_LONG);
        db.close();
    }

    public static ArrayList<Taco> cargarListaTacosDesdeBD(Context context){
        ArrayList<Taco> arrayTacos;
        arrayTacos = new ArrayList<Taco>();

        ConexionSQLiteOpenHelper conn = new ConexionSQLiteOpenHelper(context, Utilidades.BD_TACOS, null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        Taco taco_actual = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_TACOS, null);
        int id;

        while (cursor.moveToNext()){
            taco_actual = new Taco();
            id = cursor.getInt(0);
            taco_actual.setCarne(cursor.getString(1));
            taco_actual.setTipo_salsa(cursor.getInt(2));
            taco_actual.setLimon(cursor.getInt(3)==1);
            taco_actual.setCilantro(cursor.getInt(4)==1);
            taco_actual.setCebolla(cursor.getInt(5)==1);

            arrayTacos.add(taco_actual);
        }

        db.close();

        return arrayTacos;
    }

    private static void toast(Context context, String text, int time){
        Toast toast = Toast.makeText(context, text, time);
        toast.show();
    }
}
