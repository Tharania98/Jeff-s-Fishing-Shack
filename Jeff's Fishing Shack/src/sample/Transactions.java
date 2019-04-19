package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transactions {


private final StringProperty customername;
    private final StringProperty reel;
    private final StringProperty hook;
    private final StringProperty line;
    private final StringProperty rod;
    private final StringProperty sinker;
    private final StringProperty swivel;
    private final IntegerProperty price;





    public Transactions(String customername, String reel, String hook, String line, String rod,String sinker, String swivel,int price) {

        this.customername = new SimpleStringProperty(customername);
        this.reel = new SimpleStringProperty(reel);
        this.hook = new SimpleStringProperty(hook);
        this.line = new SimpleStringProperty(line);
        this.rod = new SimpleStringProperty(rod);
        this.sinker= new SimpleStringProperty(sinker);
        this.swivel = new SimpleStringProperty(swivel);
        this.price = new SimpleIntegerProperty(price);

    }



    public StringProperty customernameProperty(){
        return customername;
    }
    public StringProperty reelProperty(){
        return reel;
    }
    public StringProperty hookProperty(){
        return hook;
    }
    public StringProperty lineProperty(){
        return line;
    }
    public StringProperty rodProperty(){
        return rod;
    }
    public StringProperty sinkerProperty(){
        return sinker;
    }
    public StringProperty swivelProperty(){ return swivel;}
    public IntegerProperty priceProperty(){
        return price;
    }

}


