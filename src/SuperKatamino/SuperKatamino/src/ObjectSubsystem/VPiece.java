package ObjectSubsystem;

import EngineSubsystem.InputListener;

import javax.swing.*;
import java.awt.*;

public class VPiece extends Piece {

    public VPiece() {
        super();
        Image Image = new ImageIcon(this.getClass().getResource("Vpiece.png")).getImage();
        setImage(Image);
    }

    public VPiece(int positionX, int positionY, Image image, int[][] composition, int centralX, int centralY) {
        super(positionX, positionY, image, composition, centralX, centralY);
        Image Image = new ImageIcon(this.getClass().getResource("Vpiece.png")).getImage();
        setImage(Image);
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(this.getImage(), this.getPositionX(), this.getPositionY(), null);
    }

    @Override
    public void update(InputListener input) {
        //isBetween use
        if((isBetween(this.getPositionX(), input.getNewCoordinateX(),this.getPositionX() + 100))
                && isBetween(this.getPositionY(), input.getNewCoordinateY(),this.getPositionY() + 100)){
            int[] updated = input.getCoordinates();
            this.setPositionX(updated[2] - 50); // 155 must be the value with the new pictures middle point of piece
            this.setPositionY(updated[3] - 50); // 155 must be the value with the new pictures middle point of piece
        }
    }
}
