package medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NoArgsConstructor;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosLiquidacaoECustodiaAba;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.CorretoraDeValores;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.Custodiante;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.Moeda;

@Embeddable
@NoArgsConstructor
public class LiquidacaoECustodiaAba {
    @Enumerated(EnumType.STRING)
    private CorretoraDeValores corretoraDeValores;
    @Enumerated(EnumType.STRING)
    private Custodiante custodiante;
    @Enumerated(EnumType.STRING)
    private Moeda moedaLiquidacao;

    public LiquidacaoECustodiaAba(DadosLiquidacaoECustodiaAba dados) {
        this.corretoraDeValores = dados.corretoraDeValores();
        this.custodiante = dados.custodiante();
        this.moedaLiquidacao = dados.moedaLiquidacao();
    }

    public void atualizarInformacoes(DadosLiquidacaoECustodiaAba dados) {
        if (dados.corretoraDeValores() != null)
            this.corretoraDeValores = dados.corretoraDeValores();

        if (dados.custodiante() != null)
            this.custodiante = dados.custodiante();

        if (dados.moedaLiquidacao() != null)
            this.moedaLiquidacao = dados.moedaLiquidacao();

    }
}
