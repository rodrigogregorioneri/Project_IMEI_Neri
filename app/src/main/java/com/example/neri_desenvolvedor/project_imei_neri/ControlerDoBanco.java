package com.example.neri_desenvolvedor.project_imei_neri;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by NERI-DESENVOLVEDOR on 03/04/2016.
 */
public class ControlerDoBanco {
    private SQLiteDatabase db;
    private CriaDataBase banco;
    private SQLiteDatabase bd;

    public ControlerDoBanco(Context context) {
        banco = new CriaDataBase(context);
        bd = banco.getWritableDatabase();
    }

    public String insereDado(String email, String data, String senha, String sexo, String imei, String imsi, String operadora, String modelo) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaDataBase.getEMAIL(), email);
        valores.put(CriaDataBase.getDATA(), data);
        valores.put(CriaDataBase.getSENHA(), senha);
        valores.put(CriaDataBase.getSEXO(), sexo);
        valores.put(CriaDataBase.getIMEI(), imei);
        valores.put(CriaDataBase.getIMSI(), imsi);
        valores.put(CriaDataBase.getOPERADORA(), operadora);
        valores.put(CriaDataBase.getMODELO(), modelo);
        resultado = db.insert(CriaDataBase.getTABELA(), null, valores);
        db.close();
        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro Inserido com sucesso";
        }
    }

    public boolean buscar(String senha) {
        String[] colunas = new String[]{"senha"};
        Cursor cursor = bd.query("user", colunas, senha, null, null, null, "senha");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Login l = new Login();
                l.setSenha(cursor.getColumnName(0));
                return true;
            } while (cursor.moveToNext());
        }
        return false;
    }


    public boolean autentica(String email, String senha) {
        Cursor c = db.rawQuery("SELECT * FROM user where email =" + email + " AND senha=" + senha, null);


        Login result_login = new Login();

        try {
            if (c.moveToFirst()) {
                result_login.setEmail(c.getString(0));
                result_login.setSenha(c.getString(1));

            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }







}