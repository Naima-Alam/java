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
public class AdminPanelController implements Initializable {

    @FXML
    private AnchorPane fx2apane1;
    @FXML
    private Button fx2vws;
    @FXML
    private Button fx2adds;
    @FXML
    private Button fx2addc;
    @FXML
    private Button fx2vwc;
    @FXML
    private Button fx2logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    
    
    @FXML
    private void fx2addnewstdnt(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("AdminAddStdnt.fxml"));
             fx2apane1.getChildren().setAll(root2);
    }

    @FXML
    private void fx2addnewcourse(ActionEvent event) throws IOException {
         Parent root3 = FXMLLoader.load(getClass().getResource("AdminAddCourse.fxml"));
             fx2apane1.getChildren().setAll(root3);
    }
    @FXML
    private void fx2viewstdnt(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(getClass().getResource("AdminViewStdnt.fxml"));
             fx2apane1.getChildren().setAll(root4);
    }
    @FXML
    private void fx2viewcourse(ActionEvent event) throws IOException {
        
        Parent root5 = FXMLLoader.load(getClass().getResource("AdminViewCourse.fxml"));
             fx2apane1.getChildren().setAll(root5);
    }

    @FXML
    private void fx2adminlogout(ActionEvent event) throws IOException {
        Parent root6 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
             fx2apane1.getChildren().setAll(root6);
    }
    
}
