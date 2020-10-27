package Main;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ChessComponent extends JComponent {

    private Board board;
    private JFrame frame;
    private final static int SIZE = 60; // Pixels per square
    private Map<PieceType, Map<PieceColor, ImageIcon>> iconMap = new HashMap<>();
    private final ImageIcon blackKing = new ImageIcon(ClassLoader.getSystemResource("king_black.png"));
    private final ImageIcon whiteKing = new ImageIcon(ClassLoader.getSystemResource("king_white.png"));
    private final ImageIcon blackQueen = new ImageIcon(ClassLoader.getSystemResource("queen_black.png"));
    private final ImageIcon whiteQueen = new ImageIcon(ClassLoader.getSystemResource("queen_white.png"));
    private final ImageIcon blackBishop = new ImageIcon(ClassLoader.getSystemResource("bishop_black.png"));
    private final ImageIcon whiteBishop = new ImageIcon(ClassLoader.getSystemResource("bishop_white.png"));
    private final ImageIcon blackKnight = new ImageIcon(ClassLoader.getSystemResource("knight_black.png"));
    private final ImageIcon whiteKnight = new ImageIcon(ClassLoader.getSystemResource("knight_white.png"));
    private final ImageIcon blackRook = new ImageIcon(ClassLoader.getSystemResource("rook_black.png"));
    private final ImageIcon whiteRook = new ImageIcon(ClassLoader.getSystemResource("rook_white.png"));
    private final ImageIcon blackPawn = new ImageIcon(ClassLoader.getSystemResource("pawn_black.png"));
    private final ImageIcon whitePawn = new ImageIcon(ClassLoader.getSystemResource("pawn_white.png"));

    public ChessComponent(final Board board) {
        this.board = board;
        this.frame = new JFrame("Chess");

        iconMap.put(PieceType.KING, new HashMap() // According to code analysis this could use EnumMap
                // No perfomance issue noticed.
        {
            {put(PieceColor.WHITE, whiteKing);}

            {put(PieceColor.BLACK, blackKing);}
        });
        iconMap.put(PieceType.QUEEN, new HashMap()
        {
            {put(PieceColor.WHITE, whiteQueen);}

            {put(PieceColor.BLACK, blackQueen);}
        });
        iconMap.put(PieceType.BISHOP, new HashMap()
        {
            {put(PieceColor.WHITE, whiteBishop);}

            {put(PieceColor.BLACK, blackBishop);}
        });
        iconMap.put(PieceType.KNIGHT, new HashMap()
        {
            {put(PieceColor.WHITE, whiteKnight);}

            {put(PieceColor.BLACK, blackKnight);}
        });
        iconMap.put(PieceType.ROOK, new HashMap()
        {
            {put(PieceColor.WHITE, whiteRook);}

            {put(PieceColor.BLACK, blackRook);}
        });
        iconMap.put(PieceType.PAWN, new HashMap()
        {
            {put(PieceColor.WHITE, whitePawn);}

            {put(PieceColor.BLACK, blackPawn);}
        });

    }

    public Dimension getPreferredSize() {
        return new Dimension((board.getWidth()) * SIZE, (board.getHeight()) * SIZE);
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;
        for (int x = 0; x < board.getWidth(); x++) { // Compensate for OUTSIDE borders
            for (int y = 0; y < board.getHeight(); y++) {
                if ((x + y) % 2 == 0) {
                    g2d.setColor(new Color(247, 222, 140)); //COLOR = BEIGE
                } else {
                    g2d.setColor(new Color(178, 128, 54)); // COLOR = BROWN
                }
                g2d.drawRect(x * SIZE, y * SIZE, SIZE, SIZE);
                g2d.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
            }
        }

        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (board.getSquareAt(x,y) != PieceType.EMPTY) {
                    iconMap.get(board.getSquareAt(x, y)).get(board.getColorAt(x, y)).paintIcon(this, g, x * SIZE, y * SIZE);
                }
            }
        }
    }

}

