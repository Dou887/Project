package pieces;

import main.Board;

import java.awt.*;
import java.util.Vector;

public class King extends AbstractPiece {
    private int value = 99999;

    public King(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor, x, y, moved);
    }

    public int getValue() {
        return value;
    }

    public boolean isValidMove(Point endSquare) {
        if(endSquare == null){
            return false;
        }
        int deltaX = Math.abs(x - endSquare.x);
        int deltaY = Math.abs(y - endSquare.y);
        return deltaX + deltaY == 1 || (deltaX == 1 && deltaY == 1);

    }

    public PieceType type() {
        return PieceType.KING;
    }




}
