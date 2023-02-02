package lk.ijse.meatShop.view.TM;

import javafx.scene.control.Button;

public class BuyCartTM {
    private String itemcode;
    private String category;
    private String desccrip;
    private Double uniteprice;
    private Double toatal;
    private int qty;
    private Button btnDelete;

    public BuyCartTM(String itemcode, String category, String desccrip, Double uniteprice, Double toatal, int qty, Button btnDelete) {
        this.itemcode = itemcode;
        this.category = category;
        this.desccrip = desccrip;
        this.uniteprice = uniteprice;
        this.toatal = toatal;
        this.qty = qty;
        this.btnDelete = btnDelete;
    }

    public Double getToatal() {
        return toatal;
    }

    public void setToatal(Double toatal) {
        this.toatal = toatal;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public BuyCartTM(String itemcode, String category, String desccrip, Double uniteprice, int qty,Button btnDelete) {
        this.itemcode = itemcode;
        this.category = category;
        this.desccrip = desccrip;
        this.uniteprice = uniteprice;
        this.qty = qty;
        this.btnDelete=btnDelete;
    }

    public BuyCartTM() {
    }

    @Override
    public String toString() {
        return "BuyCartTM{" +
                "itemcode='" + itemcode + '\'' +
                ", category='" + category + '\'' +
                ", desccrip='" + desccrip + '\'' +
                ", uniteprice=" + uniteprice +
                ", qty=" + qty +
                '}';
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesccrip() {
        return desccrip;
    }

    public void setDesccrip(String desccrip) {
        this.desccrip = desccrip;
    }

    public Double getUniteprice() {
        return uniteprice;
    }

    public void setUniteprice(Double uniteprice) {
        this.uniteprice = uniteprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
