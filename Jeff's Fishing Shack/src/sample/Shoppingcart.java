package sample;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;


import java.util.ArrayList;

import java.util.Properties;
import java.util.ResourceBundle;

public class Shoppingcart implements Initializable {

    public TextField emailcus;

    public String size1;
    public String size2;
    public String size3;
    public String size4;
    public String size5;
    public String size6;

    public int total = 0;
    public int commonquantity;

    public ComboBox combobox1;
    public ComboBox combobox2;
    public ComboBox combobox3;
    public ComboBox combobox4;
    public ComboBox combobox5;
    public ComboBox combobox6;


    public TextField quantity1;
    public TextField quantity2;
    public TextField quantity3;
    public TextField quantity4;
    public TextField quantity5;
    public TextField quantity6;

    public Label totalPrice1;
    public Label totalPrice2;
    public Label totalPrice3;
    public Label totalPrice4;
    public Label totalPrice5;
    public Label totalPrice6;


    public Label totalPrice10;
    public Label reel;
    public Label hook;
    public Label line;
    public Label rod;
    public Label sinkers;
    public Label swivels;
    public TextField name;
    public TextField mailid;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

//creating of arraylist to store the sizes of each product
        ArrayList<String> FISHINGREELS = new ArrayList<>();
        ArrayList<String> FISHYHOOKS = new ArrayList<>();
        ArrayList<String> FISHINGLINE = new ArrayList<>();
        ArrayList<String> FISHINGROD = new ArrayList<>();
        ArrayList<String> FISHINGSINKER = new ArrayList<>();
        ArrayList<String> SWIVELS = new ArrayList<String>();
//adding the values to array list
        FISHINGREELS.add("SMALL");
        FISHINGREELS.add("MEDIUM");
        FISHINGREELS.add("LARGE");
        FISHYHOOKS.add("4");
        FISHYHOOKS.add("6");
        FISHYHOOKS.add("8");
        FISHINGLINE.add("100");
        FISHINGLINE.add("200");
        FISHINGLINE.add("300");
        FISHINGROD.add("6");
        FISHINGROD.add("8");
        FISHINGROD.add("10");
        FISHINGSINKER.add("100");
        FISHINGSINKER.add("200");
        FISHINGSINKER.add("300");
        SWIVELS.add("SMALL");
        SWIVELS.add("MEDIUM");
        SWIVELS.add("LARGE");
//adding the arraylist to observable list to the value to combobox
        ObservableList<String> list1 = FXCollections.observableArrayList(FISHINGREELS);
        ObservableList<String> list2 = FXCollections.observableArrayList(FISHYHOOKS);
        ObservableList<String> list3 = FXCollections.observableArrayList(FISHINGLINE);
        ObservableList<String> list4 = FXCollections.observableArrayList(FISHINGROD);
        ObservableList<String> list5 = FXCollections.observableArrayList(FISHINGSINKER);
        ObservableList<String> list6 = FXCollections.observableArrayList(SWIVELS);
//setting the values to the combobox
        combobox1.setItems(list1);
        combobox2.setItems(list2);
        combobox3.setItems(list3);
        combobox4.setItems(list4);
        combobox5.setItems(list5);
        combobox6.setItems(list6);


    }


    //Searching for the unit price of the product and find the total price of the product
    public int database(String size, String code, int qty) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");
        String sql = "SELECT  `unit price` FROM `INVENTORY` WHERE code LIKE '%" + code + "%' AND size='" + size + "';";
        ResultSet resultSet = con.prepareStatement(sql).executeQuery();
        int price = 0;
        while (resultSet.next()) {
            price = resultSet.getInt("unit price");
        }
        System.out.println(price);
        int totalprice = qty * price;

        return totalprice;
    }


    public void fishingReel() throws SQLException {
        size1 = (String) combobox1.getValue();
        commonquantity = Integer.parseInt((quantity1.getText()));
        int totalprice = database(size1, "FRR", commonquantity);
        //double tot=totalprice;
        totalPrice1.setText(Integer.toString(totalprice));
        commonquantity = 0;
        total = total + totalprice;
        totalPrice10.setText(Integer.toString(total));
    }

    public void fishingHook() throws SQLException {
        size2 = (String) combobox2.getValue();
        commonquantity = Integer.parseInt((quantity2.getText()));
        int totalprice = database(size2, "FH", commonquantity);
        //double tot=totalprice;
        totalPrice2.setText(Integer.toString(totalprice));
        commonquantity = 0;
        total = total + totalprice;
        totalPrice10.setText(Integer.toString(total));
    }


    public void fishingLine() throws SQLException {
        size3 = (String) combobox3.getValue();
        commonquantity = Integer.parseInt((quantity3.getText()));
        int totalprice = database(size3, "FL", commonquantity);
        //double tot=totalprice;
        totalPrice3.setText(Integer.toString(totalprice));
        commonquantity = 0;
        total = total + totalprice;
        totalPrice10.setText(Integer.toString(total));
    }


    public void fishingRod() throws SQLException {
        size4 = (String) combobox4.getValue();
        commonquantity = Integer.parseInt((quantity4.getText()));
        int totalprice = database(size4, "FR", commonquantity);
        //double tot=totalprice;
        totalPrice4.setText(Integer.toString(totalprice));
        commonquantity = 0;
        total = total + totalprice;
        totalPrice10.setText(Integer.toString(total));
    }

    public void sinkers() throws SQLException {
        size5 = (String) combobox5.getValue();
        commonquantity = Integer.parseInt((quantity5.getText()));
        int totalprice = database(size5, "SI", commonquantity);
        //double tot=totalprice;
        totalPrice5.setText(Integer.toString(totalprice));
        commonquantity = 0;
        total = total + totalprice;
        totalPrice10.setText(Integer.toString(total));
    }

    public void swivels() throws SQLException {
        size6 = (String) combobox6.getValue();
        commonquantity = Integer.parseInt((quantity6.getText()));
        int totalprice = database(size6, "SW", commonquantity);
        //double tot=totalprice;
        totalPrice6.setText(Integer.toString(totalprice));
        commonquantity = 0;
        total = total + totalprice;
        totalPrice10.setText(Integer.toString(total));
    }

    @FXML
    public void productDetails(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/product.fxml", "Product");
    }

    @FXML
    public void cartback(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        loadWindow("/sample/customer.fxml", "Customer");
    }

    @FXML
    private void payment(ActionEvent event) throws IOException, SQLException {
        sendmail();
        enterdetails();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("YOUR BILL VALUE IS " + totalPrice10.getText() + " A mail will be sent to your mail confirming your mail");
        alert.showAndWait();

    }


    public void sendmail() {

        String host = "smtp.gmail.com";

//

        Properties props = new Properties();
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("jeff4thara@gmail.com", "jeff12,.");
                    }
                });


        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        try {
            message.setFrom(new InternetAddress("jeff4thara@gmail.com"));
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Set To: header field of the header.
        try {
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailid.getText()));
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Set Subject: header field
        try {
            message.setSubject("Testing Subject");
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Now set the actual message
        try {
            message.setText(",\n\tCustomer Name:" +name.getText()+ ".Your payment has been confirmed. Your total bill value is " + totalPrice10.getText());
        } catch (javax.mail.MessagingException e1) {
            e1.printStackTrace();
        }

        // Send message
        try {
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (Exception e) {
            e.printStackTrace();
        }



}
    public void enterdetails(){
        try

        {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fish", "root", "");

            String txt11 = name.getText();
            String txt12 = quantity1.getText();
            String txt13 = quantity2.getText();
            String txt14 = quantity3.getText();
            String txt15 = quantity4.getText();
            String txt16 = quantity5.getText();
            String txt17 = quantity6.getText();
            String txt18 = totalPrice10.getText();
            PreparedStatement stmt = con.prepareStatement(" insert into transactions values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, txt11);
            stmt.setString(2, txt12);
            stmt.setString(3, txt13);
            stmt.setString(4, txt14);
            stmt.setString(5, txt15);
            stmt.setString(6, txt16);
            stmt.setString(7, txt17);
            stmt.setString(8, txt18);


            int j = stmt.executeUpdate();
            System.out.println("1 record inserted");


            con.close();


        } catch(
                Exception e)

        {
            System.out.println(e);
        }



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

