package Models;

public class Bot extends  Player{
    private DifficultyLevel botDifficultyLevel;

    public DifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(DifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Bot(int id, String name, Symbol symbol, PlayerType playerType, DifficultyLevel botDifficultyLevel){
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
