/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import converter.ConverterGenerico;
import entidade.Estado;
import entidade.Multa;
import util.TipoMulta;
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
public class MultaControle implements Serializable {


    
    
    @Inject
    private MultaFacade multaFacade;
    private Multa multa;
    //private ConverterGenerico estadoConverter;
    private Map<String, TipoMulta> listaInfracoes = new HashMap<String, TipoMulta>();
    

    public MultaControle() {
        init();
    }
    
    public void init (){
                
        listaInfracoes = new HashMap<String, TipoMulta>();
        listaInfracoes.put("Cartão em branco", TipoMulta.CARTAO_EM_BRANCO);
        listaInfracoes.put("Cartão fora do veículo", TipoMulta.CARTAO_FORA_DO_VEICULO);
        listaInfracoes.put("Cartão rasurado",TipoMulta.CARTAO_RASURADO);
        listaInfracoes.put("Falta de cartão", TipoMulta.FALTA_DE_CARTA);
        listaInfracoes.put(" Horario adiantado", TipoMulta.HORARIO_ADIANTADO);
        listaInfracoes.put(" Lápis ou similar", TipoMulta.LAPIS_OU_SIMILAR);
        listaInfracoes.put("Limite tolerancia ultrapassado",TipoMulta.LIMITE_TOLERANCIA_ULTRAPASSADO);
        listaInfracoes.put("Periodo ultrapassado", TipoMulta.PERIODO_ULTRAPASSADO);
        listaInfracoes.put("Renovação de + de 1 cartão de tolerancia por quadra",TipoMulta.RENOVACAO_DE_MAIS_DE_UM_CARTAO_DE_TOLERANCIA_POR_QUADRA);
        listaInfracoes.put("Renovação do cartão + de 2 horas na mesma vaga/quadra",TipoMulta.RENOVACAO_DO_CARTAO_MAIS_DE_DUAS_HORAS_NA_MESMA_VAGA_QUADRA);
        listaInfracoes.put("Preenchimento irregular do cartão",TipoMulta.PREENCHIMENTO_IRREGULAR_DO_CARTAO);
    }
    
    public Map<String, TipoMulta> getListaInfracoes() {
        return listaInfracoes;
    }

    
    public void novo(){
       multa  = new Multa();
    }
    
    public void excluir(Multa e){
        multaFacade.excluir(e);
    }
    
    public void editar(Multa e){
        this.multa = e;
    }
    
    public void salvar() {
        multaFacade.salvar(multa);
    }
    
    public List<Multa> listaTodos() {
        return multaFacade.listaTodos();
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }


}
