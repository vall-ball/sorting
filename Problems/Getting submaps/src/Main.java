
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        scanner.nextLine();
        int length = Integer.parseInt(scanner.nextLine());
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(scanner.nextInt(), scanner.nextLine().trim());
        }

        for (int i = from; i <= to; i++) {
            if (map.containsKey(i)) {
                System.out.println(i + " " + map.get(i));
            }
        }
    }
}