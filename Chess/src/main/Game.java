package main;

import gui.ChessViewer;
import pieces.PieceColor;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Move> movesPlayed= new ArrayList<>();
    private Player[] players;
    private Player playerInTurn;


    public Game(Board board) {
    }

    public void init(Player player1, Player player2){
        players[0] = player1;
        players[1] = player2;

        //chose side
    }

    public boolean makeMove(Player player, Move move){

        return false;
    }

    public static void main(String[] args) {
        boolean running = true;
        boolean inGame = true;
        Board board = new Board();
        ChessViewer chessViewer = new ChessViewer(board);
        board.side(PieceColor.BLACK);
        chessViewer.show();
        Game game = new Game(board);
        while(running){
            //Front page
            // give the user option to leave the game
            //Ask the user some questions
            // solo or multi

            // if solo => chose color to be, maybe chose the difficulty
            // create board of depending the chooses before
            // if multi connect to server

            board.side(PieceColor.BLACK);
            while(inGame){

                //Ask player in turn to move
                // if it is checkmate break
                // store result
                //Ask for a rematch
                // no => break
            }
        }
    }
}
