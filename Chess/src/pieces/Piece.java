package pieces;

import java.awt.*;

public interface Piece {
    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    PieceColor color();

    boolean moved();

    boolean isValidMove(Point endSquare);

    void setMoved();
    PieceType type();
}
