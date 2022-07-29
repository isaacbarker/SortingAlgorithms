package me.isaacbarker.Sorter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Print ASCII art

        // ANSI colours
        String GREEN = "\u001B[32m";
        String BOLD = "\u001b[1m";
        String UNDERLINE = "\u001b[4m";
        String RESET = "\u001b[0m";

        // ASCII Art
        System.out.println("\n" +
                "\n" +
                "                                                                                                                           \n" +
                "                                                                                                                           \n" +
                "   ,---,                                                          ,---,.                           ,-.                     \n" +
                ",`--.' |                                                        ,'  .'  \\                      ,--/ /|                     \n" +
                "|   :  :                                                      ,---.' .' |             __  ,-.,--. :/ |             __  ,-. \n" +
                ":   |  '  .--.--.                                             |   |  |: |           ,' ,'/ /|:  : ' /            ,' ,'/ /| \n" +
                "|   :  | /  /    '    ,--.--.      ,--.--.     ,---.          :   :  :  /  ,--.--.  '  | |' ||  '  /      ,---.  '  | |' | \n" +
                "'   '  ;|  :  /`./   /       \\    /       \\   /     \\         :   |    ;  /       \\ |  |   ,''  |  :     /     \\ |  |   ,' \n" +
                "|   |  ||  :  ;_    .--.  .-. |  .--.  .-. | /    / '         |   :     \\.--.  .-. |'  :  /  |  |   \\   /    /  |'  :  /   \n" +
                "'   :  ; \\  \\    `.  \\__\\/: . .   \\__\\/: . ..    ' /          |   |   . | \\__\\/: . .|  | '   '  : |. \\ .    ' / ||  | '    \n" +
                "|   |  '  `----.   \\ ,\" .--.; |   ,\" .--.; |'   ; :__         '   :  '; | ,\" .--.; |;  : |   |  | ' \\ \\'   ;   /|;  : |    \n" +
                "'   :  | /  /`--'  //  /  ,.  |  /  /  ,.  |'   | '.'|        |   |  | ; /  /  ,.  ||  , ;   '  : |--' '   |  / ||  , ;    \n" +
                ";   |.' '--'.     /;  :   .'   \\;  :   .'   \\   :    :        |   :   / ;  :   .'   \\---'    ;  |,'    |   :    | ---'     \n" +
                "'---'     `--'---' |  ,     .-./|  ,     .-./\\   \\  /         |   | ,'  |  ,     .-./        '--'       \\   \\  /           \n" +
                "                    `--`---'     `--`---'     `----'          `----'     `--`---'                        `----'            \n" +
                "======================================================>isaacbarker.me<====================================================="
        );

        // Print info
        System.out.println(BOLD + "SORTINGVISUALISER by Isaac Barker: https://isaacbarker.me");
        System.out.println(BOLD + "Please select the sorting algorithm: " + RESET + "bubble, merge");

        // Get type of selection algorithm to run
        String input = "";

        while (!(input.equalsIgnoreCase("bubble") ||
                input.equalsIgnoreCase("merge"))
        ) {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        }

        // Sort an array of numbers 1-n
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            arr.add(i + 1);
        }
        Collections.shuffle(arr);

        // Render starting array
        System.out.println(GREEN + BOLD + "Sorting in progress... Timer starting." + RESET);

        System.out.println(UNDERLINE + "Starting array:" + RESET);
        Visualiser.render(arr);

        long startTime = System.currentTimeMillis();
        List<Integer> result = null;

        if (input.equalsIgnoreCase("bubble")) { // O(n^2)
            BubbleSort bubbleSort = new BubbleSort(arr);
            result = bubbleSort.sort();
        } else if (input.equalsIgnoreCase("merge")) { // O(log n)
            MergeSort mergeSort = new MergeSort(arr);
            result = mergeSort.sort();
        }

        // Render result
        System.out.println(UNDERLINE + "\nSorted array:" + RESET);
        Visualiser.render(result);

        // Timings
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("\n" + BOLD + "Sort took " + endTime + " milliseconds.\n");
        System.out.println(BOLD + "Thank you! Check out my Github:" + RESET + "https://github.com/isaacbarker");
    }
}