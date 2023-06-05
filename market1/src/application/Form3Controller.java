package application;
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Spring;

import com.myConnect.Util.VeriTabaniUtil;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;



public class Form3Controller {

	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	
	
	@FXML
	private ImageView aubergine;

	@FXML
	private ImageView bean;

	@FXML
	private ImageView beypazari;

	@FXML
	private ImageView bplimon;

	@FXML
	private ImageView bulgur;

	@FXML
	private ImageView camSil;

	@FXML
	private ImageView cappy;

	@FXML
	private ImageView chickpeas;

	@FXML
	private ImageView cilek;

	@FXML
	private ImageView cpsSade;

	@FXML
	private ImageView cpsYogurt;

	@FXML
	private ImageView cucumber;

	@FXML
	private ImageView domestos;

	@FXML
	private ImageView drink102;

	@FXML
	private ImageView drink1021;

	@FXML
	private ImageView drink1022;

	@FXML
	private ImageView drink1023;

	@FXML
	private ImageView drink1024;

	@FXML
	private ImageView drink1025;

	@FXML
	private ImageView drink111;
	
    @FXML
    private TabPane tabUrunler;

    @FXML
    private Tab icecek;
 
    @FXML
    private Tab meyve;
 

    @FXML
    private Tab sebze;

    @FXML
    private Tab temizlk;

    @FXML
    private Tab bakiyat;

    @FXML
    private Tab atistirmalik;

    @FXML
    private Text tplm;

    @FXML
    private Label toplam;

    @FXML
    private Label odenen;

    @FXML
    private Label paraustu;

   
    @FXML
    private TextField ekran;

    @FXML
    private Button adtBtn;

    @FXML
    private Button silBtn;

    @FXML
    private Button odnBtn;

    @FXML
    private Button okBtn;

    @FXML
    private Button kart;

    @FXML
    private Button anb;
    @FXML
    private Button bC;
    
    @FXML
    private Button bsekiz;

    @FXML
    private Button bsifir;

    @FXML
    private Button buc;
    @FXML
    private Button bvirgul;

    @FXML
    private Button byedi;
    @FXML
    private Button yirmib;
    
    @FXML
    private Button ikiyuzb;
    @FXML
    private Button yuzb;
    
    @FXML
    private Button ellib;
    @FXML
    private Button biki;
    @FXML
    private Button balti;

    @FXML
    private Button bbes;

    @FXML
    private Button bbir;

    @FXML
    private Button bdokuz;

    @FXML
    private Button bdort;

    @FXML
    private Button besb;
    @FXML
    private TableView<Products> sepet;

    @FXML
    private TableColumn<Products, Integer> adet;

    @FXML
    private TableColumn<Products, String> urun;

    @FXML
    private TableColumn<Products, Double> fiyat;

    @FXML
    private TableColumn<Products, Double> total;
  
    String totalSayi="";  
  
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    
    Form3Controller(){
    	
    	baglanti=VeriTabaniUtil.Baglan();
    }

  
@FXML
public void image(ActionEvent event) {
	Products product =new Products();
	ImageView imageView =(ImageView)event.getSource();

	String resimId = imageView.getId();
	sql="select * from market where urun=?";
	sorgu=baglanti.prepareStatement(sql);
	sorgu.setString(1,resimId);
	getirilen=sorgu.executeQuery();
	

	

	int adetImg = getirilen.getString("adet");
String urunImg = getirilen.getString("urun");
double fiyatImg = getirilen.getString("fiyat");
double tplmImg = getirilen.getString("total");

	


    dizi.add(new Products(adetImg, urunImg,fiyatImg,tplmImg));
	
	sepet.setItems(dizi);
}
   
    
   
  
    @FXML
   public  void number(ActionEvent event) {

     Button btn = (Button)event.getSource();
        
    	totalSayi=totalSayi+btn.getText();
    	ekran.setText(totalSayi);
    	
    }
             
   @FXML
   public void tamSayi(ActionEvent event) {
	   Button tam =(Button)event.getSource();
	  odenen.setText(tam.getText());
	  ParaUstu();
   
   }
 

    @FXML
    void c(ActionEvent event) {
    	
ekran.setText(null);
    }
      
    
    
    @FXML
    void kart(ActionEvent event) {

    	odenen.setText(toplam.getText());
    	paraustu.setText("ödendi");
    }
	

    
    @FXML 
    void odenenBtn(ActionEvent event) {
    	odenen.setText(ekran.getText());
    	ParaUstu();
    	totalSayi="";
    	ekran.setText("");
    	

    }

    @FXML
    void okBtn(ActionEvent event) {
    	 
    	toplam.setText(".....");
    	odenen.setText(".....");
    	paraustu.setText(".....");
    	ekran.clear();
    	dizi.clear();
    	
    	dizi.clear();
    } 

    

    @FXML
    void silBtn(ActionEvent event) {
     	Products product;
    	product =(Products) sepet.getItems().get(sepet.getSelectionModel().getSelectedIndex());
    	
    	dizi.remove(product);
    	
    	
    }

   

   
    public void totalHesaplama(int adet,double fiyat) {
    	 
      	double totalHsp=adet*fiyat;
      	
      }

    @FXML
    void adetBtn(ActionEvent event) {
    	
    	Products product =new Products();
    	product =(Products) sepet.getItems().get(sepet.getSelectionModel().getSelectedIndex());
    	int a=Integer.parseInt((ekran.getText());
 
    	product.adet=a;
    	double fiyatHsp=product.fiyat;
     	double totalHsp=a*fiyatHsp;
        product.total=totalHsp;
        dizi.remove(product);
        dizi.add(product);

    }

 


    @FXML
    void virgul(ActionEvent event) {

    
    }

  
    
    

    
     ObservableList<Products> dizi;
     
    @FXML
    void initialize() {      
    	
    	dizi=FXCollections.observableArrayList();
    	
     	Image apple=new Image("/meyve/apple.jpg");
    	elma.setImage(apple);
    	

    	Image banana=new Image("/meyve/banana.jpg");
    	muz.setImage(banana);
    	

    	Image cherry=new Image("/meyve/cherry.jpg");
    	kiraz.setImage(cherry); 
    	

    	Image grape	=new Image("/meyve/grape.jpg");
    	uzum.setImage(grape);
    	

    	Image kiwi=new Image("/meyve/kiwi.jpg");
    	kivi.setImage(kiwi);
    	 

    	Image melon=new Image("/meyve/melon.jpg");
    	kavun.setImage(melon);
    	

    	Image sberry=new Image("/meyve/sberry.jpg");
    	cilek.setImage(sberry);
    	

    	Image watermelon=new Image("/meyve/watermelon.jpg");
    	karpuz.setImage(watermelon); 
    	
    	
    	
    	
    	
    	

    	Image i9=new Image("/atistirmalik/cpsSade.jpeg");
    	cpsSade.setImage(i9); 
    	
    	Image i10=new Image("/atistirmalik/cpsYogurt.jpeg");
    	cpsYogurt.setImage(i10); 

    	Image i11=new Image("/atistirmalik/etiCt.jpeg");
    	etiCt.setImage(i11); 

    	Image i12=new Image("/atistirmalik/peynirk.jpeg");
    	peynirk.setImage(i12); 

    	Image i13=new Image("/atistirmalik/snikers.jpeg");
    	snikers.setImage(i13); 

    	Image i14=new Image("/atistirmalik/susamk.jpeg");
    	susamk.setImage(i14); 

    	Image i15=new Image("/atistirmalik/tpuzum.jpeg");
    	tpuzum.setImage(i15); 

    	Image i16=new Image("/atistirmalik/wanted.jpeg");
    	wanted.setImage(i16); 
    	
    	
    	
    	Image i1=new Image("/bakliyat/bean.jpeg");
    	bean.setImage(i1); 
    	
    	Image i2=new Image("/bakliyat/bulgur.jpeg");
    	bulgur.setImage(i2); 

    	Image i3=new Image("/bakliyat/chickpeas.jpeg");
    	chickpeas.setImage(i3); 

    	Image i4=new Image("/bakliyat/glentil.jpeg");
    	glentil.setImage(i4); 

    	Image i5=new Image("/bakliyat/lentil.jpeg");
    	lentil.setImage(i5); 

    	Image i6=new Image("/bakliyat/manti.jpeg");
    	manti.setImage(i6); 

    	Image i7=new Image("/bakliyat/pasta.jpeg");
    	pasta.setImage(i7); 

    	Image i8=new Image("/bakliyat/rice.jpeg");
    	rice.setImage(i8); 
    	
    	
    	
      	Image i17=new Image("/beypazari/beypazari.jpeg");
      	beypazari.setImage(i17); 
    	
    	Image i18=new Image("/icecek/bplimon.jpeg");
    	bplimon.setImage(i18); 

    	Image i19=new Image("/icecek/cappy.jpeg");
    	cappy.setImage(i19); 

    	Image i20=new Image("/icecek/limonata.jpeg");
    	limonata.setImage(i20); 

    	Image i21=new Image("/icecek/link.jpeg");
    	link.setImage(i21); 

    	Image i22=new Image("/icecek/salgam.jpeg");
    	salgam.setImage(i22); 

    	
   

    	Image i25=new Image("/sebze/aubergine.jpg");
    	aubergine.setImage(i25); 

    	Image i26=new Image("/sebze/cucumber.jpg");
    	cucumber.setImage(i26); 

    	Image i27=new Image("/sebze/garlic.jpg");
    	garlic.setImage(i27); 

    	Image i28=new Image("/sebze/leek.jpg");
    	leek.setImage(i28); 

    	Image i29=new Image("/sebze/lemon.jpg");
    	lemon.setImage(i29); 

    	Image i30=new Image("/sebze/onion.jpg");
    	onion.setImage(i30); 

    	Image i31=new Image("/sebze/redpepper.jpg");
    	redpepper.setImage(i31); 

    	Image i32=new Image("/sebze/tomato.jpg");
    	tomato.setImage(i32); 
 
    	
    	

    	Image i33=new Image("/temizlik/camSil.jpeg");
    	camSil.setImage(i33); 


    	Image i34=new Image("/temizlik/domestos.jpeg");
    	domestos.setImage(i34); 


    	Image i35=new Image("/temizlik/mguc.jpeg");
    	mguc.setImage(i35); 


    	Image i36=new Image("/temizlik/sguc.jpeg");
    	sguc.setImage(i36); 


    	Image i37=new Image("/temizlik/shampo.jpeg");
    	shampo.setImage(i37); 


    	Image i38=new Image("/temizlik/yummos.jpeg");
    	yummos.setImage(i38); 

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
 
    	
    }  
  
    public static class Products { 
  
    	private int adet;
    	private String urun;
    	private double fiyat;
    	private double total;
        private int id;
        
        
      
        public Products() {

        }
        
        
    	public Products(int adet,String urun,double fiyat,double total) {
    	
    		this.urun=urun;
    		this.fiyat=fiyat;
    		this.adet=adet;
    		this.total=total;
    	}
    	public Products(int id,int adet,String urun,double fiyat,double total) {
    		this.id=id;
    		this.urun=urun;
    		this.fiyat=fiyat;
    		this.adet=adet;
    		this.total=total;
    	}

    	
    	
    	public  Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
    	
		public Integer getAdet() {
			return adet;
		}

		public void setAdet(Integer adet) {
			this.adet = adet;
		}

		public String getUrun() {
			return urun;
		}

		public void setUrun(String urun) {
			this.urun = urun;
		}

		public double getFiyat() {
			return fiyat;
		}

		public void setFiyat(double fiyat) {
			this.fiyat = fiyat;
		}

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}  
    	
    }
    
    public void Sepetim() { 

  	  int y =0;

  	  for (Products products : dizi) {
  		
  		 double tp = products.getTotal();
  	
  		 y +=products.getTotal();
  		  
			
		}
	  
  	  toplam.setText(String.valueOf(y));
  	  sepet.setItems(dizi);;
  	
  	}
    
    public void ParaUstu() {
    	
    	
double tp = Double.parseDouble(toplam.getText());
double odn =Double.parseDouble(odenen.getText());
double pustu =odn-tp;
String parau=String.valueOf(pustu);
paraustu.setText(parau);
    }

    
    
    
}
  	  
    
    

