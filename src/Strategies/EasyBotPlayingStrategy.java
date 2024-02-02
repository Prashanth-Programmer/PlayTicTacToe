package Strategies;

import Models.Board;
import Models.CellState;
import Models.Move;
import Models.Cell;

import java.util.List;

public class EasyBotPlayingStrategy implements  BotPlayingStrategies{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row : board.getCells()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return  new Move(cell, null);
                }
            }
        }
        return  null;
    }
}
