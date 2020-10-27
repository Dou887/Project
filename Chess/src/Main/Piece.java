package Main;

public interface Piece {
    int getX();
    int getY();
    PieceColor getPieceColor();
    boolean moved();
    PieceType type();
}
