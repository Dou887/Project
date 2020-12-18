package gui;

import main.Board;
import main.Game;
import pieces.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EnumMap;
import java.util.Vector;

import static pieces.PieceColor.*;
import static pieces.PieceType.*;

public class ChessComponent extends JComponent implements MouseListener {

    private final Game game;
    private final static int SIZE = 60; // Pixels per square
    private final EnumMap<PieceType, EnumMap<PieceColor, ImageIcon>> pieceMap = new EnumMap<>(PieceType.class);
    private final Color lightSquare = new Color(247, 222, 140);
    private final Color darkSquare = new Color(178, 128, 54);
    private Point startSquare = null;
    private Point endSquare = null;
    private String alpha = "abcdefgh";

    public ChessComponent(final Game game) {
        this.game = game;
        this.loadImage();
        this.addMouseListener(this);
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
        return new Dimension((game.getBoard().getWidth()) * 2 * SIZE , (game.getBoard().getHeight()) * SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        for (int x = 0; x < game.getBoard().getWidth(); x++) { // Compensate for OUTSIDE borders
            for (int y = 0; y < game.getBoard().getHeight(); y++) {
                Color color1 = ((x + y) % 2 == 0) ? lightSquare : darkSquare;

                g2d.setColor(color1);
                g2d.drawRect(x * SIZE, y * SIZE, SIZE, SIZE);
                g2d.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
                if(x==0){
                    Color color2 = (y % 2 == 0) ? darkSquare: lightSquare;
                    g2d.setColor(color2);
                    Font font = new Font("arial", Font.BOLD,18);
                    g2d.setFont(font);
                    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    g2d.drawString(String.valueOf(y+1),x * SIZE, (y+1) * SIZE-42);
                }
                if(y==7){
                    Color color2 = (x % 2 == 0) ? lightSquare: darkSquare;

                    g2d.setColor(color2);

                    Font font = new Font("arial", Font.BOLD,18);
                    g2d.setFont(font);
                    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    g2d.drawString(String.valueOf(alpha.charAt(x)),(x) * SIZE+45,(y+1) * SIZE);
                }
            }
        }
        if(startSquare != null && game.getBoard().getSquare(startSquare).color() ==
                game.getPlayerInTurn().getPieceColor()){
            g2d.setColor(new Color(0,102,0,150));
            g2d.drawRect(startSquare.x * SIZE, startSquare.y * SIZE, SIZE, SIZE);
            g2d.fillRect(startSquare.x * SIZE, startSquare.y * SIZE, SIZE, SIZE);
        }
        for (int x = 0; x < game.getBoard().getWidth(); x++) {
            for (int y = 0; y < game.getBoard().getHeight(); y++) {
                Point temp = new Point(x,y);
                if (game.getBoard().getSquareAt(temp) != EMPTY) {
                    pieceMap.get(game.getBoard().getSquareAt(temp)).get(game.getBoard().getColorAt(temp)).
                            paintIcon(this, g, x * SIZE, y * SIZE);
                }
            }
        }
        g2d.setColor(Color.BLACK);
        g2d.drawRect(8 * SIZE, 0, 2, 8 * SIZE+20);
        g2d.fillRect(8 * SIZE, 0, 2, 8 * SIZE+20);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 60;
        int y = e.getY() / 60;
        Point temp = new Point(x,y);
        if((startSquare == null || endSquare != null) && !game.getBoard().isEmpty(temp)) {
            if(game.getBoard().getSquare(temp).color() == game.getPlayerInTurn().getPieceColor()){
                startSquare = temp;
                this.repaint();
            }
        } else {
            endSquare = new Point(x, y);
            game.playerMove(game.getPlayerInTurn(), startSquare, endSquare);
            startSquare = null;
            endSquare = null;
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}



