package org.example.mindbalancecenter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class ProgramRegistrationPageController {
    @FXML
    private ImageView btnAdd1;

    @FXML
    private Button btnAddPatient;

    @FXML
    private Button btnRegister;

    @FXML
    private ImageView btnSetting2;

    @FXML
    private ComboBox<?> cmbProgramId;

    @FXML
    private ComboBox<?> cmdPatientd;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colLastSessionDate;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private TableColumn<?, ?> colTherapyistName;

    @FXML
    private TableView<?> tblPatient;

    @FXML
    private TextField txtAdvanceAmount;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtExperienceYear;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtPatientName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtProgramName;

    @FXML
    private TextField txtSpecialization;

    @FXML
    private TextField txtTherapyistName;
}
