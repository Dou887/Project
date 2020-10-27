package Main;

public class Game {


    public Game() {

    }
    public void create(){
        Board board = new Board();
        ChessComponent viewer = new ChessComponent(board);
    }




    public static void main(String[] args) {

    }
}
