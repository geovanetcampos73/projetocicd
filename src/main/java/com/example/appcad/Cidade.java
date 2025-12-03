package com.example.appcad;

public class Cidade {
    private int codigo;
    private String descricao;
    private int coduf;
    private String uf;
    //PLUBLICANDO
    public Cidade(int codigo, String descricao, int coduf, String uf) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.coduf = coduf;
        this.uf = uf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCoduf() {
        return coduf;
    }

    public void setCoduf(int coduf) {
        this.coduf = coduf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
