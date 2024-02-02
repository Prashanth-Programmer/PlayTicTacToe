package Controllers;

import Exceptions.BotCountException;
import Exceptions.PlayerCountException;
import Exceptions.SymbolException;
import Models.Game;
import Models.Player;
import Strategies.WinningStrategies;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategies> winningStrategies) throws PlayerCountException, BotCountException, SymbolException {
        return Game.GetBuilder().setDimension(dimension).
                setPlayerList(playerList).
                setWinningStrategies(winningStrategies).build();
    }

    public void makeMove(){

    }


}
