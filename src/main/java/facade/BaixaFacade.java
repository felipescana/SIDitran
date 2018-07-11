package facade;

import entidade.Baixa;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import util.Transacional;

@Transacional
public class BaixaFacade extends AbstractFacade<Baixa>{

    @Inject
    private EntityManager em;

    public BaixaFacade() {
        super(Baixa.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void salvar(Baixa os) {        
        super.salvar(os); 
    }
    
}
