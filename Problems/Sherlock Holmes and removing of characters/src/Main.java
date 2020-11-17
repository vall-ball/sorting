import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] firstWord = scanner.nextLine().toLowerCase().toCharArray();
        char[] secondWord = scanner.nextLine().toLowerCase().toCharArray();

        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();

        for (char c : firstWord) {
            first.add(c);
        }

         for (char c : secondWord) {
             second.add(c);
         }

         List<Character> list = new ArrayList<>();

         for (Character c : first) {
             if (second.remove(c)) {
                 list.add(c);
            }
        }

         for (Character c : list) {
            first.remove(c);
         }

        for (Character c : second) {
            first.remove(c);
        }

        System.out.println(first.size() + second.size());

    }
}

