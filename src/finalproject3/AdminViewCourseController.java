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
public class AdminViewCourseController implements Initializable {

    @FXML
    private AnchorPane fx6apane1;
    @FXML
    private TableView<AdminViewCourseModel> fx6viewcourse;
    @FXML
    private Button fx6backbtn;
    @FXML
    private Button fx6dltbtn;
    @FXML
    private TableColumn<AdminViewCourseModel, Integer> fx6sn;
    @FXML
    private TableColumn<AdminViewCourseModel, String> fx6title;
    @FXML
    private TableColumn<AdminViewCourseModel, String> fx6code;
    @FXML
    private TableColumn<AdminViewCourseModel, Integer> fx6batch;
    @FXML
    private TableColumn<AdminViewCourseModel, Integer> fx6credit;
    @FXML
    private TableColumn<AdminViewCourseModel, String> fx6sec;
    @FXML
    private TableColumn<AdminViewCourseModel, Integer> fx6seat;

    /**
     * Initializes the controller class.
     */
    DatabaseControl obj6viewcourse = new DatabaseControl();

    void refreshadmincoursetable() {

        fx6sn.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("sn"));
        fx6title.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, String>("title"));
        fx6code.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, String>("code"));
        fx6batch.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("batch"));
        fx6credit.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("credit"));
        fx6sec.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, String>("sec"));
        fx6seat.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("seat"));

        try {
            fx6viewcourse.setItems(obj6viewcourse.adminviewcoursetable());
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fx6sn.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("sn"));
        fx6title.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, String>("title"));
        fx6code.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, String>("code"));
        fx6batch.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("batch"));
        fx6credit.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("credit"));
        fx6sec.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, String>("sec"));
        fx6seat.setCellValueFactory(new PropertyValueFactory<AdminViewCourseModel, Integer>("seat"));

        try {
            fx6viewcourse.setItems(obj6viewcourse.adminviewcoursetable());
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void fx6back(ActionEvent event) throws IOException {
        Parent fx6 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        fx6apane1.getChildren().setAll(fx6);
    }

    @FXML
    private void fx6dltcourse(ActionEvent event) {

        AdminViewCourseModel obj6dltcourse1 = fx6viewcourse.getSelectionModel().getSelectedItem();
        int sn = obj6dltcourse1.getSn();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Successful");
        alert.setContentText("You have successfully removed" + obj6dltcourse1.getTitle());
        alert.show();

        DatabaseControl obj6dltcourse2 = new DatabaseControl();
        obj6dltcourse2.admindeleteCourse(sn);

        refreshadmincoursetable();//to reload the table after deletion

    }

}
