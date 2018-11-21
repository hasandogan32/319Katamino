package ObjectSubsystem;

import javax.swing.*;
import java.awt.*;

public class Table extends GameObject {

    private PieceContainer size[][];
    private int spaces[][];
    private int NumRows;
    private int NumColumns;

    //Constructors
    public Table(int numRows, int numColumns) {
        super();
        this.setPositionX(0);
        this.setPositionY(0);
        Image Image = new ImageIcon(this.getClass().getResource("Table.png")).getImage();
        setImage(Image);
        this.size = null;
        this.spaces = null;
        NumRows = numRows;
        NumColumns = numColumns;
        initTable(NumRows, NumColumns);
    }

    public Table(int positionX, int positionY, Image image, PieceContainer[][] size, int[][] spaces, int numRows, int numColumns) {
        super(positionX, positionY, image);
        this.size = size;
        this.spaces = spaces;
        NumRows = numRows;
        NumColumns = numColumns;
        initTable(NumRows, NumColumns);
    }

    //initiliaze table
    public void initTable(int numrows, int numcolumns){
        PieceContainer[][] container = new PieceContainer[numrows][numcolumns];

        //Container coordinate initiliazer
        int coordinateY = 104;
        for(int i = 0; i < numrows; i++){
            int coordinateX = 76;
            for(int j = 0; j < numcolumns; j++){
                // increase x axis for every j
                container[i][j] = new PieceContainer(coordinateX, coordinateY);
                coordinateX += 62;
            }
            //increase y axis once
            coordinateY += 62;
        }
        this.size = container;

    }


    //render and update
    @Override
    public void render(Graphics2D g) {
        g.drawImage(this.getImage(), 0, 0,null);


        // try


        //g.drawString("Score: " + this.size[0][0].getContainerPositionX(), 20 , 50);

        g.setColor(Color.RED);
        for(int i = 0; i < NumRows; i++){
            for(int j = 0; j < NumColumns; j++) {
                g.fillRect(this.size[i][j].getContainerPositionX(), this.size[i][j].getContainerPositionY(),
                           62, 62);
            }
        }
        /*g.setColor(Color.BLUE);
        g.fillRect(this.size[0][0].getContainerPositionX(), this.size[0][0].getContainerPositionY(),
                62, 62);
        g.setColor(Color.GREEN);
        g.fillRect(this.size[0][1].getContainerPositionX(), this.size[0][1].getContainerPositionY(),
                62, 62);
        g.setColor(Color.BLACK);
        g.fillRect(this.size[0][6].getContainerPositionX(), this.size[0][6].getContainerPositionY(),
                62, 62);*/




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
