
package roguerino.movement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import roguerino.logic.Logic;
import roguerino.logic.MovementLogic;

/**
 * Tämä luokka mahdollistaa hiiren kuuntelemisen ja toteuttaa liikkumisen 
 * Logic-luokan muuttujien ja MovementLogic luokan toiminnallisuutta hyödyntäen.
 */

public class MouseManager implements MouseListener {

    private Logic logic;
    private MovementLogic movementLogic;

    public MouseManager(Logic logic) {
        this.logic = logic;
        this.movementLogic = new MovementLogic(logic.getPlayer(), logic.getLevel());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Tällä hetkellä, koska pathfinding-algoritmia ei ole, liikkuminen toteutetaan
     * graafisessa käyttöliittymässä kuuntelemalla pelaajan ympärillä oleville
     * pikseleille tulevia hiiren klikkauksia ja liikutaan yhden blockin verran.
     * @param e 
     */
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() < 320) {
            if (e.getY() < 320) {
                this.movementLogic.movement(1);
            } else if (e.getY() > 384) {
                this.movementLogic.movement(7);
            } else {
                this.movementLogic.movement(8);
            }
        } else if (e.getX() > 384) {
            if (e.getY() < 320) {
                this.movementLogic.movement(3);
            } else if (e.getY() > 384) {
                this.movementLogic.movement(5);
            } else {
                this.movementLogic.movement(4);
            }
        } else if (e.getY() < 320) {
            this.movementLogic.movement(2);
        } else {
            this.movementLogic.movement(6);
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
