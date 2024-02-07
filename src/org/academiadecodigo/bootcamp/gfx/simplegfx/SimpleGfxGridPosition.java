package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(10,10,20, 20);
        //throw new UnsupportedOperationException();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(col*10+10, row*10+10, 10, 10);
        rectangle.setColor(Color.RED);
        rectangle.fill();


        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        //throw new UnsupportedOperationException();

    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        //throw new UnsupportedOperationException();
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        //throw new UnsupportedOperationException();
        switch (direction){
            case UP:
                rectangle.translate(0, -distance);
                break;
            case DOWN:
                rectangle.translate(0, distance);
                break;
            case LEFT:
                rectangle.translate(-distance, 0);
                break;
            case RIGHT:
                rectangle.translate(distance, 0);
        }
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        // throw new UnsupportedOperationException();
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        simpleGfxGrid.border.setColor(SimpleGfxColorMapper.getColor(color));

    }
}
