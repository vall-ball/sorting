import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            scanner.nextInt();
        }
        System.out.println(length - 1);
    }
}