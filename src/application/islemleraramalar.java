package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import mySQL.database.Veritabanı;


public class islemleraramalar {
public islemleraramalar() {
		
		baglanti=Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<islemler> TableView_Aramalar;

    @FXML
    private AnchorPane anchor_giris;

    @FXML
    private Button button_arama;

    @FXML
    private TableColumn<islemler, String> column_aciklama;

    @FXML
    private TableColumn<islemler, String> column_kullaniciadi;

    @FXML
    private TableColumn<islemler, LocalDate> column_tarih;

    @FXML
    private TableColumn<islemler, Double > column_tutar;

    @FXML
    private ComboBox<String> comco_user;

    @FXML
    private DatePicker datebaslangic;

    @FXML
    private DatePicker datebitis;

    @FXML
    private TextField txt_arama;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    
    @FXML
    void button_arama_Click(ActionEvent event) {
    	
    	
    	sql="select * from islemler where islemTarih> '"+datebaslangic.getValue()+"'and islemTarih< '"+datebitis.getValue()+"'";

    	DegerleriGetir(TableView_Aramalar,sql);
    }

    @FXML
    void combo_user_OnAction(ActionEvent event) {

    }
    @FXML
    void txt_arama_KeyPressed(KeyEvent event) { 
    	
    
     if(txt_arama.getText().equals("")) {
    		
    		sql="select * from islemler";
    				
    	}
    	else {
    		sql="select * from islemler where islemAciklama like '%"+txt_arama.getText()+"%' or eposta like '%"+txt_arama.getText()+"%' ";
    		
    	} 
     DegerleriGetir(TableView_Aramalar,sql);
    }  	

    @FXML
    void txt_arama_OnAction(ActionEvent event) {
    	
   
    	

    }
    public void DegerleriGetir(TableView<islemler> tablo, String sql) {
    	if (sql == null) {
           
            sql = "select * from islemler";
        }
        ObservableList<islemler> islemlerliste = FXCollections.observableArrayList();
        try {
            sorguIfadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguIfadesi.executeQuery();

            while (getirilen.next()) {
                islemlerliste.add(new islemler(getirilen.getString("eposta"), getirilen.getString("islemAciklama"),
                        getirilen.getDouble("islemTutar"), getirilen.getDate("islemTarih")));
            }

            column_kullaniciadi.setCellValueFactory(new PropertyValueFactory<>("eposta"));
            column_aciklama.setCellValueFactory(new PropertyValueFactory<>("islemAciklama"));
            column_tutar.setCellValueFactory(new PropertyValueFactory<>("islemTutar"));
            column_tarih.setCellValueFactory(new PropertyValueFactory<>("islemTarih"));

            TableView_Aramalar.setItems(islemlerliste);
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
       
    }


 

    @FXML
    void initialize() {
    	
    	DegerleriGetir(TableView_Aramalar,sql);
    	
    	datebaslangic.setValue(LocalDate.now());
    	datebitis.setValue(LocalDate.now());
    	

    }
   

}
