import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] keys = scanner.nextLine().split("");
        String[] values = scanner.nextLine().split("");
        String plainText = scanner.nextLine();
        String cipherText = scanner.nextLine();

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        Map<String, String> invertMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            invertMap.put(values[i], keys[i]);
        }

        StringBuilder codeText = new StringBuilder();

        for (String s : plainText.split("")) {
            codeText.append(map.get(s));
        }
        System.out.println(codeText);

        StringBuilder decodeText = new StringBuilder();

        for (String s : cipherText.split("")) {

            decodeText.append(invertMap.get(s));
        }
        System.out.println(decodeText);

    }
}