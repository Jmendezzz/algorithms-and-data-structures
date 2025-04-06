package com.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    /* Bubble sort algorithm.
    * Time complexity: O(n ^ 2)
    * Space complexity O(1)
    */
    public static void main(String[] args) {

        int[] numbers = {3, -2, 10, 1, 5 , 4 ,2};

        bubbleSort(numbers);

        Arrays.stream(numbers).forEach(System.out::print);
    }


    public static void bubbleSort(int[] numbers){

        for(int i = 0; i < numbers.length; i++){

            for(int j = 0; j < numbers.length - 1; j++){
                if(numbers[j] > numbers[j + 1]){
                    int aux = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = aux;
                }
            }
        }
    }
}
