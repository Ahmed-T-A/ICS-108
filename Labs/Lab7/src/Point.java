public class Point{
    // Data field:
    private double x,y;
    //-----------
    // Constructors:
    public Point(){
        x = 0.0;
        y = 0.0;
    }
    //-----------
    public Point(double x1, double y1){
        x = x1;
        y = y1;
    }
    //-----------
    // Methods
    public double getX(){ 
        return x;
    }
    public double getY(){
        return y;
    }    
    public double distance(Point point2){
        return Math.sqrt(Math.pow((x - point2.getX()), 2) + Math.pow((y - point2.getY()), 2));
    }
}
