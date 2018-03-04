/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisualization;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * FXML Controller class
 *
 * @author uluc
 */
public class CommentController implements Initializable {

    @FXML
    private TreeView treeView;

    @FXML
    private Label label;

    @FXML
    private RadioButton reSize;

    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    protected HashMap<String, EventNight> days = new HashMap<>();
    public String choosenDay = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reSize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (reSize.isSelected()) {
                    FXMLDocumentController.stage.setWidth(220);
                    FXMLDocumentController.stage.setHeight(70);
                } else {
                    treeView.setDisable(false);
                    FXMLDocumentController.stage.setWidth(400);
                    FXMLDocumentController.stage.setHeight(400);

                }
            }
        });
        fillTreeView(treeView, FXMLDocumentController.allArtists, FXMLDocumentController.allNights, days);
    }

    private void fillTreeView(TreeView<String> treeView, ArrayList<Artist> allArtists, ArrayList<EventNight> allNights, HashMap<String, EventNight> days1) {
        if (FXMLDocumentController.allNights != null) {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 0; i < allNights.size(); i++) {
                days1.put(ft.format(allNights.get(i).getDate()), allNights.get(i));
            }
            //root
            TreeItem<String> rootItem = new TreeItem<String>("Root");
            rootItem.setExpanded(true);

            // all Days            
            TreeItem<String> allDays = new TreeItem<String>("Tüm Günler");
            for (int i = 0; i < allNights.size(); i++) {
                TreeItem<String> itemDay = new TreeItem<String>(ft.format(allNights.get(i).getDate()));
                allDays.getChildren().add(itemDay);
            }

            // Event Types           
            TreeItem<String> EventTypes = new TreeItem<String>("Event Tipine Göre");

            TreeItem<String> type8 = new TreeItem<String>("8 Binlik");
            TreeItem<String> type25 = new TreeItem<String>("25 Binlik");
            TreeItem<String> type40 = new TreeItem<String>("40 Binlik");
            TreeItem<String> type70 = new TreeItem<String>("+70 Binlik");
            TreeItem<String> standartD = new TreeItem<String>("Normal Günler");
            for (int i = 0; i < allNights.size(); i++) {
                TreeItem<String> itemDay = new TreeItem<String>(ft.format(allNights.get(i).getDate()));
                if (allNights.get(i).getEventType().equals("Normal Gün")) {
                    standartD.getChildren().add(itemDay);
                } else if (allNights.get(i).getEventType().equals("8 Binlik")) {
                    type8.getChildren().add(itemDay);
                } else if (allNights.get(i).getEventType().equals("25 Binlik")) {
                    type25.getChildren().add(itemDay);
                } else if (allNights.get(i).getEventType().equals("40 Binlik")) {
                    type40.getChildren().add(itemDay);
                } else if (allNights.get(i).getEventType().equals("+70 Binlik")) {
                    type70.getChildren().add(itemDay);
                }
            }
            EventTypes.getChildren().addAll(type8, type25, type40, type70, standartD);

            //according to Artist
            TreeItem<String> AcArtist = new TreeItem<String>("Artistlere Göre");
            for (int i = 0; i < allArtists.size(); i++) {
                TreeItem<String> artistN = new TreeItem<String>(allArtists.get(i).getArtistName());
                for (int j = 0; j < allArtists.get(i).getNights().size(); j++) {
                    TreeItem<String> artistDay = new TreeItem<String>(ft.format(allArtists.get(i).getNights().get(j).getDate()));
                    artistN.getChildren().add(artistDay);
                }
                AcArtist.getChildren().add(artistN);
            }

            rootItem.getChildren().addAll(allDays, EventTypes, AcArtist);
            treeView.setRoot(rootItem);
            treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        String date = (String) ((TreeItem) treeView.getSelectionModel().getSelectedItem()).getValue();
                        if (days1.containsKey(date)) {
                            choosenDay = date;
                            if (days1.get(date).getArtist()!=null)
                                label.setText("Güne Yorum\n " + ft.format(days1.get(date).getDate()) + "<>" + days1.get(date).getEventType() + "<>" + days1.get(date).getArtist().getArtistName());
                            else 
                                label.setText("Güne Yorum\n " + ft.format(days1.get(date).getDate()) + "<>" + days1.get(date).getEventType() );
                            textArea.setText(days1.get(date).getComment());
                        } else {
                            label.setText("");
                            textArea.setText("");

                        }
                    } catch (Exception e) {

                        System.err.println(e.toString());
                    }
                }
            });
            textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                        days1.get(choosenDay).setComment(textArea.getText());
                    }
                }
            });
            treeView.setShowRoot(false);

        }
    }

}
