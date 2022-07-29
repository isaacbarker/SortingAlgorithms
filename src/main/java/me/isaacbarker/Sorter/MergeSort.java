package me.isaacbarker.Sorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private List<Integer> arr;

    public MergeSort(List<Integer> arr) {
        this.arr = arr;
    }

    public List<Integer> sort() {
        return merge(arr);
    }

    private List<Integer> merge(List<Integer> arr) {
        if (arr.size() == 1) { // Return array if it is at its smallest part
            return arr;
        }

        int midpoint = arr.size() / 2;

        List<Integer> s1 = merge(arr.subList(0, midpoint));
        List<Integer> s2 = merge(arr.subList(midpoint, arr.size()));

        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        // Merge subsets
        while (i < s1.size() && j < s2.size()) {

            if (s1.get(i) <= s2.get(j)) {
                result.add(s1.get(i));
                i ++;
            } else {
                result.add(s2.get(j));
                j++;
            }
        }

        // Add remaining elements.
        result.addAll(s1.subList(i, s1.size()));
        result.addAll(s2.subList(j, s2.size()));

        return result;
    }

}
