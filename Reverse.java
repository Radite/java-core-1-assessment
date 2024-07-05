import java.util.Scanner;

public class Reverse{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String toReverse = scanner.nextLine();

        // Convert string to array
        char [] charArray = toReverse.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;

        }

        String reversed = new String(charArray);
        System.out.println("Reversed using iteration: " + reversed);

        StringBuilder reversed2 = new StringBuilder(toReverse);
        reversed2.reverse();
        System.out.println("Reversed using .reverse: " + reversed2);

        StringBuilder reversed3 = new StringBuilder();
        int size = toReverse.length() - 1;

        for (int i = size; i >= 0; i--){
            char c = toReverse.charAt(i);
            reversed3.append(c);
        }

        System.out.println("Reversed using Stringbuilder: " + reversed3);
        scanner.close();
    }
}