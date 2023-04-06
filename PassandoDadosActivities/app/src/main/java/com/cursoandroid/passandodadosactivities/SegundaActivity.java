package com.cursoandroid.passandodadosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);

        //**********Recuperar Dados Enviados*************************

        Bundle dados = getIntent().getExtras(); //Com o objeto Bundle é possivel recuperar os dados enviados de uma Activity para outra
        String nome = dados.getString("nome"); //método get. pode recuperar string, int, double, boolean e etc
        int idade = dados.getInt("idade");
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        //**********Configurar valores recuperados**********************

        //textNome.setText(nome);
        textNome.setText(usuario.getEmail());
        textIdade.setText(String.valueOf(idade)); //valueOf é possivel passar int, char, long e etc. Converte qualquer valor para String
    }
}