package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sample.controller.CurrenciesRetriever;
import sample.model.Currencies;
import sample.utils.ComboBoxUtil;
import sample.utils.ConversionUtil;

import java.awt.event.ItemEvent;
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
        for (Map.Entry<String, Double> entry : names.entrySet())
            nameList.add(entry.getKey());

        leftBox.setItems(FXCollections.observableList(nameList));
        rightBox.setItems(FXCollections.observableList(nameList));

        if(ComboBoxUtil.load().getBoxInit()!=null)
            leftBox.getSelectionModel().select(ComboBoxUtil.load().getBoxInit());

        if(ComboBoxUtil.load().getBoxFin()!=null)
            rightBox.getSelectionModel().select(ComboBoxUtil.load().getBoxFin());

    }


    /*@Override
    public void itemStateChanged(ItemEvent e) {
        convert();
        String convertedText= ConversionUtil.exeConversion(leftBox,startRate,endRate);
        setTextField(convertedText);
    }*/

    /*public void convert(String startText, String endText, Double startRate, Double endRate)
    {
        String leftText= leftTextField.getText();
        String rightText= rightTextField.getText();
        Double startRate = names.get(leftBox.getSelectionModel().getSelectedItem());
        Double endRate = names.get(rightBox.getSelectionModel().getSelectedItem());

        String convertedText= ConversionUtil.exeConversion(leftText,startRate,endRate);
        try
        {
            rightTextField.setText(convertedText);
        }
        catch(IllegalStateException e)
        {
            System.out.println("Caught Start");
        }
    }*/

    public void leftTextChanged(KeyEvent keyEvent) throws InterruptedException {
        //System.out.println("left event");
        String startText= leftTextField.getText();
        Double startRate = names.get(leftBox.getSelectionModel().getSelectedItem());
        Double endRate = names.get(rightBox.getSelectionModel().getSelectedItem());
        String convertedText= ConversionUtil.exeConversion(startText,startRate,endRate);
        try
        {
            rightTextField.setText(convertedText);
        }
        catch(IllegalStateException e)
        {
            System.out.println("Caught Start");
        }
    }

    public void rightTextChanged(KeyEvent keyEvent) {
        System.out.println("right event");
        String startText= rightTextField.getText();
        Double startRate = names.get(leftBox.getSelectionModel().getSelectedItem());
        Double endRate = names.get(rightBox.getSelectionModel().getSelectedItem());
        String convertedText= ConversionUtil.exeConversion(startText,endRate,startRate);
        try
        {
            leftTextField.setText(convertedText);
        }
        catch(IllegalStateException e)
        {
            System.out.println("Caught Start");
        }
    }

    public void leftBoxChanged(ActionEvent actionEvent) {
        String startText= rightTextField.getText();
        Double startRate = names.get(rightBox.getSelectionModel().getSelectedItem());
        Double endRate = names.get(leftBox.getSelectionModel().getSelectedItem());
        String convertedText= ConversionUtil.exeConversion(startText,startRate,endRate);
        try
        {
            leftTextField.setText(convertedText);
        }
        catch(IllegalStateException e)
        {
            System.out.println("Caught Start");
        }
    }

    public void rightBoxChanged(ActionEvent actionEvent) {
        String startText= leftTextField.getText();
        Double startRate = names.get(leftBox.getSelectionModel().getSelectedItem());
        Double endRate = names.get(rightBox.getSelectionModel().getSelectedItem());
        String convertedText= ConversionUtil.exeConversion(startText,startRate,endRate);
        try
        {
            rightTextField.setText(convertedText);
        }
        catch(IllegalStateException e)
        {
            System.out.println("Caught Start");
        }
    }

    /*public void setTextField(String convertedText)
    {
        try
        {
            endTextField.setText(convertedText);
        }
        catch(IllegalStateException e)
        {
            System.out.println("Caught Start");
        }
    }*/

}
