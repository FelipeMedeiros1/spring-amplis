package medeiros.felipe.amplis_api.transacoes.cadastro.subsegmentoPREVIC;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SubsegmentoListener implements ApplicationListener<SubsegmentoPREVICEvent> {
    @Override
    public void onApplicationEvent(SubsegmentoPREVICEvent event) {
        event.getNovoSubsegmento();
    }


}