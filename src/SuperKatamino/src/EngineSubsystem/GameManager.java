package EngineSubsystem;

import ObjectSubsystem.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class GameManager {

    public final static int WIDTH = 1280, HEIGHT = 720;

    private String gameName = "Super Katamino";

    private Canvas game = new Canvas();

    private InputListener input;

    private ArrayList<Updatable> updatables = new ArrayList<>();
    private ArrayList<Renderable> renderables = new ArrayList<>();

    public void addUpdatables(Updatable u){
        updatables.add(u);
    }

    public void removeUpdatables(Updatable u){
        updatables.remove(u);
    }

    public void addRenderable(Renderable r){
        renderables.add(r);
    }

    public void removeRenderable(Renderable r){
        renderables.remove(r);
    }

    public void start(){
        //init window
        Dimension gameSize = new Dimension(GameManager.WIDTH, GameManager.HEIGHT);
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

        //init input
        input = new InputListener();
        //game.addKeyListener(input);

        //Game loop
        final int TICKS_PER_SECOND = 60; // 60 frames per second
        final int TIME_PER_TICK = 1050 / TICKS_PER_SECOND;
        final int MAX_FRAMESKIPS = 5; // 5 update call per render

        long nextGameTick = System.currentTimeMillis();
        int loops; // counts amount of update

        long timeAtLastFPSCheck = 0;
        int ticks = 0;


        boolean running = true;
        while(running){
            //Updating
            loops = 0;
            while(System.currentTimeMillis() > nextGameTick && loops < MAX_FRAMESKIPS){
                update();
                ticks++;

                nextGameTick += TIME_PER_TICK;
                loops++;
            }

            //Rendering
            render();

            //FPS Check
            if(System.currentTimeMillis() - timeAtLastFPSCheck >= 1000){
                System.out.println("FPS: " + ticks);
                gameWindow.setTitle(gameName + " - FPS: " + ticks);
                ticks = 0;
                timeAtLastFPSCheck = System.currentTimeMillis();
            }

        }
        //Game end
    }

    private void update() {
        for(Updatable u : updatables){
            u.update(input);
        }
    }

    private void render(){
        BufferStrategy b = game.getBufferStrategy();
        if(b == null){
            game.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D)b.getDrawGraphics();
        g.clearRect(0, 0, game.getWidth(), game.getHeight());
        for(Renderable r : renderables){
            r.render(g);
        }
        g.dispose();
        b.show();
    }

    public static void main(String[] args){
        GameManager g = new GameManager();

        //Initialise game objects
        GameObject table = new Table();
        GameObject pieceZ = new ZPiece();
        GameObject piecev = new VPiece();
        GameObject piecep = new PPiece();
        GameObject piecex = new XPiece();
        GameObject piecel = new IPiece();

        g.addRenderable(table);
        g.addUpdatables(table);

        g.addUpdatables(pieceZ);
        g.addRenderable(pieceZ);

        g.addUpdatables(piecev);
        g.addRenderable(piecev);

        g.addUpdatables(piecep);
        g.addRenderable(piecep);

        g.addUpdatables(piecex);
        g.addRenderable(piecex);

        g.addUpdatables(piecel);
        g.addRenderable(piecel);

        /*BufferStrategy b = game.getBufferStrategy();
        if(b == null){
            game.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D)b.getDrawGraphics();
        Graphics2D g = (Graphics2D)game.getGraphics();
        game.getGraphics().clearRect(0, 0, game.getWidth(), game.getHeight());
        g.drawImage(table.getImage(), 0, 0,null);
        g.drawImage(pieceZ.getImage(), pieceZ.getPositionX(), pieceZ.getPositionY(), null);
        g.drawImage(piecev.getImage(), 200, 200, null);
        g.drawImage(piecep.getImage(), 300, 300, null);
        g.drawImage(piecex.getImage(), 400, 400, null);
        g.drawImage(piecel.getImage(), 137, 165, null);
        g.dispose();*/


        //Add updatables and renderables

        //start!
        g.start();
    }
}

