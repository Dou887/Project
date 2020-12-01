package player;

import pieces.PieceColor;

public interface Player {

    void setWins();

    void setLoses();

    void setPieceColor(PieceColor pieceColor);

    PieceColor getPieceColor();

    void setDraw();
}
