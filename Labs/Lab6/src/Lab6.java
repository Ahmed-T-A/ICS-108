import java.util.Scanner;
public class Lab6 {
    public static void main(String[] args){
        // Declearing the variables:
        Scanner input = new Scanner(System.in);
        System.out.println("********************");
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        MyInteger number1 = new MyInteger(number);
        //----------------------
        if (MyInteger.isEven(number))
            System.out.println("The number is even.\n");

        else if (MyInteger.isOdd(number)){
            if (MyInteger.isPrime(number))
                System.out.println("The number is a prime.\n");
            else
                System.out.println("The number is Odd.\n");
        } 
        //----------------------
        System.out.print("Enter another number: ");
        int number2 = input.nextInt();
        MyInteger number3 = new MyInteger(number2);
        if (number1.equals(number3)){
            System.out.println("the numbers are equal");
            System.out.println("********************");}
        else{
            System.out.println("The numbers are not equal");
            System.out.println("********************");}
        //----------------------
    }
}
