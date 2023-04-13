import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Calculator\n");
        System.out.println("Pick an operator: + - * / % \n");
        char sign = sc.next().charAt(0);

        System.out.println("Enter First Number: ");
        int n1 = sc.nextInt();

        System.out.println("Enter Second Number: ");
        int n2 = sc.nextInt();

        double sum = n1 + n2;
        double dif = n1 - n2;
        double prod = n1 * n2;
        double quo = n1 / n2;
        double mod = n1 % n2;

        switch(sign){
            case '+'  : System.out.println("Sum : " + sum);
            break;
            case '-'  : System.out.println("Difference : " + dif);
            break;
            case '*'  : System.out.println("Product : " + prod);
            break;
            case '/'  : System.out.println("Quotient : " + quo);
            break;
            case '%'  : System.out.println("Modulo : " + mod);
            break;
        }
    }
}
