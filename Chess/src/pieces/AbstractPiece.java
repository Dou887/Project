package pieces;

import main.Board;

import java.awt.*;
import java.util.Vector;

import static pieces.PieceType.KNIGHT;
import static pieces.PieceType.PAWN;

public abstract class AbstractPiece implements Piece {

    protected int x;
    protected int y;
    protected final PieceColor pieceColor;
    protected boolean moved;
    protected PieceType pieceType;
    protected Vector<Point> possibleMoves = new Vector<>();
    protected Vector<Point> forcedMoves = new Vector<>();

    public AbstractPiece(PieceColor pieceColor, int x, int y, boolean moved) {
        this.x = x;
        this.y = y;
        this.pieceColor = pieceColor;
        this.moved = moved;
    }

    public Vector<Point> squaresAttacked(Board board){
        if(!forcedMoves.isEmpty()){
            possibleMoves = forcedMoves;
        }
        possibleMoves.clear();
        for(int x = 0; x<8; x++){
            for (int y= 0; y <8; y++){
                Point temp = new Point(x,y);
                if(this.isValidMove(temp) && !pathBlocked(board,temp)){
                    if(board.isEmpty(temp)){
                        possibleMoves.add(temp);
                    }
                    else if(board.getSquare(temp).color() != this.color() &&
                            board.getSquareAt(new Point(this.x,this.y)) != PAWN ){
                        possibleMoves.add(temp);
                    }
                }
            }
        }
        return possibleMoves;
    }

    public void validForcedMove(Point coord){
        if(coord != null) {
            forcedMoves.add(coord);
        }
    }
    public Vector<Point> printForcedMove(){
        return forcedMoves;
    }

    public boolean pathBlocked(Board board, Point endSquare){
        int dirY = y < endSquare.y ? 1 : -1;
        int dirX = x < endSquare.x ? 1 : -1;

        if (board.getSquareAt(new Point(x,y)) == KNIGHT) {
            return false;
        }
        if (endSquare.x - x == 0) {
            for (int i = 1; i < Math.abs(y - endSquare.y); i++) {
                if (!board.isEmpty(new Point(x, y + i * dirY))) {
                    return true;
                }
            }
        }
        if (endSquare.y - y == 0) {
            for (int i = 1; i < Math.abs(x - endSquare.x); i++) {
                if (!board.isEmpty(new Point(x + i * dirX, y))) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 1; i < Math.abs(x - endSquare.x); i++) {
                if (!board.isEmpty(new Point(x + i * dirX, y + i * dirY))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public PieceType type() {
        return pieceType;
    }

    @Override
    public void setMoved() {
        this.moved = true;

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
