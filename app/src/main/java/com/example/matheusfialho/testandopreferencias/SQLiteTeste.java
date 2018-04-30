package com.example.matheusfialho.testandopreferencias;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteTeste extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_teste);

        Button butCadastrar = (Button) findViewById(R.id.butCadastrar);

        butCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControladorBanco crud = new ControladorBanco(getBaseContext());
                EditText editNome = (EditText) findViewById(R.id.editNome);
                EditText editIdade = (EditText) findViewById(R.id.editIdade);
                String nome = editNome.getText().toString();
                int idade = Integer.parseInt(editIdade.getText().toString());
                String resultado;

                resultado = crud.insereDado(nome, idade);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

    }
}
