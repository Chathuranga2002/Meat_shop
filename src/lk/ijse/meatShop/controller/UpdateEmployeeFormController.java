package lk.ijse.meatShop.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.to.Employee;
import lk.ijse.meatShop.util.Navigation;
import lk.ijse.meatShop.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateEmployeeFormController implements Initializable {

    @FXML
    private AnchorPane pane2;

    @FXML
    private JFXTextField txtname;

    @FXML
    private Label lblemoid;

    @FXML
    private JFXPasswordField txtpassword;

    @FXML
    private JFXTextField txtaddres;

    @FXML
    private JFXTextField txtnic;

    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXTextField txtmobileno;

    @FXML
    private JFXComboBox cobjobroll;

    @FXML
    private JFXTextField txtSearchbox;

    @FXML
    void AddEmployeeOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADDEMPLOYEE, pane2);

    }

    @FXML
    void SearchOnaction(ActionEvent event) throws SQLException, ClassNotFoundException {


        try {
            Employee employee = EmployeeModel.search(txtSearchbox.getText());
            if (employee!= null) {
                fillData(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void fillData(Employee employee) {
        lblemoid.setText(employee.getEmployeeId());
        txtusername.setText(employee.getUsername());
        txtnic.setText(employee.getNic());
        txtname.setText(employee.getName());
        txtaddres.setText(employee.getAddres());
        cobjobroll.setPromptText(employee.getJobroll());
        txtmobileno.setText(employee.getTel_no());

    }

    @FXML
    void UpdateEmplloyeeOnaction(ActionEvent event) {

    }

    @FXML
    void UpdateSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Employee employee=new Employee();
        employee.setEmployeeId(lblemoid.getText());
        employee.setUsername(txtusername.getText());
        employee.setPassword(txtpassword.getText());
        employee.setAddres(txtaddres.getText());
        employee.setNic(txtnic.getText());
        employee.setTel_no(txtmobileno.getText());
        employee.setName(txtname.getText());
        employee.setJobroll(String.valueOf(cobjobroll.getValue()));


        boolean isUpdate = EmployeeModel.Update(employee);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successful...!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }

    }

    @FXML
    void ViewEmployeeOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VIEWEMPLOYEE, pane2);

    }

    String[] role={"Cashier", "Butcher"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cobjobroll.getItems().addAll(role);
    }
}
