package Main;

public class Knight extends AbstractPiece {
    public Knight(PieceColor pieceColor, int x, int y, boolean moved) {
        super(pieceColor, x, y, moved);
    }
    public boolean isValidMove(){
        return false;
    }

    public PieceType type(){
        return PieceType.Knight;
    }
}