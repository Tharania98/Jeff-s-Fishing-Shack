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

public class ProductDetails {
    @FXML
    private Label label;
    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, String> columnproductName;
    @FXML
    private TableColumn<Product,String> columnsize;
    @FXML
    private TableColumn<Product,Integer> columnunitPrice;
    @FXML
    private Button btnLoad;
    //Initialise observable list to hold out database data
    private ObservableList<Product> data;
//method to load data from database table
    public void loadData(ActionEvent event) throws IOException {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");
            data = FXCollections.observableArrayList();
            //Execute query and store result in a resultset
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM inventory");
            while (rs.next()) {
                data.add(new Product(rs.getString(3), rs.getString(4), rs.getInt(5)));
            }

        }catch(SQLException ex){
            System.out.println("Error"+ex);
        }
//set cell value factory to tableview
        columnproductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        columnsize.setCellValueFactory(new PropertyValueFactory<>("size"));
        columnunitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        //tableUser.setItems(null);
        tableProduct.setItems(data);
    }//method load another window on button click
    public void back(ActionEvent event) throws IOException{
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/shoppingcart.fxml", "Shoppingcart");


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
