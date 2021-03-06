package roguerino;

import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import roguerino.Game;
import roguerino.blocks.Black;
import roguerino.blocks.Blockerino;
import roguerino.logic.Logic;
import roguerino.levels.Level;
import roguerino.entities.Player;
import roguerino.logic.MovementLogic;

public class RoguelikepeliTest {

    private Logic test;

    public RoguelikepeliTest() {
        this.test = new Logic();
    }

    @Test
    public void badInputFromUser() {
        ByteArrayInputStream in = new ByteArrayInputStream("lolcat".getBytes());
        try {
            System.setIn(in);
            test.run();
        } catch (Exception e) {
            fail("You let bad input pass. Subsequently, you fail.");
        }
    }

    @Test
    public void creatingBlocksOutOfBounds() {
        Blockerino block = new Black();
        Level level = new Level(10, 10);

        try {
            level.setBlock(11, 11, block);
        } catch (Exception e) {
            fail("You let someone put tiles outside your magical world. For shame.");
        }
    }

    @Test
    public void movingOutOfBounds() {
        ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream("4".getBytes());

        try {
            for (int i = 0; i < test.getLevel().getHeight(); i++) {
                System.setIn(in);
            }

            for (int i = 0; i < test.getLevel().getWidth(); i++) {
                System.setIn(in2);
            }

            test.run();
        } catch (Exception e) {
            fail("You let the player get out of the level, now what are you going to do?");
        }
    }

    @Test
    public void logicGetBlockFromOutOfBounds() {
        try {
            Blockerino block = test.getBlock(1231, 123049);
        } catch (Exception e) {
            fail("Where did you go digging, I wonder?");
        }
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

}
