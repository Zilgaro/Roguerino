/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roguerino.blockerino.test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import roguerino.blocks.Black;
import roguerino.blocks.Blockerino;
import roguerino.blocks.Empty;
import roguerino.blocks.Wall;
import roguerino.entities.Enemy;
import roguerino.entities.Player;


/**
 *
 * @author Zilgaro
 */
public class BlockerinoTest {
    

    
    public BlockerinoTest() {
    }
    
    @Test
    public void ShouldNotBeAbleToSetEntityToUnWalkableBlock() {
        Blockerino block = new Black();
        Blockerino block2 = new Wall();
        Player player = new Player();
        block.setEntity(player);
        block2.setEntity(player);
        
        assertTrue(block.getPlayer() == null);
        assertTrue(block2.getPlayer() == null);
    }
    
    @Test
    public void ShouldNotBeAbleToSetTwoDifferentEntitiesToOneBlock1() {
        Blockerino block = new Empty();
        
        Player player = new Player();
        Enemy enemy = new Enemy(0,0);
        
        block.setEntity(enemy);
        block.setEntity(player);
        
        assertTrue(block.hasPlayer() == false);
        assertTrue(block.getPlayer() == null);
    }
    
    @Test
    public void ShouldNotBeAbleToSetTwoDifferentEntitiesToOneBlock2() {
        Blockerino block = new Empty();
        
        Player player = new Player();
        Enemy enemy = new Enemy(0,0);
        
        block.setEntity(player);
        block.setEntity(enemy);
        
        assertTrue(block.hasEnemy() == false); 
        assertTrue(block.hasPlayer());
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

