import Controllers.GameController;
import Models.*;
import Strategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try{
            int dimensions = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1, "AB", new Symbol('X'), PlayerType.HUMAN));
            players.add(new Bot(2, "GPT", new Symbol('O'), PlayerType.BOT, DifficultyLevel.EASY));
            List<WinningStrategies> winningStrategies = new ArrayList<>();
            Game game = gameController.startGame(dimensions, players, winningStrategies);
            System.out.println("Create Game successfully");
            while(game.getGameState().equals(GameState.IN_PROGRESS)){
                gameController.displayBoard(game);
                gameController.makeMove(game);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Something went wrong "+ex);
        }

    }
}
