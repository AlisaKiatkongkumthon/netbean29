/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwan;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByOrderId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPK.orderId = :orderId"),
    @NamedQuery(name = "OrderDetail.findByProdId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPK.prodId = :prodId"),
    @NamedQuery(name = "OrderDetail.findByOrderName", query = "SELECT o FROM OrderDetail o WHERE o.orderName = :orderName"),
    @NamedQuery(name = "OrderDetail.findByAmount", query = "SELECT o FROM OrderDetail o WHERE o.amount = :amount")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderDetailPK orderDetailPK;
    @Size(max = 40)
    @Column(name = "ORDER_NAME")
    private String orderName;
    @Size(max = 6)
    @Column(name = "AMOUNT")
    private String amount;
    @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public OrderDetail(String orderId, String prodId) {
        this.orderDetailPK = new OrderDetailPK(orderId, prodId);
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailPK != null ? orderDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderDetailPK == null && other.orderDetailPK != null) || (this.orderDetailPK != null && !this.orderDetailPK.equals(other.orderDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kwan.OrderDetail[ orderDetailPK=" + orderDetailPK + " ]";
    }
    
}
