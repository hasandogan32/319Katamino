package Scenes;

import Application.GameLevel;
import Application.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileInputStream;

public class LevelPickerScene extends Scene {

    public LevelPickerScene() {
        super(new Pane(), 930, 750);
        Pane mainLayout = new Pane();
        setRoot(mainLayout);
        try{

            FileInputStream input = new FileInputStream("C:\\Users\\Sinem\\Desktop\\pr2\\SuperKatamino\\Code\\SuperKatamino\\src\\Scenes\\back2.png");
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


        Button level1 = new Button("Level 1");
        mainLayout.getChildren().add(level1);
        level1.setLayoutX(450);
        level1.setLayoutY(100);
        level1.setOnAction(e -> {
            GameLevel l1 = new GameLevel(3, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
            Main.mainStage.setScene(new GameScene(l1));
        });
        Button level2 = new Button("Level 2");
        mainLayout.getChildren().add(level2);
        level2.setLayoutX(450);
        level2.setLayoutY(150);

        Button level3 = new Button("Level 3");
        mainLayout.getChildren().add(level3);
        level3.setLayoutX(450);
        level3.setLayoutY(200);

        Button level4 = new Button("Level 4");
        mainLayout.getChildren().add(level4);
        level4.setLayoutX(450);
        level4.setLayoutY(250);

        Button level5 = new Button("Level 5");
        mainLayout.getChildren().add(level5);
        level5.setLayoutX(450);
        level5.setLayoutY(300);

        Button level6 = new Button("Level 6");
        mainLayout.getChildren().add(level6);
        level6.setLayoutX(450);
        level6.setLayoutY(350);

        Button level7 = new Button("Level 7");
        mainLayout.getChildren().add(level7);
        level7.setLayoutX(450);
        level7.setLayoutY(400);

        Button level8 = new Button("Level 8");
        mainLayout.getChildren().add(level8);
        level8.setLayoutX(450);
        level8.setLayoutY(450);

        Button level9 = new Button("Level 9");
        mainLayout.getChildren().add(level9);
        level9.setLayoutX(450);
        level9.setLayoutY(500);

        Button level10 = new Button("Level 10");
        mainLayout.getChildren().add(level10);
        level10.setLayoutX(450);
        level10.setLayoutY(550);


        Button back = new Button("Back");
        mainLayout.getChildren().add(back);
        back.setLayoutX(50);
        back.setLayoutY(650);


            level2.setOnAction(e -> {
                GameLevel l2 = new GameLevel(4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));

            });
            level3.setOnAction(e -> {
                GameLevel l2 = new GameLevel(5, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));

            });
            level4.setOnAction(e -> {
                GameLevel l2 = new GameLevel(6, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));
            });
            level5.setOnAction(e -> {
                GameLevel l2 = new GameLevel(7, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));
            });
            level6.setOnAction(e -> {
                GameLevel l2 = new GameLevel(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));
            });
            level7.setOnAction(e -> {
                GameLevel l2 = new GameLevel(9, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));
            });
            level8.setOnAction(e -> {
                GameLevel l2 = new GameLevel(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));
            });
            level9.setOnAction(e -> {
                GameLevel l2 = new GameLevel(11, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));
            });

            level10.setOnAction(e -> {
                GameLevel l2 = new GameLevel(12, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                Main.mainStage.setScene(new GameScene(l2));
            });

        back.setOnAction(e -> {
            Main.mainStage.setScene(new MainScene());
        });
    }
}
