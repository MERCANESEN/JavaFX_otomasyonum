package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mySQL.database.Veritabanı;
import javafx.scene.control.PasswordField;
public class Yönetici {
public Yönetici() {
		
		baglanti=Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_giris;

    @FXML
    private Button btngiriş;

    @FXML
    private Label label_eposta;
    
    @FXML
    private Label label_mesaj;


    @FXML
    private Label label_sifre;
    

    @FXML
    private PasswordField promp_şifre;

    @FXML
    private TextField text_eposta;

  
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_giris_Click(ActionEvent event) {
    	sql="select * from yönetici where eposta=? and şifre=?";
    	  
    
    	   try {
    		   
    			sorguIfadesi=baglanti.prepareStatement(sql);
    			sorguIfadesi.setString(1, text_eposta.getText().trim());
    			
    			sorguIfadesi.setString(2, promp_şifre.getText().trim());
    			
    			
    			ResultSet getirilen=sorguIfadesi.executeQuery();
    			
    			
    			if(!getirilen.next()) {
    				
    				label_mesaj.setText("Eposta veya Şifre Hatalı..");
    			
    				
    			}
    			else {
    				getirilen.getString(1);
    				System.out.println("eposta:" + getirilen.getString("eposta"));
    				System.out.println("şifre:" + getirilen.getString("şifre"));
    			
    	
    	 try {
   		    Stage stage1=new Stage();
   		    AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("islemleraramalar.fxml"));
  			Scene scene = new Scene(pane1);
  			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  			stage1.setScene(scene);
  			stage1.show();
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
    			}	
    	   }
    	 catch(Exception e) {
    			label_mesaj.setText(e.getMessage().toString());
    			
    			
    		}

    }

    @FXML
    void text_eposta(ActionEvent event) {

    }

    @FXML
    void promp_şifre(ActionEvent event) {

    }

    @FXML
    void text_sifre(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert anchor_giris != null : "fx:id=\"anchor_giris\" was not injected: check your FXML file 'Yoneticigirisi.fxml'.";
        assert btngiriş != null : "fx:id=\"btngiriş\" was not injected: check your FXML file 'Yoneticigirisi.fxml'.";
        assert label_eposta != null : "fx:id=\"label_eposta\" was not injected: check your FXML file 'Yoneticigirisi.fxml'.";
        assert label_sifre != null : "fx:id=\"label_sifre\" was not injected: check your FXML file 'Yoneticigirisi.fxml'.";
        assert text_eposta != null : "fx:id=\"text_eposta\" was not injected: check your FXML file 'Yoneticigirisi.fxml'.";
   

    }

}
