/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Media;

/**
 *
 * @author manhtran
 */
@Stateless
public class Media_SessionBean {

    @PersistenceContext
    private EntityManager em;
    
    public void insert(Media m){
        em.persist(m);
    }
    
    public void update(Media m){
        em.merge(m);
    }
    
    public void remove(Media m){
        em.remove(em.merge(m));
    }
    
}
