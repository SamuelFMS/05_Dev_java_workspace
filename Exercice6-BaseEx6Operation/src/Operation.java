public class Operation {
    public static int add(int a, int b) {
        return  a + b;
    }
    public static int sub(int a, int b) {
        return  a - b;
    }
    public static int mul(int a, int b) {
        return  a * b;
    }
    public static Integer div(int a, int b) {
        if(b==0){
            return null;
        }
        return  a / b;
    }

    public static void main(String[] args) {
        System.out.println(add(5,2));
        System.out.println(sub(5,2));
        System.out.println(mul(5,2));
        System.out.println(div(5,2));
        System.out.println(div(3,0));
    }
}
