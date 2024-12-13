package medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes;

import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosCadastroAVistaEOpcoes;
import medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.dto.DadosDetalheAVistaEOpcoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AVistaEOpcoesService {
    @Autowired
    private AVistaEOpcoesRepository repository;

    public DadosDetalheAVistaEOpcoes cadastrar(DadosCadastroAVistaEOpcoes dados){
        var aVistaEOpcoes = new AVistaEOpcoes(dados);
        repository.save(aVistaEOpcoes);
        return new DadosDetalheAVistaEOpcoes(aVistaEOpcoes);
    }




}
