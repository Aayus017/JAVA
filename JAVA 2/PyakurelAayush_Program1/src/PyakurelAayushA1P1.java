import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PyakurelAayushA1P1 {
    public static void main(String[] args) {
        int[] randomInt = new int[100];
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        for(int i =0 ; i < randomInt.length ; i++){
            randomInt[i] = rand.nextInt(9999);
        }
        System.out.print("Enter an integer in range 0-99 for the index: ");
        try{
            int index = scan.nextInt();

            if(0 < index && index < 100){
                int num = randomInt[index];
                System.out.println("The element at position" +index+ "is " +num );
            }else{
                System.out.println("Try again. (Incorrect input: index is out of bounds)");
            }

        }catch(InputMismatchException exc){
            System.out.println("Try again. (Incorrect input: an integer is required)");
        }
    }
}
