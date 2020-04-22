package com.manoelcampos.exportador;

public interface Coluna {
    String getTitulo();
    void setTitulo(String titulo);
    String abrir();
    String fechar();
    String exportarCabecalho();
    String exportarDados(Produto produto);
}
