/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
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
            whiskey, reg, undead, saloon;
    Image rdie, ldie, cdie, bdie, rdie2, rdie3, rdie4, rdie5, bdie2;
    ImageView background, bLogo, mHeader;
    ImageView black_img, gringo_img, jesse_img, jour_img,
            paul_img, pedro_img, suzy_img, vulture_img;
    ImageView jose_img, tequila_img, belle_img, greg_img;
    ImageView SR1, SR2, SR3, SR4, UR1, UR2, UR3, UR4,
            UR5, UR6, UR7, UR8, sHeader, uHeader;
    ImageView d1, d2, d3, d4, d5, d6, ds1, ds2, ds3, ds4, ds5,
            ds6, du1, du2, du3, du4, du5, du6, dg1, dg2, dg3;
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
    Group group1 = new Group();
    Group group2 = new Group();
    Group group3 = new Group();
    Group expGroup = new Group();
    Group charGroup = new Group();
    Group diceGroup = new Group();
    Group diceGroup2 = new Group();
    Group initGroup = new Group();
    
    Media bgM, bulls, glass, un, dieS;
    MediaPlayer bMusic, eye, clink, dead, rollS;
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
    RadioButton salInc = new RadioButton();
    RadioButton undInc = new RadioButton();
    RadioButton loudmouth = new RadioButton();
    RadioButton coward = new RadioButton();
    
    ToggleButton musicToggle = new ToggleButton();
    Boolean isSelected, cDSelect, lDSelect, sher;
    ComboBox players = new ComboBox();
    int cSel, pageNum=0;
    
    //initialization of game variables
    ArrayList<CharCards> char_cards = new ArrayList();
    ArrayList<Dice> dice = new ArrayList();
    ArrayList<Roles> role_cards = new ArrayList();
    static ArrayList<Player> play_order = new ArrayList();
    static ArrayList<Player> temp_play_order = new ArrayList();
    static ArrayList<Player> temp_play_order2 = new ArrayList();
    
    Dice bDie = new Dice(2, 0, "Indian Arrow", "Dynamite", "Duel", "Duel",
            "Whiskey", "Gatling");
    Dice cDie = new Dice(0, 0, "Indian Arrow", "Double Beer", "Bull's Eye 1",
            "Broken Arrow", "Beer", "Dynamite");
    Dice lDie = new Dice(0, 0, "Indian Arrow", "Dynamite", "Double Bull's Eye 1",
            "Double Bull's Eye 2", "Bullet", "Gatling");
    Dice regDie = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");
    
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
                bMusic.stop();
            } else {
                dead.setVolume(.8);
                clink.setVolume(.8);
                eye.setVolume(.8);
                rollS.setVolume(.8);
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
        
        barrow = new Image(
            new FileInputStream("src/bang/media/barrow.png"));
        ds1 = new ImageView(barrow);
        ds1.setFitWidth(75);
        ds1.setLayoutX(10);
        ds1.setLayoutY(10);
        ds1.setPreserveRatio(true);
        
        bullet = new Image(
            new FileInputStream("src/bang/media/bullet.png"));
        ds2 = new ImageView(bullet);
        ds2.setFitWidth(75);
        ds2.setLayoutX(90);
        ds2.setLayoutY(10);
        ds2.setPreserveRatio(true);
        
        dbe1 = new Image(
            new FileInputStream("src/bang/media/dbe1.png"));
        ds3 = new ImageView(dbe1);
        ds3.setFitWidth(75);
        ds3.setLayoutX(10);
        ds3.setLayoutY(90);
        ds3.setPreserveRatio(true);
        
        dbe2 = new Image(
            new FileInputStream("src/bang/media/dbe2.png"));
        ds4 = new ImageView(dbe2);
        ds4.setFitWidth(75);
        ds4.setLayoutX(90);
        ds4.setLayoutY(90);
        ds4.setPreserveRatio(true);
        
        dbeer = new Image(
            new FileInputStream("src/bang/media/dbeer.png"));
        ds5 = new ImageView(dbeer);
        ds5.setFitWidth(75);
        ds5.setLayoutX(10);
        ds5.setLayoutY(170);
        ds5.setPreserveRatio(true);
        
        dgatling = new Image(
            new FileInputStream("src/bang/media/dgatling.png"));
        ds6 = new ImageView(dgatling);
        ds6.setFitWidth(75);
        ds6.setLayoutX(90);
        ds6.setLayoutY(170);
        ds6.setPreserveRatio(true);
        
        whiskey = new Image(
            new FileInputStream("src/bang/media/whiskey.png"));
        du1 = new ImageView(whiskey);
        du1.setFitWidth(75);
        du1.setLayoutX(10);
        du1.setLayoutY(10);
        du1.setPreserveRatio(true);
        
        duel = new Image(
            new FileInputStream("src/bang/media/duel.png"));
        du2 = new ImageView(duel);
        du2.setFitWidth(75);
        du2.setLayoutX(90);
        du2.setLayoutY(10);
        du2.setPreserveRatio(true);
        
        reg = new Image(
            new FileInputStream("src/bang/media/reg.png"));
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
                .addAll(ds1, ds2, ds3, ds4, ds5, ds6, diceDesc, close2);
        
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
        
        diceDesc.setText("1. Whiskey Bottle\n2. Fight a Duel");
        diceDesc.setLayoutX(170);
        diceDesc.setLayoutY(10);
        diceGroup2.getChildren().clear();
        
        diceGroup2.getChildren()
                .addAll(du1, du2, diceDesc, close2);
        
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


        if(undInc.isSelected()){
            dice.add(bDie);
            dice.add(bDie);
        }else{
            dice.add(regDie);
            dice.add(regDie);
        }
        dice.add(regDie);
        dice.add(regDie);
        dice.add(regDie);
        
        //A switch to add specific cards based on how many players there are
        switch(cSel)
        {
            case 8:
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
        
    }  
    //trying to implement a button for dice rolling initiative
    public void diceSetup(){
        loudmouth.setLayoutX(300);
        loudmouth.setLayoutY(185);
        loudmouth.setFont(Font.font("Copperplate", 20));
        coward.setLayoutX(300);
        coward.setLayoutY(215);
        coward.setFont(Font.font("Copperplate", 20));
        group3.getChildren().clear();
        group3.getChildren()
                .addAll(background, musicToggle, rollDice);
        if((undInc.isSelected())){
            group3.getChildren()
                    .addAll(bDie_img, bDie2_img);
            if((salInc.isSelected())){
                group3.getChildren()
                        .addAll(lDie_img, cDie_img, rDie_img, rDie2_img,
                                rDie3_img, loudmouth, coward);
                }
            else if((!salInc.isSelected())){
                group3.getChildren()
                        .addAll(rDie_img, rDie2_img, rDie3_img);
                }
            }
        else if((!undInc.isSelected())){
            group3.getChildren()
                    .add(rDie_img);
            if((salInc.isSelected())){
                group3.getChildren()
                        .addAll(lDie_img, cDie_img, rDie3_img, rDie2_img,
                                rDie4_img, rDie5_img, loudmouth, coward);
                }
            else if((!salInc.isSelected())){
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
                loudmouth.setText("Loudmouth Die in use");
                coward.setText("Use Coward Die");
                coward.setSelected(false);
                cDie_img.setVisible(false);
                lDie_img.setVisible(true);
                rDie2_img.setVisible(false);
            } else {
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
                coward.setText("Coward Die in use");
                loudmouth.setText("Use Loudmouth Die");
                loudmouth.setSelected(false);
                lDie_img.setVisible(false);
                cDie_img.setVisible(true);
                rDie2_img.setVisible(false);
            } else {
                coward.setText("Use Coward Die");
                lDie_img.setVisible(false);
                cDie_img.setVisible(false);
                rDie2_img.setVisible(true);
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    
}
