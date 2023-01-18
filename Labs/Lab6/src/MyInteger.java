public class MyInteger {
    //Data field:
    private int value;
    //------------
    //Constructor:
    public MyInteger(int number){
        value = number;
    }
    //------------
    //Methods:
    public int getInteger(){
        return value; }
    //*************
    public static boolean isEven(int number){
        if ((number % 2) == 0)
            return true;
        else
            return false; }
    //*************    
    public static boolean isOdd(int number){
        if ((number % 2) == 1)
            return true;
        else
            return false; }
    //*************
    public static boolean isPrime(int number){
        for (int i = 2; (i < number) ; i++){
            if ((number % i) == 0)
                return false;
        }
        return true;
    }
    //*************    
    public boolean equals(MyInteger number){
        if (value == number.getInteger())
            return true;
        else    
            return false; }
}