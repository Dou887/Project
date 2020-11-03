package pieces;

public class Queen extends AbstractPiece {

    private PieceType pieceType;
    public Queen(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor,x,y,moved);

    }
    public boolean isValidMove(int newX, int newY ){
        int deltaX = Math.abs(x - newX);
        int deltaY = Math.abs(y - newY);
        return ((x == newX) ^ (y == newY)) || deltaX == deltaY;
    }
    public PieceType type(){
        return PieceType.QUEEN;
    }
}
