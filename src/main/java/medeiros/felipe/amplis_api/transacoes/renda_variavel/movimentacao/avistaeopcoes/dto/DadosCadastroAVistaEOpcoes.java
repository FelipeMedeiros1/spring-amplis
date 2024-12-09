package medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.*;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.Boleano;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.ModalidadeDoMovimento;
import medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.TruncarArredondar;

public record DadosCadastroAVistaEOpcoes(
        @NotNull
        ModalidadeDoMovimento modalidadeDoMovimento,
        @NotBlank
        String dataDoMOvimento,
        @NotNull
        Mercado mercado,
        @NotBlank
        String ativo,
        @NotBlank
        String carteira,
        String numeroDeNegocioNaBolsa,
        SubsegmentoPREVIC subsegmentoPREVIC,
        @NotBlank
        String quantidade,
        @NotBlank
        String preco,
        @NotNull
        TipoMovimento tipoMovimento,
        Motivo motivo,
        @NotNull
        String sobraDayTrade,
        @NotNull
        String afterMarket,
        String sistemaDeOrigem,
        @NotNull
        Boleano calculaCorretagemEmolumentos,
        String porcentageDevolucaoDeCorretagemDaCorretora,
        String porcentageDevolucaoDeCorretagemDoRefaturador,
        @NotNull
        TruncarArredondar truncarArredondar,
        TipoDeCorretagem tipoDeCorretagem,
        String valorDeCorretagem,
        TipoEmolumento tipoEmolumento,
        String valorEmolumento,
        @NotNull @Valid DadosLiquidacaoECustodiaAba liquidacaoECustodia


) {
}
