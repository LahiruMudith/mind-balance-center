package org.example.mindbalancecenter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.PatientBO;
import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.dto.tm.PatientTM;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
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
    private TableColumn<PatientTM, String> colAddress;

    @FXML
    private TableColumn<PatientTM, Date> colBirthYear;

    @FXML
    private TableColumn<PatientTM, String> colGender;

    @FXML
    private TableColumn<PatientTM, String> colId;

    @FXML
    private TableColumn<PatientTM, String> colName;

    @FXML
    private TableColumn<PatientTM, String> colPhoneNumber;

    @FXML
    private TableColumn<PatientTM, Date> colRegistrationDate;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton raddioBtnFemale;

    @FXML
    private RadioButton radioBtnMale;

    @FXML
    private TableView<PatientTM> tblPatient;

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
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirthYear.setCellValueFactory(new PropertyValueFactory<>("yearOfBirth"));
        colRegistrationDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));

        Text sriLnakaCoutryCode = new Text("+94");
        txtPhoneNumber.setText(sriLnakaCoutryCode.getText());

        refeshPage();
    }

    void refeshPage(){
        clearFields();
//        load patient data to table
        try {
            List<PatientDto> allPatient = patientBO.getAllPatient();
            ObservableList<PatientTM> patientTMS = FXCollections.observableArrayList();
            for (PatientDto patientDto : allPatient){
                PatientTM patientTM = new PatientTM(
                        patientDto.getId(),
                        patientDto.getName(),
                        patientDto.getPhoneNumber(),
                        patientDto.getAddress(),
                        patientDto.getGender(),
                        patientDto.getYearOfBirth(),
                        patientDto.getRegistrationDate()
                );
                patientTMS.add(patientTM);
            }
            tblPatient.setItems(patientTMS);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String newId = patientBO.getNewId();
            txtID.setText(newId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void clearFields(){
        txtID.clear();
        txtName.clear();
        txtPhoneNumber.clear();
        txtAddress.clear();
        txtBirthYear.clear();
        gender.selectToggle(null);

    }

    @FXML
    void delete(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean b = patientBO.deletePatient(txtID.getText());
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION, "Patient Delete Successfully").show();
            refeshPage();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to Delete Patient").show();
        }
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
            refeshPage();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Patient").show();
        }
    }

    @FXML
    void update(ActionEvent event) throws SQLException, ClassNotFoundException {
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

        boolean b = patientBO.updatePatient(patientDto);
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION, "Patient Updated Successfully").show();
            refeshPage();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to Update Patient").show();
        }
    }


    @FXML
    void tblPatient(MouseEvent event) {
        PatientTM selectedItem = tblPatient.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            txtID.setText(selectedItem.getId());
            txtName.setText(selectedItem.getName());
            txtPhoneNumber.setText(selectedItem.getPhoneNumber());
            txtAddress.setText(selectedItem.getAddress());
            txtBirthYear.setText(String.valueOf(selectedItem.getYearOfBirth()));
            if (selectedItem.getGender().equals("Male")){
                radioBtnMale.setSelected(true);
            }else if (selectedItem.getGender().equals("Female")) {
                raddioBtnFemale.setSelected(true);
            }
        }
    }
}
