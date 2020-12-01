package main;

import gui.ChessViewer;
import pieces.Piece;

import player.HumanPlayer;
import player.Player;
import sound.Sound;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static pieces.PieceColor.BLACK;
import static pieces.PieceColor.WHITE;
public class Game  {

    private final List<Move> movesPlayed;
    private final Player[] players;
    private Player playerInTurn;
    private Board board;
    private Point startSquare = null;
    private Point endSquare = null;

    public Game() {
        this.movesPlayed = new ArrayList<>();
        this.players = new Player[2];
        board = new Board();
        board.side(WHITE);
    }

    public Board getBoard() {
        return board;
    }

    public void init(Player player1, Player player2){
        players[0] = player1;
        players[1] = player2;
        playerInTurn = players[0];
        player1.setPieceColor(WHITE);
        player2.setPieceColor(BLACK);

    }

    public Player getPlayerInTurn() {
        return playerInTurn;
    }

    public boolean playerMove(Player player, Point startSquare, Point endSquare){
        // might need to convert pixel to board square
        Move move = new Move(this.board,player, startSquare, endSquare);
        return makeMove(player,move);
    }

    public boolean makeMove(Player player, Move move){
        Piece sourcePiece = move.getSourcePiece();
        Piece destPiece = move.getDestPiece();
        // selected an invalid square
        if(sourcePiece == null){
            System.out.println("got no piece");
            return false;
        }
        // check if the right player is making a move
        if(playerInTurn.getPieceColor() != sourcePiece.color()){
            System.out.println("wrong dude");
            return false;
        }
        if(move.isCastlingMove()){
            move.setCastlingMove();

        }
        if(!move.isValidMove()){
            return false;
        }
        move.piece(move.getStartSquare(), move.getEndSquare());
        movesPlayed.add(move);
        playerInTurn = playerInTurn == players[0] ? players[1] : players[0];
        if(move.isPawnPromoting()){
            move.setPawnPromoting();

        }

        System.out.println(playerInTurn);
        return true;
    }


    public static void main(String[] args) {
        boolean running = true;
        boolean inGame = true;
        Board board = new Board();
        board.side(WHITE);

        Player player1 = new HumanPlayer("Douglas");
        Player player2 = new HumanPlayer("Arnold");
        Game game = new Game();
        game.init(player1, player2);
        ChessViewer chessViewer = new ChessViewer(game);
        chessViewer.show();



    }
}
