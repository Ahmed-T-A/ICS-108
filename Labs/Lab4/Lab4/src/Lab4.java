import java.util.Scanner;
public class Lab4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //-------------------------------------------
        //List informations:
        System.out.print("Enter the size of the List1 : ");
        int size = input.nextInt();
        int[] list1 = new int[size];
        System.out.println("Enter List1:");
        for (int z = 0; z < list1.length; z++)
            list1[z] = input.nextInt();
        //-------------------------------------------
        //find the element in the array:
        String element = "";
        for (int s = 0; s <= list1.length-1; s++){
            element = element + Integer.toString(list1[s]) + " ";
        }
        //-------------------------------------------
        // finding out whether the list is sorted:
        if (sortedList(list1)){
            System.out.println("The array has " + size + " integers " + element);
            System.out.println("The array is sorted");
        } else{
            System.out.println("The array has " + size + " integers " + element);
            System.out.println("The array is not sorted");
        }
        //=======================================================
    }
    public static boolean sortedList(int[] list1){
        int i = 0;
        while ( i < list1.length - 1){
            if (list1[i] > list1[i+1]){
                return false;
            }
            else{
                i++;
            }
            return true;
        }
        return false;
    }
}
