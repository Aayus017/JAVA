import java.util.ArrayList;
import java.util.Arrays;
public class PyakurelA5 {
    public static <E> void reverseInPlace(E[] array){
        int start = 0;
        int end = array.length-1;
        while(start<end){
            E temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for(E element : list){
            if(!result.contains(element)){
                result.add(element);
            }
        }
        return result;
    }

    public static ArrayList<String> removeDuplicateString(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();

        for (String element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static <E> void printArray(E[] a) {
        for (E element: a ) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] stringArray = {"red", "green", "blue", "yellow"};
        String[] tempS = stringArray;
        System.out.print("Array: ");
        printArray(stringArray);
        reverseInPlace(stringArray);
        System.out.print("reversed: ");
        printArray(stringArray);
        System.out.println("Reversed in place: " + (tempS == stringArray) + "\n");
        ArrayList<String> StringArrayList = new ArrayList<>(Arrays.asList("red", "green", "blue", "green", "red", "yellow"));
        ArrayList<String> uniqueStringArrayList = removeDuplicateString(StringArrayList);
        ArrayList<Integer> intArrrayList = new ArrayList<>(Arrays.asList(8, 9, 10, 9, 10, 8, 8, 11, 12));
        ArrayList<Integer> uniquesArrrayList = removeDuplicates(intArrrayList);
        System.out.println("The unique values from the list " + StringArrayList + " are: " + uniqueStringArrayList);
        System.out.println("\nThe unique values from the list " + intArrrayList + " are: " + uniquesArrrayList);
    }
}