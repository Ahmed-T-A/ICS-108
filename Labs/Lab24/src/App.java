import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> myList = new ArrayList<>();
        Queue<String> myQueue = new Queue<>(myList);
        myQueue.add("X");
        myQueue.add("Y");
        myQueue.add("Z");

        System.out.println(myQueue.remove()); // Returns X
        System.out.println(myQueue.remove()); // Returns Y
        System.out.println(myQueue.remove()); // Returns Z
        System.out.println(myQueue.remove()); // Returns null

    }
}
