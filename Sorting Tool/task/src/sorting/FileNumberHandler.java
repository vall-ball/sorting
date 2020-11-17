package sorting;

import java.util.*;

public class FileNumberHandler {
    String sortingType;
    List<String> list;

    public FileNumberHandler(String sortingType, List<String> list) {
        this.sortingType = sortingType;
        this.list = list;
    }

    public List<Long> getList() {
        List<Long> listOfLong = new ArrayList<>();
        if (list.size() != 0) {
            try {
                for (String s : list) {
                    for (String s1 : s.split(" ")) {
                        listOfLong.add(Long.parseLong(s1));
                    }
                }
            }  catch (NumberFormatException e) {
                listOfLong.add(0L);
                return listOfLong;
            }
        }
        return listOfLong;
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
        List<Long> list = getList();
        Collections.sort(list);
        List<String> answer = new ArrayList<>();
        answer.add("Total numbers: " + list.size() + "\n");
        answer.add("Sorted data: ");
        for (long l : list) {
           answer.add(l + " ");
        }
        return answer;
    }

    public List<String> sortByCount() {
        List<String> answer = new ArrayList<>();
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
        answer.add("Total numbers: " + list.size() + "\n");

        for (int i : counts) {
            for (Long s : dataEntryToCount.get(i)) {
                answer.add(s + ": " + i + " time(s), " + (int)((double) i / (double) list.size() * 100) + "%" + "\n");
            }
        }
        return answer;
    }
}
