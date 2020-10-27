package Main;

import javax.swing.*;
import java.awt.*;

public class ChessViewer {
    private Board board;
    private JFrame frame;
    private ChessComponent chessComponent;

    public ChessViewer(final Board board) {
        this.board = board;
        frame = new JFrame("Chess");
        chessComponent = new ChessComponent(board);

    }

    public void show(){
        frame.setLayout(new BorderLayout());
        frame.add(chessComponent, BorderLayout.CENTER);
        chessComponent.setFont(new Font("monospaced", Font.PLAIN,20));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Board board = new Board();
        ChessViewer chessViewer = new ChessViewer(board);
        chessViewer.show();

    }
}
