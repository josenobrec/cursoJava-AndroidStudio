package com.cursoandroid.reciclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cursoandroid.reciclerview.R;
import com.cursoandroid.reciclerview.RecyclerItemClickListener;
import com.cursoandroid.reciclerview.adapter.Adapter;
import com.cursoandroid.reciclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>(); //Lista de filmes, colocar em cada item desta lista um objeto filme

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //Configurar Adapter --> Recebe os dados e formata o Layout e utiliza no ReciclerView
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView --> Cria os itens
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager); //Configura o objeto layoutManager
        recyclerView.setHasFixedSize(true);  //Método para melhorar a performace do RecyclerView, que é a recomendação do google
                                            //este método irá otimizar o RecyclerView, dizendo que ele terá um tamanho fixo
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL)); // Lista com Divisor
        recyclerView.setAdapter(adapter); //Configura um adaptador

        //Evento de Click --> É possivel criar uma classe customizada do zero para tratar esse evento de click, porém o google já fornece algumas implementações
        // padrões para tratar este evento. Ao pesquisar click para recyclerView 
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) { //int position retorna a posição do item que foi clicado
                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item Pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click Longo: "+ filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void criarFilmes(){

        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão America - Guerra Civíl", "Aventura / Ficção", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu Malvado Favorito 3", "Comédia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        this.listaFilmes.add(filme);

    }
}