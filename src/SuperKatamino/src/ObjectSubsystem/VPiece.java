package ObjectSubsystem;

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
        GameObject pieceV = new VPiece();
        g.drawImage(pieceV.getImage(), 200, 200, null);
    }
}
