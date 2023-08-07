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
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(new FxSoundView(), 320, 240);
        stage.setTitle("FxSound");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

enum AudioDevices{
    LENOVO_SPEAKER,
    EXTRENAL_SPEAKER
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
    private NumberAxis yAxis;
    private CategoryAxis xAxis;
    private BarChart barChart;
    private HBox hBox1,hBox2,hBox3,hBox4;
    private ComboBox<String> audioEqualizerComboBox , audioDeviceComboBox;
    public FxSoundView()
    {
        //
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        //
        barChart = new BarChart<>(xAxis,yAxis);
        //
        ObservableList<String> audioDevicesList = FXCollections.observableArrayList();
        audioDevicesList.addAll(Arrays.toString(AudioDevices.values()));
        ObservableList<String> audioEqualizersList = FXCollections.observableArrayList();
        audioEqualizersList.addAll(Arrays.toString(AudioEqualizers.values()));
        //
        audioEqualizerComboBox = new ComboBox<>(audioEqualizersList);
        audioDeviceComboBox = new ComboBox<>(audioDevicesList);
        //
        hBox1 = new HBox(20);
        hBox2 = new HBox(20);
        hBox3 = new HBox(20);
        hBox4 = new HBox(20);
        //
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        //
        hBox1.getChildren().addAll(audioEqualizerComboBox,audioDeviceComboBox);
        hBox2.getChildren().addAll(barChart);
        //
        getChildren().addAll(hBox1,hBox2,hBox3,hBox4);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(2.5,2.5,2.5,2.5));
    }
}