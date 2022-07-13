package it.polito.tdp.genes;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.genes.model.ArchiAdiacenti;
import it.polito.tdp.genes.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStatistiche;

    @FXML
    private Button btnRicerca;

    @FXML
    private ComboBox<String> boxLocalizzazione;

    @FXML
    private TextArea txtResult;

    @FXML
    void doRicerca(ActionEvent event) {

    }

    @FXML
    void doStatistiche(ActionEvent event) {
    	
    	String localizzazione = boxLocalizzazione.getValue();
    	
    	txtResult.clear();
    	txtResult.appendText(" adiacenti a : "+ localizzazione + "\n");
    	for (ArchiAdiacenti a : model.getLocalizzazioniConnesse(localizzazione)) {
    		
    		txtResult.appendText(a.getLoca() + " "+ a.getPeso()+ "\n");
    	}

    }

    @FXML
    void initialize() {
        assert btnStatistiche != null : "fx:id=\"btnStatistiche\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert boxLocalizzazione != null : "fx:id=\"boxLocalizzazione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
		boxLocalizzazione.getItems().addAll(this.model.getLocalizzazioni());
		
		this.model.creaGrafo();
		
		txtResult.appendText("Grafo creato con : \n");
		txtResult.appendText("Vertici : " + model.getVertici() + "\n");
		txtResult.appendText("Archi : " + model.getArchi() + "\n");
		
	}
}
