package facade;

import entidade.ItensProduto;
import entidade.OrdemServico;
import entidade.Produto;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import util.Transacional;

@Transacional
public class OrdemServicoFacade extends AbstractFacade<OrdemServico>{

    @Inject
    private EntityManager em;

    public OrdemServicoFacade() {
        super(OrdemServico.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void salvar(OrdemServico os) {        
        super.salvar(os); 
        baixaEstoque(os);
    }

    private void baixaEstoque(OrdemServico os) {
        for(ItensProduto it : os.getItensProdutos()){
            Produto p = it.getProduto();
            p.setEstoque(p.getEstoque() - it.getQuantidade());
            em.merge(p);
        }
    }
    
    
    
    
}
