package lk.ijse.meatShop.controller;

import animatefx.animation.BounceIn;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.meatShop.util.Navigation;
import lk.ijse.meatShop.util.Routes;

import java.io.IOException;

public class LoginFormContorller {

    public JFXPasswordField password;
    public JFXTextField txtUsername;
    public Label lblHide;
    public AnchorPane pane;
    public Label lblinvalidtxt;

    public void ViewPassword(MouseEvent mouseEvent) {




    }

    public void LoginOnaction(ActionEvent actionEvent) throws IOException {
        if(txtUsername.getText().equals("owner")&& password.getText().equals("1234")) {
            Navigation.navigate(Routes.OWNER, pane);

        }else if(txtUsername.getText().equals("cha")&& password.getText().equals("1234")){
            Navigation.navigate(Routes.CHASHIER,pane);
        }
        else {
            new BounceIn(txtUsername).play();
            new BounceIn(password).play();
            lblinvalidtxt.setText("Username or password invalid");
            password.setText("");
            txtUsername.setText("");

        }

    }

}
