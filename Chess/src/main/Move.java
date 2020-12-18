package main;
import pieces.King;
import pieces.Piece;
import pieces.PieceColor;
import pieces.Queen;
import player.Player;
import java.awt.*;

import static pieces.PieceColor.WHITE;
import static pieces.PieceType.*;

public class Move {
    private final Point startSquare;

    private final Point endSquare;
    private Piece pieceKilled;
    private final Board board;
    private Piece restorePiece;


    public Move(Board board, Player player, Point startSquare, Point endSquare) {
        this.board = board;
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.pieceKilled = null;

    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    public Point getStartSquare() {
        return startSquare;
    }

    public Point getEndSquare() {
        return endSquare;
    }

    public boolean sameParti(Point startSquare, Point endSquare){
        if(!board.isEmpty(startSquare) && !board.isEmpty(endSquare)){
            return board.getColorAt(startSquare) == board.getColorAt(endSquare);
        }
        return false;
    }

    public boolean pathBlocked(Point startSquare, Point endSquare){
        int dirY = startSquare.y < endSquare.y ? 1 : -1;
        int dirX = startSquare.x < endSquare.x ? 1 : -1;

        if (board.getSquareAt(startSquare) == KNIGHT) {
            return false;
        }
        if (endSquare.x - startSquare.x == 0) {
            for (int i = 1; i < Math.abs(startSquare.y - endSquare.y); i++) {
                if (!board.isEmpty(new Point(startSquare.x, startSquare.y + i * dirY))) {
                    return true;
                }
            }
        }
        if (endSquare.y - startSquare.y == 0) {
            for (int i = 1; i < Math.abs(startSquare.x - endSquare.x); i++) {
                if (!board.isEmpty(new Point(startSquare.x + i * dirX, startSquare.y))) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 1; i < Math.abs(startSquare.x - endSquare.x); i++) {
                if (!board.isEmpty(new Point(startSquare.x + i * dirX, startSquare.y + i * dirY))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void piece(Point startSquare, Point endSquare){
        if(board.getSquare(startSquare) != null) {
            board.getSquare(startSquare).setX(endSquare.x);
            board.getSquare(startSquare).setY(endSquare.y);
            board.getSquare(startSquare).setMoved();
            board.movePiece(startSquare, endSquare);
            board.setPiece(null, startSquare);
        }
    }

    public boolean isCastlingMove(){
        if(board.getSquareAt(startSquare) == KING && !board.getSquare(startSquare).moved() &&
            startSquare.y == endSquare.y && Math.abs(startSquare.x- endSquare.x) == 2){
            boolean rightRook = endSquare.x>4;
            int num1 = rightRook ? 1 : -2;int num2 = rightRook ? 1 : -1;
            Point sideOfKing = new Point(startSquare.x+num2, startSquare.y);
            Point rookSquare = new Point(endSquare.x+num1, endSquare.y);
            return !board.getSquare(rookSquare).moved() && !pathBlocked(rookSquare, startSquare) &&
                        !squareAttacked(sideOfKing,WHITE) && !squareAttacked(endSquare,WHITE);
            }
        return false;
    }
    public boolean squareAttacked(Point endSquare, PieceColor playerColor){
            for (int x = 0; x < board.getWidth(); x++) {
                for (int y = 0; y < board.getHeight(); y++) {
                    Point startSquare = new Point(x, y);
                    if (!board.isEmpty(startSquare)) {
                        if (!sameParti(startSquare,endSquare) && isValidMove(startSquare, endSquare)) {
                            return true;
                        }
                    }
                }
            }

        return false;
    }

    public void setCastlingMove(){
        board.movePiece(startSquare, endSquare);
        boolean rightRook = endSquare.x>4;
        int num1 = rightRook ? 1 : -2;
        int num2 = rightRook ? 1 : -1;
        Point sideOfKing = new Point(startSquare.x+num2, startSquare.y);
        Point rookSquare = new Point(endSquare.x+num1, endSquare.y);
        System.out.println(new Point(startSquare.x+num2, startSquare.y));
        System.out.println(new Point(endSquare.x+num1, endSquare.y));
        board.movePiece(rookSquare, sideOfKing);
    }
    public boolean isPawnAttack(Point startSquare, Point endSquare){
        if(board.getSquareAt(startSquare) == PAWN){
            if(!sameParti(startSquare,endSquare)){
                int num = board.getColorAt(startSquare) == WHITE ? 1 : -1;
                return startSquare.y - endSquare.y == num && Math.abs(endSquare.x - startSquare.x) == 1;
            }
        }
        return false;
    }

    public boolean isPawnPromoting(){
        if(board.getSquareAt(endSquare) == PAWN){
            return (endSquare.y == 0 || endSquare.y == 7);
        }
        return false;
    }
    public void setPawnPromoting(){
        Piece piece = new Queen(board.getColorAt(endSquare), endSquare.x, endSquare.y, false);
        board.setPiece(piece, endSquare);
    }

    public boolean isValidMove(Point startSquare, Point endSquare){
        if(board.getSquare(startSquare) == null){
            return false;
        }
        if (board.getSquareAt(startSquare) == PAWN){
            return board.getSquare(endSquare) == null ? board.getSquare(startSquare).isValidMove(endSquare)
                    : isPawnAttack(startSquare,endSquare);
        }
        else if(!board.isEmpty(startSquare)){
            return board.getSquare(startSquare).isValidMove(endSquare) && !pathBlocked(startSquare, endSquare)
                    && !sameParti(startSquare,endSquare);
            }
        return false;
        }


    public Piece getSourcePiece(){
        return board.getSquare(startSquare);
    }

    public Piece getDestPiece(){
        return board.getSquare(endSquare);
    }

    public boolean isCheckMate(PieceColor playerColor){
        boolean isCheckMate = true;
        for(int x1 = 0; x1< board.getWidth();x1++) {
            for (int y1 = 0; y1 < board.getHeight(); y1++) {
                Point startSquare = new Point(x1,y1);
                if(!board.isEmpty(startSquare)) {
                    if(board.getColorAt(startSquare) == playerColor){
                        for (int x = 0; x < board.getWidth(); x++) {
                            for (int y = 0; y < board.getHeight(); y++){
                                Point endSquare = new Point(x,y);
                                if (isValidMove(startSquare,endSquare)){
                                    restorePiece = board.getSquare(endSquare);
                                    piece(startSquare, endSquare);
                                    if (!isCheck(playerColor)) {

                                        isCheckMate = false;
                                    }
                                    piece(endSquare, startSquare);
                                    board.setPiece(restorePiece, endSquare);
                                }
                            }
                        }
                    }
                }
            }
        }
        return isCheckMate;
    }
    public boolean selfCheck(PieceColor color){
        if(isCheck(color)){
            piece(endSquare,startSquare);
            board.setPiece(pieceKilled,endSquare);
            return true;
        }
        return false;
    }

    public boolean isCheck(PieceColor playerColor){
        Point kingPos = null;
        for(int x1 = 0; x1< board.getWidth();x1++) {
            for (int y1 = 0; y1 < board.getHeight(); y1++) {
                if (board.getColorAt(new Point(x1, y1)) == playerColor && board.getSquareAt(new Point(x1, y1)) == KING) {
                    kingPos = new Point(x1, y1);
                    break;
                }
            }
        }
        return squareAttacked(kingPos, playerColor);
    }
}
