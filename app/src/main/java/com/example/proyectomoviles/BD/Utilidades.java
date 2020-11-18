package com.example.proyectomoviles.BD;

public class Utilidades {
    public static final String BD_TACOS = "BD_TACOS";
    public static final String TABLA_TACOS = "Tacos";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_CARNE = "carne";
    public static final String CAMPO_TIPO_SALSA = "tipo_salsa";
    public static final String CAMPO_LIMON = "limon";
    public static final String CAMPO_CILANTRO = "cilantro";
    public static final String CAMPO_CEBOLLA = "cebolla";

    public static final String SQL_CREAR_TABLA_TACOS = "CREATE TABLE "+  TABLA_TACOS  +" ("+ CAMPO_ID +" INTEGER, "+ CAMPO_CARNE +" VARCHAR(255), "+CAMPO_TIPO_SALSA+" INTEGER, "+CAMPO_LIMON+" BOOLEAN, "+CAMPO_CILANTRO+" BOOLEAN, "+CAMPO_CEBOLLA+" BOOLEAN)";

}
