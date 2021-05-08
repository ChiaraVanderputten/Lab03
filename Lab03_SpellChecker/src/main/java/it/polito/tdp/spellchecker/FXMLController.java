/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {
	
	Model model;
	
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private ComboBox<String> cbLanguage;
	
    @FXML
    private TextArea txtParolaInserita;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtParoleSbagliate;
    

    @FXML
    private TextField txtErroriPresenti;


    @FXML
    private TextField txtCheckSecond;



    @FXML
    private Button btnClearText;
    



    @FXML
    void doClearText(ActionEvent event) {
    	
    	txtParolaInserita.clear();
    	txtParoleSbagliate.clear();
    	txtCheckSecond.clear();
    	txtErroriPresenti.clear();
    	
    	model.getListaP().clear();
    	model.getListaPSbagliate().clear();
    	model.setCont(0);

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	
    	if(txtParolaInserita.getText().isEmpty()) {
    		txtParolaInserita.setText("Inserisci una parola"); 
    		 
    		return;
    	}
    	
    	if(cbLanguage.getValue()==null) {
    		txtParolaInserita.setText("Inserisci una lingua");
    		return;
    	}
    	
       
         
    	model.paroleErrate(txtParolaInserita.getText(), cbLanguage.getValue());
    	int numErr=model.getCont();
    	txtErroriPresenti.setText("The text contains "+numErr+" errors");
    	
    	txtParoleSbagliate.setText(model.ListaParoleSbagliate());
    	
        
        
    	
        
    }
    
   
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	   assert cbLanguage != null : "fx:id=\"cbLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
           assert txtParolaInserita != null : "fx:id=\"txtParolaInserita\" was not injected: check your FXML file 'Scene.fxml'.";
           assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
           assert txtParoleSbagliate != null : "fx:id=\"txtParoleSbagliate\" was not injected: check your FXML file 'Scene.fxml'.";
           assert txtErroriPresenti != null : "fx:id=\"txtErroriPresenti\" was not injected: check your FXML file 'Scene.fxml'.";
           assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
           assert txtCheckSecond != null : "fx:id=\"txtCheckSecond\" was not injected: check your FXML file 'Scene.fxml'.";


    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	cbLanguage.getItems().addAll("English", "Italian");
    	
    }
    
}


