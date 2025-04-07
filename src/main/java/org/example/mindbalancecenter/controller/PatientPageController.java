package org.example.mindbalancecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.PatientBO;
import org.example.mindbalancecenter.dto.PatientDto;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
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
        Text sriLnakaCoutryCode = new Text("+94");
        txtPhoneNumber.setText(sriLnakaCoutryCode.getText());
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) throws SQLException, ClassNotFoundException {
        RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
        Date registrationDate = Date.valueOf(LocalDate.now());
        String gender = selectedRadioButton.getText();

        PatientDto patientDto = new PatientDto(
                txtID.getText(),
                txtName.getText(),
                txtPhoneNumber.getText(),
                txtAddress.getText(),
                gender,
                Year.parse(txtBirthYear.getText()),
                registrationDate
        );

        boolean b = patientBO.savePatient(patientDto);
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION, "Patient Added Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Patient").show();
        }
    }

    @FXML
    void update(ActionEvent event) {

    }
}
