import Controllers.GameController;
import Models.*;
import Strategies.ColumnWinningStrategy;
import Strategies.DiagonalWinningStrategy;
import Strategies.RowWinningStrategy;
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
            winningStrategies.add(new RowWinningStrategy());
            winningStrategies.add(new ColumnWinningStrategy());
            winningStrategies.add(new DiagonalWinningStrategy());
            Game game = gameController.startGame(dimensions, players, winningStrategies);
            System.out.println("Create Game successfully");
            while(game.getGameState().equals(GameState.IN_PROGRESS)){
                gameController.displayBoard(game);
                gameController.makeMove(game);
            }
            if(gameController.checkGameState(game).equals(GameState.DRAW)){
                System.out.println("Game is drawn");
            }
            if(gameController.checkGameState(game).equals(GameState.WIN)){
                System.out.println("Winner is "+ gameController.getWinner(game).getName());
            }
        }
        catch (Exception ex)
        {
            System.out.println("Something went wrong "+ex);
        }

    }
}
