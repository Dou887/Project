package pieces;

import main.Board;

import java.awt.*;

import static pieces.PieceColor.BLACK;
import static pieces.PieceColor.NONE;

public class Pawn extends AbstractPiece {

    public Pawn(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }

    public PieceType type(){
        return PieceType.PAWN;
    }

    public boolean isValidMove(Board board, Point endSquare, Boolean enPassant){
        if(board.isEmpty(endSquare.x, endSquare.y)){
            return enPassant ? canAttack(endSquare) :
                    // Normal moves when enSquare is empty
                    moved ? pieceColor == BLACK ? endSquare.x == x && endSquare.y - y < 3 :
                    endSquare.x == x && y - endSquare.y < 3 :
                    pieceColor == BLACK ? endSquare.x == x && endSquare.y - y == 1 :
                    endSquare.x == x && y - endSquare.y == 1;
        }
        else if(isEnemy(board, endSquare)){
                return canAttack(endSquare);
        }
        return false;
    }

    @Override
    public boolean isEnemy(Board board, Point endSquare) {
        return super.isEnemy(board, endSquare);
    }

    public boolean canAttack(Point endSquare){
        int deltaX = Math.abs(x - endSquare.x);
        return pieceColor==BLACK ? endSquare.y==y+1 && deltaX==1 : endSquare.y==y-1 && deltaX==1;
    }

    public boolean moved(){
        return moved;
    }

    public boolean isPromoting(){
        return false;
    }

    public Piece promoteTo(){
        return null;
    }
}
