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
import lk.ijse.meatShop.model.AddToShowcaseModel;
import lk.ijse.meatShop.model.BuyToStoreModel;
import lk.ijse.meatShop.model.ItemModel;
import lk.ijse.meatShop.to.Stocks;
import lk.ijse.meatShop.view.TM.ShowkaseTm;
import lk.ijse.meatShop.view.TM.StocksTm;
import lk.ijse.meatShop.view.TM.SupplierTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddShowcaseFormController implements Initializable {

    public Label lblqtyonstoks;
    @FXML
    private AnchorPane pane1;

    @FXML
    private TableView <StocksTm> tblStoks;

    @FXML
    private TableColumn colItemCode;

    @FXML
    private TableColumn colcatagary;

    @FXML
    private TableColumn coldesc;

    @FXML
    private TableColumn colqty;

    @FXML
    private TableView<ShowkaseTm> tblShowcase;

    @FXML
    private TableColumn colSitemcode;

    @FXML
    private TableColumn colScategory;

    @FXML
    private TableColumn colSdesc;

    @FXML
    private TableColumn colSuniteprice;

    @FXML
    private TableColumn colSqtyonhand;

    @FXML
    private JFXTextField txtqty;

    @FXML
    private JFXComboBox cobitemcode;

    @FXML
    private Label lblcategory;

    @FXML
    private Label lbldescription;

    @FXML
    private JFXTextField txtuniteprice;

    @FXML
    void AddOnAction(ActionEvent event) {
        String itemcode=icode;
        double uniteprice= Double.parseDouble(txtuniteprice.getText());
        int qty= Integer.parseInt(txtqty.getText());
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isStokUpdate = AddToShowcaseModel.UpdateStoks(qty,itemcode);
            if (isStokUpdate) {
                boolean isItemupdate =AddToShowcaseModel.UpdateShowcasse(qty,itemcode,uniteprice);
                if (isItemupdate) {
                    DBConnection.getInstance().getConnection().commit();
                    new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();
                    cler();
                    setTable();
                    setvalus();
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
            } catch (SQLException | ClassNotFoundException ignored) {
            }
        }

    }
    ObservableList<StocksTm> stocksTms = FXCollections.observableArrayList();
    ObservableList<ShowkaseTm> showkaseTms = FXCollections.observableArrayList();

    private void setTable() {
        tblStoks.getItems().clear();
        tblShowcase.getItems().clear();
        try {
            ResultSet set1 = ItemModel.getAll();
            ResultSet set2 = ItemModel.getAllItem();
            while (set1.next()){
                stocksTms.add(new StocksTm(
                        set1.getString(1),
                        set1.getString(2),
                        set1.getString(3),
                        set1.getInt(4)
                ));
            }
            while (set2.next()){
                showkaseTms.add(new ShowkaseTm(
                        set2.getString(1),
                        set2.getString(2),
                        set2.getString(3),
                        set2.getDouble(4),
                        set2.getInt(5)
                ));
            }

            tblStoks.setItems(stocksTms);
            tblShowcase.setItems(showkaseTms);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setvalus(){
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        colcatagary.setCellValueFactory(new PropertyValueFactory<>("category"));
        coldesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("QtyonHand"));

        colSitemcode.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        colScategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colSdesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colSqtyonhand.setCellValueFactory(new PropertyValueFactory<>("QtyonHand"));
        colSuniteprice.setCellValueFactory(new PropertyValueFactory<>("uniteprice"));


    }
    public void combo(){
        try {
            ResultSet itemcode = AddToShowcaseModel.getStokscode();
            ObservableList<String> item = FXCollections.observableArrayList();


            while (itemcode.next()) {
                item.add(itemcode.getString(1));
                cobitemcode.setItems(item);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void cler(){
        lbldescription.setText("");
        lblqtyonstoks.setText("");
        lblcategory.setText("");
       txtuniteprice.setText("");
       txtqty.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setvalus();
        setTable();
        combo();

    }
        String icode;
    public void IsselectItemOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        icode=cobitemcode.getSelectionModel().getSelectedItem().toString();
        Stocks itemDesc = AddToShowcaseModel.getStoksDesc(icode);
        lblcategory.setText(itemDesc.getCategory());
        lbldescription.setText(itemDesc.getDescription());
        lblqtyonstoks.setText(String.valueOf(itemDesc.getQtyonHand()));
    }
}
