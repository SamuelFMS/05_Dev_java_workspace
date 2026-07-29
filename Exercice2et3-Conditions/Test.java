import java.util.Scanner;

public class Test {
    /**
     * Method to display whether the number is positive or negative and whether it is even or odd.
     *
     * @param numero
     */
    static void debugNumber(Integer numero) {
        if (numero > 0) {
            System.out.print("Le nombre " + numero + " est positif");
        } else if (numero < 0) {
            System.out.print("Le nombre " + numero + " est négatif");
        } else {
            System.out.print("Le nombre est égale a 0");
        }
        if (numero % 2 == 0) {
            System.out.println(" et pair");
        } else {
            System.out.println(" et impair");
        }
    }

    /**
     * Method for entering an integer
     *
     * @param scan
     * @return
     */
    public static Integer inputInteger(Scanner scan) {
        Integer number = null;
        Boolean isInputValid = false;
        do {
            String numberString = scan.next();
            try {
                number = Integer.parseInt(numberString.trim());
                isInputValid = true;
            } catch (NumberFormatException e) {
                // Gérer l'erreur si le string n'est pas un nombre
                System.out.println("Ce n'est pas un nombre valide !");
            }
        } while(!isInputValid);
        return number;
    }

    /**
     * Method that checks whether or not the string corresponds to an int.
     * @param value
     * @return
     */
    public static boolean isACorrectInt(String value) {
        boolean isANumber = true;
        if (value.startsWith("-")) {
            value = value.substring(1);
        }
        if(value.length() != 0){
            for (int indexChar = 0; indexChar < value.length(); indexChar++) {
                if (value.charAt(indexChar) < '0' || value.charAt(indexChar) > '9') {
                    isANumber = false;
                    break;
                }
            }
        }
        else {
            isANumber = false;
        }
        return isANumber;
    }

    /**
     * Same functon as saisieInteger except it doesnt use try and catch only things seen from lesson
     * @param scan
     * @return
     */
    public static Integer saisieIntegerWithoutTryAndCatch(Scanner scan) {
        boolean isInputCorrect = false;
        Integer nombre = null;
        do {
            String numberString = scan.next();
            if (isACorrectInt(numberString)) {
                nombre = Integer.parseInt(numberString);
                isInputCorrect = true;
            } else {
                System.out.println("Votre saisie est incorrecte. Veuillez reesayez");
            }
        } while(!isInputCorrect);
        return nombre;

    }

    /**
     * Main method if args then debug the number passed on the args
     * otherwise ask a integer to the user and debug the number
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello!");
        if (args.length >= 1) {
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                try {
                    Integer number = Integer.parseInt(arg.trim());
                    debugNumber(number);
                } catch (NumberFormatException e) {
                    // Gérer l'erreur si le string n'est pas un nombre
                    System.out.println("Ce n'est pas un nombre valide !");

                }
            }
        } else {
            System.out.println("Quel est votre numéro ? ");
            Scanner scan = new Scanner(System.in);
            Integer number = saisieIntegerWithoutTryAndCatch(scan);
            System.out.println("Vous avez saisi: " + number);
            debugNumber(number);
            scan.close();
        }
    }
}