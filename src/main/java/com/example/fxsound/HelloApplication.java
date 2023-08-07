package com.example.fxsound;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    public static Double WIDTH = Screen.getPrimary().getBounds().getWidth() * .67;
    public static Double HEIGHT = Screen.getPrimary().getBounds().getHeight() * .73;
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new FxSoundView(), WIDTH, HEIGHT);
        scene.getStylesheets().addAll(new File("src/main/resources/styles/dark.css").toURI().toASCIIString());
        stage.setTitle("FxSound");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

enum AudioDevices{
    LENOVO_SPEAKER,
    EXTERNAL_SPEAKER
}
enum AudioEqualizers{
    MUSIC,
    DANCE,
    POP,
    GAMING,
    TV,
    CAR,
    CLUB,
    TECHNO,
    LATIN,
    BASS_BOOST,
    TREBLE_BOOST,
}



class FxSoundView extends VBox {
    private NumberAxis barChartYAxis , lineChartXAxis , lineChartYAxis;
    private CategoryAxis barChartXAxis ;
    private final BarChart<String,Number> barChart;
    private final LineChart<Number,Number> lineChart;
    private final HBox hBox0,hBox1,hBox2,hBox3,hBox4;
    private Label slider1Label , slider2Label ,slider3Label,slider4Label,slider5Label , appTitleLabel ;
    private VBox slidersVBox;
    private Slider slider1,slider2,slider3,slider4,slider5;
    private final ComboBox<String> audioEqualizerComboBox , audioDeviceComboBox;
    private Button menuButton , fullScreenButton , onOffButton , closeButton;
    private ImageView menuButtonIcon,powerButtonIcon,fullScreenButtonIcon , closeButtonIcon;
    public FxSoundView()
    {
        //
        closeButtonIcon = new ImageView(new File("src/main/resources/icons/red-close-button.png").toURI().toASCIIString());
        menuButtonIcon = new ImageView(new File("src/main/resources/icons/redpowerbutton.webp").toURI().toASCIIString());
        powerButtonIcon = new ImageView(new File("menublackcircularbutton_104737.png").toURI().toASCIIString());
        fullScreenButtonIcon = new ImageView(new File("src/main/resources/icons/fullscreenbuttonicon1.png").toURI().toASCIIString());
        //
        appTitleLabel = new Label("FXSound");
        slider1Label = new Label("Clarity");
        slider2Label = new Label("Ambience");
        slider3Label = new Label("Surround Sound");
        slider4Label = new Label("Dynamic Boost");
        slider5Label = new Label("Bass Boost");

        //
        slider1 = new Slider();
        slider2 = new Slider();
        slider3 = new Slider();
        slider4 = new Slider();
        slider5 = new Slider();
        //
        menuButton = new Button();
        fullScreenButton = new Button();
        onOffButton = new Button();
        closeButton = new Button();
        //
        barChartXAxis = new CategoryAxis();
        barChartYAxis = new NumberAxis();
        //
        lineChartXAxis = new NumberAxis();
        lineChartYAxis = new NumberAxis();
        //
        lineChart = new LineChart<>(lineChartXAxis,lineChartYAxis);
        barChart = new BarChart<>(barChartXAxis,barChartYAxis);
        //
        ObservableList<String> audioDevicesList = FXCollections.observableArrayList();
        audioDevicesList.addAll(Arrays.toString(Arrays.stream(AudioDevices.values()).toArray()));
        ObservableList<String> audioEqualizersList = FXCollections.observableArrayList();
        audioEqualizersList.addAll(Arrays.toString(Arrays.stream(AudioEqualizers.values()).toArray()));
        //
        audioEqualizerComboBox = new ComboBox<>(audioEqualizersList);
        audioDeviceComboBox = new ComboBox<>(audioDevicesList);
        //
        slidersVBox = new VBox(10);
        //
        hBox0 = new HBox(20);
        hBox1 = new HBox(20);
        hBox2 = new HBox(20);
        hBox3 = new HBox(20);
        hBox4 = new HBox(20);
        //
        menuButtonIcon.setPreserveRatio(true);
        menuButtonIcon.setFitWidth(32);
        menuButtonIcon.setFitHeight(28);
        //
        powerButtonIcon.setPreserveRatio(true);
        powerButtonIcon.setFitWidth(52);
        powerButtonIcon.setFitHeight(38);
        //
        fullScreenButtonIcon.setPreserveRatio(true);
        fullScreenButtonIcon.setFitWidth(32);
        fullScreenButtonIcon.setFitHeight(28);
        //
        menuButton.setGraphic(menuButtonIcon);
        onOffButton.setGraphic(powerButtonIcon);
        fullScreenButton.setGraphic(fullScreenButtonIcon);
        closeButton.setGraphic(closeButtonIcon);
        //
        hBox0.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        //

        //
        hBox1.getChildren().addAll(audioEqualizerComboBox,audioDeviceComboBox);
        hBox2.getChildren().addAll(barChart);
        slidersVBox.getChildren().addAll(slider1Label,slider1,slider2Label,slider2,slider3Label,slider3,slider4Label,slider4,slider5Label,slider5);
        hBox3.getChildren().addAll(slidersVBox , lineChart);
        hBox4.getChildren().addAll(menuButton,onOffButton,fullScreenButton);
        //
        getChildren().addAll(hBox1,hBox2,hBox3,hBox4);
        //
        setAlignment(Pos.CENTER);
        setPadding(new Insets(12.55,12.55,12.55,12.55));
        //
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(12.55,12.55,12.55,12.55));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(12.55,12.55,12.55,12.55));
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(12.55,12.55,12.55,12.55));
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setPadding(new Insets(12.55,12.55,12.55,12.55));
        //
        slidersVBox.setPadding(new Insets(2.5,5,10,5));
        slidersVBox.setAlignment(Pos.CENTER);
        //
        //
        audioDeviceComboBox.prefWidthProperty().bind(hBox1.widthProperty().multiply(.45));
        audioDeviceComboBox.prefHeightProperty().bind(hBox1.heightProperty());
        audioEqualizerComboBox.prefWidthProperty().bind(hBox1.widthProperty().multiply(.45));
        audioEqualizerComboBox.prefHeightProperty().bind(hBox1.heightProperty());
        //
        slidersVBox.prefWidthProperty().bind(hBox3.widthProperty().multiply(.15));
        slidersVBox.prefHeightProperty().bind(hBox3.heightProperty());
        //
        slider1.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider2.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider3.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider4.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider5.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));


        slider1.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider2.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider3.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider4.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider5.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));

        //
        slider1Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider2Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider3Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider4Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider5Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider1Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider2Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider3Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider4Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider5Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        //
        //
        lineChart.prefWidthProperty().bind(hBox3.widthProperty().multiply(.65));
        lineChart.prefHeightProperty().bind(hBox3.heightProperty());
        //
        barChart.prefWidthProperty().bind(hBox2.widthProperty());
        barChart.prefHeightProperty().bind(hBox2.heightProperty());
        //
        hBox1.prefWidthProperty().bind(widthProperty());
        hBox2.prefWidthProperty().bind(widthProperty());
        hBox3.prefWidthProperty().bind(widthProperty());
        hBox4.prefWidthProperty().bind(widthProperty());
        //
        hBox1.prefHeightProperty().bind(heightProperty().multiply(.1));
        hBox2.prefHeightProperty().bind(heightProperty().multiply(.20));
        hBox3.prefHeightProperty().bind(heightProperty().multiply(.4));
        hBox4.prefHeightProperty().bind(heightProperty().multiply(.3));
        //
        barChart.setLegendVisible(false);
        lineChart.setCreateSymbols(false);
        //

        //
    }
}