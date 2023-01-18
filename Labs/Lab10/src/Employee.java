public class Employee {
    // DATA FIELD:
    private String name;
    private int id;
    //----------------------------
    // CONSTRUCTOR:
    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    //----------------------------
    // METHODS:
    public String toString(){ return "The name is " + name + " and the id is " + id; }
    public String getName(){ return name; }
    public int getId(){ return id; }
}
