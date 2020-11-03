package pieces;

public class King extends AbstractPiece {

    public King(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y, moved);
    }


    public boolean isValidMove(int newX, int newY){
        int deltaX = Math.abs(x - newX);
        int deltaY = Math.abs(y - newY);
        return deltaX + deltaY == 1 || (deltaX == 1 && deltaY == 1);

    }
    public PieceType type(){
        return PieceType.KING;
    }

}
