package lk.ijse.meatShop.view.TM;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FeedbackTm {
    private String cus_id ;
    private String comment ;
    private ImageView view;

    public String getCus_id() {
        return cus_id;
    }

    public FeedbackTm() {
    }

    @Override
    public String toString() {
        return "FeedbackTm{" +
                "cus_id='" + cus_id + '\'' +
                ", comment='" + comment + '\'' +
                ", view=" + view +
                '}';
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

    public ImageView getView() {
        return view;
    }

    public void setView(ImageView view) {
        this.view = view;
    }

    public FeedbackTm(String cus_id, String comment, ImageView view) {
        this.cus_id = cus_id;
        this.comment = comment;
        this.view = view;
    }
}
