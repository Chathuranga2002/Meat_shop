package lk.ijse.meatShop.util;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    private static AnchorPane pane2;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case OWNER:
                window.setTitle("Owner Dashbord ");
                initUI("OwnerDashbordForm.fxml");
                break;
            case LOGIN:
                window.setTitle("LOGIN");
                initUI("LoginForm.fxml");
                break;
            case ADDEMPLOYEE:

                initUI("AddEmployeeForm.fxml");
                break;
            case UPDATEEMPLOYEE:

                initUI("UpdateEmployeeForm.fxml");
                break;
            case VIEWEMPLOYEE:

                initUI("ViewEmployeeForm.fxml");
                break;
            case ADDSUPPLIER:

                initUI("AddSupplierForm.fxml");
                break;

            case VIEWSUP:

                initUI("ViewSupplierForm.fxml");
                break;
            case ADDITEM:

                initUI("AddItemForm.fxml");
                break;
            case FEEDBACK:

                initUI("FeedbackForm.fxml");
                break;
            case ADDTOSHOWCASE:

                initUI("AddShowcaseForm.fxml");
                break;
            case BUYITEM:

                initUI("BuyItemForm.fxml");
                break;
            case PAYMENT:
                initUI("PaymentForm.fxml");
                break;
            case CHASHIER:
                initUI("CashierDashbordForm.fxml");
                break;
            case CUSTOMER:
                initUI("AddCustomerForm.fxml");
                break;
            case ORDERVIEW:
                initUI("ViewOrderForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                        .getResource("/lk/ijse/meatShop/view/" + location)));
    }


}
