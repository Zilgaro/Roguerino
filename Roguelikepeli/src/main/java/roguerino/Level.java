

package roguerino;

public class Level {
    
    private Block[][] blocks;
    private int height;
    private int width;

    public Level(int height, int width) {
        this.height = height;
        this.width = width;
        this.blocks = new Block[this.width][this.height];
        
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
             this.blocks[i][j]=new Block();
            }
        }
    }
    
    public void setBlock(int x, int y, Block block) {
        this.blocks[x][y] = block;
    }

    public Block getBlock(int x, int y) {
        return this.blocks[x][y];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
}
