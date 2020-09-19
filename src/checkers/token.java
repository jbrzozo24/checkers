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
    public Boolean isKing; //true if this piece has been King'ed
    public Boolean isJumped; //true if this piece has been jumped over

    // Constructor
    public token(Color color) {
        super();
        this.color= color;
        shadowcolor= color.darker();

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
