package roguerino.levels;

import roguerino.blocks.Blockerino;
import roguerino.blocks.Empty;

/**
 * Luo levelin asettemalla sen täyteen 'tyhjiä' blockeja.
 */
public class LevelGenerator {

    public LevelGenerator() {

    }

    /*
     public Level generateLevel() { //Turha metodi atm
     Level level = new Level(30, 30);

     return level;
     }
     */
    /**
     * Tarkempaa katsastusta harrastettuna tämä metodi on melko redundantti;
     * levelin konstruktorissa itsessään luodaan jo dimensioiden puitteissa
     * oleva kartta, jossa on pelkkiä Empty() -blockeja. Kuitenkin
     * LevelGenerator luokkanaan on oikeutettu: sitä tarvitaan mikäli
     * lisättäisiin toisenlaisten karttojen generointi, joissa jo valmiiksi
     * olisi muitakin block -tyyppejä.
     *
     * @param width annettu leveys
     * @param height annettu korkeus
     * @return palauttaa generoidun levelin
     */
    public Level generateLevelEmpty(int width, int height) { //luo tyhjää(kävelytilaa) täynnä olevan kentän
        Level level = new Level(width, height);
        /*
         for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
         Blockerino block = new Empty();
         level.setBlock(i, j, block);
         }
         }
         */
        return level;
    }
}
