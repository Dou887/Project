package Main;

public class Rook extends AbstractPiece {
    public Rook(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }
    public boolean isValidMove(){
        return false;
    }

    public PieceType type(){
        return PieceType.ROOK;
    }
}
