package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modify {
    public Button modify;
    public TextField mdfusername;
    public PasswordField mdfpassword;
    public TextField mdffirstname;
    public TextField mdflastname;
    public TextField mdfid;
@FXML

//method to modify customer details
    private void modify(ActionEvent event) throws SQLException {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");//database connection



            PreparedStatement stmt = con.prepareStatement(" UPDATE customer SET Email=?, Password = ?, FirstName = ?, LastName = ? WHERE Id = '"+mdfid.getText()+"'" );//query to update data from database table

            stmt.setString(1, mdfusername.getText());
            stmt.setString(2, mdfpassword.getText());
            stmt.setString(3, mdffirstname.getText());
            stmt.setString(4, mdflastname.getText());

            int i = stmt.executeUpdate();
            System.out.println("1 record inserted");



            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }




    }
    //method load another window on button click
    public void customer(ActionEvent event) throws IOException{
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/adminMainPage.fxml", "adminMainPage");

    }//method load another window
    public void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }
}
