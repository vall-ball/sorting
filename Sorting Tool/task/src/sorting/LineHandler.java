package sorting;

import java.util.*;

public class LineHandler {
    String sortingType;

    public LineHandler(String sortingType) {
        this.sortingType = sortingType;
    }

    public List<String> getList() {
        Scanner scanner = new Scanner(System.in);
        String max;
        long countOfMax = 0;
        List<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            list.add(line);
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
        List<String> list = getList();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String one, String two) {
                return one.compareTo(two);
            }
        });

        System.out.println("Total lines: " + list.size());
        System.out.println("Sorted data: ");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void sortByCount() {
        List<String> list = getList();
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                int i = map.get(s);
                i++;
                map.put(s, i);
            } else {
                map.put(s, 1);
            }
        }

        List<Integer> counts = new ArrayList<>();
        for (String s : map.keySet()) {
            counts.add(map.get(s));
        }

        Set<Integer> set = new HashSet<>();
        set.addAll(counts);
        counts.clear();
        counts.addAll(set);
        Collections.sort(counts);

        Map<Integer, Set<String>> dataEntryToCount = new HashMap<>();
        for (String s : map.keySet()) {
            if (dataEntryToCount.containsKey(map.get(s))) {
                dataEntryToCount.get(map.get(s)).add(s);
            } else {
                Set<String> set1 = new TreeSet<>();
                set1.add(s);
                dataEntryToCount.put(map.get(s), set1);
            }
        }
        System.out.println("Total words: " + list.size());

        for (int i : counts) {
            for (String s : dataEntryToCount.get(i)) {
                System.out.println(s + ": " + i + " time(s), " + (int)((double) i / (double) list.size() * 100) + "%");
            }
        }

    }
}

