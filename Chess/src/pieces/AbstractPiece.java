package pieces;

import main.Board;

import java.awt.*;

import static pieces.PieceColor.NONE;

public abstract class AbstractPiece implements Piece {

    protected int x;
    protected int y;
    protected PieceColor pieceColor;
    protected boolean moved;
    protected PieceType pieceType;

    public AbstractPiece(PieceColor pieceColor, int x, int y, boolean moved) {
        this.x = x;
        this.y = y;
        this.pieceColor = pieceColor;
        this.moved = moved;
    }

    public boolean isEnemy(Board board, Point endSquare){
        if(pieceColor!= board.getColorAt(endSquare.x, endSquare.y) &&
                board.getColorAt(endSquare.x, endSquare.y) != NONE){
            return true;
        }
        return false;
    }

    @Override
    public PieceType type() {
        return pieceType;
    }

    @Override
    public boolean moved() {
        return moved;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public PieceColor color() {
        return pieceColor;
    }
}
