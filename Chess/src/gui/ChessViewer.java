package gui;

import main.Board;
import javax.swing.*;
import java.awt.*;

public class ChessViewer {
    private final JFrame frame;
    private final ChessComponent chessComponent;
    private final FrontPage frontPage;
    private final int mode = 0;
    public ChessViewer(final Board board) {
        frame = new JFrame("Chess");
        chessComponent = new ChessComponent(board);
        frontPage = new FrontPage();
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

}
