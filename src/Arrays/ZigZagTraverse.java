package Arrays;

import java.util.*;

/*Difficulty - Medium*/
public class ZigZagTraverse {
    public static void main(String[] args){
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        test.add(new ArrayList<>(Arrays.asList(6, 7, 8)));
        test.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
        printList(Objects.requireNonNull(zigzagTraverse(test)));
    }

    /*TimeComplexity - O(n) where n is the size of the list
      Space Complexity - O(n) - result size */
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        boolean isDown = true;
        int rows = array.size();
        int cols = array.get(0).size();
        res.add(array.get(i).get(j));

        // O(n)
        while(i != rows-1 || j != cols-1){
            if(isDown){
                i++; j--;
                if(i > rows-1){
                    i = rows - 1;
                    j = j + 2;
                    isDown = false;
                }else if(j < 0 && i <= rows-1){
                    j = 0;
                    isDown = false;
                }

            } else {
                i--; j++;
                if(j > cols - 1){
                    j = cols - 1;
                    i = i + 2;
                    isDown = true;
                }else if(i < 0 && j <= cols-1){
                    i = 0;
                    isDown = true;
                }

            }
            res.add(array.get(i).get(j));
        }
        return res;
    }

    /**
     * method to print the 2D list
     * @param list list to be printed
     */
    public static void printList(List<Integer> list){
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }
}