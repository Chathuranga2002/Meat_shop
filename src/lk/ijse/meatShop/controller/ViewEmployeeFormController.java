package lk.ijse.meatShop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.util.Navigation;
import lk.ijse.meatShop.util.Routes;
import lk.ijse.meatShop.view.TM.EmployeTM;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewEmployeeFormController implements Initializable {

    @FXML
    private AnchorPane pane3;

    @FXML
    private TableView tblemployee;

    @FXML
    private TableColumn colemp_id;

    @FXML
    private TableColumn colusername;

    @FXML
    private TableColumn colnic;

    @FXML
    private TableColumn colname;

    @FXML
    private TableColumn coladdres;

    @FXML
    private TableColumn coltel_no;

    @FXML
    private TableColumn colroll;

    ObservableList<EmployeTM> employeeTMS= FXCollections.observableArrayList();

    @FXML
    void AddEmployeeOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADDEMPLOYEE, pane3);

    }
    private void setTable() {
        tblemployee.getItems().clear();
        try {
            ResultSet set = EmployeeModel.getAll();
            while (set.next()){
                employeeTMS.add(new EmployeTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(7)

                ));
            }
            tblemployee.setItems(employeeTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void UpdateEmplloyeeOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADDEMPLOYEE, pane3);

    }

    @FXML
    void ViewEmployeeOnaction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colemp_id.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdres.setCellValueFactory(new PropertyValueFactory<>("address"));
        coltel_no.setCellValueFactory(new PropertyValueFactory<>("telno"));
        colroll.setCellValueFactory(new PropertyValueFactory<>("rool"));
        setTable();





    }
}
