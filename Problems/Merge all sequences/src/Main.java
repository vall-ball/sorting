import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] arr = new int[length][];

        for (int i = 0; i < length; i++) {
            int l = scanner.nextInt();
            arr[i] = new int[l];
            for (int j = 0; j < l; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] answer = mergeAllArrays(arr);
        for (int i : answer) {
            System.out.print(i + " ");
        }


    }

    private static int[] mergeAllArrays(int[][] arrays) {
        if (arrays.length > 1) {
            int[] a = merge(arrays[0], arrays[1]);
            if (arrays.length > 2) {
                for (int i = 2; i < arrays.length; i++) {
                    int[] answer = merge(a, arrays[i]);
                    a = answer;
                }

            }

            return a;
        } else if (arrays.length == 0){
            return new int[0];
        } else {
            return arrays[0];
        }
    }
    private static int[] merge(int[] first, int[] second) {
        int[] answer = new int[first.length + second.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < first.length && j < second.length) {
            if (first[i] >= second[j]) {
                answer[k] = first[i];
                i++;
            } else {
                answer[k] = second[j];
                j++;
            }
            k++;
        }
        for (;i < first.length; i++, k++) {
            answer[k] = first[i];
        }

        /* insert all the remaining elements of the right subarray in the array */
        for (;j < second.length; j++, k++) {
            answer[k] = second[j];
        }
        return answer;
    }


}