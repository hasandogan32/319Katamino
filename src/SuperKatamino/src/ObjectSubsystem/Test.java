package ObjectSubsystem;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    private String gameName = "Super Katamino";
    private Canvas game = new Canvas();

    public void start(){
        //init window
        Dimension gameSize = new Dimension(1280, 720);
        JFrame gameWindow = new JFrame(gameName);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(gameSize);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        game.setSize(gameSize);
        game.setMaximumSize(gameSize);
        game.setMinimumSize(gameSize);
        game.setPreferredSize(gameSize);
        gameWindow.add(game);
        gameWindow.setLocationRelativeTo(null);


        GameObject table = new Table();
        GameObject pieceZ = new ZPiece();
        GameObject piecev = new VPiece();
        GameObject piecep = new PPiece();
        GameObject piecex = new XPiece();
        GameObject piecel = new IPiece();

        /*BufferStrategy b = game.getBufferStrategy();
        if(b == null){
            game.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D)b.getDrawGraphics();*/
        Graphics2D g = (Graphics2D)game.getGraphics();
        game.getGraphics().clearRect(0, 0, game.getWidth(), game.getHeight());
        g.drawImage(table.getImage(), 0, 0,null);
        g.drawImage(pieceZ.getImage(), pieceZ.getPositionX(), pieceZ.getPositionY(), null);
        g.drawImage(piecev.getImage(), 200, 200, null);
        g.drawImage(piecep.getImage(), 300, 300, null);
        g.drawImage(piecex.getImage(), 400, 400, null);
        g.drawImage(piecel.getImage(), 137, 165, null);
        g.dispose();
        //b.show();

        /*
        Image ZImage = new ImageIcon(this.getClass().getResource("XPiece.png")).getImage();
        game.getGraphics().setColor(Color.RED);
        game.getGraphics().drawRect(300,250,100,100);
        Image ZImage = new ImageIcon(this.getClass().getResource("XPiece.png")).getImage();
        game.getGraphics().drawImage(pieceZ.getImage(), 500, 500, null);
        */
    }


    public static void main(String[] args){
        //start!
        Test t = new Test();
        t.start();
    }



}
