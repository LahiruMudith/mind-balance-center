package org.example.mindbalancecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.TherapistBO;
import org.example.mindbalancecenter.dto.tm.TherapistTM;

import java.net.URL;
import java.util.ResourceBundle;

public class TherapistPageController implements Initializable {
    TherapistBO therapistBO = (TherapistBO) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPIST);
    @FXML
    private ImageView btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private ImageView btnSetting2;

    @FXML
    private ImageView btnUpdate;

    @FXML
    private ComboBox<?> cmbAssignedProgram;

    @FXML
    private TableColumn<?, ?> colExperienceYEar;

    @FXML
    private TableColumn<?, ?> colAssignedProgram;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colSpetialization;

    @FXML
    private TableView<?> tblPatient;

    @FXML
    private TextField txtExperienceYear;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtSpecialization;

    @FXML
    void btnAdd(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String experienceYear = txtExperienceYear.getText();
        String assignedProgram = (String) cmbAssignedProgram.getValue();
        String specialization = txtSpecialization.getText();

        TherapistTM therapistTM = new TherapistTM(
                id,
                name,
                phoneNumber,
                experienceYear,
                assignedProgram,
                specialization
        );
        therapistBO.save(therapistTM);
    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @FXML
    void tblTherapist(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colExperienceYEar.setCellValueFactory(new PropertyValueFactory<>("experienceYear"));
        colAssignedProgram.setCellValueFactory(new PropertyValueFactory<>("assignedProgram"));
        colSpetialization.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        pageRefresh();
    }

    void pageRefresh(){

    }
}
