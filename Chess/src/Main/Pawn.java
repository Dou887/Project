package Main;

public class Pawn extends AbstractPiece{

    public Pawn(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }
    public PieceType type(){
        return PieceType.PAWN;
    }
    public boolean isValidMove(){
        return false;
    }
    public boolean isPromoting(){
        return false;
    }

    public Piece promoteTo(){
        return null;
    }
}
