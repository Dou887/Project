package pieces;

import main.Board;

import java.awt.*;

public class Queen extends AbstractPiece {

    private PieceType pieceType;
    public Queen(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);

    }
    public boolean isValidMove(Board board, Point endSquare ){
        int deltaX = Math.abs(x - endSquare.x);
        int deltaY = Math.abs(y - endSquare.y);
        return ((x == endSquare.x) ^ (y == endSquare.y)) || deltaX == deltaY;
    }

    @Override
    public boolean isValidMove(Point endSquare) {
        int deltaX = Math.abs(x - endSquare.x);
        int deltaY = Math.abs(y - endSquare.y);
        return ((x == endSquare.x) ^ (y == endSquare.y)) || deltaX == deltaY;
    }

    @Override
    public boolean moved() {
        return super.moved();
    }

    @Override
    public void setMoved() {
        super.setMoved();
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
        return PieceType.QUEEN;
    }

}
