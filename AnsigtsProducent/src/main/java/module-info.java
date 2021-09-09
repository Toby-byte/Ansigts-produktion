module com.example.ansigtsproducent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ansigtsproducent to javafx.fxml;
    exports com.example.ansigtsproducent;
}