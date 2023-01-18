import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> nonPrimenumbers = new ArrayList<>();
        for(int i = 2; i <= 100; i++) { numbers.add(i);}
       
        for(int i = 0; i < numbers.size(); i++)
        {
            for(int j = i + 1; j < numbers.size(); j++)
            {
                if ( numbers.get(j) % numbers.get(i) == 0)
                {
                    numbers.remove(j);
                }
            }
        }
        System.out.println(numbers);


    }
}
