public class Triangle {
    /**
     * Function that return the same string repeated by count times
     * @param str
     * @param count
     * @return
     */
    public static String repeat(String str, int count) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < count; i++) {
            res.append(str);
        }
        return res.toString();
    }

    /**
     * First way to draw a triangle loop for
     * @param taille
     */
    public static void methodeUne(int taille) {
        for (int i = 0; i < taille; i++) {
            int nbEtoile = i * 2 + 1;
            int espacement = (taille - 1) - i;
            System.out.println(repeat(" ", espacement) + repeat("*", nbEtoile));
        }
    }

    /**
     * A second method using recursion
     * @param actuel
     * @param taille
     */
    public static void methodeDeux(int actuel, int taille) {
        if (actuel >= taille) {
            return;
        }
        int nbEtoile = actuel * 2 + 1;
        int espacement = (taille - 1) - actuel;
        System.out.println(repeat(" ", espacement) + repeat("*", nbEtoile));
        methodeDeux(actuel + 1, taille);
    }

    /**
     * Main program to test the drawing of the two triangles
     * @param args
     */
    public static void main(String[] args) {
        methodeUne(7);
        methodeDeux(0, 7);
    }
}
