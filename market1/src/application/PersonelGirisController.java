package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.myConnect.Util.VeriTabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class PersonelGirisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane adminGirisPnl;

    @FXML
    private TextField personel_name;

    @FXML
    private TextField personel_sifre;

    
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    
   PersonelGirisController(){
    	
    	baglanti=VeriTabaniUtil.Baglan();
    }
    
 

    @FXML
    void prsnlGiris(ActionEvent event) {
    	sql="select *from kullanicilar where kullaniciAdi=? and sifre=? and yetki='personel'";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1,personel_name.getText().trim());
    		sorgu.setString(2,personel_sifre.getText().trim());
    		//   ResultSet getirilen=
    		getirilen=sorgu.executeQuery();
    		
    		if(!getirilen.next()) {
    			System.out.println("kullanici adi veya sifre hatalıdır");
    		}

    	} catch (Exception e) {
    		
    		FXMLLoader fxmlLoader = new FXMLLoader (getClass().getResource("Form3controller.fxml"));
    		Parent root1=(Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));
    		stage.show();
    		
    	}
    }

    @FXML
    void initialize() {
        
    }

}

