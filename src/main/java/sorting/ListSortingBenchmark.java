package sorting;

import sorting.impl.*;

import java.util.*;
import java.util.stream.Collectors;

public class ListSortingBenchmark {
    public static void main(String[] args) {
        List<ListSortingAlgorithm<Integer>> algorithms = Arrays.asList(new BubbleSort<>(), new InsertionSort<>(), new MergeSort<>(), new QuickSort<>(), new SelectionSort<>());

        int numberOfElements = 10000;
        runBenchmark(algorithms, numberOfElements);
    }

    private static void runBenchmark(List<ListSortingAlgorithm<Integer>> algorithms, int numberOfElements) {
        printHeader(numberOfElements);

        List<Integer> LIST_TO_SORT = new Random().ints(numberOfElements).boxed().collect(Collectors.toList());

        for (ListSortingAlgorithm<Integer> algo : algorithms) {

            long startTime = System.currentTimeMillis();
            algo.sort(new ArrayList<>(LIST_TO_SORT));

            System.out.format("%20s %20s", algo.getClass().getSimpleName(), (System.currentTimeMillis() - startTime));
            System.out.println();
        }

        long startTime = System.currentTimeMillis();
        Collections.sort(new ArrayList<>(LIST_TO_SORT));

        System.out.format("%20s %20s", "Collections.sort", (System.currentTimeMillis() - startTime));
        System.out.println();
    }

    private static void printHeader(int numberOfElements) {
        System.out.println(numberOfElements + " elements to sort.");

        System.out.println("-----------------------------------------------");
        System.out.printf("%20s %20s", "ALGO", "TIME(ms)");
        System.out.println();
        System.out.println("-----------------------------------------------");
    }
}
