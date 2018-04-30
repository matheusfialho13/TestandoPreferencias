package com.example.matheusfialho.testandopreferencias;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ControladorBanco {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public ControladorBanco(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String nome, int idade) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, nome);
        valores.put(String.valueOf(CriaBanco.IDADE), idade);


        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";



    }
}
