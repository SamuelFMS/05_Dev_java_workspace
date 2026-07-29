import Operation.OperationInterface;
import Operation.Additionner;
import Operation.Substract;

public class Matrix {
    public static Integer[] matrixSize(int[][] matrix){
        Integer[] res = new Integer[2];
        int longueur = matrix.length;
        if(longueur == 0) {
            return res;
        }
        int largeur = matrix[0].length;
        for (int i = 1; i < matrix.length; i++){
            if(matrix[i].length != largeur) {
                return res;
            }
        }
        res[0] = longueur;
        res[1] = largeur;
        return res;
    }
    public static boolean identicalMatrix(int[][] matrix1, int[][] matrix2){
        Integer[] res = matrixSize(matrix1);
        Integer[] res2 = matrixSize(matrix2);
        return res[0] != null && res[0] == res2[0] && res[1] == res2[1];
    }
    public static int[][] mul(int f, int[][] matrix){
        int[][] res = new int[matrix.length][];
        for(int x = 0; x < matrix.length; x++) {
            res[x] = new int[matrix[x].length];
            for(int y = 0; y < matrix[x].length; y++){
                res[x][y] = f * matrix[x][y];
            }
        }
        return res;
    }
    public static int[][] add(int[][] matrix1, int[][] matrix2) {
        return operation(matrix1, matrix2, new Additionner());
    }
    public static int[][] sub(int[][] matrix1, int[][] matrix2) {
        return operation(matrix1, matrix2, new Substract());
    }
    private static int[][] operation(int[][] matrix1, int[][] matrix2, OperationInterface operationInterface) {
        int[][] res = null;
        if(!identicalMatrix(matrix1, matrix2)){
            return res;
        }
        Integer[] taille = matrixSize(matrix1);
        Integer longueur = taille[0];
        Integer largeur = taille[1];
        res = new int[longueur][];
        for (int x = 0; x < longueur; x++){
            res[x] = new int[largeur];
            for(int y = 0; y < largeur; y++){
                res[x][y] = operationInterface.calculer(matrix1[x][y], matrix2[x][y]);
            }
        }
        return res;
    }

    public static void displayOperation(int[][] matrix1, int[][] matrix2, int[][] matrixResult, String symbole){
        displayTable(matrix1);
        System.out.println(symbole);
        displayTable(matrix2);
        System.out.println("=");
        displayTable(matrixResult);
    }
    public static void displayOperation(int facteur, int[][] matrix2, int[][] matrixResult, String symbole){
        System.out.println(facteur);
        System.out.println(symbole);
        displayTable(matrix2);
        System.out.println("=");
        displayTable(matrixResult);
    }
    public static void displayTable(int[][] matrix){
        for(int x = 0; x < matrix.length; x++) {
            for(int y = 0; y < matrix[x].length; y++) {
                System.out.print(matrix[x][y] + "  ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        int[][] firstMatrix = {{5,2,4}, {0,1,1}, {6,3,1}};
        int[][] secondMatrix = {{1,1,3}, {2,5,6}, {3,0,5}};
        int[][] thirdMatrix = {{8,7}, {5,4}, {2,1}};
        int[][] fourthMatrix = {{0,2}, {1,2},{1,1}};
        displayOperation(firstMatrix, secondMatrix, add(firstMatrix, secondMatrix), "+");
        System.out.println("------------");
        displayOperation(thirdMatrix, fourthMatrix, sub(thirdMatrix, fourthMatrix), "-");
        System.out.println("------------");
        displayOperation(2, fourthMatrix, mul(2, fourthMatrix), "*");
    }
}
