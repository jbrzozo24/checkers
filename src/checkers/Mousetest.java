package checkers;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Mousetest extends JFrame {

    public static void main(String[] args) {
        new Mousetest();
    }

    // keeps track of mouse events
    public MouseEvents me= new MouseEvents();

    Box b= new Box(BoxLayout.X_AXIS);
    square b00= new square(0, 0);

    // constructor
    public Mousetest() {
        super("test");
        b.add(b00);

        b00.addMouseListener(me);

        pack();
        setVisible(true);
        setResizable(false);

    }

}
