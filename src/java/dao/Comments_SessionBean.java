/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Comments;

/**
 *
 * @author manhtran
 */
@Stateless
public class Comments_SessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public void insert(Comments m){
        em.persist(m);
    }
    
    public void update(Comments m){
        em.merge(m);
    }
    
    public void remove(Comments m){
        em.remove(em.merge(m));
    }
    public List<Comments> getComments(){
        return em.createNamedQuery("Comments.findAll").getResultList();
    }
}
