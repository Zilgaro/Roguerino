
package roguerino.movement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import roguerino.Logic;

public class MouseManager implements MouseListener {

    private Logic logic;

    public MouseManager(Logic logic) {
        this.logic = logic;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() < 320) {
            if (e.getY() < 320) {
                this.logic.movement(1);
            } else if (e.getY() > 384) {
                this.logic.movement(7);
            } else {
                this.logic.movement(8);
            }
        } else if (e.getX() > 384) {
            if (e.getY() < 320) {
                this.logic.movement(3);
            } else if (e.getY() > 384) {
                this.logic.movement(5);
            } else {
                this.logic.movement(4);
            }
        } else if (e.getY() < 320) {
            this.logic.movement(2);
        } else {
            this.logic.movement(6);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
