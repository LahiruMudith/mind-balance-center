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
import javafx.scene.layout.AnchorPane;
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.ProgramRegistrationBO;
import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.dto.ProgramRegistrationDto;
import org.example.mindbalancecenter.dto.ProgramRegistrationTblDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.dto.tm.PatientTM;
import org.example.mindbalancecenter.dto.tm.ProgramRegistrationTblTM;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Struct;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ProgramRegistrationPageController implements Initializable{
    ProgramRegistrationBO programRegistrationBO = (ProgramRegistrationBO) BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM_REGISTRATION);
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView btnAdd1;

    @FXML
    private Button btnAddPatient;

    @FXML
    private Button btnRegister;

    @FXML
    private ImageView btnSetting2;

    @FXML
    private ComboBox<String> cmbProgramId;

    @FXML
    private ComboBox<String> cmdPatientd;

    @FXML
    private TableColumn<ProgramRegistrationTblTM, BigDecimal> colCost;

    @FXML
    private TableColumn<ProgramRegistrationTblTM, String> colDuration;

    @FXML
    private TableColumn<ProgramRegistrationTblTM, Date> colLastSessionDate;

    @FXML
    private TableColumn<ProgramRegistrationTblTM, String> colProgramName;

    @FXML
    private TableColumn<ProgramRegistrationTblTM, String> colTherapyistName;

    @FXML
    private TableView<ProgramRegistrationTblTM> tblPatient;

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

    @FXML
    void btnAddNewPatient(MouseEvent event) {

    }

    @FXML
    void cmbPatient(ActionEvent event) {
        String id = cmdPatientd.getValue();
        if (cmdPatientd.getValue() != null) {
            try {
                PatientDto patient = programRegistrationBO.searchPatientById(id);
                txtPatientName.setText(patient.getName());
                txtAge.setText(String.valueOf(patient.getAge()));
                txtPhoneNumber.setText(patient.getPhoneNumber());
                txtGender.setText(patient.getGender());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
       }

        List<ProgramRegistrationTblDto> tblData = programRegistrationBO.getTblData(id);
        ObservableList<ProgramRegistrationTblTM> tblTMS = FXCollections.observableArrayList();
        for (ProgramRegistrationTblDto programTMS : tblData){
            ProgramRegistrationTblTM patientTM = new ProgramRegistrationTblTM(
                    programTMS.getProgramName(),
                    programTMS.getDuration(),
                    programTMS.getCost(),
                    programTMS.getTherapistName(),
                    programTMS.getSessionDate()
            );
            tblTMS.add(patientTM);
        }
        tblPatient.setItems(tblTMS);

    }
    @FXML
    void cmbProgram(ActionEvent event) {
        if (cmbProgramId.getValue() != null) {
            String id = cmbProgramId.getValue();
            try {
                TherapyProgramDto program = programRegistrationBO.searchProgramById(id);
                txtProgramName.setText(program.getName());
                txtCost.setText(program.getCost().stripTrailingZeros().toPlainString());
                txtDuration.setText(program.getDuration());
                txtTherapyistName.setText(program.getTherapistName());
                txtSpecialization.setText(program.getSpetialization());
                txtExperienceYear.setText(program.getExperienceYear());

                BigDecimal advanceAmount = program.getCost().multiply(BigDecimal.valueOf(0.10));
                txtAdvanceAmount.setText(advanceAmount.stripTrailingZeros().toPlainString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnRegister(ActionEvent event) throws Exception {
        Date date = Date.valueOf(LocalDate.now());
        boolean isRegistered = programRegistrationBO.register(
                new ProgramRegistrationDto(
                        txtID.getText(),
                        date,
                        cmdPatientd.getValue(),
                        cmbProgramId.getValue(),
                        Integer.valueOf(txtAdvanceAmount.getText())
                )
        );
        if (isRegistered){
            new Alert(Alert.AlertType.CONFIRMATION, "Program Registration Complete").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Program Registration Fail").show();
        }
    }

    void pageRefesh() {
        try {
            List<PatientDto> patients = programRegistrationBO.getPatients();
            ObservableList<String> patientNames = FXCollections.observableArrayList();
            for (PatientDto therapistDto : patients){
                patientNames.add(therapistDto.getId());
            }
            cmdPatientd.setItems(patientNames);

            List<TherapyProgramDto> programs = programRegistrationBO.getPrograms();
            ObservableList<String> programNames = FXCollections.observableArrayList();
            for (TherapyProgramDto therapistDto : programs){
                programNames.add(therapistDto.getId());
            }
            cmbProgramId.setItems(programNames);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Get new ID
        try {
            String newId = programRegistrationBO.getNewId();
            txtID.setText(newId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colTherapyistName.setCellValueFactory(new PropertyValueFactory<>("therapistName"));
        colLastSessionDate.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));

        pageRefesh();
    }
}
