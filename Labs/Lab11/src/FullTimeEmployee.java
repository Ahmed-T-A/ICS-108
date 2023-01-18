public class FullTimeEmployee extends Employee {
    // DATA FIELD:
    private double salary;
    //---------------------------------
    // CONSTRUCTOR:
    public FullTimeEmployee(String name, int id, double salary){
        super(name,id);
        this.salary = salary;
    }
    //---------------------------------
    // METHODS:
    public String toString(){ return super.toString() + " and the salary is " + salary; }
    public double getSalary(){ return salary; }
}
