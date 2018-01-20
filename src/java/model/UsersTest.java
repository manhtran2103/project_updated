/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manhtran
 */
@Entity
@Table(name = "users_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersTest.findAll", query = "SELECT u FROM UsersTest u")
    , @NamedQuery(name = "UsersTest.findByUserId", query = "SELECT u FROM UsersTest u WHERE u.userId = :userId")
    , @NamedQuery(name = "UsersTest.findByUserName", query = "SELECT u FROM UsersTest u WHERE u.userName = :userName")
    , @NamedQuery(name = "UsersTest.findByUserEmail", query = "SELECT u FROM UsersTest u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "UsersTest.findByUserPassword", query = "SELECT u FROM UsersTest u WHERE u.userPassword = :userPassword")})
public class UsersTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Long userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_password")
    private String userPassword;

    public UsersTest() {
    }

    public UsersTest(Long userId) {
        this.userId = userId;
    }

    public UsersTest(Long userId, String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersTest)) {
            return false;
        }
        UsersTest other = (UsersTest) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UsersTest[ userId=" + userId + " ]";
    }
    
}
