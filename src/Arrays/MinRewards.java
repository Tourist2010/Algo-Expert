package Arrays;

import java.util.*;

/*Difficulty - Medium*/
public class MinRewards {
    public static void main(String[] args){
        System.out.println(minRewards(new int[]{0, 4, 2, 1, 3}));
    }

    /*TimeComplexity - O(n) where n is the size of the list
      Space Complexity - O(n) - to store the rewards */
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        // O(n)
        for(int i = 1; i < scores.length; i++){
            if(scores[i] > scores[i-1]){
                rewards[i] = rewards[i-1] + 1;
            }
        }

        // O(n)
        for(int i = scores.length-2; i >= 0; i--){
            if(scores[i] > scores[i+1]){
                rewards[i] = Math.max(rewards[i], rewards[i+1] + 1);
            }
        }

        int minRewards = 0;
        for(int i : rewards)
            minRewards = minRewards + i;

        return minRewards;
    }

    /**
     * method to print the 2D list
     * @param list list to be printed
     */
    public static void printList(int[] list){
        for(int i : list){
            System.out.println(i + " ");
        }
    }
}