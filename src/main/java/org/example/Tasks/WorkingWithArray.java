package org.example.Tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WorkingWithArray {

    public static void printResult() {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var generatedArray = getRandomArray(n);
        var arrayInString = Arrays.toString(generatedArray);
        System.out.println(arrayInString.substring(1, arrayInString.length()-2));
        System.out.println(getMinModulo(generatedArray));
    }

    private static int[] getRandomArray(int n) {
        var arr = new int[n];
        var random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(-100, 100);
        }
        return arr;
    }

    private static int getMinModulo(int[] arr) {
        var min = Integer.MAX_VALUE;
        for (int c : arr) {
            min = Math.min(Math.abs(c), min);
        }
        return min;
    }

}
