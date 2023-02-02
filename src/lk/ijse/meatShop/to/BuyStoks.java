package lk.ijse.meatShop.to;

import java.util.ArrayList;

public class BuyStoks {
    private String buy_id;
    private String date;
    private String sup_id;
    private double tot;
    private double advance;
    private double topayvalue;
    private ArrayList<CartDetail> orderDetails = new ArrayList<>();

    public BuyStoks(String buy_id, String date, String sup_id, double tot, double advance, double topayvalue, ArrayList<CartDetail> orderDetails) {
        this.buy_id = buy_id;
        this.date = date;
        this.sup_id = sup_id;
        this.tot = tot;
        this.advance = advance;
        this.topayvalue = topayvalue;
        this.orderDetails = orderDetails;
    }

    public BuyStoks() {
    }

    @Override
    public String toString() {
        return "BuyStoks{" +
                "buy_id='" + buy_id + '\'' +
                ", date='" + date + '\'' +
                ", sup_id='" + sup_id + '\'' +
                ", tot=" + tot +
                ", advance=" + advance +
                ", topayvalue=" + topayvalue +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public String getBuy_id() {
        return buy_id;
    }

    public void setBuy_id(String buy_id) {
        this.buy_id = buy_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getTopayvalue() {
        return topayvalue;
    }

    public void setTopayvalue(double topayvalue) {
        this.topayvalue = topayvalue;
    }

    public ArrayList<CartDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<CartDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
