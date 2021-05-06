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
public class AdminViewStdntController implements Initializable {

    @FXML
    private AnchorPane fx4apane1;
    @FXML
    private TableView<AdminViewStdntModel> fx4viewstdnt;
    @FXML
    private TableColumn<AdminViewStdntModel, String> fx4name;
    @FXML
    private TableColumn<AdminViewStdntModel, Integer> fx4id;
    @FXML
    private TableColumn<AdminViewStdntModel, Integer> fx4batch;
    @FXML
    private TableColumn<AdminViewStdntModel, String> fx4dept;
    @FXML
    private TableColumn<AdminViewStdntModel, String> fx4pswrd;
    @FXML
    private Button fx4backbtn;
    @FXML
    private Button fx4dltbtn;

    /**
     * Initializes the controller class.
     */
    DatabaseControl obj4viewstdnt = new DatabaseControl();

    void refreshstdttable() {

        fx4name.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, String>("name"));
        fx4id.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, Integer>("id"));
        fx4batch.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, Integer>("batch"));
        fx4dept.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, String>("dept"));
        fx4pswrd.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, String>("pswrd"));

        try {
            fx4viewstdnt.setItems(obj4viewstdnt.adminviewstdnttable());
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewStdntController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { //for 1sr time stdnt table loading

        fx4name.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, String>("name"));
        fx4id.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, Integer>("id"));
        fx4batch.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, Integer>("batch"));
        fx4dept.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, String>("dept"));
        fx4pswrd.setCellValueFactory(new PropertyValueFactory<AdminViewStdntModel, String>("pswrd"));

        try {
            fx4viewstdnt.setItems(obj4viewstdnt.adminviewstdnttable());
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewStdntController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        refreshstdttable();
    }

    @FXML
    private void fx4backbtn(ActionEvent event) throws IOException {
        Parent fx4 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        fx4apane1.getChildren().setAll(fx4);
    }

    @FXML
    private void fx4dltbtn(ActionEvent event) {

        AdminViewStdntModel obj4dltstdnt1 = fx4viewstdnt.getSelectionModel().getSelectedItem();
        int sn = obj4dltstdnt1.getSn();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Successful");
        alert.setContentText("You have successfully removed " + obj4dltstdnt1.getName());
        alert.show();

        DatabaseControl obj4dltstdnt2 = new DatabaseControl();
        obj4dltstdnt2.admindeleteStdnt(sn);

        refreshstdttable();//to reload the table after deletion
    }

}
