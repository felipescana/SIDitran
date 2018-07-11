/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sistemas
 */
@Entity
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataServico;
    @ManyToOne
    private Pessoa pessoa;
    private Double ValorTotal;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ordemServico")
    private List<ItensServico> itensServicos;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ordemServico")
    private List<ItensProduto> itensProdutos;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ordemServico")
    private List<ContasReceber> contasRecebers;

    public OrdemServico() {
        this.dataServico = new Date();
        this.itensServicos = new ArrayList<ItensServico>();
        this.itensProdutos = new ArrayList<ItensProduto>();
        this.contasRecebers = new ArrayList<ContasReceber>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ContasReceber> getContasRecebers() {
        return contasRecebers;
    }

    public void setContasRecebers(List<ContasReceber> contasRecebers) {
        this.contasRecebers = contasRecebers;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getValorTotal() {
        ValorTotal = 0d;
        for (ItensServico is : itensServicos) {
            ValorTotal += is.getSubtotal();
        }
        for (ItensProduto ip : itensProdutos) {
            ValorTotal += ip.getSubtotal();
        }
        return ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public List<ItensServico> getItensServicos() {
        return itensServicos;
    }

    public void setItensServicos(List<ItensServico> itensServicos) {
        this.itensServicos = itensServicos;
    }

    public List<ItensProduto> getItensProdutos() {
        return itensProdutos;
    }

    public void setItensProdutos(List<ItensProduto> itensProdutos) {
        this.itensProdutos = itensProdutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.OrdemServico[ id=" + id + " ]";
    }

}
