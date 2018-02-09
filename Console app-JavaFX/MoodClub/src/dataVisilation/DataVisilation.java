/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisilation;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 *
 * @author ulucf
 */
public class DataVisilation extends Application {
     

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
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
