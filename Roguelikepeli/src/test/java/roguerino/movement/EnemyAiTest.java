/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.movement;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import roguerino.Game;
import roguerino.logic.Logic;

/**
 *
 * @author Zilgaro
 */
public class EnemyAiTest {
    
    private Logic test;

    public EnemyAiTest() {
        this.test= new Logic();
    }
    @Test 
    public void EnemyAiNullVulnerabilityTest() {
        test.run();
        EnemyAi enemyAi = new EnemyAi(test.getLevel());
        
        try {
            enemyAi.run(null);
        } catch (Exception e) {
            fail("Your EnemyAi is vulnerable to a null list of enemies");
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
