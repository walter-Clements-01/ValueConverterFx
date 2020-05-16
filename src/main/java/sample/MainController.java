package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import sample.controller.CurrenciesRetriever;
import sample.model.Currencies;
import sample.utils.ComboBoxUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private GridPane firstGridPane;
    @FXML
    private ComboBox<String> leftBox;
    @FXML
    private ComboBox<String> rightBox;
    @FXML
    private TextField leftTextField;
    @FXML
    private TextField rightTextField;
    @FXML
    private Label updateLabel;
    @FXML
    private Label updatedAtLabel;
    @FXML
    private Button updateButton;

    private CurrenciesRetriever currenciesRetriever;
    private Currencies currencies;
    private Map<String, Double> names;

    public MainController() throws Exception {

        currenciesRetriever = new CurrenciesRetriever();
        currencies = currenciesRetriever.getCurrencies();
        names=currencies.getRatesNames();
    }
    public void initialize(java.net.URL arg0, ResourceBundle arg1){
        try {
            setComboBoxes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setComboBoxes() throws Exception {
        ArrayList<String> nameList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : names.entrySet()) {

            nameList.add(entry.getKey());
        }
        leftBox.setItems(FXCollections.observableList(nameList));
        rightBox.setItems(FXCollections.observableList(nameList));

        if(ComboBoxUtil.load().getBoxInit()!=null)
            leftBox.getSelectionModel().select(ComboBoxUtil.load().getBoxInit());

        if(ComboBoxUtil.load().getBoxFin()!=null)
            rightBox.getSelectionModel().select(ComboBoxUtil.load().getBoxFin());

    }
}
