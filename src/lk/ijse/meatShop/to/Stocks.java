package lk.ijse.meatShop.to;

public class Stocks {

    private String itemcode;
    private String category;
    private String description;
    private int QtyonHand;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtyonHand() {
        return QtyonHand;
    }

    public void setQtyonHand(int unitPrice) {
        this.QtyonHand = unitPrice;
    }

    public Stocks() {
    }

    public Stocks(String itemcode, String category, String description, int unitPrice) {
        this.itemcode = itemcode;
        this.category = category;
        this.description = description;
        this.QtyonHand = unitPrice;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "itemcode='" + itemcode + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + QtyonHand +
                '}';
    }
}
