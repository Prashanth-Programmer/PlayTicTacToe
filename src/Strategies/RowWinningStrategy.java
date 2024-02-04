package Strategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategies{
    Map<Integer, Map<Symbol, Integer>> rowsMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getCell().getPlayer().getSymbol();
        if(!rowsMap.containsKey(row)){
            rowsMap.put(row, new HashMap<>());
        }
        Map<Symbol, Integer> rowMap = rowsMap.get(row);
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol, 0);
        }
        rowMap.put(symbol, rowMap.get(symbol) + 1);
        if(rowMap.get(symbol) == board.getSize()){
            return  true;
        }
        else{
            return false;
        }
    }
}
