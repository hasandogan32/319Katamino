package ObjectSubsystem;

import java.awt.*;

public class Piece extends GameObject {

    int Composition[][];
    int centralX;
    int centralY;

    //Constructor
    public Piece() {
        super();
        this.Composition = null;
        this.centralX = 2;
        this.centralY = 2;
    }

    public Piece(int positionX, int positionY, Image image, int[][] composition, int centralX, int centralY) {
        super(positionX, positionY, image);
        Composition = composition;
        this.centralX = centralX;
        this.centralY = centralY;
    }

    //Getters
    public int[][] getComposition() {
        return Composition;
    }

    public int getCentralX() {
        return centralX;
    }

    public int getCentralY() {
        return centralY;
    }

    //Setters
    public void setComposition(int[][] composition) {
        Composition = composition;
    }

    public void setCentralX(int centralX) {
        this.centralX = centralX;
    }

    public void setCentralY(int centralY) {
        this.centralY = centralY;
    }
}
