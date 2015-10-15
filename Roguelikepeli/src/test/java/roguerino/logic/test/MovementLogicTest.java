package roguerino.logic.test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import roguerino.logic.Logic;
import roguerino.logic.MovementLogic;

public class MovementLogicTest {
    
    private MovementLogic movLogic;
    private Logic test;
    

    public MovementLogicTest() {
        this.test = new Logic();
        this.movLogic = new MovementLogic(test.getLevel());
    }
    
    
    @Test
    public void logicValidTestFromOutOfBounds() {        
        assertFalse("Validblock from out of bounds must be false", movLogic.validBlock(2323, 23123));
    }
    
    @Test
    public void logicValidTestWithBadMovementKey() {
        assertFalse("Validblock call with bad movementKey must be false", movLogic.validBlock(9, 9, 9));
    }
    
    
    @Test
    public void logicValidBlockWithOutOfBoundsCoordinatesAndValidMovement() {

        assertFalse("Block can't be valid if it is out of bounds", movLogic.validBlock(23423423, 324234234, 5));
    
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
