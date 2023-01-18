import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Student[] students = new Student[6];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < students.length; i++){
            System.out.print("Enter 1 if you want to add Graduate Student and 0 for Undergraduate student: ");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.print("Enter the ID: ");
                int id = input.nextInt();
                System.out.print("Enter the GPA: ");
                double gpa = input.nextDouble();
                System.out.println("---------------");
                Graduate x = new Graduate(id, gpa);
                students[i] = x;
            } 
            else if (choice == 0){
                System.out.print("Enter the ID: ");
                int id = input.nextInt();
                System.out.print("Enter the GPA: ");
                double gpa = input.nextDouble();
                System.out.println("---------------");
                Undergraduate y = new Undergraduate(id, gpa);
                students[i] = y;
            }
            else
                System.out.println("INVALID INPUT NUMBER");
        }

        for (int i = 0; i < students.length; i++){
            System.out.println(students[i].toString());
        }
    }
}
