import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int numberOfParticipant = 4;
    public static int[][] score = new int[numberOfParticipant][numberOfParticipant];
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
                System.out.println(" et " + (j + 1) + " pour " + pseudonymOfParticipant.get(j));
                StateMatch state = whoWon(scanner, i, j);
                switch (state) {
                    case IWon:
                        score[i][j] = 1;
                        break;
                    case JWon:
                        score[j][i] = 1;
                        break;
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
                if (scorePerPlayer[j] > scorePerPlayer[i] || (scorePerPlayer[j] == scorePerPlayer[i] && score[j][i] == 1)) {
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
    
    enum StateMatch {IWon, JWon}
}