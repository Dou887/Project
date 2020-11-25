package pieces;

public abstract class AbstractPiece implements Piece {

    protected int x;
    protected int y;
    protected final PieceColor pieceColor;
    protected boolean moved;
    protected PieceType pieceType;

    public AbstractPiece(PieceColor pieceColor, int x, int y, boolean moved) {
        this.x = x;
        this.y = y;
        this.pieceColor = pieceColor;
        this.moved = moved;
    }

    @Override
    public PieceType type() {
        return pieceType;
    }

    @Override
    public void setMoved() {
        this.moved = true;

    }

    @Override
    public boolean moved() {
        return moved;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public PieceColor color() {
        return pieceColor;
    }
}
