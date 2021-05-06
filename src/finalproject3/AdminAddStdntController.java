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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ERIN
 */
public class AdminAddStdntController implements Initializable {

    @FXML
    private AnchorPane fx3apane1;
    @FXML
    private Text fx3txt1;
    @FXML
    private Text fx3txt2;
    @FXML
    private TextField fx3id;
    @FXML
    private TextField fx3name;
    @FXML
    private TextField fx3sec;
    @FXML
    private TextField fx3batch;
    @FXML
    private TextField fx3dept;
    @FXML
    private TextField fx3pswrd;
    @FXML
    private Button fx3backbtn;
    @FXML
    private Button fx3addstdntbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void fx3back(ActionEvent event) throws IOException {
        Parent root7 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        fx3apane1.getChildren().setAll(root7);
    }

    @FXML
    private void fx3addstdntbtn(ActionEvent event) {

        DatabaseControl obj3addstdnt = new DatabaseControl();

        String name = fx3name.getText();
        int id = Integer.parseInt(fx3id.getText());
        int batch = Integer.parseInt(fx3batch.getText());
        String dept = fx3dept.getText();
        String pswrd = fx3pswrd.getText();
        try {
            obj3addstdnt.admininsertStdnt(name, id, batch, dept, pswrd);
            fx3id.clear();
            fx3name.clear();
            fx3batch.clear();
            fx3dept.clear();

            fx3pswrd.clear();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Successful");
            alert.setContentText("You have successfully added " + name);
            alert.show();
            obj3addstdnt.adduserbyadmin(id, pswrd);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
