import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfDictionary = Integer.parseInt(scanner.nextLine());
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < lengthOfDictionary; i++) {
            dictionary.add(scanner.nextLine().toLowerCase());
        }

        int lengthOfLines = Integer.parseInt(scanner.nextLine());
        List<String> text = new ArrayList<>();
        for (int i = 0; i < lengthOfLines; i++) {
            text.add(scanner.nextLine());
        }

        Set<String> answer = new HashSet<>();
        for (String t : text) {
            String[] arr = t.split(" ");
            for (String s : arr) {
                if (!dictionary.contains(s.toLowerCase())) {
                    answer.add(s);
                }
            }
        }

        for (String a : answer) {
            System.out.println(a);
        }

    }
}