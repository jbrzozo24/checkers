package checkers;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class checkers extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID= 1L;

    public static void main(String[] args) {
        checkers game= new checkers();
    }

    // fields:
    public Box mainbox= new Box(BoxLayout.X_AXIS);
    public Box boardbox= new Box(BoxLayout.Y_AXIS);
    public Box infobox= new Box(BoxLayout.Y_AXIS);
    // double array of squares for the board
    public square[][] array= new square[8][8];
    // mouse events object, add this as a mouse listener to each square
    public MouseEvents me= new MouseEvents();
    public Color turn= Color.red.darker();

    // Constructor:
    public checkers() {
        super("Checkers");
        addComponents();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    // Methods to create the JFrame with the necessary components below

    /** returns a Box that is a row of n squares, at y position h */
    public Box addSquares(int n, int h, token token) {
        Box temp= new Box(BoxLayout.X_AXIS);
        square[] squares= new square[8];
        int i= 0;
        while (i < n) {
            if (token == null) {
                square s= new square(i, h);
                squares[i]= s;
                temp.add(squares[i]);
                if (s.color == square.darkgraysquare) {
                    System.out.println("assigned mouse listeners");
                    squares[i].addMouseListener(me);
                }
            } else {
                square s= new square(i, h, token);
                squares[i]= s;
                temp.add(squares[i]);
                if (s.color == square.darkgraysquare) {
                    System.out.println("assigned mouse listeners");
                    squares[i].addMouseListener(me);
                }
            }

            i= i + 1;
        }
        array[h]= squares;
        return temp;
    }

    /** adds all components to the JFrame, currently only adds the boardbox */
    public void addComponents() {
        createBoardBox(8);
        createInfoBox();
        mainbox.add(boardbox);
        mainbox.add(infobox);
        add(mainbox, BorderLayout.CENTER);
    }

    /** makes a full 8x8 game board */
    public void createBoardBox(int n) {
        int i= 0;
        while (i < n) {
            if (i <= 2) {
                boardbox.add(addSquares(n, i, new token(Color.DARK_GRAY.darker())));
            } else if (i <= 4) {
                boardbox.add(addSquares(n, i, null));
            } else {
                boardbox.add(addSquares(n, i, new token(Color.red.darker())));
            }
            i= i + 1;
        }

    }

    /** adds all necessary components to an infobox on the right side of the gameboard */
    public void createInfoBox() {
        infobox.add(new JLabel("Welcome to Checkers!"));
        infobox.add(new JButton("New Game"));

    }

    // toString override to debug
    @Override
    public String toString() {
        String s= "[";
        for (int row= 0; row < 8; row++ ) {
            for (int column= 0; column < 8; column++ ) {
                s= s + array[row][column].hasPiece;
            }
        }
        s= s + "]";
        return s;
    }

    // Methods to actually play the game.

    // returns true if the token clicked on is a valid token to move.
    public static boolean isValidpiece(square sq) {
        // TODO 1 NOT FINISHED
        if (sq.hasPiece) { return true; }
        return false;
    }

}
