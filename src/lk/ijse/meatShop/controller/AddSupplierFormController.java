package lk.ijse.meatShop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.model.SupplierModel;
import lk.ijse.meatShop.to.Employee;
import lk.ijse.meatShop.to.Supplier;
import lk.ijse.meatShop.util.Navigation;
import lk.ijse.meatShop.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddSupplierFormController implements Initializable {

    public Label lblId;
    @FXML
    private AnchorPane pane1;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtaddres;

    @FXML
    private JFXTextField txtnic;

    @FXML
    private JFXTextField txtmobileno;

    @FXML
    private JFXTextField txtid;


    @FXML
    void AddSupplierOnaction(ActionEvent event) {

    }

    @FXML
    void SearchOnaction(ActionEvent event) {
        try {
            Supplier supplier = SupplierModel.search(txtid.getText());
            if (supplier!= null) {
                fillData(supplier);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void ViewSupplierOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VIEWSUP, pane1);


    }
    @FXML
    public void UpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Supplier supplier=new Supplier(lblId.getText(),txtname.getText(),txtaddres.getText(),txtnic.getText(),
                txtmobileno.getText());

        boolean isUpdate = SupplierModel.Update(supplier);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successful...!").show();
            reset();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }
    }
    @FXML
    public void AddSuoOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Supplier supplier=new Supplier(lblId.getText(),txtname.getText(),txtaddres.getText(),txtnic.getText(),
                txtmobileno.getText());

        boolean isAdded = SupplierModel.save(supplier);
        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();
            reset();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }
    }
    private void fillData(Supplier supplier) {

        lblId.setText(supplier.getSup_id());
        txtnic.setText(supplier.getNic());
        txtname.setText(supplier.getName());
        txtaddres.setText(supplier.getAddress());
        txtmobileno.setText(supplier.getTel_no());

    }
    private void Nextid() {

        try {
            ResultSet Set = SupplierModel.getLastId();
            if (Set.next()) {
                String[] S00 = Set.getString(1).split("S00");
                int id = Integer.parseInt(S00[1]);
                id++;
                lblId.setText("S00" + id);


            } else {
                lblId.setText("S001");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void reset(){
        Nextid();
        txtid.setText("");
        txtaddres.setText("");
        txtmobileno.setText("");
        txtname.setText("");
        txtnic.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Nextid();
    }

    public void SearchonAction(ActionEvent actionEvent) {
        try {
            Supplier supplier = SupplierModel.search(txtid.getText());
            if (supplier!= null) {
                fillData(supplier);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
