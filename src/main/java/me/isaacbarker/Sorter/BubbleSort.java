package me.isaacbarker.Sorter;

import java.util.List;

public class BubbleSort {

    private List<Integer> arr;

    public BubbleSort(List<Integer> arr) {
        this.arr = arr;
    }

    public List<Integer> sort() {

        // Iterate through array
        // Optimise to ensure there is no unused passes
        boolean swapped;

        for (int i = 0; i < arr.size(); i++) {
            // For each element
            swapped = false;

            for (int j = 0; j < arr.size() - i - 1; j++) {
                // Check for swap
                if (arr.get(j) > arr.get(j + 1)) {
                    swapped = true;
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }

            // if no swaps are made end the sorting
            if (!swapped) {
                break;
            }
        }

        return arr;

    }

}
