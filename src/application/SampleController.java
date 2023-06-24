package application;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.PasswordField;
import mySQL.database.Veritabanı;
import java.sql.*;
import javafx.stage.Stage;


public class SampleController {
	
public SampleController() {
		
		baglanti=Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_giris;

    @FXML
    private Button button_giris;

    @FXML
    private Button button_uyeol;

    @FXML
    private Button button_şifrenimiunuttun;
    
    @FXML
    private Button button_yonetici;

    @FXML
    private Label label_eposta;

    @FXML
    private Label label_sifre;

    @FXML
    private Label label_sonuc;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    private PasswordField promp_şifre;


    @FXML
    private TextField text_eposta;


    @FXML
    void button_giris_Click(ActionEvent event) {
    	sql="select * from login where eposta=? and sifre=?";
  	  
  	  
   	   try {
   		   
   			sorguIfadesi=baglanti.prepareStatement(sql);
   			sorguIfadesi.setString(1, text_eposta.getText().trim());
   			sorguIfadesi.setString(2, promp_şifre.getText().trim());
   			
   			
   			ResultSet getirilen=sorguIfadesi.executeQuery();
   			
   			
   			if(!getirilen.next()) {
   				
   				label_sonuc.setText("Eposta veya Şifre Hatalı..");
   			
   				
   			}
   			else {
   				getirilen.getString(1);
   				System.out.println("eposta:" + getirilen.getString("eposta"));
   				System.out.println("sifre:" + getirilen.getString("sifre"));
   				try {
   		  		    Stage stage1=new Stage();
   		  		    AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample2.fxml"));
	   		  		Scene scene = new Scene(pane1);
	   		  		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	   		  		stage1.setScene(scene);
	   		  		stage1.show();
	   		  	} catch(Exception e) {
	   		  		e.printStackTrace();
	   		  	}
   				
   			} 
   		
   	   } catch(Exception e) {
   			label_sonuc.setText(e.getMessage().toString());
   			
   			
   		}
  	}
   	   
    @FXML
    void button_uyeol(ActionEvent event) {
    	
    	 try {
    		    Stage stage1=new Stage();
    		    AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample3.fxml"));
   			Scene scene = new Scene(pane1);
   			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
   			stage1.setScene(scene);
   			stage1.show();
   		} catch(Exception e) {
   			e.printStackTrace();
   		}

     }

    

    @FXML
    void btn_şifrenimiunuttun(ActionEvent event) {

    
    	 try {
 		    Stage stage1=new Stage();
 		    AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample4.fxml"));
			Scene scene = new Scene(pane1);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

  }
    	
    @FXML
    void button_yonetici_Click(ActionEvent event) {
    	 try {
  		    Stage stage1=new Stage();
  		    AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Yoneticigirisi.fxml"));
 			Scene scene = new Scene(pane1);
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 			stage1.setScene(scene);
 			stage1.show();
 		} catch(Exception e) {
 			e.printStackTrace();
 		}

    }
    	

    
    

    @FXML
    void text_eposta(ActionEvent event) {

    }

    @FXML
    void text_sifre(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert anchor_giris != null : "fx:id=\"anchor_giris\" was not injected: check your FXML file 'Sample.fxml'.";
        assert button_giris != null : "fx:id=\"button_giris\" was not injected: check your FXML file 'Sample.fxml'.";
        assert button_uyeol != null : "fx:id=\"button_uyeol\" was not injected: check your FXML file 'Sample.fxml'.";
        assert button_şifrenimiunuttun != null : "fx:id=\"button_şifrenimiunuttun\" was not injected: check your FXML file 'Sample.fxml'.";
        assert label_eposta != null : "fx:id=\"label_eposta\" was not injected: check your FXML file 'Sample.fxml'.";
        assert label_sifre != null : "fx:id=\"label_sifre\" was not injected: check your FXML file 'Sample.fxml'.";
        assert label_sonuc != null : "fx:id=\"label_sonuc\" was not injected: check your FXML file 'Sample.fxml'.";
        assert text_eposta != null : "fx:id=\"text_eposta\" was not injected: check your FXML file 'Sample.fxml'.";
 

    }
  
	

}

