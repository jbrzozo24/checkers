package checkers;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


/** This class is used to create game tokens on the checker board */

public class token extends JPanel {
	
	private static final long serialVersionUID= 1L;

    // fields:
    public static final int DIAMETER= 60;

    public Color color; // the color of this piece
    public Color shadowcolor; //the color of the shadow of this piece
    public Boolean isKing=false; //true if this piece has been King'ed
    public Boolean isJumped; //true if this piece has been jumped over
    public Boolean isSelected=false; //true if this piece is selected by the user
    public square location; //The square that this token is on

    // Constructor
    public token(Color color){
        super();
        this.color= color;
        this.shadowcolor= color.darker();
        this.isKing=false;
        this.isJumped=false;
        this.isSelected=false;
        this.location=null; 
    }
    
    //gets the x and y position of this token
    public int[] getCoords() {
    	//TODO
    	return null;
    }
    
    //Moves this piece from one square to another
    public void movePiece(square from, square to) {
    	this.location= to; //update square location
    	from.piece=null;
    	from.hasPiece=false;
    	to.piece=this;
    	to.hasPiece=true;
    }
    

    @Override
    public void paint(Graphics g) {
        g.setColor(shadowcolor);
        g.fillOval(5, 5, DIAMETER, DIAMETER);
        g.setColor(color);
        g.fillOval(5, 5, DIAMETER - 3, DIAMETER - 3);
    }

    // adds a button does nothing rn
    // public void addButton() {
    // button= new JButton("i exist");
    // add(button);
    // }

}
