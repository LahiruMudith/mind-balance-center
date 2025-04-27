package org.example.mindbalancecenter.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.mindbalancecenter.bo.BOFactory;
import org.example.mindbalancecenter.bo.ProgramNamesPopUpBO;
import org.example.mindbalancecenter.dto.TherapyProgramDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProgramNamesPopUpController {
    ProgramNamesPopUpBO programNamesPopUpBO = (ProgramNamesPopUpBO) BOFactory.getInstance().getBO(BOFactory.BOType.PROGRAM_POPUP_MENU);
    @FXML
    private ImageView btnClose;

    @FXML
    private ComboBox<String> cmbProgramNames;

    @FXML
    void cmbProgramName(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/book-session-page-view.fxml"));
        Parent popupRoot = fxmlLoader.load();
        BookSessionPageController bookSessionPageController = fxmlLoader.getController();
        bookSessionPageController.setProgramName(cmbProgramNames.getValue());

        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    @FXML
    void btnClose(MouseEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void loadProgramsForPatient(String selectedPatientName) {
        try {
            List<TherapyProgramDto> programNames = programNamesPopUpBO.getProgramNames(selectedPatientName);
            ObservableList<String> tms = FXCollections.observableArrayList();
            for (TherapyProgramDto programDto : programNames){
                if (programDto != null) {
                    tms.add(programDto.getName());
                }
            }
            cmbProgramNames.setItems(tms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isProgramidSelected() {
        String selectedItem = cmbProgramNames.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            return true;
        } else {
            return false;
        }
    }
}
