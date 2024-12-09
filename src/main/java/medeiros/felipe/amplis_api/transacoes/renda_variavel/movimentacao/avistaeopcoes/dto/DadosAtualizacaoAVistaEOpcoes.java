package medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto;


import jakarta.validation.constraints.NotNull;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.*;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.Boleano;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.ModalidadeDoMovimento;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.TruncarArredondar;

public record DadosAtualizacaoAVistaEOpcoes(
        @NotNull
        Long id,
        ModalidadeDoMovimento modalidadeDoMovimento,
        String dataDoMovimento,
        Mercado mercado,
        String ativo,
        String quantidade,
        String preco,
        TipoMovimento tipoMovimento,
        Motivo motivo,
        String sobraDayTrade,
        String afterMarket,
        Boleano calculaCorretagemEmolumentos,
        TruncarArredondar truncarArredondar,
        String valorDeCorretagem,
        TipoEmolumento tipoEmolumento,
        DadosLiquidacaoECustodiaAba liquidacaoECustodia

) {
}
