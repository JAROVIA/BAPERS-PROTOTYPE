package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller1 {
    //get all the components in the fxml
    @FXML
    private GridPane scene1;

    @FXML
    private TextField tableName;

    @FXML
    private TextField row1;

    @FXML
    private TextField row2;

    @FXML
    private TextField row3;

    @FXML
    private TextField row4;

    @FXML
    private Label notification;

    @FXML
    private void setNotification(String note){
        notification.setText(note);
    }

    @FXML
    private void switchToScene() throws IOException {
        String fxmlUrl2 = "/sample/scene2.fxml";
        try {
            //load the other page
            Parent p2 = FXMLLoader.load(getClass().getResource(fxmlUrl2));
            Scene scene2 = new Scene(p2, 500, 500);
            //could be any component, just to reference the window to switch scene
            Stage stage = (Stage) scene1.getScene().getWindow();
            stage.setScene(scene2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void insert(){
        // number of text fields for some use
        String t5 = tableName.getText();
        String t1 = row1.getText();
        String t2 = row2.getText();
        String t3 = row3.getText();
        String t4 = row4.getText();

        boolean success = false;
        //
        // TODO - insert to table here
        //

        // success = if insert was successful
        if(success){
            setNotification("success");
        }
        else{
            setNotification("error inserting");
        }
    }
}

