/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe Canabrava
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
      
        @Column(name="userName", nullable=false, unique=true)
        private String nomeUsuario;
        
        @Column(name="password", nullable=false, unique=false)
        private String senha;
   
        @Column(name="lastAccess", unique=true)
        @Temporal(TemporalType.DATE)
        private Date ultimoAcesso;
        
        public String getNomeUsuario() {
              return nomeUsuario;
        }
        
        public void setNomeUsuario(String nomeUsuario) {
              this.nomeUsuario = nomeUsuario;
        }
        
        public String getSenha() {
              return senha;
        }
        
        public void setSenha(String senha) {
              this.senha = senha;
        }
        
        public Date getUltimoAcesso() {
              return ultimoAcesso;
        }
        
        public void setUltimoAcesso(Date ultimoAcesso) {
              this.ultimoAcesso = ultimoAcesso;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.usuario[ id=" + id + " ]";
    }
    
}
