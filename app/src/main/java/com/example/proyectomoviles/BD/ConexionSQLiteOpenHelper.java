package com.example.proyectomoviles.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ConexionSQLiteOpenHelper extends SQLiteOpenHelper {
    Context contexto;

    public ConexionSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Este método se invoca al princippio y crea una nueva base de datos
        toast("BD método onCreate()", Toast.LENGTH_LONG);
        db.execSQL(Utilidades.SQL_CREAR_TABLA_TACOS);
        toast("BD mandada a crear tablas", Toast.LENGTH_LONG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Verifica si la base de datos que se pretende crear ya existe
        db.execSQL("DROP TABLE IF EXISTS " + Utilidades.TABLA_TACOS);
        onCreate(db);
    }


    public void toast(String text, int time){
        Toast toast = Toast.makeText(contexto, text, time);
        toast.show();
    }
}
