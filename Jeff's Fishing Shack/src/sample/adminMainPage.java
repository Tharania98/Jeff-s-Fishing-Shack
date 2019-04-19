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

public class adminMainPage {

@FXML
//method load another window on button click
    public void enterStaffDetails(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/staffDetails.fxml", "staffDetails");
        }
    @FXML
    //method load another window on button click
    public void viewTransactions(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/viewTransactionAdmin.fxml", "viewTransactionAdmin");
    }
@FXML
//method load another window on button click
public void modifyStaffDetails(ActionEvent event) throws IOException{
    ((Node) event.getSource()).getScene().getWindow().hide();
    loadWindow("/sample/modifyStaffDetails.fxml", "modifyStaffDetails");
}

@FXML
//method load another window on button click
public void adminlogout(ActionEvent event) throws IOException{
    ((Node) event.getSource()).getScene().getWindow().hide();
    loadWindow("/sample/welcome.fxml", " Welcome ");
}


    //method load another window
    public void loadWindow (String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }


}
