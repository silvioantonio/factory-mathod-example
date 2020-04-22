package com.manoelcampos.exportador;

import java.util.function.Function;

/**
 * Exporta dados de uma lista de {@link Produto} para Markdown (arquivos md).
 *
 * <p>Observe que, como estamos usando o padrão Simple Factory para instanciar
 * objetos {@link ExportadorListaProduto}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Simple Factory faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class ExportadorListaProdutoMarkdown extends AbstractExportadorListaProduto {


    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        StringBuilder builder = new StringBuilder();
        for (Coluna coluna : getColunas()) {
            builder.append(coluna.abrir() + "---------");
        }
        builder.append("\n");
        return builder.toString();
    }

    @Override
    public Coluna newColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        return new ColunaMarkdown(obtemValorColuna, titulo);
    }

}
