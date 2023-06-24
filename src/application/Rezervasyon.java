package application;


import java.net.URL;
import java.sql.ResultSet;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.Pagination;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;




public class Rezervasyon {
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_giris;
    
    @FXML
    private Button btnrezervasyon;


    @FXML
    private ImageView imgResim;

    @FXML
    private Label lblAciklama;

    @FXML
    private Label lblBaslik;

    @FXML
    private Label lblFiyat;

    @FXML
    private Label lblKonum;
    
    @FXML
    private Label label_sonuç;


    @FXML
    private Pagination pgDeniz;

    @FXML
    void getImages(ActionEvent event) {

    }
    ResultSet getirilen=null;
    
    @FXML
    void btnrezervasyon(ActionEvent event )  {
    	try {
    		label_sonuç.setText("Rezervasyon Oluşturuldu....");
    	
    	}
    	
    	catch(Exception e)
{
    		label_sonuç.setText(e.getMessage().toString());
			
    	}
    	
 		}

    @FXML
    void initialize() {
    	pgDeniz.setPageFactory((pageIndex) -> {
    		switch (pageIndex) {
	    		case 0:
	    			lblBaslik.setText("KEMER OTEL");
	    			lblAciklama.setText("Şehir Merkezi 3 km uzaklıkta");
	    			lblKonum.setText("Antalya");
	    			lblFiyat.setText("2500 TL");
	    			imgResim.setImage(new Image("/application/image/indir.png"));
	    			btnrezervasyon.setText("Kemer Otel için rezervasyon oluştur");
	    			
	    			break;
	    		case 1:
	    			lblBaslik.setText("DENİZ APART");
	    			lblAciklama.setText("Merkeze 2.7 km Denize 1 km uzaklıkta");
	    			lblKonum.setText("Antalya/Kaş");
	    			lblFiyat.setText("3000 TL");
	    			btnrezervasyon.setText("Deniz Apart için rezervasyon oluştur");
	    			imgResim.setImage(new Image("/application/image/indir (1).png"));

	        		break;
	    		case 2:
	    			lblBaslik.setText("KUMSAL OTEL");
	    			lblAciklama.setText("Kumsala Yürüyerek 5 dakika");
	    			lblKonum.setText("Kuşadası");
	    			lblFiyat.setText("2170 TL");
	    			btnrezervasyon.setText("Kumsal Otel için rezervasyon oluştur");
	    			imgResim.setImage(new Image("/application/image/indir.png"));
	        		break;
	    		case 3:
	    			lblBaslik.setText("BONCUK APART");
	    			lblAciklama.setText("Şehir Merkezi 3 km uzaklıkta");
	    			lblKonum.setText("Antalya");
	    			lblFiyat.setText("2000 TL");
	    			imgResim.setImage(new Image("/application/image/indir (1).png"));
	    			btnrezervasyon.setText("Boncuk Apart için rezervasyon oluştur");
	        		break;
	    		default:
	    			lblBaslik.setText("TATİLLİK EV");
	    			lblAciklama.setText("Deniz Manzaralı Merkezde");
	    			lblKonum.setText("Muğla/Bodrum");
	    			lblFiyat.setText("7000 TL");
	    			imgResim.setImage(new Image("/application/image/indir (2).png"));
	    			btnrezervasyon.setText("Tatillik Ev için rezervasyon oluştur");
	    			break;
	    	}
    		
            return new Label();
           
        });
    	
    	
    	
    

    }
    

}
