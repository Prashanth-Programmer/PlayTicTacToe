package Models;

public class Bot extends  Player{
    private DifficultyLevel botDifficultyLevel;

    public DifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(DifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
