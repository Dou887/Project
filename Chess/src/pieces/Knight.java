package pieces;

import main.Board;

import java.awt.*;

public class Knight extends AbstractPiece {

    public Knight(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor, x, y, moved);
    }
    public boolean isValidMove(Board board, Point endSquare){
        if(isEnemy(board, endSquare)){
            int deltaX = Math.abs(x - endSquare.x);
            int deltaY = Math.abs(y - endSquare.y);
            return deltaX * deltaY == 2;
        }
        return false;
    }
    public PieceType type(){
        return PieceType.KNIGHT;
    }
}
