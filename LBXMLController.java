/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Abdur Rahman
 */
public class LBXMLController implements Initializable {
    //Database Controll
    static PreparedStatement ps = null;
    static Connection conn = null;
    public static void Connector() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:librarymanagement.sqlite");
    }
    //student optoin all design controll start from
    
        
    boolean login = false;
    int p;
    int q;
    
    @FXML
    private PasswordField st_pass,st_cpass;
    
    @FXML
    private TextField st_uname;

    @FXML
    private JFXButton btn_regst;
     @FXML
    void st_registration(ActionEvent event) throws SQLException {
        if(st_pass.getText().equals(st_cpass.getText())){
            ps = conn.prepareStatement("INSERT INTO students VALUES(?,?)");
            ps.setString(1, st_uname.getText());
            ps.setString(2, st_pass.getText());
            ps.executeUpdate();
            ps.close();
        }
    }
    
    @FXML
    private JFXButton studentButton;

    @FXML
    private AnchorPane studentNavigation;

    @FXML
    private JFXButton createAccountButton;

    @FXML
    private JFXButton loginButton;

    @FXML
    private AnchorPane createAccountNavigation;
    
    @FXML
    private AnchorPane loginNavigation;
    
    @FXML
    private JFXButton loginbutton2;
    
    @FXML
    private Label logoutLavel;
    
    @FXML
    private AnchorPane plate;
    
    @FXML
    private AnchorPane bookSearchpane;
    
    @FXML
    void createAccountButtonAction(ActionEvent event) {
        createAccountNavigation.setVisible(true);
        createAccountNavigation.toFront();
        loginNavigation.setVisible(false);
        p=2;
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        loginNavigation.setVisible(true);
        loginNavigation.toFront();
        createAccountNavigation.setVisible(false);
        p=2;
    }

    @FXML
    void studentButtonAction(ActionEvent event) {
       if(!login){
           studentNavigation.setVisible(true);
           studentNavigation.toFront();
           login=true;
           q=1;
          
       }
    }
    
    @FXML
    void loginButton2Action(ActionEvent event) {
        plate.setVisible(true);
        loginNavigation.setVisible(false);
        createAccountNavigation.setVisible(false);
        studentNavigation.setVisible(false);
        login = true;
    }
    @FXML
    void logoutAction(MouseEvent event) {
        login = false;
        plate.setVisible(false);
        selmover.setVisible(true);
        selmover.setLayoutX(30.0);
        bookSearchpane.setVisible(true);
        yourlibinfo.setVisible(false);
        finelab.setVisible(false);
    }
    
    @FXML
    private Pane selmover;
    
    @FXML
    private Label lab1;

    @FXML
    private Label lab2;

    @FXML
    private Label lab3;
    
    @FXML
    private AnchorPane yourlibinfo;

    @FXML
    private AnchorPane finelab;
    
    @FXML
    private Label stdxlab1;
        
    @FXML
    private Label stdxlab2;
            
    @FXML
    private Label stdxlab3;
               
    
    @FXML
    void act1(MouseEvent event) {
        if(event.getSource() == lab1){
        selmover.setVisible(true);
        selmover.setLayoutX(30.0);
        bookSearchpane.setVisible(true);
        yourlibinfo.setVisible(false);
        finelab.setVisible(false);
        
        }
        else if(event.getSource() == lab2){
        selmover.setVisible(true);
        selmover.setLayoutX(154.0);
        yourlibinfo.setVisible(true);
        bookSearchpane.setVisible(false);
         finelab.setVisible(false);
        }
        else if(event.getSource() == lab3){
        selmover.setVisible(true);
        selmover.setLayoutX(270.0);
        finelab.setVisible(true);
        yourlibinfo.setVisible(false);
        bookSearchpane.setVisible(false);
        }
        else if(event.getSource() == stdxlab1){
            studentNavigation.setVisible(false);
            if(p!=2){
             login=false;   
            }
            q=0;
        }
        else if(event.getSource() == stdxlab2){
            createAccountNavigation.setVisible(false);
            if(q!=1){
             login=false;   
            }
            p=0;
            
        }
        else if(event.getSource() == stdxlab3){
            loginNavigation.setVisible(false);
            if(q!=1){
             login=false;   
            }
            p=0;
            
        }

    }
    

    // student design control end................end
    
    
    // librarian design control start from..........
    
    @FXML
    private Label librarianNavigationExit;
        
    @FXML
    private AnchorPane librarianafterloginancorepane;
        
     @FXML
    void act2(MouseEvent event) {
        
        if(event.getSource()==librarianNavigationExit){
            librarianNavigation.setVisible(false);
            login=false;
        }
        

    }
    
    @FXML
    private AnchorPane librarianNavigation;
    
    
    @FXML
    void librarianButtonAction(ActionEvent event) {
       if(!login){
         librarianNavigation.setVisible(true);
         login=true;
       }
    }
    
    
    @FXML
    void librarianLoginAction(ActionEvent event) {
        librarianafterloginancorepane.setVisible(true);
         librarianNavigation.setVisible(false);
        
    }
    
    @FXML
    void librarianLogoutButtonAction(ActionEvent event) {
    librarianafterloginancorepane.setVisible(false);
    studentinfopane.setVisible(false);
    borrowbookpane.setVisible(false);
    submissionbookpane.setVisible(false);
    settingpane.setVisible(false);
    login=false;
    }
    
        @FXML
    private AnchorPane studentinfopane;

    @FXML
    private AnchorPane borrowbookpane;

    @FXML
    private AnchorPane submissionbookpane;

    @FXML
    private AnchorPane settingpane;
    
    @FXML
    void studentinfoButtonAction(ActionEvent event) {
        studentinfopane.setVisible(true);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(false);
    }
    @FXML
    void borrowbookButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(true);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(false);
    }

    @FXML
    void submissionbookButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(true);
        settingpane.setVisible(false);
    }
    
    
    @FXML
    void settingButtonAction(ActionEvent event) {
        studentinfopane.setVisible(false);
        borrowbookpane.setVisible(false);
        submissionbookpane.setVisible(false);
        settingpane.setVisible(true);
    }
    
      // librarian design control ..........end 
    
    
    // Accountant design control start from..........
  
    @FXML
    private JFXButton log;
    
    @FXML
    private Label accountantNavigationExit1;
    
        @FXML
    void accountantNavigationExit(MouseEvent event) {
        if(event.getSource()==accountantNavigationExit1){
          accountantNavigation.setVisible(false);
             login=false;  
        }

    }
    @FXML
    private AnchorPane accountantNavigation;
    
    @FXML
    void accountantButtonAction(ActionEvent event) {
        
        if(!login){
             accountantNavigation.setVisible(true);
             login=true;
        }

    }
    
    @FXML
    private AnchorPane accountantafterloginpane;
    
    
    @FXML
    void accountantLoginButtonAction(ActionEvent event) {
       accountantNavigation.setVisible(false); 
     accountantafterloginpane.setVisible(true);
    }
    
    @FXML
    void accountantSignoutButtonAction(ActionEvent event) {
     accountantafterloginpane.setVisible(false);
     login=false;
    }
    
    
    // Accountant design control ..........end 
    
    
    // Authority design control start from..........
    
    
    @FXML
    private AnchorPane authorityNavigation;
    
    @FXML
    void authorityButtonAction(ActionEvent event) {
        if(!login){
         authorityNavigation.setVisible(true);
         login=true;
        }
        
       }
    
    @FXML
    void authorityLogoutButtonAction(ActionEvent event) {
    authorityNavigation.setVisible(false);
    login=false;
    }
    
    
    @FXML
    private Pane librarianSettingPane;

    @FXML
    private Pane studentSettingPane;


    @FXML
    private Pane accountantSettingPane;
    
    
    @FXML
    void authorityStudentButton(ActionEvent event) {
        librarianSettingPane.setVisible(false);
        studentSettingPane.setVisible(true);
        accountantSettingPane.setVisible(false);

    }

    @FXML
    void authoritylibrarianButton(ActionEvent event) {
        librarianSettingPane.setVisible(true);
        studentSettingPane.setVisible(false);
        accountantSettingPane.setVisible(false);

    }
    @FXML
    void authorityAccountanttButton(ActionEvent event) {
        librarianSettingPane.setVisible(false);
        studentSettingPane.setVisible(false);
        accountantSettingPane.setVisible(true);

    }
    
    
    
      // Authority design control ..........end 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connector();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LBXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LBXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
