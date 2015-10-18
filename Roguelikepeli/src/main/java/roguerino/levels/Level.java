package roguerino.levels;

import roguerino.blocks.Blockerino;
import roguerino.blocks.Empty;

/**
 * Tämä luokka huolehtii kentän perustoiminnallisuudesta, luomisesta, sekä sen
 * block-rakenteen tallentamisesta.
 */
public class Level {

    private Blockerino[][] blocks;
    private int height;
    private int width;

    public Level(int height, int width) {

        this.height = Math.abs(height);
        this.width = Math.abs(width);
        this.blocks = new Blockerino[this.width][this.height];

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.blocks[i][j] = new Empty();
            }
        }
    }

    public void setBlock(int x, int y, Blockerino block) {
        if (x <= this.width && y <= this.height) {
            this.blocks[x][y] = block;
        }

    }

    public Blockerino getBlock(int x, int y) {
        if (this.height >= y && this.width >= x) {
            return this.blocks[x][y];
        }
        return null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
