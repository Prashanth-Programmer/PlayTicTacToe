package Strategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategies{

    Map<Symbol, Integer> leftDiagonal = new HashMap<>();
    Map<Symbol, Integer> rightDiagonal = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getCell().getPlayer().getSymbol();

        if(row == col){
            if(!leftDiagonal.containsKey(symbol)){
                leftDiagonal.put(symbol, 0);
            }
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);
            if(leftDiagonal.get(symbol) == board.getSize()){
                return  true;
            }
        }
        if((row + col) == board.getSize() - 1){
            if(!rightDiagonal.containsKey(symbol)){
                rightDiagonal.put(symbol, 0);
            }
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);
            if(rightDiagonal.get(symbol) == board.getSize()){
                return  true;
            }
        }
        return  false;
    }
}
