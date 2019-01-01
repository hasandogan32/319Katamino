package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import Application.Main;

import java.io.FileInputStream;

public class MainScene extends Scene {

    public MainScene() {
        super(new Pane(), 930, 750);
        Pane mainLayout = new Pane();
        setRoot(mainLayout);

        Button helpButton = new Button("HOW TO PLAY");
        Button creditsButton = new Button("CREDITS");
        Button levelPickerButton = new Button("PLAY GAME");
        Button optionsButton = new Button("SETTINGS");
        Button scoresButton = new Button("HIGH SCORES");

        levelPickerButton.setLayoutX(427);
        levelPickerButton.setLayoutY(350);
        helpButton.setLayoutX(420);
        helpButton.setLayoutY(400);
        optionsButton.setLayoutX(432);
        optionsButton.setLayoutY(450);
        scoresButton.setLayoutX(422);
        scoresButton.setLayoutY(500);
        creditsButton.setLayoutX(435);
        creditsButton.setLayoutY(550);

        mainLayout.getChildren().addAll(levelPickerButton, helpButton, optionsButton, scoresButton, creditsButton);
        try{

            FileInputStream input = new FileInputStream("C:\\Users\\Sinem\\Desktop\\pr2\\SuperKatamino\\Code\\SuperKatamino\\src\\Scenes\\back1.png");
            Image image = new Image(input);

            BackgroundImage myBI= new BackgroundImage(image,
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            //then you set to your node
            mainLayout.setBackground(new Background(myBI));
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
        levelPickerButton.setOnAction(e -> {
            Main.mainStage.setScene(new LevelPickerScene());
        });
        creditsButton.setOnAction(e -> {
            Main.mainStage.setScene(new CreditsScene());
        });
        helpButton.setOnAction(e -> {
            Main.mainStage.setScene(new HelpScene());
        });
    }
}
