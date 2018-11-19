package ObjectSubsystem;

import javax.swing.*;
import java.awt.*;

public class Table extends GameObject {

    private PieceContainer size[][];
    private int spaces[][];
    private int NumRows;
    private int NumColumns;

    //Constructors
    public Table() {
        super();
        // change after board menu
        Image Image = new ImageIcon(this.getClass().getResource("Table.png")).getImage();
        setImage(Image);
        this.size = null;
        this.spaces = null;
        NumRows = 0;
        NumColumns = 0;
    }

    public Table(int positionX, int positionY, Image image, PieceContainer[][] size, int[][] spaces, int numRows, int numColumns) {
        super(positionX, positionY, image);
        this.size = size;
        this.spaces = spaces;
        NumRows = numRows;
        NumColumns = numColumns;
    }


    //render and update


    @Override
    public void render(Graphics2D g) {
        GameObject table = new Table();
        g.drawImage(table.getImage(), 0, 0,null);
    }

    //Setters
    public void setSize(PieceContainer[][] size) {
        this.size = size;
    }

    public void setSpaces(int[][] spaces) {
        this.spaces = spaces;
    }

    public void setNumRows(int numRows) {
        NumRows = numRows;
    }

    public void setNumColumns(int numColumns) {
        NumColumns = numColumns;
    }

    //Getters
    public PieceContainer[][] getSize() {
        return size;
    }

    public int[][] getSpaces() {
        return spaces;
    }

    public int getNumRows() {
        return NumRows;
    }

    public int getNumColumns() {
        return NumColumns;
    }
}
