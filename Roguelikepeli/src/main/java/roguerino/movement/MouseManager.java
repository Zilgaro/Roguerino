
package roguerino.movement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import roguerino.entities.Player;
import roguerino.logic.Logic;
import roguerino.logic.MovementLogic;

/**
 * Tämä luokka mahdollistaa hiiren kuuntelemisen ja toteuttaa liikkumisen 
 * Logic-luokan muuttujien ja MovementLogic luokan toiminnallisuutta hyödyntäen.
 */

public class MouseManager implements MouseListener {

    private Logic logic;
    private MovementLogic movementLogic;
    private Player player;

    public MouseManager(Logic logic) {
        this.logic = logic;
        this.movementLogic = new MovementLogic(logic.getLevel());
        this.player = logic.getPlayer();
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
                this.movementLogic.movement(1, player);
            } else if (e.getY() > 384) {
                this.movementLogic.movement(7, player);
            } else {
                this.movementLogic.movement(8, player);
            }
        } else if (e.getX() > 384) {
            if (e.getY() < 320) {
                this.movementLogic.movement(3, player);
            } else if (e.getY() > 384) {
                this.movementLogic.movement(5, player);
            } else {
                this.movementLogic.movement(4, player);
            }
        } else if (e.getY() < 320) {
            this.movementLogic.movement(2, player);
        } else {
            this.movementLogic.movement(6, player);
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
