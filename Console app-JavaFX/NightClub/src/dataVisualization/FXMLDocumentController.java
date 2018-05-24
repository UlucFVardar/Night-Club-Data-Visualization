/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisualization;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author ulucf
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private RadioButton moneyMovementSmaller1;

    @FXML
    private TableView allNightTableView;

    @FXML
    private Button evaluationByDayBtn;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
    private RadioButton discountSmaller1;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private RadioButton treatSmaller;

    @FXML
    private TableColumn<?, ?> eventColumn161;

    @FXML
    private TextField GEMin;

    @FXML
    private TableColumn<?, ?> giroEColumn1;

    @FXML
    private TableColumn<?, ?> artistCostColumn1;

    @FXML
    private TableColumn<?, ?> moneyMoventColumn;

    @FXML
    private TableColumn<?, ?> eventColumn1;

    @FXML
    private TableColumn<?, ?> discountColumn1;

    @FXML
    private Label informationLabelName;

    @FXML
    private TableView allNightTableView1;

    @FXML
    private TableColumn<?, ?> eventColumn1211;

    @FXML
    private TableColumn<?, ?> totalCostColumn;

    @FXML
    private PieChart DailyProfitDistiribution;

    @FXML
    private DatePicker distributionByArtistsEnd;

    @FXML
    private TableColumn<?, ?> endexColumn;

    @FXML
    private MenuItem lastDegree;

    @FXML
    private TableColumn<?, ?> tipColumn1;

    @FXML
    private Button showDeeply3;

    @FXML
    private Button showDeeply2;

    @FXML
    private Button showDeeply1;
    @FXML
    private Button telegramSend;

    @FXML
    private TableColumn<?, ?> treatColumn1;

    @FXML
    private TextField GEMax;

    @FXML
    private TableColumn<?, ?> sumOfDiscountColumn1;

    @FXML
    private TableColumn<?, ?> profitColumn;

    @FXML
    private BorderPane borderpane;

    @FXML
    private SplitMenuButton distributionByArtistsSplitMenu;

    @FXML
    private DatePicker datePiccerForDaylyProfit;

    @FXML
    private TextField AMin;

    @FXML
    private TableColumn<?, ?> bottleColumn;

    @FXML
    private TableColumn<?, ?> bottleColumn1;

    @FXML
    private MenuItem commentsMenItem;

    @FXML
    private CheckBox distributionByArtistsCheckProfit;

    @FXML
    private TableColumn<?, ?> eventColumn;

    @FXML
    private DatePicker distributionByArtistsStart;

    @FXML
    private TableColumn<?, ?> eventColumn1111;

    @FXML
    private TableColumn<?, ?> dontPayColumn;

    @FXML
    private MenuItem firstDegree;

    @FXML
    private TableColumn<?, ?> tipColumn;

    @FXML
    private Button distiributionByName;

    @FXML
    private StackedBarChart<?, ?> evalutionByDayStackChart;

    @FXML
    private RadioButton moneyMovementSmaller;

    @FXML
    private StackedBarChart<?, ?> distirubitonByNameStackChart;

    @FXML
    private TableColumn<?, ?> drunkColumn1;

    @FXML
    private TableColumn<?, ?> groupEntryColumn;

    @FXML
    private AnchorPane asd;

    @FXML
    private TabPane gunlukCiroTabPane;

    @FXML
    private Label informationLabelType;

    @FXML
    private DatePicker distiributionByNameStart;

    @FXML
    private TextField AMax;

    @FXML
    private TableColumn<?, ?> profitColumn1;

    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textArea1;

    @FXML
    private TableColumn<?, ?> endexColumn1;

    @FXML
    private RadioButton endexSmaller;

    @FXML
    private StackedBarChart<?, ?> anomaliesStack;

    @FXML
    private TableColumn<?, ?> artistCostColumn;

    @FXML
    private TableColumn<?, ?> discountColumn;

    @FXML
    private TableColumn<?, ?> salesColumn1;

    @FXML
    private DatePicker evaluationByDayEnd;

    @FXML
    private LineChart<?, ?> lineChartByArtist;

    @FXML
    private TableColumn<?, ?> moneyMoventColumn1;

    @FXML
    private TableColumn<?, ?> giroEColumn;

    @FXML
    private TableColumn<?, ?> treatColumn;

    @FXML
    private TableColumn<?, ?> giroColumn;

    @FXML
    private RadioButton salesSmaller;

    @FXML
    private TableColumn<?, ?> eventColumn111;

    @FXML
    private CheckBox evaluationByDayGiroCheck;

    @FXML
    private MenuItem thirdDegree;

    @FXML
    private Label dailyProfitValue;

    @FXML
    private Label DailyTurnoverDistributionLabel;

    @FXML
    private TableColumn<?, ?> eventColumn11;

    @FXML
    private TableColumn<?, ?> groupEntryColumn1;

    @FXML
    private TableColumn<?, ?> eventColumn12;

    @FXML
    private Accordion accordion;

    @FXML
    private TableColumn<?, ?> eventColumn13;

    @FXML
    private Button distributionByArtists;

    @FXML
    private TableColumn<?, ?> eventColumn14;

    @FXML
    private TableColumn<?, ?> eventColumn15;

    @FXML
    private Label giroLabel;

    @FXML
    private CategoryAxis evelation;

    @FXML
    private TableColumn<?, ?> eventColumn16;

    @FXML
    private Label eventLabel1;

    @FXML
    private TextField GMin;

    @FXML
    private TableColumn<?, ?> sumOfDiscountColumn;

    @FXML
    private TableColumn<?, ?> eventColumn121;

    @FXML
    private TableColumn<?, ?> eventColumn131;

    @FXML
    private Label informationLabelDay;

    @FXML
    private Label informationLabelAnomolies;

    @FXML
    private StackedBarChart<?, ?> distributionByArtistsStackChart;

    @FXML
    private TableColumn<?, ?> totalCostColumn1;

    @FXML
    private RadioButton endexSmaller1;

    @FXML
    private PieChart DailyTurnoverDistribution;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TextField GMax;

    @FXML
    private Button searchButton;

    @FXML
    private DatePicker evaluationByDayStart;

    @FXML
    private TextField PMin;

    @FXML
    private TableColumn<?, ?> dontPayColumn1;

    @FXML
    private RadioButton treatSmaller1;

    @FXML
    private CheckBox evaluationByDayProfitCheck;

    @FXML
    private TitledPane allNight;

    @FXML
    private CheckBox distiributionByNameCheckGiro;

    @FXML
    private TableColumn<?, ?> eventColumn141;

    @FXML
    private CheckBox distributionByArtistsCheckGiro;

    @FXML
    private TextField PMax;

    @FXML
    private TableColumn<?, ?> salesColumn;

    @FXML
    private CheckBox distiributionByNameCheckProfit;

    @FXML
    private MenuItem addnightexcel;

    @FXML
    private Label datePiccerLabelForDaylyCiro;

    @FXML
    private TableColumn<?, ?> dateColumn1;

    @FXML
    private Label datePiccerLabelForDaylyProfit;

    @FXML
    private DatePicker datePiccerForDaylyCiro;

    @FXML
    private LineChart<?, ?> anomaliesLine;

    @FXML
    private RadioButton discountSmaller;

    @FXML
    private TableColumn<?, ?> eventColumn1311;

    @FXML
    private TableColumn<?, ?> drunkColumn;

    @FXML
    private Label eventLabel;

    @FXML
    private LineChart<?, ?> DailyCheckLine;

    @FXML
    private Button showDeeply;

    @FXML
    private SplitMenuButton searchTypeSplit;

    @FXML
    private TableColumn<?, ?> giroColumn1;

    @FXML
    private SplitMenuButton distiributionByNameSplitMenu;

    @FXML
    private Label profitLabel;

    @FXML
    private TableColumn<?, ?> eventColumn151;

    @FXML
    private MenuItem secondDegree;

    @FXML
    private DatePicker distiributionByNameEnd;

    @FXML
    private RadioButton salesSmaller1;

    @FXML
    private LineChart<?, ?> lineChartByName;

    @FXML
    private TabPane tabPane;

    public static Stage stage;
    public boolean oneItemSelected = false;
    public String clickedDate = ""; //for intent forum grafic to info page
    public String choosenDate = ""; //for comment all info page
    public String choosenDate1 = ""; //for comment in search page
    public static ArrayList<Artist> allArtists = null;
    public HashMap<String, EventNight> allN = null;
    public static ArrayList<EventNight> allNights = null;
    protected HashMap<String, Double> unitCosts = null;
    protected HashMap<String, Double> unitSalesPrice = null;
    protected String[] columnMapKeys = {"Tarih", "Event Tipi", "comingPeople", "Ciro", "Kar", "Tip", "Ödenmez", "Grup Girişi",
        "Artist Cost", "total Cost", "Şişe Sayısı", "Toplam İndirim", "general Endex", "Altol Tüketim E.",
        "70clSales", "35clSales", "confettiSales", "cigaretSales", "glassSales", "70clTreat", "35clTreat",
        "confettiTreat", "cigaretTreat", "glassTreat"};

    public FXMLDocumentController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create a new MultiRange with min/max values
        ObservableList columns = allNightTableView1.getColumns();
        int size = columns.size();
        int k = 0;
        for (int i = 0; i < size; i++) {
            TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);

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
        columns = allNightTableView.getColumns();
                     size = columns.size();
                     k = 0;
                    for (int i = 0; i < size; i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
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
        GMax.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = GMax.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (!(ch == '.' || ch == '-')) {
                            GMax.setText(GMax.getText().substring(0, GMax.getText().length() - 1));
                        }
                    }
                }
            }
        });
        
        GMin.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = GMin.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (!(ch == '.' || ch == '-')) {
                            GMin.setText(GMin.getText().substring(0, GMin.getText().length() - 1));
                        }
                    }
                }
            }
        });
        PMax.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = PMax.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (!(ch == '.' || ch == '-')) {
                            PMax.setText(PMax.getText().substring(0, PMax.getText().length() - 1));
                        }
                    }
                }
            }
        });
        PMin.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = PMin.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        if (!(ch == '.' || ch == '-')) {
                            PMin.setText(PMin.getText().substring(0, PMin.getText().length() - 1));
                        }
                    }
                }
            }
        });
        AMax.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = AMax.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (!(ch == '.' || ch == '-')) {
                            AMax.setText(AMax.getText().substring(0, AMax.getText().length() - 1));
                        }
                    }
                }
            }
        });
        AMin.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = AMin.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        if (!(ch == '.' || ch == '-')) {
                            AMin.setText(AMin.getText().substring(0, AMin.getText().length() - 1));
                        }
                    }
                }
            }
        });
        GEMax.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = GEMax.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (!(ch == '.' || ch == '-')) {
                            GEMax.setText(GEMax.getText().substring(0, GEMax.getText().length() - 1));
                        }
                    }
                }
            }
        });
        GEMin.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = GEMin.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (!(ch == '.' || ch == '-')) {
                            GEMin.setText(GEMin.getText().substring(0, GEMin.getText().length() - 1));
                        }
                    }
                }
            }
        });

        for (int i = 0; i < searchTypeSplit.getItems().size(); i++) {
            searchTypeSplit.getItems().get(i).setOnAction(myHandler2);
        }
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (allNights != null && allNights.size() > 0) {
                    ArrayList<EventNight> filteredNights = new ArrayList<>();
                    double gMax = 999999, gMin = -999999, pMax = 999999, pMin = -999999, geMax = 999, geMin = -999, aMax = 999, aMin = -999;
                    if (!GMax.getText().equals("")) {
                        gMax = Double.parseDouble(GMax.getText());
                    }
                    if (!GMin.getText().equals("")) {
                        gMin = Double.parseDouble(GMin.getText());
                    }
                    if (!PMax.getText().equals("")) {
                        pMax = Double.parseDouble(PMax.getText());
                    }
                    if (!AMax.getText().equals("")) {
                        aMax = Double.parseDouble(AMax.getText());
                    }
                    if (!AMin.getText().equals("")) {
                        aMin = Double.parseDouble(AMin.getText());
                    }
                    if (!GEMax.getText().equals("")) {
                        geMax = Double.parseDouble(GEMax.getText());
                    }
                    if (!PMin.getText().equals("")) {
                        pMin = Double.parseDouble(PMin.getText());
                    }
                    if (!GEMin.getText().equals("")) {
                        pMin = Double.parseDouble(GEMin.getText());
                    }

                    if (!searchTypeSplit.getText().equals("Sınırlama Yok")) {
                        for (int i = 0; i < allNights.size(); i++) {
                            EventNight e = allNights.get(i);
                            if (e.getEventType().equals(searchTypeSplit.getText())
                                    && (e.getProfit() >= pMin && e.getProfit() <= pMax)
                                    && (e.getEndorsement() >= gMin && e.getEndorsement() <= gMax)
                                    && (e.getAlcoholConsumption() >= aMin && e.getAlcoholConsumption() <= aMax)
                                    && (e.getEndex() >= geMin && e.getEndex() <= geMax)) {
                                filteredNights.add(allNights.get(i));
                            }
                        }
                    } else {
                        for (int i = 0; i < allNights.size(); i++) {
                            EventNight e = allNights.get(i);
                            if ((e.getProfit() >= pMin && e.getProfit() <= pMax)
                                    && (e.getEndorsement() >= gMin && e.getEndorsement() <= gMax)
                                    && (e.getAlcoholConsumption() >= aMin && e.getAlcoholConsumption() <= aMax)
                                    && (e.getEndex() >= geMin && e.getEndex() <= geMax)) {
                                filteredNights.add(e);
                            }
                        }

                    }

                    allNightTableView.setEditable(false);
                    allNightTableView.getSelectionModel().setCellSelectionEnabled(false);
                    allNightTableView1.setItems(generateDataInMap(filteredNights));
                    allNightTableView1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                        if (newSelection != null) {
                            int s = newSelection.toString().lastIndexOf("Tarih=");
                            String date = newSelection.toString().substring(s + 6, s + 16);
                            choosenDate1 = date;
                            textArea1.setText(allN.get(date).getComment());
                        }
                    });
                    textArea1.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent keyEvent) {
                            if (keyEvent.getCode() == KeyCode.ENTER) {
                                allN.get(choosenDate1).setComment(textArea1.getText());
                            }
                        }
                    });
                }
            }
        });
        commentsMenItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("comment.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 400, 400);
                    stage = new Stage();
                    stage.setTitle("Yorumlar");
                    stage.setScene(scene);
                    stage.show();
                    stage.setAlwaysOnTop(true);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
        });
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
                    if (allN == null) {
                        allN = new HashMap<String, EventNight>();
                    }

                    myExcelFile Data = new myExcelFile(file.getAbsolutePath());
                    unitCosts = readUnitCostFromExcel(Data);
                    unitSalesPrice = readUnitSalesPriceFromExcel(Data);
                    allNights = creatAllNightsFromExcel(Data, unitCosts, unitSalesPrice, allN);
                    SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
                    for (int i = 0; i < allNights.size(); i++) {
                        allN.put(ft.format(allNights.get(i).getDate()), allNights.get(i));
                    }
                    if (allArtists.size() != distiributionByNameSplitMenu.getItems().size()) {
                        for (int i = 0; i < allArtists.size(); i++) {
                            MenuItem item = new MenuItem(allArtists.get(i).getArtistName());
                            item.setOnAction(myHandler);
                            distiributionByNameSplitMenu.getItems().add(item);
                        }
                    }
                    
                    allNightTableView.setEditable(false);
                    allNightTableView.getSelectionModel().setCellSelectionEnabled(false);
                    allNightTableView.setItems(generateDataInMap(allNights));
                    allNightTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                        if (newSelection != null) {
                            int s = newSelection.toString().lastIndexOf("Tarih=");
                            String date = newSelection.toString().substring(s + 6, s + 16);
                            choosenDate = date;
                            textArea.setText(allN.get(date).getComment());
                        }
                    });
                    textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent keyEvent) {
                            if (keyEvent.getCode() == KeyCode.ENTER) {
                                allN.get(choosenDate).setComment(textArea.getText());
                            }
                        }
                    });
                    findAndDrawAnomalies(allNights, anomaliesStack, anomaliesLine);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                pushDB(allNights); //*****db push function
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

                    if (evaluationByDayGiroCheck.isSelected()) {
                        drawLineChart(DailyCheckLine, dates, EventNight.getNamesOfEndex(), endex);

                        drawStackChartBetweenDateswithInputs(evalutionByDayStackChart, dates, names, giro, null, informationLabelDay);
                    } else if (evaluationByDayProfitCheck.isSelected()) {
                        drawLineChart(DailyCheckLine, dates, EventNight.getNamesOfEndex(), endex);

                        drawStackChartBetweenDateswithInputs(evalutionByDayStackChart, dates, names, null, sumOfProfit, informationLabelDay);
                    }
                } else if (allNights != null) {
                    String names[] = EventNight.getNamesOfSaledElements();
                    ArrayList<double[]> giro = new ArrayList<>();
                    ArrayList<Date> dates = new ArrayList<>();
                    ArrayList<double[]> profit = new ArrayList<>();
                    ArrayList<Double> sumOfProfit = new ArrayList<>();
                    ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

                    for (int j = 0; j < allNights.size(); j++) {
                        giro.add(allNights.get(j).getGainOfSales());
                        dates.add(allNights.get(j).getDate());
                        profit.add(allNights.get(j).getProfitOfSales());
                        sumOfProfit.add(allNights.get(j).getProfit());
                        endex.add(new Pair<Double, Double>(allNights.get(j).getAlcoholConsumption(), allNights.get(j).getEndex()));
                    }
                    names = EventNight.getNamesOfSaledElements();

                    if (evaluationByDayGiroCheck.isSelected()) {
                        drawStackChartBetweenDateswithInputs(evalutionByDayStackChart, dates, names, giro, null, informationLabelDay);
                        drawLineChart(DailyCheckLine, dates, EventNight.getNamesOfEndex(), endex);
                    } else if (evaluationByDayProfitCheck.isSelected()) {
                        drawStackChartBetweenDateswithInputs(evalutionByDayStackChart, dates, names, null, sumOfProfit, informationLabelDay);
                        drawLineChart(DailyCheckLine, dates, EventNight.getNamesOfEndex(), endex);

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

                    names = EventNight.getNamesOfSaledElements();
                    if (distributionByArtistsCheckGiro.isSelected()) {
                        drawLineChart(lineChartByArtist, dates, EventNight.getNamesOfEndex(), endex);
                        drawStackChartBetweenDateswithInputs(distributionByArtistsStackChart, dates, names, giro, null, informationLabelType);
                    } else if (distributionByArtistsCheckProfit.isSelected()) {
                        drawStackChartBetweenDateswithInputs(distributionByArtistsStackChart, dates, names, null, sumOfProfit, informationLabelType);
                        drawLineChart(lineChartByArtist, dates, EventNight.getNamesOfEndex(), endex);

                    }
                } else if (allNights != null) {
                    String names[] = EventNight.getNamesOfSaledElements();
                    ArrayList<double[]> giro = new ArrayList<>();
                    ArrayList<Date> dates = new ArrayList<>();
                    ArrayList<double[]> profit = new ArrayList<>();
                    ArrayList<Double> sumOfProfit = new ArrayList<>();
                    ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

                    //if user select longer then one year there will be a problem
                    for (int j = 0; j < allNights.size(); j++) {
                        if (allNights.get(j).getEventType().toString().equals(distributionByArtistsSplitMenu.getText().toString().trim())) {
                            giro.add(allNights.get(j).getGainOfSales());
                            dates.add(allNights.get(j).getDate());
                            profit.add(allNights.get(j).getProfitOfSales());
                            sumOfProfit.add(allNights.get(j).getProfit());
                            endex.add(new Pair<Double, Double>(allNights.get(j).getAlcoholConsumption(), allNights.get(j).getEndex()));
                        }
                    }

                    names = EventNight.getNamesOfSaledElements();
                    if (distributionByArtistsCheckGiro.isSelected()) {
                        drawLineChart(lineChartByArtist, dates, EventNight.getNamesOfEndex(), endex);
                        drawStackChartBetweenDateswithInputs(distributionByArtistsStackChart, dates, names, giro, null, informationLabelType);
                    } else if (distributionByArtistsCheckProfit.isSelected()) {
                        drawLineChart(lineChartByArtist, dates, EventNight.getNamesOfEndex(), endex);
                        drawStackChartBetweenDateswithInputs(distributionByArtistsStackChart, dates, names, null, sumOfProfit, informationLabelType);
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
                if (allArtists != null && distiributionByNameEnd.getValue() != null && distiributionByNameStart.getValue() != null) {
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
                    names = EventNight.getNamesOfSaledElements();
                    if (distiributionByNameCheckGiro.isSelected()) {

                        drawLineChart(lineChartByName, dates, EventNight.getNamesOfEndex(), endex);

                        drawStackChartBetweenDateswithInputs(distirubitonByNameStackChart, dates, names, giro, null, informationLabelName);
                    } else if (distiributionByNameCheckProfit.isSelected()) {
                        drawLineChart(lineChartByName, dates, EventNight.getNamesOfEndex(), endex);

                        drawStackChartBetweenDateswithInputs(distirubitonByNameStackChart, dates, names, null, sumOfProfit, informationLabelName);
                    }
                } else if (allArtists != null) {
                    String names[] = EventNight.getNamesOfSaledElements();
                    ArrayList<double[]> giro = new ArrayList<>();
                    ArrayList<Date> dates = new ArrayList<>();
                    ArrayList<double[]> profit = new ArrayList<>();
                    ArrayList<Double> sumOfProfit = new ArrayList<>();
                    ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

                    for (int i = 0; i < allArtists.size(); i++) {
                        if (distiributionByNameSplitMenu.getText().equalsIgnoreCase(allArtists.get(i).getArtistName())) {
                            for (int aDay = 0; aDay < allArtists.get(i).getNights().size(); aDay++) {
                                giro.add(allArtists.get(i).getNights().get(aDay).getGainOfSales());
                                dates.add(allArtists.get(i).getNights().get(aDay).getDate());
                                profit.add(allArtists.get(i).getNights().get(aDay).getProfitOfSales());
                                sumOfProfit.add(allArtists.get(i).getNights().get(aDay).getProfit());
                                endex.add(new Pair<Double, Double>(allArtists.get(i).getNights().get(aDay).getAlcoholConsumption(), allArtists.get(i).getNights().get(aDay).getEndex()));
                            }
                            break;
                        }
                    }
                    names = EventNight.getNamesOfSaledElements();
                    if (distiributionByNameCheckGiro.isSelected()) {
                        drawLineChart(lineChartByName, dates, EventNight.getNamesOfEndex(), endex);
                        drawStackChartBetweenDateswithInputs(distirubitonByNameStackChart, dates, names, giro, null, informationLabelName);
                    } else if (distiributionByNameCheckProfit.isSelected()) {
                        drawLineChart(lineChartByName, dates, EventNight.getNamesOfEndex(), endex);
                        drawStackChartBetweenDateswithInputs(distirubitonByNameStackChart, dates, names, null, sumOfProfit, informationLabelName);
                    }
                }
            }
        });
        moneyMovementSmaller1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (moneyMovementSmaller1.isSelected()) {
                    ObservableList columns = moneyMoventColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = moneyMoventColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(40 + (i) * 10);
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
        discountSmaller1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (discountSmaller1.isSelected()) {
                    ObservableList columns = discountColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = discountColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(100);
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
        endexSmaller1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (endexSmaller1.isSelected()) {
                    ObservableList columns = endexColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = endexColumn1.getColumns();
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
        treatSmaller1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (treatSmaller1.isSelected()) {
                    ObservableList columns = treatColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = treatColumn1.getColumns();
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
        salesSmaller1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (salesSmaller1.isSelected()) {
                    ObservableList columns = salesColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(20);
                    }
                } else {
                    ObservableList columns = salesColumn1.getColumns();
                    for (int i = 0; i < columns.size(); i++) {
                        TableColumn<String, Double> c = (TableColumn<String, Double>) columns.get(i);
                        c.setPrefWidth(75);
                    }
                }
            }
        });
        telegramSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                URL url = null;
                HttpURLConnection connection = null;
                String str = "https://api.telegram.org/bot577945846:AAGi470sszD_Coz4XDj13i8ax9Qzdejy0A0/sendmessage?chat_id=443290984&parse_mode=HTML&disable_web_page_preview=true&text=Buyrun%20"+choosenDate.toString()+"%20tarihi%20için%20raporunuz.";
                System.out.println(str);
                try {
                    url = new URL(str);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //connection = (HttpURLConnection) url.openConnection();
                    InputStream is = url.openStream();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public EventHandler<ActionEvent> myHandler2 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent event) {
            MenuItem selectedItem = (MenuItem) event.getSource();
            searchTypeSplit.setText(selectedItem.getText().toString());
        }
    };
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
            allNightTableView.setStyle(" -fx-background-color: #005797;"
                    + "-fx-background-insets: 0;"
                    + "-fx-background-radius: 1;"
                    + "-selected-color: #21D900;"
                    + "-fx-text-fill: Black;");

            for (int i = 0; i < allNightTableView.getItems().size(); i++) {
                Map<String, String> map = (Map<String, String>) allNightTableView.getItems().get(i);
                if (map.get("Tarih").equals(clickedDate)) {
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

    private ArrayList<EventNight> creatAllNightsFromExcel(myExcelFile Data, HashMap<String, Double> unitCosts, HashMap<String, Double> unitSalesPrice, HashMap<String, EventNight> allN) throws IOException, JSONException {
        ArrayList<EventNight> e = new ArrayList<>();
        String artistName = "";
        int size = Data.getSheetSize();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 1; i < size; i++) {
            artistName = "";
            Date date = (Date) Data.get("E22", i);

            if (allN.containsKey(ft.format(date))) {
                continue;
            }
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
        CategoryAxis xAxis = (CategoryAxis) sbc.getXAxis();        
        NumberAxis yAxis = (NumberAxis) sbc.getYAxis();
        xAxis.getCategories().clear();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        xAxis.setAnimated(false);
        yAxis.setAnimated(false);       
        yAxis.setAutoRanging(true);
        XYChart.Series<String, Number>[] series;
        if (sumofP == null) {
            series = new XYChart.Series[names.length];
        } else {
            series = new XYChart.Series[1];
        }
        int size=series.length;
        for ( int i = 0; i <size ; i++ ) {
            series[i] = new XYChart.Series<String, Number>();
                           
            if (sumofP == null) {
                series[i].setName(names[i].toString());
            } else {
                series[i].setName("Toplam Kar Değerleri");
            }
            for (int j = 0; j < dates.size(); j++) {
                String date=ft.format(dates.get(j));
                if (sumofP == null) {
                    series[i].getData().add(new XYChart.Data<String, Number>(date, values.get(j)[i]));
                } else {
                    System.out.println("Kar> "+sumofP.get(j)+" date> "+ft.format(dates.get(j)));
                    series[i].getData().add(new XYChart.Data<String, Number>(date, sumofP.get(j)));
                    
                }
            }
            sbc.getData().add(series[i]);
        }
        System.out.println("lovwe>"+yAxis.getLowerBound());
        
        for (Series<String, Number> serie : sbc.getData()) {
            for (XYChart.Data<String, Number> item : serie.getData()) {
                item.getNode().setOnMousePressed((MouseEvent event) -> {
                    if (l != null) {
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

    private ObservableList generateDataInMap(ArrayList<EventNight> allNights) {
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
        CategoryAxis xAxis = (CategoryAxis) lineChart.getXAxis();        
        NumberAxis yAxis = (NumberAxis) lineChart.getYAxis();
        xAxis.setAnimated(false);
        yAxis.setAnimated(false);
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
        ArrayList<Double> standartD = new ArrayList<>();
        ArrayList<Double> type8 = new ArrayList<>();
        ArrayList<Double> type25 = new ArrayList<>();
        ArrayList<Double> type40 = new ArrayList<>();
        ArrayList<Double> type70 = new ArrayList<>();

        for (int i = 0; i < allNights.size(); i++) {
            nightsEndex.add(allNights.get(i).getEndex());
            if (allNights.get(i).getEventType().equals("Normal Gün")) {
                standartD.add(allNights.get(i).getEndex());
            } else if (allNights.get(i).getEventType().equals("8 Binlik")) {
                type8.add(allNights.get(i).getEndex());
            } else if (allNights.get(i).getEventType().equals("25 Binlik")) {
                type25.add(allNights.get(i).getEndex());
            } else if (allNights.get(i).getEventType().equals("40 Binlik")) {
                type40.add(allNights.get(i).getEndex());
            } else if (allNights.get(i).getEventType().equals("+70 Binlik")) {
                type70.add(allNights.get(i).getEndex());
            }
        }

        Collections.sort(nightsEndex);
        Pair<Double, Double> loverBoundUpperBound = findBounderys(nightsEndex);
        double diffrence = Math.abs(loverBoundUpperBound.getKey() - loverBoundUpperBound.getValue());
        double lowerB = loverBoundUpperBound.getKey() - 1.5 * diffrence;
        double upperB = loverBoundUpperBound.getValue() + 1.5 * diffrence;

        Collections.sort(type8);
        Pair<Double, Double> type8B = findBounderys(type8);
        double diffrence8 = Math.abs(type8B.getKey() - type8B.getValue());
        double type8LB = type8B.getKey() - 1.5 * diffrence8;
        double type8UB = type8B.getValue() + 1.5 * diffrence8;

        Collections.sort(type25);
        Pair<Double, Double> type25B = findBounderys(type25);
        double diffrence25 = Math.abs(type25B.getKey() - type25B.getValue());
        double type25LB = type25B.getKey() - 1.5 * diffrence25;
        double type25UB = type25B.getValue() + 1.5 * diffrence25;

        Collections.sort(type40);
        Pair<Double, Double> type40B = findBounderys(type40);
        double diffrence40 = Math.abs(type40B.getKey() - type40B.getValue());
        double type40LB = type40B.getKey() - 1.5 * diffrence40;
        double type40UB = type40B.getValue() + 1.5 * diffrence40;

        Collections.sort(type70);
        Pair<Double, Double> type70B = findBounderys(type70);
        double diffrence70 = Math.abs(type70B.getKey() - type70B.getValue());
        double type70LB = type70B.getKey() - 1.5 * diffrence70;
        double type70UB = type70B.getValue() + 1.5 * diffrence70;

        Collections.sort(standartD);
        Pair<Double, Double> typeNOB = findBounderys(standartD);
        double diffrenceNO = Math.abs(typeNOB.getKey() - typeNOB.getValue());
        double typeNOLB = typeNOB.getKey() - 1.5 * diffrenceNO;
        double typeNOUB = typeNOB.getValue() + 1.5 * diffrenceNO;

        String names[] = EventNight.getNamesOfSaledElements();
        ArrayList<double[]> giro = new ArrayList<>();
        ArrayList<Date> dates = new ArrayList<>();
        ArrayList<double[]> profit = new ArrayList<>();
        ArrayList<Double> sumOfProfit = new ArrayList<>();
        ArrayList<Pair<Double, Double>> endex = new ArrayList<>();

        for (int i = 0; i < allNights.size(); i++) {

            if (allNights.get(i).getEventType().equals("Normal Gün")) {
                if (allNights.get(i).getEndex() >= typeNOUB || allNights.get(i).getEndex() <= typeNOLB) {
                    giro.add(allNights.get(i).getGainOfSales());
                    dates.add(allNights.get(i).getDate());
                    profit.add(allNights.get(i).getProfitOfSales());
                    sumOfProfit.add(allNights.get(i).getProfit());
                    endex.add(new Pair<Double, Double>(allNights.get(i).getAlcoholConsumption(), allNights.get(i).getEndex()));
                }
            } else if (allNights.get(i).getEventType().equals("8 Binlik")) {
                if (allNights.get(i).getEndex() >= type8UB || allNights.get(i).getEndex() <= type8LB) {
                    giro.add(allNights.get(i).getGainOfSales());
                    dates.add(allNights.get(i).getDate());
                    profit.add(allNights.get(i).getProfitOfSales());
                    sumOfProfit.add(allNights.get(i).getProfit());
                    endex.add(new Pair<Double, Double>(allNights.get(i).getAlcoholConsumption(), allNights.get(i).getEndex()));
                }
            } else if (allNights.get(i).getEventType().equals("25 Binlik")) {
                if (allNights.get(i).getEndex() >= type25UB || allNights.get(i).getEndex() <= type25LB) {
                    giro.add(allNights.get(i).getGainOfSales());
                    dates.add(allNights.get(i).getDate());
                    profit.add(allNights.get(i).getProfitOfSales());
                    sumOfProfit.add(allNights.get(i).getProfit());
                    endex.add(new Pair<Double, Double>(allNights.get(i).getAlcoholConsumption(), allNights.get(i).getEndex()));
                }
            } else if (allNights.get(i).getEventType().equals("40 Binlik")) {
                if (allNights.get(i).getEndex() >= type40UB || allNights.get(i).getEndex() <= type40LB) {
                    giro.add(allNights.get(i).getGainOfSales());
                    dates.add(allNights.get(i).getDate());
                    profit.add(allNights.get(i).getProfitOfSales());
                    sumOfProfit.add(allNights.get(i).getProfit());
                    endex.add(new Pair<Double, Double>(allNights.get(i).getAlcoholConsumption(), allNights.get(i).getEndex()));
                }
            } else if (allNights.get(i).getEventType().equals("+70 Binlik")) {
                if (allNights.get(i).getEndex() >= type70UB || allNights.get(i).getEndex() <= type70LB) {
                    giro.add(allNights.get(i).getGainOfSales());
                    dates.add(allNights.get(i).getDate());
                    profit.add(allNights.get(i).getProfitOfSales());
                    sumOfProfit.add(allNights.get(i).getProfit());
                    endex.add(new Pair<Double, Double>(allNights.get(i).getAlcoholConsumption(), allNights.get(i).getEndex()));
                }
            }
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
        if (size <= 4) {
            return new Pair<Double, Double>(-99999.0, 9999999.0);
        }
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
        return new Pair<Double, Double>(Q1, Q3);
    }
   
    public String createInfo(EventNight e) throws JSONException {
        String info="";
        String inf="";
        //Artist
        String str2="isimsiz";
        if(e.getArtist()!=null)
            str2=convert(e.getArtist().getArtistName().toString());
        
        info+="artistName="+str2+"&";
        info+="artistPrice="+Double.toString((double)e.getArtistCost())+"&";
        info+="eventType="+ e.getEventType() +"&";
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date d=e.getDate();                               
        String str=ft.format(d);
        info+="eventDate="+str+"&";
        info+="eventComment="+"null"+"&";
        info+="totalProfit="+ Double.toString((double)e.getProfit())+"&";
        info+="totalEndersement="+Double.toString((double)e.getEndorsement())+"&";
        info+="tip="+Double.toString((double)e.getTip())+"&"; 
        info+="dontPay="+Double.toString((double)e.getDontPay())+"&";
        info+="totalCost="+ "2"+"&";    //
        info+="nameOfSales="+"70cl 35cl konfeti sigara bardak"+"&";
        String s=e.getSalesOfNight()[0] +"|"+e.getSalesOfNight()[1]+"|"+e.getSalesOfNight()[2]+"|"+e.getSalesOfNight()[3]+"|"+e.getSalesOfNight()[4];
        String s2=e.getProfitOfSales()[0]+"|"+e.getProfitOfSales()[1]+"|"+e.getProfitOfSales()[2]+"|"+e.getProfitOfSales()[3]+"|"+e.getProfitOfSales()[4];
        String s3=e.getGainOfSales()[0]+"|"+e.getGainOfSales()[1]+"|"+e.getGainOfSales()[2]+"|"+e.getGainOfSales()[3]+"|"+e.getGainOfSales()[4];
        info+="sumOfProfit="+ s2 +"&";    //
        info+="sumOfGiro="+s3+"&";      //  
        info+="salesNumber="+s+"&";    //
        info+="cl70Number="+ Integer.toString((int)e.getIkramOfNight()[0])+"&";
        info+="cl35Number="+ Integer.toString((int)e.getIkramOfNight()[1])+"&";
        info+="confetyNumber="+ Integer.toString((int)e.getIkramOfNight()[2])+"&";
        info+="bottleNumber="+ Integer.toString((int)e.getDiscountBottle())+"&";
        info+="totalDiscount="+ Integer.toString((int)e.getDiscount())+"&";
        info+="alcoholIndex="+ Double.toString((double)e.getAlcoholConsumption())+"&";
        info+="generalIndex="+ Double.toString((double) e.getEndex())+"&";
        info+="grupEnterenceFree="+ Double.toString((double) e.getGroupEntryFee());                     
        
        inf+="\""+str2+"\",";
        inf+=Double.toString((double)e.getArtistCost())+",";
        inf+= "\""+e.getEventType()+"\",";
        inf+= "\""+str+"\",";
        inf+="\"null\",";
        inf+=Double.toString((double)e.getProfit())+",";
        inf+=Double.toString((double)e.getEndorsement())+",";
        inf+=Double.toString((double)e.getTip())+",";        
        inf+=Double.toString((double)e.getDontPay())+",";
        inf+="2,";
        inf+="\"70cl 35cl konfeti sigara bardak\",";
        inf+="\""+s2+"\",";
        inf+="\""+s3+"\",";
        inf+="\""+s+"\",";
        
        inf+=Integer.toString((int)e.getIkramOfNight()[0])+",";
        inf+=Integer.toString((int)e.getIkramOfNight()[1])+",";
        inf+=Integer.toString((int)e.getIkramOfNight()[2])+",";
        inf+= Integer.toString((int)e.getDiscountBottle())+",";
        inf+=Integer.toString((int)e.getDiscount())+",";
        inf+= Double.toString((double)e.getAlcoholConsumption())+",";
        inf+=Double.toString((double) e.getEndex())+",";
        inf+=Double.toString((double) e.getGroupEntryFee());
        System.out.println("call innodb.addEventNight  ( "+inf+");");
        
        
        
        
        return info;    
    }
    private void pushDB(ArrayList<EventNight> allNights) {
        MyThread myThread;
        myThread = new MyThread(null, false,allNights);
        myThread.start();
       
    } public String convert(String a){
                a = a.replace('İ', 'I');
                a = a.replace('Ş', 's');
                a = a.replace('Ç', 'C');
                a = a.replace('Ü', 'U');
                a = a.replace('Ö', 'O');
                a = a.replace('ş', 's');
                a = a.replace('ğ', 'g');
                a = a.replace('ı', 'i');
                a = a.replace('ö', 'o');
                a = a.replace('ü', 'u');
                a = a.replace('ç', 'c');    
                //a = a.replace(' ', '-');    
                
                   
            return a;
        }
    public class MyThread extends Thread {
        
        String info;
        boolean flag;
        ArrayList<EventNight> allNights;
        public MyThread(String o, boolean f,ArrayList<EventNight> allNights) {
            this.info = o;
            this.flag = f;
            this.allNights=allNights;
        }
       
        public void run() {
            if (this.flag == false) {
                try {
                    MyThread myThread = new MyThread(createInfo(this.allNights.get(0)),true,null);
                    myThread.start();
                    for (int i = 1; i < this.allNights.size()  ;) {
                        if (myThread.isAlive() == false) {
                            myThread = new MyThread(createInfo(this.allNights.get(i)),true,null);
                            myThread.start();
                            i++;
                        }
                    }
                } catch (JSONException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {                   
                    CloseableHttpClient httpClient = HttpClientBuilder.create().build();                                        
                    this.info = convert(this.info.toString());                                        
                    URL url = new URL("https://i4pd9k2cy9.execute-api.us-east-2.amazonaws.com/prod/inserteventnight?"+this.info.toString());
                    
                    //System.out.println(url.toString());
                    
                    HttpPost request = new HttpPost(url.toString());
                    httpClient.execute(request);
                    httpClient.close();

                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
