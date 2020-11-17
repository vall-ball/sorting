package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    Scanner scanner = new Scanner(System.in);

    public void sort() {

        List<Integer> list = new ArrayList<>();

        while (scanner.hasNextLong()) {
            int number = scanner.nextInt();
            list.add(number);
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        SortingTool.mergeSort(array, 0, array.length);
        System.out.println("Total numbers: " + array.length + ".");
        System.out.print("Sorted data: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }



}
