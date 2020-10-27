package Main;

public class King extends AbstractPiece {

    public King(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y, moved);
    }
    public boolean isValidMove(){
        return false;
    }
    public PieceType type(){
        return PieceType.King;
    }

}
