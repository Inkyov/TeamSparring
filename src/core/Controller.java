package core;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    @FXML
    public ImageView redTimyo;
    @FXML
    public ImageView blueTimyo;
    @FXML
    public Label rChLbl;
    @FXML
    public Label bChLbl;
    @FXML
    public Label rPJ2Label;
    @FXML
    public Label bPJ2Label;
    @FXML
    public Label rPJ1Label;
    @FXML
    public Label bPJ1Label;
    @FXML
    public Label rPJ3Label;
    @FXML
    public Label bPJ3Label;
    @FXML
    public Label rPJ4Label;
    @FXML
    public Label bPJ4Label;
    @FXML
    public Label rKChLabel;
    @FXML
    public Label bKChLabel;
    @FXML
    public Label rPLbl1;
    @FXML
    public Label bPLbl1;
    @FXML
    public Label result;
    @FXML
    public ComboBox<String> categories;
    @FXML
    public Label roundsLabel;
    @FXML
    public Button leftArrow;
    @FXML
    public Button rightArrow;
    @FXML
    public Label secondLabel;
    @FXML
    public Label minutesLabel;
    @FXML
    public Pane timerPane;
    @FXML
    public MenuItem refreshButt;
    @FXML
    public GridPane grid;
    @FXML
    public Label winTeam;
    @FXML
    public Label winTeamRed;
    @FXML
    public Label winTeamBlue;
    private int round = 1;
    private CustomTimeline customTimeline;
    private Parent root;
    private VisibleScoreBoardController visibleScoreBoardController;

    private SimpleIntegerProperty redPoint1 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty redPoint1Property() { return redPoint1; }
    private SimpleIntegerProperty redPoint2 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty redPoint2Property() { return redPoint2; }
    private SimpleIntegerProperty redPoint3 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty redPoint3Property() { return redPoint3; }
    private SimpleIntegerProperty redPoint4 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty redPoint4Property() { return redPoint4; }

    private SimpleIntegerProperty bluePoint1 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty bluePoint1Property() { return bluePoint1; }
    private SimpleIntegerProperty bluePoint2 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty bluePoint2Property() { return bluePoint2; }
    private SimpleIntegerProperty bluePoint3 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty bluePoint3Property() { return bluePoint3; }
    private SimpleIntegerProperty bluePoint4 = new SimpleIntegerProperty(-2);
    private SimpleIntegerProperty bluePoint4Property() { return bluePoint4; }

    private SimpleIntegerProperty minutes = new SimpleIntegerProperty(2);
    SimpleIntegerProperty minutesProperty() { return minutes; }

    private SimpleStringProperty secondsLabel = new SimpleStringProperty("00");
    SimpleStringProperty secondsLabelProperty() {return secondsLabel;}

    private SimpleStringProperty resultLabel = new SimpleStringProperty("Срещата е равна");
    private SimpleStringProperty resultLabelProperty() {return resultLabel;}

    private SimpleIntegerProperty redResult = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty redResultProperty() { return redResult; }

    private SimpleIntegerProperty  blueResult = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty blueResultProperty() { return blueResult; }

    private SimpleBooleanProperty redGiven1 = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty blueGiven1 = new SimpleBooleanProperty(false);

    private SimpleBooleanProperty redGiven2 = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty blueGiven2 = new SimpleBooleanProperty(false);

    private SimpleBooleanProperty redGiven3 = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty blueGiven3 = new SimpleBooleanProperty(false);

    private SimpleBooleanProperty redGiven4 = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty blueGiven4 = new SimpleBooleanProperty(false);

    private SimpleBooleanProperty redOpacity = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty blueOpacity = new SimpleBooleanProperty(false);
    private SimpleIntegerProperty blueChui = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty blueChuiProperty() { return blueChui; }
    private SimpleIntegerProperty redChui = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty redChuiProperty() { return redChui; }
    private SimpleIntegerProperty redKamChum = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty redKamChumProperty() { return redKamChum; }
    private SimpleIntegerProperty blueKamChum = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty blueKamChumProperty() { return blueKamChum; }
    private SimpleIntegerProperty redWinner = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty redWinnerProperty() {return redWinner;}
    private SimpleIntegerProperty blueWinner = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty blueWinnerProperty() {return blueWinner;}

    private SimpleStringProperty roundLabel = new SimpleStringProperty("Рунд 1");
    private SimpleStringProperty roundLabelProperty() { return roundLabel; }

    public void initialize(URL location, ResourceBundle resources){

        File file = new File("resources/images/kick.png");
        Image image = new Image(file.toURI().toString());
        redTimyo.setImage(image);
        blueTimyo.setImage(image);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/visibleScoreBoard.fxml"));
        try {
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1680, 850));
            stage.getIcons().add(new Image("file:resources/images/icon.png"));
            stage.setTitle("Match Grading System");
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        visibleScoreBoardController = fxmlLoader.getController();

        rPJ1Label.textProperty().bind(redPoint1Property().asString());
        rPJ2Label.textProperty().bind(redPoint2Property().asString());
        rPJ3Label.textProperty().bind(redPoint3Property().asString());
        rPJ4Label.textProperty().bind(redPoint4Property().asString());
        bPJ1Label.textProperty().bind(bluePoint1Property().asString());
        bPJ2Label.textProperty().bind(bluePoint2Property().asString());
        bPJ3Label.textProperty().bind(bluePoint3Property().asString());
        bPJ4Label.textProperty().bind(bluePoint4Property().asString());
        visibleScoreBoardController.rPJ1Label.textProperty().bind(redPoint1Property().asString());
        visibleScoreBoardController.rPJ2Label.textProperty().bind(redPoint2Property().asString());
        visibleScoreBoardController.rPJ3Label.textProperty().bind(redPoint3Property().asString());
        visibleScoreBoardController.rPJ4Label.textProperty().bind(redPoint4Property().asString());
        visibleScoreBoardController.bPJ1Label.textProperty().bind(bluePoint1Property().asString());
        visibleScoreBoardController.bPJ2Label.textProperty().bind(bluePoint2Property().asString());
        visibleScoreBoardController.bPJ3Label.textProperty().bind(bluePoint3Property().asString());
        visibleScoreBoardController.bPJ4Label.textProperty().bind(bluePoint4Property().asString());
        minutesLabel.textProperty().bind(minutesProperty().asString());
        visibleScoreBoardController.minutesLabel.textProperty().bind(minutesProperty().asString());
        secondLabel.textProperty().bind(secondsLabelProperty());
        visibleScoreBoardController.secondLabel.textProperty().bind(secondsLabelProperty());
        rPLbl1.textProperty().bind(redResultProperty().asString());
        bPLbl1.textProperty().bind(blueResultProperty().asString());
        result.textProperty().bind(resultLabelProperty());
        roundsLabel.textProperty().bind(roundLabelProperty());
        visibleScoreBoardController.roundsLabel.textProperty().bind(roundLabelProperty());
        bChLbl.textProperty().bind(blueChuiProperty().asString());
        rChLbl.textProperty().bind(redChuiProperty().asString());
        bKChLabel.textProperty().bind(blueKamChumProperty().asString());
        rKChLabel.textProperty().bind(redKamChumProperty().asString());
        winTeamBlue.textProperty().bind(blueWinnerProperty().asString());
        winTeamRed.textProperty().bind(redWinnerProperty().asString());
        visibleScoreBoardController.blueWinner.textProperty().bind(blueWinnerProperty().asString());
        visibleScoreBoardController.redWinner.textProperty().bind(redWinnerProperty().asString());

        redResultProperty().addListener((observable, oldValue, newValue) -> winner() );
        blueResultProperty().addListener((observable, oldValue, newValue) ->  winner() );
        redPoint1Property().addListener((observable, oldValue, newValue) -> countJudges() );
        redPoint2Property().addListener((observable, oldValue, newValue) -> countJudges() );
        redPoint3Property().addListener((observable, oldValue, newValue) -> countJudges() );
        redPoint4Property().addListener((observable, oldValue, newValue) -> countJudges() );
        bluePoint1Property().addListener((observable, oldValue, newValue) -> countJudges() );
        bluePoint2Property().addListener((observable, oldValue, newValue) -> countJudges() );
        bluePoint3Property().addListener((observable, oldValue, newValue) -> countJudges() );
        bluePoint4Property().addListener((observable, oldValue, newValue) -> countJudges() );

        //Red Timyo indicator
        redTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> timyoIndicator(mouseEvent, redOpacity, redTimyo, visibleScoreBoardController.redTimyoIm, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property()));

        //Blue Timyo indicator
        blueTimyo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> timyoIndicator(mouseEvent, blueOpacity, blueTimyo, visibleScoreBoardController.blueTimyoIm, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(), bluePoint4Property()));

        //Red Chuis
        rChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setChuis(mouseEvent, redChui, redOpacity, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property(), 3, 4));

        //Blue Chuis
        bChLbl.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setChuis(mouseEvent, blueChui, blueOpacity, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(),bluePoint4Property(), 1, 2));

        //Blue Kam Chum
        bKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setKamChum(mouseEvent, blueKamChum, bluePoint1Property(), bluePoint2Property(), bluePoint3Property(),bluePoint4Property(), visibleScoreBoardController.bKamChum1, visibleScoreBoardController.bKamChum2));

        //Red Kam Chum
        rKChLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent-> setKamChum(mouseEvent, redKamChum, redPoint1Property(), redPoint2Property(), redPoint3Property(), redPoint4Property(), visibleScoreBoardController.rKamChum1, visibleScoreBoardController.rKamChum2));

        categories.setItems(FXCollections.observableArrayList("Отборно юноши(14-15)", "Отборно юноши(16-17)","Отборно девойки(14-15)","Отборно девойки(16-17)","Отборно мъже","Отборно жени"));
        categories.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            refresh();
            visibleScoreBoardController.category.setText(categories.getSelectionModel().getSelectedItem());
        });
        CustomComboBox comboBox = new CustomComboBox(categories);

        refreshButt.setOnAction(e-> refresh());
        refreshButt.setAccelerator(new KeyCodeCombination(KeyCode.F5));
        grid.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> grid.requestFocus());

        customTimeline = new CustomTimeline(this, 2, 59);
        Thread timerThread = new Thread(customTimeline);
        timerThread.start();

        rightArrow.setOnAction(e -> {
            switch(round){
                case 1:
                    customTimeline.pause();
                    roundLabelProperty().setValue("Рунд 2");
                    secondsLabelProperty().setValue(String.format("%02d", 0));
                    minutesProperty().setValue(2);
                    customTimeline = new CustomTimeline(this, 2, 59);
                    round = 2;
                    RoundWin();
                    partial_refresh();
                    break;
                case 2:
                    customTimeline.pause();
                    roundLabelProperty().setValue("Рунд 3");
                    secondsLabelProperty().setValue(String.format("%02d", 0));
                    minutesProperty().setValue(2);
                    customTimeline = new CustomTimeline(this, 2, 59);
                    round = 3;
                    RoundWin();
                    partial_refresh();
                    break;
                case 3:
                    customTimeline.pause();
                    roundLabelProperty().setValue("Рунд 4");
                    minutesProperty().setValue(2);
                    secondsLabelProperty().setValue(String.format("%02d", 0));
                    customTimeline = new CustomTimeline(this, 2, 59);
                    round = 4;
                    RoundWin();
                    partial_refresh();
                    break;
                case 4:
                    customTimeline.pause();
                    roundLabelProperty().setValue("Рунд 5");
                    minutesProperty().setValue(2);
                    secondsLabelProperty().setValue(String.format("%02d", 0));
                    customTimeline = new CustomTimeline(this, 2, 59);
                    round = 5;
                    RoundWin();
                    partial_refresh();
                    break;
                case 5:
                    customTimeline.pause();
                    refresh();
                    break;
            }
        });

        timerPane.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if(MouseButton.PRIMARY.equals(mouseEvent.getButton())){
                customTimeline.play();
            }else customTimeline.pause();
        });

        Judge socket1 = new Judge(8886,redPoint1Property(), bluePoint1Property());
        Thread socketThread1 = new Thread(socket1);
        Judge socket2 = new Judge(8887, redPoint2Property(), bluePoint2Property());
        Thread socketThread2 = new Thread(socket2);
        Judge socket3 = new Judge(8888, redPoint3Property(), bluePoint3Property());
        Thread socketThread3 = new Thread(socket3);
        Judge socket4 = new Judge(8889, redPoint4Property(), bluePoint4Property());
        Thread socketThread4 = new Thread(socket4);
        socketThread1.start();
        socketThread2.start();
        socketThread3.start();
        socketThread4.start();
    }

    private void winner(){
        if (redResult.get() > blueResult.get() && redResult.get() >= 2){
            resultLabel.setValue("Червеният води");
        }else if(redResult.get() < blueResult.get() && blueResult.get() >= 2) {
            resultLabel.setValue("Синият води");
        }else if(redResult.get() == blueResult.get() || redResult.get() == 1 || blueResult.get() == 1){
            resultLabel.setValue("Срещата е равна");
        }
    }

    private void partial_refresh(){
        customTimeline.pause();
        redKamChum.setValue(0);
        blueKamChum.setValue(0);
        redChui.setValue(0);
        blueChui.setValue(0);
        secondsLabelProperty().setValue("00");
        minutesProperty().setValue(2);
        customTimeline = new CustomTimeline(this, 2, 59);
        bluePoint1Property().setValue(-2);
        bluePoint2Property().setValue(-2);
        bluePoint3Property().setValue(-2);
        bluePoint4Property().setValue(-2);
        redPoint1Property().setValue(-2);
        redPoint2Property().setValue(-2);
        redPoint3Property().setValue(-2);
        redPoint4Property().setValue(-2);
        redResultProperty().setValue(0);
        blueResultProperty().setValue(0);
        blueTimyo.setOpacity(0.1);
        redTimyo.setOpacity(0.1);
        redOpacity.setValue(false);
        blueOpacity.setValue(false);
        visibleScoreBoardController.setColor();
        visibleScoreBoardController.setOpacity();
        visibleScoreBoardController.redChuiBackground.setVisible(false);
        visibleScoreBoardController.blueChuiBackground.setVisible(false);
        visibleScoreBoardController.manyBChLabel.setVisible(false);
        visibleScoreBoardController.manyRChLabel.setVisible(false);
    }

    private void refresh(){
        customTimeline.pause();
        redKamChum.setValue(0);
        blueKamChum.setValue(0);
        redChui.setValue(0);
        blueChui.setValue(0);
        round = 1;
        secondsLabelProperty().setValue("00");
        minutesProperty().setValue(2);
        customTimeline = new CustomTimeline(this, 2, 59);
        bluePoint1Property().setValue(-2);
        bluePoint2Property().setValue(-2);
        bluePoint3Property().setValue(-2);
        bluePoint4Property().setValue(-2);
        redPoint1Property().setValue(-2);
        redPoint2Property().setValue(-2);
        redPoint3Property().setValue(-2);
        redPoint4Property().setValue(-2);
        redResultProperty().setValue(0);
        blueResultProperty().setValue(0);
        blueWinner.setValue(0);
        redWinner.setValue(0);
        roundLabelProperty().setValue("Рунд 1");
        blueTimyo.setOpacity(0.1);
        redTimyo.setOpacity(0.1);
        redOpacity.setValue(false);
        blueOpacity.setValue(false);
        visibleScoreBoardController.setColor();
        visibleScoreBoardController.setOpacity();
        visibleScoreBoardController.redChuiBackground.setVisible(false);
        visibleScoreBoardController.blueChuiBackground.setVisible(false);
        visibleScoreBoardController.manyBChLabel.setVisible(false);
        visibleScoreBoardController.manyRChLabel.setVisible(false);

    }

    private void RoundWin(){
        if(redResult.get() > blueResult.get()){
            redWinner.setValue(redWinner.get() + 2);
        }else
        if(redResult.get() < blueResult.get()){
            blueWinner.setValue(blueWinner.get() + 2);
        }else
        if(redResult.get() == blueResult.get()){
            redWinner.setValue(redWinner.get() + 1);
            blueWinner.setValue(blueWinner.get() + 1);
        }
    }

    private synchronized void ChangeLabels(int point, SimpleIntegerProperty sIntProp1, SimpleIntegerProperty sIntProp2, SimpleIntegerProperty sIntProp3, SimpleIntegerProperty sIntProp4 ){
        List<SimpleIntegerProperty> simpleIntegerProperties = new ArrayList<>(Arrays.asList(sIntProp1,sIntProp2, sIntProp3, sIntProp4));
        simpleIntegerProperties.forEach(e-> e.setValue(e.get() + point));
    }

    private synchronized void setKamChum(MouseEvent mouseEvent, SimpleIntegerProperty kamChum, SimpleIntegerProperty sIntP1, SimpleIntegerProperty sIntP2, SimpleIntegerProperty sIntP3, SimpleIntegerProperty sIntP4, Rectangle rectangle1, Rectangle rectangle2){
        if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
            kamChum.setValue(kamChum.get()+1);
            visibleScoreBoardController.setKamChum(kamChum.get(), 1, rectangle1, rectangle2);
            ChangeLabels(-1, sIntP1, sIntP2, sIntP3, sIntP4);
        } else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
            kamChum.setValue(kamChum.get()-1);
            visibleScoreBoardController.setKamChum(kamChum.get(), 0, rectangle1, rectangle2);
            ChangeLabels(1, sIntP1, sIntP2, sIntP3, sIntP4);
        }
    }

    private synchronized void timyoIndicator(MouseEvent e, SimpleBooleanProperty op, ImageView controllerImgView, ImageView visibleControllerImgView, SimpleIntegerProperty sIntP1, SimpleIntegerProperty sIntP2, SimpleIntegerProperty sIntP3, SimpleIntegerProperty sIntP4){
        if (MouseButton.PRIMARY.equals(e.getButton()) && !op.get()) {
            controllerImgView.setOpacity(1);
            try {
                visibleScoreBoardController.setTimyoIm(1, visibleControllerImgView);
            }catch (NullPointerException ex){
                ex.printStackTrace();
            }
            ChangeLabels(2, sIntP1, sIntP2, sIntP3, sIntP4);
            op.setValue(true);
        }
        else if (MouseButton.SECONDARY.equals(e.getButton()) && op.get()) {
            controllerImgView.setOpacity(0.1);
            try {
                visibleScoreBoardController.setTimyoIm(0.1, visibleControllerImgView);
            }catch (NullPointerException ex){
                ex.printStackTrace();
            }
            ChangeLabels(-2, sIntP1, sIntP2, sIntP3, sIntP4);
            op.setValue(false);

        }
    }

    private synchronized void setChuis(MouseEvent mouseEvent, SimpleIntegerProperty chuis, SimpleBooleanProperty op, SimpleIntegerProperty sIntProp1, SimpleIntegerProperty sIntProp2, SimpleIntegerProperty sIntProp3, SimpleIntegerProperty sIntProp4, int set, int unset){
        if (MouseButton.PRIMARY.equals(mouseEvent.getButton())) {
            chuis.setValue(chuis.get()+1);
            visibleScoreBoardController.setChuiCircles(chuis.get(), set);
            if(chuis.get() % 3 == 0){
                ChangeLabels(-1, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
            }
        }
        else if (MouseButton.SECONDARY.equals(mouseEvent.getButton())) {
            chuis.setValue(chuis.get()-1);
            visibleScoreBoardController.setChuiCircles(chuis.get(), unset);
            if(chuis.get() % 3 == 0){
                ChangeLabels(1, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
                if  (chuis.get() == 0 && !op.get()){
                    blueChui.setValue(0);
                    ChangeLabels(0, sIntProp1, sIntProp2, sIntProp3, sIntProp4);
                }
            }
        }
    }

    private synchronized void countJudges(){
        int redCount = 0, blueCount = 0;

        if(redPoint1Property().get() == bluePoint1Property().get() && redGiven1.get()){
            visibleScoreBoardController.J1Rect.setFill(Color.web("#d1d1d1"));
            redCount--;
            if(redCount == -1){
                redCount++;
            }
            redGiven1.setValue(false);
        }else if(redPoint1Property().get() == bluePoint1Property().get() && blueGiven1.get()){
            visibleScoreBoardController.J1Rect.setFill(Color.web("#d1d1d1"));
            blueCount--;if(blueCount == -1){
                blueCount++;
            }
            blueGiven1.setValue(false);
        }else if(redPoint1Property().get() > bluePoint1Property().get()){
            visibleScoreBoardController.J1Rect.setFill(Color.RED);
            redCount++;
            redGiven1.setValue(true);
        }else if(redPoint1Property().get() < bluePoint1Property().get()){
            visibleScoreBoardController.J1Rect.setFill(Color.BLUE);
            blueCount++;
            blueGiven1.setValue(true);
        }

        if(redPoint2Property().get() == bluePoint2Property().get() && redGiven2.get()){
            visibleScoreBoardController.J2Rect.setFill(Color.web("#d1d1d1"));
            redCount--;
            if(redCount == -1){
                redCount++;
            }
            redGiven2.setValue(false);
        }else if(redPoint2Property().get() == bluePoint2Property().get() && blueGiven2.get()){
            visibleScoreBoardController.J2Rect.setFill(Color.web("#d1d1d1"));
            blueCount--;if(blueCount == -1){
                blueCount++;
            }
            blueGiven2.setValue(false);
        }else if(redPoint2Property().get() > bluePoint2Property().get()){
            visibleScoreBoardController.J2Rect.setFill(Color.RED);
            redCount++;
            redGiven2.setValue(true);
        }else if(redPoint2Property().get() < bluePoint2Property().get()){
            visibleScoreBoardController.J2Rect.setFill(Color.BLUE);
            blueCount++;
            blueGiven2.setValue(true);
        }

        if(redPoint3Property().get() == bluePoint3Property().get() && redGiven3.get()){
            visibleScoreBoardController.J3Rect.setFill(Color.web("#d1d1d1"));
            redCount--;
            if(redCount == -1){
                redCount++;
            }
            redGiven3.setValue(false);
        }else if(redPoint3Property().get() == bluePoint3Property().get() && blueGiven3.get()){
            visibleScoreBoardController.J3Rect.setFill(Color.web("#d1d1d1"));
            blueCount--;if(blueCount == -1){
                blueCount++;
            }
            blueGiven3.setValue(false);
        }else if(redPoint3Property().get() > bluePoint3Property().get()){
            visibleScoreBoardController.J3Rect.setFill(Color.RED);
            redCount++;
            redGiven3.setValue(true);
        }else if(redPoint3Property().get() < bluePoint3Property().get()){
            visibleScoreBoardController.J3Rect.setFill(Color.BLUE);
            blueCount++;
            blueGiven3.setValue(true);
        }

        if(redPoint4Property().get() == bluePoint4Property().get() && redGiven4.get()){
            visibleScoreBoardController.J4Rect.setFill(Color.web("#d1d1d1"));
            redCount--;
            if(redCount == -1){
                redCount++;
            }
            redGiven4.setValue(false);
        }else if(redPoint4Property().get() == bluePoint4Property().get() && blueGiven4.get()){
            visibleScoreBoardController.J4Rect.setFill(Color.web("#d1d1d1"));
            blueCount--;if(blueCount == -1){
                blueCount++;
            }
            blueGiven4.setValue(false);
        }else if(redPoint4Property().get() > bluePoint4Property().get()){
            visibleScoreBoardController.J4Rect.setFill(Color.RED);
            redCount++;
            redGiven4.setValue(true);
        }else if(redPoint4Property().get() < bluePoint4Property().get()){
            visibleScoreBoardController.J4Rect.setFill(Color.BLUE);
            blueCount++;
            blueGiven4.setValue(true);
        }
        if(redCount == -1){
            redCount++;
        }else if(blueCount == -1){
            blueCount++;
        }
        blueResult.setValue(blueCount);
        redResult.setValue(redCount);

    }
}
