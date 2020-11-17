import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] first = scanner.nextLine().toLowerCase().toCharArray();
        char[] second = scanner.nextLine().toLowerCase().toCharArray();

        Map<Character, Integer> firstMap = new HashMap<>();
        Map<Character, Integer> secondMap = new HashMap<>();

        for (char c : first) {
            if (firstMap.containsKey(c)) {
                int i = firstMap.get(c);
                i++;
                firstMap.put(c, i);
            } else {
                firstMap.put(c, 1);
            }
        }

        for (char c : second) {
            if (secondMap.containsKey(c)) {
                int i = secondMap.get(c);
                i++;
                secondMap.put(c, i);
            } else {
                secondMap.put(c, 1);
            }
        }
        if (firstMap.equals(secondMap)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}