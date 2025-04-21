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
import org.example.mindbalancecenter.bo.TherapyProgramBO;
import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.dto.tm.TherapyProgramTM;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ProgramController implements Initializable {
    TherapyProgramBO therapyProgramBO = (TherapyProgramBO) BOFactory.getInstance().getBO(BOFactory.BOType.THERAPY_PROGRAM);
    @FXML
    private ImageView btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private ImageView btnSetting2;

    @FXML
    private ImageView btnUpdate;

    @FXML
    private ComboBox<String> cmbTherapist;

    @FXML
    private TableColumn<TherapyProgramTM, BigDecimal> colCost;

    @FXML
    private TableColumn<TherapyProgramTM, String> colDescription;

    @FXML
    private TableColumn<TherapyProgramTM, String> colDuration;

    @FXML
    private TableColumn<TherapyProgramTM, String> colId;

    @FXML
    private TableColumn<TherapyProgramTM, String> colName;

    @FXML
    private TableColumn<TherapyProgramTM, String> colTherapistName;

    @FXML
    private TableView<TherapyProgramTM> tblProgram;

    @FXML
    private TextField txtCost;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtProgramDuration;

    @FXML
    void delete(ActionEvent event) {
        try {
            boolean b = therapyProgramBO.delete(txtID.getText());
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION, "Therapy Program Delete Successfully").show();
                refeshPage();
            }else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Therapy Program").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void save(ActionEvent event) {
        BigDecimal cost = BigDecimal.valueOf(Long.parseLong(txtCost.getText()));
        try {
            boolean b = therapyProgramBO.save(new TherapyProgramDto(
                            txtID.getText(),
                            txtName.getText(),
                            txtProgramDuration.getText(),
                            cost,
                            txtDescription.getText(),
                            cmbTherapist.getValue()
            ));
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION, "Therapy Program Added Successfully").show();
                refeshPage();
            }else {
                new Alert(Alert.AlertType.ERROR, "Failed to Add Therapy Program").show();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void tblTherapyProgram(MouseEvent event) {
        TherapyProgramTM selectedItem = tblProgram.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            txtID.setText(selectedItem.getId());
            txtName.setText(selectedItem.getName());
            txtDescription.setText(selectedItem.getDescription());
            txtProgramDuration.setText(selectedItem.getDuration());
            txtCost.setText(String.valueOf(selectedItem.getCost().intValue()));
            cmbTherapist.setValue(selectedItem.getTherapistName());
            System.out.println(selectedItem.getTherapistName());
        }
    }

    @FXML
    void therapist(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {
        BigDecimal cost = BigDecimal.valueOf(Long.parseLong(txtCost.getText()));
        try {
            boolean b = therapyProgramBO.update(new TherapyProgramDto(
                    txtID.getText(),
                    txtName.getText(),
                    txtProgramDuration.getText(),
                    cost,
                    txtDescription.getText(),
                    cmbTherapist.getValue()
            ));
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION, "Therapy Program Update Successfully").show();
                refeshPage();
            }else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Therapy Program").show();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void refeshPage(){
        try {
            List<TherapyProgramDto> all = therapyProgramBO.getAll();
            ObservableList<TherapyProgramTM> therapyProgramTMS = FXCollections.observableArrayList();
            for (TherapyProgramDto therapyProgramDto : all){
                TherapyProgramTM patientTM = new TherapyProgramTM(
                        therapyProgramDto.getId(),
                        therapyProgramDto.getName(),
                        therapyProgramDto.getDuration(),
                        therapyProgramDto.getCost(),
                        therapyProgramDto.getDescription(),
                        therapyProgramDto.getTherapistName()
                );
                therapyProgramTMS.add(patientTM);
            }
            tblProgram.setItems(therapyProgramTMS);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        addd Therapist to combo box
        try {
            List<TherapistDto> all = therapyProgramBO.getTherapist();
            ObservableList<String> therapistName = FXCollections.observableArrayList();
            for (TherapistDto therapistDto : all){
                therapistName.add(therapistDto.getName());
            }
            cmbTherapist.setItems(therapistName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colTherapistName.setCellValueFactory(new PropertyValueFactory<>("therapistName"));

        refeshPage();
    }
}
