package pieces;

import pieces.*;

import java.util.ArrayList;
import java.util.List;

import static pieces.PieceColor.*;

public class PieceSet {
    private final List<Piece> listOfPieces = new ArrayList<>();

    public PieceSet(PieceColor pieceColor) {
        PieceColor color1 = pieceColor == WHITE ? BLACK : WHITE;
        PieceColor color2 = pieceColor == BLACK? BLACK : WHITE;

        listOfPieces.add(new Rook(color1, 0, 0, false));
        listOfPieces.add(new Rook(color1, 7, 0, false));

        listOfPieces.add(new Bishop(color1, 2, 0, false));
        listOfPieces.add(new Bishop(color1, 5, 0, false));

        listOfPieces.add(new Knight(color1, 1, 0, false));
        listOfPieces.add(new Knight(color1, 6, 0, false));

        listOfPieces.add(new Queen(color1, 3, 0, false));
        listOfPieces.add(new King(color1, 4, 0, false));


        listOfPieces.add(new Rook(color2, 0, 7, false));
        listOfPieces.add(new Rook(color2, 7, 7, false));

        listOfPieces.add(new Bishop(color2, 2, 7, false));
        listOfPieces.add(new Bishop(color2, 5, 7, false));

        listOfPieces.add(new Knight(color2, 1, 7, false));
        listOfPieces.add(new Knight(color2, 6, 7, false));

        listOfPieces.add(new Queen(color2, 3, 7, false));
        listOfPieces.add(new King(color2, 4, 7, false));

        for (int x = 0; x < 8; x++) {
            listOfPieces.add(new Pawn(color1, x, 1, false));
            listOfPieces.add(new Pawn(color2, x, 6, false));
        }



    }

    public List<Piece> list(){
        return listOfPieces;
    }

}
