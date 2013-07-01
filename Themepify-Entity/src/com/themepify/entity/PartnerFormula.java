/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hover
 */
@Entity
@Table(name = "partner_formula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerFormula.findAll", query = "SELECT p FROM PartnerFormula p"),
    @NamedQuery(name = "PartnerFormula.findById", query = "SELECT p FROM PartnerFormula p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerFormula.findByFixValue", query = "SELECT p FROM PartnerFormula p WHERE p.fixValue = :fixValue"),
    @NamedQuery(name = "PartnerFormula.findByPercentage", query = "SELECT p FROM PartnerFormula p WHERE p.percentage = :percentage"),
    @NamedQuery(name = "PartnerFormula.findByStatus", query = "SELECT p FROM PartnerFormula p WHERE p.status = :status")})
public class PartnerFormula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fix_value")
    private BigDecimal fixValue;
    @Column(name = "percentage")
    private BigDecimal percentage;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partnerFormulaId")
    private List<Transactions> transactionsList;
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Partner partnerId;

    public PartnerFormula() {
    }

    public PartnerFormula(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFixValue() {
        return fixValue;
    }

    public void setFixValue(BigDecimal fixValue) {
        this.fixValue = fixValue;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public Partner getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Partner partnerId) {
        this.partnerId = partnerId;
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
        if (!(object instanceof PartnerFormula)) {
            return false;
        }
        PartnerFormula other = (PartnerFormula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.themepify.entity.PartnerFormula[ id=" + id + " ]";
    }
    
}
