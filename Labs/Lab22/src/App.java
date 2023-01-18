import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            File sortedFile1 = new File("sortedFile1.txt");
            File sortedFile2 = new File("sortedFile2.txt");
            File finalFile = new File("finalFile.txt");

            Scanner input1 = new Scanner(sortedFile1);
            Scanner input2 = new Scanner(sortedFile2);
            Scanner input3 = new Scanner(finalFile);
            PrintWriter output = new PrintWriter(finalFile);

            int x = 0;
            int y = 0;
            x = input1.nextInt();
            y = input2.nextInt();

            while(input1.hasNextInt() && input2.hasNextInt())
            {
                if (x < y)
                {
                    output.println(x);
                    x = input1.nextInt();
                }
                else
                {
                    output.println(y);
                    y = input2.nextInt();
                }
            }

            if (x < y)
            {
                output.println(x);
                output.println(y);
            }
            
            else
            {
                output.println(y);
                output.println(x);
            }

            while(input1.hasNextInt()){
                x = input1.nextInt();
                output.println(x);
            }

            while(input2.hasNextInt()){
                y = input2.nextInt();
                output.println(y);
            }



            input1.close();
            input2.close();
            input3.close();
            output.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
