package ObjectSubsystem;

import EngineSubsystem.InputListener;
import EngineSubsystem.Renderable;
import EngineSubsystem.Updatable;

import java.awt.*;

public class GameObject implements Updatable, Renderable {

    //////////////
    public void update(InputListener input){}
    public void render(Graphics2D g){

    }
    //////////////

    private int PositionX;
    private int PositionY;
    private Image image;

    //Constructors
    public GameObject() {
        this.PositionX = 75;
        this.PositionY = 103;
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
