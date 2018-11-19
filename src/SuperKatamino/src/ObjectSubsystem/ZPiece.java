package ObjectSubsystem;

import javax.swing.*;
import java.awt.*;

public class ZPiece extends Piece {

    public ZPiece() {
        super();
        Image Image = new ImageIcon(this.getClass().getResource("ZPiece.png")).getImage();
        setImage(Image);
    }

    public ZPiece(int positionX, int positionY, Image image, int[][] composition, int centralX, int centralY) {
        super(positionX, positionY, image, composition, centralX, centralY);
        Image Image = new ImageIcon(this.getClass().getResource("ZPiece.png")).getImage();
        setImage(Image);
    }

    @Override
    public void render(Graphics2D g) {
        GameObject pieceZ = new ZPiece();
        g.drawImage(pieceZ.getImage(), pieceZ.getPositionX(), pieceZ.getPositionY(), null);
    }
}
