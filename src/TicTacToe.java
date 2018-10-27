import java.util.Scanner;
import java.util.Random;


public class TicTacToe {

    public static final Random RANDOM = new Random();

    public static void main (String[] args){

        Board game = new Board();
        Scanner scanner = new Scanner(System.in);
        game.displayBoard(); //
        System.out.println("Select turn:\n1. Computer (X) / 2. User (0): ");

        int choice = scanner.nextInt();

        if (choice == Board.HUMAN) {
            Cell cell = new Cell(RANDOM.nextInt(3), RANDOM.nextInt(3));
            game.makeMove(cell, Board.HUMAN);
            game.displayBoard();
        }

        while (!game.isGameFinished()){
            boolean validMove = true;

            do {
                if(!validMove){
                    System.out.println("Invalid move");
                }

                System.out.println();
                Cell turnMove = new Cell (scanner.nextInt(), scanner.nextInt());
                validMove = game.makeMove(turnMove, Board.COMPU);


            } while(!validMove);

            game.displayBoard();

            if (game.isGameFinished())
                break;

            game.miniMax(0, game.HUMAN);
            System.out.println("Computer choice: " + game.compuMove);

            game.makeMove(game.compuMove, Board.HUMAN);
            game.displayBoard();
        }

        if (game.hasWon(Board.HUMAN))
            System.out.println("You lost");
        else if (game.hasWon(Board.COMPU))
            System.out.println("You won");
        else
            System.out.println("Draw");

    }
}

