package cn.itcast.mybatis.pojo;

import java.io.Serializable;

public class OrderDetail implements Serializable{
    
    private Integer id;
    
    private Double totalPrice;
    
    private Integer status;

    private Item item;
    
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", item=" + item +
                '}';
    }
}
