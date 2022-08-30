package application;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GarageController implements Runnable, Initializable {

    @FXML
    protected Rectangle posto1a;

    @FXML
    protected Rectangle posto2a;

    @FXML
    protected Rectangle posto3a;

    @FXML
    protected Rectangle posto4a;

    @FXML
    protected Rectangle posto5a;

    @FXML
    protected Rectangle posto6a;

    @FXML
    protected Rectangle posto7a;

    @FXML
    protected Rectangle posto8a;

    @FXML
    protected Rectangle posto9a;

    @FXML
    protected Rectangle posto10a;

    @FXML
    protected Rectangle posto11f;

    @FXML
    protected Rectangle posto12f;

    @FXML
    protected Rectangle posto15f;

    @FXML
    protected Rectangle posto14f;

    @FXML
    protected Rectangle posto13f;

    @FXML
    protected Rectangle posto16f;

    @FXML
    protected Rectangle posto17f;

    @FXML
    protected Rectangle posto18f;

    @FXML
    protected Rectangle posto19f;

    @FXML
    protected Rectangle posto20f;

    @FXML
    protected Rectangle posto21b;

    @FXML
    protected Rectangle posto22b;

    @FXML
    protected Rectangle posto23b;

    @FXML
    protected Rectangle posto24b;

    @FXML
    protected Rectangle posto25b;

    @FXML
    protected Rectangle posto26b;

    @FXML
    protected Rectangle posto27b;

    @FXML
    protected Rectangle posto28b;

    @FXML
    protected Rectangle posto29b;

    @FXML
    protected Rectangle posto30b;
    
    @FXML
    protected Label timeLabel;
    
    @FXML
    private TextField targaFurgone;
    
    @FXML
    private TextField targaAuto;

    @FXML
    private TextField targaBici;
    
    @FXML
    private TextField targaAutoR;

    @FXML
    private TextField targaFurgoneR;

    @FXML
    private TextField targaBiciR;
    
    @FXML
    private Label tipoScontrino;

    @FXML
    private Label targaScontrino;

    @FXML
    private Label tempoScontrino;

    @FXML
    private Label importoScontrino;
    
    // orario
    private Thread thread = null;
    private String time = "";
    private SimpleDateFormat format;
    private Date date;
    private Calendar calendar;
    
    // vettori posti 
    protected Bici bici[]  = new Bici[10];
    protected Furgone furgoni[] = new Furgone[10];
    protected Auto auto[] = new Auto[10];
    protected int i_bici;
    protected int i_auto;
    protected int i_furgone;
	
	// Costo parcheggio
    private final double COSTO_AUTO = 0.04;
    private final double COSTO_BICI = 0.008;
    private final double COSTO_CAMION = 0.08;
    
    private double profitto = 0;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { //Start timer using thread on application startup
        thread = new Thread(this);
        thread.start();
    }
	
	
	 public void run() {
	        try {
	            while (true) {
	                calendar = Calendar.getInstance();             		                
	                format = new SimpleDateFormat("mm:ss a");
	                date = calendar.getTime();
	                time = format.format(date);
	           

	                Platform.runLater(new Runnable() {
	                    @Override
	                    public void run() {
	                    	timeLabel.setText(time);
	                    }
	                });

	                Thread.sleep(1000);
	            }
	        } catch (Exception e) { //Error check
	        	timeLabel.setText("Error occurred!!");
	        }
	    }


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}

	public double getProfitto() {
		return profitto;
	}


	public void setProfitto(double profitto) {
		this.profitto = profitto;
	}


	@FXML
    void btnParcheggiaFurgone(ActionEvent event) {
		
		
    	
    	if(posto11f.getFill().equals(Color.RED) && posto12f.getFill().equals(Color.RED) && posto13f.getFill().equals(Color.RED) &&
    			posto14f.getFill().equals(Color.RED) && posto15f.getFill().equals(Color.RED) && posto16f.getFill().equals(Color.RED) &&
    			posto17f.getFill().equals(Color.RED) && posto18f.getFill().equals(Color.RED) && posto19f.getFill().equals(Color.RED) &&
    			posto20f.getFill().equals(Color.RED)){
    				 
    				 Alert alert = new Alert(AlertType.ERROR, "Non ci sono parcheggi disponibili!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Impossibile parcheggiare il furgone");
    				 alert.show();
    			 }
    			
    				
    				
    			 		 
    			 String targa = targaFurgone.getText();
    			 
    			 
    			 
    			 if(posto11f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,11);
    				 i_furgone++;
    				 posto11f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    				 
    			 } 
    			 else if(posto12f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,12);
    				 i_furgone++;
    				 posto12f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}
    			 else if(posto13f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,13);
    				 i_furgone++;
    				 posto13f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}		 
    			 else if(posto14f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,14);
    				 i_furgone++;
    				 posto14f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto15f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,15);
    				 i_furgone++;
    				 posto15f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto16f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,16);
    				 i_furgone++;
    				 posto16f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto17f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,17);
    				 i_furgone++;
    				 posto17f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 } 
    			 else if(posto18f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,18);
    				 i_furgone++;
    				 posto18f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto19f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,19);
    				 i_furgone++;
    				 posto19f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 } 
    			
    			 else if(posto20f.getFill().equals(Color.GREEN)){
    				 furgoni[i_furgone] = new Furgone(targa,20);
    				 i_furgone++;
    				 posto20f.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato il furgone!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}
    		 }
	
    @FXML
    void btnParcheggiaAuto(ActionEvent event) {
    	
    	
    	
    	if(posto1a.getFill().equals(Color.RED) && posto2a.getFill().equals(Color.RED) && posto3a.getFill().equals(Color.RED) &&
    			posto4a.getFill().equals(Color.RED) && posto5a.getFill().equals(Color.RED) && posto6a.getFill().equals(Color.RED) &&
    			posto7a.getFill().equals(Color.RED) && posto8a.getFill().equals(Color.RED) && posto9a.getFill().equals(Color.RED) &&
    			posto10a.getFill().equals(Color.RED)){
    				 Alert alert = new Alert(AlertType.ERROR, "Non ci sono parcheggi disponibili!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Impossibile parcheggiare l'auto");
    				 alert.show();
    			 }
    			
    				
    				
    			 		 
    			 String targa = targaAuto.getText();
    			 
    			 
    			 
    			 if(posto1a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,1);
    				 i_auto++;
    				 posto1a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 } 
    			 else if(posto2a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,2);
    				 i_auto++;
    				 posto2a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}
    			 else if(posto3a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,3);
    				 i_auto++;
    				 posto3a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}		 
    			 else if(posto4a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,4);
    				 i_auto++;
    				 posto4a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto5a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,5);
    				 i_auto++;
    				 posto5a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto6a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,6);
    				 i_auto++;
    				 posto6a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto7a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,7);
    				 i_auto++;
    				 posto7a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 } 
    			 else if(posto8a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,8);
    				 i_auto++;
    				 posto8a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto9a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,9);
    				 i_auto++;
    				 posto9a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 } 
    			
    			 else if(posto10a.getFill().equals(Color.GREEN)){
    				 auto[i_auto] = new Auto(targa,10);
    				 i_auto++;
    				 posto10a.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato l'auto!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go Garage");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}

    }

    @FXML
    void btnParcheggiaBici(ActionEvent event) {
    	
    	
    	
    	if(posto21b.getFill().equals(Color.RED) && posto22b.getFill().equals(Color.RED) && posto23b.getFill().equals(Color.RED) &&
    			posto24b.getFill().equals(Color.RED) && posto25b.getFill().equals(Color.RED) && posto26b.getFill().equals(Color.RED) &&
    			posto27b.getFill().equals(Color.RED) && posto28b.getFill().equals(Color.RED) && posto29b.getFill().equals(Color.RED) &&
    			posto30b.getFill().equals(Color.RED)){
    				 Alert alert = new Alert(AlertType.ERROR, "Non ci sono parcheggi disponibili!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Impossibile parcheggiare la bici");
    				 alert.show();
    			 }
    				
    				
    			 		 
    			 String nome = targaBici.getText();
    			 
    			 
    			 
    			 
    			 if(posto21b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,21);
    				 i_bici++;
    				 posto21b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 } 
    			 else if(posto22b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,22);
    				 i_bici++;
    				 posto22b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}
    			 else if(posto23b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,23);
    				 i_bici++;
    				 posto23b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}		 
    			 else if(posto24b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,24);
    				 i_bici++;
    				 posto24b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto25b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,25);
    				 i_bici++;
    				 posto25b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto26b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,26);
    				 i_bici++;
    				 posto26b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto27b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,27);
    				 i_bici++;
    				 posto27b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto28b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,28);
    				 i_bici++;
    				 posto28b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			 else if(posto29b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,29);
    				 i_bici++;
    				 posto29b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			 }
    			
    			 else if(posto30b.getFill().equals(Color.GREEN)){
    				 bici[i_bici] = new Bici(nome,30);
    				 i_bici++;
    				 posto30b.setFill(Color.RED);
    				 Alert alert = new Alert(AlertType.CONFIRMATION, "Hai parcheggiato la Bici!", ButtonType.OK);
    				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    				 alert.setTitle("Parkin'go");
    				 alert.setHeaderText("Parcheggio!");
    				 alert.show();
    			}

    }
    
    @SuppressWarnings("deprecation")
	@FXML
    void btnRitiraAuto(ActionEvent event) {
    	
    	 String targa;
		 targa = targaAuto.getText();
		 double tempo;
		 double importo;
		 
	 
		 for ( int i = 0 ; i < 10 ; i++){
			 if( auto[i].getTarga().equals(targa)){
				
	            calendar = Calendar.getInstance();             		                
	            date = calendar.getTime();
					
	            @SuppressWarnings("deprecation")
				int minuti = date.getSeconds();
	            
	            int diff = 0;
	            
	            diff = minuti - auto[i].getDateOne().getSeconds() ;
								
				
	            tipoScontrino.setText("Auto");
				targaScontrino.setText(targa);
				tempo = (date.getSeconds() - auto[i].getDateOne().getSeconds()) ;
				importo = tempo*COSTO_AUTO;
				tempoScontrino.setText(""+diff+" minuti");
				importoScontrino.setText(""+importo+ "€");
				profitto= profitto+importo;
				
				Alert alert = new Alert(AlertType.CONFIRMATION, "Hai ritirato la tua auto!", ButtonType.OK);
				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				 alert.setTitle("Parkin'go");
				 alert.setHeaderText("Ritiro!");
				 alert.show();
				
				
				
			
				if( auto[i].getNposto() == 1 ){
					posto1a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 2){
					posto2a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 3){
					posto3a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 4){
					posto4a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 5){
					posto5a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 6){
					posto6a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 7){
					posto7a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 8){
					posto8a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 9){
					posto9a.setFill(Color.GREEN);
				}
				else if(auto[i].getNposto() == 10){
					posto10a.setFill(Color.GREEN);
				}
			 }
		 } 		 		 
	 

    }

    @SuppressWarnings("deprecation")
	@FXML
    void btnRitiraBici(ActionEvent event) {
    	
    	 String nome;
		 nome = targaBici.getText();
		 double tempo;
		 double importo;
		 
		 
		 for ( int i = 0 ; i < 10 ; i++){
			 if( bici[i].getNome().equals(nome)){
				
			   calendar = Calendar.getInstance();             		                
		       date = calendar.getTime();
		       
		       int minuti = date.getSeconds();
		       @SuppressWarnings("unused")
			   int diff = 0;
		       diff = minuti - bici[i].getDateOne().getSeconds() ;
				
				tipoScontrino.setText("Bici");
				targaScontrino.setText(nome);
				tempo = (date.getSeconds()-bici[i].getDateOne().getSeconds()) ;
				importo = tempo*COSTO_BICI;
				tempoScontrino.setText(""+tempo+" minuti");
				importoScontrino.setText(""+importo+ "€");
				profitto= profitto+importo;
				
				Alert alert = new Alert(AlertType.CONFIRMATION, "Hai ritirato la tua bici!", ButtonType.OK);
				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				 alert.setTitle("Parkin'go");
				 alert.setHeaderText("Ritiro!");
				 alert.show();
				
				if( bici[i].getNposto() == 21){
					posto21b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 22){
					posto22b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 23){
					posto23b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 24){
					posto24b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 25){
					posto25b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 26){
					posto26b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 27){
					posto27b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 28){
					posto28b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 29){
					posto29b.setFill(Color.GREEN);
				}
				else if(bici[i].getNposto() == 30){
					posto30b.setFill(Color.GREEN);
				}
			 }
		 }

    }

    @SuppressWarnings("deprecation")
	@FXML
    void btnRitiraFurgone(ActionEvent event) {
    	
    	 String targa;
		 targa = targaFurgone.getText();
		 double tempo;
		 double importo;
		 

		


		 for ( int i = 0 ; i < 10 ; i++){
			 if( furgoni[i].getTarga().equals(targa)){
				
			   calendar = Calendar.getInstance();             		                
		       date = calendar.getTime();
		       
		       int minuti = date.getSeconds();
		       
		       @SuppressWarnings("unused")
		       int diff = 0;
		       diff = minuti - furgoni[i].getDateOne().getSeconds() ;
				
				tipoScontrino.setText("Furgone");
				targaScontrino.setText(targa);
				tempo = (date.getSeconds()-furgoni[i].getDateOne().getSeconds()) ;
				importo = tempo*COSTO_CAMION;
				tempoScontrino.setText(""+tempo+" minuti");
				importoScontrino.setText(""+importo+ "€");
				profitto= profitto+importo;
				
				Alert alert = new Alert(AlertType.CONFIRMATION, "Hai ritirato il tuo furgone!", ButtonType.OK);
				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
				 alert.setTitle("Parkin'go");
				 alert.setHeaderText("Ritiro!");
				 alert.show();
				
				if( furgoni[i].getNposto() == 11){
					posto11f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 12){
					posto12f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 13){
					posto13f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 14){
					posto14f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 15){
					posto15f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 16){
					posto16f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 17){
					posto17f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 18){
					posto18f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 19){
					posto19f.setFill(Color.GREEN);
				}
				else if(furgoni[i].getNposto() == 20){
					posto20f.setFill(Color.GREEN);
				}
			 }
		 } 

    }
    

    @FXML
    void btnprofitto(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION, "Il garage ha guadagnato "+profitto+" euro", ButtonType.OK);
		 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		 alert.setTitle("Parkin'go Amministrazione");
		 alert.setHeaderText("Profitto!");
		 alert.show();
    	
    	

    }

}
