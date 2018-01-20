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
@Table(name = "like_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikeUsers.findAll", query = "SELECT l FROM LikeUsers l")
    , @NamedQuery(name = "LikeUsers.findByUserId", query = "SELECT l FROM LikeUsers l WHERE l.likeUsersPK.userId = :userId")
    , @NamedQuery(name = "LikeUsers.findByMediaId", query = "SELECT l FROM LikeUsers l WHERE l.likeUsersPK.mediaId = :mediaId")})
public class LikeUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LikeUsersPK likeUsersPK;

    public LikeUsers() {
    }

    public LikeUsers(LikeUsersPK likeUsersPK) {
        this.likeUsersPK = likeUsersPK;
    }

    public LikeUsers(long userId, long mediaId) {
        this.likeUsersPK = new LikeUsersPK(userId, mediaId);
    }

    public LikeUsersPK getLikeUsersPK() {
        return likeUsersPK;
    }

    public void setLikeUsersPK(LikeUsersPK likeUsersPK) {
        this.likeUsersPK = likeUsersPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (likeUsersPK != null ? likeUsersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikeUsers)) {
            return false;
        }
        LikeUsers other = (LikeUsers) object;
        if ((this.likeUsersPK == null && other.likeUsersPK != null) || (this.likeUsersPK != null && !this.likeUsersPK.equals(other.likeUsersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LikeUsers[ likeUsersPK=" + likeUsersPK + " ]";
    }
    
}
