package medeiros.felipe.api.transacoes.renda_variavel.movimentacao.avistaeopcoes.filtro;

import medeiros.felipe.api.transacoes.cadastro.Observador;

import java.util.ArrayList;
import java.util.List;

    public class SubsegmentoPREVIC_Obs {
        private List<Observador<SubsegmentoPREVIC_Obs>> observadores = new ArrayList<>();
        private List<SubsegmentoPREVIC_Obs> opcoes = new ArrayList<>();

        public void adicionarObservador(Observador<SubsegmentoPREVIC_Obs> observador) {
            observadores.add(observador);
        }

        public void removerObservador(Observador<SubsegmentoPREVIC_Obs> observador) {
            observadores.remove(observador);
        }

        private void notificarObservadores() {
            for (Observador<SubsegmentoPREVIC_Obs> observador : observadores) {
                observador.atualizacao(this);
            }
        }

        public void adicionarNovoSubsegmento(SubsegmentoPREVIC_Obs novoSubsegmento) {
            opcoes.add(novoSubsegmento);
            notificarObservadores();
        }

        public List<SubsegmentoPREVIC_Obs> getOpcoes() {
            return opcoes;
        }
    }