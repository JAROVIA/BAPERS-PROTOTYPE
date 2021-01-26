package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //main class extends Application and overrides start()
    @Override
    public void start(Stage stage) throws Exception{
        //setting the title
        stage.setTitle("testin'");

        //the url (path) to the fxml file for the initial page, and load
        String fxmlUrl1 = "/sample/scene1.fxml";
        Parent p1 = FXMLLoader.load(getClass().getResource(fxmlUrl1));

        Scene scene1 = new Scene(p1, 500, 500);

        //set the scene to the window
        stage.setScene(scene1);
        stage.show();
    }

    //to start the app
    public static void main(String[] args) { launch(args); }
}
