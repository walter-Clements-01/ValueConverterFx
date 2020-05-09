package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        stage.setTitle("Convertitore di valuta");
        stage.setScene(new Scene(root, 450, 350));
        stage.show();

        Scene scene = stage.getScene();
        ComboBox<String> leftBox = (ComboBox<String>) scene.lookup("#combo1");
        ComboBox<String> rightBox = (ComboBox<String>) scene.lookup("#combo2");
        TextField leftTextField = (TextField) scene.lookup("#textField1");
        TextField rightTextField = (TextField) scene.lookup("#textField2");
        Label updateLabel = (Label) scene.lookup("#updateLabel");
        Button updateButton = (Button) scene.lookup("#updateButton");

        MainController mainController = new MainController(leftBox,rightBox,leftTextField,rightTextField,updateLabel,updateButton);
        mainController.setComboBoxes();


        /*ArrayList<String> leftList = new ArrayList<>();
        leftList.add("test");
        leftBox.setItems(FXCollections.observableList(leftList));*/

    }
    public static void main(String[] args) {
        launch(args);
    }
}
