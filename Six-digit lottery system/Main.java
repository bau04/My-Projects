import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the 2-digit lottery draw");
        System.out.println("Choose a number from 0-9");

        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int n3 = sc.nextInt();

        System.out.print("Enter fourth number: ");
        int n4 = sc.nextInt();

        System.out.print("Enter fifth number: ");
        int n5 = sc.nextInt();

        System.out.print("Enter sixth number: ");
        int n6 = sc.nextInt();

        Random random = new Random();

        int x1 = random.nextInt(0, 9);
        int x2 = random.nextInt(0, 9);
        int x3 = random.nextInt(0, 9);
        int x4 = random.nextInt(0, 9);
        int x5 = random.nextInt(0, 9);
        int x6 = random.nextInt(0, 9);

        String W = "Winning number: " + x1 + " , " + x2 + " , " + x3 + " , " + x4 + " , " + x5 + " , " + x6;
        String P = "     Your pick: " + n1 + " , " + n2 + " , " + n3 + " , " + n4 + " , " + n5 + " , " + n6;

        if (n1 == x1 && n2 == x2 && n3 == x3 && n4 == x4 && n5 == x5 && n6 == x6){
            System.out.println("\nToday's lottery result is: ");
            System.out.println(W);
            System.out.println(P);
            System.out.println("        Result: You Won!!!");
        }

        if (n1 <= -1 || n2 <= -1 || n3 <= -1 || n4 <= -1 || n5 <= -1 || n6 <= -1){
            System.out.println("Error: The number you entered is below the range");
        }

        if (n1 >= 10 || n2 >= 10 || n3 >= 10 || n4 >= 10 || n5 >= 10 || n6 >= 10){
            System.out.println("Error: The number you entered is above the range");
        }

        if (n1 != x1 && n2 != x2 && n3 != x3 && n4 != x4 && n5 != x5 && n6 != x6){
            System.out.println("\nToday's lottery result is: ");
            System.out.println(W);
            System.out.println(P);
            System.out.println("        Result: You lost!");
        }

        else {
            System.out.println("\nToday's lottery result is: ");
            System.out.println(W);
            System.out.println(P);
            System.out.println("        Result: You lost!");
        }

    }
}
