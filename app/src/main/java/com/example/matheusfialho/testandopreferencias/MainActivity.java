package com.example.matheusfialho.testandopreferencias;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String valorName = null;
    private int valorIdade = 0;
    private Button button;
    private EditText editName;
    private EditText editIdade;
    //public SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this); OUTRO MODO DE USAR

    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.editName);
        editIdade = (EditText) findViewById(R.id.editIdade);
        button = (Button) findViewById(R.id.button);
        preferences = getSharedPreferences("pref", MODE_PRIVATE );
        //editor = preferences.edit();
        checkPreferences();
        register();

        Button butCadastrar = (Button) findViewById(R.id.butCadastrar);
        butCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapScreen(MainActivity.this, SQLiteTeste.class);
            }
        });

    }

    // Cadastrando Usúário ao clicar em cadastrar
    private void register(){
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                insetPreferences();
                Toast.makeText(getApplicationContext(), "Cadastrado", Toast.LENGTH_SHORT).show();
                // Mudando para tela com as informações fornecidas (PerfilActivity)
                swapScreen(MainActivity.this, PerfilActivity.class);
            }

        });

    }

    // Conferindo se já existe preferência de usuário salva
    private  void checkPreferences(){
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        valorName = preferences.getString("valorName", null);
        valorIdade = preferences.getInt("valorId", -1);

        // Se já tiver troca para tela de Perfil
        if(valorName != null && valorIdade > 0){
            swapScreen(MainActivity.this, PerfilActivity.class);
        }
    }

    // Trocando para a tela PerfilActivity
    public void swapScreen(Context context, Class classe){
        Intent intent = new Intent(context, classe);
        startActivity(intent);
    }

    // Inserindo nosvas preferências caso não haja nenhuma salva
    private void insetPreferences(){
        checkPreferences();
        valorName = editName.getText().toString();
        valorIdade = Integer.parseInt(editIdade.getText().toString());
        editor = preferences.edit();
        editor.putString("valorName", valorName);
        editor.putInt("valorId", valorIdade);
        editor.apply();

        /*
        if (valorName == null && valorIdade <= 0){

        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        */
    }
    protected void onResume (){
        super.onResume();
    }
    protected void onDestroy(){
        super.onDestroy();
    }
}
