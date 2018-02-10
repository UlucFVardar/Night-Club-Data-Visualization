/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisilation;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


/**
 *
 * @author ulucf
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private DatePicker DailyCheckDateStart;

    @FXML
    private MenuItem addnightexcel;
    @FXML
    private DatePicker DailyCheckDateEnd;
    @FXML
    private StackedBarChart<?, ?> stachChart11;

    @FXML
    private DatePicker datePiccerForDaylyCiro;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label datePiccerLabelForDaylyCiro1;

    @FXML
    private Label DailyTurnoverDistributionLabel1;

    @FXML
    private LineChart<?, ?> DailyCheckLine;

    @FXML
    private AnchorPane asd;

    @FXML
    private StackedBarChart<?, ?> dailyCheckStack;

    @FXML
    private TabPane gunlukCiroTabPane;

    @FXML
    private StackedBarChart<?, ?> stachChart111;

    @FXML
    private PieChart DailyTurnoverDistribution;

    @FXML
    private PieChart DailyTurnoverDistribution1;

    @FXML
    private Label datePiccerLabelForDaylyCiro;

    @FXML
    private Label DailyTurnoverDistributionLabel;

    @FXML
    private DatePicker datePiccerForDaylyCiro1;
    private double xOffset = 0;
    private double yOffset = 0;

    public FXMLDocumentController() {

        this.deneme = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("sadasda");
            }
        };

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pair<String, Integer>[] CiroDistiribution = new Pair[3];
        CiroDistiribution[0] = new Pair("Alkol", -14);
        CiroDistiribution[1] = new Pair("Sigara", 50);
        CiroDistiribution[2] = new Pair("Bİlet", 33);
        datePiccerForDaylyCiro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = datePiccerForDaylyCiro.getValue();
                datePiccerLabelForDaylyCiro.setText(date.toString());
                creatPieChart(DailyTurnoverDistribution, CiroDistiribution, "Günlük Ciro Dağılımı"); //gönderilen veriler basten alınıyor //o tarihte bir gece var ise 
                DailyTurnoverDistributionLabel.setText("");
                DailyTurnoverDistributionLabel.setTextFill(Color.DIMGREY);
                DailyTurnoverDistributionLabel.setStyle("-fx-font: 24 arial;");
                for (final PieChart.Data data : DailyTurnoverDistribution.getData()) {
                    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                            new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            DailyTurnoverDistributionLabel.setLayoutX(e.getSceneX() - 30);
                            DailyTurnoverDistributionLabel.setLayoutY(e.getSceneY() - 60);
                            DailyTurnoverDistributionLabel.setText(String.valueOf(data.getPieValue()) + " TL");
                        }
                    });
                }
            }
        });
        DailyCheckDateEnd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (compareDates(DailyCheckDateEnd.getValue(), DailyCheckDateStart.getValue())) {
                    System.out.print("evet büyük");
                    drawStackChartBetweenDateswithInputs(dailyCheckStack, DailyCheckDateEnd.getValue(), DailyCheckDateStart.getValue());
                }

            }

        });
          addnightexcel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser chooser = new FileChooser();
                chooser.setInitialDirectory(new File("src"));
                chooser.setTitle("Open File");
                Stage stage = new Stage();
                File file = chooser.showOpenDialog(stage);
                if (file == null) {
                    return;
                }
                
                try {
                    myExcelFile allNights = new myExcelFile( file.getAbsolutePath() );
                    System.out.println("aldım");
                    
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            }
        });
    

    }
    public EventHandler<ActionEvent> deneme;

    private void creatPieChart(PieChart DailyTurnoverDistribution, Pair<String, Integer>[] inputPair, String porpuse) {
        ObservableList<PieChart.Data> datos = FXCollections.observableArrayList();
        for (int i = 0; i < inputPair.length; i++) {
            datos.add(new PieChart.Data(inputPair[i].getKey(), inputPair[i].getValue()));
        }
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        DailyTurnoverDistribution.setData(datos);
        DailyTurnoverDistribution.setTitle(porpuse);
    }

    private void drawStackChartBetweenDateswithInputs(StackedBarChart<?, ?> dailyCheckStack, LocalDate endDate, LocalDate startDate) {
        StackedBarChart<String, Number> sbc = (StackedBarChart<String, Number>) dailyCheckStack;
        sbc.getData().clear();
        int dayNumber = endDate.getDayOfYear() - startDate.getDayOfYear() + 1;
        ArrayList<String> cloumns = new ArrayList<>();
        for (int i = 0; i < dayNumber; i++) {
            cloumns.add(startDate.plusDays(i).toString());
        }
        CategoryAxis xAxis = (CategoryAxis) dailyCheckStack.getXAxis();
        NumberAxis yAxis = (NumberAxis) dailyCheckStack.getYAxis();
        xAxis.getCategories().clear();

        XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
        xAxis.setLabel("Günler");
        xAxis.setCategories(FXCollections.<String>observableArrayList((cloumns)));
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Value");
        series1.setName("Alkoller");
        series2.setName("Bilet");
        series3.setName("Sigara");

        for (int i = 0; i < dayNumber; i++) {
            series1.getData().add(new XYChart.Data<String, Number>(cloumns.get(i), 25601.34 + Math.random() * 1000));
            series2.getData().add(new XYChart.Data<String, Number>(cloumns.get(i), -12415));
            series3.getData().add(new XYChart.Data<String, Number>(cloumns.get(i), 45000.65));
        }

        sbc.getData().addAll(series1, series2, series3);
    }

    public boolean compareDates(LocalDate FirstDate, LocalDate otherDate) {
        int cmp = (FirstDate.getYear() - otherDate.getYear());
        if (cmp == 0) {
            cmp = (FirstDate.getDayOfYear() - otherDate.getDayOfYear());
        }
        if (cmp >= 0)//first date is bigger
        {
            return true;
        } else {
            return false;
        }
    }
}
