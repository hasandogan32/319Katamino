package ObjectSubsystem;

import java.awt.*;

public class PieceContainer {

    private int ContainerSize;
    private int ContainerPositionX;
    private int ContainerPositionY;
    private boolean isEmpty;

    public PieceContainer() {
        ContainerSize = 62;
        ContainerPositionX = 0;
        ContainerPositionY = 0;
        isEmpty = true;
    }

    //Constructor
    public PieceContainer(int containerPositionX, int containerPositionY) {
        ContainerSize = 62;
        ContainerPositionX = containerPositionX;
        ContainerPositionY = containerPositionY;
        isEmpty = true;
    }

    //Get Next Piece Container methods
    public int getNextContainerBeginX(Container c){
        return this.ContainerPositionX + 62;
    }

    public int getNextContainerBeginY(Container c){
        return this.ContainerPositionY + 62;
    }

    //Getters
    public boolean isEmpty() {
        return isEmpty;
    }

    public int getContainerSize() {
        return ContainerSize;
    }

    public int getContainerPositionX() {
        return ContainerPositionX;
    }

    public int getContainerPositionY() {
        return ContainerPositionY;
    }

    //Setters
    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void setContainerSize(int containerSize) {
        ContainerSize = containerSize;
    }

    public void setContainerPositionX(int containerPositionX) {
        ContainerPositionX = containerPositionX;
    }

    public void setContainerPositionY(int containerPositionY) {
        ContainerPositionY = containerPositionY;
    }
}
