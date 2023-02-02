package lk.ijse.meatShop.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import lk.ijse.meatShop.model.CustomerModel;
import lk.ijse.meatShop.model.FeedbackModel;
import lk.ijse.meatShop.to.Customer;
import lk.ijse.meatShop.to.Feedback;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddFeedbackFormController implements Initializable {

    @FXML
    private AnchorPane pane1;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXComboBox<String> combRate;

    @FXML
    private TextArea txtComment;
    String []rate={"1","2","3","4","5"};



    @FXML
    void AddOnaction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Feedback feedback =new Feedback(txtCustomerId.getText(),txtComment.getText(),
                Integer.parseInt(combRate.getValue()));
        boolean isAdded = FeedbackModel.save(feedback);
        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();
            cler();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }


    }

    private void cler() {
        txtComment.setText("");
        combRate.setPromptText("");
        txtCustomerId.setText("");

    }

    public void SerchOnAction(ActionEvent actionEvent) {
        try {
            Feedback feedback = FeedbackModel.search(txtCustomerId.getText());
            if (feedback!= null) {
                fillData(feedback);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateOnaction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int rate=Integer.parseInt(combRate.getValue());
        Feedback feedback=new Feedback(txtCustomerId.getText(),txtComment.getText(),rate);
        boolean isUpdate = FeedbackModel.Update(feedback);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successful...!").show();
            cler();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }
    }

    private void fillData(Feedback feedback) {

        txtComment.setText(feedback.getComment());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combRate.getItems().addAll(rate);

    }
}
