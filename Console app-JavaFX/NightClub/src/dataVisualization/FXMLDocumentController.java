/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisualization;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.input.ContextMenuEvent;
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

    @FXML // fx:id="endexSmaller"
    private RadioButton endexSmaller; // Value injected by FXMLLoader

    @FXML // fx:id="anomaliesStack"
    private StackedBarChart<?, ?> anomaliesStack; // Value injected by FXMLLoader

    @FXML // fx:id="allNightTableView"
    private TableView allNightTableView; // Value injected by FXMLLoader

    @FXML // fx:id="artistCostColumn"
    private TableColumn<?, ?> artistCostColumn; // Value injected by FXMLLoader

    @FXML
    private Label informationLabelDay;

    @FXML
    private Label informationLabelType;

    @FXML
    private Label informationLabelName;

    @FXML
    private Label informationLabelAnomolies;

    @FXML
    private Button showDeeply, showDeeply1, showDeeply2, showDeeply3;

    @FXML // fx:id="discountColumn"
    private TableColumn<?, ?> discountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="evaluationByDayBtn"
    private Button evaluationByDayBtn; // Value injected by FXMLLoader

    @FXML // fx:id="evaluationByDayEnd"
    private DatePicker evaluationByDayEnd; // Value injected by FXMLLoader

    @FXML // fx:id="lineChartByArtist"
    private LineChart<?, ?> lineChartByArtist; // Value injected by FXMLLoader

    @FXML // fx:id="giroEColumn"
    private TableColumn<?, ?> giroEColumn; // Value injected by FXMLLoader

    @FXML // fx:id="treatColumn"
    private TableColumn<?, ?> treatColumn; // Value injected by FXMLLoader

    @FXML // fx:id="giroColumn"
    private TableColumn<?, ?> giroColumn; // Value injected by FXMLLoader

    @FXML // fx:id="salesSmaller"
    private RadioButton salesSmaller; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn111"
    private TableColumn<?, ?> eventColumn111; // Value injected by FXMLLoader

    @FXML // fx:id="treatSmaller"
    private RadioButton treatSmaller; // Value injected by FXMLLoader

    @FXML // fx:id="evaluationByDayGiroCheck"
    private CheckBox evaluationByDayGiroCheck; // Value injected by FXMLLoader

    @FXML // fx:id="thirdDegree"
    private MenuItem thirdDegree; // Value injected by FXMLLoader

    @FXML // fx:id="dailyProfitValue"
    private Label dailyProfitValue; // Value injected by FXMLLoader

    @FXML // fx:id="DailyTurnoverDistributionLabel"
    private Label DailyTurnoverDistributionLabel; // Value injected by FXMLLoader

    @FXML // fx:id="moneyMoventColumn"
    private TableColumn<?, ?> moneyMoventColumn; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn11"
    private TableColumn<?, ?> eventColumn11; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn12"
    private TableColumn<?, ?> eventColumn12; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn13"
    private TableColumn<?, ?> eventColumn13; // Value injected by FXMLLoader

    @FXML // fx:id="distributionByArtists"
    private Button distributionByArtists; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn14"
    private TableColumn<?, ?> eventColumn14; // Value injected by FXMLLoader

    @FXML // fx:id="totalCostColumn"
    private TableColumn<?, ?> totalCostColumn; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn15"
    private TableColumn<?, ?> eventColumn15; // Value injected by FXMLLoader

    @FXML // fx:id="giroLabel"
    private Label giroLabel; // Value injected by FXMLLoader

    @FXML // fx:id="evelation"
    private CategoryAxis evelation; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn16"
    private TableColumn<?, ?> eventColumn16; // Value injected by FXMLLoader

    @FXML // fx:id="DailyProfitDistiribution"
    private PieChart DailyProfitDistiribution; // Value injected by FXMLLoader

    @FXML // fx:id="distributionByArtistsEnd"
    private DatePicker distributionByArtistsEnd; // Value injected by FXMLLoader

    @FXML // fx:id="eventLabel1"
    private Label eventLabel1; // Value injected by FXMLLoader

    @FXML // fx:id="sumOfDiscountColumn"
    private TableColumn<?, ?> sumOfDiscountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="endexColumn"
    private TableColumn<?, ?> endexColumn; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn121"
    private TableColumn<?, ?> eventColumn121; // Value injected by FXMLLoader

    @FXML // fx:id="lastDegree"
    private MenuItem lastDegree; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn131"
    private TableColumn<?, ?> eventColumn131; // Value injected by FXMLLoader

    @FXML // fx:id="distributionByArtistsStackChart"
    private StackedBarChart<?, ?> distributionByArtistsStackChart; // Value injected by FXMLLoader

    @FXML // fx:id="DailyTurnoverDistribution"
    private PieChart DailyTurnoverDistribution; // Value injected by FXMLLoader

    @FXML // fx:id="dateColumn"
    private TableColumn<?, ?> dateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="profitColumn"
    private TableColumn<?, ?> profitColumn; // Value injected by FXMLLoader

    @FXML // fx:id="borderpane"
    private BorderPane borderpane; // Value injected by FXMLLoader

    @FXML // fx:id="evaluationByDayStart"
    private DatePicker evaluationByDayStart; // Value injected by FXMLLoader

    @FXML // fx:id="distributionByArtistsSplitMenu"
    private SplitMenuButton distributionByArtistsSplitMenu; // Value injected by FXMLLoader

    @FXML // fx:id="evaluationByDayProfitCheck"
    private CheckBox evaluationByDayProfitCheck; // Value injected by FXMLLoader

    @FXML // fx:id="datePiccerForDaylyProfit"
    private DatePicker datePiccerForDaylyProfit; // Value injected by FXMLLoader

    @FXML // fx:id="distiributionByNameCheckGiro"
    private CheckBox distiributionByNameCheckGiro; // Value injected by FXMLLoader

    @FXML // fx:id="bottleColumn"
    private TableColumn<?, ?> bottleColumn; // Value injected by FXMLLoader

    @FXML // fx:id="distributionByArtistsCheckGiro"
    private CheckBox distributionByArtistsCheckGiro; // Value injected by FXMLLoader

    @FXML // fx:id="salesColumn"
    private TableColumn<?, ?> salesColumn; // Value injected by FXMLLoader

    @FXML // fx:id="distiributionByNameCheckProfit"
    private CheckBox distiributionByNameCheckProfit; // Value injected by FXMLLoader

    @FXML // fx:id="addnightexcel"
    private MenuItem addnightexcel; // Value injected by FXMLLoader

    @FXML // fx:id="datePiccerLabelForDaylyCiro"
    private Label datePiccerLabelForDaylyCiro; // Value injected by FXMLLoader

    @FXML // fx:id="distributionByArtistsCheckProfit"
    private CheckBox distributionByArtistsCheckProfit; // Value injected by FXMLLoader

    @FXML // fx:id="eventColumn"
    private TableColumn<?, ?> eventColumn; // Value injected by FXMLLoader

    @FXML // fx:id="datePiccerLabelForDaylyProfit"
    private Label datePiccerLabelForDaylyProfit; // Value injected by FXMLLoader

    @FXML // fx:id="distributionByArtistsStart"
    private DatePicker distributionByArtistsStart; // Value injected by FXMLLoader

    @FXML // fx:id="datePiccerForDaylyCiro"
    private DatePicker datePiccerForDaylyCiro; // Value injected by FXMLLoader

    @FXML // fx:id="anomaliesLine"
    private LineChart<?, ?> anomaliesLine; // Value injected by FXMLLoader

    @FXML // fx:id="dontPayColumn"
    private TableColumn<?, ?> dontPayColumn; // Value injected by FXMLLoader

    @FXML // fx:id="discountSmaller"
    private RadioButton discountSmaller; // Value injected by FXMLLoader

    @FXML // fx:id="firstDegree"
    private MenuItem firstDegree; // Value injected by FXMLLoader

    @FXML // fx:id="tipColumn"
    private TableColumn<?, ?> tipColumn; // Value injected by FXMLLoader

    @FXML // fx:id="drunkColumn"
    private TableColumn<?, ?> drunkColumn; // Value injected by FXMLLoader

    @FXML // fx:id="distiributionByName"
    private Button distiributionByName; // Value injected by FXMLLoader

    @FXML // fx:id="evalutionByDayStackChart"
    private StackedBarChart<?, ?> evalutionByDayStackChart; // Value injected by FXMLLoader

    @FXML // fx:id="eventLabel"
    private Label eventLabel; // Value injected by FXMLLoader

    @FXML // fx:id="DailyCheckLine"
    private LineChart<?, ?> DailyCheckLine; // Value injected by FXMLLoader

    @FXML // fx:id="moneyMovementSmaller"
    private RadioButton moneyMovementSmaller; // Value injected by FXMLLoader

    @FXML // fx:id="distirubitonByNameStackChart"
    private StackedBarChart<?, ?> distirubitonByNameStackChart; // Value injected by FXMLLoader

    @FXML // fx:id="distiributionByNameSplitMenu"
    private SplitMenuButton distiributionByNameSplitMenu; // Value injected by FXMLLoader

    @FXML // fx:id="groupEntryColumn"
    private TableColumn<?, ?> groupEntryColumn; // Value injected by FXMLLoader

    @FXML // fx:id="asd"
    private AnchorPane asd; // Value injected by FXMLLoader

    @FXML // fx:id="profitLabel"
    private Label profitLabel; // Value injected by FXMLLoader

    @FXML // fx:id="secondDegree"
    private MenuItem secondDegree; // Value injected by FXMLLoader

    @FXML // fx:id="distiributionByNameEnd"
    private DatePicker distiributionByNameEnd; // Value injected by FXMLLoader

    @FXML // fx:id="gunlukCiroTabPane"
    private TabPane gunlukCiroTabPane; // Value injected by FXMLLoader

    @FXML // fx:id="distiributionByNameStart"
    private DatePicker distiributionByNameStart; // Value injected by FXMLLoader

    @FXML // fx:id="lineChartByName"
    private LineChart<?, ?> lineChartByName; // Value injected by FXMLLoader

    @FXML
    private TitledPane allNight;

    @FXML
    private Accordion accordion;
    @FXML
    private TabPane tabPane;

    public boolean oneItemSelected = false;
    public String clickedDate = "";
    protected ArrayList<Artist> allArtists = null;
    protected ArrayList<EventNight> allNights = null;
    protected HashMap<String, Double> unitCosts = null;
    protected HashMap<String, Double> unitSalesPrice = null;
    protected String[] columnMapKeys = {"Tarih", "Event Tipi", "comingPeople", "Ciro", "Kar", "Tip", "Ödenmez", "Grup Girişi",
        "Artist Cost", "total Cost", "Şişe Sayısı", "Toplam İndirim", "general Endex", "Altol Tüketim E.",
        "70clSales", "35clSales", "confettiSales", "cigaretSales", "glassSales", "70clTreat", "35clTreat",
        "confettiTreat", "cigaretTreat", "glassTreat"};

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
        showDeeply.setOnAction(intent);
        showDeeply1.setOnAction(intent);
        showDeeply2.setOnAction(intent);
        showDeeply3.setOnAction(intent);
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                oneItemSelected = false;
                showDeeply.setDisable(!oneItemSelected);
                showDeeply1.setDisable(!oneItemSelected);
                showDeeply2.setDisable(!oneItemSelected);
                showDeeply3.setDisable(!oneItemSelected);

            }
        }
        );
        datePiccerForDaylyCiro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = datePiccerForDaylyCiro.getValue();
                for (int i = 0; i < allNights.size(); i++) {
                    Date dNow = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                    if (ft.format(allNights.get(i).getDate()).toString().equals(date.toString())) {
                        datePiccerLabelForDaylyCiro.setText(date.toString()); //allNights.get(i)
                        creatPieChart(DailyTurnoverDistribution, allNights.get(i).getNameOfSales(), allNights.get(i).getGainOfSales(), "Günlük Ciro Dağılımı"); //gönderilen veriler basten alınıyor //o tarihte bir gece var ise 
                        giroLabel.setText("Toplam Ciro : " + allNights.get(i).getEndorsement());
                        if (allNights.get(i).getArtist() == null) {
                            eventLabel.setText("Sanatçısız gün");
                        } else {
                            eventLabel.setText("Event : " + allNights.get(i).getArtist().getArtistName());
                        }
                        break;
                    } else if (i == allNights.size() - 1) {
                        datePiccerLabelForDaylyCiro.setText("Bu tarih için veri yok!");
                        clearPieChar(DailyTurnoverDistribution);
                        giroLabel.setText("");
                        eventLabel.setText("");
                    }
                }
                DailyTurnoverDistributionLabel.setText("");
                DailyTurnoverDistributionLabel.setTextFill(Color.DIMGREY);
                DailyTurnoverDistributionLabel.setStyle("-fx-font: 20 arial;");
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
        addnightexcel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser chooser = new FileChooser();
                chooser.setInitialDirectory(new File("."));
                chooser.setTitle("Open File");
                Stage stage = new Stage();
                File file = chooser.showOpenDialog(stage);
                if (file == null) {
                    return;
                }
                try {
                    myExcelFile Data = new myExcelFile(file.getAbsolutePath());
                    unitCosts = readUnitCostFromExcel(Data);
                    unitSalesPrice = readUnitSalesPriceFromExcel(Data);
                    allNights = creatAllNightsFromExcel(Data, unitCosts, unitSalesPrice);
                    /*
                        for (int i = 0; i < allNights.size(); i++) 
                            System.out.println(allNights.get(i));                   
                     */
                    for (int i = 0; i < allArtists.size(); i++) {
                        MenuItem item = new MenuItem(allArtists.get(i).getArtistName());
                        item.setOnAction(myHandler);
                        distiributionByNameSplitMenu.getItems().add(item);
                    }
                    ObservableList columns = allNightTableView.getColumns();
                    int size = columns.size();
                    int k = 0;
                    for (int i = 0; i < size; i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        //System.out.println("adı>>>"+c.getText()+", kontorl>>"+ (c.getColumns().size()!=0) );
                        if (c.getColumns().size() != 0) {
                            int size2 = c.getColumns().size();
                            ObservableList<TableColumn<String, ?>> columns1 = c.getColumns();
                            for (int j = 0; j < size2; j++) {
                                columns1.get(j).setCellValueFactory(new MapValueFactory(columnMapKeys[k]));
                                k++;
                            }
                        } else {
                            c.setCellValueFactory(new MapValueFactory(columnMapKeys[k]));
                            k++;
                        }
                    }
                    allNightTableView.setEditable(false);
                    allNightTableView.getSelectionModel().setCellSelectionEnabled(false);
                    allNightTableView.setItems(generateDataInMap());
                    findAndDrawAnomalies(allNights, anomaliesStack, anomaliesLine);

                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        datePiccerForDaylyProfit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate date = datePiccerForDaylyProfit.getValue();
                for (int i = 0; i < allNights.size(); i++) {
                    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                    if (ft.format(allNights.get(i).getDate()).toString().equals(date.toString())) {
                        datePiccerLabelForDaylyProfit.setText(date.toString()); //allNights.get(i)
                        creatPieChart(DailyProfitDistiribution, allNights.get(i).getNameOfSales(), allNights.get(i).getProfitOfSales(), "Günlük Ciro Dağılımı"); //gönderilen veriler basten alınıyor //o tarihte bir gece var ise 
                        profitLabel.setText("Toplam Kar : " + allNights.get(i).getProfit());
                        if (allNights.get(i).getArtist() == null) {
                            eventLabel1.setText("Sanatçısız gün");
                        } else {
                            eventLabel1.setText("Event : " + allNights.get(i).getArtist().getArtistName());
                        }
                        break;
                    } else if (i == allNights.size() - 1) {
                        datePiccerLabelForDaylyProfit.setText("Bu tarih için veri yok!");
                        clearPieChar(DailyProfitDistiribution);
                        profitLabel.setText("");
                        eventLabel1.setText("");
                    }
                }
                dailyProfitValue.setText("");
                dailyProfitValue.setTextFill(Color.DIMGREY);
                dailyProfitValue.setStyle("-fx-font: 20 arial;");
                for (final PieChart.Data data : DailyProfitDistiribution.getData()) {
                    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                            new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            dailyProfitValue.setLayoutX(e.getSceneX() - 30);
                            dailyProfitValue.setLayoutY(e.getSceneY() - 60);
                            dailyProfitValue.setText(String.valueOf(data.getPieValue()) + " TL");
                        }
                    });
                }
            }
        });
        evaluationByDayGiroCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                evaluationByDayProfitCheck.setSelected(false);
            }
        });
        evaluationByDayProfitCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                evaluationByDayGiroCheck.setSelected(false);
            }
        });
        evaluationByDayBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (allNights != null && evaluationByDayStart.getValue() != null && evaluationByDayEnd.getValue() != null) {
                    //
                    String names[] = EventNight.getNamesOfSaledElements();
                    ArrayList<double[]> giro = new ArrayList<>();
                    ArrayList<Date> dates = new ArrayList<>();
                    ArrayList<double[]> profit = new ArrayList<>();
                    ArrayList<Double> sumOfProfit = new ArrayList<>();
                    ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

                    //if user select longer then one year there will be a problem
                    int dayNumber = evaluationByDayEnd.getValue().getDayOfYear() - evaluationByDayStart.getValue().getDayOfYear() + 1;
                    for (int i = 0; i < dayNumber; i++) {
                        for (int j = 0; j < allNights.size(); j++) {
                            if (compareDatesLocalandNormalDate(evaluationByDayStart.getValue().plusDays(i), allNights.get(j).getDate())) {
                                giro.add(allNights.get(j).getGainOfSales());
                                dates.add(allNights.get(j).getDate());
                                profit.add(allNights.get(j).getProfitOfSales());
                                sumOfProfit.add(allNights.get(j).getProfit());
                                endex.add(new Pair<Double, Double>(allNights.get(j).getAlcoholConsumption(), allNights.get(j).getEndex()));
                                break;
                            }
                        }
                    }
                    names = EventNight.getNamesOfSaledElements();
                    drawLineChart(DailyCheckLine, dates, EventNight.getNamesOfEndex(), endex);

                    if (evaluationByDayGiroCheck.isSelected()) {
                        drawStackChartBetweenDateswithInputs(evalutionByDayStackChart, dates, names, giro, null, informationLabelDay);
                    } else if (evaluationByDayProfitCheck.isSelected()) {
                        drawStackChartBetweenDateswithInputs(evalutionByDayStackChart, dates, names, profit, sumOfProfit, informationLabelDay);
                    }
                }
            }
        });
        distributionByArtists.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (allNights != null && distributionByArtistsEnd.getValue() != null && distributionByArtistsStart.getValue() != null) {
                    String names[] = EventNight.getNamesOfSaledElements();
                    ArrayList<double[]> giro = new ArrayList<>();
                    ArrayList<Date> dates = new ArrayList<>();
                    ArrayList<double[]> profit = new ArrayList<>();
                    ArrayList<Double> sumOfProfit = new ArrayList<>();
                    ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

                    //if user select longer then one year there will be a problem
                    int dayNumber = distributionByArtistsEnd.getValue().getDayOfYear() - distributionByArtistsStart.getValue().getDayOfYear() + 1;
                    for (int i = 0; i < dayNumber; i++) {
                        for (int j = 0; j < allNights.size(); j++) {
                            if (compareDatesLocalandNormalDate(distributionByArtistsStart.getValue().plusDays(i), allNights.get(j).getDate())
                                    && allNights.get(j).getEventType().toString().equals(distributionByArtistsSplitMenu.getText().toString().trim())) {
                                giro.add(allNights.get(j).getGainOfSales());
                                dates.add(allNights.get(j).getDate());
                                profit.add(allNights.get(j).getProfitOfSales());
                                sumOfProfit.add(allNights.get(j).getProfit());
                                endex.add(new Pair<Double, Double>(allNights.get(j).getAlcoholConsumption(), allNights.get(j).getEndex()));

                                break;
                            }
                        }
                    }
                    drawLineChart(lineChartByArtist, dates, EventNight.getNamesOfEndex(), endex);

                    names = EventNight.getNamesOfSaledElements();
                    if (distributionByArtistsCheckGiro.isSelected()) {
                        drawStackChartBetweenDateswithInputs(distributionByArtistsStackChart, dates, names, giro, null, informationLabelType);
                    } else if (distributionByArtistsCheckProfit.isSelected()) {
                        drawStackChartBetweenDateswithInputs(distributionByArtistsStackChart, dates, names, profit, sumOfProfit, informationLabelType);
                    }
                }
            }
        });
        firstDegree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distributionByArtistsSplitMenu.setText(firstDegree.getText());
            }
        });
        secondDegree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distributionByArtistsSplitMenu.setText(secondDegree.getText());
            }
        });
        thirdDegree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distributionByArtistsSplitMenu.setText(thirdDegree.getText());
            }
        });
        lastDegree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distributionByArtistsSplitMenu.setText(lastDegree.getText());
            }
        });
        distributionByArtistsCheckGiro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distributionByArtistsCheckProfit.setSelected(false);
            }
        });
        distributionByArtistsCheckProfit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distributionByArtistsCheckGiro.setSelected(false);
            }
        });
        distiributionByNameCheckGiro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distiributionByNameCheckProfit.setSelected(false);
            }
        });
        distiributionByNameCheckProfit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                distiributionByNameCheckGiro.setSelected(false);
            }
        });
        distiributionByName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (allArtists != null && distiributionByNameEnd != null && distiributionByNameStart != null) {
                    String names[] = EventNight.getNamesOfSaledElements();
                    ArrayList<double[]> giro = new ArrayList<>();
                    ArrayList<Date> dates = new ArrayList<>();
                    ArrayList<double[]> profit = new ArrayList<>();
                    ArrayList<Double> sumOfProfit = new ArrayList<>();
                    ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

                    //if user select longer then one year there will be a problem
                    int dayNumber = distiributionByNameEnd.getValue().getDayOfYear() - distiributionByNameStart.getValue().getDayOfYear() + 1;
                    for (int i = 0; i < allArtists.size(); i++) {
                        if (distiributionByNameSplitMenu.getText().equalsIgnoreCase(allArtists.get(i).getArtistName())) {
                            //i. index has the artist that user select
                            for (int d = 0; d < dayNumber; d++) {
                                for (int aDay = 0; aDay < allArtists.get(i).getNights().size(); aDay++) {
                                    if (compareDatesLocalandNormalDate(distiributionByNameStart.getValue().plusDays(d), allArtists.get(i).getNights().get(aDay).getDate())) {
                                        giro.add(allArtists.get(i).getNights().get(aDay).getGainOfSales());
                                        dates.add(allArtists.get(i).getNights().get(aDay).getDate());
                                        profit.add(allArtists.get(i).getNights().get(aDay).getProfitOfSales());
                                        sumOfProfit.add(allArtists.get(i).getNights().get(aDay).getProfit());
                                        endex.add(new Pair<Double, Double>(allArtists.get(i).getNights().get(aDay).getAlcoholConsumption(), allArtists.get(i).getNights().get(aDay).getEndex()));

                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    drawLineChart(lineChartByName, dates, EventNight.getNamesOfEndex(), endex);
                    names = EventNight.getNamesOfSaledElements();
                    if (distiributionByNameCheckGiro.isSelected()) {
                        drawStackChartBetweenDateswithInputs(distirubitonByNameStackChart, dates, names, giro, null, informationLabelName);
                    } else if (distiributionByNameCheckProfit.isSelected()) {
                        drawStackChartBetweenDateswithInputs(distirubitonByNameStackChart, dates, names, profit, sumOfProfit, informationLabelName);
                    }
                }
            }
        });
        moneyMovementSmaller.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (moneyMovementSmaller.isSelected()) {
                    ObservableList columns = moneyMoventColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = moneyMoventColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(40 + (i) * 10);
                    }
                }
            }
        });
        discountSmaller.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (discountSmaller.isSelected()) {
                    ObservableList columns = discountColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = discountColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(100);
                    }
                }
            }
        });
        endexSmaller.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (endexSmaller.isSelected()) {
                    ObservableList columns = endexColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = endexColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(75);
                    }
                }
            }
        });
        treatSmaller.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treatSmaller.isSelected()) {
                    ObservableList columns = treatColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = treatColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(70);
                    }
                }
            }
        });
        salesSmaller.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (salesSmaller.isSelected()) {
                    ObservableList columns = salesColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = salesColumn.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(75);
                    }
                }
            }
        });
    }
    public EventHandler<ActionEvent> deneme;
    public EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent event) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            distiributionByNameSplitMenu.setText(selectedItem.getText().toString());
        }
    };
    public EventHandler<ActionEvent> intent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            accordion.setExpandedPane(allNight);
            SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");
            allNightTableView.setStyle(" -fx-background-color: #005797;" +
                                        "-fx-background-insets: 0;" +
                                        "-fx-background-radius: 1;" +
                                        "-selected-color: #21D900;" +
                                        "-fx-text-fill: Black;");

            for( int i=0 ;i< allNightTableView.getItems().size() ; i++ ){            
                Map<String, String> map=(Map<String, String>) allNightTableView.getItems().get(i);
                if( map.get("Tarih").equals(clickedDate)){
                    allNightTableView.getSelectionModel().select(i);
                    
                    break;
                }
            }
           
        }
    };

    private HashMap<String, Double> readUnitCostFromExcel(myExcelFile Data) {
        HashMap<String, Double> r = new HashMap<String, Double>();
        for (int i = 9; i <= 15; i++) {
            String location1 = "A" + i;
            String location2 = "B" + i;
            r.put(Data.get(location1, 0).toString(), (Double) Data.get(location2, 0));
        }

        return r;
    }

    private ArrayList<EventNight> creatAllNightsFromExcel(myExcelFile Data, HashMap<String, Double> unitCosts, HashMap<String, Double> unitSalesPrice) {
        ArrayList<EventNight> e = new ArrayList<>();
        String artistName = "";
        int size = Data.getSheetSize();
        for (int i = 1; i < size; i++) {
            artistName = "";
            Date date = (Date) Data.get("E22", i);
            Pair<Integer, Integer> p = new Pair((int) ((double) Data.get("B3", i) / 1), (int) ((double) Data.get("B4", i) / 1));

            EventNight eN = new EventNight((Date) date,
                    (double) Data.get("G15", i),
                    (double) Data.get("J13", i),
                    (int) ((double) Data.get("J14", i) / 1),
                    (double) Data.get("J18", i),
                    (double) Data.get("F18", i),
                    p,
                    (int) ((double) Data.get("C3", i) / 1));
            eN.setSalesOfNight((int) ((double) Data.get("E4", i) / 1),
                    (int) ((double) Data.get("F4", i) / 1),
                    (int) ((double) Data.get("E10", i) / 1),
                    (int) ((double) Data.get("E7", i) / 1),
                    (int) ((double) Data.get("J5", i) / 1));
            eN.setIkramOfNight((int) ((double) Data.get("G4", i) / 1),
                    (int) ((double) Data.get("H4", i) / 1),
                    (int) ((double) Data.get("G7", i) / 1));

            artistName = Data.get("B21", i).toString().split(":")[1].trim();
            if (!artistName.equals("")) {
                Artist newArtist = new Artist(artistName, (double) Data.get("E18", i), eN);
                if (allArtists == null) {
                    allArtists = new ArrayList<>();
                    allArtists.add(newArtist);
                } else {
                    boolean flag = false;
                    for (int k = 0; k < allArtists.size(); k++) {
                        if (allArtists.get(k).getArtistName().equalsIgnoreCase(artistName)) {
                            flag = true;
                            allArtists.get(k).addNight(eN);
                            allArtists.get(k).addCost((double) Data.get("E18", i));
                            newArtist = allArtists.get(k);
                            break;
                        }
                    }
                    if (!flag) {
                        allArtists.add(newArtist);
                    }
                }
                eN.setArtist(newArtist, (double) Data.get("E18", i));
            }

            e.add(eN);

        }
        for (int i = 0; i < e.size(); i++) {
            e.get(i).calculateEndorsement_and_Profit(unitSalesPrice, unitCosts);
        }

        return e;
    }

    private HashMap<String, Double> readUnitSalesPriceFromExcel(myExcelFile Data) {
        HashMap<String, Double> r = new HashMap<String, Double>();
        for (int i = 9; i <= 15; i++) {
            String location1 = "A" + i;
            String location2 = "C" + i;
            r.put((String) Data.get(location1, 0), (Double) Data.get(location2, 0));
        }

        return r;
    }

    private void clearPieChar(PieChart DailyTurnoverDistribution) {
        ObservableList<PieChart.Data> datos = FXCollections.observableArrayList();
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        DailyTurnoverDistribution.setData(datos);
        DailyTurnoverDistribution.setTitle("Veri yok");
    }

    private void creatPieChart(PieChart DailyTurnoverDistribution, String[] names, double[] values, String porpuse) {
        ObservableList<PieChart.Data> datos = FXCollections.observableArrayList();
        for (int i = 0; i < values.length; i++) {
            datos.add(new PieChart.Data(names[i], values[i]));
        }
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        DailyTurnoverDistribution.setData(datos);
        DailyTurnoverDistribution.setTitle(porpuse);
    }

    private void drawStackChartBetweenDateswithInputs(StackedBarChart<?, ?> stackChart, ArrayList<Date> dates, String[] names, ArrayList<double[]> values, ArrayList<Double> sumofP, Label l) {
        StackedBarChart<String, Number> sbc = (StackedBarChart<String, Number>) stackChart;
        sbc.getData().clear();
        ArrayList<String> cloumns = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            cloumns.add(ft.format(dates.get(i)).toString());
        }
        CategoryAxis xAxis = (CategoryAxis) sbc.getXAxis();
        NumberAxis yAxis = (NumberAxis) sbc.getYAxis();
        // xAxis.setTickLabelRotation(90);        
        xAxis.getCategories().clear();
        XYChart.Series<String, Number>[] series;
        if (sumofP == null) {
            series = new XYChart.Series[names.length];
        } else {
            series = new XYChart.Series[1];
        }
        for (int i = 0; i < series.length; i++) {
            series[i] = new XYChart.Series<String, Number>();
            if (sumofP == null) {
                series[i].setName(names[i].toString());
            } else {
                series[i].setName("Toplam Ciro Değerleri");
            }
            for (int j = 0; j < dates.size(); j++) {
                if (sumofP == null) {
                    series[i].getData().add(new XYChart.Data<String, Number>(cloumns.get(j).toString(), values.get(j)[i]));
                } else {
                    series[i].getData().add(new XYChart.Data<String, Number>(cloumns.get(j).toString(), sumofP.get(j)));
                }
            }
            sbc.getData().add(series[i]);
        }
        for (Series<String, Number> serie : sbc.getData()) {
            for (XYChart.Data<String, Number> item : serie.getData()) {
                item.getNode().setOnMousePressed((MouseEvent event) -> {
                    if (l != null) {
                        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
                        for (int i = 0; i < this.allNights.size(); i++) {
                            EventNight e = this.allNights.get(i);
                            if (ft.format(e.getDate()).toString().equals(item.getXValue())) {
                                String temp = "";
                                if (e.getArtist() == null) {
                                    temp = String.format("Tarih : %-10s   Normal Gün  Ciro : %-8.2f  Kar : %-8.2f", item.getXValue(), e.getEndorsement(), e.getProfit());
                                } else {
                                    temp = String.format("Tarih : %-10s   Sanatçı Adı : %-10s Sanatçı Tipi : %-6s  Ciro : %-8.2f  Kar : %-8.2f", item.getXValue(), e.getArtist().getArtistName(), e.getEventType(), e.getEndorsement(), e.getProfit());
                                }
                                l.setText(temp);
                                oneItemSelected = true;
                                showDeeply.setDisable(!oneItemSelected);
                                showDeeply1.setDisable(!oneItemSelected);
                                showDeeply2.setDisable(!oneItemSelected);
                                showDeeply3.setDisable(!oneItemSelected);
                                clickedDate = item.getXValue();
                            }
                        }
                    }
                });
            }
        }

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

    public boolean compareDatesLocalandNormalDate(LocalDate dataL, Date dataN) {

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        if (ft.format(dataN).toString().equals(dataL.toString())) {
            return true;
        }
        return false;
    }

    private ObservableList<Map> generateDataInMap() {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for (int i = 0; i < allNights.size(); i++) {
            Map<String, String> dataRow = new HashMap<>();
            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            dataRow.put("Tarih", ft.format(allNights.get(i).getDate()).toString());
            String eventType = "";
            if (allNights.get(i).getArtist() != null) {
                eventType = allNights.get(i).getEventType() + ", " + allNights.get(i).getArtist().getArtistName();
            } else {
                eventType = allNights.get(i).getEventType();
            }
            dataRow.put("Event Tipi", eventType);
            dataRow.put("Ciro", Double.toString(allNights.get(i).getEndorsement()));
            dataRow.put("Kar", Double.toString(allNights.get(i).getProfit()));
            dataRow.put("Tip", Double.toString(allNights.get(i).getTip()));
            dataRow.put("Ödenmez", Double.toString(allNights.get(i).getDontPay()));
            dataRow.put("Grup Girişi", Double.toString(allNights.get(i).getGroupEntryFee()));
            dataRow.put("total Cost", Double.toString((allNights.get(i).getEndorsement() - allNights.get(i).getProfit())));
            dataRow.put("Artist Cost", Double.toString(allNights.get(i).getArtistCost()));
            dataRow.put("Şişe Sayısı", Double.toString(allNights.get(i).getDiscountBottle()));
            dataRow.put("Toplam İndirim", Double.toString(allNights.get(i).getDiscount()));
            dataRow.put("general Endex", Double.toString(allNights.get(i).getEndex()));
            dataRow.put("Altol Tüketim E.", Double.toString(allNights.get(i).getAlcoholConsumption()));
            dataRow.put("comingPeople", Integer.toString(allNights.get(i).getNumberOfTotalPerson()));
            dataRow.put("70clSales", Integer.toString(allNights.get(i).getSalesOfNight()[0]));
            dataRow.put("35clSales", Integer.toString(allNights.get(i).getSalesOfNight()[1]));
            dataRow.put("confettiSales", Integer.toString(allNights.get(i).getSalesOfNight()[3]));
            dataRow.put("cigaretSales", Integer.toString(allNights.get(i).getSalesOfNight()[2]));
            dataRow.put("glassSales", Integer.toString(allNights.get(i).getSalesOfNight()[4]));
            dataRow.put("70clTreat", Integer.toString(allNights.get(i).getIkramOfNight()[0]));
            dataRow.put("35clTreat", Integer.toString(allNights.get(i).getIkramOfNight()[1]));
            dataRow.put("confettiTreat", Integer.toString(allNights.get(i).getIkramOfNight()[2]));
            allData.add(dataRow);
        }
        return allData;
    }

    private void drawLineChart(LineChart<?, ?> chart, ArrayList<Date> dates, String[] names, ArrayList<Pair<Double, Double>> values) {

        LineChart<String, Number> lineChart = (LineChart<String, Number>) chart;
        lineChart.getData().clear();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM");
        XYChart.Series[] series = new XYChart.Series[names.length];
        for (int i = 0; i < names.length; i++) {
            series[i] = new XYChart.Series();
            series[i].setName(names[i]);
            for (int j = 0; j < dates.size(); j++) {
                if (i == 0) {
                    series[i].getData().add(new XYChart.Data(ft.format(dates.get(j)).toString(), values.get(j).getKey()));
                } else {
                    series[i].getData().add(new XYChart.Data(ft.format(dates.get(j)).toString(), values.get(j).getValue()));
                }
            }
            lineChart.getData().add(series[i]);

        }
    }

    private void findAndDrawAnomalies(ArrayList<EventNight> allNights, StackedBarChart<?, ?> anomaliesStack, LineChart<?, ?> anomaliesLine) {
        ArrayList<Double> nightsEndex = new ArrayList<>();
        for (int i = 0; i < allNights.size(); i++) {
            nightsEndex.add(allNights.get(i).getEndex());
        }
        Collections.sort(nightsEndex);
        Pair<Double, Double> loverBoundUpperBound = findBounderys(nightsEndex);
        double diffrence = Math.abs(loverBoundUpperBound.getKey() - loverBoundUpperBound.getValue());
        double lowerB = loverBoundUpperBound.getKey() - 1.5 * diffrence;
        double upperB = loverBoundUpperBound.getValue() + 1.5 * diffrence;

        String names[] = EventNight.getNamesOfSaledElements();
        ArrayList<double[]> giro = new ArrayList<>();
        ArrayList<Date> dates = new ArrayList<>();
        ArrayList<double[]> profit = new ArrayList<>();
        ArrayList<Double> sumOfProfit = new ArrayList<>();
        ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

        for (int i = 0; i < allNights.size(); i++) {
            if (allNights.get(i).getEndex() >= upperB || allNights.get(i).getEndex() <= lowerB) {
                giro.add(allNights.get(i).getGainOfSales());
                dates.add(allNights.get(i).getDate());
                profit.add(allNights.get(i).getProfitOfSales());
                sumOfProfit.add(allNights.get(i).getProfit());
                endex.add(new Pair<Double, Double>(allNights.get(i).getAlcoholConsumption(), allNights.get(i).getEndex()));
            }
        }
        names = EventNight.getNamesOfSaledElements();
        drawLineChart(anomaliesLine, dates, EventNight.getNamesOfEndex(), endex);
        drawStackChartBetweenDateswithInputs(anomaliesStack, dates, names, giro, null, informationLabelAnomolies);
    }

    private Pair<Double, Double> findBounderys(ArrayList<Double> nightsEndex) {
        int size = nightsEndex.size();
        double Q1;
        double Q3;
        int MLoc = (int) size / 2;
        ArrayList<Double> leftList = new ArrayList<>(nightsEndex.subList(0, MLoc));
        ArrayList<Double> rightList = new ArrayList<>(nightsEndex.subList(MLoc + 1, size));

        int lsize = leftList.size();
        int rsize = rightList.size();
        if (lsize % 2 == 0) {//leftList is even
            Q1 = (leftList.get(lsize / 2) + leftList.get(lsize / 2 - 1)) / 2;
        } else {
            Q1 = leftList.get(lsize / 2);
        }

        if (rsize % 2 == 0) {//rigthList is even
            Q3 = (rightList.get(rsize / 2) + rightList.get(rsize / 2 - 1)) / 2;
        } else {
            Q3 = rightList.get(rsize / 2);
        }
        System.out.println("Q1>" + Q1 + "  Q2>" + Q3);
        return new Pair<Double, Double>(Q1, Q3);
    }

}
