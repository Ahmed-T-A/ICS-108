public class MCQuestion extends Question {
    // DATA FIELD:
    private String choiceA;
    private String choiceB;
    private String choiceC;
    //--------------------
    // CONSTRUCTORS:
    public MCQuestion(String text, String a, String b, String c){
        super(text);
        this.choiceA = a;
        this.choiceB = b;
        this.choiceC = c;
    }
    //-------------------
    // METHODS:
    public String toString(){
        return super.toString() + "\nA. " + choiceA + "\nB. " + choiceB + "\nC. " + choiceC;
    }
}
