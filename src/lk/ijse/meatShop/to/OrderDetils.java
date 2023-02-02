package lk.ijse.meatShop.to;

import lk.ijse.meatShop.view.TM.OrderTM;

public class OrderDetils {

    private String orderId;
    private String itemcode;
    private int qty;
    private double unitPrice;

    public OrderDetils(String orderId, String itemcode, int qty, double unitPrice) {
        this.orderId = orderId;
        this.itemcode = itemcode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }


    @Override
    public String toString() {
        return "CartDetail{" +
                "orderId='" + orderId + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
