package lk.ijse.meatShop.view.TM;

public class ShowkaseTm {
    private String itemcode;
    private String category;
    private String description;
    private double uniteprice;
    private int QtyonHand;

    public ShowkaseTm(String itemcode, String category, String description, double uniteprice, int qtyonHand) {
        this.itemcode = itemcode;
        this.category = category;
        this.description = description;
        this.uniteprice = uniteprice;
        QtyonHand = qtyonHand;
    }

    @Override
    public String toString() {
        return "ShowkaseTm{" +
                "itemcode='" + itemcode + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", uniteprice=" + uniteprice +
                ", QtyonHand=" + QtyonHand +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUniteprice() {
        return uniteprice;
    }

    public void setUniteprice(double uniteprice) {
        this.uniteprice = uniteprice;
    }

    public int getQtyonHand() {
        return QtyonHand;
    }

    public void setQtyonHand(int qtyonHand) {
        QtyonHand = qtyonHand;
    }
}
