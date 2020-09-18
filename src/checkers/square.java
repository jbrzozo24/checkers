package checkers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class square extends JPanel {

    // fields:

    public static final int HEIGHT= 70;
    public static final int WIDTH= 70;
    public static Color graysquare= Color.GRAY;
    public static Color darkgraysquare= Color.DARK_GRAY;
    // the color of this square
    public Color color;
    // true if this square has an object of class token on it.
    public boolean hasPiece= false;
    // the x-position of this square
    public int x;
    // the y-position of this square
    public int y;
    // the checkers piece on this square, null if none
    public token piece;
    // true if the square is selected
    public boolean selected;

    /** Constructor for class Square, constructs a square with coordinates (x,y)<br>
     * and button with same coordinates. */
    public square(int x, int y) {
        super();
        this.x= x;
        this.y= y;
        selected= false;
        setPreferredSize(new Dimension(HEIGHT, WIDTH));
        if ((x + y) % 2 == 0) color= graysquare;
        else color= darkgraysquare;

    }

    public square(int x, int y, token piece) {
        super();
        this.x= x;
        this.y= y;
        selected= false;
        setPreferredSize(new Dimension(HEIGHT, WIDTH));
        if ((x + y) % 2 == 0) color= graysquare;
        else color= darkgraysquare;
        if (color == darkgraysquare) {
            hasPiece= true;
            this.piece= piece;
        }
    }

    public void clicked() {
        if (checkers.isValidpiece(this)) {
            selected= !selected;
        }
        if (selected) {
            color= color.brighter();
        } else {
            color= color.darker();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, HEIGHT, WIDTH);

        if (hasPiece) {
            piece.paint(g);
        }

    }

// OOPS THIS WAS FOR WHEN I THOUGHT I NEEDED BUTTONS ON EACH SQUARE
    /** // adds an action listen to this squares button public void setupButton() {
     * button.addActionListener(this);
     *
     * }
     *
     * //calls various methods when this square is clicked <br>
     * public void actionPerformed(ActionEvente) {
     *
     * } */

}