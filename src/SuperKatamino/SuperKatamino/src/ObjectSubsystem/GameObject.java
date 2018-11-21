package ObjectSubsystem;

import EngineSubsystem.InputListener;
import EngineSubsystem.Renderable;
import EngineSubsystem.Updatable;

import java.awt.*;

public class GameObject implements Updatable, Renderable {

    //////////////
    public void update(InputListener input){}
    public void render(Graphics2D g){}
    //////////////

    private int PositionX;
    private int PositionY;
    private Image image;

    /*public boolean isBetween(int a, int b, int c) {
        return a >= b ? a <= c : false;
    }*/

    public boolean isBetween(int a, int b, int c) {
        if(a <= b){
            return c >= b;
        }
        return false;
    }

    //Constructors
    public GameObject() {
        this.PositionX = 76;
        this.PositionY = 104;
        this.image = null;
    }

    public GameObject(int positionX, int positionY, Image image) {
        PositionX = positionX;
        PositionY = positionY;
        this.image = image;
    }

    //Setters
    public void setPositionX(int positionX) {
        PositionX = positionX;
    }

    public void setPositionY(int positionY) {
        PositionY = positionY;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    //Getters
    public int getPositionX() {
        return PositionX;
    }

    public int getPositionY() {
        return PositionY;
    }

    public Image getImage() {
        return image;
    }
}
