import java.util.Random;
import java.util.Scanner;

public class q1 {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    private static String normalizeMove(String move) {
        for (String validMove : MOVES) {
            if (validMove.equalsIgnoreCase(move.trim())) {
                return validMove;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        final int rounds = 5;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter your move for round " + (i + 1) + " (Rock, Paper, Scissors): ");
            String playerMove = normalizeMove(scanner.nextLine());
            while (playerMove == null) {
                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                playerMove = normalizeMove(scanner.nextLine());
            }

            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%d | %s | %s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        double winPercentage = wins * 100.0 / rounds;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        scanner.close();
    }
}
