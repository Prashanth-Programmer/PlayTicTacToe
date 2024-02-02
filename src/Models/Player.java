package Models;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    private Scanner scanner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Player(int id, String name, Symbol symbol, PlayerType playerType){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }
    public Move makeMove(Board board){
        System.out.println("please enter the row");
        int row = this.scanner.nextInt();

        System.out.println("please enter the column");
        int col = this.scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }
}
