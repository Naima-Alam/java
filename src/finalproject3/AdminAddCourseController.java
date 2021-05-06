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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ERIN
 */
public class AdminAddCourseController implements Initializable {

    @FXML
    private AnchorPane fx5apane1;
    @FXML
    private Button fx5backbtn;
    @FXML
    private Button fx5addcoursebtn;
    @FXML
    private TextField fx5title;
    @FXML
    private TextField fx5code;
    @FXML
    private TextField fx5batch;
    @FXML
    private TextField fx5credit;
    @FXML
    private TextField fx5sec;
    @FXML
    private TextField fx5seat;

    @FXML

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void fx5back(ActionEvent event) throws IOException {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
            fx5apane1.getChildren().setAll(p);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void fx5addcoursebtn(ActionEvent event) {
        DatabaseControl obj5addcourse = new DatabaseControl();

        String title = fx5title.getText();
        String code = fx5code.getText();
        int batch = Integer.parseInt(fx5batch.getText());
        int credit = Integer.parseInt(fx5credit.getText());
        String sec = fx5sec.getText();
        int seat = Integer.parseInt(fx5seat.getText());

        try {
            obj5addcourse.admininsertCourse(title, code, batch, credit, sec, seat);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Successful");
            alert.setContentText("You have successfully added " + title);
            alert.show();

            fx5title.clear();
            fx5code.clear();
            fx5sec.clear();
            fx5batch.clear();
            fx5credit.clear();
            fx5sec.clear();
            fx5seat.clear();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
