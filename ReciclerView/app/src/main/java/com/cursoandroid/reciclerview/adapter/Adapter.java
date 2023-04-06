package com.cursoandroid.reciclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.reciclerview.R;
import com.cursoandroid.reciclerview.model.Filme;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewwHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @Override
    public MyViewwHolder onCreateViewHolder(ViewGroup parent, int viewType) {   //MyViewHolder-->> Nome da Classe do objeto que iremos criar
                                                                                // onCreateViewHolder -->> é chamado para que possamos criar as visualizações
        View itemLista = LayoutInflater.from(parent.getContext())   //Converter o xml em objeto tipo View, utiliza a clase LayoutInflater
        .inflate(R.layout.adapter_lista, parent, false);//parent é o componente que o item de lista esta dentro. Método inflate usa 3 parametros

        return new MyViewwHolder(itemLista); //O método onCreateViewwHolder--> irá criar o itemLista que é a visualização baseado no xml
    }

    @Override
    public void onBindViewHolder(MyViewwHolder holder, int position) { // onBindViewHolder--> Visualização

        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount() { //getItemCount--> retorna a quantidade de itens que será exibido
        return listaFilmes.size();
    }

    public class MyViewwHolder extends RecyclerView.ViewHolder{ //Essa Classe (MyViewwHolder) será responsavel por guardar cada um dos dados,
                                                                // antes deles serem exibidos na Tela(Titulo, Ano e Genero)
        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewwHolder(/*@NonNull*/ View itemView) { //Recuperar os componentes de tela
            super(itemView); //acessar os itens aqui dentro

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }

}
