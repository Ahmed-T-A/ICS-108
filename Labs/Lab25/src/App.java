import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\hamad\\Desktop\\KFUPM\\221\\ICS 108\\Labs\\Lab25\\text.txt");
        Scanner input = new Scanner(file);
        TreeMap<String, TreeSet<Integer>> courses = new TreeMap<>();

        while(input.hasNext()){
            int x = input.nextInt();
            String y = input.next();
            if(!courses.containsKey(y)){
                TreeSet<Integer> ids = new TreeSet<>();
                ids.add(x);
                courses.put(y, ids);
            }
            else{
                courses.get(y).add(x);
            }
        }
        System.out.println(courses);
    }
}
