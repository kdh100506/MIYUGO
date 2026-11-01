package Nobember_1st;

import java.util.Arrays;

public class Exam2 {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(String label, int[] arr) {
        System.out.println(label + " " + Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        print("정렬 전", arr);
        selectionSort(arr);
        print("정렬 후", arr);
    }
}