import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextLong();
        }
            System.out.println(invCount(array));
        }


    static long merge(long[] arr, long[] left, long[] right) {
        int i = 0;
        int j = 0;
        long count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length-i;
                j++;
            }
        }
        return count;
    }

    static long invCount(long[] arr) {
        if (arr.length < 2)
            return 0;

        int m = (arr.length + 1) / 2;
        long left[] = Arrays.copyOfRange(arr, 0, m);
        long right[] = Arrays.copyOfRange(arr, m, arr.length);

        return invCount(left) + invCount(right) + merge(arr, left, right);
    }
}