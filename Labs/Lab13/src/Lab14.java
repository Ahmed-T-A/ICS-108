import java.util.Scanner;
import java.util.Arrays;
public class Lab14 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //----------------------------------------
        // CREATING THE ARRAY OF SPECIFIC SIZE:
        Point[] pointsArray = new Point[6];
        pointsArray[0] = new Point(1,1);
        pointsArray[1] = new Point(4,4);
        pointsArray[2] = new Point(2,2);
        pointsArray[3] = new Point(5,2);
        pointsArray[4] = new Point(7,7);
        pointsArray[5] = new Point(8,0);
        //----------------------------------------
        Point[] pointArrayCopy = new Point[6];
        for (int i = 0; 1 < pointArrayCopy.length; i++){
            Point x = pointsArray[i].clone();
            pointArrayCopy[i] = x;
        }
        //----------------------------------------
        Arrays.sort(pointArrayCopy);
        
    }
}