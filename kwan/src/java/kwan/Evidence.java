/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwan;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "evidence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evidence.findAll", query = "SELECT e FROM Evidence e"),
    @NamedQuery(name = "Evidence.findByEvidNo", query = "SELECT e FROM Evidence e WHERE e.evidNo = :evidNo"),
    @NamedQuery(name = "Evidence.findByTime", query = "SELECT e FROM Evidence e WHERE e.time = :time"),
    @NamedQuery(name = "Evidence.findByEvDATE", query = "SELECT e FROM Evidence e WHERE e.evDATE = :evDATE"),
    @NamedQuery(name = "Evidence.findByMoney", query = "SELECT e FROM Evidence e WHERE e.money = :money")})
public class Evidence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "EVID_NO")
    private String evidNo;
    @Size(max = 5)
    @Column(name = "TIME")
    private String time;
    @Column(name = "Ev_DATE")
    @Temporal(TemporalType.DATE)
    private Date evDATE;
    @Column(name = "MONEY")
    private Long money;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    @ManyToOne
    private Customer custId;

    public Evidence() {
    }

    public Evidence(String evidNo) {
        this.evidNo = evidNo;
    }

    public String getEvidNo() {
        return evidNo;
    }

    public void setEvidNo(String evidNo) {
        this.evidNo = evidNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getEvDATE() {
        return evDATE;
    }

    public void setEvDATE(Date evDATE) {
        this.evDATE = evDATE;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evidNo != null ? evidNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evidence)) {
            return false;
        }
        Evidence other = (Evidence) object;
        if ((this.evidNo == null && other.evidNo != null) || (this.evidNo != null && !this.evidNo.equals(other.evidNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kwan.Evidence[ evidNo=" + evidNo + " ]";
    }
    
}
