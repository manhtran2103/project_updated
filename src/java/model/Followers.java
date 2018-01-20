/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manhtran
 */
@Entity
@Table(name = "followers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followers.findAll", query = "SELECT f FROM Followers f")
    , @NamedQuery(name = "Followers.findByUserId", query = "SELECT f FROM Followers f WHERE f.followersPK.userId = :userId")
    , @NamedQuery(name = "Followers.findByFollowerId", query = "SELECT f FROM Followers f WHERE f.followersPK.followerId = :followerId")})
public class Followers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FollowersPK followersPK;

    public Followers() {
    }

    public Followers(FollowersPK followersPK) {
        this.followersPK = followersPK;
    }

    public Followers(long userId, long followerId) {
        this.followersPK = new FollowersPK(userId, followerId);
    }

    public FollowersPK getFollowersPK() {
        return followersPK;
    }

    public void setFollowersPK(FollowersPK followersPK) {
        this.followersPK = followersPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followersPK != null ? followersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followers)) {
            return false;
        }
        Followers other = (Followers) object;
        if ((this.followersPK == null && other.followersPK != null) || (this.followersPK != null && !this.followersPK.equals(other.followersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Followers[ followersPK=" + followersPK + " ]";
    }
    
}
