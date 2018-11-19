package ObjectSubsystem;

import javax.swing.*;
import java.awt.*;

public class IPiece extends Piece{

    public IPiece() {
        super();
        Image Image = new ImageIcon(this.getClass().getResource("IPiece.png")).getImage();
        setImage(Image);
    }

    public IPiece(int positionX, int positionY, Image image, int[][] composition, int centralX, int centralY) {
        super(positionX, positionY, image, composition, centralX, centralY);
        Image Image = new ImageIcon(this.getClass().getResource("IPiece.png")).getImage();
        setImage(Image);
    }

    @Override
    public void render(Graphics2D g) {
        GameObject pieceI = new IPiece();
        g.drawImage(pieceI.getImage(), 137, 165, null);// change location later
    }

}
