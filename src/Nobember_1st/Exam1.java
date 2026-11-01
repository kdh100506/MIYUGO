package Nobember_1st;

import java.util.Arrays;

public class Exam1 {
    static void sort(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(String label, int[] arr) {
        System.out.println(label + " " + Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    sort(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        print("정렬 전", arr);
        bubbleSort(arr);
        print("정렬 후", arr);
    }
}