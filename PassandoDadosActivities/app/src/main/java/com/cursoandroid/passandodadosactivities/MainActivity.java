package com.cursoandroid.passandodadosactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent ==> intenção, o que quer fazer?
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class); //Criar uma nova intent e instanciar
                //passar 2 parametros o primeiro é o contexto e o segundo é para qual activity pretende ir

                //**********Instanciar o Objeto**********************

                Usuario usuario = new Usuario("Jamilton", "jamilton@gmail.com");

                //**********Passar dados*************************
                             // ==> de uma activity para outra precisamos utilizar o objeto intent e o metodo putExtra,
                                    //o método putExtra recebe uma String e o segundo int value, pode utilizar varios parametros
                intent.putExtra("nome", "Maria"); // com o metodo putExtra pode passar qualquer valor
                intent.putExtra("idade", 40);
                intent.putExtra("objeto", usuario);

                startActivity(intent);
                //iniciar uma nova activity(abrir nova atividade), porem precisa passar um parametro que é uma intent(objeto intent)

            }
        });
    }
}