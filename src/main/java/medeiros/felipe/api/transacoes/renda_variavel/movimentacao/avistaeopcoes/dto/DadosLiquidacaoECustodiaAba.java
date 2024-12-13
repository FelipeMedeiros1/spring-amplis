package medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto;

import jakarta.validation.constraints.NotNull;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.CorretoraDeValores;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.Custodiante;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.Moeda;

public record DadosLiquidacaoECustodiaAba(
        @NotNull
        CorretoraDeValores corretoraDeValores,
        @NotNull
        Custodiante custodiante,
        Moeda moedaLiquidacao

) {
}
