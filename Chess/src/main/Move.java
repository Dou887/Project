package main;

import pieces.Piece;
import player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static pieces.PieceType.*;

public class Move {
    private final Point startSquare;
    private final Point endSquare;
    private Piece pieceKilled;
    private Piece pieceMoved;
    private final Board board;

    public Move(Board board, Player player, Point startSquare, Point endSquare) {
        this.board = board;
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.pieceKilled = null;
    }

    public boolean pathBlocked(){
        int dirY = startSquare.y < endSquare.y ? 1 : -1;
        int dirX = startSquare.x < endSquare.x ? 1 : -1;

        if (board.getSquareAt(startSquare.x, startSquare.y) == KNIGHT) {
            return false;
        }
        if (endSquare.x - startSquare.x == 0) {
            for (int i = 1; i < Math.abs(startSquare.y - endSquare.y); i++) {
                if (!board.isEmpty(startSquare.x, startSquare.y + i * dirY)) {
                    return true;
                }
            }
        }
        if (endSquare.y - startSquare.x == 0) {
            for (int i = 1; i < Math.abs(startSquare.x - endSquare.y); i++) {
                if (!board.isEmpty(startSquare.x + i * dirX, startSquare.y)) {
                    return true;
                }
            }
        } else {
            for (int i = 1; i < Math.abs(startSquare.x - endSquare.x); i++) {
                if (!board.isEmpty(startSquare.x + i * dirX, startSquare.y + i * dirY)) {
                    return true;
                }
            }
        }
        return false;
    }




    public void move(){
    }

    public boolean isCheck(){
        return false;
    }

    public List<Point> possibleMoves(int x, int y){
        List<Point >listOfMoves = new ArrayList<>();
        return null;
    }

    public Point getStartSquare() {
        return startSquare;
    }

    public Point getEndSquare() {
        return endSquare;
    }

    public static void main(String[] args) {
        Point point = new Point(20,21);
        System.out.println(point.y);
    }
}
