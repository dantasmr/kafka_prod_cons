package com.simpleexample.kafka;

public class TitleModel {

    private String titulo;
    private String descricao;

    public TitleModel() {}

    public TitleModel(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("titulo: %s descricao: %s", this.titulo, this.descricao);
    }
}
