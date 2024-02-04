package Strategies;

import Models.Board;
import Models.Move;

public interface WinningStrategies {
    public boolean checkWinner(Board board, Move move);
}
