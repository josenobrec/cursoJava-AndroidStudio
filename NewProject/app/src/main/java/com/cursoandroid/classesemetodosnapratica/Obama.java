package com.cursoandroid.classesemetodosnapratica;

public class Obama extends Cidadao implements Presidente {

    @Override
    public void ganharEleicao() {
        System.out.println("Ganhar uma eleição nos Estados Unidos");
    }
}
