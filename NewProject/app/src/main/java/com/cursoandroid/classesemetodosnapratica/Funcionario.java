package com.cursoandroid.classesemetodosnapratica;

class Funcionario {

    //Propriedades
    String nome;
    double salario;


    //Métodos - sem retorno
    /*void recuperarSalario(){

       this.salario = this.salario - (this.salario *0.1);
        System.out.println(this.salario);

    } */

    //Método - Com Retorno

    double recuperarSalario(double bonus, double descontoAdicional) {
        this.salario = this.salario - (this.salario * 0.1);
        return this.salario + bonus -descontoAdicional;
    }
}
