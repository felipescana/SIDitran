/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import converter.ConverterGenerico;
import converter.MoneyConverter;
import entidade.ItensMulta;
import entidade.Baixa;
import entidade.Multa;
import facade.BaixaFacade;
import facade.MultaFacade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/**
 *
 * @author carol
 */
@Named
@ViewAccessScoped
public class BaixaControle implements Serializable {

    @Inject
    private BaixaFacade baixaFacade;
    private Baixa baixa;
    private ItensMulta itensMulta;

    @Inject
    private MultaFacade multaFacade;

    private MoneyConverter moneyConverter;
    private ConverterGenerico converterMulta;

    public void addItemMulta() {
        itensMulta.setBaixa(baixa);
        baixa.getItensMultas().add(itensMulta);
        itensMulta = new ItensMulta();
    }

    public void removerItemProduto(ItensMulta it) {
        baixa.getItensMultas().remove(it);
    }

    public MoneyConverter getMoneyConverter() {
        if (moneyConverter == null) {
            moneyConverter = new MoneyConverter();
        }
        return moneyConverter;
    }

    public void setMoneyConverter(MoneyConverter moneyConverter) {
        this.moneyConverter = moneyConverter;
    }

    public void setaValorMulta() {
        //itensMulta.setValor(itensMulta.getMulta().getValor());
    }

    public ItensMulta getItensMulta() {
        return itensMulta;
    }

    public void setItensMulta(ItensMulta itensMulta) {
        this.itensMulta = itensMulta;
    }

    public void setConverterServico(ConverterGenerico converterServico) {
        this.converterMulta = converterServico;
    }

    public List<Multa> listaFiltrandoMulta(String part) {
        return multaFacade.listaFiltrando(part, "placa");
    }

    public ConverterGenerico getConverterMulta() {
        if (converterMulta == null) {
            converterMulta = new ConverterGenerico(multaFacade);
        }
        return converterMulta;
    }

    public void setConverterMulta(ConverterGenerico converterMulta) {
        this.converterMulta = converterMulta;
    }

    public void novo() {
        baixa = new Baixa();
        itensMulta = new ItensMulta();
    }

    public void excluir(Baixa e) {
        baixaFacade.excluir(e);
    }

    public void editar(Baixa e) {
        this.baixa = e;
    }

    public void salvar() {
        baixaFacade.salvar(baixa);
    }

    public List<Baixa> listaTodos() {
        return baixaFacade.listaTodos();
    }

    public Baixa getBaixa() {
        return baixa;
    }

    public void setBaixa(Baixa baixa) {
        this.baixa = baixa;
    }

}
