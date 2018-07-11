package facade;

import entidade.Agente;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import util.Transacional;

@Transacional
public class AgenteFacade extends AbstractFacade<Agente>{

    @Inject
    private EntityManager em;

    public AgenteFacade() {
        super(Agente.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}