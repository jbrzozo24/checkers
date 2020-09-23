package checkers;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class MouseEvents extends MouseInputAdapter {
	
	public checkers game; //the game being played

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO 1
        Object ob= e.getSource(); //ob is the object that was clicked
        if (ob instanceof square) { //check to make sure it is a square before casting
            ((square) ob).clicked(game); //call clicked 
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO 2
    	Object ob= e.getSource();
    	if(ob instanceof square) {
    		System.out.println(((square) ob).toString());
    	}
        //System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO 3
    }
}
