package Main;

public class Bishop extends AbstractPiece {

    public Bishop(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);
    }
    public boolean isValidMove(){
        return false;
    }

    public PieceType type(){
        return PieceType.Bishop;
    }

}
