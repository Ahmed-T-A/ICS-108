public class Vehicle {
    private int id, wheels;
    //---------------------------------------
    // CONSTRUCTOR:
    public Vehicle(int id, int wheels){
        this.id = id;
        this.wheels = wheels;
    }
    //---------------------------------------
    // METHODS:
    public int getId(){ return id; }

    public int getWheels(){ return wheels; }
    
    public String toString(){ return "The Id is " + id + " and the number of wheels is " + wheels; }
}
