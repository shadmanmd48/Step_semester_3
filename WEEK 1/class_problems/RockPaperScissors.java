import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        int totalRounds = 5;

        int[] rounds = new int[totalRounds];
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        String[] samplePlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < totalRounds; i++) {
            rounds[i] = i + 1;
            playerMoves[i] = samplePlayerMoves[i];
            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Round " + rounds[i] + " - Player: " + playerMoves[i] +
                               ", Computer: " + computerMoves[i] + " -> " + results[i]);
        }

        System.out.println("\n----------------- SUMMARY TABLE -----------------");
        System.out.printf("%-8s | %-12s | %-14s | %-12s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-12s | %-14s | %-12s%n", rounds[i], playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("-------------------------------------------------");

        double winPercentage = ((double) wins / totalRounds) * 100.0;

        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                totalRounds, wins, losses, draws, winPercentage);
    }
}
