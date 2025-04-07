package com.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = { 10, 20, 3, -1, 1, 2, 2};
        mergeSort(numbers);

        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }

    private static void mergeSort(int[] numbers){

        int length = numbers.length;

        //Base case of recursion.
        if(length <=  1){
            return;
        }

        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        int i = 0;
        int j = 0;

        for(; i < length; i++){
            if(i < middle){
                left[i] = numbers[i];
            }else{
                right[j] = numbers[i];
                j++;
            }
        }

        mergeSort(left);
        mergeSort(right);
        merge(left,right,numbers);
    }


    //Using while
    private static void merge(int[] left, int[] right, int[] array) {
        // Pointers:
        int i = 0; // Right index.
        int j = 0; // Left index.
        int k = 0; // Array Index.

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }


        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }


    private static void mergeWithFor(int[] left, int[] right, int[] array){
        int leftPosition = 0;
        int rightPosition = 0;

        for (int i = 0; i < array.length; i++) {
            // Si ambos arreglos tienen elementos por comparar
            if (leftPosition < left.length && rightPosition < right.length) {
                if (left[leftPosition] < right[rightPosition]) {
                    array[i] = left[leftPosition];
                    leftPosition++;
                } else {
                    array[i] = right[rightPosition];
                    rightPosition++;
                }
            }
            // Si ya se acabó el arreglo right
            else if (leftPosition < left.length) {
                array[i] = left[leftPosition];
                leftPosition++;
            }
            // Si ya se acabó el arreglo left
            else {
                array[i] = right[rightPosition];
                rightPosition++;
            }
        }
    }



}
