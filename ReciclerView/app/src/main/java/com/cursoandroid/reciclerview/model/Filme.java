package com.cursoandroid.reciclerview.model;

public class Filme {

    private String tituloFilme;
    private String genero;
    private String ano;

    public Filme(){ //Instaciar a Classe Filme sem passar parametros

    }

    public Filme(String tituloFilme, String genero, String ano) { //Construtor Filme
        this.tituloFilme = tituloFilme;
        this.genero = genero;
        this.ano = ano;
    }

    //Métodos Getter and Setter para recuperar os valores

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
