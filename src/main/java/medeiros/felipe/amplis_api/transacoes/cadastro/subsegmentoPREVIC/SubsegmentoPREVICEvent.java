package medeiros.felipe.amplis_api.transacoes.cadastro.subsegmentoPREVIC;

import org.springframework.context.ApplicationEvent;

public class SubsegmentoPREVICEvent extends ApplicationEvent {
    private String novoSubsegmento;

    public SubsegmentoPREVICEvent(Object source, String novoSubsegmento) {
        super(source);
        this.novoSubsegmento = novoSubsegmento;
    }

    public String getNovoSubsegmento() {
        return novoSubsegmento;
    }
}
