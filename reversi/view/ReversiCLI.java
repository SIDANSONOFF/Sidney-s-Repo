package reversi.view;

import java.util.Scanner;

import reversi.model.ReversiException;
import reversi.model.Reversi;

/**
 * A simple command line interface for playing a game of Reversi.
 */
public class ReversiCLI {
    /**
     * Used when printing the board; labels the columns.
     */
    private static final String ROW_HEADER = "   0 1 2 3 4 5 6 7\n";

    /**
     * Used when printing the board; separates rows.
     */
    private static final String ROW_SEPARATOR = "  -----------------\n";


    /**
     * Creates a board and plays a game of Reversi.
     * @param args Not used.
     */
    public static void main(String[] args) {
        Reversi board = new Reversi();
        board.start();
        try(Scanner scanner = new Scanner(System.in)) {
            boolean sentinel = true;
            while(sentinel) {
                System.out.println(boardToString(board));
                System.out.println("It is the " + board.getCurrentPlayer() +
                        " player's turn.");
                System.out.print(">> ");
                String[] command = scanner.nextLine().split(" ");
                switch(command[0]) {
                    case "quit":
                        sentinel = !quit(scanner);
                        break;
                    case "move":
                        move(command, board);
                        break;
                    case "pass":
                        pass(board);
                        break;
                    case "help":
                        help();
                        break;
                    default:
                        invalid(command);
                        break;
                }
            }
            System.out.println("Good bye!");
        }
    }

    /**
     * Prints a help message with the available commands.
     */
    private static void help() {
        System.out.println("Available commands: ");
        System.out.println("  help - displays this message");
        System.out.println("  move R C - makes a move for the current player");
        System.out.println("  pass - forfeits this turn");
        System.out.println("  quit - quits the game");
        System.out.println();
    }

    /**
     * Prompts the user to ask if they are sure, and if so, quits the game.
     * @param scanner The scanner used to read the user response.
     * @return True if the game should quit, false if it should not.
     */
    private static boolean quit(Scanner scanner) {
        System.out.print("Are you sure? (y/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }

    /**
     * Attempts to make a move.
     *
     * @param command The split command entered by the user.
     * @param board The board on which the move will be made.
     */
    private static void move(String[] command, Reversi board) {
        if(command.length != 3) {
            System.err.println("Invalid move!");
        } else {
            try {
                int row = Integer.parseInt(command[1]);
                int col = Integer.parseInt(command[2]);
                board.move(row, col);
            } catch(ReversiException bme) {
                System.out.println(bme.getMessage());
            } catch(NumberFormatException nfe) {
                System.out.println("Row and column must be integers.");
            }
        }
    }

    /**
     * Called when the player voluntarily passes their turn.
     * @param board The board on which the current game is being played.
     */
    private static void pass(Reversi board) {
        board.pass();
    }

    /**
     * Displays an invalid command message.
     *
     * @param command The invalid command.
     */
    private static void invalid(String[] command) {
        System.out.println("Invalid command: " + command[0]);
    }
    
    /**
     * Returns a {@link String} representation of the board suitable for
     * printing.
     *
     * @return A {@link String} representation of the board.
     */
    private static String boardToString(Reversi board) {
        // using a string builder is more efficient than concatenation
        // (it also makes the IntelliJ warnings go away)
        StringBuilder builder = new StringBuilder(ROW_HEADER);
        builder.append(ROW_SEPARATOR);
        int column = 0;
        for(int row=0; row<Reversi.ROWS; row++) {
            builder.append(column++);
            builder.append(" ");
            for(int col=0; col<Reversi.COLS; col++) {
                builder.append("|");
                builder.append(board.getSquare(row, col));
            }
            builder.append("|\n");
            builder.append(ROW_SEPARATOR);
        }

        return builder.toString();
    }
}
