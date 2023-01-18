public class PartTimeEmployee extends Employee {
    // DATA FIELD:
    private int hours;
    //---------------------------------
    // CONSTRUCTOR:
    public PartTimeEmployee(String name, int id, int hours){
        super(name,id);
        this.hours = hours;
    }
    //---------------------------------
    // METHODS:
    public String toString(){ return super.toString() + " and the hours is " + hours; }
    public int getHours(){ return hours; }
}
