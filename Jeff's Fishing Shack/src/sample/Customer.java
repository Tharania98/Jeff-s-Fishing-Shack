package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Customer {
@FXML
//method load another window on button click
    private void purchase(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/shoppingcart.fxml", "Shoppingcart");
    }
@FXML
//method load another window on button click
    private void inquire(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/inquire.fxml", "inquire");
    }

 @FXML
 //method load another window on button click
 private void modify(ActionEvent event) throws IOException {
     ((Node) event.getSource()).getScene().getWindow().hide();
     loadWindow("/sample/modify.fxml", "Modify");
 }

@FXML
//method load another window on button click
private void logout(ActionEvent event) throws IOException {
    ((Node) event.getSource()).getScene().getWindow().hide();
    loadWindow("/sample/welcome.fxml", "Welcome");
}

    //method load another window
    public void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }
}
