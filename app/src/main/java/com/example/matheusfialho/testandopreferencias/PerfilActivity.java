package com.example.matheusfialho.testandopreferencias;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {

    private TextView TextViewName;
    private TextView TextViewIdade;
    private MainActivity mainActivity = new MainActivity();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        TextViewName = (TextView) findViewById(R.id.namePerfil);
        TextViewIdade = (TextView) findViewById(R.id.idadePerfil);
        Button button = (Button) findViewById(R.id.buttonClear);
        //Evendo do clique do botão "Limpar Preferencias"
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clearPreferences();
                swapScreen(PerfilActivity.this, MainActivity.class);
            }

        });

        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        //Inicializando as preferências do usuário
        mainActivity.preferences = getSharedPreferences("pref", MODE_PRIVATE );
        // Setando as preferência em duas TextView
        TextViewName.setText(mainActivity.preferences.getString("valorName", null));
        TextViewIdade.setText(String.valueOf(mainActivity.preferences.getInt("valorId", -1)));
    }

    // Troca de tela
    public void swapScreen(Context origem, Class destino ){
        Intent intent = new Intent(origem, destino);
        startActivity(intent);
    }

    //Limpando as preferencias
    private void clearPreferences() {
        mainActivity.editor = mainActivity.preferences.edit();
        mainActivity.editor.clear();
        mainActivity.editor.apply();

        /*
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("Pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mainActivity.editor = mainActivity.preferences.edit();
        */
    }
}
