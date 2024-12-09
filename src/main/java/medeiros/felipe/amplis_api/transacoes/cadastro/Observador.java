package medeiros.felipe.amplis_api.transacoes.cadastro;

public interface Observador<T> {
    void atualizacao(T entidade);
}