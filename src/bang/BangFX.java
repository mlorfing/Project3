/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author ctaylor
 */
public class BangFX extends Application {

    //initialization of variables used for GUI
    Stage window = new Stage();
    Stage exp = new Stage();
    Stage char_desc = new Stage();
    Stage dice_n = new Stage();
    Stage dice_d = new Stage();
    Image bground, logo, mheader;
    Image black, gringo, jesse, jour, paul,
            pedro, suzy, vulture;
    Image jose, tequila, belle, greg;
    Image sr1, sr2, sr3, sr4, sheader;
    Image ur1, ur2, ur3, ur4, ur5, ur6, ur7, ur8,
            uheader;
    Image arrow, barrow, be1, be2, beer, bullet, dbe1,
            dbe2, dbeer, dgatling, duel, dynamite, gatling,
            whiskey, reg, undead, saloon, bdynamite, bgatling,
            blarrow;
    Image rdie, ldie, cdie, bdie, rdie2, rdie3, rdie4, rdie5, bdie2;
    ImageView background, bLogo, mHeader;
    ImageView black_img, gringo_img, jesse_img, jour_img,
            paul_img, pedro_img, suzy_img, vulture_img;
    ImageView jose_img, tequila_img, belle_img, greg_img;
    ImageView SR1, SR2, SR3, SR4, UR1, UR2, UR3, UR4,
            UR5, UR6, UR7, UR8, sHeader, uHeader;
    ImageView d1, d2, d3, d4, d5, d6, d12, d22, d32, d42, d52, d62,
            d13, d23, d33, d43, d53, d63, d14, d24, d34, d44, d54, d64,
            d15, d25, d35, d45, d55, d65, dc1, dc2, dc3, dc4, dc5, dc6,
            dl1, dl2, dl3, dl4, dl5, dl6, du1, du2, du3, du4, 
            du5, du6, du12, du22, du32, du42, du52, du62, dg1, dg2, dg3;
    ImageView rDie_img, lDie_img, cDie_img, bDie_img, bDie2_img,
            rDie2_img, rDie3_img, rDie4_img, rDie5_img;
    Scene scene1, expScene, charScene, diceScene, ddScene, 
            initScene, scene2;
    TextArea charDesc = new TextArea();
    VBox cD = new VBox(charDesc);
    Label diceNames = new Label();
    Label diceDesc = new Label();
    Label init = new Label();
    Label welcome = new Label();
    Label expansion = new Label();
    Label expIncl = new Label();
    Label character = new Label();
    Label chiefChoice = new Label();
    Label action = new Label();
    Label indAtt = new Label();
    Label dynExp = new Label();
    Label drank = new Label();
    Group group1 = new Group();
    Group group2 = new Group();
    Group group3 = new Group();
    Group expGroup = new Group();
    Group charGroup = new Group();
    Group diceGroup = new Group();
    Group diceGroup2 = new Group();
    Group initGroup = new Group();
    
    Media bgM, bulls, glass, un, dieS, dyna, arrS, ind, gat;
    MediaPlayer bMusic, eye, clink, dead, rollS, mite, swoosh, attack, ling;
    Button go = new Button();
    Button rules = new Button();
    Button charAbilities = new Button();
    Button saloonR = new Button();
    Button saloonC = new Button();
    Button undeadR = new Button();
    Button undeadC = new Button();
    Button close = new Button();
    Button close2 = new Button();
    Button prev = new Button();
    Button next = new Button();
    Button prev2 = new Button();
    Button next2 = new Button();
    Button nextMain = new Button();
    Button setupDice = new Button();
    Button rollDice = new Button();
    Button dEffects = new Button();
    Button chiefY = new Button();
    Button chiefN = new Button();
    RadioButton salInc = new RadioButton();
    RadioButton undInc = new RadioButton();
    RadioButton loudmouth = new RadioButton();
    RadioButton coward = new RadioButton();
    CheckBox die1 = new CheckBox();
    CheckBox die2 = new CheckBox();
    CheckBox die3 = new CheckBox();
    CheckBox die4 = new CheckBox();
    CheckBox die5 = new CheckBox();
    
    
    ToggleButton musicToggle = new ToggleButton();
    Boolean isSelected, cDSelect, lDSelect, sher, reroll;
    ComboBox players = new ComboBox();
    int cSel, pageNum=0, dynamiteCount = 0, rollCount = 0, arrCount = 0,
            gatCount = 0;
    
    static Scanner scan;
    String answer;
    static int arrowCount = 9;
    static boolean chiefArrow = false;
    static boolean chief = false;
    //initialization of game variables
    ArrayList<CharCards> char_cards = new ArrayList();
    ArrayList<Dice> dice = new ArrayList();
    ArrayList<Roles> role_cards = new ArrayList();
    ArrayList<CheckBox> checkBoxes = new ArrayList();
    ArrayList<String> finalDice = new ArrayList();
    static ArrayList<Player> play_order = new ArrayList();
    static ArrayList<Player> temp_play_order = new ArrayList();
    static ArrayList<Player> temp_play_order2 = new ArrayList();
    
    Dice RD1 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");
    Dice RD2 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");
    Dice RD3 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");
    Dice RD4 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");
    Dice RD5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");
        
        
    Player current;
    Player left1;
    Player right1;
    Player left2;
    Player right2;
    Player left3;
    Player right3;
    Player human = new Player("NULL", 0, "NULL", false);
    Player ai1 = new Player("NULL", 0, "NULL", true);
    Player ai2 = new Player("NULL", 0, "NULL", true);
    Player ai3 = new Player("NULL", 0, "NULL", true);
    Player ai4 = new Player("NULL", 0, "NULL", true);
    Player ai5 = new Player("NULL", 0, "NULL", true);
    Player ai6 = new Player("NULL", 0, "NULL", true);
    Player ai7 = new Player("NULL", 0, "NULL", true);
    
    //main method
    public static void main(String[] args) {
        launch(args);
    }
    //sets the buttons to go forward to next screen
    @Override
    public void start(Stage primaryStage) throws Exception {
        scan  = new Scanner(System.in);
        dice.add(RD1);
        dice.add(RD2);
        dice.add(RD3);
        dice.add(RD4);
        dice.add(RD5);
        window = primaryStage;
        window.setResizable(false);
        exp.setOnCloseRequest(e -> {
            exp.hide();
            pageNum = 0;
                });
        exp.setAlwaysOnTop(true);
        char_desc.setOnCloseRequest(e -> char_desc.hide());
        char_desc.setAlwaysOnTop(true);
        dice_n.setOnCloseRequest(e -> dice_n.hide());
        dice_n.setAlwaysOnTop(true);
        dice_d.setOnCloseRequest(e -> dice_d.hide());
        dice_d.setAlwaysOnTop(true);
        
        setWelcomeScreen();
        setSecondaryScreens();
        go.setOnAction(e->{
            eye.seek(Duration.ZERO);
            eye.play();
            
            assign();
            revealSheriff();
            init.setLayoutX(340);
            init.setLayoutY(160);
            group2.getChildren()
                .addAll(background, init, nextMain, musicToggle);
            initScene = new Scene(group2, 1280, 720);
            window.setTitle("BANG! Gameplay");
            window.setScene(initScene);
            window.show();
        });
        
        scene2 = new Scene(group3, 1280, 720);
        setupDice.setOnAction(e->{
            diceSetup();
        });
        
        
    }
    //sets initial welcome screen, asks for user input
    public void setWelcomeScreen() throws Exception{
        bground = new Image(
                new FileInputStream("src/bang/media/tabletop.jpg"));
        background = new ImageView(bground);
        background.setFitHeight(720);
        background.setFitWidth(1280);
        background.setOpacity(.6);

        welcome.setLayoutX(500);
        welcome.setLayoutY(100);
        welcome.setText("Welcome to ");
        welcome.setFont(Font.font ("Copperplate", 50));
        
        expIncl.setLayoutX(500);
        expIncl.setLayoutY(500);
        expIncl.setText("Include Expansion Packs?\nOld Saloon"
                + "\nUndead or Alive");
        expIncl.setFont(Font.font("Copperplate", 25));
        
        salInc.setLayoutX(750);
        salInc.setLayoutY(530); 
        undInc.setLayoutX(750);
        undInc.setLayoutY(555);
        
        expansion.setLayoutX(20);
        expansion.setLayoutY(150);
        expansion.setText("Expansion Packs Included:");
        expansion.setFont(Font.font("Copperplate", 25));
        
        logo = new Image(new FileInputStream("src/bang/media/bang.png"));
        bLogo = new ImageView(logo);
        bLogo.setLayoutX(410);
        bLogo.setLayoutY(150);
        bLogo.setPreserveRatio(true);
        bLogo.setFitWidth(500);
        
        bulls = new Media(this.getClass().getResource(
                "/bang/media/music/bullseye.wav").toString());
        eye = new MediaPlayer(bulls);
        eye.setVolume(.8);
        
        arrS = new Media(this.getClass().getResource(
                "/bang/media/music/arrow.wav").toString());
        swoosh = new MediaPlayer(arrS);
        swoosh.setVolume(.8);
        
        gat = new Media(this.getClass().getResource(
                "/bang/media/music/gatling.wav").toString());
        ling = new MediaPlayer(gat);
        ling.setVolume(.8);
        
        ind = new Media(this.getClass().getResource(
                "/bang/media/music/indians.wav").toString());
        attack = new MediaPlayer(ind);
        attack.setVolume(.8);
        
        dyna = new Media(this.getClass().getResource(
                "/bang/media/music/dynamite.wav").toString());
        mite = new MediaPlayer(dyna);
        mite.setVolume(.8);
        
        dieS = new Media(this.getClass().getResource(
                "/bang/media/music/diceroll.wav").toString());
        rollS = new MediaPlayer(dieS);
        rollS.setVolume(.8);

        glass = new Media(this.getClass().getResource(
                "/bang/media/music/beer.wav").toString());
        clink = new MediaPlayer(glass);
        clink.setVolume(.8);
        
        un = new Media(this.getClass().getResource(
                "/bang/media/music/undead.wav").toString());
        dead = new MediaPlayer(un);
        dead.setVolume(.8);
        
        rules.setText("See Rules");
        rules.setLayoutX(20);
        rules.setLayoutY(20);
        rules.setFont(Font.font ("Copperplate", 25));
        rules.setOnAction((ActionEvent event) -> {
            event.consume();
            eye.seek(Duration.ZERO);
            BangSwingRules.main(new String [0]);
            eye.play();
        });
        
        charAbilities.setText("Character Special Abilities");
        charAbilities.setLayoutX(20);
        charAbilities.setLayoutY(70);
        charAbilities.setFont(Font.font ("Copperplate", 15));
        charAbilities.setOnAction((ActionEvent event) -> {
            event.consume();
            eye.seek(Duration.ZERO);
            eye.play();
            close.setLayoutX(120);
            close.setLayoutY(630);
            expGroup.getChildren().clear();
        
            expGroup.getChildren()
                .addAll(mHeader, close, black_img, gringo_img, jesse_img, jour_img,
                    paul_img, pedro_img, suzy_img, vulture_img);
            
            exp.setTitle("Base Characters");
            exp.show();
        });
        
        saloonR.setText("Old Saloon - Rules");
        saloonR.setLayoutX(20);
        saloonR.setLayoutY(175);
        saloonR.setFont(Font.font ("Copperplate", 20));
        saloonR.setOnAction((ActionEvent event) -> {
            event.consume();
            clink.seek(Duration.ZERO);
            clink.play();
            close.setLayoutX(120);
            close.setLayoutY(630);
            
            expGroup.getChildren().clear();
        
            expGroup.getChildren()
                .addAll(sHeader, close, prev, next, SR1, SR2, SR3, SR4);
            
            saloonR();
            exp.setTitle("Old Saloon Rules");
            exp.show();
        });
        
        saloonC.setText("Old Saloon - Characters");
        saloonC.setLayoutX(20);
        saloonC.setLayoutY(215);
        saloonC.setFont(Font.font ("Copperplate", 15));
        saloonC.setOnAction((ActionEvent event) -> {
            event.consume();
            clink.seek(Duration.ZERO);
            clink.play();
            close.setLayoutX(120);
            close.setLayoutY(630);
            expGroup.getChildren().clear();
        
            expGroup.getChildren()
                .addAll(sHeader, close, jose_img, tequila_img);
            
            exp.setTitle("Old Saloon Characters");
            exp.show();
        });
        
        undeadR.setText("Undead or Alive - Rules");
        undeadR.setLayoutX(20);
        undeadR.setLayoutY(265);
        undeadR.setFont(Font.font ("Copperplate", 20));
        undeadR.setOnAction((ActionEvent event) -> {
            event.consume();
            dead.seek(Duration.ZERO);
            dead.play();
            close.setLayoutX(120);
            close.setLayoutY(630);
            expGroup.getChildren().clear();
        
            expGroup.getChildren()
                .addAll(uHeader, close, UR1, UR2, UR3, UR4,
            UR5, UR6, UR7, UR8, prev2, next2);
            
            undeadR();
            exp.setTitle("Undead Rules");
            exp.show();
        });
        
        undeadC.setText("Undead or Alive - Characters");
        undeadC.setLayoutX(20);
        undeadC.setLayoutY(305);
        undeadC.setFont(Font.font ("Copperplate", 15));
        undeadC.setOnAction((ActionEvent event) -> {
            event.consume();
            dead.seek(Duration.ZERO);
            dead.play();
            close.setLayoutX(120);
            close.setLayoutY(630);
            expGroup.getChildren().clear();
        
            expGroup.getChildren()
                .addAll(uHeader, close, belle_img, greg_img);
            
            exp.setTitle("Undead Characters");
            exp.show();
        });
        
        musicToggle.setText("Music On/Off");
        musicToggle.setFont(Font.font("Copperplate", 20));
        musicToggle.setLayoutX(1100);
        musicToggle.setLayoutY(20);
        bgM = new Media(this.getClass().getResource(
                "/bang/media/music/background.mp3").toString());
        bMusic = new MediaPlayer(bgM);
        bMusic.setAutoPlay(true);
        bMusic.setCycleCount(4000);
        bMusic.setVolume(.5);
        musicToggle.setOnAction((ActionEvent event) -> {
            event.consume();
            isSelected = musicToggle.isSelected();
            if(isSelected){
                dead.setVolume(0);
                clink.setVolume(0);
                eye.setVolume(0);
                rollS.setVolume(0);
                mite.setVolume(0);
                attack.setVolume(0);
                ling.setVolume(0);
                swoosh.setVolume(0);
                bMusic.stop();
            } else {
                dead.setVolume(.8);
                clink.setVolume(.8);
                eye.setVolume(.8);
                rollS.setVolume(.8);
                mite.setVolume(.8);
                attack.setVolume(.8);
                ling.setVolume(.8);
                swoosh.setVolume(.8);
                bMusic.seek(Duration.ZERO);
                bMusic.play();
            }
        });
        
        go.setLayoutX(750);
        go.setLayoutY(445);
        go.setText("GO!");
        go.setFont(Font.font("Copperplate", 20));
        
        dEffects.setLayoutX(20);
        dEffects.setLayoutY(103);
        dEffects.setText("View Dice Faces");
        dEffects.setFont(Font.font("Copperplate", 20));
        dEffects.setOnAction((ActionEvent event) -> {
            event.consume();
            rollS.seek(Duration.ZERO);
            rollS.play();
            diceEffects();
        });
        
        players.setLayoutX(500);
        players.setLayoutY(450);
        players.setPromptText("Choose the number of players: ");
        for(int i=4; i<9; i++){
            players.getItems().add(i);
        }
        
        group1.getChildren()
                .addAll(background, welcome, expansion,
                        saloonR, saloonC, undeadR, undeadC,
                        bLogo, rules, charAbilities, go,
                        players, musicToggle, dEffects, expIncl, 
                        salInc, undInc);
        scene1 = new Scene(group1, 1280, 720);
        window.setTitle("BANG! Gameplay");
        window.setScene(scene1);
        window.show();
    }
    //sets character/dice/rule windows and images
    public void setSecondaryScreens() throws Exception{
        close.setText("Close");
        close.setFont(Font.font("Copperplate", 15));
        close.setOnAction(e -> {
            pageNum = 0;
            Stage stage =  (Stage)close.getScene().getWindow();
            stage.close();
        });
        
        
        close2.setText("Close");
        close2.setFont(Font.font("Copperplate", 15));
        close2.setOnAction(e -> {
            pageNum = 0;
            Stage stage =  (Stage)close2.getScene().getWindow();
            stage.close();
        });
        
        prev.setLayoutX(95);
        prev.setLayoutY(600);
        prev.setText("Prev");
        prev.setFont(Font.font("Copperplate", 15));
        prev.setOnAction(e -> {
            pageNum--;
            if(pageNum >= 0)
                saloonR();
        });
        
        next.setLayoutX(155);
        next.setLayoutY(600);
        next.setText("Next");
        next.setFont(Font.font("Copperplate", 15));
        next.setOnAction(e -> {
            pageNum++;
            if(pageNum < 4)
                saloonR();
        });
        
        prev2.setLayoutX(95);
        prev2.setLayoutY(600);
        prev2.setText("Prev");
        prev2.setFont(Font.font("Copperplate", 15));
        prev2.setOnAction(e -> {
            pageNum--;
            if(pageNum >= 0)
                undeadR();
        });
        
        next2.setLayoutX(155);
        next2.setLayoutY(600);
        next2.setText("Next");
        next2.setFont(Font.font("Copperplate", 15));
        next2.setOnAction(e -> {
            pageNum++;
            if(pageNum < 8)
                undeadR();
        });
        mheader = new Image(new FileInputStream("src/bang/media/mheader.png"));
        mHeader = new ImageView(mheader);
        mHeader.setLayoutX(0);
        mHeader.setLayoutY(0);
        mHeader.setPreserveRatio(true);
        mHeader.setFitWidth(300); 
        
        sheader = new Image(new FileInputStream("src/bang/media/sheader.png"));
        sHeader = new ImageView(sheader);
        sHeader.setLayoutX(0);
        sHeader.setLayoutY(0);
        sHeader.setPreserveRatio(true);
        sHeader.setFitWidth(300);  
        
        uheader = new Image(new FileInputStream("src/bang/media/uheader.png"));
        uHeader = new ImageView(uheader);
        uHeader.setLayoutX(0);
        uHeader.setLayoutY(0);
        uHeader.setPreserveRatio(true);
        uHeader.setFitWidth(300); 
        
        sr1 = new Image(new FileInputStream("src/bang/media/sr1.png"));
        SR1 = new ImageView(sr1);
        SR1.setLayoutX(0);
        SR1.setLayoutY(85);
        SR1.setPreserveRatio(true);
        SR1.setFitWidth(300);
        
        sr2 = new Image(new FileInputStream("src/bang/media/sr2.png"));
        SR2 = new ImageView(sr2);
        SR2.setLayoutX(0);
        SR2.setLayoutY(85);
        SR2.setPreserveRatio(true);
        SR2.setFitWidth(300);     
        
        sr3 = new Image(new FileInputStream("src/bang/media/sr3.png"));
        SR3 = new ImageView(sr3);
        SR3.setLayoutX(0);
        SR3.setLayoutY(85);
        SR3.setPreserveRatio(true);
        SR3.setFitWidth(300);        
        
        sr4 = new Image(new FileInputStream("src/bang/media/sr4.png"));
        SR4 = new ImageView(sr4);
        SR4.setLayoutX(0);
        SR4.setLayoutY(85);
        SR4.setPreserveRatio(true);
        SR4.setFitWidth(300);        
        
        ur1 = new Image(new FileInputStream("src/bang/media/ur1.png"));
        UR1 = new ImageView(ur1);
        UR1.setLayoutX(0);
        UR1.setLayoutY(85);
        UR1.setPreserveRatio(true);
        UR1.setFitWidth(300);        
        
        ur2 = new Image(new FileInputStream("src/bang/media/ur2.png"));
        UR2 = new ImageView(ur2);
        UR2.setLayoutX(0);
        UR2.setLayoutY(85);
        UR2.setPreserveRatio(true);
        UR2.setFitWidth(300);        
        
        ur3 = new Image(new FileInputStream("src/bang/media/ur3.png"));
        UR3 = new ImageView(ur3);
        UR3.setLayoutX(0);
        UR3.setLayoutY(85);
        UR3.setPreserveRatio(true);
        UR3.setFitWidth(300);        
        
        ur4 = new Image(new FileInputStream("src/bang/media/ur4.png"));
        UR4 = new ImageView(ur4);
        UR4.setLayoutX(0);
        UR4.setLayoutY(85);
        UR4.setPreserveRatio(true);
        UR4.setFitWidth(300);        
        
        ur5 = new Image(new FileInputStream("src/bang/media/ur5.png"));
        UR5 = new ImageView(ur5);
        UR5.setLayoutX(0);
        UR5.setLayoutY(85);
        UR5.setPreserveRatio(true);
        UR5.setFitWidth(300);        
        
        ur6 = new Image(new FileInputStream("src/bang/media/ur6.png"));
        UR6 = new ImageView(ur6);
        UR6.setLayoutX(0);
        UR6.setLayoutY(85);
        UR6.setPreserveRatio(true);
        UR6.setFitWidth(300);        
        
        ur7 = new Image(new FileInputStream("src/bang/media/ur7.png"));
        UR7 = new ImageView(ur7);
        UR7.setLayoutX(0);
        UR7.setLayoutY(85);
        UR7.setPreserveRatio(true);
        UR7.setFitWidth(300);        
        
        ur8 = new Image(new FileInputStream("src/bang/media/ur8.png"));
        UR8 = new ImageView(ur8);
        UR8.setLayoutX(0);
        UR8.setLayoutY(85);
        UR8.setPreserveRatio(true);
        UR8.setFitWidth(300);
        
        black = new Image(
            new FileInputStream("src/bang/media/black.png"));
        black_img = new ImageView(black);
        black_img.setFitWidth(125);
        black_img.setLayoutX(20);
        black_img.setLayoutY(110);
        black_img.setPreserveRatio(true);
        black_img.setOnMouseClicked(e->{
            blackDesc();
        });
        
        gringo = new Image(
            new FileInputStream("src/bang/media/gringo.png"));
        gringo_img = new ImageView(gringo);
        gringo_img.setFitWidth(125);
        gringo_img.setLayoutX(150);
        gringo_img.setLayoutY(110);
        gringo_img.setPreserveRatio(true);
        gringo_img.setOnMouseClicked(e->{
            gringoDesc();
        });
        
        jesse = new Image(
            new FileInputStream("src/bang/media/jesse.png"));
        jesse_img = new ImageView(jesse);
        jesse_img.setFitWidth(125);
        jesse_img.setLayoutX(20);
        jesse_img.setLayoutY(240);
        jesse_img.setPreserveRatio(true);
        jesse_img.setOnMouseClicked(e->{
            jesseDesc();
        });
        
        jour = new Image(
            new FileInputStream("src/bang/media/jour.png"));
        jour_img = new ImageView(jour);
        jour_img.setFitWidth(125);
        jour_img.setLayoutX(150);
        jour_img.setLayoutY(240);
        jour_img.setPreserveRatio(true);
        jour_img.setOnMouseClicked(e->{
            jourDesc();
        });
        
        paul = new Image(
            new FileInputStream("src/bang/media/paul.png"));
        paul_img = new ImageView(paul);
        paul_img.setFitWidth(125);
        paul_img.setLayoutX(20);
        paul_img.setLayoutY(370);
        paul_img.setPreserveRatio(true);
        paul_img.setOnMouseClicked(e->{
            paulDesc();
        });
        
        pedro = new Image(
            new FileInputStream("src/bang/media/pedro.png"));
        pedro_img = new ImageView(pedro);
        pedro_img.setFitWidth(125);
        pedro_img.setLayoutX(150);
        pedro_img.setLayoutY(370);
        pedro_img.setPreserveRatio(true);
        pedro_img.setOnMouseClicked(e->{
            pedroDesc();
        });
        
        suzy = new Image(
            new FileInputStream("src/bang/media/suzy.png"));
        suzy_img = new ImageView(suzy);
        suzy_img.setFitWidth(125);
        suzy_img.setLayoutX(20);
        suzy_img.setLayoutY(500);
        suzy_img.setPreserveRatio(true);
        suzy_img.setOnMouseClicked(e->{
            suzyDesc();
        });
        
        vulture = new Image(
            new FileInputStream("src/bang/media/vulture.png"));
        vulture_img = new ImageView(vulture);
        vulture_img.setFitWidth(125);
        vulture_img.setLayoutX(150);
        vulture_img.setLayoutY(500);
        vulture_img.setPreserveRatio(true);
        vulture_img.setOnMouseClicked(e->{
            vultureDesc();
        });
        
        jose = new Image(
            new FileInputStream("src/bang/media/jose.png"));
        jose_img = new ImageView(jose);
        jose_img.setFitWidth(125);
        jose_img.setLayoutX(87);
        jose_img.setLayoutY(105);
        jose_img.setPreserveRatio(true);
        jose_img.setOnMouseClicked(e->{
            joseDesc();
        });
        
        tequila = new Image(
            new FileInputStream("src/bang/media/tequila.png"));
        tequila_img = new ImageView(tequila);
        tequila_img.setFitWidth(125);
        tequila_img.setLayoutX(87);
        tequila_img.setLayoutY(235);
        tequila_img.setPreserveRatio(true);
        tequila_img.setOnMouseClicked(e->{
            tequilaDesc();
        });
        
        belle = new Image(
            new FileInputStream("src/bang/media/belle.png"));
        belle_img = new ImageView(belle);
        belle_img.setFitWidth(125);
        belle_img.setLayoutX(87);
        belle_img.setLayoutY(105);
        belle_img.setPreserveRatio(true);
        belle_img.setOnMouseClicked(e->{
            belleDesc();
        });
        
        greg = new Image(
            new FileInputStream("src/bang/media/greg.png"));
        greg_img = new ImageView(greg);
        greg_img.setFitWidth(125);
        greg_img.setLayoutX(87);
        greg_img.setLayoutY(235);
        greg_img.setPreserveRatio(true);
        greg_img.setOnMouseClicked(e->{
            gregDesc();
        });
        
        expScene = new Scene(expGroup, 300, 670, Color.BEIGE);
        exp.setScene(expScene);
        
        charScene = new Scene(charGroup, 300, 300, Color.BEIGE);
        charDesc.setPrefSize(charScene.getWidth(), charScene.getHeight());
        charDesc.setEditable(false);
        charDesc.setFont(Font.font("Copperplate", 15));
        charDesc.setWrapText(true);
        char_desc.setScene(charScene);
        
        arrow = new Image(
            new FileInputStream("src/bang/media/arrow.png"));
        d1 = new ImageView(arrow);
        d1.setFitWidth(75);
        d1.setLayoutX(10);
        d1.setLayoutY(10);
        d1.setPreserveRatio(true);
        
        dynamite = new Image(
            new FileInputStream("src/bang/media/dynamite.png"));
        d2 = new ImageView(dynamite);
        d2.setFitWidth(75);
        d2.setLayoutX(90);
        d2.setLayoutY(10);
        d2.setPreserveRatio(true);
        
        be1 = new Image(
            new FileInputStream("src/bang/media/be1.png"));
        d3 = new ImageView(be1);
        d3.setFitWidth(75);
        d3.setLayoutX(10);
        d3.setLayoutY(90);
        d3.setPreserveRatio(true);
        
        be2 = new Image(
            new FileInputStream("src/bang/media/be2.png"));
        d4 = new ImageView(be2);
        d4.setFitWidth(75);
        d4.setLayoutX(90);
        d4.setLayoutY(90);
        d4.setPreserveRatio(true);
        
        beer = new Image(
            new FileInputStream("src/bang/media/beer.png"));
        d5 = new ImageView(beer);
        d5.setFitWidth(75);
        d5.setLayoutX(10);
        d5.setLayoutY(170);
        d5.setPreserveRatio(true);
        
        gatling = new Image(
            new FileInputStream("src/bang/media/gatling.png"));
        d6 = new ImageView(gatling);
        d6.setFitWidth(75);
        d6.setLayoutX(90);
        d6.setLayoutY(170);
        d6.setPreserveRatio(true);
        
        d12 = new ImageView(arrow);
        d12.setFitWidth(75);
        d12.setPreserveRatio(true);
        
        d22 = new ImageView(dynamite);
        d22.setFitWidth(75);
        d22.setPreserveRatio(true);
        
        d32 = new ImageView(be1);
        d32.setFitWidth(75);
        d32.setPreserveRatio(true);
        
        d42 = new ImageView(be2);
        d42.setFitWidth(75);
        d42.setPreserveRatio(true);
        
        d52 = new ImageView(beer);
        d52.setFitWidth(75);
        d52.setPreserveRatio(true);
        
        d62 = new ImageView(gatling);
        d62.setFitWidth(75);
        d62.setPreserveRatio(true);
        
        d13 = new ImageView(arrow);
        d13.setFitWidth(75);
        d13.setPreserveRatio(true);
        
        d23 = new ImageView(dynamite);
        d23.setFitWidth(75);
        d23.setPreserveRatio(true);
        
        d33 = new ImageView(be1);
        d33.setFitWidth(75);
        d33.setPreserveRatio(true);
        
        d43 = new ImageView(be2);
        d43.setFitWidth(75);
        d43.setPreserveRatio(true);
        
        d53 = new ImageView(beer);
        d53.setFitWidth(75);
        d53.setPreserveRatio(true);
        
        d63 = new ImageView(gatling);
        d63.setFitWidth(75);
        d63.setPreserveRatio(true);
        
        d14 = new ImageView(arrow);
        d14.setFitWidth(75);
        d14.setPreserveRatio(true);
        
        d24 = new ImageView(dynamite);
        d24.setFitWidth(75);
        d24.setPreserveRatio(true);
        
        d34 = new ImageView(be1);
        d34.setFitWidth(75);
        d34.setPreserveRatio(true);
        
        d44 = new ImageView(be2);
        d44.setFitWidth(75);
        d44.setPreserveRatio(true);
        
        d54 = new ImageView(beer);
        d54.setFitWidth(75);
        d54.setPreserveRatio(true);
        
        d64 = new ImageView(gatling);
        d64.setFitWidth(75);
        d64.setPreserveRatio(true);
        
        d15 = new ImageView(arrow);
        d15.setFitWidth(75);
        d15.setPreserveRatio(true);
        
        d25 = new ImageView(dynamite);
        d25.setFitWidth(75);
        d25.setPreserveRatio(true);
        
        d35 = new ImageView(be1);
        d35.setFitWidth(75);
        d35.setPreserveRatio(true);
        
        d45 = new ImageView(be2);
        d45.setFitWidth(75);
        d45.setPreserveRatio(true);
        
        d55 = new ImageView(beer);
        d55.setFitWidth(75);
        d55.setPreserveRatio(true);
        
        d65 = new ImageView(gatling);
        d65.setFitWidth(75);
        d65.setPreserveRatio(true);
        
        dl1 = new ImageView(arrow);
        dl1.setFitWidth(75);
        dl1.setPreserveRatio(true);
        
        bullet = new Image(
            new FileInputStream("src/bang/media/bullet.png"));
        dl2 = new ImageView(bullet);
        dl2.setFitWidth(75);
        dl2.setLayoutX(90);
        dl2.setLayoutY(10);
        dl2.setPreserveRatio(true);
        
        dl3 = new ImageView(dynamite);
        dl3.setFitWidth(75);
        dl3.setPreserveRatio(true);
        
        dbe1 = new Image(
            new FileInputStream("src/bang/media/dbe1.png"));
        dl4 = new ImageView(dbe1);
        dl4.setFitWidth(75);
        dl4.setLayoutX(10);
        dl4.setLayoutY(90);
        dl4.setPreserveRatio(true);
        
        dbe2 = new Image(
            new FileInputStream("src/bang/media/dbe2.png"));
        dl5 = new ImageView(dbe2);
        dl5.setFitWidth(75);
        dl5.setLayoutX(90);
        dl5.setLayoutY(90);
        dl5.setPreserveRatio(true);
        
        dgatling = new Image(
            new FileInputStream("src/bang/media/dgatling.png"));
        dl6 = new ImageView(dgatling);
        dl6.setFitWidth(75);
        dl6.setLayoutX(90);
        dl6.setLayoutY(170);
        dl6.setPreserveRatio(true);
        
        
        dc1 = new ImageView(arrow);
        dc1.setFitWidth(75);
        dc1.setPreserveRatio(true);
       
        barrow = new Image(
            new FileInputStream("src/bang/media/barrow.png"));
        dc2 = new ImageView(barrow);
        dc2.setFitWidth(75);
        dc2.setLayoutX(10);
        dc2.setLayoutY(10);
        dc2.setPreserveRatio(true);
        
        dc3 = new ImageView(dynamite);
        dc3.setFitWidth(75);
        dc3.setLayoutX(10);
        dc3.setLayoutY(90);
        dc3.setPreserveRatio(true);
       
        dc4 = new ImageView(be1);
        dc4.setFitWidth(75);
        dc4.setLayoutX(90);
        dc4.setLayoutY(90);
        dc4.setPreserveRatio(true);
       
        dc5 = new ImageView(beer);
        dc5.setFitWidth(75);
        dc5.setLayoutX(10);
        dc5.setLayoutY(170);
        dc5.setPreserveRatio(true);
        
        dbeer = new Image(
            new FileInputStream("src/bang/media/dbeer.png"));
        dc6 = new ImageView(dbeer);
        dc6.setFitWidth(75);
        dc6.setLayoutX(10);
        dc6.setLayoutY(170);
        dc6.setPreserveRatio(true);
        
        blarrow = new Image(
            new FileInputStream("src/bang/media/blarrow.png"));
        du1 = new ImageView(blarrow);
        du1.setFitWidth(75);
        du1.setLayoutX(10);
        du1.setLayoutY(10);
        du1.setPreserveRatio(true);
        
        bdynamite = new Image(
            new FileInputStream("src/bang/media/bdynamite.png"));
        du2 = new ImageView(bdynamite);
        du2.setFitWidth(75);
        du2.setLayoutX(90);
        du2.setLayoutY(10);
        du2.setPreserveRatio(true);
        
        whiskey = new Image(
            new FileInputStream("src/bang/media/whiskey.png"));
        du3 = new ImageView(whiskey);
        du3.setFitWidth(75);
        du3.setLayoutX(10);
        du3.setLayoutY(90);
        du3.setPreserveRatio(true);
        
        bgatling = new Image(
            new FileInputStream("src/bang/media/bgatling.png"));
        du4 = new ImageView(bgatling);
        du4.setFitWidth(75);
        du4.setLayoutX(90);
        du4.setLayoutY(90);
        du4.setPreserveRatio(true);
        
        duel = new Image(
            new FileInputStream("src/bang/media/duel.png"));
        du5 = new ImageView(duel);
        du5.setFitWidth(75);
        du5.setLayoutX(10);
        du5.setLayoutY(170);
        du5.setPreserveRatio(true);
        
        du6 = new ImageView(duel);
        du6.setFitWidth(75);
        du6.setPreserveRatio(true);
        
        du12 = new ImageView(blarrow);
        du12.setFitWidth(75);
        du12.setPreserveRatio(true);
        
        du22 = new ImageView(bdynamite);
        du22.setFitWidth(75);
        du22.setPreserveRatio(true);
        
        du32 = new ImageView(whiskey);
        du32.setFitWidth(75);
        du32.setPreserveRatio(true);
        
        du42 = new ImageView(bgatling);
        du42.setFitWidth(75);
        du42.setPreserveRatio(true);
        
        du52 = new ImageView(duel);
        du52.setFitWidth(75);
        du52.setPreserveRatio(true);
        
        du62 = new ImageView(duel);
        du62.setFitWidth(75);
        du62.setPreserveRatio(true);
       
        dg1 = new ImageView(reg);
        dg1.setFitWidth(250);
        dg1.setLayoutX(25);
        dg1.setLayoutY(14);
        dg1.setPreserveRatio(true);
        dg1.setOnMouseClicked(e ->{
            dGroup1();
        });
        
        saloon = new Image(
            new FileInputStream("src/bang/media/saloon.png"));
        dg2 = new ImageView(saloon);
        dg2.setFitWidth(250);
        dg2.setLayoutX(25);
        dg2.setLayoutY(100);
        dg2.setPreserveRatio(true);
        dg2.setOnMouseClicked(e ->{
            dGroup2();
        });
        
        undead = new Image(
            new FileInputStream("src/bang/media/undead.png"));
        dg3 = new ImageView(undead);
        dg3.setFitWidth(250);
        dg3.setLayoutX(25);
        dg3.setLayoutY(220);
        dg3.setPreserveRatio(true);
        dg3.setOnMouseClicked(e ->{
            dGroup3();
        });
        
        rdie = new Image(new FileInputStream("src/bang/media/rdie.png"));
        rDie_img = new ImageView(rdie);
        rDie_img.setLayoutX(300);
        rDie_img.setLayoutY(100);
        rDie_img.setPreserveRatio(true);
        rDie_img.setFitWidth(75);
        
        rdie2 = new Image(new FileInputStream("src/bang/media/rdie.png"));
        rDie2_img = new ImageView(rdie2);
        rDie2_img.setLayoutX(385);
        rDie2_img.setLayoutY(100);
        rDie2_img.setPreserveRatio(true);
        rDie2_img.setFitWidth(75);
        
        rdie3 = new Image(new FileInputStream("src/bang/media/rdie.png"));
        rDie3_img = new ImageView(rdie3);
        rDie3_img.setLayoutX(470);
        rDie3_img.setLayoutY(100);
        rDie3_img.setPreserveRatio(true);
        rDie3_img.setFitWidth(75);
        
        rdie4 = new Image(new FileInputStream("src/bang/media/rdie.png"));
        rDie4_img = new ImageView(rdie4);
        rDie4_img.setLayoutX(555);
        rDie4_img.setLayoutY(100);
        rDie4_img.setPreserveRatio(true);
        rDie4_img.setFitWidth(75);
        
        rdie5 = new Image(new FileInputStream("src/bang/media/rdie.png"));
        rDie5_img = new ImageView(rdie5);
        rDie5_img.setLayoutX(640);
        rDie5_img.setLayoutY(100);
        rDie5_img.setPreserveRatio(true);
        rDie5_img.setFitWidth(75);
        
        bdie = new Image(new FileInputStream("src/bang/media/bdie.png"));
        bDie_img = new ImageView(bdie);
        bDie_img.setLayoutX(555);
        bDie_img.setLayoutY(100);
        bDie_img.setPreserveRatio(true);
        bDie_img.setFitWidth(75);
        
        bdie2 = new Image(new FileInputStream("src/bang/media/bdie.png"));
        bDie2_img = new ImageView(bdie2);
        bDie2_img.setLayoutX(640);
        bDie2_img.setLayoutY(100);
        bDie2_img.setPreserveRatio(true);
        bDie2_img.setFitWidth(75);
        
        ldie = new Image(new FileInputStream("src/bang/media/ldie.png"));
        lDie_img = new ImageView(ldie);
        lDie_img.setLayoutX(385);
        lDie_img.setLayoutY(100);
        lDie_img.setPreserveRatio(true);
        lDie_img.setFitWidth(75);
        
        cdie = new Image(new FileInputStream("src/bang/media/cdie.png"));
        cDie_img = new ImageView(cdie);
        cDie_img.setLayoutX(385);
        cDie_img.setLayoutY(100);
        cDie_img.setPreserveRatio(true);
        cDie_img.setFitWidth(75);
        
        diceNames.setWrapText(true);
        diceNames.setFont(Font.font("Copperplate", 15));
        diceDesc.setWrapText(true);
        
        diceScene = new Scene(diceGroup, 300, 450, Color.BEIGE);
        ddScene = new Scene(diceGroup2, 500, 350, Color.BEIGE);
        
        nextMain.setLayoutX(1000);
        nextMain.setLayoutY(650);
        nextMain.setText("Next");
        nextMain.setFont(Font.font("Copperplate", 20));
        
        setupDice.setLayoutX(1000);
        setupDice.setLayoutY(650);
        setupDice.setText("Choose Dice");
        setupDice.setFont(Font.font("Copperplate", 20));
        nextMain.setOnAction(e->{
            group1.getChildren().clear();
            
            group1.getChildren()
                    .addAll(background, musicToggle, character, setupDice);
            window.setTitle("BANG! Gameplay");
            window.setScene(scene1);
            window.show();
        });
        
        charTooltips();
        
    }
    //sets character tooltips
    public void charTooltips(){
        Tooltip t = new Tooltip("Black Jack");
        t.setFont(Font.font ("Copperplate"));
        Tooltip.install(black_img, t);
        Tooltip t1 = new Tooltip("El Gringo");
        t1.setFont(Font.font ("Copperplate"));
        Tooltip.install(gringo_img, t1);
        Tooltip t2 = new Tooltip("Jesse Jones");
        t2.setFont(Font.font ("Copperplate"));
        Tooltip.install(jesse_img, t2);
        Tooltip t3 = new Tooltip("Jourdonnais");
        t3.setFont(Font.font ("Copperplate"));
        Tooltip.install(jour_img, t3);
        Tooltip t4 = new Tooltip("Paul Regret");
        t4.setFont(Font.font ("Copperplate"));
        Tooltip.install(paul_img, t4);
        Tooltip t5 = new Tooltip("Pedro Ramirez");
        t5.setFont(Font.font ("Copperplate"));
        Tooltip.install(pedro_img, t5);
        Tooltip t6 = new Tooltip("Suzy Lafayette");
        t6.setFont(Font.font ("Copperplate"));
        Tooltip.install(suzy_img, t6);
        Tooltip t7 = new Tooltip("Vulture Sam");
        t7.setFont(Font.font ("Copperplate"));
        Tooltip.install(vulture_img, t7);
        Tooltip t8 = new Tooltip("Jose Delgado");
        t8.setFont(Font.font ("Copperplate"));
        Tooltip.install(jose_img, t8);
        Tooltip t9 = new Tooltip("Tequila Joe");
        t9.setFont(Font.font ("Copperplate"));
        Tooltip.install(tequila_img, t9);
        Tooltip t10 = new Tooltip("Belle Star");
        t10.setFont(Font.font ("Copperplate"));
        Tooltip.install(belle_img, t10);
        Tooltip t11 = new Tooltip("Greg Digger");
        t11.setFont(Font.font ("Copperplate"));
        Tooltip.install(greg_img, t11);
        Tooltip t12 = new Tooltip("Regular Dice");
        t12.setFont(Font.font ("Copperplate"));
        Tooltip.install(dg1, t12);
        Tooltip t13 = new Tooltip("Old Saloon Dice");
        t13.setFont(Font.font ("Copperplate"));
        Tooltip.install(dg2, t13);
        Tooltip t14 = new Tooltip("Undead or Alive Dice");
        t14.setFont(Font.font ("Copperplate"));
        Tooltip.install(dg3, t14);
    }
    //sets window for dice
    public void diceEffects(){
        close.setLayoutX(120);
        close.setLayoutY(410);
        
        diceNames.setText("");
        
        diceNames.setText("Choose a dice group to see dice faces and names.");
        diceNames.setLayoutX(5);
        diceNames.setLayoutY(340);
        diceNames.setPrefWidth(290);
        
        diceGroup.getChildren().clear();
        
        diceGroup.getChildren()
                .addAll(dg1, dg2, dg3, diceNames, close);
        
        dice_n.setScene(diceScene);
        dice_n.setResizable(false);
        dice_n.show();
    } 
    //window for regular dice
    public void dGroup1(){
        close2.setLayoutX(55);
        close2.setLayoutY(310);
        
        diceDesc.setText("");
        diceDesc.setFont(Font.font("Copperplate", 25));
        
        diceDesc.setText("1. Indian Arrow\n2. Dynamite\n"
                        +"3. Bull's Eye 1\n4. Bull's Eye 2\n"
                        +"5. Beer\n6. Gatling");
        diceDesc.setLayoutX(170);
        diceDesc.setLayoutY(10);
        
        diceGroup2.getChildren().clear();
        
        diceGroup2.getChildren()
                .addAll(d1, d2, d3, d4, d5, d6, diceDesc, close2);
        
        dice_d.setScene(ddScene);
        dice_d.setResizable(false);
        dice_d.show();
    }
    //window for Old Saloon dice
    public void dGroup2(){
        close2.setLayoutX(55);
        close2.setLayoutY(310);
        
        diceDesc.setText("");
        diceDesc.setFont(Font.font("Copperplate", 25));
        
        diceDesc.setText("1. Broken Arrow\n2. Bullet\n"
                        +"3. Double Bull's Eye 1\n4. Double "
                        + "Bull's Eye 2\n5. Double Beer\n6. "
                        + "Double Gatling");
        diceDesc.setLayoutX(170);
        diceDesc.setLayoutY(10);
        diceGroup2.getChildren().clear();
        
        diceGroup2.getChildren()
                .addAll(dc2, dl2, dl5, dl4, dc6, dl6, diceDesc, close2);
        
        dice_d.setScene(ddScene);
        dice_d.setResizable(false);
        dice_d.show();
    }
    //window for Undead or Alive dice
    public void dGroup3(){
        close2.setLayoutX(55);
        close2.setLayoutY(310);
        
        diceDesc.setText("");
        diceDesc.setFont(Font.font("Copperplate", 25));
        
        diceDesc.setText("1. Indian Arrow\n2. Dynamite\n"
                + "3. Whiskey\n4. Gatling\n"
                + "5. Fight a Duel");
        diceDesc.setLayoutX(170);
        diceDesc.setLayoutY(10);
        diceGroup2.getChildren().clear();
        
        diceGroup2.getChildren()
                .addAll(du1, du2, du3, du4, du5, diceDesc, close2);
        
        dice_d.setScene(ddScene);
        dice_d.setResizable(false);
        dice_d.show();
    }
    //sets dialog windows for the characer descriptions
    public void blackDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Black Jack");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("BLACK JACK\n(8 Life Points)\n\nYou may re-roll Dynamite"
                + " (not if you roll three or more!).\n\nIf you roll three or "
                + "more Dynamite at once (or in total if you didn’t re-roll "
                + "them), follow the usual rules (your turn ends, etc.).");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void gringoDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("El Gringo");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("EL GRINGO\n(7 Life Points)\n\nWhen a player makes you "
                + "lose one or more life points, he must take an arrow.\n\nLife "
                + "points lost to Indians or Dynamite are not affected.");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void jesseDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Jesse Jones");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("JESSE JONES\n(9 Life Points)\n\nIf you have four "
                + "life points or less, you gain two if you use BEER for "
                + "yourself.\n\nFor example, if you have four life points and use"
                + " two beers, you get four life points.");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void jourDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Jourdonnais");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("JOURDONNAIS\n(7 Life Points)\n\nYou never lose more"
                + " than one life point to Indians.");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void paulDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Paul Regret");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("PAUL REGRET\n(9 Life Points)\n\nYou never lose "
                + "life points to the Gatling Gun.");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void pedroDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Pedro Ramirez");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("PEDRO RAMIREZ\n(8 Life Points)\n\nEach time you lose a"
                + " life point, you may discard one of your arrows.\n\nYou "
                + "still lose the life point when you use this ability.");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void suzyDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Suzy Lafayette");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("SUZY LAFAYETTE\n(8 Life Points)\n\nIf you didn’t roll"
                + " any BULLSEYE1 or BULLSEYE2, you gain two life points.\n\n"
                + "This only applies at the END of your turn, not during your"
                + " re-rolls.");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void vultureDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Vulture Sam");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("VULTURE SAM\n(9 Life Points)\n\nEach time another "
                + "player is eliminated, you gain two life points.");
        charDesc.setText(desc);
        char_desc.show();
        
    }
    public void joseDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Jose Delgado");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("JOSE DELGADO\n(7 Life Points)\n\nYou may use the Loudmouth"
                + " die without replacing a base die (roll six dice"
                + "total).\n\nIf you use the Loudmouth die, you roll "
                + "6 dice total; if you use the Coward die, 5. You "
                + "cannot use the Loudmouth and the Coward dice together.");
        charDesc.setText(desc);
        char_desc.show();
    }
    public void tequilaDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Tequila Joe");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("TEQUILA JOE\n(7 Life Points)\n\nYou may use the Coward"
                + " die without replacing a base die (roll six dice total).\n\n"
                + "If you use the Coward die, you roll 6 dice total; if you "
                + "use the Loudmouth die, 5. You cannot use the Loudmouth and "
                + "the Coward dice together.");
        charDesc.setText(desc);
        char_desc.show();
    }
    public void belleDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Belle Star");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("BELLE STAR\n(8 Life Points)\n\nAfter each of your dice "
                + "rolls, you can change one DYNAMITE to GATLING\n\n"
                + "(Not if you roll three or more DYNAMITE!).");
        charDesc.setText(desc);
        char_desc.show();
    }
    public void gregDesc(){
        close2.setLayoutX(120);
        close2.setLayoutY(250);
        char_desc.setTitle("Greg Digger");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("GREG DIGGER\n(7 Life Points)\n\nYou may use each "
                + "WHISKEY you roll twice.");
        charDesc.setText(desc);
        char_desc.show();
    }
    //sets dialog windows for the rules
    public void regDesc(){
        char_desc.setTitle("Jose Delgado");
        
        charGroup.getChildren().clear();
        
        charGroup.getChildren()
            .addAll(cD, close2);
        
        charDesc.clear();
        String desc = ("JOSE DELGADO\n(7 Life Points)\n\nYou may use the Loudmouth"
                + " die without replacing a base die (roll six dice"
                + "total).\n\nIf you use the Loudmouth die, you roll "
                + "6 dice total; if you use the Coward die, 5. You "
                + "cannot use the Loudmouth and the Coward dice together.");
        charDesc.setText(desc);
        char_desc.show();
    }
    public void saloonR(){
        
        switch(pageNum){
            case 0: SR1.setVisible(true);
                SR2.setVisible(false);
                SR3.setVisible(false);
                SR4.setVisible(false);
                break;
            case 1: SR1.setVisible(false);
                SR2.setVisible(true);
                SR3.setVisible(false);
                SR4.setVisible(false);
                break;
            case 2: SR1.setVisible(false);
                SR2.setVisible(false);
                SR3.setVisible(true);
                SR4.setVisible(false);
                break;
            case 3: SR1.setVisible(false);
                SR2.setVisible(false);
                SR3.setVisible(false);
                SR4.setVisible(true);
                break;
        }
    }
    public void undeadR(){
        
        switch(pageNum){
            case 0: UR1.setVisible(true);
                UR2.setVisible(false);
                UR3.setVisible(false);
                UR4.setVisible(false);
                UR5.setVisible(false);
                UR6.setVisible(false);
                UR7.setVisible(false);
                UR8.setVisible(false);
                break;
            case 1: UR1.setVisible(false);
                UR2.setVisible(true);
                UR3.setVisible(false);
                UR4.setVisible(false);
                UR5.setVisible(false);
                UR6.setVisible(false);
                UR7.setVisible(false);
                UR8.setVisible(false);
                break;
            case 2: UR1.setVisible(false);
                UR2.setVisible(false);
                UR3.setVisible(true);
                UR4.setVisible(false);
                UR5.setVisible(false);
                UR6.setVisible(false);
                UR7.setVisible(false);
                UR8.setVisible(false);
                break;
            case 3: UR1.setVisible(false);
                UR2.setVisible(false);
                UR3.setVisible(false);
                UR4.setVisible(true);
                UR5.setVisible(false);
                UR6.setVisible(false);
                UR7.setVisible(false);
                UR8.setVisible(false);
                break;
            case 4: UR1.setVisible(false);
                UR2.setVisible(false);
                UR3.setVisible(false);
                UR4.setVisible(false);
                UR5.setVisible(true);
                UR6.setVisible(false);
                UR7.setVisible(false);
                UR8.setVisible(false);
                break;
            case 5: UR1.setVisible(false);
                UR2.setVisible(false);
                UR3.setVisible(false);
                UR4.setVisible(false);
                UR5.setVisible(false);
                UR6.setVisible(true);
                UR7.setVisible(false);
                UR8.setVisible(false);
                break;
            case 6: UR1.setVisible(false);
                UR2.setVisible(false);
                UR3.setVisible(false);
                UR4.setVisible(false);
                UR5.setVisible(false);
                UR6.setVisible(false);
                UR7.setVisible(true);
                UR8.setVisible(false);
                break;
            case 7: UR1.setVisible(false);
                UR2.setVisible(false);
                UR3.setVisible(false);
                UR4.setVisible(false);
                UR5.setVisible(false);
                UR6.setVisible(false);
                UR7.setVisible(false);
                UR8.setVisible(true);
                break;
        }
    } 
    //assigns each AI and the user a character and role
    public void assign(){
        //Sets the number of players in the game to how many AI there are going to be
        cSel = (int)players.getValue()-1; 
        
        //Create Character Cards and adds them to char_cards ArrayList
        if(salInc.isSelected()){
            char_cards.add(new CharCards("Jose Delgado", 7));
            char_cards.add(new CharCards("Tequila Joe", 7));
            Collections.shuffle(char_cards);  
        }
        if(undInc.isSelected()){
            char_cards.add(new CharCards("Belle Star", 8));
            char_cards.add(new CharCards("Greg Digger", 7));
            Collections.shuffle(char_cards);
        }
        char_cards.add(new CharCards("Black Jack", 8));
        char_cards.add(new CharCards("El Gringo", 7));
        char_cards.add(new CharCards("Jesse Jones", 9));
        char_cards.add(new CharCards("Jourdonnais", 7));
        char_cards.add(new CharCards("Paul Regret", 9));
        char_cards.add(new CharCards("Pedro Ramirez", 8));
        char_cards.add(new CharCards("Suzy Lafayette", 8));
        char_cards.add(new CharCards("Vulture Sam", 9));
        Collections.shuffle(char_cards);  

        //A switch to add specific cards based on how many players there are
        switch(cSel)
        {
            case 7:
                role_cards.add(new Roles("Renegade"));
            case 6:
                role_cards.add(new Roles("Deputy"));
            case 5:
                role_cards.add(new Roles("Outlaw"));
            case 4:
                role_cards.add(new Roles("Deputy"));
            case 3:
                role_cards.add(new Roles("Sheriff"));
                role_cards.add(new Roles("Renegade"));
                role_cards.add(new Roles("Outlaw"));
                role_cards.add(new Roles("Outlaw"));
                Collections.shuffle(role_cards);                                //Shuffles the cards to make roles random
        }
        
        //A switch to give all players(including AI) random characters and rolls
        switch(cSel){
            case 7:
                ai7 = new Player(char_cards.get(7).name, char_cards.get(7).lp,
                        role_cards.get(7).role, true);
            case 6:
                ai6 = new Player(char_cards.get(6).name, char_cards.get(6).lp,
                        role_cards.get(6).role, true);
            case 5:
                ai5 = new Player(char_cards.get(5).name, char_cards.get(5).lp,
                        role_cards.get(5).role, true);
            case 4:
                ai4 = new Player(char_cards.get(4).name, char_cards.get(4).lp,
                        role_cards.get(4).role, true);
            case 3:
                human = new Player(char_cards.get(0).name, char_cards.get(0).lp,
                        role_cards.get(0).role, false);
                ai1 = new Player(char_cards.get(1).name, char_cards.get(1).lp,
                        role_cards.get(1).role, true);
                ai2 = new Player(char_cards.get(2).name, char_cards.get(2).lp,
                        role_cards.get(2).role, true);
                ai3 = new Player(char_cards.get(3).name, char_cards.get(3).lp,
                        role_cards.get(3).role, true);
        }
    }
    //prob gonna remove this and add to assign() method, reveals roles
    public void revealSheriff(){
            init.setText("You are the "+human.role+", playing as "+human.name+".\n");
            init.setFont(Font.font("Copperplate", 25));
            init.setWrapText(true);
            init.setPrefSize(600, 400);
            switch(cSel){
            case 7:
                if(ai7.role.equals("Sheriff"))
                    init.setText(init.getText()+"NPC 7 is the Sheriff, playing as "+ai7.name+".\n");
                else
                    init.setText(init.getText()+"NPC 7 is playing as "+ai7.name+". \n");
            case 6:
                if(ai6.role.equals("Sheriff"))
                    init.setText(init.getText()+"NPC 6 is the Sheriff, playing as "+ai6.name+".\n");
                else
                    init.setText(init.getText()+"NPC 6 is playing as "+ai6.name+". \n");
            case 5:
                if(ai5.role.equals("Sheriff"))
                    init.setText(init.getText()+"NPC 5 is the Sheriff, playing as "+ai5.name+".\n");
                else
                    init.setText(init.getText()+"NPC 5 is playing as "+ai5.name+". \n");
            case 4:
                if(ai4.role.equals("Sheriff"))
                    init.setText(init.getText()+"NPC 4 is the Sheriff, playing as "+ai4.name+".\n");
                else
                    init.setText(init.getText()+"NPC 4 is playing as "+ai4.name+". \n");
            case 3:
                if(ai3.role.equals("Sheriff"))
                    init.setText(init.getText()+"NPC 3 is the Sheriff, playing as "+ai3.name+".\n");
                else
                    init.setText(init.getText()+"NPC 3 is playing as "+ai3.name+". \n");
                if(ai2.role.equals("Sheriff"))
                    init.setText(init.getText()+"NPC 2 is the Sheriff, playing as "+ai2.name+".\n");
                else
                    init.setText(init.getText()+"NPC 2 is playing as "+ai2.name+". \n");
                if(ai1.role.equals("Sheriff"))
                    init.setText(init.getText()+"NPC 1 is the Sheriff, playing as "+ai1.name+".\n");
                else
                    init.setText(init.getText()+"NPC 1 is playing as "+ai1.name+". \n");
            }
            
            setPlayOrder();
    }
    //sets play order starting with sheriff
    public void setPlayOrder(){
        //A temp list to store all players for UI, game mechanics, and more
        temp_play_order.add(human);
        temp_play_order.add(ai1);
        temp_play_order.add(ai2);
        temp_play_order.add(ai3);
        temp_play_order.add(ai4);
        temp_play_order.add(ai5);
        temp_play_order.add(ai6);
        temp_play_order.add(ai7);

        //Temp variables for helping with making the play order
        int stop = -1;
        boolean sher = false;

        //Making the human's role shown so they know which team they are on
        temp_play_order.get(0).shown = true;
        
        //This figures out who's the Sheriff and the correct playing order
        for (int i = 0; i < 16; i++) {                                          
            if (!(temp_play_order.get(i % 8).role.equals("NULL"))) {            
                if (sher == true) {                                             
                    if (i % 8 == stop) {                                        
                        break;                                                  
                    } 
                    else {                                                        
                        play_order.add(temp_play_order.get(i % 8));                   
                    }
                }
                if (sher == false) {                                              
                    if (temp_play_order.get(i % 8).role.equals("Sheriff")) {       
                        temp_play_order.get(i % 8).setMaxHealth(
                                temp_play_order.get(i % 8).maxHealth + 2);         
                        temp_play_order.get(i % 8).heal(2);                         
                        temp_play_order.get(i % 8).shown = true;                 
                        temp_play_order.get(i % 8).known = true;                   
                        play_order.add(temp_play_order.get(i % 8));                
                        stop = i;                                                  
                        sher = true;                                         
                    }
                }

            }
        }
        
        character.setLayoutX(10);
        character.setLayoutY(10);
        character.setWrapText(true);
        character.setFont(Font.font("Copperplate", 20));
        
        //Start of play order
        character.setText("The play order is: \n");
        
        //Prints out the play order, starting with sheriff
        for (int j = 0; j < play_order.size(); j++) {
            character.setText(character.getText()+ (j + 1) + ") " + play_order.get(j).name + "\n");
        }
        character.setText(character.getText()+"\n");
        
        
        left1 = play_order.get(1);
        right1 = play_order.get(play_order.size() - 1);
        try {
            left2 = play_order.get(2);
        } catch (Exception a) {
            left2 = play_order.get(0);
        }
        try {
            left3 = play_order.get(3);
        } catch (Exception a) {
            left3 = play_order.get(0);
        }
        try {
            right2 = play_order.get(play_order.size() - 2);
        } catch (Exception a) {
            right2 = play_order.get(0);
        }
        try {
            right3 = play_order.get(play_order.size() - 3);
        } catch (Exception a) {
            right3 = play_order.get(0);
        }
    }  
    //trying to implement a button for dice rolling initiative
    public void diceSetup(){        
        checkBoxes.add(die1);
        checkBoxes.add(die2);
        checkBoxes.add(die3);
        checkBoxes.add(die4);
        checkBoxes.add(die5);
        
        d1.setLayoutY(300);
        d2.setLayoutY(300);
        d3.setLayoutY(300);
        d4.setLayoutY(300);
        d5.setLayoutY(300);
        d6.setLayoutY(300);
        
        d12.setLayoutY(300);
        d22.setLayoutY(300);
        d32.setLayoutY(300);
        d42.setLayoutY(300);
        d52.setLayoutY(300);
        d62.setLayoutY(300);
        
        d13.setLayoutY(300);
        d23.setLayoutY(300);
        d33.setLayoutY(300);
        d43.setLayoutY(300);
        d53.setLayoutY(300);
        d63.setLayoutY(300);
        
        d14.setLayoutY(300);
        d24.setLayoutY(300);
        d34.setLayoutY(300);
        d44.setLayoutY(300);
        d54.setLayoutY(300);
        d64.setLayoutY(300);
        
        d15.setLayoutY(300);
        d25.setLayoutY(300);
        d35.setLayoutY(300);
        d45.setLayoutY(300);
        d55.setLayoutY(300);
        d65.setLayoutY(300);
        
        dl1.setLayoutY(300);
        dl2.setLayoutY(300);
        dl3.setLayoutY(300);
        dl4.setLayoutY(300);
        dl5.setLayoutY(300);
        dl6.setLayoutY(300);
        
        dc1.setLayoutY(300);
        dc2.setLayoutY(300);
        dc3.setLayoutY(300);
        dc4.setLayoutY(300);
        dc5.setLayoutY(300);
        dc6.setLayoutY(300);
        
        du1.setLayoutY(300);
        du2.setLayoutY(300);
        du3.setLayoutY(300);
        du4.setLayoutY(300);
        du5.setLayoutY(300);
        du6.setLayoutY(300);
        
        du12.setLayoutY(300);
        du22.setLayoutY(300);
        du32.setLayoutY(300);
        du42.setLayoutY(300);
        du52.setLayoutY(300);
        du62.setLayoutY(300);
        
        d1.setVisible(false);
        d2.setVisible(false);
        d3.setVisible(false);
        d4.setVisible(false);
        d5.setVisible(false);
        d6.setVisible(false);
        
        d12.setVisible(false);
        d22.setVisible(false);
        d32.setVisible(false);
        d42.setVisible(false);
        d52.setVisible(false);
        d62.setVisible(false);
        
        d13.setVisible(false);
        d23.setVisible(false);
        d33.setVisible(false);
        d43.setVisible(false);
        d53.setVisible(false);
        d63.setVisible(false);
        
        d14.setVisible(false);
        d24.setVisible(false);
        d34.setVisible(false);
        d44.setVisible(false);
        d54.setVisible(false);
        d64.setVisible(false);
        
        d15.setVisible(false);
        d25.setVisible(false);
        d35.setVisible(false);
        d45.setVisible(false);
        d55.setVisible(false);
        d65.setVisible(false);
        
        dl1.setVisible(false);
        dl2.setVisible(false);
        dl3.setVisible(false);
        dl4.setVisible(false);
        dl5.setVisible(false);
        dl6.setVisible(false);
        
        dc1.setVisible(false);
        dc2.setVisible(false);
        dc3.setVisible(false);
        dc4.setVisible(false);
        dc5.setVisible(false);
        dc6.setVisible(false);
        
        du1.setVisible(false);
        du2.setVisible(false);
        du3.setVisible(false);
        du4.setVisible(false);
        du5.setVisible(false);
        du6.setVisible(false);
        
        du12.setVisible(false);
        du22.setVisible(false);
        du32.setVisible(false);
        du42.setVisible(false);
        du52.setVisible(false);
        du62.setVisible(false);
        
        loudmouth.setLayoutX(300);
        loudmouth.setLayoutY(185);
        loudmouth.setFont(Font.font("Copperplate", 20));
        coward.setLayoutX(300);
        coward.setLayoutY(215);
        coward.setFont(Font.font("Copperplate", 20));
        
        rollDice.setLayoutX(850);
        rollDice.setLayoutY(120);
        rollDice.setText("ROLL");
        rollDice.setFont(Font.font("Copperplate", 20));
        
        chiefY.setLayoutX(850);
        chiefY.setLayoutY(400);
        chiefY.setText("Yes");
        chiefY.setVisible(false);
        chiefY.setFont(Font.font("Copperplate", 20));
        
        chiefN.setLayoutX(950);
        chiefN.setLayoutY(400);
        chiefN.setText("No");
        chiefN.setVisible(false);
        chiefN.setFont(Font.font("Copperplate", 20));
         
        chiefChoice.setLayoutX(850);
        chiefChoice.setLayoutY(350);
        chiefChoice.setText("Do you want the chief arrow?");
        chiefChoice.setVisible(false);
        chiefChoice.setFont(Font.font("Copperplate", 20));
        
        action.setLayoutX(300);
        action.setLayoutY(400);
        action.setWrapText(true);
        action.setText("");
        action.setVisible(true);
        action.setFont(Font.font("Copperplate", 20));
        
        indAtt.setLayoutX(300);
        indAtt.setLayoutY(450);
        indAtt.setWrapText(true);
        indAtt.setText("Indians are attacking!");
        indAtt.setVisible(false);
        indAtt.setFont(Font.font("Copperplate", 25));
        
        dynExp.setLayoutX(300);
        dynExp.setLayoutY(450);
        dynExp.setWrapText(true);
        dynExp.setVisible(false);
        dynExp.setFont(Font.font("Copperplate", 25));
        
        drank.setLayoutX(300);
        drank.setLayoutY(450);
        drank.setWrapText(true);
        drank.setVisible(false);
        drank.setFont(Font.font("Copperplate", 25));
            
        chiefY.setOnAction(e-> {
            rollDice.setDisable(false);
            current.chiefArrow = true;
            chiefArrow = false;
            chiefY.setVisible(false);
            chiefN.setVisible(false);
            chiefChoice.setVisible(false);
        });

        chiefN.setOnAction(e-> {
            rollDice.setDisable(false);
            current.chiefArrow = false;
            chiefArrow = true;
            chiefY.setVisible(false);
            chiefN.setVisible(false);
            chiefChoice.setVisible(false);
        });
        
        group3.getChildren().clear();
        group3.getChildren()
                .addAll(background, musicToggle, character, rollDice, d1, 
                        d2, d3, d4, d5, d6, d12, d22, d32, d42, d52, d62, 
                        d13, d23, d33, d43, d53, d63, d14, d24, d34, d44, 
                        d54, d64, d15, d25, d35, d45, d55, d65,  dc1, 
                        dc2, dc3, dc4, dc5, dc6, dl1, dl2, dl3, dl4, dl5, 
                        dl6, du1, du2, du3, du4, du5, du6, du12, du22, 
                        du32, du42, du52, du62, die1, die2, die3, die4, die5,
                        action, indAtt, dynExp);
        if((undInc.isSelected())){
            group3.getChildren()
                    .addAll(bDie_img, bDie2_img);
            die4.setText("Look At Me");
            die5.setText("Look At Me");
            dice.remove(RD4);
            RD4 = new Dice(2, 0, "Indian Arrow", "Dynamite",
                "Whiskey", "Gatling", "Duel", "Duel");
            dice.add(RD4); 
            dice.remove(RD5);
            RD5 = new Dice(2, 0, "Indian Arrow", "Dynamite",
                "Whiskey", "Gatling", "Duel", "Duel");
            dice.add(RD5);
            if((salInc.isSelected())){
                chiefArrow = true;
                arrowCount = 10;
                chief = true;
                group3.getChildren()
                        .addAll(lDie_img, cDie_img, rDie_img, rDie2_img,
                                rDie3_img, loudmouth, coward, chiefY, chiefN,
                                chiefChoice);
                }
            else if((!salInc.isSelected())){
                chiefArrow = false;
                arrowCount = 9;
                chief = false;
                group3.getChildren()
                        .removeAll(chiefY, chiefN, chiefChoice);
                group3.getChildren()
                        .addAll(rDie_img, rDie2_img, rDie3_img);
                }
            
            }
        else if((!undInc.isSelected())){
            group3.getChildren()
                    .add(rDie_img);
            die4.setText("");
            die5.setText("");
            dice.remove(RD4);
            RD4 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
                    "Bull's Eye 2", "Beer", "Gatling");
            dice.add(RD4);
            dice.remove(RD5);
            RD5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
                    "Bull's Eye 2", "Beer", "Gatling");
            dice.add(RD5);
            if((salInc.isSelected())){
                chiefArrow = true;
                arrowCount = 10;
                chief = true;
                group3.getChildren()
                        .addAll(lDie_img, cDie_img, rDie3_img, rDie2_img,
                                rDie4_img, rDie5_img, loudmouth, coward,
                                chiefY, chiefN, chiefChoice);
                }
            else if((!salInc.isSelected())){
                chiefArrow = false;
                arrowCount = 9;
                chief = false;
                group3.getChildren()
                        .removeAll(chiefY, chiefN, chiefChoice);
                group3.getChildren()
                        .addAll(rDie4_img, rDie2_img, rDie3_img, rDie5_img);
                }
            }
        window.setScene(scene2);
        window.show();
        
        coward.setText("Use Coward Die");
        loudmouth.setText("Use Loudmouth Die");
        
        loudmouth.setOnAction((ActionEvent event) -> {
            event.consume();
            lDSelect = loudmouth.isSelected();
            
            if(lDSelect){
                die2.setText("Loudmouth");
                dice.remove(RD2);
                RD2 = new Dice(1, 0, "Indian Arrow", "Bullet", "Dynamite", 
                        "Double Bull's Eye 1", "Double Bull's Eye 2", 
                        "Double Gatling");
                dice.add(RD2);
                loudmouth.setText("Loudmouth Die in use");
                coward.setText("Use Coward Die");
                coward.setSelected(false);
                cDie_img.setVisible(false);
                lDie_img.setVisible(true);
                rDie2_img.setVisible(false);
            } else {
                die2.setText("");
                dice.remove(RD2);
                RD2 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
                    "Bull's Eye 2", "Beer", "Gatling");
                dice.add(RD2);
                loudmouth.setText("Use Loudmouth Die");
                cDie_img.setVisible(false);
                lDie_img.setVisible(false);
                rDie2_img.setVisible(true);
            }
        });     
        
        coward.setOnAction((ActionEvent event) -> {
            event.consume();
            cDSelect = coward.isSelected();
            
            if(cDSelect){
                die2.setText("Coward");
                dice.remove(RD2);
                RD2 = new Dice(1, 0, "Indian Arrow", "Broken Arrow", "Dynamite",
                        "Bull's Eye 1", "Beer", "Double Beer");
                dice.add(RD2)
                coward.setText("Coward Die in use");
                loudmouth.setText("Use Loudmouth Die");
                loudmouth.setSelected(false);
                lDie_img.setVisible(false);
                cDie_img.setVisible(true);
                rDie2_img.setVisible(false);
            } else {
                die2.setText("");
                dice.remove(RD2);
                RD2 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
                    "Bull's Eye 2", "Beer", "Gatling");
                dice.add(RD2);
                coward.setText("Use Coward Die");
                lDie_img.setVisible(false);
                cDie_img.setVisible(false);
                rDie2_img.setVisible(true);
            }
        });
        
        rollDice.setOnAction(e-> {
            rollS.seek(Duration.ZERO);
            rollS.play();
            rollDiceGo();
        });
    }
    
    public void resetDieFace(){
        
        d1.setVisible(false);
        d2.setVisible(false);
        d3.setVisible(false);
        d4.setVisible(false);
        d5.setVisible(false);
        d6.setVisible(false);
        
        d12.setVisible(false);
        d22.setVisible(false);
        d32.setVisible(false);
        d42.setVisible(false);
        d52.setVisible(false);
        d62.setVisible(false);
        
        d13.setVisible(false);
        d23.setVisible(false);
        d33.setVisible(false);
        d43.setVisible(false);
        d53.setVisible(false);
        d63.setVisible(false);
        
        d14.setVisible(false);
        d24.setVisible(false);
        d34.setVisible(false);
        d44.setVisible(false);
        d54.setVisible(false);
        d64.setVisible(false);
        
        d15.setVisible(false);
        d25.setVisible(false);
        d35.setVisible(false);
        d45.setVisible(false);
        d55.setVisible(false);
        d65.setVisible(false);
        
        dl1.setVisible(false);
        dl2.setVisible(false);
        dl3.setVisible(false);
        dl4.setVisible(false);
        dl5.setVisible(false);
        dl6.setVisible(false);
        
        dc1.setVisible(false);
        dc2.setVisible(false);
        dc3.setVisible(false);
        dc4.setVisible(false);
        dc5.setVisible(false);
        dc6.setVisible(false);
        
        du1.setVisible(false);
        du2.setVisible(false);
        du3.setVisible(false);
        du4.setVisible(false);
        du5.setVisible(false);
        du6.setVisible(false);
        
        du12.setVisible(false);
        du22.setVisible(false);
        du32.setVisible(false);
        du42.setVisible(false);
        du52.setVisible(false);
        du62.setVisible(false);
        
    }
    
    public void rollDiceGo(){
        
        dynamiteCount = 0;
        finalDice.clear();
        action.setText("");
        rollCount = 0;
        //curent(player object) for easier referencing 
        current = play_order.get(0);
        
        group3.getChildren().remove(character);
        //Start of play order
        character.setText("Players: \n"
                + current.name +"'s turn \n");

        for (int j = 0; j < play_order.size(); j++) {
            if(play_order.get(j).computer == false){
                character.setText(character.getText()+ (j + 1) + ") You " 
                    + "\nHealth: "+play_order.get(j).health
                    +"\nArrows: "+play_order.get(j).arrows);
            } else {
                character.setText(character.getText()+ (j + 1) + ") "
                    + play_order.get(j).name
                    + "\nHealth: "+play_order.get(j).health
                    + "\nArrows: "+play_order.get(j).arrows);
            }
            if(play_order.get(j).chiefArrow == true)
            {
            character.setText(character.getText()
                    +"\nHas Chief Arrow"
                    +"\n\n");
            }
            else {
                character.setText(character.getText()+".\n\n");
            }
        }
        group3.getChildren().add(character);
        
        resetDieFace();
        
        for (int roll = 0; roll < 5; roll++) 
            dice.get(roll).roll();
            
        
        System.out.println("Roll " + (rollCount + 1) + " results:");
        System.out.println("Dice 1 : " + RD1.sides[RD1.side]);
        System.out.println("Dice 2 : " + RD2.sides[RD2.side]);
        System.out.println("Dice 3 : " + RD3.sides[RD3.side]);
        System.out.println("Dice 4 : " + RD4.sides[RD4.side]);
        System.out.println("Dice 5 : " + RD5.sides[RD5.side]);
        
        for(int i=0; i<5; i++) {
            checkBoxes.get(i).setDisable(false);
            if(dice.get(i).sides[dice.get(i).side] == "Indian Arrow") {
                if(dice.get(i).dice == 0){
                    if(dice.get(i).equals(RD1)){
                        d1.setLayoutX(300);
                        d1.setVisible(true);
                        die1.setSelected(true);
                        die1.setDisable(true);
                        arrCount++;
                        
                    }
                    if(dice.get(i).equals(RD2)){
                        d12.setLayoutX(385);
                        d12.setVisible(true);
                        die2.setSelected(true);
                        die2.setDisable(true);
                        arrCount++;
                    }
                    if(dice.get(i).equals(RD3)){
                        d13.setLayoutX(470);
                        d13.setVisible(true);
                        die3.setSelected(true);
                        die3.setDisable(true);
                        arrCount++;
                    }
                    if(dice.get(i).equals(RD4)){
                        d14.setLayoutX(555);
                        d14.setVisible(true);
                        die4.setSelected(true);
                        die4.setDisable(true);
                        arrCount++;
                    }
                    if(dice.get(i).equals(RD5)){
                        d15.setLayoutX(640);
                        d15.setVisible(true);
                        die5.setSelected(true);
                        die5.setDisable(true);
                        arrCount++;
                    }
                }
                else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Bullet"){
                    if(dice.get(i).equals(RD2)){
                        dl1.setLayoutX(385);
                        dl1.setVisible(true);
                        die2.setSelected(true);
                        die2.setDisable(true);
                        arrCount++;
                    }
                }
                else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Broken Arrow"){
                    if(dice.get(i).equals(RD2)){
                        dc1.setLayoutX(385);
                        dc1.setVisible(true);
                        die2.setSelected(true);
                        die2.setDisable(true);
                        arrCount++;
                    }
                }
                else if(dice.get(i).dice == 2){
                    if(dice.get(i).equals(RD4)){
                        du1.setLayoutX(555);
                        du1.setVisible(true);
                        die4.setSelected(true);
                        die4.setDisable(true);
                        arrCount++;
                    }
                    if(dice.get(i).equals(RD5)){
                        du12.setLayoutX(640);
                        du12.setVisible(true);
                        die5.setSelected(true);
                        die5.setDisable(true);
                        arrCount++;
                    }
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Broken Arrow") {
                if(dice.get(i).dice == 1) {
                    dc2.setLayoutX(385);
                    dc2.setVisible(true);
                    die2.setSelected(true);
                    die2.setDisable(true);
                    barrowAction();
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Bullet") {
                if(dice.get(i).dice == 1) {
                    dl2.setLayoutX(385);
                    dl2.setVisible(true);
                    die2.setSelected(true);
                    die2.setDisable(true);
                    bulletAction();
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Dynamite") {
                if(dice.get(i).dice == 0){
                    if(dice.get(i).equals(RD1)){
                        d2.setLayoutX(300);
                        d2.setVisible(true);
                        dynamiteCount++;
                    }
                    if(dice.get(i).equals(RD2)){
                        d22.setLayoutX(385);
                        d22.setVisible(true);
                        dynamiteCount++;
                    }
                    if(dice.get(i).equals(RD3)){
                        d23.setLayoutX(470);
                        d23.setVisible(true);
                        dynamiteCount++;
                    }
                    if(dice.get(i).equals(RD4)){
                        d24.setLayoutX(555);
                        d24.setVisible(true);
                        dynamiteCount++;
                    }
                    if(dice.get(i).equals(RD5)){
                        d25.setLayoutX(640);
                        d25.setVisible(true);
                        dynamiteCount++;
                    }
                }
                else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Bullet"){
                    if(dice.get(i).equals(RD2)){
                        dl3.setLayoutX(385);
                        dl3.setVisible(true);
                        dynamiteCount++;
                    }
                }
                else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Broken Arrow"){
                    if(dice.get(i).equals(RD2)){
                        dc3.setLayoutX(385);
                        dc3.setVisible(true);
                        dynamiteCount++;
                    }
                }
                else if(dice.get(i).dice == 2){
                    if(dice.get(i).equals(RD4)){
                        du2.setLayoutX(555);
                        du2.setVisible(true);
                        dynamiteCount++;
                    }
                    if(dice.get(i).equals(RD5)){
                        du22.setLayoutX(640);
                        du22.setVisible(true);
                        dynamiteCount++;
                    }
                }
                dynamiteAction(i, dynamiteCount);
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Whiskey") {
                if(dice.get(i).dice == 2){
                    if(dice.get(i).equals(RD4)){
                        du3.setLayoutX(555);
                        du3.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        du32.setLayoutX(640);
                        du32.setVisible(true);
                    }
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Bull's Eye 1") {
                if(dice.get(i).dice == 0){
                    if(dice.get(i).equals(RD1)){
                        d3.setLayoutX(300);
                        d3.setVisible(true);
                    }
                    if(dice.get(i).equals(RD2)){
                        d32.setLayoutX(385);
                        d32.setVisible(true);
                    }
                    if(dice.get(i).equals(RD3)){
                        d33.setLayoutX(470);
                        d33.setVisible(true);
                    }
                    if(dice.get(i).equals(RD4)){
                        d34.setLayoutX(555);
                        d34.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        d35.setLayoutX(640);
                        d35.setVisible(true);
                    }
                }
                else {
                    if(dice.get(i).equals(RD2)){
                        dc4.setLayoutX(385);
                        dc4.setVisible(true);
                    }
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Bull's Eye 2") {
                if(dice.get(i).dice == 0){
                    if(dice.get(i).equals(RD1)){
                        d4.setLayoutX(300);
                        d4.setVisible(true);
                    }
                    if(dice.get(i).equals(RD2)){
                        d42.setLayoutX(385);
                        d42.setVisible(true);
                    }
                    if(dice.get(i).equals(RD3)){
                        d43.setLayoutX(470);
                        d43.setVisible(true);
                    }
                    if(dice.get(i).equals(RD4)){
                        d44.setLayoutX(555);
                        d44.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        d45.setLayoutX(640);
                        d45.setVisible(true);
                    }
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Double Bull's Eye 1") {
                if(dice.get(i).dice == 1) {
                    dl4.setLayoutX(385);
                    dl4.setVisible(true);
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Double Bull's Eye 2") {
                if(dice.get(i).dice == 1) {
                    dl5.setLayoutX(385);
                    dl5.setVisible(true);
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Beer") {
                if(dice.get(i).dice == 0){
                    if(dice.get(i).equals(RD1)){
                        d5.setLayoutX(300);
                        d5.setVisible(true);
                    }
                    if(dice.get(i).equals(RD2)){
                        d52.setLayoutX(385);
                        d52.setVisible(true);
                    }
                    if(dice.get(i).equals(RD3)){
                        d53.setLayoutX(470);
                        d53.setVisible(true);
                    }
                    if(dice.get(i).equals(RD4)){
                        d54.setLayoutX(555);
                        d54.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        d55.setLayoutX(640);
                        d55.setVisible(true);
                    }
                }
                else {
                    if(dice.get(i).equals(RD2)){
                        dc5.setLayoutX(385);
                        dc5.setVisible(true);
                    }
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Double Beer") {
                if(dice.get(i).dice == 1) {
                    dc6.setLayoutX(385);
                    dc6.setVisible(true);
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Gatling") {
                if(dice.get(i).dice == 0){
                    if(dice.get(i).equals(RD1)){
                        d6.setLayoutX(300);
                        d6.setVisible(true);
                    }
                    if(dice.get(i).equals(RD2)){
                        d62.setLayoutX(385);
                        d62.setVisible(true);
                    }
                    if(dice.get(i).equals(RD3)){
                        d63.setLayoutX(470);
                        d63.setVisible(true);
                    }
                    if(dice.get(i).equals(RD4)){
                        d64.setLayoutX(555);
                        d64.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        d65.setLayoutX(640);
                        d65.setVisible(true);
                    }
                }
                else if(dice.get(i).dice == 2){
                    if(dice.get(i).equals(RD4)){
                        du4.setLayoutX(555);
                        du4.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        du42.setLayoutX(640);
                        du42.setVisible(true);
                    }
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Double Gatling") {
                if(dice.get(i).dice == 1) {
                    dl6.setLayoutX(385);
                    dl6.setVisible(true);
                }
            }
            else if(dice.get(i).sides[dice.get(i).side] == "Duel"){
                if(dice.get(i).dice == 2){
                    if(dice.get(i).equals(RD4)){
                        du5.setLayoutX(555);
                        du5.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        du52.setLayoutX(640);
                        du52.setVisible(true);
                    }
                }
                if(dice.get(i).dice == 2){
                    if(dice.get(i).equals(RD4)){
                        du6.setLayoutX(555);
                        du6.setVisible(true);
                    }
                    if(dice.get(i).equals(RD5)){
                        du62.setLayoutX(640);
                        du62.setVisible(true);
                    }
                }
            }
        }
        coward.setDisable(current.computer);
        loudmouth.setDisable(current.computer);
        coward.setSelected(false);
        loudmouth.setSelected(false);
        for (int i = 0; i < 5; i++) {                                    
            checkBoxes.get(i).setFont(Font.font("Copperplate", 10)); 
            checkBoxes.get(i).setLayoutX((i * 85) + 300);   
            checkBoxes.get(i).setLayoutY(275);           
            checkBoxes.get(i).setDisable(current.computer);    

        } 
        if(arrCount != 0)
            arrowAction(arrCount);
        rollDice.setOnAction(e-> {
            rollS.seek(Duration.ZERO);
            rollS.play();
            if(arrCount != 0){
                arrCount = 0;
            }
            rollCount++;
            reroll();
        });
    
    }
    
    public void reroll(){  
        dynamiteCount = 0;
        action.setText("");
        if(rollCount != 4) {
            
            finalDice.clear();
 
            group3.getChildren().remove(character);
            //Start of play order
            character.setText("Players: \n"
                    + current.name +"'s turn \n");

            for (int j = 0; j < play_order.size(); j++) {
                if(play_order.get(j).computer == false){
                    character.setText(character.getText()+ (j + 1) + ") You " 
                        + "\nHealth: "+play_order.get(j).health
                        +"\nArrows: "+play_order.get(j).arrows);
                } else {
                    character.setText(character.getText()+ (j + 1) + ") "
                        + play_order.get(j).name
                        + "\nHealth: "+play_order.get(j).health
                        + "\nArrows: "+play_order.get(j).arrows);
                }
                if(play_order.get(j).chiefArrow == true)
                {
                character.setText(character.getText()
                        +"\nHas Chief Arrow"
                        +"\n\n");
                }
                else {
                    character.setText(character.getText()+".\n\n");
                }
            }
            group3.getChildren().add(character);

            resetDieFace();

            for (int roll = 0; roll < 5; roll++) {
                if(checkBoxes.get(roll).isSelected()) {
                    dice.get(roll).roll();
                }
            }
            System.out.println("Roll " + (rollCount + 1) + " results:");
            System.out.println("Dice 1 : " + RD1.sides[RD1.side]);
            System.out.println("Dice 2 : " + RD2.sides[RD2.side]);
            System.out.println("Dice 3 : " + RD3.sides[RD3.side]);
            System.out.println("Dice 4 : " + RD4.sides[RD4.side]);
            System.out.println("Dice 5 : " + RD5.sides[RD5.side]);

            for(int i=0; i<5; i++) {
                checkBoxes.get(i).setSelected(false);
                checkBoxes.get(i).setDisable(false);
            } 
            current = play_order.get(0);
            coward.setDisable(current.computer);
            loudmouth.setDisable(current.computer);
            coward.setSelected(false);
            loudmouth.setSelected(false);
            for (int i = 0; i < 5; i++) {                                     //For the size of all the check boxes for the dice selection
                checkBoxes.get(i).setFont(Font.font("Copperplate", 10));
                checkBoxes.get(i).setSelected(false);                             //Set all to not selected
                checkBoxes.get(i).setLayoutX((i * 85) + 300);                    //Layout X
                checkBoxes.get(i).setLayoutY(275);                                //Layout Y
                checkBoxes.get(i).setDisable(current.computer);         //Only enabled if current player is not a computer

            } 
            for(int i=0; i<5; i++) {
                if(dice.get(i).sides[dice.get(i).side] == "Indian Arrow") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d1.setLayoutX(300);
                            d1.setVisible(true);
                            die1.setSelected(true);
                            die1.setDisable(true);
                            arrCount++;

                        }
                        if(dice.get(i).equals(RD2)){
                            d12.setLayoutX(385);
                            d12.setVisible(true);
                            die2.setSelected(true);
                            die2.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD3)){
                            d13.setLayoutX(470);
                            d13.setVisible(true);
                            die3.setSelected(true);
                            die3.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD4)){
                            d14.setLayoutX(555);
                            d14.setVisible(true);
                            die4.setSelected(true);
                            die4.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            d15.setLayoutX(640);
                            d15.setVisible(true);
                            die5.setSelected(true);
                            die5.setDisable(true);
                            arrCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Bullet"){
                        if(dice.get(i).equals(RD2)){
                            dl1.setLayoutX(385);
                            dl1.setVisible(true);
                            die2.setSelected(true);
                            die2.setDisable(true);
                            arrCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Broken Arrow"){
                        if(dice.get(i).equals(RD2)){
                            dc1.setLayoutX(385);
                            dc1.setVisible(true);
                            die2.setSelected(true);
                            die2.setDisable(true);
                            arrCount++;
                        }
                    }
                    else if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du1.setLayoutX(555);
                            du1.setVisible(true);
                            die4.setSelected(true);
                            die4.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            du12.setLayoutX(640);
                            du12.setVisible(true);
                            die5.setSelected(true);
                            die5.setDisable(true);
                            arrCount++;
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Broken Arrow") {
                    if(dice.get(i).dice == 1) {
                        dc2.setLayoutX(385);
                        dc2.setVisible(true);
                        die2.setSelected(true);
                        die2.setDisable(true);
                        barrowAction();
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Bullet") {
                    if(dice.get(i).dice == 1) {
                        dl2.setLayoutX(385);
                        dl2.setVisible(true);
                        die2.setSelected(true);
                        die2.setDisable(true);
                        bulletAction();
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Dynamite") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d2.setLayoutX(300);
                            d2.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD2)){
                            d22.setLayoutX(385);
                            d22.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD3)){
                            d23.setLayoutX(470);
                            d23.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD4)){
                            d24.setLayoutX(555);
                            d24.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            d25.setLayoutX(640);
                            d25.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Broken Arrow"){
                        if(dice.get(i).equals(RD2)){
                            dc3.setLayoutX(385);
                            dc3.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Bullet"){
                        if(dice.get(i).equals(RD2)){
                            dl3.setLayoutX(385);
                            dl3.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    else if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du2.setLayoutX(555);
                            du2.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            du22.setLayoutX(640);
                            du22.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    dynamiteAction(i, dynamiteCount);
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Whiskey") {
                    if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du3.setLayoutX(555);
                            du3.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            du32.setLayoutX(640);
                            du32.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Bull's Eye 1") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d3.setLayoutX(300);
                            d3.setVisible(true);
                        }
                        if(dice.get(i).equals(RD2)){
                            d32.setLayoutX(385);
                            d32.setVisible(true);
                        }
                        if(dice.get(i).equals(RD3)){
                            d33.setLayoutX(470);
                            d33.setVisible(true);
                        }
                        if(dice.get(i).equals(RD4)){
                            d34.setLayoutX(555);
                            d34.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            d35.setLayoutX(640);
                            d35.setVisible(true);
                        }
                    }
                    else {
                        if(dice.get(i).equals(RD2)){
                            dc4.setLayoutX(385);
                            dc4.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Bull's Eye 2") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d4.setLayoutX(300);
                            d4.setVisible(true);
                        }
                        if(dice.get(i).equals(RD2)){
                            d42.setLayoutX(385);
                            d42.setVisible(true);
                        }
                        if(dice.get(i).equals(RD3)){
                            d43.setLayoutX(470);
                            d43.setVisible(true);
                        }
                        if(dice.get(i).equals(RD4)){
                            d44.setLayoutX(555);
                            d44.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            d45.setLayoutX(640);
                            d45.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Bull's Eye 1") {
                    if(dice.get(i).dice == 1) {
                        dl4.setLayoutX(385);
                        dl4.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Bull's Eye 2") {
                    if(dice.get(i).dice == 1) {
                        dl5.setLayoutX(385);
                        dl5.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Beer") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d5.setLayoutX(300);
                            d5.setVisible(true);
                        }
                        if(dice.get(i).equals(RD2)){
                            d52.setLayoutX(385);
                            d52.setVisible(true);
                        }
                        if(dice.get(i).equals(RD3)){
                            d53.setLayoutX(470);
                            d53.setVisible(true);
                        }
                        if(dice.get(i).equals(RD4)){
                            d54.setLayoutX(555);
                            d54.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            d55.setLayoutX(640);
                            d55.setVisible(true);
                        }
                    }
                    else {
                        if(dice.get(i).equals(RD2)){
                            dc5.setLayoutX(385);
                            dc5.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Beer") {
                    if(dice.get(i).dice == 1) {
                        dc6.setLayoutX(385);
                        dc6.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Gatling") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d6.setLayoutX(300);
                            d6.setVisible(true);
                        }
                        if(dice.get(i).equals(RD2)){
                            d62.setLayoutX(385);
                            d62.setVisible(true);
                        }
                        if(dice.get(i).equals(RD3)){
                            d63.setLayoutX(470);
                            d63.setVisible(true);
                        }
                        if(dice.get(i).equals(RD4)){
                            d64.setLayoutX(555);
                            d64.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            d65.setLayoutX(640);
                            d65.setVisible(true);
                        }
                    }
                    else if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du4.setLayoutX(555);
                            du4.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            du42.setLayoutX(640);
                            du42.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Gatling") {
                    if(dice.get(i).dice == 1) {
                        dl6.setLayoutX(385);
                        dl6.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Duel"){
                    if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du5.setLayoutX(555);
                            du5.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            du52.setLayoutX(640);
                            du52.setVisible(true);
                        }
                    }
                    if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du6.setLayoutX(555);
                            du6.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            du62.setLayoutX(640);
                            du62.setVisible(true);
                        }
                    }
                }
            }rollCount++;
        }
        if(arrCount != 0){
            arrowAction(arrCount);
            }
        if(rollCount != 4)
            rollDice.setOnAction(e->{
                rollS.seek(Duration.ZERO);
                rollS.play();
                arrCount = 0;
                reroll2();
            });

    }
    
    public void reroll2(){
        dynamiteCount = 0;
        if(rollCount != 4) {
            
            finalDice.clear();
 
            group3.getChildren().remove(character);
            //Start of play order
            character.setText("Players: \n"
                    + current.name +"'s turn \n");

            for (int j = 0; j < play_order.size(); j++) {
                if(play_order.get(j).computer == false){
                    character.setText(character.getText()+ (j + 1) + ") You " 
                        + "\nHealth: "+play_order.get(j).health
                        +"\nArrows: "+play_order.get(j).arrows);
                } else {
                    character.setText(character.getText()+ (j + 1) + ") "
                        + play_order.get(j).name
                        + "\nHealth: "+play_order.get(j).health
                        + "\nArrows: "+play_order.get(j).arrows);
                }
                if(play_order.get(j).chiefArrow == true)
                {
                character.setText(character.getText()
                        +"\nHas Chief Arrow"
                        +"\n\n");
                }
                else {
                    character.setText(character.getText()+".\n\n");
                }
            }
            group3.getChildren().add(character);

            resetDieFace();

            for (int roll = 0; roll < 5; roll++) {
                if(checkBoxes.get(roll).isSelected())
                    dice.get(roll).roll();
            }
            for (int roll = 0; roll < 5; roll++) {
                finalDice.add(dice.get(roll).keep());
            }
            System.out.println("Roll " + (rollCount + 1) + " results:");
            System.out.println("Dice 1 : " + RD1.sides[RD1.side]);
            System.out.println("Dice 2 : " + RD2.sides[RD2.side]);
            System.out.println("Dice 3 : " + RD3.sides[RD3.side]);
            System.out.println("Dice 4 : " + RD4.sides[RD4.side]);
            System.out.println("Dice 5 : " + RD5.sides[RD5.side]);

            for(int i=0; i<5; i++) {
                checkBoxes.get(i).setSelected(false);
                checkBoxes.get(i).setDisable(false);
            } 
            current = play_order.get(0);
            coward.setDisable(current.computer);
            loudmouth.setDisable(current.computer);
            coward.setSelected(false);
            loudmouth.setSelected(false);
            for (int i = 0; i < 5; i++) {                                     //For the size of all the check boxes for the dice selection
                checkBoxes.get(i).setFont(Font.font("Copperplate", 10));
                checkBoxes.get(i).setSelected(false);                             //Set all to not selected
                checkBoxes.get(i).setLayoutX((i * 85) + 300);                    //Layout X
                checkBoxes.get(i).setLayoutY(275);                                //Layout Y
                checkBoxes.get(i).setDisable(current.computer);         //Only enabled if current player is not a computer

            } 
            for(int i=0; i<5; i++) {
                if(dice.get(i).sides[dice.get(i).side] == "Indian Arrow") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d1.setLayoutX(300);
                            d1.setVisible(true);
                            die1.setSelected(true);
                            die1.setDisable(true);
                            arrCount++;

                        }
                        if(dice.get(i).equals(RD2)){
                            d12.setLayoutX(385);
                            d12.setVisible(true);
                            die2.setSelected(true);
                            die2.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD3)){
                            d13.setLayoutX(470);
                            d13.setVisible(true);
                            die3.setSelected(true);
                            die3.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD4)){
                            d14.setLayoutX(555);
                            d14.setVisible(true);
                            die4.setSelected(true);
                            die4.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            d15.setLayoutX(640);
                            d15.setVisible(true);
                            die5.setSelected(true);
                            die5.setDisable(true);
                            arrCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Bullet"){
                        if(dice.get(i).equals(RD2)){
                            dl1.setLayoutX(385);
                            dl1.setVisible(true);
                            die2.setSelected(true);
                            die2.setDisable(true);
                            arrCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Broken Arrow"){
                        if(dice.get(i).equals(RD2)){
                            dc1.setLayoutX(385);
                            dc1.setVisible(true);
                            die2.setSelected(true);
                            die2.setDisable(true);
                            arrCount++;
                        }
                    }
                    else if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du1.setLayoutX(555);
                            du1.setVisible(true);
                            die4.setSelected(true);
                            die4.setDisable(true);
                            arrCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            du12.setLayoutX(640);
                            du12.setVisible(true);
                            die5.setSelected(true);
                            die5.setDisable(true);
                            arrCount++;
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Broken Arrow") {
                    if(dice.get(i).dice == 1) {
                        dc2.setLayoutX(385);
                        dc2.setVisible(true);
                        die2.setSelected(true);
                        die2.setDisable(true);
                        barrowAction();
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Bullet") {
                    if(dice.get(i).dice == 1) {
                        dl2.setLayoutX(385);
                        dl2.setVisible(true);
                        die2.setSelected(true);
                        die2.setDisable(true);
                        bulletAction();
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Dynamite") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d2.setLayoutX(300);
                            d2.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD2)){
                            d22.setLayoutX(385);
                            d22.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD3)){
                            d23.setLayoutX(470);
                            d23.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD4)){
                            d24.setLayoutX(555);
                            d24.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            d25.setLayoutX(640);
                            d25.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Bullet"){
                        if(dice.get(i).equals(RD2)){
                            dl3.setLayoutX(385);
                            dl3.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    else if(dice.get(i).dice == 1 && dice.get(i).sides[1] == "Broken Arrow"){
                        if(dice.get(i).equals(RD2)){
                            dc3.setLayoutX(385);
                            dc3.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    else if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du2.setLayoutX(555);
                            du2.setVisible(true);
                            dynamiteCount++;
                        }
                        if(dice.get(i).equals(RD5)){
                            du22.setLayoutX(640);
                            du22.setVisible(true);
                            dynamiteCount++;
                        }
                    }
                    dynamiteAction(i, dynamiteCount);
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Whiskey") {
                    if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du3.setLayoutX(555);
                            du3.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            du32.setLayoutX(640);
                            du32.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Bull's Eye 1") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d3.setLayoutX(300);
                            d3.setVisible(true);
                        }
                        if(dice.get(i).equals(RD2)){
                            d32.setLayoutX(385);
                            d32.setVisible(true);
                        }
                        if(dice.get(i).equals(RD3)){
                            d33.setLayoutX(470);
                            d33.setVisible(true);
                        }
                        if(dice.get(i).equals(RD4)){
                            d34.setLayoutX(555);
                            d34.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            d35.setLayoutX(640);
                            d35.setVisible(true);
                        }
                    }
                    else {
                        if(dice.get(i).equals(RD2)){
                            dc4.setLayoutX(385);
                            dc4.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Bull's Eye 2") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d4.setLayoutX(300);
                            d4.setVisible(true);
                        }
                        if(dice.get(i).equals(RD2)){
                            d42.setLayoutX(385);
                            d42.setVisible(true);
                        }
                        if(dice.get(i).equals(RD3)){
                            d43.setLayoutX(470);
                            d43.setVisible(true);
                        }
                        if(dice.get(i).equals(RD4)){
                            d44.setLayoutX(555);
                            d44.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            d45.setLayoutX(640);
                            d45.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Bull's Eye 1") {
                    if(dice.get(i).dice == 1) {
                        dl4.setLayoutX(385);
                        dl4.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Bull's Eye 2") {
                    if(dice.get(i).dice == 1) {
                        dl5.setLayoutX(385);
                        dl5.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Beer") {
                    if(dice.get(i).dice == 0){
                        if(dice.get(i).equals(RD1)){
                            d5.setLayoutX(300);
                            d5.setVisible(true);
                        }
                        if(dice.get(i).equals(RD2)){
                            d52.setLayoutX(385);
                            d52.setVisible(true);
                        }
                        if(dice.get(i).equals(RD3)){
                            d53.setLayoutX(470);
                            d53.setVisible(true);
                        }
                        if(dice.get(i).equals(RD4)){
                            d54.setLayoutX(555);
                            d54.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            d55.setLayoutX(640);
                            d55.setVisible(true);
                        }
                    }
                    else {
                        if(dice.get(i).equals(RD2)){
                            dc5.setLayoutX(385);
                            dc5.setVisible(true);
                        }
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Beer") {
                    if(dice.get(i).dice == 1) {
                        dc6.setLayoutX(385);
                        dc6.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Gatling") {
                        if(dice.get(i).dice == 0){
                            if(dice.get(i).equals(RD1)){
                                d6.setLayoutX(300);
                                d6.setVisible(true);
                            }
                            if(dice.get(i).equals(RD2)){
                                d62.setLayoutX(385);
                                d62.setVisible(true);
                            }
                            if(dice.get(i).equals(RD3)){
                                d63.setLayoutX(470);
                                d63.setVisible(true);
                            }
                            if(dice.get(i).equals(RD4)){
                                d64.setLayoutX(555);
                                d64.setVisible(true);
                            }
                            if(dice.get(i).equals(RD5)){
                                d65.setLayoutX(640);
                                d65.setVisible(true);
                            }
                        }
                        else if(dice.get(i).dice == 2){
                            if(dice.get(i).equals(RD4)){
                                du4.setLayoutX(555);
                                du4.setVisible(true);
                            }
                            if(dice.get(i).equals(RD5)){
                                du42.setLayoutX(640);
                                du42.setVisible(true);
                            }
                        }
                    }
                else if(dice.get(i).sides[dice.get(i).side] == "Double Gatling") {
                    if(dice.get(i).dice == 1) {
                        dl6.setLayoutX(385);
                        dl6.setVisible(true);
                    }
                }
                else if(dice.get(i).sides[dice.get(i).side] == "Duel"){
                    if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du5.setLayoutX(555);
                            du5.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            du52.setLayoutX(640);
                            du52.setVisible(true);
                        }
                    }
                    if(dice.get(i).dice == 2){
                        if(dice.get(i).equals(RD4)){
                            du6.setLayoutX(555);
                            du6.setVisible(true);
                        }
                        if(dice.get(i).equals(RD5)){
                            du62.setLayoutX(640);
                            du62.setVisible(true);
                        }
                    }
                }
            }rollCount++;
        }
        for(int i=0; i<finalDice.size(); i++){
            System.out.println(finalDice.get(i));
            String str = finalDice.get(i);
            if(dice.get(i).sides[dice.get(i).side] == "Beer" ||
                    dice.get(i).sides[dice.get(i).side] == "Whiskey" ||
                    dice.get(i).sides[dice.get(i).side] == "Double Beer")
                getDrunk(i);
            if(dice.get(i).sides[dice.get(i).side] == "Dynamite")
                dynamiteAction(i, dynamiteCount);
            }
        if(arrCount != 0){
            arrowAction(arrCount);
            }
        play_order.add(play_order.get(0));
        play_order.remove(0);
        dynamiteCount = 0;
        rollDice.setOnAction(e-> {
            rollS.seek(Duration.ZERO);
            rollS.play();
            arrCount = 0;
            rollDiceGo();
        });
    
    }
    
    public void dynamiteAction(int i, int count){
        dynExp.setText(current.name+"'s turn ended due to dynamite explosion.");
        if(current.name == "Black Jack"||current.name == "Belle Star") {
                if(current.computer == false){
                    checkBoxes.get(i).setSelected(true);
                    checkBoxes.get(i).setDisable(false);
                }
                else {
                    checkBoxes.get(i).setSelected(false);
                    checkBoxes.get(i).setDisable(true);
                }
        }
        else {
            checkBoxes.get(i).setDisable(true);
            checkBoxes.get(i).setSelected(false);
        }
        if(count > 2){
            dynExp.setVisible(true);
            rollDice.setDisable(true);
            mite.seek(Duration.ZERO);
            mite.play();
            mite.setOnEndOfMedia(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }            
                current.damage(1);
                rollCount = 0;
                play_order.add(play_order.get(0));
                play_order.remove(0);
                dynamiteCount = 0;
                dynExp.setVisible(false);
                rollDice.setDisable(false);
                rollDiceGo();
                mite.stop();
                
            });
        }
    }
    
    public void arrowAction(int arr) {
        if(chiefArrow){
            if(current.computer){ 
                chiefY.setVisible(true);
                chiefN.setVisible(true);
                chiefChoice.setVisible(true);
                rollDice.setDisable(true);
                chiefY.fire();
            }else {
            chiefY.setVisible(true);
            chiefN.setVisible(true);
            chiefChoice.setVisible(true);
            rollDice.setDisable(true);
            }
        }
        current.arrows += arr;
        arrowCount -= arr;
        if(arrowCount <= 0){
            indAtt.setVisible(true);
            rollDice.setDisable(true);
            attack.seek(Duration.ZERO);
            attack.play();
            attack.setOnEndOfMedia(()-> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                rollDice.setDisable(false);
                indAtt.setVisible(false);
                attack.stop();
            });
            indianAttack();
        }
    }
    
    public void barrowAction(){
        if(current.arrows == 0) {
            Random rand = new Random();
            int pick = (rand.nextInt(100000000)%cSel);
            if(play_order.get(pick).arrows > 0) {
                System.out.println(play_order.get(pick).name+" returned an arrow.");
                play_order.get(pick).arrows -= 1;
                arrowCount += 1;
            }
            else
                barrowAction();
        }else 
            current.arrows -= 1;
            System.out.println(current.name+" returned an arrow.");
            arrowCount += 1;
    }
    
    public void bulletAction(){
        eye.seek(Duration.ZERO);
        eye.play();
        current.damage(1);
    }
    
    public void getDrunk(int i){
        clink.seek(Duration.ZERO);
        clink.play();
        if(dice.get(i).sides[dice.get(i).side] == "Beer"){
            if(current.JJ && current.health < 5){
                current.heal(2);
                System.out.println(current.name+" healed.");
            }
            else if(current.health < current.maxHealth){
                current.selfBeer();
                System.out.println(current.name+" healed.");
            }
            else{
                Random rand = new Random();
                int pick = (rand.nextInt(100000000)%cSel);
                if(play_order.get(pick).arrows > 0) {
                    System.out.println(current.name+" healed "
                            +play_order.get(pick).name+".");
                    play_order.get(pick).heal(1);
                }
            }
            
        }
        if(dice.get(i).sides[dice.get(i).side] == "Whiskey"){
            if(current.name == "Greg Digger")
                current.heal(2);
            else
                current.heal(1);
            
        }
        if(dice.get(i).sides[dice.get(i).side] == "Double Beer"){
            if(current.JJ && current.health < 5){
                current.heal(4);
                System.out.println(current.name+" healed.");
            }
            else if(current.health < current.maxHealth-1)
                current.heal(2);
            else if(current.health < current.maxHealth){
                current.heal(1);
                Random rand = new Random();
                int pick = (rand.nextInt(100000000)%cSel);
                if(play_order.get(pick).arrows > 0) {
                    System.out.println(current.name+" healed "
                            +play_order.get(pick).name+".");
                    play_order.get(pick).heal(1);
                }
            }
            else{
                Random rand = new Random();
                int pick = (rand.nextInt(100000000)%cSel);
                if(play_order.get(pick).arrows > 0) {
                    System.out.println(current.name+" healed "
                            +play_order.get(pick).name+".");
                    play_order.get(pick).heal(1);
                }
                pick = (rand.nextInt(100000000)%cSel);
                if(play_order.get(pick).arrows > 0) {
                    System.out.println(current.name+" healed "
                            +play_order.get(pick).name+".");
                    play_order.get(pick).heal(1);
                }
            }
            
        }
        
    }
    
    public void gatAttack(){
        ling.seek(Duration.ZERO);
        ling.play();
    }
    
    public void dueling(){
        
    }
    
    public static void indianAttack() {
        int most = 0;
        int index = 0;
        boolean safe = false;
        for (int i = 0; i < play_order.size(); i++) {
            if (play_order.get(i).arrows > most) {
                most = play_order.get(i).arrows;
                index = i;
            }
            else if (play_order.get(i).arrows == most) {
                safe = true;
                index = 10;
            }
        }
        for (int j = 0; j < play_order.size(); j++) {
            if (play_order.get(j).chiefArrow == false || j != index) {
                if (play_order.get(j).name.equals("Jourdonnais") && play_order.get(j).arrows > 0) {
                    play_order.get(j).arrows = 1;
                }
                play_order.get(j).damage(play_order.get(j).arrows);
                if (!safe) {
                    play_order.get(j).damage(1);
                } else {
                    play_order.get(j).damage(0);
                }
                play_order.get(j).arrowReset();
                play_order.get(j).chiefArrow = false;
                if (play_order.get(j).health <= 0) {
                    //action.setText(play_order.get(j).name+ " has died.");
                }
            } else {
                play_order.get(j).arrowReset();
                play_order.get(j).chiefArrow = false;
            }
        }
        if(chief){
            arrowCount = 10;
            chiefArrow = true;
        } else {
            arrowCount = 9;
            chiefArrow = false;
        }
    }
    //end of file
}
