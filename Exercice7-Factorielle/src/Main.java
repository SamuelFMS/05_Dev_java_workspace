//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * Function that return the factorial of n
     * @param n
     * @return
     */
    public static int factorielle(int n){
        if(n==1){
            System.out.print(n);
            return n;
        }
        System.out.print(n +" x ");
        return n * factorielle(n-1);
    }

    /**
     * Main function to test the factorial function
     * @param args
     */
    public static void main(String[] args) {
        int res=factorielle(5);
        System.out.println(" = " + res);

        res=factorielle(4);
        System.out.println(" = " + res);

        res=factorielle(3);
        System.out.println(" = " + res);

        res=factorielle(2);
        System.out.println(" = " + res);

        res=factorielle(1);
        System.out.println(" = " + res);

    }
}