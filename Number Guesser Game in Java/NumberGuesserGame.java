import java.util.Scanner;
//import javax.swing.JOptionPane;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);

    System.out.println("Number Guesser Game!");
    System.out.println("Guess a number between 1 and 6");
    System.out.println("Type your number: ");
    int n = sc.nextInt();

    Random random = new Random();

    //Generates random number and the limits of it
    int r = random.nextInt(1,6);


    if(r == n) {
        System.out.println("Your guess is correct!");
        System.out.println("Your answer: " + n)
        System.out.println("Correct Answer: " + r)
    }

    else if(n < 1) {
        System.out.println("Your answer is below the range");
    }

    else if(n > 6) {
        System.out.println("Your answer is above the range");
    }

    else{
        System.out.println("Your guess is wrong. The correct answer is " + r);
    }

    }
} 
