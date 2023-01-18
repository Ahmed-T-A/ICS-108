import java.util.Scanner;
import java.util.Arrays;
public class Lab7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //----------------------------------------
        // CREATING THE ARRAY OF SPECIFIC SIZE:
        System.out.print("Enter the number of points you want to enter: ");
        int pointNum = input.nextInt();
        Point[] pointsArray = new Point[pointNum];
        //----------------------------------------
        // ADDING ELEMENT TO THE ARRAY:
        for(int i=0; i < pointsArray.length; i++){
            System.out.print("Enter the x Coordenate of " + (i+1) + " point: ");
            double x = input.nextDouble();
            System.out.print("Enter the y Coordenate of " + (i+1) + " point: "); 
            double y = input.nextDouble(); 
            System.out.println("----");
            pointsArray[i] = new Point(x,y);
        }
        // //----------------------------------------
        // // CALCULATING THE DISTANCE BETWEEN EACH TWO POINTS:
        double perimeter = 0.0 ,distance;
        for(int z = 1; z < pointsArray.length; z++){
            Point firstPoint = pointsArray[z-1];
            Point secondPoint = pointsArray[z];
            distance = firstPoint.distance(secondPoint);
            perimeter += distance;
        }
        perimeter += pointsArray[0].distance(pointsArray[pointsArray.length - 1]);
        //----------------------------------------
        // THE ANSWER: 
        System.out.printf("The perimeter = %.1f \n" , perimeter);
        System.out.println("**************************");
    }
}
