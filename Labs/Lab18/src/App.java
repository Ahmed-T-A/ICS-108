import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        File unsorted = new File("unsortedStudents.txt");
        File sorted = new File("sortedStudentsByID.txt");
        Students[] studentsArray = new Students[10];
        try{
            Scanner input = new Scanner(unsorted); 
            input.nextInt();
            for(int i = 0; i < 10; i++ ){
                int id = input.nextInt();
                String name = input.next();
                studentsArray[i] = new Students(name, id); 
            }
            Arrays.sort(studentsArray);
            for (int i = 0; i < studentsArray.length; i++){
                System.out.println(studentsArray[i].toString());
            }
            
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            PrintWriter output = new PrintWriter(sorted);
            output.println("=============== Sorted File ===============");
            for(int i = 0; i < 10; i++){
                output.println(studentsArray[i].toString());
            }
            output.println("=============== End Of File ===============");
            output.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
