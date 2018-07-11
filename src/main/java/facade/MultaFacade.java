package facade;

import entidade.Multa;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import util.Transacional;

@Transacional
public class MultaFacade extends AbstractFacade<Multa>{

    @Inject
    private EntityManager em;

    public MultaFacade() {
        super(Multa.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}