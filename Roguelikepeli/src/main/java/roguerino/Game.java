

package roguerino;

public class Game {
    
    private Logic logic;
    
    public Game() {
        this.logic = new Logic();
    }

    public Logic getLogic() {
        return logic;
    }
    
    public void init() {
        this.logic.run();
    }
}
