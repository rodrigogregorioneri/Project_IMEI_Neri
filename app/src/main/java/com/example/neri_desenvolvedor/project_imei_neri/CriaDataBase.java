package com.example.neri_desenvolvedor.project_imei_neri;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NERI-DESENVOLVEDOR on 03/04/2016.
 */
public class CriaDataBase extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "user";
    private static final String ID = "_id";
    private static final String EMAIL = "email";
    private static final String DATA = "data";
    private static final String SENHA = "senha";
    private static final String SEXO = "sexo";
    private static final String IMEI = "imei";
    private static final String IMSI = "imsi";
    private static final String OPERADORA = "operadora";
    private static final String MODELO = "modelo";
    private static final int VERSAO = 1;
    protected SQLiteDatabase database;
    public CriaDataBase(Context context){
        super(context, getNomeBanco(),null, getVERSAO());
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getID() {
        return ID;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static String getDATA() {
        return DATA;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public static String getSEXO() {
        return SEXO;
    }

    public static String getIMEI() {
        return IMEI;
    }

    public static String getIMSI() {
        return IMSI;
    }

    public static String getOPERADORA() {
        return OPERADORA;
    }

    public static String getMODELO() {
        return MODELO;
    }
    public static int getVERSAO() {
        return VERSAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE "+ getTABELA() +"("
                + getID() +" integer primary key autoincrement,"
                + getEMAIL() +" text,"
                + getDATA() +" text,"
                + getSENHA() +" text,"
                + getSEXO() +" text,"
                + getIMEI() +" text,"
                + getIMSI() +" text,"
                + getOPERADORA() +" text,"
                + getMODELO() +" text"
                +")" +
                "INSERT INTO dados(email, senha) VALUES('a','a')";



            db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS "+ getTABELA());
                onCreate(db);
    }


}
