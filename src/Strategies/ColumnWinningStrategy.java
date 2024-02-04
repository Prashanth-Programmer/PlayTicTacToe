package Strategies;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategies{
    Map<Integer, Map<Symbol, Integer>> columnsMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getCell().getPlayer().getSymbol();
        if(!columnsMap.containsKey(col)){
            columnsMap.put(col, new HashMap<>());
        }
        Map<Symbol, Integer> colMap = columnsMap.get(col);
        if(!colMap.containsKey(symbol)){
            colMap.put(symbol, 0);
        }
        colMap.put(symbol, colMap.get(symbol) + 1);
        if(colMap.get(symbol) == board.getSize()){
            return  true;
        }
        else{
            return false;
        }
    }
}
