package medeiros.felipe.api.transacoes.cadastro;

public interface Observador<T> {
    void atualizacao(T entidade);
}