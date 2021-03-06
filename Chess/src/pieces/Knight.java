package pieces;

import java.awt.*;

public class Knight extends AbstractPiece {
    private int value = 3;
    public Knight(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor, x, y, moved);
    }

    @Override
    public boolean isValidMove(Point endSquare) {
        if(endSquare == null){
            return false;
        }
        int deltaX = Math.abs(x - endSquare.x);
        int deltaY = Math.abs(y - endSquare.y);
        return deltaX * deltaY == 2;
    }

    public int getValue() {
        return value;
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

    public PieceType type(){
        return PieceType.KNIGHT;
    }
}
