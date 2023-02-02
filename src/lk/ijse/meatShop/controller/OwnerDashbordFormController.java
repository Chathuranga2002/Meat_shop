package lk.ijse.meatShop.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.ijse.meatShop.util.DateAndTime;
import lk.ijse.meatShop.util.Navigation;
import lk.ijse.meatShop.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class OwnerDashbordFormController implements Initializable {


    public Label lbltitile;
    public AnchorPane pane3;
    public AnchorPane pane;
    public Label lblDate;
    public Text txttime;
    public AnchorPane pane1;
    @FXML
    private AnchorPane Pane;

    @FXML
    private Label lblname;

    @FXML
    private AnchorPane pane2;

    @FXML
    void EmployeeOnAction(ActionEvent event) throws IOException {
        pane1.setVisible(false);
        Navigation.navigate(Routes.ADDEMPLOYEE, pane);

    }

    @FXML
    void ItemOnAction(ActionEvent event) throws IOException {
        pane1.setVisible(false);
        Navigation.navigate(Routes.ADDITEM, pane);

    }

    @FXML
    void LogoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN, Pane);


    }

    @FXML
    void ReportOnAction(ActionEvent event) {

    }

    @FXML
    void StocksOnAction(ActionEvent event) throws IOException {
        pane1.setVisible(false);

        Navigation.navigate(Routes.ADDTOSHOWCASE, pane);

    }

    @FXML
    void SupllerOnAction(ActionEvent event) throws IOException {
        pane1.setVisible(false);
    
        Navigation.navigate(Routes.ADDSUPPLIER, pane);

    }

    public void FeedbackOnAction(ActionEvent actionEvent) throws IOException {
        pane1.setVisible(false);
        Navigation.navigate(Routes.FEEDBACK, pane);
    }

    public void PaymentOnAction(ActionEvent actionEvent) throws IOException {
        pane1.setVisible(false);
        Navigation.navigate(Routes.PAYMENT, pane);
    }
    private void setTime() {
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    txttime.setText("Time : "+hour.format(new Date()));

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTime();
        lblDate.setText("Date :"+DateAndTime.dateNow());
        lblname.setText("Thisra");

    }
}
