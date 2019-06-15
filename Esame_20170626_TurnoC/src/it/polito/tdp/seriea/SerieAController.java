/**
 * Sample Skeleton for 'SerieA.fxml' Controller Class
 */

package it.polito.tdp.seriea;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class SerieAController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxNumeroDiGoal"
    private ChoiceBox<?> boxNumeroDiGoal; // Value injected by FXMLLoader

    @FXML // fx:id="boxSquadra1"
    private ChoiceBox<?> boxSquadra1; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcolaConnessioniGoal"
    private Button btnCalcolaConnessioniGoal; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizzaRisultati"
    private Button btnAnalizzaRisultati; // Value injected by FXMLLoader

    @FXML // fx:id="boxSquadra2"
    private ChoiceBox<?> boxSquadra2; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimulaStagioni"
    private Button btnSimulaStagioni; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doAnalizzaRisultati(ActionEvent event) {

    }

    @FXML
    void doCalcolaConnessioniGoal(ActionEvent event) {

    }

    @FXML
    void doSimulaStagioni(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxNumeroDiGoal != null : "fx:id=\"boxNumeroDiGoal\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert boxSquadra1 != null : "fx:id=\"boxSquadra1\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert btnCalcolaConnessioniGoal != null : "fx:id=\"btnCalcolaConnessioniGoal\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert btnAnalizzaRisultati != null : "fx:id=\"btnAnalizzaRisultati\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert boxSquadra2 != null : "fx:id=\"boxSquadra2\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert btnSimulaStagioni != null : "fx:id=\"btnSimulaStagioni\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SerieA.fxml'.";

    }
}
