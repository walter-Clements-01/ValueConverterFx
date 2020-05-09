package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.controller.CurrenciesRetriever;
import sample.model.Currencies;
import sample.utils.ComboBoxUtil;

import java.util.ArrayList;
import java.util.Map;

public class MainController {
    private ComboBox<String> leftBox;
    private ComboBox<String> rightBox;
    private TextField leftTextField;
    private TextField rightTextField;
    @FXML
    private Label updateLabel;
    @FXML
    private Button updateButton;
    private CurrenciesRetriever currenciesRetriever;
    private Currencies currencies;
    private Map<String, Double> names;
    public MainController(ComboBox<String> leftBox, ComboBox<String> rightBox, TextField leftTextField,
                          TextField rightTextField, Label updateLabel, Button updateButton) throws Exception {
        this.leftBox=leftBox;
        this.rightBox=rightBox;
        this.leftTextField=leftTextField;
        this.rightTextField=rightTextField;
        this.updateLabel=updateLabel;
        this.updateButton=updateButton;
        currenciesRetriever = new CurrenciesRetriever();
        currencies = currenciesRetriever.getCurrencies();
        names=currencies.getRatesNames();
    }
    public void setComboBoxes() throws Exception {
        ArrayList<String> nameList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : names.entrySet()) {

            nameList.add(entry.getKey());
        }
        leftBox.setItems(FXCollections.observableList(nameList));
        rightBox.setItems(FXCollections.observableList(nameList));

        leftBox.getSelectionModel().select(ComboBoxUtil.load().getBoxInit());
        rightBox.getSelectionModel().select(ComboBoxUtil.load().getBoxFin());
    }
}
