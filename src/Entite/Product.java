/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product_1.findAll", query = "SELECT p FROM Product_1 p")
    , @NamedQuery(name = "Product_1.findById", query = "SELECT p FROM Product_1 p WHERE p.id = :id")
    , @NamedQuery(name = "Product_1.findByNameProduct", query = "SELECT p FROM Product_1 p WHERE p.nameProduct = :nameProduct")
    , @NamedQuery(name = "Product_1.findByReference", query = "SELECT p FROM Product_1 p WHERE p.reference = :reference")
    , @NamedQuery(name = "Product_1.findByBrand", query = "SELECT p FROM Product_1 p WHERE p.brand = :brand")
    , @NamedQuery(name = "Product_1.findBySupplier", query = "SELECT p FROM Product_1 p WHERE p.supplier = :supplier")
    , @NamedQuery(name = "Product_1.findByTimeUse", query = "SELECT p FROM Product_1 p WHERE p.timeUse = :timeUse")
    , @NamedQuery(name = "Product_1.findByPrice", query = "SELECT p FROM Product_1 p WHERE p.price = :price")
    , @NamedQuery(name = "Product_1.findBySkinType", query = "SELECT p FROM Product_1 p WHERE p.skinType = :skinType")
    , @NamedQuery(name = "Product_1.findByPhotoProduct", query = "SELECT p FROM Product_1 p WHERE p.photoProduct = :photoProduct")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name_product")
    private String nameProduct;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @Column(name = "supplier")
    private String supplier;
    @Basic(optional = false)
    @Column(name = "time_use")
    private String timeUse;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "skin_type")
    private String skinType;
    @Basic(optional = false)
    @Column(name = "photo_product")
    private String photoProduct;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @ManyToOne
    private Admin adminId;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String nameProduct, String reference, String brand, String supplier, String timeUse, double price, String skinType, String photoProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.reference = reference;
        this.brand = brand;
        this.supplier = supplier;
        this.timeUse = timeUse;
        this.price = price;
        this.skinType = skinType;
        this.photoProduct = photoProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getPhotoProduct() {
        return photoProduct;
    }

    public void setPhotoProduct(String photoProduct) {
        this.photoProduct = photoProduct;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite.Product_1[ id=" + id + " ]";
    }
    
}
