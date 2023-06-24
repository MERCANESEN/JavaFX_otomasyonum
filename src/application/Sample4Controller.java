package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mySQL.database.Veritabanı;

public class Sample4Controller {
public Sample4Controller() {
		
		baglanti=Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_giris;

    @FXML
    private Button button_degistir;

    @FXML
    private Label lbl_mevcut;

    @FXML
    private Label lbl_sifresonuc;
    
    @FXML
    private PasswordField pas_mevcut;

    @FXML
    private PasswordField pas_şifre;

    @FXML
    private PasswordField pas_şifretekrar;
    
    @FXML
    private TextField text_eposta;

   
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_degistir(ActionEvent event) {
    	
    	sql="select count(*) from login where sifre=? and eposta=?";
  	  
 	   try {
 		   
 			sorguIfadesi=baglanti.prepareStatement(sql);
 			sorguIfadesi.setString(1, text_eposta.getText().trim());
 			sorguIfadesi.setString(2, pas_şifre.getText().trim());
 			
	   
 			ResultSet getirilen= sorguIfadesi.executeQuery();
			if(!getirilen.next()) {
   				
				lbl_sifresonuc.setText("Eposta veya Şifre Hatalı..");
   			
   				
   			}
   			else {
			sql="update login set sifre=? where eposta=?";
	    	  
	    	   try {
	    		   
	    			sorguIfadesi=baglanti.prepareStatement(sql);
	    			sorguIfadesi.setString(1,Veritabanı.MD5Sifrele(pas_şifre.getText().trim()) );
	    			sorguIfadesi.setString(2, text_eposta.getText().trim());
	    			
	   	   
					sorguIfadesi.executeUpdate();
					
					lbl_sifresonuc.setText("Şifre Güncellendi...");
					
		   		
		   	   } catch(Exception e) {
		   		   
		   		lbl_sifresonuc.setText(e.getMessage().toString());
		   			
		   			
		   		}	
			
   			}
			
			
		
	   } catch(Exception e) {
		   
		lbl_sifresonuc.setText(e.getMessage().toString());
			
			
		}
    }

    @FXML
    void initialize() {
      
    }

}
