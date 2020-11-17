package sorting;

import java.util.*;

public class FileWordHandler {
    List<String> list;
    String sortingType;

    public FileWordHandler(List<String> list, String sortingType) {
        this.list = list;
        this.sortingType = sortingType;
    }

    public List<String> getList() {
        List<String> listOfString = new ArrayList<>();
        for (String s : list) {
            for (String s1 : s.split(" ")) {
                listOfString.add(s1);
            }
        }
        return listOfString;
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
        List<String> listStr = getList();
        List<String> answer = new ArrayList<>();
        Collections.sort(listStr, new Comparator<String>() {
            @Override
            public int compare(String one, String two) {
                return one.compareTo(two);
            }
        });

        answer.add("Total words: " + listStr.size() + "\n");
        answer.add("Sorted data: " + "\n");
        for (String s : listStr) {
            answer.add(s + " ");
        }
        return answer;
    }

    public List<String> sortByCount() {
        List<String> listStr = getList();
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : listStr) {
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
