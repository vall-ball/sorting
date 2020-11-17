import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            set.add(scanner.nextLine());
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}