package pieces;

import main.Board;

import java.awt.*;

public interface Piece {
    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    PieceColor color();

    boolean moved();

    PieceType type();
}
