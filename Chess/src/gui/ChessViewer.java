package gui;

import main.Board;
import main.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ChessViewer implements MouseListener {
    private final JFrame frame;
    private final ChessComponent chessComponent;
    private final FrontPage frontPage;
    private final int mode = 0;
    private Game game;
    private Point startSquare = null;
    private Point endSquare = null;

    public ChessViewer(final Game game) {
        frame = new JFrame("Chess");
        chessComponent = new ChessComponent(game.getBoard());
        frontPage = new FrontPage();
        chessComponent.addMouseListener(this);
        this.game = game;
    }
    public void show(){
        if(mode==0) {
            frame.setLayout(new BorderLayout());
            frame.add(chessComponent, BorderLayout.CENTER);
            frame.pack();
            chessComponent.setFont(new Font("monospaced", Font.PLAIN, 20));
            frame.setVisible(true);
        }
        else {
            frame.setLayout(new BorderLayout());
            frame.add(frontPage, BorderLayout.CENTER);
            frontPage.setFont(new Font("monospaced", Font.PLAIN, 20));
            frame.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX()/60;
        int y = e.getY()/60;

        if((startSquare == null || endSquare != null) && !game.getBoard().isEmpty(new Point(x,y))){
            startSquare = new Point(x,y);
        }
        else{
            endSquare = new Point(x,y);
            game.playerMove(game.getPlayerInTurn(), startSquare, endSquare);
            startSquare = null;
            endSquare = null;
            chessComponent.repaint();
        }
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
