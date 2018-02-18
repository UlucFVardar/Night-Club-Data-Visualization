package dataVisualization;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author ulucf
 */
public class DataVisualization extends Application {    
    @Override
    public void start(Stage stage) throws Exception {     
        FXMLLoader fXMLLoader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLDocumentController FXMLDocumentController = (FXMLDocumentController) fXMLLoader.getController();
        Scene scene = new Scene(root);     
        stage.setTitle("Night Club");                     
        scene.getStylesheets().add("/styles/Styles.css");      
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        //stage.initStyle(StageStyle.UNDECORATED);      
        stage.setScene(scene);
        stage.sizeToScene();
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
