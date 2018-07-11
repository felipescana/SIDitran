/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe Canabrava
 */
@Entity
@Table(name = "multa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multa_1.findAll", query = "SELECT m FROM Multa_1 m")
    , @NamedQuery(name = "Multa_1.findById", query = "SELECT m FROM Multa_1 m WHERE m.id = :id")
    , @NamedQuery(name = "Multa_1.findByDatahora", query = "SELECT m FROM Multa_1 m WHERE m.datahora = :datahora")
    , @NamedQuery(name = "Multa_1.findByDatanotificacao", query = "SELECT m FROM Multa_1 m WHERE m.datanotificacao = :datanotificacao")
    , @NamedQuery(name = "Multa_1.findByHorachegada", query = "SELECT m FROM Multa_1 m WHERE m.horachegada = :horachegada")
    , @NamedQuery(name = "Multa_1.findByHoranotificacao", query = "SELECT m FROM Multa_1 m WHERE m.horanotificacao = :horanotificacao")
    , @NamedQuery(name = "Multa_1.findByInfracao", query = "SELECT m FROM Multa_1 m WHERE m.infracao = :infracao")
    , @NamedQuery(name = "Multa_1.findByLocalnotificacao", query = "SELECT m FROM Multa_1 m WHERE m.localnotificacao = :localnotificacao")
    , @NamedQuery(name = "Multa_1.findByMarcamodelo", query = "SELECT m FROM Multa_1 m WHERE m.marcamodelo = :marcamodelo")
    , @NamedQuery(name = "Multa_1.findByModeloveiculo", query = "SELECT m FROM Multa_1 m WHERE m.modeloveiculo = :modeloveiculo")
    , @NamedQuery(name = "Multa_1.findByNomeagente", query = "SELECT m FROM Multa_1 m WHERE m.nomeagente = :nomeagente")
    , @NamedQuery(name = "Multa_1.findByNumero", query = "SELECT m FROM Multa_1 m WHERE m.numero = :numero")
    , @NamedQuery(name = "Multa_1.findByObservacao", query = "SELECT m FROM Multa_1 m WHERE m.observacao = :observacao")
    , @NamedQuery(name = "Multa_1.findByPlaca", query = "SELECT m FROM Multa_1 m WHERE m.placa = :placa")
    , @NamedQuery(name = "Multa_1.findByRegularizacao", query = "SELECT m FROM Multa_1 m WHERE m.regularizacao = :regularizacao")
    , @NamedQuery(name = "Multa_1.findByUf", query = "SELECT m FROM Multa_1 m WHERE m.uf = :uf")
    , @NamedQuery(name = "Multa_1.findByPago", query = "SELECT m FROM Multa_1 m WHERE m.pago = :pago")})
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "datahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora;
    @Column(name = "datanotificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanotificacao;
    @Column(name = "horachegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horachegada;
    @Column(name = "horanotificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horanotificacao;
    @Column(name = "infracao")
    private Integer infracao;
    @Column(name = "localnotificacao")
    private String localnotificacao;
    @Column(name = "marcamodelo")
    private String marcamodelo;
    @Column(name = "modeloveiculo")
    private String modeloveiculo;
    @Column(name = "nomeagente")
    private String nomeagente;
    @Column(name = "numero")
    private BigInteger numero;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "placa")
    private String placa;
    @Column(name = "regularizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regularizacao;
    @Column(name = "uf")
    private String uf;
    @Column(name = "pago")
    private Boolean pago;

    public Multa() {
    }

    public Multa(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public Date getDatanotificacao() {
        return datanotificacao;
    }

    public void setDatanotificacao(Date datanotificacao) {
        this.datanotificacao = datanotificacao;
    }

    public Date getHorachegada() {
        return horachegada;
    }

    public void setHorachegada(Date horachegada) {
        this.horachegada = horachegada;
    }

    public Date getHoranotificacao() {
        return horanotificacao;
    }

    public void setHoranotificacao(Date horanotificacao) {
        this.horanotificacao = horanotificacao;
    }

    public Integer getInfracao() {
        return infracao;
    }

    public void setInfracao(Integer infracao) {
        this.infracao = infracao;
    }

    public String getLocalnotificacao() {
        return localnotificacao;
    }

    public void setLocalnotificacao(String localnotificacao) {
        this.localnotificacao = localnotificacao;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public String getModeloveiculo() {
        return modeloveiculo;
    }

    public void setModeloveiculo(String modeloveiculo) {
        this.modeloveiculo = modeloveiculo;
    }

    public String getNomeagente() {
        return nomeagente;
    }

    public void setNomeagente(String nomeagente) {
        this.nomeagente = nomeagente;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getRegularizacao() {
        return regularizacao;
    }

    public void setRegularizacao(Date regularizacao) {
        this.regularizacao = regularizacao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
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
        if (!(object instanceof Multa)) {
            return false;
        }
        Multa other = (Multa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Multa_1[ id=" + id + " ]";
    }
    
}
