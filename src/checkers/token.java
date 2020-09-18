package checkers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class token extends JPanel {

    // fields:
    public static final int DIAMETER= 60;

    // the color of this piece:
    public Color color;
    public Color shadowcolor;

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
