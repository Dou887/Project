package pieces;

public class Rook extends AbstractPiece {
    public Rook(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }
    public boolean isValidMove(int newX, int newY){
        return (x == newX) ^ (y == newY);
    }

    public PieceType type(){
        return PieceType.ROOK;
    }
}
