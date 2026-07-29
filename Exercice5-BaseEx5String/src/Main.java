import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isAPalindrome(String word) {
        // • 5 : Enlever les espaces afin que Elu par cette crapule soit un palindrome
        word = word.replace(" ", "");

        word = word.toUpperCase();

        for (int x = 0; x < word.length() / 2; x++) {
            int y = (word.length() - x) - 1;
            if (word.charAt(x) != word.charAt(y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // - 1 : Trouver plusieurs moyens de concaténer 2 chaînes de type String
        String string1 = "Bonjour ";
        String string2 = "Samuel";
        System.out.println(string1 + string2);
        System.out.println(string1.concat(string2));

        // - 2 : Dans une chaîne(phrase) donnée, trouver s'il existe un mot, si oui, afficher trouvé.
        // ex : "il fait beau aujourd'hui" → mot recherché "Beau" donc trouvé !
        String phrase = "Il fait beau aujourd'hui";
        String search = "beau";
        if (phrase.contains(search)) {
            System.out.println("mot recherché " + search + " trouvé.");
            System.out.println("Dans la phrase " + phrase);
        } else {
            System.out.println("mot recherché " + search + " non trouvé.");
            System.out.println("Dans la phrase " + phrase);
        }

        // • 3 : Reprendre exercice précédent et remplacer le mot si trouvé par un autre saisi par
        // l'utilisateur. ex : "il fait beau aujourd'hui" donne "il fait chaud aujourd'hui"
        String newWord = "chaud";
        String newPhrase = phrase.replace(search, newWord);
        System.out.println(newPhrase);

        // • 4 : Écrire un programme qui dit si une chaîne est un palindrome, ex : akka, ottO
        System.out.println("test is a Palindrome " + isAPalindrome("test"));
        System.out.println("testt is a Palindrome " + isAPalindrome("testt"));
        System.out.println("Radar is a Palindrome " + isAPalindrome("Radar"));
        System.out.println("Kayak is a Palindrome " + isAPalindrome("Kayak"));
        System.out.println("Ressasser is a Palindrome " + isAPalindrome("Ressasser"));
        System.out.println("Rotor is a Palindrome " + isAPalindrome("Rotor"));
        System.out.println("Elu par cette crapule is a Palindrome " + isAPalindrome("Elu par cette crapule"));

    }
}