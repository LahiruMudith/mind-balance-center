package org.example.mindbalancecenter.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.PatientBO;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientPageController implements Initializable {
    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PATIENT);
    @FXML
    private ImageView btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private ImageView btnSetting2;

    @FXML
    private ImageView btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBirthYear;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colRegistrationDate;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton raddioBtnFemale;

    @FXML
    private RadioButton radioBtnMale;

    @FXML
    private TableView<?> tblPatient;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBirthYear;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void save(){ }
}
