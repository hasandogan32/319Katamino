package EngineSubsystem;

import java.awt.event.*;

public class InputListener implements KeyListener, MouseMotionListener, MouseListener {

    private int initialCoordinateX;
    private int initialCoordinateY;
    private int newCoordinateX;
    private int newCoordinateY;
    private boolean isPressed;

    public int[] getCoordinates(){
        int[] coordinates = new int[4];
        coordinates[0] = this.initialCoordinateX;
        coordinates[1] = this.initialCoordinateY;
        coordinates[2] = this.newCoordinateX;
        coordinates[3] = this.newCoordinateY;
        return coordinates;
    }

    public void mouseLocation(MouseEvent e){
        this.newCoordinateX = e.getX();
        this.newCoordinateY = e.getY();
    }

    //MOUSE EVENTS
    @Override
    public void mousePressed(MouseEvent e) {
        this.initialCoordinateX = e.getXOnScreen();
        this.initialCoordinateY = e.getYOnScreen();
        mouseLocation(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseLocation(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseLocation(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // KEYBOARD EVENTS
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //Getters
    public int getNewCoordinateX() {
        return newCoordinateX;
    }

    public int getNewCoordinateY() {
        return newCoordinateY;
    }

    public int getInitialCoordinateX() {
        return initialCoordinateX;
    }

    public int getInitialCoordinateY() {
        return initialCoordinateY;
    }

}
