import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Sorted {
  public static void main(String[] args) throws Exception {
    try{
      FileInputStream fileInput = new FileInputStream("unsortedfile.dat");
      ObjectInputStream objInput = new ObjectInputStream(fileInput);
      Student[] sortedStudent = (Student[]) objInput.readObject();
      Arrays.sort(sortedStudent);
      for(int i = 0; i < sortedStudent.length; i++){
        System.out.println(sortedStudent[i].toString());
      }
      objInput.close();
      FileOutputStream sortedfile = new FileOutputStream("sortedstudentfile.dat");
      ObjectOutputStream objOutput = new ObjectOutputStream(sortedfile);
      objOutput.writeObject(sortedStudent);
      objOutput.close();
      
    } catch (FileNotFoundException e){
      System.out.println(e.getMessage());

    } catch(IOException em){
      System.out.println(em.getMessage());
      
    } catch(ClassNotFoundException emm){
      System.out.println(emm.getMessage());
    }
  }
}