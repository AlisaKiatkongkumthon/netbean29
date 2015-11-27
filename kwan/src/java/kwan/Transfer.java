/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwan;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t"),
    @NamedQuery(name = "Transfer.findByTranNo", query = "SELECT t FROM Transfer t WHERE t.tranNo = :tranNo"),
    @NamedQuery(name = "Transfer.findByCustName", query = "SELECT t FROM Transfer t WHERE t.custName = :custName"),
    @NamedQuery(name = "Transfer.findByCustAddress", query = "SELECT t FROM Transfer t WHERE t.custAddress = :custAddress")})
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "TRAN_NO")
    private String tranNo;
    @Size(max = 7)
    @Column(name = "CUST_NAME")
    private String custName;
    @Size(max = 100)
    @Column(name = "CUST_ADDRESS")
    private String custAddress;
    @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
    @ManyToOne(optional = false)
    private Product prodId;

    public Transfer() {
    }

    public Transfer(String tranNo) {
        this.tranNo = tranNo;
    }

    public String getTranNo() {
        return tranNo;
    }

    public void setTranNo(String tranNo) {
        this.tranNo = tranNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public Product getProdId() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tranNo != null ? tranNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.tranNo == null && other.tranNo != null) || (this.tranNo != null && !this.tranNo.equals(other.tranNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kwan.Transfer[ tranNo=" + tranNo + " ]";
    }
    
}
