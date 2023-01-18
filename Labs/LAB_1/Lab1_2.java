import java.util.Scanner;
public class Lab1_2{
    public static void main(String[] args) {
        double gpa = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students = ");
        int studentNum = input.nextInt();

        for ( int i = 0; i < studentNum; i++ ){
            System.out.println("Enter the grades");
            String grade = input.next();
            switch (grade){
                case "A+":
                    gpa = gpa + 4.00;
                    break;
                case "A":
                    gpa = gpa + 3.75;
                    break;
                case "B+":
                    gpa = gpa + 3.50;
                    break;
                case "B":
                    gpa = gpa + 3.00;
                    break;
                case "C+":
                    gpa = gpa + 2.50;
                    break;
                case "C":
                    gpa = gpa + 2.00;
                    break;
            }
        }
        System.out.println("The GPA is: " + (gpa / studentNum));
    }
}