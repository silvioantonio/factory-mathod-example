package com.manoelcampos.exportador;

import java.util.function.Function;

public abstract class AbstractColuna implements Coluna {

    private Function<Produto, Object> obtemValorColuna;
    private String titulo;

    public AbstractColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        this.obtemValorColuna = obtemValorColuna;
        this.titulo = titulo;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String exportarCabecalho() {
        return abrir() + titulo + fechar();
    }

    @Override
    public String exportarDados(Produto produto) {
        Object retorno = obtemValorColuna.apply(produto);
        return abrir() + retorno.toString() + fechar();
    }
}
