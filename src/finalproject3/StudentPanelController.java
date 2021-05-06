/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ERIN
 */
public class StudentPanelController implements Initializable {

    @FXML
    private AnchorPane fx7apane1;
    @FXML
    private Button fx7clickhere;
    @FXML
    private Button fx7logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void fx7clickhere(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("StudentEnrollCourse.fxml"));
        fx7apane1.getChildren().setAll(root1);
    }

    @FXML
    private void fx7logout(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        fx7apane1.getChildren().setAll(root2);
    }

}
