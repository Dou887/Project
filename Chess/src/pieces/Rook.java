package pieces;

import java.awt.*;

public class Rook extends AbstractPiece {
    private int value = 5;
    public Rook(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean isValidMove(Point endSquare) {
        if(endSquare == null){
            return false;
        }
        return (x == endSquare.x) ^ (y == endSquare.y);
    }
    public PieceType type(){
        return PieceType.ROOK;
    }

    @Override
    public void setMoved() {
        super.setMoved();
    }

    @Override
    public boolean moved() {
        return super.moved();
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
}
