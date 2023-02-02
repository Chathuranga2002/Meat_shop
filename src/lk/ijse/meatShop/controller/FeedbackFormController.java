package lk.ijse.meatShop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.meatShop.model.EmployeeModel;
import lk.ijse.meatShop.model.FeedbackModel;
import lk.ijse.meatShop.to.Feedback;
import lk.ijse.meatShop.view.TM.EmployeTM;
import lk.ijse.meatShop.view.TM.FeedbackTm;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FeedbackFormController implements Initializable {
    ObservableList<FeedbackTm> feedbackTms = FXCollections.observableArrayList();

    @FXML
    private AnchorPane pane1;

    @FXML
    private TableView<FeedbackTm> tblfeedbacks;

    @FXML
    private TableColumn colcusid;

    @FXML
    private TableColumn colcomment;

    @FXML
     TableColumn colratings;
    Image image;

    private void getall(){
        tblfeedbacks.getItems().clear();
      try {
          ResultSet set = FeedbackModel.getAll();
          while (set.next()){
             Feedback setrate=   new Feedback(
                      set.getString(1),
                      set.getString(2),
                      set.getInt(3));



                int rate=setrate.getRate();
              switch (rate){
                  case 1:
                      image=new Image("/lk/ijse/meatShop/assets/image/Rate/1star.png");
                      System.out.println("1");
                      break;
                  case 2:
                      image=new Image("/lk/ijse/meatShop/assets/image/Rate/2star.png");
                      System.out.println("2");
                      break;
                  case 3:
                      image=new Image("/lk/ijse/meatShop/assets/image/Rate/3star.png");
                      System.out.println("3");
                      break;
                  case 4:
                      image=new Image("/lk/ijse/meatShop/assets/image/Rate/4star.png");
                      System.out.println("4");
                      break;
                  case 5:
                      image=new Image("/lk/ijse/meatShop/assets/image/Rate/5star.png");
                      System.out.println("5");
                      break;
              }
              ImageView view = new ImageView(image);
//              view.setFitHeight(40);
//              view.setFitWidth(250);
              feedbackTms.add(new FeedbackTm(setrate.getCus_id(),setrate.getComment(),view));
          }
          tblfeedbacks.setItems(feedbackTms);
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
  }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colcusid.setCellValueFactory(new PropertyValueFactory<>("cus_id"));
        colcomment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        colratings.setCellValueFactory(new PropertyValueFactory<>("view"));
        getall();

    }
}
