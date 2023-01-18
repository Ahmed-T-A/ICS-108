import java.util.Scanner;
public class Lab09 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //==============================================
        System.out.print(" Enter the question: ");
        String text = input.nextLine();

        System.out.print(" Enter the choice A: ");
        String choiceA = input.nextLine();

        System.out.print(" Enter the choice B: ");
        String choiceB = input.nextLine();

        System.out.print(" Enter the choice C: ");
        String choiceC = input.nextLine();

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        //==============================================
        MCQuestion question = new MCQuestion(text, choiceA, choiceB, choiceC);
        System.out.println(question);

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}
