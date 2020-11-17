import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] newspaper = scanner.nextLine().trim().toCharArray();
        char[] note = scanner.nextLine().trim().toCharArray();

        Map<Character, Integer> newspaperMap = new HashMap<>();
        Map<Character, Integer> noteMap = new HashMap<>();

        for (char c : newspaper) {
            if (newspaperMap.containsKey(c)) {
                int i = newspaperMap.get(c);
                i++;
                newspaperMap.put(c, i);
            } else {
                newspaperMap.put(c, 1);
            }
        }

        for (char c : note) {
            if (noteMap.containsKey(c)) {
                int i = noteMap.get(c);
                i++;
                noteMap.put(c, i);
            } else {
                noteMap.put(c, 1);
            }
        }

        boolean answer = true;

        for (char c : noteMap.keySet()) {
            if (!newspaperMap.containsKey(c) || noteMap.get(c) > newspaperMap.get(c)) {
                answer = false;
                break;
            }
        }

        if (answer) {
            System.out.println("You get money");
        } else {
            System.out.println("You are busted");
        }

    }
}