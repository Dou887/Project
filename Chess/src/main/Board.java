package main;

import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceSet;
import pieces.PieceType;

import java.awt.*;

import static pieces.PieceColor.*;
import static pieces.PieceType.*;

public class Board {

    private final int HEIGHT = 8;
    private final int WIDTH = 8;
    private final Piece[][] square = new Piece[WIDTH][HEIGHT];


    public Board() {
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public boolean outOfBounds(Point coord){
        return (-1 >= coord.x || coord.x >= 8) || (-1 >= coord.y || coord.y >= 8);
    }

    public void side(PieceColor pieceColor){
        PieceSet pieceSet = new PieceSet(pieceColor);
        for (Piece piece: pieceSet.list()){
            int x = piece.getX();
            int y = piece.getY();
            square[x][y] = piece;
        }
    }
    public void movePiece(Point startSquare, Point endSquare){
        square[endSquare.x][endSquare.y] = null;
        square[endSquare.x][endSquare.y] = square[startSquare.x][startSquare.y];
        square[startSquare.x][startSquare.y] = null;
    }

    /**
     * Method is only used for pawn promotion
     */
    public void setPiece(Piece piece, Point coord){
        square[coord.x][coord.y] = piece;
    }

    public Piece getSquare(Point coord) {
        if(coord == null){
            return null;
        }
        return square[coord.x][coord.y];
    }

    public boolean isEmpty(Point coord){
        return square[coord.x][coord.y] == null;
    }


    public PieceType getSquareAt(Point coord) {
        if(outOfBounds(coord)){
            System.out.println("Out of bounds");
            return OUTSIDE;
        }
        return isEmpty(coord) ? EMPTY : square[coord.x][coord.y].type();
    }
    public PieceColor getColorAt(Point coord)  {
        if(outOfBounds(coord)){
            System.out.println("Out of bounds");
            return NONE;
        }
        return isEmpty(coord) ? NONE : square[coord.x][coord.y].color();
    }
}
