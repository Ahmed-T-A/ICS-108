import java.util.Scanner;
public class Lab3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //-------------------------------------------
        //List 1 informations:
        System.out.print("Enter the size of the List1 : ");
        int i = input.nextInt();
        int[] list1 = new int[i];
        System.out.println("Enter List1:");
        for (int z = 0; z < list1.length; z++)
            list1[z] = input.nextInt();
        //-------------------------------------------
        //List 2 informations:
        System.out.print("Enter the size of the List2 : ");
        int n = input.nextInt();
        int[] list2 = new int[n];
        System.out.println("Enter List2:");
        for (int k = 0; k < list2.length; k++)
            list2[k] = input.nextInt();
        //-------------------------------------------
        //Finding out whether the two lists are equal:
        if (equals(list1, list2)){
            System.out.println("List1 and List2 are equal");
            System.out.println("====================================");}
        else{
            System.out.println("List1 and List2 are not equal");
            System.out.println("====================================");}
    }
    //====================================================================
    public static boolean equals(int[] list1, int[] list2){
        if (list1.length == list2.length){
            for (int i = 0; i < list1.length; i++){
                if (list1[i] != list2[i])
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}
