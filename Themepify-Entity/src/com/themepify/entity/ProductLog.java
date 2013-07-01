/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hover
 */
@Entity
@Table(name = "product_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductLog.findAll", query = "SELECT p FROM ProductLog p"),
    @NamedQuery(name = "ProductLog.findById", query = "SELECT p FROM ProductLog p WHERE p.id = :id"),
    @NamedQuery(name = "ProductLog.findByLogtime", query = "SELECT p FROM ProductLog p WHERE p.logtime = :logtime")})
public class ProductLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "logtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logtime;
    @JoinColumn(name = "uploader_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Uploader uploaderId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;

    public ProductLog() {
    }

    public ProductLog(Long id) {
        this.id = id;
    }

    public ProductLog(Long id, Date logtime) {
        this.id = id;
        this.logtime = logtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public Uploader getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Uploader uploaderId) {
        this.uploaderId = uploaderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductLog)) {
            return false;
        }
        ProductLog other = (ProductLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.themepify.entity.ProductLog[ id=" + id + " ]";
    }
    
}
