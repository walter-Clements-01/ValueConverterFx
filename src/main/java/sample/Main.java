package sample;
import sample.controller.ComboBoxes;
import sample.utils.ComboBoxUtil;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        URL url = this.getClass().getClassLoader().getResource("sample.fxml");
        System.out.println(url);

        InputStream inputStream = getClass().getResourceAsStream("/sample.fxml");

        String sample = convert(inputStream,"UTF-8");

        Parent root = FXMLLoader.load(url);
        stage.setTitle("Convertitore di valuta");
        stage.setScene(new Scene(root, 450, 350));
        stage.show();

        Scene scene = stage.getScene();

        ComboBox<String> leftBox = (ComboBox<String>) scene.lookup("#leftBox");
        leftBox.setEditable(true);
        ComboBox<String> rightBox = (ComboBox<String>) scene.lookup("#rightBox");
        rightBox.setEditable(true);

        /*TextField leftTextField = (TextField) scene.lookup("#textField1");
        TextField rightTextField = (TextField) scene.lookup("#textField2");
        Label updateLabel = (Label) scene.lookup("#updateLabel");
        Button updateButton = (Button) scene.lookup("#updateButton");*/

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                ComboBoxes comboBoxes = new ComboBoxes();
                comboBoxes.setBoxInit(leftBox.getSelectionModel().getSelectedItem());
                comboBoxes.setBoxFin(rightBox.getSelectionModel().getSelectedItem());

                ComboBoxUtil.save(comboBoxes);
            }
        });

    }
    public static void main(String[] args) {
        launch(args);
    }
    public String convert(InputStream inputStream, String charset) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        return stringBuilder.toString();
    }
}
