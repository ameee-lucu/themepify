/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "partner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p"),
    @NamedQuery(name = "Partner.findById", query = "SELECT p FROM Partner p WHERE p.id = :id"),
    @NamedQuery(name = "Partner.findByName", query = "SELECT p FROM Partner p WHERE p.name = :name"),
    @NamedQuery(name = "Partner.findByEmail", query = "SELECT p FROM Partner p WHERE p.email = :email"),
    @NamedQuery(name = "Partner.findByToken", query = "SELECT p FROM Partner p WHERE p.token = :token"),
    @NamedQuery(name = "Partner.findByVerify", query = "SELECT p FROM Partner p WHERE p.verify = :verify"),
    @NamedQuery(name = "Partner.findByNotify", query = "SELECT p FROM Partner p WHERE p.notify = :notify")})
public class Partner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "token")
    private String token;
    @Column(name = "verify")
    private String verify;
    @Column(name = "notify")
    private String notify;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partnerId")
    private List<PartnerFormula> partnerFormulaList;

    public Partner() {
    }

    public Partner(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    @XmlTransient
    public List<PartnerFormula> getPartnerFormulaList() {
        return partnerFormulaList;
    }

    public void setPartnerFormulaList(List<PartnerFormula> partnerFormulaList) {
        this.partnerFormulaList = partnerFormulaList;
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
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.themepify.entity.Partner[ id=" + id + " ]";
    }
    
}
