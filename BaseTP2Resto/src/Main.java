import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Integer inputInteger(Scanner scan, int min, int max) {
        Integer number = null;
        Boolean isInputValid = false;
        do {
            String numberString = scan.next();
            try {
                number = Integer.parseInt(numberString.trim());
                if (number >= min && number <= max) {
                    isInputValid = true;
                } else System.out.println("Veuillez saisir un nombre entre " + min + " et " + max);
            } catch (NumberFormatException e) {
                // Gérer l'erreur si le string n'est pas un nombre
                System.out.println("Ce n'est pas un nombre valide !");
            }
        } while(!isInputValid);
        return number;
    }

    public static void displayItemMenu(String[] elements){
        for(int i = 0; i < elements.length; i++){
            System.out.print("["+(i+1)+" - " + elements[i] + "]");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String[] entrys = {"Salade", "Soupe", "Quiche", "Aucune"};
        String[] mainMenus = {"Poulet", "Boeuf", "Poisson", "Végétarien", "Végan", "Aucun"};
        String[] accompaniements = {"Riz", "Pates", "Frites", "Légumes","Aucun"};
        String[] drinks = {"Eau plate", "Eau gazeuze", "soda", "Vin", "Aucune"};
        String[] desserts = {"Tarte maison", "Mousse au chocolat", "Tiramisu", "Aucun"};


        /**
         * Debut du programme
         */
        System.out.println("Bonjour, combien de menus souhaitez vous ?");
        Scanner scanner = new Scanner(System.in);
        int numberOfOrder = inputInteger(scanner, 0, 10);
        for(int numberMenu = 0; numberMenu < numberOfOrder; numberMenu++){
            System.out.println("============================================");
            System.out.println("Commande numéro " + (numberMenu+1));
            System.out.println("============================================");

            // Entry
            int entry = askItem(entrys,"Que souhaitez vous comme entrée ? [Saisir le chiffre correspondant]", scanner)-1;
            int mainMenu =  askItem(mainMenus,"Que souhaitez vous comme plats ? [Saisir le chiffre correspondant]", scanner)-1;
            int accompaniement = askItem(accompaniements,"Que souhaitez vous comme accompagnements ? [Saisir le chiffre correspondant]", scanner)-1;
            int drink = askItem(drinks,"Que souhaitez vous comme boissons ? [Saisir le chiffre correspondant]", scanner)-1;
            int dessert = askItem(desserts,"Que souhaitez vous comme desserts ? [Saisir le chiffre correspondant]", scanner)-1;
            System.out.println("Résumé de la commande " + (numberMenu+1));
            System.out.print("["+entrys[entry]+", ");
            System.out.print(mainMenus[mainMenu] + ", ");
            System.out.print(accompaniements[accompaniement] + ", ");
            System.out.print(drinks[drink] + ", ");
            System.out.println(desserts[dessert] + "]");
            System.out.println("============================================");
        }
        scanner.close();

    }

    private static int askItem(String[] listItem,String question, Scanner scanner) {
        displayItemMenu(listItem);
        System.out.println(question);
        return inputInteger(scanner, 1, listItem.length);
    }
}