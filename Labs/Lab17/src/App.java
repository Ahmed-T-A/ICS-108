import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // new IllegalArgumentException();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the grade letter: ");
        String grade = input.next();
        try{
            System.out.println("The quality points: " + checkingGrade(grade));
        } catch(IllegalArgumentException e){
            System.out.println("Invalid Grade");
        }
    }
    public static double checkingGrade(String g){
        switch (g){
            case "A+": return 4.00;
            case "A": return 3.75;
            case "B+": return 3.50;
            case "B": return 3.00;
            case "C+": return 2.50;
            case "C":  return 2.00;
            case "D+": return 1.50;
            case "D": return 1.00;
            case "F": return 0.00;
            default: throw new IllegalArgumentException();
        }
    }
}
