package ObjectSubsystem;

import javax.swing.*;
import java.awt.*;

public class PPiece extends Piece {

    public PPiece() {
        super();
        Image Image = new ImageIcon(this.getClass().getResource("PPiece.png")).getImage();
        setImage(Image);
    }

    public PPiece(int positionX, int positionY, Image image, int[][] composition, int centralX, int centralY) {
        super(positionX, positionY, image, composition, centralX, centralY);
        Image Image = new ImageIcon(this.getClass().getResource("PPiece.png")).getImage();
        setImage(Image);
    }

    @Override
    public void render(Graphics2D g) {
        GameObject pieceP = new PPiece();
        g.drawImage(pieceP.getImage(), 300, 300, null);
    }

}
