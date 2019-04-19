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

public class modifyStaffDetails {
    public Button modifystaff;
    public TextField user;
    public PasswordField pass;
    public TextField full;

    @FXML
    //method to modify staff details
    private void modifystaff(ActionEvent event) throws SQLException {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");//database connection



            PreparedStatement stmt = con.prepareStatement(" UPDATE staff SET Staff user name=?, Staff Password = ?  WHERE Staff Full Name = '"+full.getText()+"'" );//query to update staff details on to database details

            stmt.setString(1, user.getText());
            stmt.setString(2, pass.getText());



            int i = stmt.executeUpdate();
            System.out.println("1 record inserted");



            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }




    }

    public void modifystaffback(ActionEvent event) throws IOException{
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/modify.fxml", "Modify");
    }


    public void loadWindow(String location, String title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }
}
