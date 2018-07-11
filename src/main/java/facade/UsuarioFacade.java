/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Felipe Canabrava
 */
public class UsuarioFacade {
            private EntityManagerFactory factory = Persistence
                    .createEntityManagerFactory("SystemServicePU");
        private EntityManager em = factory.createEntityManager();
   
        public Usuario getUsuario(String nomeUsuario, String senha) {
   
              try {
                    Usuario usuario = (Usuario) em
                               .createQuery(
                                           "SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
                               .setParameter("name", nomeUsuario)
                               .setParameter("senha", senha).getSingleResult();
   
                    return usuario;
              } catch (NoResultException e) {
                    return null;
              }
        }
   
      public boolean inserirUsuario(Usuario usuario) {
              try {
                    em.persist(usuario);
                    return true;
              } catch (Exception e) {
                    e.printStackTrace();
                    return false;
              }
        }
        
        public boolean deletarUsuario(Usuario usuario) {
              try {
                    em.remove(usuario);
                    return true;
              } catch (Exception e) {
                    e.printStackTrace();
                    return false;
              }
        }
}
