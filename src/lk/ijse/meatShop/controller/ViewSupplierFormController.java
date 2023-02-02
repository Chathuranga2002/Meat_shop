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
import lk.ijse.meatShop.model.SupplierModel;
import lk.ijse.meatShop.util.Navigation;
import lk.ijse.meatShop.util.Routes;
import lk.ijse.meatShop.view.TM.EmployeTM;
import lk.ijse.meatShop.view.TM.SupplierTM;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewSupplierFormController implements Initializable {

    @FXML
    private AnchorPane pane3;

    @FXML
    private TableView<SupplierTM> tblSupplier;

    @FXML
    private TableColumn colSup_id;

    @FXML
    private TableColumn colnic;

    @FXML
    private TableColumn colname;

    @FXML
    private TableColumn coladdres;

    @FXML
    private TableColumn coltel_no;
    ObservableList<SupplierTM> supplierTMS = FXCollections.observableArrayList();

    @FXML
    void AddSupplierOnaction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADDSUPPLIER, pane3);

    }
    private void setTable() {
        tblSupplier.getItems().clear();
        try {
            ResultSet set = SupplierModel.getAll();
            while (set.next()){
                supplierTMS.add(new SupplierTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5)


                ));
            }
            tblSupplier.setItems(supplierTMS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ViewSupplierOnaction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colSup_id.setCellValueFactory(new PropertyValueFactory<>("sup_id"));
        colnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdres.setCellValueFactory(new PropertyValueFactory<>("address"));
        coltel_no.setCellValueFactory(new PropertyValueFactory<>("tel_no"));
        setTable();

    }
}
