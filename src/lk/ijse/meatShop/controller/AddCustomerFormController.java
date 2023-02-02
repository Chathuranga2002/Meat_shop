package lk.ijse.meatShop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.meatShop.model.CustomerModel;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.model.PaymentModle;
import lk.ijse.meatShop.to.Customer;
import lk.ijse.meatShop.to.Employee;
import lk.ijse.meatShop.view.TM.CustomerTM;
import lk.ijse.meatShop.view.TM.EmployeTM;
import lk.ijse.meatShop.view.TM.PaymentTm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private AnchorPane pane1;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtaddres;

    @FXML
    private JFXTextField txtmobileno;

    @FXML
    private JFXTextField txtcusid;

    @FXML
    private TableView<CustomerTM> Tablecustomer;

    @FXML
    private TableColumn colid;

    @FXML
    private TableColumn colname;

    @FXML
    private TableColumn Addrescoladdress;

    @FXML
    private TableColumn colcontactno;
    ObservableList<CustomerTM> customerTMS= FXCollections.observableArrayList();

    @FXML
    void AddToDbOnaction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id=txtcusid.getText();
        String name=txtname.getText();
        String address=txtaddres.getText();
        String telno=txtmobileno.getText();
        Customer customer=new Customer(id,name,address,telno);
        boolean isAdded = CustomerModel.save(customer);

        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();
            cler();
            Nextid();
            setTable();
            setvalus();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }

    }

    @FXML
    void FeedbackOnaction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/meatShop/view/AddFeedbackForm.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Feedback");

    }

    @FXML
    void SearchOnaction(ActionEvent event) {
        try {
            Customer customer = CustomerModel.search(txtcusid.getText());
            if (customer!= null) {
                fillData(customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void UpdateOnaction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Customer customer=new Customer(txtcusid.getText(),txtname.getText(),txtaddres.getText(),txtmobileno.getText());
        boolean isUpdate = CustomerModel.Update(customer);

        if (isUpdate) {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successful...!").show();
            cler();
            Nextid();
            setTable();
            setvalus();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }

    }
    private void Nextid() {

        try {
            ResultSet Set = CustomerModel.getLastId();
            if (Set.next()) {
                String[] C00 = Set.getString(1).split("C00");
                int id = Integer.parseInt(C00[1]);
                id++;
                txtcusid.setText("C00" + id);


            } else {
                txtcusid.setText("C001");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void cler(){
        txtmobileno.setText("");
        txtaddres.setText("");
        txtname.setText("");
        txtname.setText("");
    }
    private void setTable() {
        Tablecustomer.getItems().clear();
        try {
            ResultSet set = CustomerModel.getAll();
            while (set.next()){
                customerTMS.add(new CustomerTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4)



                ));
            }
            Tablecustomer.setItems(customerTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setvalus(){
        colid.setCellValueFactory(new PropertyValueFactory<>("cus_id"));
        colcontactno.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Addrescoladdress.setCellValueFactory(new PropertyValueFactory<>("address"));

    }
    private void fillData(Customer customer) {

        txtname.setText(customer.getName());
        txtaddres.setText(customer.getAddress());
        txtmobileno.setText(customer.getTel_no());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Nextid();
        setTable();
        setvalus();
    }
}
