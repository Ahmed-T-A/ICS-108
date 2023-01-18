import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Unsorted {
    public static void main(String[] args) throws Exception {
        Student[] studentArray = new Student[10];
        studentArray[0] = new Student("ZIYAD", 62660);
        studentArray[1] = new Student("MUSTAFA", 30180);
        studentArray[2] = new Student("MUSTAFA", 30180);
        studentArray[3] = new Student("MOHAMMAD", 53700);
        studentArray[4] = new Student("JEHAD", 11460);
        studentArray[5] = new Student("HASAN", 25220);
        studentArray[6] = new Student("ABDULAZIZ", 73190);
        studentArray[7] = new Student("MAHMOUD", 45440);
        studentArray[8] = new Student("AHMAD", 65470);
        studentArray[9] = new Student("AMMAR", 94720);
        try{
            FileOutputStream fileOut = new FileOutputStream("unsortedfile.dat");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOut);
            objOutput.writeObject(studentArray);
            objOutput.close();
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());

        } catch(IOException em){
            System.out.println(em.getMessage());
        }
    }
}
