package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewTransactionAdmin {

    @FXML
    private Label label;
    @FXML
    private TableView<Transactions> viewtransactions;
    @FXML
    private TableColumn<Transactions, String> customername;
    @FXML
    private TableColumn<Transactions,String> reel;
    @FXML
    private TableColumn<Transactions,String> hook;
    @FXML
    private TableColumn<Transactions,String> line;
    @FXML
    private TableColumn<Transactions,String> rod;
    @FXML
    private TableColumn<Transactions,String> sinker;
    @FXML
    private TableColumn<Transactions,String> swivel;
    @FXML

    private TableColumn<Transactions,Integer> price;

    //Initialise observable list to hold out database data
    private ObservableList<Transactions> data;

    public void loaddetails(ActionEvent event) throws IOException {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");
            data = FXCollections.observableArrayList();
            //Execute query and store result in a resultset
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM transactions");
            while (rs.next()) {
                data.add(new Transactions(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
            }
        }catch(SQLException ex){
            System.out.println("Error"+ex);
        }
//set cell value factory to tableview
        customername.setCellValueFactory(new PropertyValueFactory<>("customername"));
        reel.setCellValueFactory(new PropertyValueFactory<>("reel"));
        hook.setCellValueFactory(new PropertyValueFactory<>("hook"));
        line.setCellValueFactory(new PropertyValueFactory<>("line"));
        rod.setCellValueFactory(new PropertyValueFactory<>("rod"));
        sinker.setCellValueFactory(new PropertyValueFactory<>("sinker"));
        swivel.setCellValueFactory(new PropertyValueFactory<>("swivel"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        //tableUser.setItems(null);
        viewtransactions.setItems(data);
    }



    public void transback(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/adminMainPage.fxml", "adminMainPage");
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
