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
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.TherapistBO;
import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.tm.PatientTM;
import org.example.mindbalancecenter.dto.tm.TherapistTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
    private ComboBox<String> cmbAssignedProgram;

    @FXML
    private TableColumn<TherapistTM, String> colExperienceYEar;

    @FXML
    private TableColumn<TherapistTM, String> colAssignedProgram;

    @FXML
    private TableColumn<TherapistTM, String> colId;

    @FXML
    private TableColumn<TherapistTM, String> colName;

    @FXML
    private TableColumn<TherapistTM, String> colPhoneNumber;

    @FXML
    private TableColumn<TherapistTM, String> colSpetialization;

    @FXML
    private TableView<TherapistTM> tblTherapist;

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
    void btnAdd(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtID.getText();
        String name = txtName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String experienceYear = txtExperienceYear.getText();
        String assignedProgram = cmbAssignedProgram.getValue();
        String specialization = txtSpecialization.getText();

        TherapistTM therapistTM = new TherapistTM(
                id,
                name,
                phoneNumber,
                experienceYear,
                assignedProgram,
                specialization
        );
        boolean b = therapistBO.save(therapistTM);

        if (b){
            new Alert(Alert.AlertType.CONFIRMATION, "Therapist Added Successfully").show();
            pageRefresh();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Therapist").show();
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        String id = txtID.getText();
        boolean b = false;
        try {
            b = therapistBO.delete(id);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION, "Therapist Delete Successfully").show();
                pageRefresh();
            }else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Therapist").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to Delete Therapist").show();
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to Delete Therapist").show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) throws SQLException, ClassNotFoundException {
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
        boolean b = therapistBO.update(therapistTM);

        if (b){
            new Alert(Alert.AlertType.CONFIRMATION, "Therapist Update Successfully").show();
            pageRefresh();
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to Update Therapist").show();
        }
    }

    @FXML
    void tblTherapist(MouseEvent event) {
        TherapistTM selectedItem = tblTherapist.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            txtID.setText(selectedItem.getId());
            txtName.setText(selectedItem.getName());
            txtPhoneNumber.setText(selectedItem.getPhoneNumber());
            txtExperienceYear.setText(selectedItem.getExperienceYear());
            txtSpecialization.setText(selectedItem.getSpecialization());
            cmbAssignedProgram.setValue(selectedItem.getAssignedProgram());
        }
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
        try {
            List<TherapistDto> all = therapistBO.getAll();
            ObservableList<TherapistTM> patientTMS = FXCollections.observableArrayList();
            for (TherapistDto therapistDto : all){
                TherapistTM therapistTM = new TherapistTM(
                        therapistDto.getId(),
                        therapistDto.getName(),
                        therapistDto.getPhoneNumber(),
                        therapistDto.getExperienceYear(),
                        therapistDto.getAssignedProgram(),
                        therapistDto.getSpecialization()
                );
                patientTMS.add(therapistTM);
            }
            tblTherapist.setItems(patientTMS);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
