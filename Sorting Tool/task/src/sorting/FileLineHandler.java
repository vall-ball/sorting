package sorting;

import java.util.*;

public class FileLineHandler {
    List<String> list;
    String sortingType;

    public FileLineHandler(List<String> list, String sortingType) {
        this.list = list;
        this.sortingType = sortingType;
    }

    public List<String> handle() {
        switch (sortingType) {
            case "natural":
                return sortNaturally();
            case "byCount":
                return sortByCount();

        }
        return null;
    }

    public List<String> sortNaturally() {
        List<String> answer = new ArrayList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String one, String two) {
                return one.compareTo(two);
            }
        });

        answer.add("Total words: " + list.size() + "\n");
        answer.add("Sorted data: " + "\n");
        for (String s : list) {
            answer.add(s + "\n");
        }
        return answer;
    }

    public List<String> sortByCount() {
        List<String> answer = new ArrayList<>();
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
        answer.add("Total words: " + list.size() + "\n");

        for (int i : counts) {
            for (String s : dataEntryToCount.get(i)) {
                answer.add(s + ": " + i + " time(s), " + (int)((double) i / (double) list.size() * 100) + "%" + "\n");
            }
        }
        return answer;
    }
}


