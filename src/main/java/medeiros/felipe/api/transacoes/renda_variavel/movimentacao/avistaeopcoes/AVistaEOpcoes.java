package medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosAtualizacaoAVistaEOpcoes;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosCadastroAVistaEOpcoes;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.*;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.Boleano;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.ModalidadeDoMovimento;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.TruncarArredondar;

@Table(name = "aVistaEOpcoes")
@Entity(name = "AVistaEOpcoes")
    @Getter
    @NoArgsConstructor
    @EqualsAndHashCode(of = "id")
public class AVistaEOpcoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ModalidadeDoMovimento modalidadeDoMovimento;
    private String dataDoMovimento;
    private Mercado mercado;
    private String ativo;
    private String carteira;
    private String numeroDeNegocioNaBolsa;
    @Enumerated(EnumType.STRING)
    private SubsegmentoPREVIC subsegmentoPREVIC;
    private String quantidade;
    private String preco;
    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;
    @Enumerated(EnumType.STRING)
    private Motivo motivo;
    private String sobraDayTrade;
    private String afterMarket;
    private String sistemaDeOrigem;
    @Enumerated(EnumType.STRING)
    private Boleano calculaCorretagemEmolumentos;
    private String porcentageDevolucaoDeCorretagemDaCorretora;
    private String porcentageDevolucaoDeCorretagemDoRefaturador;
    @Enumerated(EnumType.STRING)
    private TruncarArredondar truncarArredondar;
    @Enumerated(EnumType.STRING)
    private TipoDeCorretagem tipoDeCorretagem;
    private String valorDeCorretagem;
    @Enumerated(EnumType.STRING)
    private TipoEmolumento tipoEmolumento;
    private String valorEmolumento;
    @Embedded
    private LiquidacaoECustodiaAba liquidacaoECustodia;

    public AVistaEOpcoes(DadosCadastroAVistaEOpcoes dados) {
        this.modalidadeDoMovimento = dados.modalidadeDoMovimento();
        this.dataDoMovimento = dados.dataDoMOvimento();
        this.mercado = dados.mercado();
        this.ativo = dados.ativo();
        this.carteira = dados.carteira();
        this.numeroDeNegocioNaBolsa = dados.numeroDeNegocioNaBolsa();
        this.subsegmentoPREVIC = dados.subsegmentoPREVIC();
        this.quantidade = dados.quantidade();
        this.preco = dados.preco();
        this.tipoMovimento = dados.tipoMovimento();
        this.motivo = dados.motivo();
        this.sobraDayTrade = dados.sobraDayTrade();
        this.afterMarket = dados.afterMarket();
        this.sistemaDeOrigem = dados.sistemaDeOrigem();
        this.calculaCorretagemEmolumentos = dados.calculaCorretagemEmolumentos();
        this.porcentageDevolucaoDeCorretagemDaCorretora = dados.porcentageDevolucaoDeCorretagemDaCorretora();
        this.porcentageDevolucaoDeCorretagemDoRefaturador = dados.porcentageDevolucaoDeCorretagemDoRefaturador();
        this.truncarArredondar = dados.truncarArredondar();
        this.tipoDeCorretagem = dados.tipoDeCorretagem();
        this.valorDeCorretagem = dados.valorDeCorretagem();
        this.tipoEmolumento = dados.tipoEmolumento();
        this.valorEmolumento = dados.valorEmolumento();
        this.liquidacaoECustodia = new LiquidacaoECustodiaAba(dados.liquidacaoECustodia());
    }

    public void atualizarInformacoes(DadosAtualizacaoAVistaEOpcoes dados) {
        if (dados.modalidadeDoMovimento() != null)
            this.modalidadeDoMovimento = dados.modalidadeDoMovimento();

        if (dados.dataDoMovimento() != null)
            this.dataDoMovimento = dados.dataDoMovimento();

        if (dados.mercado() != null)
            this.mercado = dados.mercado();

        if (dados.ativo() != null)
            this.ativo = dados.ativo();

        if (dados.quantidade() != null)
            this.quantidade = dados.quantidade();

        if (dados.preco() != null)
            this.preco = dados.preco();

        if (dados.tipoMovimento() != null)
            this.tipoMovimento = dados.tipoMovimento();

        if (dados.motivo() != null)
            this.motivo = dados.motivo();

        if (dados.sobraDayTrade() != null)
            this.sobraDayTrade = dados.sobraDayTrade();

        if (dados.afterMarket() != null)
            this.afterMarket = dados.afterMarket();

        if (dados.calculaCorretagemEmolumentos() != null)
            this.calculaCorretagemEmolumentos = dados.calculaCorretagemEmolumentos();

        if (dados.truncarArredondar() != null)
            this.truncarArredondar = dados.truncarArredondar();

        if (dados.valorDeCorretagem() != null)
            this.valorDeCorretagem = dados.valorDeCorretagem();

        if (dados.tipoEmolumento() != null)
            this.tipoEmolumento = dados.tipoEmolumento();

        if (dados.liquidacaoECustodia() != null)
            this.liquidacaoECustodia.atualizarInformacoes(dados.liquidacaoECustodia());
    }
}
