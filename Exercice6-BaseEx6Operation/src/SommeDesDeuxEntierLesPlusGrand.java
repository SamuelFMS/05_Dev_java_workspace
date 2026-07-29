import java.util.Arrays;

public class SommeDesDeuxEntierLesPlusGrand {
    public static Integer sommeDesDeuxEntiersLesPlusGrand(int[] array) {
        if(array.length < 2) {
            return null;
        }
        int[] copiesArray = array.clone();
        for(int i = 1; i <= 2;i++){
            for(int j = i; j < copiesArray.length; j++){
                if(copiesArray[i-1] < copiesArray[j]){
                    int temp = copiesArray[j];
                    copiesArray[j] = copiesArray[i-1];
                    copiesArray[i-1] = temp;
                }
            }
        }
        return copiesArray[0]+copiesArray[1];
    }

    public static void main(String[] args) {
        int[] array = {5,10,50,30,20,10,50};
        System.out.println(sommeDesDeuxEntiersLesPlusGrand(array));
        int[] array2 = {5,10};
        System.out.println(sommeDesDeuxEntiersLesPlusGrand(array2));
        int[] array3 = {5};
        System.out.println(sommeDesDeuxEntiersLesPlusGrand(array3));
        int[] array4 = {78, 6, -250, 2, 12, 9};
        System.out.println(sommeDesDeuxEntiersLesPlusGrand(array4));
    }
}
