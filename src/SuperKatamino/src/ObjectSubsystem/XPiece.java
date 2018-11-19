package ObjectSubsystem;

import javax.swing.*;
import java.awt.*;

public class XPiece extends Piece {

    public XPiece() {
        super();
        Image Image = new ImageIcon(this.getClass().getResource("XPiece.png")).getImage();
        setImage(Image);
    }

    public XPiece(int positionX, int positionY, Image image, int[][] composition, int centralX, int centralY) {
        super(positionX, positionY, image, composition, centralX, centralY);
        Image Image = new ImageIcon(this.getClass().getResource("XPiece.png")).getImage();
        setImage(Image);
    }

    @Override
    public void render(Graphics2D g) {
        GameObject pieceX = new XPiece();
        g.drawImage(pieceX.getImage(), 400, 400, null);
    }
}
