package com.cursoandroid.executandovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Esconde a StatusBar e Barra de navegação
        View decorView = getWindow().getDecorView();//recupera objeto de tela. recupera obj que permite manipular componentes de tela
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOpcoes);

        //Esconde a ActionBar
        getSupportActionBar().hide();

        //Executar o vídeo
        videoView.setMediaController(new MediaController(this)); // controlador do video, botões play, avançar e voltar
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video); //configurar o local que esta o video e localiza o nome do pacote e o video que deseja executar
        videoView.start(); // start do video

    }
}