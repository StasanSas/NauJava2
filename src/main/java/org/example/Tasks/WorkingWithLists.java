package org.example.Tasks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;



public class WorkingWithLists {
    public static void printResult() {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var generatedList = GetRandomList(n);
        System.out.println(generatedList.stream()
                                        .map(Object::toString)
                                        .collect(Collectors.joining(", ")));

        QuickSort(generatedList, 0, generatedList.size()-1);

        System.out.println(generatedList.stream()
                                        .map(Object::toString)
                                        .collect(Collectors.joining(", ")));
    }

    private static ArrayList<Integer> GetRandomList(int n) {
        var arr = new ArrayList<Integer>(n);
        var random = new Random();
        for (int i = 0; i < n; i++) {
            arr.add(random.nextInt(-100, 100));
        }
        return arr;
    }

    private static void QuickSort(ArrayList<Integer> arr, int left, int right) {
        var i = left;
        var j = right;
        var pivot = arr.get(left + (right - left) / 2);
        while (i <= j) {
            while (arr.get(i) < pivot)
                i++;
            while (pivot < arr.get(j))
                j--;
            if (i <= j) {
                var temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
                j--;
            }
        }
        if (left < j)
            QuickSort(arr, left, j);
        if (i < right)
            QuickSort(arr, i, right);
    }
}
