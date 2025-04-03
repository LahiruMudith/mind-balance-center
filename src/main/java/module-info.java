module org.example.mindbalancecenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens org.example.mindbalancecenter.controller to javafx.fxml;
    opens org.example.mindbalancecenter to javafx.fxml;
    exports org.example.mindbalancecenter;
    exports org.example.mindbalancecenter.bo;
    opens org.example.mindbalancecenter.bo to javafx.fxml;
    exports org.example.mindbalancecenter.bo.impl;
    opens org.example.mindbalancecenter.bo.impl to javafx.fxml;
}