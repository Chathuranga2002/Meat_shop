package lk.ijse.meatShop.to;

public class Item {
    private String itemcode;
    private String category;
    private String description;
    private Double unitPrice;
    private int qtyonHand;

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public Item(String itemcode, String category, String description, Double unitPrice, int qtyonHand) {
        this.itemcode = itemcode;
        this.category = category;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyonHand = qtyonHand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyonHand() {
        return qtyonHand;
    }

    public void setQtyonHand(int qtyonHand) {
        this.qtyonHand = qtyonHand;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemcode='" + itemcode + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyonHand=" + qtyonHand +
                '}';
    }
}
