package roguerino;

import java.awt.Dimension;
import javax.swing.JFrame;
import static roguerino.Game.HEIGHT;
import static roguerino.Game.SCALE;
import static roguerino.Game.WIDTH;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame("Roguerino");
        frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.setVisible(true);

        game.start();

    }

}
