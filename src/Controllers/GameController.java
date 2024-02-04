package Controllers;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolException;
import Models.Board;
import Models.Game;
import Models.GameState;
import Models.Player;
import Strategies.WinningStrategies;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategies> winningStrategies) throws PlayerCountException, BotCountException, SymbolException {
        return Game.GetBuilder().setDimension(dimension).
                setPlayerList(playerList).
                setWinningStrategies(winningStrategies).build();
    }

    public GameState checkGameState(Game game){
        return game.getGameState();
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }
    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game){
        return  game.getWinner();
    }


}
