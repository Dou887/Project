package Main;

public class Queen extends AbstractPiece {

    private PieceType pieceType;
    public Queen(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);

    }
    public boolean isValidMove(){
        return false;
    }
    public PieceType type(){
        return PieceType.QUEEN;
    }
}
