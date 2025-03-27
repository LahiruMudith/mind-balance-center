module org.example.mindbalancecenter {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.mindbalancecenter.controller to javafx.fxml;
    opens org.example.mindbalancecenter to javafx.fxml;
    exports org.example.mindbalancecenter;
}