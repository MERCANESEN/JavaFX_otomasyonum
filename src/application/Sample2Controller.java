package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.Scene;

public class Sample2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_giris;

    @FXML
    private Button button_ara;

    @FXML
    private ComboBox<String> combo_oda;

    @FXML
    private DatePicker date_cikis;

    @FXML
    private DatePicker date_giris;

    @FXML
    void btn_ara(ActionEvent event) {
    	 try {
  		    Stage stage1=new Stage();
  		    AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Rezervasyon.fxml"));
 			Scene scene = new Scene(pane1);
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 			stage1.setScene(scene);
 			stage1.show();
 		} catch(Exception e) {
 			e.printStackTrace();
 		}

    }

    @FXML
    void cmb_oda(ActionEvent event) {

    }
    ObservableList<String> liste;
    @FXML
    void initialize() {
    	   liste=FXCollections.observableArrayList("Tek Kişilik","İki Kişilik","Üç Kişilik","Aile","2+Çocuk","2+Evcil Hayvan");
           combo_oda.getItems().addAll(liste);
           
           
         
    }
   
}
