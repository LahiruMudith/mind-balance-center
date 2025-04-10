package org.example.mindbalancecenter.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProgramController {
    @FXML
    private ImageView btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private ImageView btnSetting2;

    @FXML
    private ImageView btnUpdate;

    @FXML
    private ComboBox<?> cmbTherapist;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTherapistName;

    @FXML
    private TableView<?> tblProgram;

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

    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void tblTherapyProgram(MouseEvent event) {

    }

    @FXML
    void therapist(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
}
