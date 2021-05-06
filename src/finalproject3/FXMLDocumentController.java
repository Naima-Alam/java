/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject3;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author ERIN
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane fx1apane1;

    @FXML
    private Label label;

    @FXML
    private Text fx1txt1;

    @FXML
    private Text fx1txt2;

    @FXML
    private Pane fx1pane;

    @FXML
    private Text fx1txt3;

    @FXML
    private Label fx1lbl1;

    @FXML
    private Label fx1lbl2;

    @FXML
    private TextField fx1tf1;

    @FXML
    private PasswordField fx1pf1;

    @FXML
    private Button fx1btn1;

    @FXML
    private Text fx1txt4;
    
    
    public static long studentid ;
     public static long studentbatch ;

    @FXML
    void handleButtonAction(ActionEvent event) throws SQLException, IOException {
        DatabaseControl objlogin = new DatabaseControl();
        Connection cn=objlogin.dbconnection();
        String name=fx1tf1.getText();
        String pass=fx1pf1.getText();
        String admin="SELECT * FROM login where Name='"+name+"' AND Password='"+pass+"' AND Role=1";
        String stdnt="SELECT * FROM login where Name='"+name+"' AND Password='"+pass+"' AND Role=2";
         ResultSet rsadmin=cn.createStatement().executeQuery(admin);
         ResultSet rsstudent=cn.createStatement().executeQuery(stdnt);
                   

         if(rsadmin.next())
         {
              Parent root1 = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
              fx1apane1.getChildren().setAll(root1);
         }
         else if(rsstudent.next())
         {
            long n = Integer.parseInt(fx1tf1.getText());
                   
                   
                  studentid=n;
                  studentbatch=(n/1000000)+2000;
             
          Parent root1 = FXMLLoader.load(getClass().getResource("StudentPanel.fxml"));
           fx1apane1.getChildren().setAll(root1);
         }
         else
         {
            fx1tf1.clear();
            fx1pf1.clear();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Invaild Username or Password !");
            alert.show();
         }
    }
    @FXML
    private void forgotpswrd(MouseEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
           fx1apane1.getChildren().setAll(root1);
    }
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    
}
