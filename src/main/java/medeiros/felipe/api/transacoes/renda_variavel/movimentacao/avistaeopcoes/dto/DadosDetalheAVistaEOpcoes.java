package medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto;


import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.AVistaEOpcoes;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro.comum.ModalidadeDoMovimento;

public record DadosDetalheAVistaEOpcoes(
        Long id,
        ModalidadeDoMovimento modalidadeDoMovimento,
        String dataDoMOvimento,
        String ativo,
        String carteira,
        String quantidade,
        String preco
) {
    public DadosDetalheAVistaEOpcoes(AVistaEOpcoes aVistaEOpcoes) {
        this(aVistaEOpcoes.getId(),aVistaEOpcoes.getModalidadeDoMovimento(),aVistaEOpcoes.getDataDoMovimento(),aVistaEOpcoes.getAtivo(),aVistaEOpcoes.getCarteira(),aVistaEOpcoes.getQuantidade(),aVistaEOpcoes.getPreco());

    }
}