package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; (i + 1 < list.size()); i++) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; (i < list.size()); i += 2) {
            String element = list.get(i);
            list.add(i, element);

        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; (i + 1 < list.size()); i += 2) {
            String first = list.get(i);
            String second = list.get(i + 1);

            list.set(i, second);
            list.set(i + 1, first);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i + 1 < list.size(); ) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.equals(second)) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
            }
            i++;
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            stack.push(num);
            queue.add(num);
        }

        for (int i = 0; i < size; i++) {
            int fromQueue = queue.poll();
            int fromStack = stack.pop();
            if (fromQueue != fromStack) {
                isPalindrome = false;
            }
            queue.add(fromQueue);
        }
        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num < 0) {
                stack.push(num);
            } else {
                queue.add(num);
            }
        }
        int positives = queue.size();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < positives; i++) {
            queue.add(queue.poll());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num % 2 == 0) {
                queue.add(num);
            } else {
                stack.push(num);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num % 2 == 0) {
                queue.add(num);
            } else {
                stack.push(num);
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String str : set) {
            if (str.length() > max) {
                max = str.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(str -> str.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        int count = 0;
        for (Integer num : set1) {
            if (set2.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> uniqueValues = new HashSet<>();
        for (String value : map.values()) {
            uniqueValues.add(value);
            if (!uniqueValues.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            resultMap.put(entry.getValue(), entry.getKey());
        }
        return resultMap;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer value : map.values()) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }
        int rarestValue = 0;
        int minCount = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();

            if (freq < minCount) {
                minCount = freq;
                rarestValue = val;
            } else if (freq == minCount && val < rarestValue) {
                rarestValue = val;
            }
        }
        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> counts = new HashMap<>();

        for (Integer num : list) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        for (Integer freq : counts.values()) {
            if (freq > maxCount) {
                maxCount = freq;
            }
        }
        return maxCount;
    }
}
