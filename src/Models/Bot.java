package Models;

import Strategies.BotPlayingStrategies;
import Strategies.BotPlayingStrategyFactory;

public class Bot extends  Player{
    private DifficultyLevel botDifficultyLevel;
    private BotPlayingStrategies botPlayingStrategy;

    public DifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(DifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Bot(int id, String name, Symbol symbol, PlayerType playerType, DifficultyLevel botDifficultyLevel){
        super(id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(this.botDifficultyLevel);
    }

    public Move makeMove(Board board){
        Move move = botPlayingStrategy.makeMove(board);
        return  move;
    }
}
