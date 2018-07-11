/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import converter.ConverterGenerico;
import converter.MoneyConverter;
import entidade.ContasReceber;
import entidade.ItensProduto;
import entidade.ItensServico;
import entidade.OrdemServico;
import entidade.Pessoa;
import entidade.Produto;
import entidade.Servico;
import facade.OrdemServicoFacade;
import facade.PessoaFacade;
import facade.ProdutoFacade;
import facade.ServicoFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/**
 *
 * @author Felipe Canabrava
 */
@Named
@ViewAccessScoped
public class OrdemServicoControle implements Serializable {

    @Inject
    private OrdemServicoFacade ordemServicoFacade;
    private OrdemServico ordemServico;
    private ItensProduto itensProduto;
    private ItensServico itensServico;
    @Inject
    private PessoaFacade pessoaFacade;
    @Inject
    private ServicoFacade servicoFacade;
    @Inject
    private ProdutoFacade produtoFacade;
    private ConverterGenerico converterPessoa;
    private ConverterGenerico converterServico;
    private MoneyConverter moneyConverter;
    private ConverterGenerico converterProduto;
    private Integer numParcela;
    private Date dtVencimento;

    public Integer getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(Integer numParcela) {
        this.numParcela = numParcela;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public ConverterGenerico getConverterProduto() {
        if (converterProduto == null) {
            converterProduto = new ConverterGenerico(produtoFacade);
        }
        return converterProduto;
    }

    public void setConverterProduto(ConverterGenerico converterProduto) {
        this.converterProduto = converterProduto;
    }

    public void addItemProduto() {
        Double estoque = itensProduto.getProduto().getEstoque();
        ItensProduto itemTemp = null;
        for (ItensProduto it : ordemServico.getItensProdutos()) {
            if (it.getProduto().equals(itensProduto.getProduto())) {
                estoque = estoque - it.getQuantidade();
                itemTemp = it;
            }
        }
        if (estoque < itensProduto.getQuantidade()) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Estoque insuficiente!",
                            "Restam apenas "
                            + estoque
                            + " unidades."));
        } else {
            if (itemTemp != null) {
                itemTemp.setQuantidade(itemTemp.getQuantidade() + itensProduto.getQuantidade());
            } else {
                itensProduto.setOrdemServico(ordemServico);
                ordemServico.getItensProdutos().add(itensProduto);
            }
            itensProduto = new ItensProduto();
        }

    }

    public void removerItemProduto(ItensProduto it) {
        ordemServico.getItensProdutos().remove(it);
    }

    public void removerItemServico(ItensServico it) {
        ordemServico.getItensServicos().remove(it);
    }

    public void addItemServico() {
        itensServico.setOrdemServico(ordemServico);
        ordemServico.getItensServicos().add(itensServico);
        itensServico = new ItensServico();
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

    public void setaValorServico() {
        itensServico.setValor(itensServico.getServico().getValor());
    }

    public void setaValorProduto() {
        itensProduto.setValor(itensProduto.getProduto().getValor());
    }

    public ItensProduto getItensProduto() {
        return itensProduto;
    }

    public void setItensProduto(ItensProduto itensProduto) {
        this.itensProduto = itensProduto;
    }

    public ItensServico getItensServico() {
        return itensServico;
    }

    public void setItensServico(ItensServico itensServico) {
        this.itensServico = itensServico;
    }

    public List<Servico> listaFiltrandoServico(String parte) {
        return servicoFacade.listaFiltrando(parte, "nome");
    }

    public List<Produto> listaFiltrandoProduto(String parte) {
        return produtoFacade.listaFiltrando(parte, "nome");
    }

    public ConverterGenerico getConverterServico() {
        if (converterServico == null) {
            converterServico = new ConverterGenerico(servicoFacade);
        }
        return converterServico;
    }

    public void setConverterServico(ConverterGenerico converterServico) {
        this.converterServico = converterServico;
    }

    public List<Pessoa> listaFiltrando(String parte) {
        return pessoaFacade.listaFiltrando(parte, "nome");
    }

    public ConverterGenerico getConverterPessoa() {
        if (converterPessoa == null) {
            converterPessoa = new ConverterGenerico(pessoaFacade);
        }
        return converterPessoa;
    }

    public void setConverterPessoa(ConverterGenerico converterPessoa) {
        this.converterPessoa = converterPessoa;
    }

    public void novo() {
        ordemServico = new OrdemServico();
        itensServico = new ItensServico();
        itensProduto = new ItensProduto();
    }

    public void excluir(OrdemServico e) {
        ordemServicoFacade.excluir(e);
    }

    public void editar(OrdemServico e) {
        this.ordemServico = e;
    }

    public void salvar() {
        ordemServicoFacade.salvar(ordemServico);
    }

    public List<OrdemServico> listaTodos() {
        return ordemServicoFacade.listaTodos();
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public void geraParcela() {
        ordemServico.setContasRecebers(new ArrayList<ContasReceber>());
        Date dtparcela = dtVencimento;
        for (int i = 1; i <= numParcela; i++) {
            ContasReceber cr = new ContasReceber();
            cr.setDataLancamento(new Date());
            cr.setNumeroParcela(i);
            cr.setOrdemServico(ordemServico);
            cr.setPessoa(ordemServico.getPessoa());
            cr.setValor(ordemServico.getValorTotal() / numParcela);
            cr.setDataVencimento(dtparcela);

            Calendar cal = Calendar.getInstance();
            cal.setTime(dtparcela);
            cal.add(Calendar.MONTH, 1);
            dtparcela = cal.getTime();
            
            ordemServico.getContasRecebers().add(cr);
        }
    }

}
