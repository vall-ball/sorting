package sorting;

import java.util.*;

public class NumberHandler {
    String sortingType;

    public NumberHandler(String sortingType) {
        this.sortingType = sortingType;
    }

    public List<Long> getList() {
        Scanner scanner = new Scanner(System.in);
        List<Long> list = new ArrayList<>();

        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            list.add(number);
        }
        return list;
    }
    public void handle() {
        switch (sortingType) {
            case "natural":
                sortNaturally();
                break;
            case "byCount":
                sortByCount();
                break;
        }

    }

    public void sortNaturally() {
        List<Long> list = getList();
        Collections.sort(list);

        System.out.println("Total numbers: " + list.size());
        System.out.print("Sorted data: ");
        for (long l : list) {
            System.out.print(l + " ");
        }
    }

    public void sortByCount() {
        List<Long> list = getList();
        Map<Long, Integer> map = new HashMap<>();
        for (Long s : list) {
            if (map.containsKey(s)) {
                int i = map.get(s);
                i++;
                map.put(s, i);
            } else {
                map.put(s, 1);
            }
        }

        List<Integer> counts = new ArrayList<>();
        for (Long s : map.keySet()) {
            counts.add(map.get(s));
        }

        Set<Integer> set = new TreeSet<>();
        set.addAll(counts);
        counts.clear();
        counts.addAll(set);
        Collections.sort(counts);

        Map<Integer, Set<Long>> dataEntryToCount = new HashMap<>();
        for (Long s : map.keySet()) {
            if (dataEntryToCount.containsKey(map.get(s))) {
                dataEntryToCount.get(map.get(s)).add(s);
            } else {
                Set<Long> set1 = new TreeSet<>();
                set1.add(s);
                dataEntryToCount.put(map.get(s), set1);
            }
        }
        System.out.println("Total numbers: " + list.size());

        for (int i : counts) {
            for (Long s : dataEntryToCount.get(i)) {
                System.out.println(s + ": " + i + " time(s), " + (int)((double) i / (double) list.size() * 100) + "%");
            }
        }

    }


}
