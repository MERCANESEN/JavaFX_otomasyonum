package application;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mySQL.database.Veritabanı;

import java.sql.*;


public class Sample3Controller {
public Sample3Controller() {
		
		baglanti=Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_giris;

    @FXML
    private Button btn_kayitol;

    @FXML
    private Label label_sonuc;


    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_eposta;

    @FXML
    private TextField txt_sifre;

    @FXML
    private TextField txt_soyad;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
  


    @FXML
    void button_kayitol(ActionEvent event) {
    	  sql="INSERT INTO login(ad,soyad,eposta,sifre) VALUES (?,?,?,?)";
     	  
     	   try {
     		   
     		sorguIfadesi=baglanti.prepareStatement(sql);
  			sorguIfadesi.setString(1, txt_ad.getText().trim());
  			sorguIfadesi.setString(2, txt_soyad.getText().trim());
  			sorguIfadesi.setString(3, txt_eposta.getText().trim());
  			sorguIfadesi.setString(4, Veritabanı.MD5Sifrele(txt_sifre.getText().trim()) );
  			sorguIfadesi.executeUpdate();
  			
  			label_sonuc.setText("Kullanıcı Eklendi...");
  			
     		
     	   } catch(Exception e) {
     		   
     			label_sonuc.setText(e.getMessage().toString());
     			
     			
     		}
     	

    }

    @FXML
    void text_ad(ActionEvent event) {

    }

    @FXML
    void text_eposta(ActionEvent event) {

    }

    @FXML
    void text_sifre(ActionEvent event) {

    }

    @FXML
    void text_soyad(ActionEvent event) {

    }
    
    
    @FXML
    void initialize() {
    	
           }
    

}


  