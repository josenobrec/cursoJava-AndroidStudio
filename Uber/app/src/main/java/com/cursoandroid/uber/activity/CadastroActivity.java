package com.cursoandroid.uber.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.cursoandroid.uber.R;
import com.cursoandroid.uber.config.ConfiguracaoFirebase;
import com.cursoandroid.uber.helper.UsuarioFirebase;
import com.cursoandroid.uber.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText campoNome, campoEmail, campoSenha;
    private Switch switchTipoUsuario;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Inicializar os componentes
        campoNome           = findViewById(R.id.editCadastroNome);
        campoEmail          = findViewById(R.id.editCadastroEmail);
        campoSenha          = findViewById(R.id.editCadastroSenha);
        switchTipoUsuario   = findViewById(R.id.switchTipoUsuario);
    }

    public void validarCadastroUsuario(View view){

        //Recupera textos dos campos
        String textoNome     = campoNome.getText().toString();
        String textoEmail    = campoEmail.getText().toString();
        String textoSenha    = campoSenha.getText().toString();

        if(!textoNome.isEmpty()){//verifica nome
            if(!textoEmail.isEmpty()){//verifica e-mail
                if(!textoSenha.isEmpty()){//verifica senha

                    Usuario usuario = new Usuario();
                    usuario.setNome(textoNome);
                    usuario.setEmail(textoEmail);
                    usuario.setSenha(textoSenha);
                    usuario.setTipo(verificaTipoUsuario());

                    cadastrarUsuario(usuario);

                }else{
                    Toast.makeText(CadastroActivity.this,
                            "Preencha a senha",
                            Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(CadastroActivity.this,
                        "Preencha o E-mail",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(CadastroActivity.this,
                    "Preencha o nome",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void cadastrarUsuario(Usuario usuario){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                   try {

                       String idUsuario = task.getResult().getUser().getUid();
                       usuario.setId(idUsuario);
                       usuario.salvar();

                       //Atualizar nome no UserProfile
                       UsuarioFirebase.atualizarNomeUsuario(usuario.getNome());

                       //Redireciona o usuário com base no seu tipo
                       //Se o usuario for passageiro chama a activity maps
                       //Senão chama a activity requisições

                       if(verificaTipoUsuario() == "P"){
                           startActivity(new Intent(CadastroActivity.this, PassageiroActivity.class));
                           finish();

                           Toast.makeText(CadastroActivity.this,
                                   "Sucesso ao cadastrar Usuário",
                                   Toast.LENGTH_SHORT).show();

                       }else{
                           startActivity(new Intent(CadastroActivity.this, RequisicoesActivity.class));
                           finish();

                           Toast.makeText(CadastroActivity.this,
                                   "Sucesso ao cadastrar Motorista",
                                   Toast.LENGTH_SHORT).show();
                       }

                   }catch (Exception e){
                       e.printStackTrace();
                   }
                }else{

                    String excecao = "";
                    try {
                        throw task.getException();
                    }catch ( FirebaseAuthWeakPasswordException e){
                        excecao = "Digite uma senha mais forte!";
                    }catch ( FirebaseAuthInvalidCredentialsException e){
                        excecao= "Por favor, digite um e-mail válido";
                    }catch ( FirebaseAuthUserCollisionException e){
                        excecao = "Este conta já foi cadastrada";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário: "  + e.getMessage();
                        e.printStackTrace();
                    }

                }
            }
        });



    }

    public String verificaTipoUsuario(){
        return switchTipoUsuario.isChecked() ? "M" : "P";
    }
}