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
public class Baixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataBaixa;
    private Double ValorTotal;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<ItensMulta> itensMulta;

    public Baixa() {
        this.dataBaixa = new Date();
        this.itensMulta = new ArrayList<ItensMulta>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataServico) {
        this.dataBaixa = dataServico;
    }

    public Double getValorTotal() {
        ValorTotal = 0d;
        for (ItensMulta is : itensMulta) {
            ValorTotal += is.getSubtotal();
        }
        return ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public List<ItensMulta> getItensMultas() {
        return itensMulta;
    }

    public void setItensMultas(List<ItensMulta> itensMulta) {
        this.itensMulta = itensMulta;
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
        if (!(object instanceof Baixa)) {
            return false;
        }
        Baixa other = (Baixa) object;
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
