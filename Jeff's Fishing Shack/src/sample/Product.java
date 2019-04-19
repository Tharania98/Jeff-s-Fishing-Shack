package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {





        private final StringProperty productName;
        private final StringProperty size;
        private final IntegerProperty unitPrice;


        public Product(String productName, String size, int unitPrice) {

            this.productName = new SimpleStringProperty(productName);
            this.size = new SimpleStringProperty(size);
            this.unitPrice = new SimpleIntegerProperty(unitPrice);

        }



        public StringProperty productNameProperty(){
            return productName;
        }
        public StringProperty sizeProperty(){
            return size;
        }
        public IntegerProperty unitPriceProperty(){
            return unitPrice;
        }

    }


