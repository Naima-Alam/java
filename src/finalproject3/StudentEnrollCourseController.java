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
public class StudentEnrollCourseController implements Initializable {

    @FXML
    private AnchorPane fx8apane1;
    @FXML
    private TableView<StudentEnrollCourseModel> fx8courseenroll;
    @FXML
    private TableColumn<StudentEnrollCourseModel, Integer> fx8sn;
    @FXML
    private TableColumn<StudentEnrollCourseModel, String> fx8title;
    @FXML
    private TableColumn<StudentEnrollCourseModel, String> fx8code;
    @FXML
    private TableColumn<StudentEnrollCourseModel, String> fx8sec;
    @FXML
    private TableColumn<StudentEnrollCourseModel, Integer> fx8credit;
    @FXML
    private TableColumn<StudentEnrollCourseModel, Integer> fx8batch;
    @FXML
    private TableColumn<StudentEnrollCourseModel, Integer> fx8seat;
    @FXML
    private Button fx8add;
    @FXML
    private Button fx8viewcourses;
    @FXML
    private Button fx8logut;

    /**
     * Initializes the controller class.
     */
    DatabaseControl obj8stdntenroll = new DatabaseControl();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fx8sn.setCellValueFactory(new PropertyValueFactory<StudentEnrollCourseModel, Integer>("sn"));
        fx8title.setCellValueFactory(new PropertyValueFactory<StudentEnrollCourseModel, String>("title"));
        fx8code.setCellValueFactory(new PropertyValueFactory<StudentEnrollCourseModel, String>("code"));
        fx8sec.setCellValueFactory(new PropertyValueFactory<StudentEnrollCourseModel, String>("sec"));
        fx8batch.setCellValueFactory(new PropertyValueFactory<StudentEnrollCourseModel, Integer>("batch"));
        fx8credit.setCellValueFactory(new PropertyValueFactory<StudentEnrollCourseModel, Integer>("credit"));
        fx8seat.setCellValueFactory(new PropertyValueFactory<StudentEnrollCourseModel, Integer>("seat"));
        try {
            fx8courseenroll.setItems(obj8stdntenroll.stdntenrolltable(FXMLDocumentController.studentbatch));
        } catch (SQLException ex) {
            Logger.getLogger(StudentEnrollCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void fx8add(ActionEvent event) {
        StudentEnrollCourseModel obj8addcourse = fx8courseenroll.getSelectionModel().getSelectedItem();
        DatabaseControl obj8stdntaddcourse = new DatabaseControl();

        if (obj8stdntaddcourse.seatcount(obj8addcourse.getCode(), obj8addcourse.getSec()) >= 0 && obj8stdntaddcourse.seatcount(obj8addcourse.getCode(), obj8addcourse.getSec()) < 3) {

            obj8stdntaddcourse.stdntaddCourse(obj8addcourse.getSn(), obj8addcourse.getTitle(), obj8addcourse.getCode(), obj8addcourse.getBatch(), obj8addcourse.getCredit(), obj8addcourse.getSec(), obj8addcourse.getSeat(), FXMLDocumentController.studentid);

            Alert al = new Alert(Alert.AlertType.CONFIRMATION);
            al.setTitle("Successful");
            al.setContentText("You have successfully been enrolled in " + obj8addcourse.getTitle());
            al.show();
        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Failed");
            al.setContentText("This Section is filled up! " + obj8addcourse.getTitle());
            al.show();
        }

    }

    @FXML
    private void fx8viewcourses(ActionEvent event) throws IOException {
        Parent root5 = FXMLLoader.load(getClass().getResource("StudentViewCourses.fxml"));
        fx8apane1.getChildren().setAll(root5);
    }

    @FXML
    private void fx8logout(ActionEvent event) throws IOException {
        Parent root5 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        fx8apane1.getChildren().setAll(root5);
    }

}
