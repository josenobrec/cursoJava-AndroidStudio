package com.cursoandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show(); //primeiro método que é chamado em um clico de vida de uma activity é o
                                                                                //onCreate
    }

    @Override
    protected void onStart() { // Segundo método chamado é o onStart
        super.onStart();

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show(); //Terceiro método chamado
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() { // é chamado quando a atividade já foi fechada, mas não foi encerrada. Esta aguardando retornar nesta atividade
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() { // Ao chamar o processo onRestart, todo o processo é reiniciado apartir do onStart.
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetachedFromWindow() { //Quando encerra o app este método é chamado
        super.onDetachedFromWindow();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}