/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author manhtran
 */
@Embeddable
public class LikeUsersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private long userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "media_id")
    private long mediaId;

    public LikeUsersPK() {
    }

    public LikeUsersPK(long userId, long mediaId) {
        this.userId = userId;
        this.mediaId = mediaId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) mediaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikeUsersPK)) {
            return false;
        }
        LikeUsersPK other = (LikeUsersPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.mediaId != other.mediaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LikeUsersPK[ userId=" + userId + ", mediaId=" + mediaId + " ]";
    }
    
}
