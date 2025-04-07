package org.example.mindbalancecenter.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    private ImageView btnClose;

    @FXML
    private ImageView btnMinimize;

    @FXML
    private Button btnPatient;

    @FXML
    private Button btnProgramRegistration;

    @FXML
    private ImageView btnSetting;

    @FXML
    private ImageView btnSignOut;

    @FXML
    private Button btnTherapist;

    @FXML
    private Button btnTherapyProgram;

    @FXML
    private Button btnTherapySession;

    @FXML
    private Text txtDate;

    @FXML
    private Text txtRole;

    @FXML
    private Text txtTime;

    @FXML
    private Pane windowPane;
    @FXML
    void btnClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnLogout(ActionEvent event) {
        navigation("view/login-page-view.fxml");
    }

    @FXML
    void btnMinimize(ActionEvent event) {
        Stage stage = (Stage) btnMinimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void btnSection(ActionEvent event) {

    }

    @FXML
    void patientSection(ActionEvent event) {
        navigation("/view/patient-page-view.fxml");
    }

    @FXML
    void programRegistration(ActionEvent event) {
        navigation("/view/program-registration-page-view.fxml");
    }

    @FXML
    void therapistSection(ActionEvent event) {
        navigation("/view/therapist-page-view.fxml");
    }

    @FXML
    void therapyProgramSection(ActionEvent event) {
        navigation("/view/program-page-view.fxml");
    }

    @FXML
    void therapySessionSection(ActionEvent event) {
        navigation("/view/book-session-page-view.fxml");
    }

    public void navigation(String path){
        try {
            windowPane.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(path));
            load.prefWidthProperty().bind(windowPane.widthProperty());
            load.prefHeightProperty().bind(windowPane.heightProperty());
            windowPane.getChildren().add(load);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread time_and_date_Tread = new Thread(() -> {
//            --------Set Time--------
            Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
                    txtTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
            ),
                    new KeyFrame(Duration.seconds(1))
            );
            clock.setCycleCount(Animation.INDEFINITE);
            clock.play();

//            --------Set Date--------
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(new Date());
            txtDate.setText(date);
        });
        time_and_date_Tread.start();
    }
}
