import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner input = new Scanner(System.in);
        // System.out.print("Enter the file name: ");
        // String myFile = input.next();
        // File file = new File(myFile);

        File file = new File("C:\\Users\\hamad\\Desktop\\KFUPM\\221\\TestFolder");

        System.out.print("The depth is: " + directoryDepth(file));
    }

    public static int directoryDepth(File file)
    {
        int depth = 0;

        if (file.isFile())
            depth += 1;

        if (file.isDirectory())
        {
            File[] filesArray = file.listFiles();
            for(int i = 0; filesArray != null && i < filesArray.length; i++)
            {
                depth += directoryDepth(filesArray[i]);
            }
        }


        return depth;
    }
}
