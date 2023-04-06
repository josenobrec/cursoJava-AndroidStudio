package com.cursoandroid.classesemetodosnapratica;

class Animal {

    int tamanho;
    String cor;
    double peso;

    //Getter e Setter

    void setCor(String cor){
        //Formatação ou Validacao
        this.cor = cor;
    }

    String getCor(){
        return this.cor;
    }

    void dormir(){
        System.out.println("Dormir Como um animal");
    }

    void correr(){
        System.out.println("Correr Como um animal");
    }

}
