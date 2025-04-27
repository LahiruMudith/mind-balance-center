package org.example.mindbalancecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.UserBO;
import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dto.UserDto;
import org.example.mindbalancecenter.entitiy.User;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IoginPageViewController implements Initializable {
    UserBO userBO = (UserBO) BOFactory.boFactory.getInstance().getBO(BOFactory.BOType.USER);
    String role = null;
    String userName = null;
    String userPassword = null;
    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    @FXML
    void btnLogin(ActionEvent event) {
        boolean isValidLogin = false;

        UserDto userDto;
        try {
            userDto = userBO.checkUser(username.getText());
            if (username.getText().equals(userDto.getUserName()) && password.getText().equals(userDto.getPassword())) {
                isValidLogin = true;
                userName = userDto.getUserName();
                userPassword = userDto.getPassword();
                role = userDto.getRole();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (isValidLogin){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/home-page-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage1 = new Stage();
                stage1.setScene(scene);
                stage1.initStyle(StageStyle.TRANSPARENT);
                stage1.setResizable(true);
                stage1.centerOnScreen();

                HomePageController homePageController = fxmlLoader.getController();
                homePageController.disableBtns(role);

                Stage window = (Stage) btnLogin.getScene().getWindow();
                window.close();
                stage1.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "Invalid username or password").show();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
