package lk.ijse.meatShop.view.TM;

public class PaymentTm {
    String id;
    String date;
    double total;
    double advance;
    double balance;
    public PaymentTm() {
    }



    @Override
    public String toString() {
        return "PaymentTm{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", total=" + total +
                ", advance=" + advance +
                ", balance=" + balance +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PaymentTm(String id, String date, double total, double advance, double balance) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.advance = advance;
        this.balance = balance;
    }
}
