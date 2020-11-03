package main;

import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceSet;
import pieces.PieceType;

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

    public boolean outOfBounds(int x, int y){
        return (-1 >= x || x >= 8) || (-1 >= y || y >= 8);
    }

    public void side(PieceColor pieceColor){
        PieceSet pieceSet = new PieceSet(pieceColor);
        for (Piece piece: pieceSet.list()){
            int x = piece.getX();
            int y = piece.getY();
            square[x][y] = piece;
        }
    }

    public boolean isEmpty(int x, int y){
        return square[x][y] == null;
    }
    public PieceType getSquareAt(int x, int y) {
        if(outOfBounds(x,y)){
            System.out.println("Out of bounds");
            return OUTSIDE;
        }
        return isEmpty(x,y) ? EMPTY : square[x][y].type();
    }
    public PieceColor getColorAt(int x, int y)  {
        if(outOfBounds(x,y) && !isEmpty(x,y)){
            System.out.println("Out of bounds");
            return NONE;
        }
        return square[x][y].color();
    }
}
