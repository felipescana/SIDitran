/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import converter.ConverterGenerico;
import entidade.Agente;
import entidade.Estado;
import entidade.Multa;
import facade.AgenteFacade;
import facade.MultaFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Felipe Canabrava
 */
@Named
@SessionScoped
public class AgenteControle implements Serializable {
    
    @Inject
    private AgenteFacade agenteFacade;
    private Agente agente;
    

    public AgenteControle() {
    }

    
    public void novo(){
       agente  = new Agente();
    }
    
    public void excluir(Agente e){
        agenteFacade.excluir(e);
    }
    
    public void editar(Agente e){
        this.agente = e;
    }
    
    public void salvar() {
        agenteFacade.salvar(agente);
    }
    
    public List<Agente> listaTodos() {
        return agenteFacade.listaTodos();
    }

    public Agente getAgente() {
        return agente   ;
    }

    public void setAgente(Agente  agente) {
        this.agente = agente;
    }


}
