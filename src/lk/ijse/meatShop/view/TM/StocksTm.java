package lk.ijse.meatShop.view.TM;

public class StocksTm {
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

    public void setQtyonHand(int qtyonHand) {
        QtyonHand = qtyonHand;
    }

    public StocksTm() {
    }

    public StocksTm(String itemcode, String category, String description, int qtyonHand) {
        this.itemcode = itemcode;
        this.category = category;
        this.description = description;
        QtyonHand = qtyonHand;
    }
}
