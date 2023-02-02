package lk.ijse.meatShop.to;

public class Feedback {
    private String cus_id;
    private String comment;
    private int rate;

    public Feedback(String cus_id, String comment, int rate) {
        this.cus_id = cus_id;
        this.comment = comment;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "cus_id='" + cus_id + '\'' +
                ", comment='" + comment + '\'' +
                ", rate=" + rate +
                '}';
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Feedback() {
    }
}
