package me.isaacbarker.Sorter;

import java.util.List;

public class Visualiser {

    public static void render(List<Integer> arr) {
        // Render a graph visualising the sort
        int WIDTH = 25;
        int HEIGHT = 10;
        // WIDTH * heightStep = HEIGHT
        // heightStep = HEIGHT / WIDTH
        double heightStep = (double) HEIGHT / arr.size();
        // WIDTH * widthStep = arr.size()
        // widthStep = arr.size() / WIDTH
        int widthStep = arr.size() / WIDTH;

        // Iterate through height and print out correct heights
        for (int i = HEIGHT + 1; i >= 0; i--) {
            String row = "";

            if (i == 0) { // Print indexes
                for (int j = 0; j < arr.size(); j += widthStep) {
                    row += String.format("%4d", j);
                }
            } else {
                for (int j = 0; j < arr.size(); j += widthStep) { // Build bar chart
                    double val = arr.get(j) * heightStep;

                    if (val <= i) {
                        row += "    ";
                    } else {
                        row += "   ▒"; //⬜ ▒ 🞓
                    }
                }
            }

            System.out.println(row);
        }
    }
}
