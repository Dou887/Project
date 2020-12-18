package main;

import gui.ChessViewer;
import pieces.Piece;

import player.HumanPlayer;
import player.Player;
import sound.Sound;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    private GameStatus status = null;

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
            System.out.println("wrong  dude");
            return false;
        }
        if(move.isCastlingMove() && !move.isCheck(playerInTurn.getPieceColor())){
            move.setCastlingMove();

        }
        // Check if it's a valid move for the chosen piece
        else if(!move.isValidMove(move.getStartSquare(), move.getEndSquare())){
            System.out.println("Not a valid move");
            return false;
        }
        move.setPieceKilled(board.getSquare(move.getEndSquare()));
        move.piece(move.getStartSquare(), move.getEndSquare());
        // if is it a pawnpromoting
        if(move.isPawnPromoting()){
            move.setPawnPromoting();

        }
        // Check if it's a self check
        if(move.selfCheck(playerInTurn.getPieceColor())){
            return false;
        }
        // the move check the opponent
        movesPlayed.add(move);
        playerInTurn = playerInTurn == players[0] ? players[1] : players[0];
        if(move.isCheck(playerInTurn.getPieceColor())) {
            System.out.println("#agjagj");
            if (move.isCheckMate(playerInTurn.getPieceColor())) {
                System.out.println("CheckMate");
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean running = true;
        boolean inGame = true;
        Board board = new Board();
        board.side(WHITE);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('B',1);
        map.put('C',2);
        map.put('D',3);
        map.put('E',4);
        map.put('F',5);
        map.put('G',6);
        map.put('H',7);

        System.out.println(map);
        Player player1 = new HumanPlayer("Douglas");
        Player player2 = new HumanPlayer("Arnold");
        Game game = new Game();
        game.init(player1, player2);
        ChessViewer chessViewer = new ChessViewer(game);
        while(true){
            chessViewer.show();
            String name= JOptionPane.showInputDialog(null,"Enter move");
            int y0 = Character.getNumericValue(name.charAt(1));
            Point startSquare = new Point(map.get(name.charAt(0)), y0-1);
            int y = Character.getNumericValue(name.charAt(3));
            Point endSquare = new Point(map.get(name.charAt(2)), y-1);
            System.out.println(startSquare);
            System.out.println(endSquare);
            game.playerMove(game.playerInTurn, startSquare,endSquare);

        }



    }
}
