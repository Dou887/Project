package Main;

import static Main.PieceType.EMPTY;

public class Board {

    private final int HEIGHT = 8;
    private final int WIDTH = 8;
    private Piece[][] square = new Piece[WIDTH][HEIGHT];
    private PieceSet pieceSet = new PieceSet();


    public Board() {
        for (Piece piece: pieceSet.list()){
            int x = piece.getX();
            int y = piece.getY();
            square[x][y] = piece;
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public boolean outOfBounds(int x, int y){
        if((-1<x && x<8) && (-1<y && y<8)){
            return false;
        }
        return true;
    }

    public boolean isEmpty(int x, int y){
        if(square[x][y] == null){
            return true;
        }
        return false;
    }
    public PieceType getSquareAt(int x,int y)  {
        if(!outOfBounds(x,y)){
            if(!isEmpty(x,y)){
                return square[x][y].type();
            }
            return EMPTY;

        }
        return null;
    }
    public PieceColor getColorAt(int x, int y){
        if(!outOfBounds(x,y) && !isEmpty(x,y)){
            return square[x][y].color();
        }
        return null;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.getColorAt(10,10);
    }

}
