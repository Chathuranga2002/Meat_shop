package lk.ijse.meatShop.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.model.ViewOrderModel;
import lk.ijse.meatShop.to.CartDetail;
import lk.ijse.meatShop.to.Order;
import lk.ijse.meatShop.to.OrderDetils;
import lk.ijse.meatShop.view.TM.EmployeTM;
import lk.ijse.meatShop.view.TM.OrderTM;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewOrderFormController {

    @FXML
    private AnchorPane pane1;

    @FXML
    private JFXTextField txtordsid;

    @FXML
    private TableView<OrderTM> TalOrders;

    @FXML
    private TableColumn colOid;

    @FXML
    private TableColumn colitemcode;

    @FXML
    private TableColumn colqty;

    @FXML
    private TableColumn coluniteprice;

    @FXML
    void searchOnaction(ActionEvent event) {
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("item_code"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        coluniteprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colOid.setCellValueFactory(new PropertyValueFactory<>("ord_id"));

        setTable();


    }
    ObservableList<OrderTM> orderTms= FXCollections.observableArrayList();
    private void setTable() {
        TalOrders.getItems().clear();
        try {
            ResultSet set = ViewOrderModel.getAll( txtordsid.getText());
            while (set.next()){
                orderTms.add(new OrderTM(
                        set.getString(1),
                        set.getString(2),
                        set.getInt(3),
                        set.getDouble(4))


                );
            }
            TalOrders.setItems(orderTms);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
