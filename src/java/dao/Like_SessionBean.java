/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.LikeUsers;

/**
 *
 * @author manhtran
 */
@Stateless
public class Like_SessionBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(LikeUsers m){
        em.persist(m);
    }
    
    public void update(LikeUsers m){
        em.merge(m);
    }
    
    public void remove(LikeUsers m){
        em.remove(em.merge(m));
    }

}
