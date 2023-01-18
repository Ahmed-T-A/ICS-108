public abstract class Student {
   
    private int id;
    private double gpa;

    public Student(int id, double gpa){
        this.id = id;
        this.gpa = gpa;
    }

    public final String toString(){ return "The ID is: " + id + " and the GPA is: " + gpa + " and the status is: " + getStatus();}
    public int getId(){ return id; }
    public double getGpa(){ return gpa; }
    public abstract String getStatus();

}
