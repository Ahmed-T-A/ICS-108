public class Truck extends Vehicle {
    private int load;
    //--------------------------------
    // CONSTRUCTOR:
    public Truck(int id, int wheels, int load){
        super(id, wheels);
        this.load = load;    
    }
    //--------------------------------
    // METHODS:
    public String toString(){ return super.toString() + " and the load is " + load + "."; }
}
