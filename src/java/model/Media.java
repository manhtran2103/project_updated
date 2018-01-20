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
@Table(name = "media")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m")
    , @NamedQuery(name = "Media.findByMediaId", query = "SELECT m FROM Media m WHERE m.mediaId = :mediaId")
    , @NamedQuery(name = "Media.findByUserId", query = "SELECT m FROM Media m WHERE m.userId = :userId")
    , @NamedQuery(name = "Media.findByTypeId", query = "SELECT m FROM Media m WHERE m.typeId = :typeId")
    , @NamedQuery(name = "Media.findByMediaUrl", query = "SELECT m FROM Media m WHERE m.mediaUrl = :mediaUrl")
    , @NamedQuery(name = "Media.findByMediaLike", query = "SELECT m FROM Media m WHERE m.mediaLike = :mediaLike")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "media_id")
    private Long mediaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private long userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_id")
    private int typeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "media_url")
    private String mediaUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "media_like")
    private int mediaLike;

    public Media() {
    }

    public Media(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Media(Long mediaId, long userId, int typeId, String mediaUrl, int mediaLike) {
        this.mediaId = mediaId;
        this.userId = userId;
        this.typeId = typeId;
        this.mediaUrl = mediaUrl;
        this.mediaLike = mediaLike;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public int getMediaLike() {
        return mediaLike;
    }

    public void setMediaLike(int mediaLike) {
        this.mediaLike = mediaLike;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaId != null ? mediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Media[ mediaId=" + mediaId + " ]";
    }
    
}
