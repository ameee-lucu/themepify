/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id"),
    @NamedQuery(name = "Transactions.findByStatus", query = "SELECT t FROM Transactions t WHERE t.status = :status"),
    @NamedQuery(name = "Transactions.findByTranstime", query = "SELECT t FROM Transactions t WHERE t.transtime = :transtime"),
    @NamedQuery(name = "Transactions.findByPrice", query = "SELECT t FROM Transactions t WHERE t.price = :price"),
    @NamedQuery(name = "Transactions.findByTotalPrice", query = "SELECT t FROM Transactions t WHERE t.totalPrice = :totalPrice"),
    @NamedQuery(name = "Transactions.findByPartnerComission", query = "SELECT t FROM Transactions t WHERE t.partnerComission = :partnerComission"),
    @NamedQuery(name = "Transactions.findByAdminComission", query = "SELECT t FROM Transactions t WHERE t.adminComission = :adminComission"),
    @NamedQuery(name = "Transactions.findByVat", query = "SELECT t FROM Transactions t WHERE t.vat = :vat"),
    @NamedQuery(name = "Transactions.findByFee1", query = "SELECT t FROM Transactions t WHERE t.fee1 = :fee1"),
    @NamedQuery(name = "Transactions.findByFee2", query = "SELECT t FROM Transactions t WHERE t.fee2 = :fee2"),
    @NamedQuery(name = "Transactions.findByChannel", query = "SELECT t FROM Transactions t WHERE t.channel = :channel")})
public class Transactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "transtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transtime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "partner_comission")
    private BigDecimal partnerComission;
    @Column(name = "admin_comission")
    private BigDecimal adminComission;
    @Column(name = "vat")
    private BigDecimal vat;
    @Column(name = "fee_1")
    private BigDecimal fee1;
    @Column(name = "fee_2")
    private BigDecimal fee2;
    @Column(name = "channel")
    private String channel;
    @JoinColumn(name = "uploader_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Uploader uploaderId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "partner_formula_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PartnerFormula partnerFormulaId;

    public Transactions() {
    }

    public Transactions(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTranstime() {
        return transtime;
    }

    public void setTranstime(Date transtime) {
        this.transtime = transtime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPartnerComission() {
        return partnerComission;
    }

    public void setPartnerComission(BigDecimal partnerComission) {
        this.partnerComission = partnerComission;
    }

    public BigDecimal getAdminComission() {
        return adminComission;
    }

    public void setAdminComission(BigDecimal adminComission) {
        this.adminComission = adminComission;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getFee1() {
        return fee1;
    }

    public void setFee1(BigDecimal fee1) {
        this.fee1 = fee1;
    }

    public BigDecimal getFee2() {
        return fee2;
    }

    public void setFee2(BigDecimal fee2) {
        this.fee2 = fee2;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public PartnerFormula getPartnerFormulaId() {
        return partnerFormulaId;
    }

    public void setPartnerFormulaId(PartnerFormula partnerFormulaId) {
        this.partnerFormulaId = partnerFormulaId;
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
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.themepify.entity.Transactions[ id=" + id + " ]";
    }
    
}
