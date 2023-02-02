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

public class AddEmployeeFormController implements Initializable{

    public JFXComboBox cobroll;
    @FXML
    private AnchorPane pane1;

    @FXML
    private JFXTextField txtname;

    @FXML
    private Label lblid;

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
    void AddEmployeeOnaction(ActionEvent event) {




    }

    @FXML
    void AddToDbOnaction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Employee employee=new Employee();
        employee.setEmployeeId(lblid.getText());
        employee.setJobroll(String.valueOf(cobroll.getValue()));
        employee.setAddres(txtaddres.getText());
        employee.setName(txtname.getText());
        employee.setNic(txtnic.getText());
        employee.setPassword(txtpassword.getText());
        employee.setTel_no(txtmobileno.getText());
        employee.setUsername(txtusername.getText());

         boolean isAdded = EmployeeModel.save(employee);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();
            Nextid();
            cobroll.getItems().addAll(role);
            cler();

        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }


    }



    @FXML
    void UpdateEmplloyeeOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.UPDATEEMPLOYEE, pane1);

    }

    @FXML
    void ViewEmployeeOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VIEWEMPLOYEE, pane1);

    }

    private void Nextid() {

        try {
            ResultSet Set = EmployeeModel.getLastId();
            if (Set.next()) {
                String[] E00 = Set.getString(1).split("E00");
                int id = Integer.parseInt(E00[1]);
                id++;
                lblid.setText("E00" + id);


            } else {
                lblid.setText("E001");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String[] role={"Cashier", "Butcher"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Nextid();

        cobroll.getItems().addAll(role);
    }
    public void cler(){
        txtusername.setText("");
        txtmobileno.setText("");
        txtnic.setText("");
        txtaddres.setText("");
        txtname.setText("");
        txtpassword.setText("");
    }




    }
