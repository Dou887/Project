package player;

import pieces.PieceColor;

import static pieces.PieceColor.WHITE;

public class HumanPlayer implements Player {
    private int matchesPlayed;
    private int wins;
    private int loses;
    private PieceColor pieceColor = null;
    private String name;

    @Override
    public String toString() {
        return "HumanPlayer{" +
                "pieceColor=" + pieceColor +
                ", name='" + name + '\'' +
                '}';
    }

    public HumanPlayer(String name) {
        this.name = name;
    }

    public void setPieceColor(PieceColor pieceColor){
        this.pieceColor = pieceColor;
    }
    public PieceColor getPieceColor() {
        return pieceColor;
    }

    @Override
    public void setWins() {

    }

    @Override
    public void setLoses() {

    }

    @Override
    public void setDraw() {

    }
}
