package gui;

import main.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ChessViewer {
    private final JFrame frame;
    private final ChessComponent chessComponent;
    private final FrontPage frontPage;
    private final Game game;
    private Point startSquare = null;
    private Point endSquare = null;
    private int mode = 0;



    public ChessViewer(final Game game) {
        frame = new JFrame("Chess");
        chessComponent = new ChessComponent(game);
        frontPage = new FrontPage();
        this.game = game;

    }
    public void show(){
        if(mode ==0) {
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


}
