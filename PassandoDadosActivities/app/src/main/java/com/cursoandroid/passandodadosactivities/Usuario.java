package com.cursoandroid.passandodadosactivities;

import java.io.Serializable;

public class Usuario implements Serializable { //==> Serializable permite que o objeto Usuario possa ser convertido em bytes, podendo armazenar em disco e transferir
                                               // de uma activity para outra (no caso a MainActivity para SegundaActivity)

    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
