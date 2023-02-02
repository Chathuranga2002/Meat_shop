package lk.ijse.meatShop.to;

public class Order {
   private String ord_id;
   private String date;
   private String cus_id;
   private String emp_id;

    @Override
    public String toString() {
        return "Order{" +
                "ord_id='" + ord_id + '\'' +
                ", date='" + date + '\'' +
                ", cus_id='" + cus_id + '\'' +
                ", emp_id='" + emp_id + '\'' +
                '}';
    }

    public Order() {
    }

    public Order(String ord_id, String date, String cus_id, String emp_id) {
        this.ord_id = ord_id;
        this.date = date;
        this.cus_id = cus_id;
        this.emp_id = emp_id;
    }

    public String getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(String ord_id) {
        this.ord_id = ord_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }
}
