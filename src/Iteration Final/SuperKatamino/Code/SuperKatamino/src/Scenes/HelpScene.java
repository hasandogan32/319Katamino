package Scenes;

import Application.GameLevel;
import Application.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
public class HelpScene extends Scene{
    public HelpScene() {
        super(new Pane(), 930, 750);
        Pane cLayout = new Pane();
        setRoot(cLayout);

        try {

            FileInputStream input = new FileInputStream("C:\\Users\\Sinem\\Desktop\\pr2\\SuperKatamino\\Code\\SuperKatamino\\src\\Scenes\\back5.png");
            Image image = new Image(input);

            BackgroundImage myBI = new BackgroundImage(image,
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            //then you set to your node
            cLayout.setBackground(new Background(myBI));
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        Button back = new Button("Back");
        cLayout.getChildren().add(back);
        back.setLayoutX(60);
        back.setLayoutY(680);
        back.setOnAction(e -> {
            Main.mainStage.setScene(new MainScene());
        });
    }
}
