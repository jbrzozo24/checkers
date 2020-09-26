package checkers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class square extends JPanel {
	
	private static final long serialVersionUID= 1L;

    // fields:

    public static final int HEIGHT= 70;
    public static final int WIDTH= 70;
    public static Color graysquare= Color.GRAY;
    public static Color darkgraysquare= Color.DARK_GRAY;
    
    public Color color; // the color of this square
    public boolean hasPiece; // true if this square has an object of class token on it.
    public int x; // the x-position of this square
    public int y; // the y-position of this square
    public token piece; // the checkers piece on this square, null if none
    public boolean selected; // true if the square is selected

    /** Constructor for class square, constructs a square with coordinates (x,y)<br>
     * and button with same coordinates. */
    public square(int x, int y) {
        super();
        this.x= x;
        this.y= y;
        this.selected= false;
        this.hasPiece= false;
        setPreferredSize(new Dimension(HEIGHT, WIDTH));
        if ((x + y) % 2 == 0) this.color= graysquare;
        else this.color= darkgraysquare;

    }
    /**
     * Constructor for class square, constructs a square with coordinates (x,y) <br>
     * and a button with same coordinates. Adds a game piece to the square
     */
    public square(int x, int y, token piece) {
        super();
        this.x= x;
        this.y= y;
        selected= false;
        setPreferredSize(new Dimension(HEIGHT, WIDTH));
        if ((x + y) % 2 == 0) color= graysquare;
        else this.color= darkgraysquare;
        if (this.color == darkgraysquare) {
            hasPiece= true;
            this.piece= piece;
            piece.location=this; //tell the piece its location
        }
    }

    /**
     * Called by MouseClicked if a square was clicked on
     */
    public void clicked(checkers game) {
    	square selectedSquare= game.squareSelected();
        if (game.isValidpiece(this)) {
            this.selected= !(this.selected);
        	if (this.selected) {
        		this.color= this.color.brighter();
        		this.piece.isSelected=true; 
        	} else {
        		this.color= this.color.darker();
        		this.piece.isSelected=false;
        	}
        } else if(selectedSquare!=null && this.hasPiece==false) {
        	selectedSquare.piece.movePiece(selectedSquare,this); //Move piece from the selected square to the square just clicked on
        	this.unselect();
        	selectedSquare.unselect();//unselect both squares since the move has completed
        	selectedSquare.repaint(); 
        }
        repaint();
    }
    
    //Helper to select this square
    public void select() {
    	if(!this.selected) {
    		this.selected=true;
    		this.color=this.color.brighter();
    	}
    }
    
    //Helper to unselect this square
    public void unselect() {
    	if(this.selected) {
    		this.selected=false;
    		this.color=this.color.darker();
    	}
    }
    
    //Helper to toggle the select on this square
    public void toggleselect() {
    	this.selected= !(this.selected);
    	if(this.selected) {this.color=this.color.brighter();}
    	else {this.color=this.color.darker();}
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, HEIGHT, WIDTH);

        if (hasPiece) {
            piece.paint(g);
        }

    }

    @Override 
    public String toString() {
        String s= "[";
        s= s + this.x + "," + this.y + "  ";
        s= s + "Selected: " + this.selected + ", "+ "hasPiece: " +this.hasPiece;
        s= s + "]";
        return s;
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