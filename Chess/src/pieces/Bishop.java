package pieces;

import main.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class Bishop extends AbstractPiece {
    private int value = 3;
    public Bishop(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }

    public int getValue() {
        return value;
    }

    public boolean isValidMove(Point endSquare){
        if(endSquare == null){
            return false;
        }
        int deltaX = Math.abs(x - endSquare.x);
        int deltaY = Math.abs(y - endSquare.y);
        return deltaX == deltaY;

    }

    public PieceType type(){
        return PieceType.BISHOP;
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
}
