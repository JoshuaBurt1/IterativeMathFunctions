module com.example.mathematicalconstants {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mathematicalconstants to javafx.fxml;
    exports com.example.mathematicalconstants;
}