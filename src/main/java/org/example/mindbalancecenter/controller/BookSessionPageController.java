package org.example.mindbalancecenter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class BookSessionPageController {
    @FXML
    private Button btnBookSession;

    @FXML
    private ImageView btnSetting2;

    @FXML
    private ComboBox<String> cmbPatientId;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDeleteBtns;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colPaymentSatus;

    @FXML
    private DatePicker datepicker;

    @FXML
    private CheckBox paymentStatus;

    @FXML
    private TableView<?> tblPatient;

    @FXML
    private TextField txtDayAmount;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtExperienceYear;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPatientName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtProgramName;

    @FXML
    private TextField txtRemainingAMount;

    @FXML
    private TextField txtRemainingDay;

    @FXML
    private TextField txtSpecialization;

    @FXML
    private TextField txtTherapystName;

    @FXML
    private TextField txtTotal;
}
