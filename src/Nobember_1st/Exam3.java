package Nobember_1st;

import java.util.Arrays;

public class Exam3 {
    static void print(String label, int[] arr) {
        System.out.println(label + " " + Arrays.toString(arr));
    }

    static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        print("정렬 전", arr);
        insertSort(arr);
        print("정렬 후", arr);
    }
}