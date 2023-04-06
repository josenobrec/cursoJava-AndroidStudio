package com.cursoandroid.classesemetodosnapratica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Obama obama =new Obama();
        obama.direitosDeveres();

        /*

        ContaBancaria conta = new ContaBancaria(); //Ira chamar o construtor configurações iniciais

        ContaBancaria conta = new ContaBancaria(1066); //Chamar o construtor de acordo com o parametro

        Pessoa pessoa = new Pessoa();
        pessoa.exibirDados("Maria", 52);

        Conta conta = new Conta();
        conta.depositar(100);//200
        conta.sacar(50);//150

        System.out.println(conta.recuperarSaldo());

        Cao cao = new Cao();
        cao.setCor("Azul");

        System.out.println(cao.getCor());

        cao.dormir();
        cao.latir();


        Passaro passaro = new Passaro();

        /*
        passaro.correr();
        passaro.dormir();
        passaro.voar();

         */



        /*
        Animal animal = new Animal();
        animal.correr();

         */


        /*
        Funcionario funcionario = new Funcionario();
        funcionario.nome = "Jose";
        funcionario.salario = 920;

        //funcionario.recuperarSalario();
        double salarioRecuperado = funcionario.recuperarSalario(120,20);
        System.out.println("O Salário do José é: " + salarioRecuperado);

         */

       /* Casa minhaCasa = new Casa();
        minhaCasa.cor = "Cor";

        System.out.println(minhaCasa.cor);
        minhaCasa.abrirPorta();

        */


    }
}