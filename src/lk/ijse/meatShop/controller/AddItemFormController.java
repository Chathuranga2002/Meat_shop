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
import lk.ijse.meatShop.db.DBConnection;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.model.ItemModel;
import lk.ijse.meatShop.to.Item;
import lk.ijse.meatShop.to.Stocks;
import lk.ijse.meatShop.util.Navigation;
import lk.ijse.meatShop.util.Routes;
import lk.ijse.meatShop.view.TM.EmployeTM;
import lk.ijse.meatShop.view.TM.StocksTm;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddItemFormController implements Initializable {

    @FXML
    private AnchorPane pane1;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private Label lblItemcode;

    @FXML
    private JFXComboBox combcatagry;

    @FXML
    private TableView tblStoks;
    ObservableList<StocksTm> stocksTms= FXCollections.observableArrayList();

    @FXML
    private TableColumn colItemCode;

    @FXML
    private TableColumn colcatagary;

    @FXML
    private TableColumn coldesc;

    @FXML
    private TableColumn colqty;

    @FXML
    void AddItemOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Stocks stocks=new Stocks();
        stocks.setItemcode(lblItemcode.getText());
        stocks.setCategory(String.valueOf(combcatagry.getValue()));
        stocks.setDescription(txtDescription.getText());
        stocks.setQtyonHand(0);

        Item item=new Item();
        item.setItemcode(lblItemcode.getText());
        item.setCategory(String.valueOf(combcatagry.getValue()));
        item.setDescription(txtDescription.getText());
        item.setUnitPrice(0.00);
        item.setQtyonHand(0);




        try {
             DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isStoksSaved = ItemModel.saveStoks(stocks);
            if (isStoksSaved) {
                boolean isItemSaved = ItemModel.saveItem(item);
                if (isItemSaved) {
                    DBConnection.getInstance().getConnection().commit();
                    new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();
                    txtDescription.clear();
                    Nextid();
                    setTable();
                } else {
                    DBConnection.getInstance().getConnection().rollback();
                    new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
                }
            } else {
                DBConnection.getInstance().getConnection().rollback();
                new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
            }
        } catch (SQLException | ClassNotFoundException ignored) {

        } finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException ignored) {
            }
        }


    }



    @FXML
    void AddToShowroomOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADDTOSHOWCASE, pane1);

    }

    @FXML
    void BuyItemOnaction(ActionEvent event) throws IOException {
       // Navigation.navigate(Routes., pane1);
        Navigation.navigate(Routes.BUYITEM, pane1);


    }

    @FXML
    void BuyOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.BUYITEM, pane1);

    }
    private void Nextid() {

        try {
            ResultSet Set = ItemModel.getLastId();
            if (Set.next()) {
                String[] I00 = Set.getString(1).split("I00");
                int id = Integer.parseInt(I00[1]);
                id++;
                lblItemcode.setText("I00" + id);


            } else {
                lblItemcode.setText("I001");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setTable() {
        tblStoks.getItems().clear();
        try {
            ResultSet set = ItemModel.getAll();
            while (set.next()){
                stocksTms.add(new StocksTm(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getInt(4)

                ));
            }
            tblStoks.setItems(stocksTms);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    String[] category ={"Meat", "Fish","Other"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combcatagry.getItems().addAll(category);
        Nextid();

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        colcatagary.setCellValueFactory(new PropertyValueFactory<>("category"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("QtyonHand"));
        setTable();



    }
}
