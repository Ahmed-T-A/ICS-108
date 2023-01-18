import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input2 = new Scanner(System.in);
        //-------------------------------------------------
        Employee[] employeeArray = createEmployeeArray();
        printFullTimeEmployees(employeeArray);
        System.out.println("***********************************************");
        double avgSalary = avgSalaryFullTimeEmployees(employeeArray);
        System.out.println("avg salary of full-time employees = " + avgSalary);
        System.out.println("***********************************************");
        printPartTimeEmployees(employeeArray);
        System.out.println("***********************************************");
        double avgHours = avgHoursPartTimeEmployees(employeeArray);
        System.out.println("avg hours of part-time employees = " + avgHours);
        //-------------------------------------------------
    }
    //===========================================================
    public static Employee[] createEmployeeArray(){
        Scanner input = new Scanner(System.in);
        Employee[] employeeArray = new Employee[5];
         // ADDING ELEMENT TO THE ARRAY
         for(int i = 0; i < employeeArray.length; i++){
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
                employeeArray[i] = employee1;
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
                employeeArray[i] = employee1;
            }
         }
        return employeeArray; 
    }
    //===========================================================
    public static void printFullTimeEmployees(Employee[] employeeArray){
        for (int i = 0; i<employeeArray.length; i++ ){
            if (employeeArray[i] instanceof FullTimeEmployee)
                System.out.println(employeeArray[i]);
        }
    }
    //===========================================================
    public static void printPartTimeEmployees(Employee[] employeeArray){
        for (int i = 0; i<employeeArray.length; i++ ){
            if (employeeArray[i] instanceof PartTimeEmployee)
                System.out.println(employeeArray[i]);
        }
    }
    //===========================================================
    public static double avgSalaryFullTimeEmployees(Employee[] employeeArray){
        double totalSalary = 0.0;
        int salaryCount = 0;
        for (int i = 0; i<employeeArray.length; i++ ){
            if (employeeArray[i] instanceof FullTimeEmployee){
                System.out.println(employeeArray[i]);
                totalSalary += (((FullTimeEmployee) employeeArray[i]).getSalary());
                salaryCount += 1;
            }
        }
        return totalSalary / salaryCount;
    }
    //===========================================================
    public static double avgHoursPartTimeEmployees(Employee[] employeeArray){
        int totalHours = 0;
        int hoursCount = 0;
        for (int i = 0; i<employeeArray.length; i++ ){
            if (employeeArray[i] instanceof PartTimeEmployee){
                System.out.println(employeeArray[i]);
                totalHours += (((PartTimeEmployee)employeeArray[i]).getHours());
                hoursCount += 1;
            }
        }
        return totalHours / hoursCount;
    }
}
