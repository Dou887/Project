package Main;

import java.util.ArrayList;
import java.util.List;

import static Main.PieceColor.BLACK;
import static Main.PieceColor.WHITE;

public class PieceSet {
    private List<Piece> listOfPieces = new ArrayList<Piece>();

    public PieceSet() {

        listOfPieces.add(new Rook(BLACK,0,0,false));
        listOfPieces.add(new Rook(BLACK,7,0,false));

        listOfPieces.add(new Rook(WHITE,0,7,false));
        listOfPieces.add(new Rook(WHITE,7,7,false));

        listOfPieces.add(new Bishop(BLACK,2,0,false));
        listOfPieces.add(new Bishop(BLACK,5,0,false));

        listOfPieces.add(new Bishop(WHITE,2,7,false));
        listOfPieces.add(new Bishop(WHITE,5,7,false));

        listOfPieces.add(new Knight(BLACK,1,0,false));
        listOfPieces.add(new Knight(BLACK,6,0,false));

        listOfPieces.add(new Knight(WHITE,1,7,false));
        listOfPieces.add(new Knight(WHITE,6,7,false));

        listOfPieces.add(new Queen(BLACK,4,0,false));
        listOfPieces.add(new King(BLACK,5,0,false));

        listOfPieces.add(new Queen(WHITE,4,7,false));
        listOfPieces.add(new King(WHITE,5,7,false));

        for(int x = 0; x<8;x++){
            listOfPieces.add(new Pawn(BLACK,x,1,false));
            listOfPieces.add(new Pawn(WHITE,x,6,false));
        }


    }

    public List<Piece> list(){
        return listOfPieces;
    }

}
