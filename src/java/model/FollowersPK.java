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
public class FollowersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private long userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "follower_id")
    private long followerId;

    public FollowersPK() {
    }

    public FollowersPK(long userId, long followerId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(long followerId) {
        this.followerId = followerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) followerId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowersPK)) {
            return false;
        }
        FollowersPK other = (FollowersPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.followerId != other.followerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FollowersPK[ userId=" + userId + ", followerId=" + followerId + " ]";
    }
    
}
