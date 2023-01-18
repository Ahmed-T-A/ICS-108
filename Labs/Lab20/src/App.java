public class App {
    public static void main(String[] args) throws Exception {
        int[] array = new int[6];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        array[5] = 6;

        System.out.println(recursiveLinearSearch(array, 6));

    }

    public static int recursiveLinearSearch(int[] array, int target){
        return recursiveLinearSearch2(array, target, 0);
    }

    public static int recursiveLinearSearch2(int[] array, int target, int idx){
        if (idx == array.length)
        {
            return -1;
        }
        else if (target == array[idx])
        {
            return idx;
        }
        else
        {
            return recursiveLinearSearch2(array, target, idx + 1);
        }
    }

}
