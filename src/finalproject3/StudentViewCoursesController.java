/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject3;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ERIN
 */
public class StudentViewCoursesController implements Initializable {

    @FXML
    private TableView<StudentViewCoursesModel> fx9stdntvwcrs;
    @FXML
    private AnchorPane fx9apane1;
    @FXML
    private TableColumn<StudentViewCoursesModel, Integer> fx9sn;
    @FXML
    private TableColumn<StudentViewCoursesModel, String> fx9title;
    @FXML
    private TableColumn<StudentViewCoursesModel, String> fx9code;
    @FXML
    private TableColumn<StudentViewCoursesModel, Integer> fx9batch;
    @FXML
    private TableColumn<StudentViewCoursesModel, String> fx9sec;
    @FXML
    private Button fx9backbtn;
    @FXML
    private Button fx9dropbtn;
@FXML
    private Button YCVFT;
    /**
     * Initializes the controller class.
     */
    DatabaseControl obj9stdntvwcrs = new DatabaseControl();

    void stdntrefreshcrstable() {
        fx9sn.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, Integer>("sn"));
        fx9title.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, String>("title"));
        fx9code.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, String>("code"));
        fx9batch.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, Integer>("batch"));
        fx9sec.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, String>("sec"));

        try {
            fx9stdntvwcrs.setItems(obj9stdntvwcrs.stdntvwcrstable(FXMLDocumentController.studentid));
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewCoursesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fx9sn.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, Integer>("sn"));
        fx9title.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, String>("title"));
        fx9code.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, String>("code"));
        fx9batch.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, Integer>("batch"));
        fx9sec.setCellValueFactory(new PropertyValueFactory<StudentViewCoursesModel, String>("sec"));

        try {
            fx9stdntvwcrs.setItems(obj9stdntvwcrs.stdntvwcrstable(FXMLDocumentController.studentid));
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewCoursesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void fx9back(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("StudentEnrollCourse.fxml"));
        fx9apane1.getChildren().setAll(root1);
    }

    @FXML
    private void fx9drop(ActionEvent event) {
        StudentViewCoursesModel obj9dltcourse1 = fx9stdntvwcrs.getSelectionModel().getSelectedItem();
        int sn = obj9dltcourse1.getSn();
        DatabaseControl obj9dltcourse2 = new DatabaseControl();
        obj9dltcourse2.stdntdltCourse(sn);
        stdntrefreshcrstable();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Successful");
        alert.setContentText("You have successfully dropped " + obj9dltcourse1.getTitle());
        alert.show();
    }

}
