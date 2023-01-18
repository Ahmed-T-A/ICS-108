
import java.util.Scanner;
public class Lab2 {

     // converting letter grade to Number method.
     public static double letterGrade2Numberic(String grade) {
        double gradeNum = 0.00;
        switch (grade){
            case "A+":  gradeNum = 4.00;    break;
            case "A" :  gradeNum = 3.75;    break;
            case "B+":  gradeNum = 3.50;    break;
            case "B" :  gradeNum = 3.00;    break;
            case "C+":  gradeNum = 2.50;    break;
            case "C" :  gradeNum = 2.00;    break;
            case "D+":  gradeNum = 1.50;    break;
            case "D" :  gradeNum = 1.00;    break;
            case "F" :  gradeNum = 0.00;
        }
        return gradeNum;
    }
    public static void main(String[] args) {
       
        try (// reading the student Number:
        Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the number of student: ");
            int studentNum = input.nextInt();
            //-----------------------------------------
            // reading the grades:
            double gpa = 0;
            for(int i = 0; i < studentNum; i++){
                String grade = input.next();
                double numGrade = letterGrade2Numberic(grade);
                gpa = gpa + numGrade;
            }
            //-----------------------------------------
            System.out.println("GPA = " + (gpa / studentNum));
        }
        }
        
    }

