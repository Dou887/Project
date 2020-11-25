package gui;

import main.Board;
import pieces.*;

import javax.swing.*;
import java.awt.*;

import java.util.EnumMap;

import static pieces.PieceColor.*;
import static pieces.PieceType.*;

public class ChessComponent extends JComponent {

    private final Board board;
    private final static int SIZE = 60; // Pixels per square
    private final EnumMap<PieceType, EnumMap<PieceColor, ImageIcon>> pieceMap = new EnumMap<>(PieceType.class);
    private final Color lightSquare = new Color(247, 222, 140);
    private final Color darkSquare = new Color(178, 128, 54);

    public ChessComponent(final Board board) {
        this.board = board;
        this.loadImage();
    }

    public void loadImage() {
        //Read the images in resources
        final ImageIcon blackKing = new ImageIcon(ClassLoader.getSystemResource("king_black.png"));
        final ImageIcon whiteKing = new ImageIcon(ClassLoader.getSystemResource("king_white.png"));
        final ImageIcon blackQueen = new ImageIcon(ClassLoader.getSystemResource("queen_black.png"));
        final ImageIcon whiteQueen = new ImageIcon(ClassLoader.getSystemResource("queen_white.png"));
        final ImageIcon blackBishop = new ImageIcon(ClassLoader.getSystemResource("bishop_black.png"));
        final ImageIcon whiteBishop = new ImageIcon(ClassLoader.getSystemResource("bishop_white.png"));
        final ImageIcon blackKnight = new ImageIcon(ClassLoader.getSystemResource("knight_black.png"));
        final ImageIcon whiteKnight = new ImageIcon(ClassLoader.getSystemResource("knight_white.png"));
        final ImageIcon blackRook = new ImageIcon(ClassLoader.getSystemResource("rook_black.png"));
        final ImageIcon whiteRook = new ImageIcon(ClassLoader.getSystemResource("rook_white.png"));
        final ImageIcon blackPawn = new ImageIcon(ClassLoader.getSystemResource("pawn_black.png"));
        final ImageIcon whitePawn = new ImageIcon(ClassLoader.getSystemResource("pawn_white.png"));
        //Sort images so we can access them by knowing PieceType and PieceColor
        pieceMap.put(KING, new EnumMap<>(PieceColor.class) {
            {
                put(WHITE, whiteKing);
            }

            {
                put(BLACK, blackKing);
            }
        });
        pieceMap.put(QUEEN, new EnumMap<>(PieceColor.class) {
            {
                put(WHITE, whiteQueen);
            }

            {
                put(BLACK, blackQueen);
            }
        });
        pieceMap.put(ROOK, new EnumMap<>(PieceColor.class) {
            {
                put(WHITE, whiteRook);
            }

            {
                put(BLACK, blackRook);
            }
        });
        pieceMap.put(PAWN, new EnumMap<>(PieceColor.class) {
            {
                put(WHITE, whitePawn);
            }

            {
                put(BLACK, blackPawn);
            }
        });
        pieceMap.put(KNIGHT, new EnumMap<>(PieceColor.class) {
            {
                put(WHITE, whiteKnight);
            }

            {
                put(BLACK, blackKnight);
            }
        });
        pieceMap.put(BISHOP, new EnumMap<>(PieceColor.class) {
            {
                put(WHITE, whiteBishop);
            }

            {
                put(BLACK, blackBishop);
            }
        });
    }

    public Dimension getPreferredSize() {
        return new Dimension((board.getWidth()) * 2 * SIZE + 5, (board.getHeight()) * SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        for (int x = 0; x < board.getWidth(); x++) { // Compensate for OUTSIDE borders
            for (int y = 0; y < board.getHeight(); y++) {
                Color color = ((x + y) % 2 == 0) ? lightSquare : darkSquare;
                g2d.setColor(color);
                g2d.drawRect(x * SIZE, y * SIZE, SIZE, SIZE);
                g2d.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
            }
        }
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                Point temp = new Point(x,y);
                if (board.getSquareAt(temp) != EMPTY) {
                    pieceMap.get(board.getSquareAt(temp)).get(board.getColorAt(temp)).
                            paintIcon(this, g, x * SIZE, y * SIZE);
                }
            }
        }
        g2d.setColor(Color.BLACK);
        g2d.drawRect(8 * SIZE, 0, 5, 8 * SIZE);
        g2d.fillRect(8 * SIZE, 0, 5, 8 * SIZE);

    }
}



