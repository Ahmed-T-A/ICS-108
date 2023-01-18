import java.util.Scanner;
public class Lab1_1{
    public static void main(String[] args) {
       
        double area;
        Scanner input = new Scanner(System.in); 

        System.out.print("Enter The number of sides = ");
        int n = input.nextInt();

        System.out.print("Enter the length of a side = ");
        double s = input.nextDouble();

        area = (n * s * s) / (4 * (Math.tan( Math.PI / n )));
        System.out.println("The area is = " + area);
    }

}