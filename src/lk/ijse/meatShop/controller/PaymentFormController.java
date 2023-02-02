package lk.ijse.meatShop.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.meatShop.model.AddToShowcaseModel;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.model.PaymentModle;
import lk.ijse.meatShop.model.SupplierModel;
import lk.ijse.meatShop.to.Payment;
import lk.ijse.meatShop.to.Stocks;
import lk.ijse.meatShop.view.TM.PaymentTm;
import lk.ijse.meatShop.view.TM.SupplierTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaymentFormController implements Initializable {

    @FXML
    private AnchorPane pane1;

    @FXML
    private Label lbldate;

    @FXML
    private JFXComboBox combBuyid;

    @FXML
    private TableView<PaymentTm> tblpayment;

    @FXML
    private TableColumn colIbuyid;

    @FXML
    private TableColumn coldate;

    @FXML
    private TableColumn coltatal;

    @FXML
    private TableColumn colpayed;

    @FXML
    private TableColumn colbalance;

    @FXML
    private JFXTextField txtMonyamunt;

    @FXML
    private Label lbltatal;

    @FXML
    private Label lblPayed;
    ObservableList<PaymentTm> paymentTms = FXCollections.observableArrayList();


    @FXML
    void updateorderOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        double amount= Double.parseDouble(txtMonyamunt.getText());
        boolean isUpdate = PaymentModle.UpdateStoks(amount,id);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successful...!").show();
            cler();
            setvalus();
            setTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }


    }
    private void setTable() {
        tblpayment.getItems().clear();
        try {
            ResultSet set = PaymentModle.getAll();
            while (set.next()){
                paymentTms.add(new PaymentTm(
                        set.getString(1),
                        set.getString(2),
                        set.getDouble(3),
                        set.getDouble(4),
                        set.getDouble(5)


                ));
            }
            tblpayment.setItems(paymentTms);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setvalus(){
        colIbuyid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coltatal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colbalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        colpayed.setCellValueFactory(new PropertyValueFactory<>("advance"));
    }
    public void combo(){
        try {
            ResultSet code = PaymentModle.getcode();
            ObservableList<String> codelist = FXCollections.observableArrayList();


            while (code.next()) {
                codelist.add(code.getString(1));
                combBuyid.setItems(codelist);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setvalus();
        setTable();
        combo();
    }
    String id;
    public void IdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            id = combBuyid.getSelectionModel().getSelectedItem().toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        Payment desc = PaymentModle.getDesc(id);
        lbldate.setText(desc.getDate());
        lblPayed.setText(String.valueOf(desc.getAdvance()));
        lbltatal.setText(String.valueOf(desc.getTotal()));
        txtMonyamunt.setText(String.valueOf(desc.getBalance()));
    }
    public void cler(){
        combo();
        lbldate.setText("");
        lblPayed.setText("");
        lbltatal.setText("");
        txtMonyamunt.setText("");
    }
}
