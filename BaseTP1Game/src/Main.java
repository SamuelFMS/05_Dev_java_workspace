import java.util.Scanner;

public class Main {
    /**
     * Function returning a number entered by the user between 0 and 100
     *
     * @param scan
     * @return Integer
     */
    public static Integer inputInteger(Scanner scan) {
        Integer number = null;
        Boolean isInputValid = false;
        do {
            String numberString = scan.next();
            try {
                number = Integer.parseInt(numberString.trim());
                if (number >= 0 && number <= 100) {
                    isInputValid = true;
                } else System.out.println("Le nombre doit etre compris entre 0 et 100");
            } catch (NumberFormatException e) {
                // Gérer l'erreur si le string n'est pas un nombre
                System.out.println("Ce n'est pas un nombre valide !");
            }
        } while(!isInputValid);
        return number;
    }


    /**
     * Main method for playing a game
     *
     * @param scan
     */
    public static void game(Scanner scan) {
        Integer randomNumber = (int) (Math.random() * 100);
        Integer numberRound = 1;

        System.out.println("Saisissez une valeur comprise entre 0 et 100");
        Integer userNumber = inputInteger(scan);

        while (userNumber != randomNumber) {
            if (userNumber > randomNumber) {
                System.out.println("Saisissez une valeur plus petite");
            }
            if (userNumber < randomNumber) {
                System.out.println("Saisissez une valeur plus grande");
            }
            userNumber = inputInteger(scan);
            numberRound++;
        }
        System.out.println("Vous avez trouvez le nombre, Bravo ! En " + numberRound + " Tours.");
    }

    /**
     * The main method asks the user if they want to play my game.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("Voulez vous jouez qa un jeu (y/n): ");

            switch (scan.next()) {
                case "y":
                    game(scan);
                    gameRunning = false;
                    break;
                case "n":
                    gameRunning = false;
                    break;
                default:
                    System.out.println("La saisi est incorrecte");
                    break;
            }
        }
        scan.close();
    }
}