import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String s = scanner.next().toUpperCase();
            if (map.containsKey(s)) {
                int i = map.get(s);
                i++;
                map.put(s, i);
            } else {
                map.put(s, 1);
            }
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}