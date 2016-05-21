/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayoayoboardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author Odigie Oseme Utibe | osemeodigie@yahoo.com | http://osemeodigie.com
 */
    // This is used to handle the menu screen in the application...
public class MenuScreen extends StackPane {

    private AyoGameManager gameManager;
    private VBox centerWindowArea = new VBox(); // center view
    private TextFlow howToPlayText;
    
    private int count = 0;
    
    public MenuScreen(AyoGameManager gameManager) {
        
        this.gameManager = gameManager;
        centerWindowArea.getChildren().clear();
        centerWindowArea.setAlignment(Pos.CENTER);
        centerWindowArea.setId("menuScreen-Box");
        getChildren().add(centerWindowArea);
        howToPlayText = new TextFlow();
    }
    
    public Pane getMainMenuScreen(){
        
            // Remove all the children nodes from this menu screen
        centerWindowArea.getChildren().clear();
     //   getChildren().clear();
             // add the menu buttons here...
        addMainMenuBtns();
        return this;
    }
    
    public Pane getComputerPlayerMenuScreen(){
        
            // Remove all the children nodes from this menu screen
        centerWindowArea.getChildren().clear();
             // add the menu buttons here...
        addComputerPlayerMenuItems();
        return this;
    }
    
     public Pane getMultiPlayerMenuScreen(){
        
            // Remove all the children nodes from this menu screen
        centerWindowArea.getChildren().clear();
             // add the menu buttons here...
        addMultiPlayerMenuItems();
        return this;
    }
     
    public Pane getOptionsMenuScreen(){
        
            // Remove all the children nodes from this menu screen
        centerWindowArea.getChildren().clear();
             // add the menu items here...
        addOptionsMenuItems();
        return this;
    }
    
    public Pane getHowToPlayMenuScreen(){
        
            // Remove all the children nodes from this menu screen
        centerWindowArea.getChildren().clear();
             // add the menu items here...
        addHowToPlayMenuItems();
        return this;
    }
    
    
    
    private void addMainMenuBtns(){
                
        Text scenetitle = new Text("Welcome to AyoAyo Game");
        scenetitle.setId("welcome-text");
 
        Label playerSelectText = new Label("Player Vs:");
        playerSelectText.getStyleClass().add("select-player-type-text");
        
        RadioButton computer = new RadioButton("Computer");
        if(!gameManager.isHumanplayer){
            computer.setSelected(true);
            computer.requestFocus();
        }
        computer.getStyleClass().add("menu-radios");
        computer.setId("computer-radio");
        
        RadioButton human = new RadioButton("Human");
        if(gameManager.isHumanplayer){
            human.setSelected(true);
            human.requestFocus();
        }
        human.getStyleClass().add("menu-radios");
        
        final ToggleGroup radioGroup = new ToggleGroup();
        radioGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldValue, Toggle newValue) -> {
            if(radioGroup.getSelectedToggle() != null){
                RadioButton checked = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                gameManager.isHumanplayer = (checked == human);
            }
            else{
                gameManager.isHumanplayer = false;
            }
        });
               
        computer.setToggleGroup(radioGroup);
        human.setToggleGroup(radioGroup);
                
        GridPane playerSelectBox = new GridPane();
        playerSelectBox.setPadding(new Insets(10,5,10,5));
        playerSelectBox.setMinWidth(500);
        playerSelectBox.setPrefWidth(500);
        playerSelectBox.setMaxWidth(500);
        playerSelectBox.add(playerSelectText, 0, 0);
        playerSelectBox.add(computer, 1, 0);
        playerSelectBox.add(human, 2, 0);
        
        count  = 0;
        playerSelectBox.getChildren().stream().map((n) -> {
            
            count ++;
            // Check whether the grid cell content is a control or pane and style accordily
            if (n instanceof Control){
                Control c = (Control)n;
                c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                c.setId("player-select-box-"+count);
            //    c.setStyle("-fx-background-color: cornsilk; -fx-alignment: center;");
            }
            return n;
        }).filter((n) -> (n instanceof Pane)).map((n) -> (Pane)n).map((c) -> {
            c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            return c;
        }).forEach((c) -> {
            c.setId("player-select-box-"+count);
         //   c.setStyle("-fx-background-color: cornsilk; -fx-alignment: center;"); 
        });
        
        ColumnConstraints _3Columns1,_3Columns2;
        _3Columns1 = new ColumnConstraints();
        _3Columns1.setPercentWidth(100/3.0); // divide into three places...
        _3Columns1.setHalignment(HPos.LEFT);
        
        _3Columns2 = new ColumnConstraints();
        _3Columns2.setPercentWidth(100/3.0); // divide into three places...
        _3Columns2.setHalignment(HPos.CENTER);
        
        playerSelectBox.getColumnConstraints().addAll(_3Columns1,_3Columns2,_3Columns2);
        
        Button optionsBtn = new Button("Options");
        optionsBtn.getStyleClass().add("main-menu-btns");
            optionsBtn.setOnAction((ActionEvent event) -> {
            // go to the option menu here...
            gameManager.optionsMenuScreen();
        });
        
        Button howToPlayBtn = new Button("How To Play");
        howToPlayBtn.getStyleClass().add("main-menu-btns");
        howToPlayBtn.setOnAction((ActionEvent event) -> {
            // go to the how to play menu here...
            gameManager.howToPlayMenuScreen();
        });
            
        Button nextBtn = new Button("Play");
        nextBtn.getStyleClass().add("okay-btn");
        nextBtn.setAlignment(Pos.CENTER_RIGHT);
        nextBtn.setOnAction((ActionEvent event) -> {
            
            if(!gameManager.isHumanplayer){
                
               gameManager.computerPlayerMenuScreen();
            }
            else{
               gameManager.multiPlayerMenuScreen();
            }
            
        });
        
        
        GridPane menuFooterBtns = new GridPane();
        menuFooterBtns.setPadding(new Insets(10,5,10,5));
        menuFooterBtns.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        menuFooterBtns.setMinWidth(500);
        menuFooterBtns.setPrefWidth(500);
        menuFooterBtns.setMaxWidth(500);
        menuFooterBtns.add(nextBtn, 1, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/2.0); // divide into two places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/2.0); // divide into two places...
        twoColumns2.setHalignment(HPos.RIGHT);
        menuFooterBtns.getColumnConstraints().addAll(twoColumns,twoColumns2);
        
        VBox centerMenu = new VBox(20);
        centerMenu.setAlignment(Pos.CENTER);
        centerMenu.getStyleClass().add("center-menu-box");
        centerMenu.getChildren().addAll(scenetitle,playerSelectBox,optionsBtn,howToPlayBtn,menuFooterBtns);
        
        HBox centerMenuHorizontal = new HBox(20);
        centerMenuHorizontal.setAlignment(Pos.CENTER);
        centerMenuHorizontal.getChildren().add(centerMenu);
        
        centerWindowArea.getChildren().addAll(centerMenuHorizontal); 
    }
    
    
    private void addComputerPlayerMenuItems(){
                   
        Text scenetitle = new Text("Play with Computer");
        scenetitle.setId("welcome-text");
        
        Label playerNameLabel = new Label("Player's name:");
        playerNameLabel.getStyleClass().add("player-names-label");
        
        TextField playerTextField = new TextField();
        MenuScreen.addTextFieldLimiter(playerTextField,10);
        playerTextField.setPromptText("Enter your name");
        playerTextField.setFocusTraversable(false);
        playerTextField.getStyleClass().add("player-names-box");
        
        Text playerTextFieldError = new Text();
        playerTextFieldError.setId("text-field-error");
        
        Label playerTypeSelectText = new Label("Choose a difficulty level:");
        playerTypeSelectText.getStyleClass().add("player-names-label");
        
        RadioButton beginner = new RadioButton("Beginner");
        beginner.getStyleClass().add("menu-radios");
        
        RadioButton intermidate = new RadioButton("Intermidate");
        intermidate.getStyleClass().add("menu-radios");
        
        RadioButton hard = new RadioButton("Hard");
        hard.getStyleClass().add("menu-radios");
        
        RadioButton veteran = new RadioButton("Veteran");
        veteran.getStyleClass().add("menu-radios");
        
        final ToggleGroup radioGroup = new ToggleGroup();
        radioGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldValue, Toggle newValue) -> {
            if(radioGroup.getSelectedToggle() != null){
                RadioButton checked = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                gameManager.computerPlayer.setPlayerType(checked.getText());
            }
            else{
                gameManager.computerPlayer.setPlayerType(beginner.getText());
            }
        });
        beginner.setToggleGroup(radioGroup);
        intermidate.setToggleGroup(radioGroup);
        hard.setToggleGroup(radioGroup);
        veteran.setToggleGroup(radioGroup);
        
        switch(gameManager.computerPlayer.getPlayerType()){
            case "BEGINNER":
                beginner.setSelected(true);
                beginner.requestFocus();
            break;

            case "INTERMIDATE":
                intermidate.setSelected(true);
                intermidate.requestFocus();
            break;

            case "HARD":
                hard.setSelected(true);
                hard.requestFocus();
            break;

            case "VETERAN":
                veteran.setSelected(true);
                veteran.requestFocus();
            break; 
        } 

        Label whoStartsFirstText = new Label("Who Starts First:");
        whoStartsFirstText.getStyleClass().add("player-names-label");
        
        RadioButton human = new RadioButton("You");
        human.getStyleClass().add("menu-radios");
        
        RadioButton ai = new RadioButton("Computer");
        ai.getStyleClass().add("menu-radios");
        final ToggleGroup radioStartsFirstGroup = new ToggleGroup();
        radioStartsFirstGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,
                Toggle oldValue, Toggle newValue) -> {
            if(radioStartsFirstGroup.getSelectedToggle() != null)
            {
                RadioButton checked = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                 if(checked == human){
                    gameManager.whoStartsFirst = 1;
                 }
                 else{
                    gameManager.whoStartsFirst = 0;
                 }
            }
            else{
               gameManager.whoStartsFirst = 1;
            }
        });
        human.setToggleGroup(radioStartsFirstGroup);
        ai.setToggleGroup(radioStartsFirstGroup);
        if(gameManager.whoStartsFirst == 1){
            human.setSelected(true);
            human.requestFocus();
        }
        else{
            ai.setSelected(true);
            ai.requestFocus();            
        }
 
        GridPane computerPlayerForm = new GridPane();
        computerPlayerForm.setPadding(new Insets(10,5,40,5));
        computerPlayerForm.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        computerPlayerForm.setMinWidth(500);
        computerPlayerForm.setPrefWidth(500);
        computerPlayerForm.setMaxWidth(500);
        
        computerPlayerForm.add(playerNameLabel, 1, 0,4,1);
        computerPlayerForm.add(playerTextField, 1, 1,4,1);
        computerPlayerForm.add(playerTextFieldError, 1, 2,4,1);
        
        computerPlayerForm.add(playerTypeSelectText, 1, 4,4,1);
        computerPlayerForm.add(beginner, 2, 5,2,1);
        computerPlayerForm.add(intermidate, 2, 6,2,1);
        computerPlayerForm.add(hard, 4, 5,2,1);
        computerPlayerForm.add(veteran, 4, 6,2,1);
        
        computerPlayerForm.add(whoStartsFirstText, 1, 8,4,1);
        computerPlayerForm.add(human, 1, 9,2,1);
        computerPlayerForm.add(ai, 3, 9,2,1);
        
        computerPlayerForm.getChildren().stream().map((n) -> {
            
            // Check whether the grid cell content is a control or pane and style accordily
            if (n instanceof Control){
                Control c = (Control)n;
                c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            }
            return n;
        }).filter((n) -> (n instanceof Pane)).map((n) -> (Pane)n).map((c) -> {
            c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            return c;
        });
        
        ColumnConstraints _3Columns1,_3Columns2;
        _3Columns1 = new ColumnConstraints();
        _3Columns1.setPercentWidth(100/6.0); // divide into six places...
        _3Columns1.setHalignment(HPos.LEFT);
        
        _3Columns2 = new ColumnConstraints();
        _3Columns2.setPercentWidth(100/6.0); // divide into six places...
        _3Columns2.setHalignment(HPos.CENTER);
        computerPlayerForm.getColumnConstraints().addAll(_3Columns2,_3Columns2,_3Columns1,_3Columns2,_3Columns1,_3Columns2);
        
        RowConstraints _rows;
        _rows = new RowConstraints();
        _rows.setPercentHeight(100/10.0); // divide into Four places...
        computerPlayerForm.getRowConstraints().addAll(_rows,_rows,_rows,_rows,_rows,_rows,_rows,_rows,_rows,_rows);
        
        Button backBtn = new Button("Go Back");
        backBtn.getStyleClass().add("back-btn");
        backBtn.setAlignment(Pos.CENTER_LEFT);
        backBtn.setOnAction((ActionEvent event) -> {
            gameManager.menuScreen();
        });        
        
        Button nextBtn = new Button("Start Game");
        nextBtn.getStyleClass().add("okay-btn");
        nextBtn.setAlignment(Pos.CENTER_RIGHT);
        nextBtn.setOnAction((ActionEvent event) -> {
            
           // push all relevant data and start game...
            playerTextFieldError.setText("");
            if(playerTextField.getText().isEmpty()){
                playerTextFieldError.setText("You have to supply your name");
            }
            if(!playerTextField.getText().isEmpty()){
                gameManager.playerOneName = gameManager.computerPlayer.Name;
                gameManager.playerTwoName = playerTextField.getText();
                gameManager.newGame();
            } 
        });
        
        GridPane menuFooterBtns = new GridPane();
        menuFooterBtns.setPadding(new Insets(10,5,10,5));
        menuFooterBtns.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        menuFooterBtns.setMinWidth(500);
        menuFooterBtns.setPrefWidth(500);
        menuFooterBtns.setMaxWidth(500);
        menuFooterBtns.add(backBtn, 0, 0);
        menuFooterBtns.add(nextBtn, 1, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/2.0); // divide into two places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/2.0); // divide into two places...
        twoColumns2.setHalignment(HPos.RIGHT);
        menuFooterBtns.getColumnConstraints().addAll(twoColumns,twoColumns2);
        
        VBox centerMenu = new VBox(20);
        centerMenu.setAlignment(Pos.CENTER);
        centerMenu.getStyleClass().add("center-menu-box");
        centerMenu.getChildren().addAll(scenetitle,computerPlayerForm,menuFooterBtns);
        
        HBox centerMenuHorizontal = new HBox(20);
        centerMenuHorizontal.setAlignment(Pos.CENTER);
        centerMenuHorizontal.getChildren().add(centerMenu);
        
        centerWindowArea.getChildren().addAll(centerMenuHorizontal);
        
    }
    
    private void addMultiPlayerMenuItems(){
                
        Text scenetitle = new Text("Multi-Player Mode");
        scenetitle.setId("welcome-text");

        Label playerOneLabel = new Label("Player one:");
        playerOneLabel.getStyleClass().add("player-names-label");
        TextField playerOneTextField = new TextField();
        playerOneTextField.setPromptText("Enter player one's name");
        addTextFieldLimiter(playerOneTextField,10);
        playerOneTextField.setFocusTraversable(false);
        playerOneTextField.getStyleClass().add("player-names-box");
        
        Text playerOneTextFieldError = new Text();
        playerOneTextFieldError.setId("text-field-error");
        
        Label playerTwoLabel = new Label("Player two:");
        playerTwoLabel.getStyleClass().add("player-names-label");
        TextField playerTwoTextField = new TextField();
        playerTwoTextField.setPromptText("Enter player two's name");
        addTextFieldLimiter(playerTwoTextField,10);
        playerTwoTextField.setFocusTraversable(false);
        playerTwoTextField.getStyleClass().add("player-names-box");
        
        Text playerTwoTextFieldError = new Text();
        playerTwoTextFieldError.setId("text-field-error");
        
        
        GridPane playersNameForm = new GridPane();
        playersNameForm.setPadding(new Insets(10,5,40,5));
        playersNameForm.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        playersNameForm.setMinWidth(500);
        playersNameForm.setPrefWidth(500);
        playersNameForm.setMaxWidth(500);
        playersNameForm.add(playerOneLabel, 1, 0,4,1);
        playersNameForm.add(playerOneTextField, 1, 1,4,1);
        playersNameForm.add(playerOneTextFieldError, 1, 2,4,1);
        
        playersNameForm.add(playerTwoLabel, 1, 4,4,1);
        playersNameForm.add(playerTwoTextField, 1, 5,4,1);
        playersNameForm.add(playerTwoTextFieldError, 1, 6,4,1);
        
        playersNameForm.getChildren().stream().map((n) -> {
            
            // Check whether the grid cell content is a control or pane and style accordily
            if (n instanceof Control){
                Control c = (Control)n;
                c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            }
            return n;
        }).filter((n) -> (n instanceof Pane)).map((n) -> (Pane)n).map((c) -> {
            c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            return c;
        });
        
        ColumnConstraints _3Columns1,_3Columns2;
        _3Columns1 = new ColumnConstraints();
        _3Columns1.setPercentWidth(100/6.0); // divide into six places...
        _3Columns1.setHalignment(HPos.LEFT);
        
        _3Columns2 = new ColumnConstraints();
        _3Columns2.setPercentWidth(100/6.0); // divide into six places...
        _3Columns2.setHalignment(HPos.CENTER);
        playersNameForm.getColumnConstraints().addAll(_3Columns1,_3Columns2,_3Columns2,_3Columns2,_3Columns2,_3Columns2);
        
        RowConstraints _rows;
        _rows = new RowConstraints();
        _rows.setPercentHeight(100/7.0); // divide into Four places...
        playersNameForm.getRowConstraints().addAll(_rows,_rows,_rows,_rows,_rows,_rows,_rows);
        
        Button backBtn = new Button("Go Back");
        backBtn.getStyleClass().add("back-btn");
        backBtn.setAlignment(Pos.CENTER_LEFT);
        backBtn.setOnAction((ActionEvent event) -> {
            gameManager.menuScreen();
        });        
        
        Button nextBtn = new Button("Start Game");
        nextBtn.getStyleClass().add("okay-btn");
        nextBtn.setAlignment(Pos.CENTER_RIGHT);
        nextBtn.setOnAction((ActionEvent event) -> {
            
            playerOneTextFieldError.setText("");
            playerTwoTextFieldError.setText("");
            gameManager.whoStartsFirst = 1; // Player one always starts first...
           // push all relevant data and start game...
            if(playerOneTextField.getText().isEmpty()){
                playerOneTextFieldError.setText("You have to supply a name for player 1");
            }
            if(playerTwoTextField.getText().isEmpty()){
                playerTwoTextFieldError.setText("You have to supply a name for player 2");
            }
            if(!playerOneTextField.getText().isEmpty() && !playerTwoTextField.getText().isEmpty()){
                gameManager.playerOneName = playerOneTextField.getText();
                gameManager.playerTwoName = playerTwoTextField.getText();
                gameManager.whoStartsFirst = 0; // player 1 starts first...
                gameManager.newGame();
            }  
        });
        
        
        GridPane menuFooterBtns = new GridPane();
        menuFooterBtns.setPadding(new Insets(10,5,10,5));
        menuFooterBtns.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        menuFooterBtns.setMinWidth(500);
        menuFooterBtns.setPrefWidth(500);
        menuFooterBtns.setMaxWidth(500);
        menuFooterBtns.add(backBtn, 0, 0);
        menuFooterBtns.add(nextBtn, 1, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/2.0); // divide into two places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/2.0); // divide into two places...
        twoColumns2.setHalignment(HPos.RIGHT);
        menuFooterBtns.getColumnConstraints().addAll(twoColumns,twoColumns2);
        
        VBox centerMenu = new VBox(20);
        centerMenu.setAlignment(Pos.CENTER);
        centerMenu.getStyleClass().add("center-menu-box");
        centerMenu.getChildren().addAll(scenetitle,playersNameForm,menuFooterBtns);
        
        HBox centerMenuHorizontal = new HBox(20);
        centerMenuHorizontal.setAlignment(Pos.CENTER);
        centerMenuHorizontal.getChildren().add(centerMenu);
        
        centerWindowArea.getChildren().addAll(centerMenuHorizontal);
    }
    
    
    private void addOptionsMenuItems(){
                
        Text scenetitle = new Text("Game Options");
        scenetitle.setId("welcome-text");
                
        Label seedsPerHouseText = new Label("Initial seeds per House:");
        seedsPerHouseText.getStyleClass().add("player-names-label");
        
        RadioButton four = new RadioButton("Four");
        four.getStyleClass().add("menu-radios");
        
        RadioButton five = new RadioButton("Five");
        five.getStyleClass().add("menu-radios");
        
        RadioButton six = new RadioButton("Six");
        six.getStyleClass().add("menu-radios");
        
        RadioButton seven = new RadioButton("Seven");
        seven.getStyleClass().add("menu-radios");
        
        final ToggleGroup seedsPerHouseOptions = new ToggleGroup();
        seedsPerHouseOptions.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldValue, Toggle newValue) -> {
            if(seedsPerHouseOptions.getSelectedToggle() != null){
                RadioButton checked = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
               switch(checked.getText()){
                   
                   case "Four":
                       gameManager.seedPerHouse = 4;
                   break;
                       
                   case "Five":
                       gameManager.seedPerHouse = 5;
                   break;
                       
                   case "Six":
                       gameManager.seedPerHouse = 6;
                   break;
                       
                   case "Seven":
                       gameManager.seedPerHouse = 7;
                   break; 
               }
            }
            else{
                gameManager.seedPerHouse = 4;
            }
        });
        four.setToggleGroup(seedsPerHouseOptions);
        five.setToggleGroup(seedsPerHouseOptions);
        six.setToggleGroup(seedsPerHouseOptions);
        seven.setToggleGroup(seedsPerHouseOptions); 
        
        switch(gameManager.seedPerHouse){

            case 4:
                four.setSelected(true);
                four.requestFocus();
            break;

            case 5:
                five.setSelected(true);
                five.requestFocus();
            break;

            case 6:
                six.setSelected(true);
                six.requestFocus();
            break;

            case 7:
                seven.setSelected(true);
                seven.requestFocus();
            break; 
        }        

        
        Label gameMusicText = new Label("Music:");
        gameMusicText.getStyleClass().add("player-names-label");
        
        RadioButton musicON = new RadioButton("ON");
        musicON.getStyleClass().add("menu-radios");
        
        RadioButton musicOFF = new RadioButton("OFF");
        musicOFF.getStyleClass().add("menu-radios");
        final ToggleGroup gameMusicOptions = new ToggleGroup();
        gameMusicOptions.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,
                Toggle oldValue, Toggle newValue) -> {
            if(gameMusicOptions.getSelectedToggle() != null)
            {
                RadioButton checked = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                gameManager.isMusic = (checked == musicON);
                if(gameManager.isMusic){
                    gameManager.mediaPlayer.play();
                }
                else{
                    gameManager.mediaPlayer.stop();
                }
            }
            else{
               gameManager.isMusic = true;
               gameManager.mediaPlayer.play();
            }
        });
        musicON.setToggleGroup(gameMusicOptions);
        musicOFF.setToggleGroup(gameMusicOptions);
        if(gameManager.isMusic){
            musicON.setSelected(true);
            musicON.requestFocus();
        }
        else{
            musicOFF.setSelected(true);
            musicOFF.requestFocus();            
        }
   
        Label gameSoundText = new Label("Fx Sound:");
        gameSoundText.getStyleClass().add("player-names-label");
        
        RadioButton soundON = new RadioButton("ON");
        soundON.getStyleClass().add("menu-radios");
        
        RadioButton soundOFF = new RadioButton("OFF");
        soundOFF.getStyleClass().add("menu-radios");
        final ToggleGroup gameSoundOptions = new ToggleGroup();
        gameSoundOptions.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov,
                Toggle oldValue, Toggle newValue) -> {
            if(gameSoundOptions.getSelectedToggle() != null)
            {
                RadioButton checked = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                gameManager.isGameSound = (checked == soundON);
            }
            else{
                gameManager.isGameSound = true;
            }
        });
        soundON.setToggleGroup(gameSoundOptions);
        soundOFF.setToggleGroup(gameSoundOptions);
         if(gameManager.isGameSound){
            soundON.setSelected(true);
            soundON.requestFocus();
        }
        else{
            soundOFF.setSelected(true);
            soundOFF.requestFocus();            
        }       
 
        GridPane gameOptionsForm = new GridPane();
        gameOptionsForm.setPadding(new Insets(10,5,40,5));
        gameOptionsForm.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        gameOptionsForm.setMinWidth(500);
        gameOptionsForm.setPrefWidth(500);
        gameOptionsForm.setMaxWidth(500);
        
        gameOptionsForm.add(seedsPerHouseText, 1, 0,4,1);
        gameOptionsForm.add(four, 1, 1,2,1);
        gameOptionsForm.add(five, 3, 1,2,1);
        gameOptionsForm.add(six, 1, 2,2,1);
        gameOptionsForm.add(seven, 3, 2,2,1);
        
        gameOptionsForm.add(gameMusicText, 1, 4,2,1);
        gameOptionsForm.add(musicON, 3, 4,1,1);
        gameOptionsForm.add(musicOFF, 4, 4,1,1);
        
        gameOptionsForm.add(gameSoundText, 1, 6,2,1);
        gameOptionsForm.add(soundON, 3, 6,1,1);
        gameOptionsForm.add(soundOFF, 4, 6,1,1);
        
        gameOptionsForm.getChildren().stream().map((n) -> {
            
            // Check whether the grid cell content is a control or pane and style accordily
            if (n instanceof Control){
                Control c = (Control)n;
                c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            }
            return n;
        }).filter((n) -> (n instanceof Pane)).map((n) -> (Pane)n).map((c) -> {
            c.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            return c;
        });
        
        ColumnConstraints _3Columns1;
        _3Columns1 = new ColumnConstraints();
        _3Columns1.setPercentWidth(100/6.0); // divide into six places...
        _3Columns1.setHalignment(HPos.LEFT);
        
        gameOptionsForm.getColumnConstraints().addAll(_3Columns1,_3Columns1,_3Columns1,_3Columns1,_3Columns1,_3Columns1);
        
        RowConstraints _rows;
        _rows = new RowConstraints();
        _rows.setPercentHeight(100/7.0); // divide into Four places...
        gameOptionsForm.getRowConstraints().addAll(_rows,_rows,_rows,_rows,_rows,_rows,_rows);
              
        
        Button nextBtn = new Button("Save Settings");
        nextBtn.getStyleClass().add("okay-btn");
        nextBtn.setAlignment(Pos.CENTER_RIGHT);
        nextBtn.setOnAction((ActionEvent event) -> {
            gameManager.menuScreen();
        });
        
        
        GridPane menuFooterBtns = new GridPane();
        menuFooterBtns.setPadding(new Insets(10,5,10,5));
        menuFooterBtns.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        menuFooterBtns.setMinWidth(500);
        menuFooterBtns.setPrefWidth(500);
        menuFooterBtns.setMaxWidth(500);
        menuFooterBtns.add(nextBtn, 1, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/2.0); // divide into two places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/2.0); // divide into two places...
        twoColumns2.setHalignment(HPos.RIGHT);
        menuFooterBtns.getColumnConstraints().addAll(twoColumns,twoColumns2);
        
        VBox centerMenu = new VBox(20);
        centerMenu.setAlignment(Pos.CENTER);
        centerMenu.getStyleClass().add("center-menu-box");
        centerMenu.getChildren().addAll(scenetitle,gameOptionsForm,menuFooterBtns);
        
        HBox centerMenuHorizontal = new HBox(20);
        centerMenuHorizontal.setAlignment(Pos.CENTER);
        centerMenuHorizontal.getChildren().add(centerMenu);
        
        centerWindowArea.getChildren().addAll(centerMenuHorizontal); 
    }
    
    private void addHowToPlayMenuItems(){
                
        Text scenetitle = new Text("How To Play");
        scenetitle.setId("welcome-text");
       
        if(howToPlayText.getChildren().isEmpty()){
            BufferedReader bf = null;
            StringBuilder sb = new StringBuilder();
            
            try{
                bf = new BufferedReader(new InputStreamReader(AyoAyoBoardGame.class.getResourceAsStream(GameAssets.HOW_TO_PLAY_DOC_LOCATION)));
                char[] buf = new char[1024];
                int i = 0;
                while((i = bf.read(buf)) != -1){
                    sb.append(String.valueOf(buf));
                    buf = new char[1024];
                }
            }
            catch(IOException e){ }
            finally{
                if(bf!=null){
                    try{bf.close();}catch(Exception ex){}
                }
            }
            Text theText = new Text(sb.toString());
            theText.setFill(Color.WHITE);
            theText.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR,18));
            howToPlayText.getChildren().add(theText); 
            howToPlayText.getStyleClass().add("how-to-play-text");
        }   

            ScrollPane howToPlayScroll = new ScrollPane();
            howToPlayScroll.setContent(howToPlayText);
            howToPlayScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            howToPlayScroll.getStyleClass().add("how-to-play");
            howToPlayText.setMinWidth(500);
            howToPlayText.setPrefWidth(500);
            howToPlayText.setMaxWidth(500);
            
            howToPlayScroll.setMinSize(550,450);
            howToPlayScroll.setPrefSize(550,450);
            howToPlayScroll.setMaxSize(550,450);
        
        Button backBtn = new Button("Go Back");
        backBtn.getStyleClass().add("back-btn");
        backBtn.setAlignment(Pos.CENTER_LEFT);
        backBtn.setOnAction((ActionEvent event) -> {
            gameManager.menuScreen();
        }); 
        
        Button nextBtn = new Button("Okay, Let's play");
        nextBtn.getStyleClass().add("okay-btn");
        nextBtn.setAlignment(Pos.CENTER_RIGHT);
        nextBtn.setOnAction((ActionEvent event) -> {
            gameManager.menuScreen();
        });
        
        
        GridPane menuFooterBtns = new GridPane();
        menuFooterBtns.setPadding(new Insets(10,5,10,5));
        menuFooterBtns.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
        menuFooterBtns.setMinWidth(500);
        menuFooterBtns.setPrefWidth(500);
        menuFooterBtns.setMaxWidth(500);
        menuFooterBtns.add(backBtn, 0, 0);
        menuFooterBtns.add(nextBtn, 1, 0);
        
        ColumnConstraints twoColumns,twoColumns2;
        twoColumns = new ColumnConstraints();
        twoColumns.setPercentWidth(100/2.0); // divide into two places...
        twoColumns.setHalignment(HPos.LEFT);
        
        twoColumns2 = new ColumnConstraints();
        twoColumns2.setPercentWidth(100/2.0); // divide into two places...
        twoColumns2.setHalignment(HPos.RIGHT);
        menuFooterBtns.getColumnConstraints().addAll(twoColumns,twoColumns2);
        
        VBox centerMenu = new VBox(20);
        centerMenu.setAlignment(Pos.CENTER);
        centerMenu.getStyleClass().add("center-menu-box");
        centerMenu.getChildren().addAll(scenetitle,howToPlayScroll,menuFooterBtns);
        
        HBox centerMenuHorizontal = new HBox(20);
        centerMenuHorizontal.setAlignment(Pos.CENTER);
        centerMenuHorizontal.getChildren().add(centerMenu);
        
        centerWindowArea.getChildren().addAll(centerMenuHorizontal); 
    }
    
    /**
     * Limits the length of text a textField can take
     * @param textField
     * @param maxLength
     */
    public static void addTextFieldLimiter(final TextField textField, final int maxLength) {
    textField.textProperty().addListener((final ObservableValue<? extends String> ov, 
            final String oldValue, final String newValue) -> {
        if (textField.getText().length() > maxLength) {
            String text = textField.getText().substring(0, maxLength);
            textField.setText(text);
            textField.positionCaret(text.length());
        }
    });
}
    
}
