package ObjectSubsystem;

import java.awt.*;

public class PieceContainer {

    private int ContainerSize;
    private int ContainerPositionX;
    private int ContainerPositionY;

    //Constructor
    public PieceContainer(int containerPositionX, int containerPositionY) {
        ContainerSize = 62;
        ContainerPositionX = containerPositionX;
        ContainerPositionY = containerPositionY;
    }

    //Get Next Piece Container methods
    public int getNextContainerBeginX(Container c){
        return this.ContainerPositionX + 63;
    }

    public int getNextContainerBeginY(Container c){
        return this.ContainerPositionY + 63;
    }

    //Getters
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
