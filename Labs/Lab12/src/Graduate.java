public class Graduate extends Student {

    private String status;

    public Graduate(int id, double gpa){
        super(id, gpa);
    }

    public String getStatus(){
        if (super.getGpa() >= 3.00)
            return status = "Good";
        else
            return status = "probation";
    }
}
