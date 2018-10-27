import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int HUMAN = 1;
    public static final int COMPU = 2;


    public Cell humanMove;
    public Cell compuMove;

    public int[][] board = new int[3][3];

    public boolean isGameFinished() {
        return getEmptyCells().isEmpty() || hasWon(HUMAN) || hasWon(COMPU);
    }

    public boolean hasWon(int player) {
        //row
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player)
                    &&(board[i][1] == player)
                && (board[i][2] == player))
        {
            return true;
        }
        ;

        //column
        for (int i = 0; i < 3; i++)
            if ((board[0][i] == player)
                    &&(board[1][i] == player)
                && (board[2][i] == player))
        {
            return true;
        }
        ;

        //diagon
        if ((board[0][0] == player)
                && (board[1][1] == player)
                && (board[2][2] == player)) {
            return true;
        }
        if ((board[0][2] == player)
                &&(board[1][1] == player)
                && (board[2][0] == player))
        {
            return true;
        }
        return false;
    }

    public List<Cell> getEmptyCells() {
        List<Cell> emptyCells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 0)
                    emptyCells.add(new Cell(i, j));
        }

        return emptyCells;
    }

    public boolean makeMove(Cell cell, int player) {
        if (board[cell.x][cell.y] == 0) {
            board[cell.x][cell.y] = player;
            return true;
        } else {
            return false;
        }
    }

    public void displayBoard() {
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String value = "?";

                if (board[i][j] == HUMAN)
                    value = "X";
                else if (board[i][j] == COMPU)
                    value = "O";

                System.out.print(value + " ");
            }

            System.out.println();
        }

        System.out.println();

    }

    public int miniMax(int depth, int turn) {
        if (hasWon(HUMAN))
            return 1;
        if (hasWon(COMPU))
            return -1;

        List<Cell> emptyCells = getEmptyCells();

        if (emptyCells.isEmpty())
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < emptyCells.size(); i++) {
            Cell cell = emptyCells.get(i);

            if (turn == HUMAN) {
                makeMove(cell, HUMAN);
                int currentScore = miniMax(depth + 1, COMPU);
                max = Math.max(currentScore, max);

                if (depth == 0)
                    System.out.println(" Computer score for position " + cell + " = " + currentScore);

                if (currentScore >= 0)
                    if (depth == 0)
                        compuMove = cell;

                if (currentScore == 1) {
                    board[cell.x][cell.y] = 0;
                    break;
                }

                if ((i == emptyCells.size() - 1) && max < 0)
                    if (depth == 0)
                        compuMove = cell;

            } else if (turn == COMPU) {
                makeMove(cell, COMPU);
                int currentScore = miniMax(depth + 1, HUMAN);
                min = Math.min(currentScore, min);

                if (min == -1) {
                    board[cell.x][cell.y] = 0;
                    break;
                }

            }

            board[cell.x][cell.y] = 0;

        }

        return turn == HUMAN ? max : min;

    }
}
