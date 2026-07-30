import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Number of people participating in the tournament
     */
    public static int numberOfParticipant = 4;
    /**
     * Array of array score against each player
     */
    public static int[][] score = new int[numberOfParticipant][numberOfParticipant];
    /**
     * Number of points given on a Win
     */
    public static int SCORE_PER_WIN = 3;
    /**
     * Number of points given on a Draw
     */
    public static int SCORE_PER_DRAW = 1;
    /**
     * Contain a List of all the pseudonym of each participant
     */
    protected static ArrayList<String> pseudonymOfParticipant = new ArrayList<String>();

    /**
     * Entry's of the nicknames of all tournament participants.
     *
     * @param scanner
     */
    public static void inputPseudonymOfParticipant(Scanner scanner) {
        while (pseudonymOfParticipant.size() < numberOfParticipant) {
            System.out.println("Saisir le pseudonyme du participant n°" + (pseudonymOfParticipant.size() + 1));
            String pseudonym = scanner.next();
            if (!pseudonymOfParticipant.contains(pseudonym)) {
                pseudonymOfParticipant.add(pseudonym);
            } else {
                System.out.println("Ce pseudo a deja ete saisie");
            }
        }
    }

    /**
     * Determines who won a match based on user input.
     *
     * @param scanner
     * @param i
     * @param j
     * @return
     */
    public static StateMatch whoWon(Scanner scanner, int i, int j) {
        StateMatch state = null;
        while (state == null) {
            String input = scanner.next();
            if (input.equals(Integer.toString(i + 1))) {
                state = StateMatch.IWon;
            } else if (input.equals(Integer.toString(j + 1))) {
                state = StateMatch.JWon;
            } else if (input.equals("0")) {
                state = StateMatch.Draw;
            } else {
                System.out.println("La saisie est incorrecte");
            }
        }
        return state;
    }

    /**
     * Enter all data for each match and to carry them out.
     *
     * @param scanner
     */
    public static void inputAllMatch(Scanner scanner) {
        for (int i = 0; i < numberOfParticipant - 1; i++) {
            for (int j = i + 1; j < numberOfParticipant; j++) {
                System.out.print("Joueur " + (i + 1) + "(" + pseudonymOfParticipant.get(i) + ")");
                System.out.print(" vs ");
                System.out.println("Joueur " + (j + 1) + "(" + pseudonymOfParticipant.get(j) + ")");

                System.out.print("Veuillez saisir le gagnant du match " + (i + 1) + " pour " + pseudonymOfParticipant.get(i));
                System.out.print(" et " + (j + 1) + " pour " + pseudonymOfParticipant.get(j));
                System.out.println(" et 0 pour une égalité");
                StateMatch state = whoWon(scanner, i, j);
                switch (state) {
                    case IWon:
                        score[i][j] = SCORE_PER_WIN;
                        break;
                    case JWon:
                        score[j][i] = SCORE_PER_WIN;
                        break;
                    case Draw:
                        score[i][j] = SCORE_PER_DRAW;
                        score[j][i] = SCORE_PER_DRAW;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Calculates a player's total score.
     *
     * @param player
     * @return
     */
    public static int calculateScore(int player) {
        int res = 0;
        for (int x = 0; x < numberOfParticipant; x++) {
            res += score[player][x];
        }
        return res;
    }

    /**
     * Displays the final result
     */
    public static void displayResult() {
        System.out.println("Affichage du classement Finale");
        int[] followedIndex = new int[numberOfParticipant];
        int[] scorePerPlayer = new int[numberOfParticipant];
        // init of my arrays
        for (int x = 0; x < numberOfParticipant; x++) {
            followedIndex[x] = x;
            scorePerPlayer[x] = calculateScore(x);
        }
        // order by who score the most or by who won
        for (int i = 0; i < numberOfParticipant - 1; i++) {
            for (int j = i + 1; j < numberOfParticipant; j++) {
                if (scorePerPlayer[j] == scorePerPlayer[i]) {
                    System.out.println(j + " " + score[j][i]);
                }
                if (scorePerPlayer[j] > scorePerPlayer[i] || (scorePerPlayer[j] == scorePerPlayer[i] && score[followedIndex[j]][followedIndex[i]] == SCORE_PER_WIN)) {
                    int tempScore = scorePerPlayer[j];
                    scorePerPlayer[j] = scorePerPlayer[i];
                    scorePerPlayer[i] = tempScore;

                    int tempIndex = followedIndex[j];
                    followedIndex[j] = followedIndex[i];
                    followedIndex[i] = tempIndex;
                }
            }
        }
        // Display
        for (int i = 0; i < numberOfParticipant; i++) {
            System.out.println("En Position " + i + ": " + pseudonymOfParticipant.get(followedIndex[i]) + " avec " + scorePerPlayer[i] + " points.");
        }
    }

    /**
     * Main program
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input of pseudonym
        inputPseudonymOfParticipant(scanner);
        // Input of Victory or lost
        inputAllMatch(scanner);
        //Display result
        displayResult();
        scanner.close();
    }

    /**
     * Enumerator of each state of a Match so if player a won if player b won or if it's a draw
     */
    enum StateMatch {IWon, JWon, Draw}
}