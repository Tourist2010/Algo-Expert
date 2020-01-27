package Arrays;

import java.util.*;

/*Difficulty - Medium*/
public class SubArraySort {
    public static void main(String[] args){
        printList(Objects.requireNonNull(subarraySort(new int[]{1, 2, 8, 4, 5})));
    }

    /*TimeComplexity - O(n) where n is the size of the list
      Space Complexity - O(1) */
    public static int[] subarraySort(int[] array) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int li = 0;
        int ri = array.length-1;

        for(int i = 0; i < array.length; i++){
            if(i == 0){
                if(array[i] > array[i+1]){
                    left = Math.min(left, array[i]);
                    right = Math.max(right, array[i]);
                }
            } else if(i == array.length-1) {
                if(array[i] < array[i-1]) {
                    left = Math.min(left, array[i]);
                    right = Math.max(right, array[i]);
                }
            } else if(array[i] > array[i+1] || array[i] < array[i-1]){
                left = Math.min(left, array[i]);
                right = Math.max(right, array[i]);
            }
        }

        if(left == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }

        for(int i = 0; i < array.length-1; i++){
            if(left < array[i]){
                li = i; break;
            } else if(left >= array[i] && left < array[i+1]){
                li = i+1; break;
            }
        }

        for(int i = array.length-1; i > 0; i--){
            if(right > array[i]){
                ri = i; break;
            } else if(right < array[i] && right >= array[i-1]){
                ri = i-1; break;
            }
        }
        return new int[]{li, ri};
    }

    /**
     * method to print the 2D list
     * @param list list to be printed
     */
    public static void printList(int[] list){
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}