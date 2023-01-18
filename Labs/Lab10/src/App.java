import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Employee[] employeesArray = new Employee[5];
        //-------------------------------------------------
        // ADDING ELEMENT TO THE ARRAY
        for(int i = 0; i < employeesArray.length; i++){
            System.out.print("IF you want to insert a full time employee enter 1 and for part time employee enter 0: ");
            int choice = input.nextInt();
            // IF THE USER ENTER 1, THEN ADD FULL TIME EMPLOYEE.
            // IF THE USER ENTER 0, THEN ADD PART TIME EMPLOYEE.
            if (choice == 1){
                System.out.print("Enter the name: ");
                String name = input.next();
                System.out.print("Enter the ID: ");
                int id = input.nextInt();
                System.out.print("Enter the salary: ");
                double salary = input.nextDouble();
                System.out.println("----------------------------------------");
                Employee employee1 = new FullTimeEmployee(name, id, salary);
                employeesArray[i] = employee1;
            }
            else if ( choice == 0){
                System.out.print("Enter the name: ");
                String name = input.next();
                System.out.print("Enter the ID: ");
                int id = input.nextInt();
                System.out.print("Enter the hours: ");
                int hours = input.nextInt();
                System.out.println("----------------------------------------");
                Employee employee1 = new PartTimeEmployee(name, id, hours);
                employeesArray[i] = employee1;
            }
        }
        //-------------------------------------------------
        // CALCULATING THE AVERAGE:
        double totalSalary = 0.0;
        int salaryCount = 0;

        int totalHours = 0;
        int hoursCount = 0;

        for (int i = 0; i<employeesArray.length; i++ ){
            if (employeesArray[i] instanceof FullTimeEmployee){
                System.out.println(employeesArray[i]);
                totalSalary += (((FullTimeEmployee) employeesArray[i]).getSalary());
                salaryCount += 1;
            }
            else if (employeesArray[i] instanceof PartTimeEmployee){
                System.out.println(employeesArray[i]);
                totalHours += (((PartTimeEmployee)employeesArray[i]).getHours());
                hoursCount += 1;
            }
        }

        double avgSalary = totalSalary / salaryCount;
        double avgHours = totalHours / hoursCount;
        System.out.println("----------------------------------------");
        System.out.printf("The average salary is = %.2f\n" , avgSalary);
        System.out.println("The average Hours is = " + avgHours);

    }
}
