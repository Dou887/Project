package pieces;

import main.Board;

import java.awt.*;
import java.util.Vector;

import static pieces.PieceColor.BLACK;

public class Pawn extends AbstractPiece {
    private int value = 1;

    public Pawn(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }

    public int getValue() {
        return value;
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
        if(endSquare != null) {
            return !moved ? pieceColor == BLACK ? endSquare.x == x && endSquare.y - y < 3 && endSquare.y - y > 0 :
                    endSquare.x == x && y - endSquare.y < 3 && y - endSquare.y > 0 :
                    // has moved
                    pieceColor == BLACK ? endSquare.x == x && endSquare.y - y == 1 :
                            endSquare.x == x && y - endSquare.y == 1;
        }
        return false;
    }

    @Override
    public Vector<Point> squaresAttacked(Board board) {
        Vector<Point> possibleMoves = new Vector<>();
        int dir = pieceColor == BLACK ? 1 : -1;
        if(!board.isEmpty(new Point(x-1, y+dir))){
            if(board.getSquare(new Point(x-1,y+dir) ).color() != this.pieceColor){
                possibleMoves.add(new Point (x-1,y+dir));
            }
        }
        if(!board.isEmpty(new Point(x+1, y+dir))) {
            if (board.getSquare(new Point(x + 1, y + dir)).color() != this.pieceColor) {
                possibleMoves.add(new Point(x + 1, y + dir));
            }
        }
        possibleMoves.addAll(super.squaresAttacked(board));
        return possibleMoves;

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
