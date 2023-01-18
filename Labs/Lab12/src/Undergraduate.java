public class Undergraduate extends Student {

    private String status;

    public Undergraduate(int id, double gpa){
        super(id, gpa);
    }

    public String getStatus(){
        if (super.getGpa() >= 3.00)
            return status = "Honor";
        else if (super.getGpa() >= 2.00)
            return status = "Good";
        else
            return status = "probation";
    }
}
