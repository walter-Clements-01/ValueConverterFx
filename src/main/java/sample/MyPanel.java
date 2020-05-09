/*package sample;

import sample.controller.ComboBoxes;
import sample.controller.CurrenciesRetriever;
import sample.model.Currencies;
import sample.utils.ComboBoxUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.Map;

public class MyPanel extends JPanel
{
    private JLabel viLabel;
    private JLabel vfLabel;
    private JComboBox boxInit;
    private JComboBox boxFin;
    private JTextField startTextField;
    private JTextField endTextField;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JPanel datePanel;
    private JLabel dateLabel;
    private JButton refreshButton;
    private CurrenciesRetriever currenciesRetriever;
    private Currencies currencies;
    private Map<String, Double> names;
    public MyPanel() throws Exception {
        currenciesRetriever = new CurrenciesRetriever();
        currencies = currenciesRetriever.getCurrencies();
        names=currencies.getRatesNames();

        topPanel = new JPanel(new GridLayout(1,2,20,20));
        viLabel = new JLabel("Valuta da convertire");
        viLabel.setFont(new Font(null,Font.BOLD, 30));
        vfLabel = new JLabel("Valuta convertita");
        vfLabel.setFont(new Font(null,Font.BOLD, 30));
        topPanel.add(viLabel, BorderLayout.CENTER);
        topPanel.add(vfLabel, BorderLayout.CENTER);

        middlePanel = new JPanel(new GridLayout(1,2,20,20));
        boxInit = new JComboBox();
        boxInit.setSize(100,75);
        boxInit.setFont(new Font(null,Font.BOLD, 15));
        boxFin = new JComboBox();
        boxFin.setFont(new Font(null,Font.BOLD, 15));
        boxFin.setSize(100,75);
        middlePanel.add(boxInit);
        middlePanel.add(boxFin);
        setComboBoxes();

        bottomPanel = new JPanel(new GridLayout(1,2,20,20));
        startTextField = new JTextField();
        startTextField.setPreferredSize(new Dimension(200,75));
        startTextField.setFont(new Font(null,Font.BOLD, 20));
        endTextField = new JTextField();
        endTextField.setPreferredSize(new Dimension(200,75));
        endTextField.setFont(new Font(null,Font.BOLD, 20));
        bottomPanel.add(startTextField, BorderLayout.WEST);
        bottomPanel.add(endTextField, BorderLayout.EAST);

        datePanel = new JPanel(new GridLayout(1,2,20,20));
        dateLabel = new JLabel("Data ultimo aggiornamento:"+  new Timestamp(currencies.getTimestamp()*1000));
        dateLabel.setFont(new Font(null,Font.BOLD, 15));

        JPanel refreshButtonPanel = new JPanel();
        refreshButton = new JButton(new ImageIcon(ImageIO.read(getClass().getResource("/refresh.png"))));
        refreshButtonPanel.add(refreshButton);

        datePanel.add(dateLabel, BorderLayout.WEST);
        datePanel.add(refreshButtonPanel, BorderLayout.EAST);

        setLayout(new GridLayout(4,1,20,20));
        add(topPanel);
        add(middlePanel);
        add(bottomPanel);
        add(datePanel);

        refreshButton.addActionListener(new RefreshButtonListener(currenciesRetriever,dateLabel));

        boxInit.addItemListener(new ItemChangeListener(startTextField,endTextField,names,boxInit,boxFin));
        boxFin.addItemListener(new ItemChangeListener(endTextField,startTextField,names,boxFin,boxInit));
        startTextField.getDocument().addDocumentListener(new TextChangeListener(startTextField,endTextField,names,boxInit,boxFin));
        endTextField.getDocument().addDocumentListener(new TextChangeListener(endTextField,startTextField,names,boxFin,boxInit));
    }
   public void setComboBoxes() throws Exception {
       for (Map.Entry<String, Double> entry : names.entrySet()) {

           boxInit.addItem(entry.getKey());
           boxFin.addItem(entry.getKey());
       }
       boxInit.setSelectedItem(ComboBoxUtil.load().getBoxInit());
       boxFin.setSelectedItem(ComboBoxUtil.load().getBoxFin());
    }
    public ComboBoxes getCurrentComboBoxes()
    {
        ComboBoxes comboBoxes = new ComboBoxes();
        comboBoxes.setBoxInit(boxInit.getSelectedItem().toString());
        comboBoxes.setBoxFin(boxFin.getSelectedItem().toString());
        return comboBoxes;
    }
}*/
