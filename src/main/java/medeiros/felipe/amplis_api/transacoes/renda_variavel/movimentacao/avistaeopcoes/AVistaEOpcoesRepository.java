package medeiros.felipe.amplis_api.transacoes.renda_variavel.movimentacao.avistaeopcoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AVistaEOpcoesRepository extends JpaRepository<AVistaEOpcoes, Long> {
    List<AVistaEOpcoes> findByCarteira(String carteira);
}
