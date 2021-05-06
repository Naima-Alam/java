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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ERIN
 */
public class ForgotPasswordController implements Initializable {

    @FXML
    private AnchorPane forgotpasswordapane1;
    @FXML
    private Text forgotpasswordlbl1;
    @FXML
    private Button forgotpasswordbackbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void forgotpasswordback(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
           forgotpasswordapane1.getChildren().setAll(root1);
    }
    
}
