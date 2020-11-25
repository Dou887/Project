package main;
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


    public Move(Board board, Player player, Point startSquare, Point endSquare) {
        this.board = board;
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.pieceKilled = null;

    }

    public Point getStartSquare() {
        return startSquare;
    }

    public Point getEndSquare() {
        return endSquare;
    }

    public boolean sameParti(){
        if(getSourcePiece() != null && getDestPiece() != null){
            return getSourcePiece().color() == getDestPiece().color();}
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
        if(board.getSquare(endSquare) != null){
            pieceKilled = board.getSquare(endSquare);
        }
        board.getSquare(startSquare).setX(endSquare.x);
        board.getSquare(startSquare).setY(endSquare.y);
        board.getSquare(startSquare).setMoved();
        board.movePiece(startSquare, endSquare);
        board.setPiece(null, startSquare);
    }

    public boolean isCastlingMove(){
        if(board.getSquareAt(startSquare) == KING && !board.getSquare(startSquare).moved() &&
            startSquare.y == endSquare.y && Math.abs(startSquare.x- endSquare.x) == 2){
            // Pieces has not moved yet

            boolean rightRook = endSquare.x>4;
            int num1 = rightRook ? 1 : -2;
            int num2 = rightRook ? 1 : -1;
            Point sideOfKing = new Point(startSquare.x+num2, startSquare.y);
            Point rookSquare = new Point(endSquare.x+num1, endSquare.y);

            System.out.println(!board.getSquare(rookSquare).moved());
            System.out.println(!pathBlocked(rookSquare, endSquare));
            return !board.getSquare(rookSquare).moved() && !pathBlocked(rookSquare, startSquare);
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
    public boolean isPawnAttack(){
        if(board.getSquareAt(startSquare) == PAWN && getSourcePiece() != null && getDestPiece() != null){
            if(getSourcePiece().color() != getDestPiece().color()){
                int num = getSourcePiece().color() == WHITE ? 1 : -1;
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

    public boolean isValidMove(){
        if (board.getSquareAt(startSquare) == PAWN){
            return getDestPiece() == null ? this.getSourcePiece().isValidMove(endSquare) : isPawnAttack();
        }
        else if(getSourcePiece() != null){
            return this.getSourcePiece().isValidMove(endSquare) && !pathBlocked(startSquare, endSquare) && !sameParti();

            }
        return false;
        }


    public Piece getSourcePiece(){
        return board.getSquare(startSquare);
    }

    public Piece getDestPiece(){
        return board.getSquare(endSquare);
    }

    public boolean canAttack(Point startSquare, Point endSquare){
        Piece piece = board.getSquare(startSquare);
        Point piecePoint = new Point(piece.getX(), piece.getY());
        return piece.isValidMove(endSquare) && !pathBlocked(piecePoint, endSquare);
    }

    public boolean isCheckMate(PieceColor color){
        for(int x1 = 0; x1< board.getWidth();x1++) {
            for (int y1 = 0; y1 < board.getHeight(); y1++) {
                for (int x = 0; x < board.getWidth(); x++) {
                    for (int y = 0; y < board.getHeight(); y++) {
                        Point startSquare = new Point(x1,y1);
                        Point endSquare = new Point(x,y);
                        if(board.getSquare(startSquare).isValidMove(endSquare) && !pathBlocked(startSquare, endSquare)){
                            this.piece(startSquare, endSquare);
                            if(!isCheck(color)){
                                this.piece(endSquare, startSquare);
                                board.setPiece(pieceKilled,endSquare);
                                return true;
                            }
                            this.piece(endSquare, startSquare);
                            board.setPiece(pieceKilled,endSquare);
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isCheck(PieceColor color){
        Point kingPos = null;
        for(int x1 = 0; x1< board.getWidth();x1++){
            for (int y1 =0; y1< board.getHeight();y1++){
                if(board.getColorAt(new Point(x1,y1)) == color && board.getSquareAt(new Point(x1,y1)) == KING){
                    kingPos = new Point(x1,y1);
                    break;
                }
            }
        }
        for(int x = 0; x< board.getWidth();x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                Point start = new Point(x,y);
                if(board.getSquare(start).color() != color){
                    if(canAttack(start,kingPos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }




}
