package pieces;

import main.Board;

import java.awt.*;

import static pieces.PieceColor.BLACK;
import static pieces.PieceColor.NONE;

public class Pawn extends AbstractPiece {

    public Pawn(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }

    @Override
    public void setMoved() {
        super.setMoved();
    }

    public PieceType type(){
        return PieceType.PAWN;
    }


    public boolean moved(){
        return moved;
    }

    @Override
    public boolean isValidMove(Point endSquare) {
        return !moved ? pieceColor == BLACK ? endSquare.x == x && endSquare.y - y < 3 :
                endSquare.x == x && y - endSquare.y < 3 :
                pieceColor == BLACK ? endSquare.x == x && endSquare.y - y == 1 :
                        endSquare.x == x && y - endSquare.y == 1;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public PieceColor color() {
        return super.color();
    }

    public boolean isPromoting(){
        if(this.pieceColor == BLACK ){

        }
        return false;
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "x=" + x +
                ", y=" + y +
                ", pieceColor=" + pieceColor +
                '}';
    }

    public Piece promoteTo(){
        return null;
    }
}
