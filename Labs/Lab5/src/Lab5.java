import java.util.Scanner;
public class Lab5 {
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       //----------------------------------------
       // Reading the (x,y) of the second point:
       System.out.print("Enter the x coordinate of the second point = "); 
       double x1 = input.nextDouble();
       System.out.print("Enter the y coordinate of the second point = "); 
       double y1 = input.nextDouble();
       double distance1;
       //---------------------------------------- 
       // Create the objects of class Point:
       Point point0 = new Point();
       Point point1 = new Point(x1,y1);
       //----------------------------------------
       // Calculate the distance:
       distance1 = point0.distance(point1);
       System.out.printf("The distance between (0.0,0.0) and (" + point1.getX() + "," + point1.getY() + ") is = %.2f\n" , distance1);
       System.out.println("*********************************************************");
    } 
}
