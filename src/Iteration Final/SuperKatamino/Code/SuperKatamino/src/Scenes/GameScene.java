package Scenes;

import Application.Main;
import Pentaminoes.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import Application.GameLevel;
import javafx.scene.transform.Scale;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;

public class GameScene extends Scene {

    public static final double gl = 62; // Width an height of each square

    static final double gameBoardOffsetX = gl;
    static final double gameBoardOffsetY = gl;

    static double mousePrevX, mousePrevY;

    GameLevel level; // The game level that is represented in this scene
    boolean[][] gameBoard; // State of the game board

    public GameScene(GameLevel level){

        super(new Pane(), 930, 750);
        Pane gameLayout = new Pane();
        setRoot(gameLayout);

        try{

            FileInputStream input = new FileInputStream("C:\\Users\\Sinem\\Desktop\\pr2\\SuperKatamino\\Code\\SuperKatamino\\src\\Scenes\\Table.png");
            Image image = new Image(input);
            final ImageView selectedImage = new ImageView();
            selectedImage.setImage(image);
            selectedImage.setX(-12);
            selectedImage.setY(-40);
            gameLayout.getChildren().addAll(selectedImage);

            FileInputStream input3 = new FileInputStream("C:\\Users\\Sinem\\Desktop\\pr2\\SuperKatamino\\Code\\SuperKatamino\\src\\Scenes\\block.png");
            Image image3 = new Image(input3);
            final ImageView selectedImage2 = new ImageView();
            selectedImage2.setImage(image3);
            selectedImage2.setX(gl*(level.width+1));
            selectedImage2.setY(35);
            gameLayout.getChildren().addAll(selectedImage2);



            FileInputStream input2 = new FileInputStream("C:\\Users\\Sinem\\Desktop\\pr2\\SuperKatamino\\Code\\SuperKatamino\\src\\Scenes\\back3.png");
            Image image2 = new Image(input2);

            BackgroundImage myBI= new BackgroundImage(image2,
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            //then you set to your node
            gameLayout.setBackground(new Background(myBI));
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }


        // Draw game board, change
        for (int i = 0; i < 6; i++){
            Line l = new Line(gameBoardOffsetX, gameBoardOffsetY + gl * i, gameBoardOffsetX + level.width * gl, gameBoardOffsetY + gl * i);
            if (i != 0 && i != 5)
                l.setStroke(Color.rgb(127, 127, 127));
            gameLayout.getChildren().add(l);
        }
        for (int i = 0; i < level.width + 1; i++){
            Line l = new Line(gameBoardOffsetX+ gl * i, gameBoardOffsetY, gameBoardOffsetX + gl * i, gameBoardOffsetY + gl * 5);
            if (i != 0 && i != level.width)
                l.setStroke(Color.rgb(127, 127, 127));
            gameLayout.getChildren().add(l);
        }


        // Draw pieces, change
        for (int i = 1; i < 13; i++){
            Pentamino shape1 = PentaminoGenerator(level.pieces[i-1]);
            shape1.setLayoutX(gl*(i%4)+60*i-80);
            shape1.setLayoutY(400 + (i%4)*gl);
            Scale scale = new Scale();

            //Setting the dimensions for the transformation
            scale.setX(0.5);
            scale.setY(0.5);

            //Setting the pivot point for the transformation
            scale.setPivotX(0);
            scale.setPivotY(0);

            //Adding the scale transformation to circle1
            shape1.getTransforms().addAll(scale);
            gameLayout.getChildren().add(shape1);
        }

        // Initialize members
        this.level = level;
        gameBoard = new boolean[5][level.width];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < level.width; j++) {
                gameBoard[i][j] = false;
            }
        }

        // Back button
        Button back = new Button("Back");
        gameLayout.getChildren().add(back);
        back.setLayoutX(50);
        back.setLayoutY(700);
        back.setOnAction(e -> {
            Main.mainStage.setScene(new LevelPickerScene());
        });
    }

    // TODO: Add remaining pieces
    private Pentamino PentaminoGenerator(int type){
        Pentamino p = null;
        if (type == 1) p = new FPiece();
        else if (type == 2) p = new IPiece();
        else if (type == 3) p = new LPiece();
        else if (type == 4) p = new PPiece();
        else if (type == 5) p = new SPiece();
        else if (type == 6) p = new TPiece();
        else if (type == 7) p = new UPiece();
        else if (type == 8) p = new VPiece();
        else if (type == 9) p = new WPiece();
        else if (type == 10) p = new XPiece();
        else if (type == 11) p = new YPiece();
        else if (type == 12) p = new ZPiece();
        else System.out.println("Undefined pentamino type");

        p.setOnMousePressed(OnMousePressedEventHandler);
        p.setOnMouseDragged(OnMouseDraggedEventHandler);
        p.setOnMouseReleased(OnMouseReleasedEventHandler);
        p.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if(e.getButton().equals(MouseButton.PRIMARY)){
                    if(e.getClickCount() == 2){
                        Pentamino p = ((Pentamino)(e.getSource()));

                        Scale scale = new Scale();

                        //Setting the dimensions for the transformation
                        scale.setX(2);
                        scale.setY(2);

                        //Setting the pivot point for the transformation
                        scale.setPivotX(0);
                        scale.setPivotY(0);

                        //Adding the scale transformation to circle1
                        p.getTransforms().addAll(scale);
                    }

                }
            }
        });
        return p;
    }

    public EventHandler<MouseEvent> OnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // Define a pointer to pentamino object
                    Pentamino p = ((Pentamino)(t.getSource()));

                    // If the piece is placed, remove
                    if (p.placed){
                        int offsetX = (int)((p.getLayoutX() - gameBoardOffsetX) / gl);
                        int offsetY = (int)((p.getLayoutY() - gameBoardOffsetY) / gl);
                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (p.structure[i][j]){
                                    gameBoard[i+offsetY][j+offsetX] = false;
                                }
                            }
                        }
                        p.displace();
                    }

                    // If left button pressed, rotate
                    if (t.getButton() == MouseButton.SECONDARY) {
                        p.Rotate();
                        return;
                    }

                    // Save the mouse position when the dragging starts
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();

                    // Bring piece to front
                    p.toFront();
                }
            };

    public EventHandler<MouseEvent> OnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to pentamino object
                    Pentamino p = ((Pentamino)(t.getSource()));

                    // Move the piece
                    if (p.getLayoutX() + t.getSceneX() - mousePrevX >= 0)
                        p.setLayoutX(p.getLayoutX() + t.getSceneX() - mousePrevX);
                    p.setLayoutY(Math.max(p.getLayoutY() + t.getSceneY() - mousePrevY, 0));

                    // Update the mouse position after a drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    public EventHandler<MouseEvent> OnMouseReleasedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    // If right button clicked
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to pentamino object
                    Pentamino p = ((Pentamino)(t.getSource()));

                    // If piece is dropped outside the box
                    if(p.getLayoutX() < gameBoardOffsetX - gl*2.5 || gameBoardOffsetX + gl*(level.width - .5) <= p.getLayoutX() ||
                            p.getLayoutY() < gameBoardOffsetY - gl*2.5 || gameBoardOffsetY + gl*4.5 <= p.getLayoutY())
                        return;

                    // Calculate offsets
                    int offsetX = (int)((NearestGL(p.getLayoutX()) - gameBoardOffsetX) / gl);
                    int offsetY = (int)((NearestGL(p.getLayoutY()) - gameBoardOffsetY) / gl);

                    // Check if the piece can be placed
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < 5; j++) {
                            if ((i+offsetY >= 5 || i+offsetY < 0 || j+offsetX >= level.width || j+offsetX < 0 || gameBoard[i+offsetY][j+offsetX]) && p.structure[i][j]){
                                return; // If cannot, return
                            }
                        }
                    }

                    // Place the piece into the gameboard
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < 5; j++) {
                            if (p.structure[i][j]){
                                gameBoard[i+offsetY][j+offsetX] = true;
                            }
                        }
                    }

                    /* Monitor game board
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < level.width; j++) {
                            System.out.print(gameBoard[i][j] + " ");
                        }
                        System.out.println();
                    }*/

                    // Snap the piece to grid
                    p.setLayoutX(NearestGL(p.getLayoutX()));
                    p.setLayoutY(NearestGL(p.getLayoutY()));
                    p.place();

                    // Check if game has ended
                    for (int i = 0; i < gameBoard.length; i++) {
                        for (int j = 0; j < gameBoard[0].length; j++) {
                            if (!gameBoard[i][j]){
                                return;
                            }
                        }
                    }

                    // TODO: Add game ended action here
                    GameLevel l = new GameLevel(level.width +1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); // Change
                    System.out.println("Game ended");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Level " + (level.width-2) +" Ended!");
                    ButtonType buttonNext = new ButtonType("Next Level");
                    alert.getButtonTypes().add(buttonNext);
                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == buttonNext) {
                        if(level.width +1<=10) {
                            Main.mainStage.setScene(new GameScene(l));
                        }
                        else {
                            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                            alert2.setContentText("Game Ended!");
                        }
                    }
                }
            };

    // Helper func that gives the nearest multiple of 'GL' to a given number
    private long NearestGL(double x){
        return Math.round(x / gl) * (long)gl;
    }
}
