package Models;

import Strategies.WinningStrategies;
import Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerTurnIndex;

    private List<WinningStrategies> winningStrategies;

    public List<WinningStrategies> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategies> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerTurnIndex() {
        return nextPlayerTurnIndex;
    }

    public void setNextPlayerTurnIndex(int nextPlayerTurnIndex) {
        this.nextPlayerTurnIndex = nextPlayerTurnIndex;
    }

    private Game(int dimensions, List<Player> players, List<WinningStrategies> winningStrategies){
        this.board = new Board(dimensions);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList();
        this.nextPlayerTurnIndex = 0;
        this.winner = null;
    }
    public static Builder GetBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> playerList;
        private List<WinningStrategies> winningStrategies;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return  this;
        }

        public List<Player> getPlayerList() {
            return playerList;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return  this;
        }

        public List<WinningStrategies> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return  this;
        }

        public Game build() throws PlayerCountException, BotCountException, SymbolException{
            validate();
            return new Game(this.dimension, this.playerList, this.winningStrategies);
        }

        public void validate() throws  PlayerCountException, BotCountException, SymbolException{
            validatePlayerCount();
            validateBotCount();
            validateSymbolCount();
        }

        public void validatePlayerCount() throws  PlayerCountException{
            if(playerList.size() != dimension - 1){
                throw new PlayerCountException();
            }
        }
        public void validateBotCount() throws  BotCountException{
            int botCount = 0;
            for(int i = 0; i < playerList.size(); i++){
                if(playerList.get(i).getPlayerType().equals(PlayerType.BOT)){
                    botCount += 1;
                }
            }
            if(botCount > 1){
                throw new BotCountException();
            }
        }
        public void validateSymbolCount() throws SymbolException{
            Map<Character, Integer> map = new HashMap<>();
            for(int i =0 ; i< playerList.size(); i++){
                if(!map.containsKey(playerList.get(i).getSymbol().getaChar())){
                    map.put(playerList.get(i).getSymbol().getaChar(), 0);
                }
                map.put(playerList.get(i).getSymbol().getaChar(), map.get(playerList.get(i).getSymbol().getaChar()) + 1);
                if(map.get(playerList.get(i).getSymbol().getaChar()) > 1){
                    throw new SymbolException();
                }
            }
        }
    }
}
