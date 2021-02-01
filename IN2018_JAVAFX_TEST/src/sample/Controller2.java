package sample;

import MySQLTest.JavaMySQLTest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static MySQLTest.JavaMySQLTest.AddTableToList;

public class Controller2 {
    //get the components in fxml
    @FXML
    private Label text;

    @FXML
    private Label notification;

    @FXML
    private TextField tableName;

    @FXML
    protected void viewAll() throws SQLException {
        ArrayList<String[]> data = new ArrayList<>();

        //get all the db data as ArrayList<String[]>
        //data is the variable for the information in the database
        //ArrayList for all rows and String[] for all columns

        String t5 = tableName.getText();
        data = JavaMySQLTest.AddTableToList(t5);

        //apparently string builder is better than += concatenation
        StringBuilder str = new StringBuilder();
        for(String[] column : data){
            for(String value : column) {
                str.append(value).append(" ");
            }
            str.append("\n");
        }

        text.setText(str.toString());
        if(!str.toString().equals("")) {
            setNotification("success, data showing");
        }
        else{
            setNotification("error");
        }
    }

    @FXML
    private void switchToScene() throws IOException {
        String fxmlUrl1 = "/sample/scene1.fxml";
        try {
            Parent p1 = FXMLLoader.load(getClass().getResource(fxmlUrl1));
            Scene scene1 = new Scene(p1, 500, 500);

            Stage stage = (Stage) text.getScene().getWindow();
            stage.setScene(scene1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setNotification(String note){
        notification.setText(note);
    }
}
