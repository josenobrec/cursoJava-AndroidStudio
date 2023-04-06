package com.cursoandroid.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

   /* private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    */

    private ImageView imageFoto;
    private Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Cadastro de usuario
        usuario.createUserWithEmailAndPassword(
                "jamilton2@gmail.com", "ja12345")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser", "Sucesso ao Cadastrar usuario!");
                        }else {
                            Log.i("CreateUser", "ERRO ao Cadastrar usuario!");
                        }
                    }
                });*/

        /*Verifica usuario logado
        if (usuario.getCurrentUser() != null){
            Log.i("CurrentUser", "Usuario logado!");
        }else{
            Log.i("CurrentUser", "Usuario não logado!");
        }*/

        /*Deslogar usuario*/
        //usuario.signOut();

        /*Logar usuario
        usuario.signInWithEmailAndPassword(
                "jamilton2@gmail.com", "ja12345")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("sigIn", "Sucesso ao logar usuario!");
                        }else {
                            Log.i("signIn", "ERRO ao logar usuario!");
                        }
                    }

                });*/

        //DatabaseReference usuarios = referencia.child("usuarios");

        /*Usuario usuario = new Usuario();

        usuario.setNome("José Renato");
        usuario.setSobrenome("Silva");
        usuario.setIdade(31);

        usuarios.push().setValue(usuario);

        usuario.setNome("Jamilton");
        usuario.setSobrenome("Damasceno");
        usuario.setIdade(30);

        usuarios.push().setValue(usuario);

        usuario.setNome("Mariana");
        usuario.setSobrenome("Silvério");
        usuario.setIdade(45);

        usuarios.push().setValue(usuario);

        usuario.setNome("Marcelo");
        usuario.setSobrenome("Farias");
        usuario.setIdade(18);

        usuarios.push().setValue(usuario);

        usuario.setNome("Ana");
        usuario.setSobrenome("Ribeiro");
        usuario.setIdade(22);

        usuarios.push().setValue(usuario);

        usuario.setNome("Rodrigo");
        usuario.setSobrenome("Matos");
        usuario.setIdade(35);

        usuarios.push().setValue(usuario);*/

        //DatabaseReference usuarioPesquisa = usuarios.child("-MxfFHWomPV1x57yTw1J");
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Marcelo");
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(3); // Limta a pesquisa aos 3 primeiros usuarios
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(3); // Limta a pesquisa aos 3 ultimos usuarios

        /*Maior ou igual (>=)
        Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(35);

         */

        /*Menor ou igual (<=)
        Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(22);/*

        /*Entre dois valores
        Query usuarioPesquisa = usuarios.orderByChild("idade")
                                        .startAt(18)
                                        .endAt(30);*/

        /*Filtrar Palavras
        Query usuarioPesquisa = usuarios.orderByChild("nome")
                                        .startAt("J")
                                        .endAt("J" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.i("Dados usuario: ", dataSnapshot.getValue().toString());

                /*Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                Log.i("Dados usuario: ", "nome " + dadosUsuario.getNome() + " idade " + dadosUsuario.getIdade());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        /*
        //referencia.child("pontos").setValue("200");
        //referencia.child("usuarios2").child("001").child("nome").setValue("Jamilton");
        DatabaseReference usuarios = referencia.child("usuarios");
        // DatabaseReference usuarios = referencia.child("usuarios").child("001"); ==> Recupera um unico usuario id 001
        DatabaseReference produtos = referencia.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*Usuario usuario = new Usuario();

        usuario.setNome("Jamilton");
        usuario.setSobrenome("Damasceno");
        usuario.setIdade(25);

        usuarios.child("001").setValue(usuario);

        usuario.setNome("Maria");
        usuario.setSobrenome("Silva");
        usuario.setIdade(45);

        usuarios.child("002").setValue(usuario);*/
/*
        Produto produto = new Produto();
        produto.setDescricao("Nexus");
        produto.setMarca("LG");
        produto.setPreco(899.99);

        produtos.child("001").setValue(produto);

        produto.setDescricao("Acer Aspire");
        produto.setMarca("Acer");
        produto.setPreco(999.99);

        produtos.child("002").setValue(produto);
*/

        buttonUpload = findViewById(R.id.buttonUpload);
        imageFoto = findViewById(R.id.imageFoto);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Configura para imagem ser salva em memória
                imageFoto.setDrawingCacheEnabled(true);
                imageFoto.buildDrawingCache();

                //Recuperar bitmap da imagem (image a ser carregada)
                Bitmap bitmap = imageFoto.getDrawingCache();

                //Comprimo bitmap para um formato png/jpeg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);

                //Converte o baos para pixel brutos em uma matriz de bytes
                //(dados da imagem)
                byte[] dadosImagem = baos.toByteArray();

                //Define nós para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = storageReference.child("imagens");
                StorageReference imagemRef = imagens.child("celular.jpeg");

                Glide.with(MainActivity.this)
                        .using(new FirebaseImageLoader())
                        .load(imagemRef)
                        .into(imageFoto);

                //Nome da imagem
                //String nomeArquivo = UUID.randomUUID().toString();
                //StorageReference imagemRef = imagens.child(nomeArquivo + ".jpeg");
                //StorageReference imagemRef = imagens.child("celular.jpeg");

                //Retorna o objeto que irá controlar o upload
                /*UploadTask uploadTask = imagemRef.putBytes(dadosImagem);

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "Upload da Imagem falhou: " + e.getMessage().toString(),
                                Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        imagemRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                Uri url = task.getResult();
                                Toast.makeText(MainActivity.this,
                                        "Sucesso ao fazer upload: ",
                                        Toast.LENGTH_LONG).show();
                            }
                        });*/

                  }
            });

                //Deletar Imagem

                //StorageReference imagemRef = imagens.child("celular.jpeg");
                //StorageReference imagemRef = imagens.child("61aa48a6-0f34-49c9-8703-ed9856a2d4e2.jpeg");

                /*imagemRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "Erro ao deletar: ",
                                Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,
                                "Sucesso ao Deletar ",
                                Toast.LENGTH_LONG).show();
                    }
                });

                 */


/*
            }
        });

 */



    }
}

