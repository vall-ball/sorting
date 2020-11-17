import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        String[] arr = str.split(" ");
        Set<Integer> answer = new HashSet<>();
        for (String s : arr) {
            answer.add(Integer.parseInt(s));
        }
        return answer;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        Set<Integer> exclusiveSet = new HashSet<>();
        for (Integer i : set) {
            if (i > 10) {
                exclusiveSet.add(i);
            }
        }
        set.removeAll(exclusiveSet);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}