package com.cursoandroid.ToggleeSwitch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleSenha;
    private Switch switchSenha;
    private CheckBox checkSenha;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSenha = findViewById(R.id.toggleSenha);
        switchSenha = findViewById(R.id.switchSenha);
        textResultado= findViewById(R.id.textResultado);
        checkSenha= findViewById(R.id.checkSenha);

        adicionarListener();
    }

    public void adicionarListener() {

        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    textResultado.setText("Ligado");
                }else{
                    textResultado.setText("Desligado");
                }
            }
        });
    }

    public void enviar (View view){
        //if(toggleSenha.isChecked()){
        //if(switchSenha.isChecked()){
        if(checkSenha.isChecked()){
            textResultado.setText("Chek Ligado");
        }else{
            textResultado.setText("Check desligado");
        }

    }

    public void abrirToast(View view){

        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);

        TextView textView = new TextView(getApplicationContext());
        textView.setBackgroundResource(R.color.purple_700);
        textView.setText("Olá Toast");


        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        //toast.setView(imagem);
        toast.setView(textView);
        toast.show();

        /*
        Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso!",
                Toast.LENGTH_LONG
        ).show();
         */
    }

    public void abrirDialog(View view){

        //Instanciar AlertDialog

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //Configurar titulo e mensagem
        dialog.setTitle("Titulo da dialog");
        dialog.setMessage("Mensagem da Dialog");

        //Configurar Cancelamento
        dialog.setCancelable(false);//true permite o cancelamento, valor padrão. False não conseguie fechar o aviso

        //Configurar Icone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //Configurar ações para sim e não
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(
                        getApplicationContext(),
                        "Executar ação ao Clicar no botão Sim",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(
                        getApplicationContext(),
                        "Executar ação ao Clicar no botão Não",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();

    }
}