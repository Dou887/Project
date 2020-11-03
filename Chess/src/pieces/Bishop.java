package pieces;

import main.Board;

import java.awt.*;

public class Bishop extends AbstractPiece {

    public Bishop(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }
    public boolean isValidMove(Board board, Point endSquare){
        return false;
    }

    public PieceType type(){
        return PieceType.BISHOP;
    }

}
