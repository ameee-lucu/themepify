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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "uploader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uploader.findAll", query = "SELECT u FROM Uploader u"),
    @NamedQuery(name = "Uploader.findById", query = "SELECT u FROM Uploader u WHERE u.id = :id"),
    @NamedQuery(name = "Uploader.findByEmail", query = "SELECT u FROM Uploader u WHERE u.email = :email"),
    @NamedQuery(name = "Uploader.findByPhoneNo", query = "SELECT u FROM Uploader u WHERE u.phoneNo = :phoneNo"),
    @NamedQuery(name = "Uploader.findByName", query = "SELECT u FROM Uploader u WHERE u.name = :name"),
    @NamedQuery(name = "Uploader.findBySocialMedia", query = "SELECT u FROM Uploader u WHERE u.socialMedia = :socialMedia"),
    @NamedQuery(name = "Uploader.findByToken", query = "SELECT u FROM Uploader u WHERE u.token = :token"),
    @NamedQuery(name = "Uploader.findByStatus", query = "SELECT u FROM Uploader u WHERE u.status = :status"),
    @NamedQuery(name = "Uploader.findByPassword", query = "SELECT u FROM Uploader u WHERE u.password = :password"),
    @NamedQuery(name = "Uploader.findByVirtualId", query = "SELECT u FROM Uploader u WHERE u.virtualId = :virtualId")})
public class Uploader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "name")
    private String name;
    @Column(name = "social_media")
    private String socialMedia;
    @Column(name = "token")
    private String token;
    @Column(name = "status")
    private String status;
    @Column(name = "password")
    private String password;
    @Column(name = "virtual_id")
    private String virtualId;
    @ManyToMany(mappedBy = "uploaderList")
    private List<Product> productList;
    @JoinTable(name = "follow", joinColumns = {
        @JoinColumn(name = "uploader_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "follower_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Uploader> uploaderList;
    @ManyToMany(mappedBy = "uploaderList")
    private List<Uploader> uploaderList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uploaderId")
    private List<Product> productList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uploaderId")
    private List<ProductLog> productLogList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uploaderId")
    private List<Transactions> transactionsList;

    public Uploader() {
    }

    public Uploader(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVirtualId() {
        return virtualId;
    }

    public void setVirtualId(String virtualId) {
        this.virtualId = virtualId;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlTransient
    public List<Uploader> getUploaderList() {
        return uploaderList;
    }

    public void setUploaderList(List<Uploader> uploaderList) {
        this.uploaderList = uploaderList;
    }

    @XmlTransient
    public List<Uploader> getUploaderList1() {
        return uploaderList1;
    }

    public void setUploaderList1(List<Uploader> uploaderList1) {
        this.uploaderList1 = uploaderList1;
    }

    @XmlTransient
    public List<Product> getProductList1() {
        return productList1;
    }

    public void setProductList1(List<Product> productList1) {
        this.productList1 = productList1;
    }

    @XmlTransient
    public List<ProductLog> getProductLogList() {
        return productLogList;
    }

    public void setProductLogList(List<ProductLog> productLogList) {
        this.productLogList = productLogList;
    }

    @XmlTransient
    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
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
        if (!(object instanceof Uploader)) {
            return false;
        }
        Uploader other = (Uploader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.themepify.entity.Uploader[ id=" + id + " ]";
    }
    
}
