package checkers;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class MouseEvents extends MouseInputAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO 1
        Object ob= e.getSource();
        if (ob instanceof square) {
            ((square) ob).clicked();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO 2
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO 3
    }
}
