import java.util.Scanner;

public class CheckSortedArray{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        scanner.nextLine();  

        int [] array = new int[len];
        String[] input = scanner.nextLine().split(" ");
        
        for (int i = 0; i < len; i++){
            array[i] = Integer.parseInt(input[i]);
        }

        boolean sorted = true;
        for (int i = 1; i < len; i++){
            if (array[i] < array[i-1]){
                sorted = false;
                break;
            }
        }
        System.out.println(sorted);
        scanner.close();
    }
}