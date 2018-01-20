/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Users;


/**
 *
 * @author manhtran
 */
@Stateless
public class Users_SessionBean {

    @PersistenceContext
    private EntityManager em;
    
    public void insert(Users u){
        em.persist(u);
    }
    
    public void update(Users u){
        em.merge(u);
    }
    
    public void remove(Users u){
        em.remove(em.merge(u));
    }
    
    public Users getUserByName_Password(String name, String password){
        String sql = "SELECT u FROM Users u WHERE u.userName = '"+name+"' AND u.userPassword = '"+password+"'";
        Query queryUser = em.createQuery(sql);
        Users u = (Users) queryUser.getSingleResult();
        return u;
    }
    
    public Users getUserById(long user_id){
        return (Users) em.createNamedQuery("Users.findByUserId").setParameter("userId", user_id).getSingleResult();
    }
    public List<Users> getUserByName(String user_name){
        return em.createNamedQuery("Users.findByUserName").setParameter("userName", user_name).getResultList();
    }
    
    public List<Users> getAllUsers(){
        return em.createNamedQuery("Users.findAll").getResultList();
    }
   
}
