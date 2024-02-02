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
            gameController.startGame(dimensions, players, winningStrategies);
        }
        catch (Exception ex)
        {
            System.out.println("Something went wrong "+ex);
            return;
        }
        System.out.println("Create Game successfully");
    }
}
