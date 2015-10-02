

package roguerino.levels;



public class Block {
    
 /**
 * Pelikentän rakennuspalikka, pitää sisällään boolean-tyyppisenä oman "tyyppinsä"
 * Tuntee, onko pelaaja/vihollinen (TODO) kyseisen palikan päällä. 
 */
    
    private Player player;
    private Enemy enemy;
    private boolean black; //black tarkoittaa tyhjää johon ei voi astua
    private boolean floor; //floor taas astuttava rakennuksen sisällä (todo)
    private boolean wall; //tässä tilanteessa wallin tulee myös olla black (Pitää selvittää miten blockin saisi määriteltyä enumtyyppeinä)
    private boolean door;
    

    //päästäkää minut pahasta
    public Block() {
        this.player = null;
        this.enemy = null;
        this.black = true;
        this.floor = false;
        this.wall = false;
        this.door = false;
    }
    
    //älkääkä saattako minua kiusaukseen
    public Block(Player player, Enemy enemy, boolean black, boolean wall, boolean floor, boolean door) {
        this.enemy = enemy;
        this.player = player;
        this.black = black;
        this.floor = floor;
        this.wall = wall;
        this.door = door;
    }

   
    public void setBlack(boolean black) {
        if (this.floor || this.door) {
            this.floor = false;
            this.door = false;
        }
        
        if (this.player != null) {
            this.player = null;
        }
        this.black = black;
    }

    public boolean isBlack() {
        return black;
    }

    public void setPlayer(Player player) { //null = ei pelaajaa
        if (!this.black && !this.wall) {
            this.player = player;
        }
        
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }
    
    public boolean hasEnemy() {
        if (enemy == null) {
            return false;
        }
        return true;
    }

    public boolean hasPlayer() { //Tarkistetaan, onko pelaaja blockin päällä
        if (player == null)
            return false;
        return true;
    }

    public void setFloor(boolean floor) {
        if (this.black) {
            this.black = false;
        }
        this.floor = floor;
    }

    public boolean isFloor() {
        return floor;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public boolean isWall() {
        return wall;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public boolean isDoor() {
        return door;
    }
  
}
