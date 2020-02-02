package Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Difficulty - Medium*/
public class SameBSTs {

    public static void main(String[] args){
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(50, 76, 81, 23, 23, 23, 657, 56, 12, -1, 3));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(50, 23, 76, 23, 23, 12, 56, 81, -1, 3, 657));
        System.out.println(sameBsts(arrayOne, arrayTwo));
    }
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.size() != arrayTwo.size()) return false;
        return sameBSTHelper(0, 0, arrayOne, arrayTwo, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //O(n^2) time | O(d) space where d is the depth of the tree and n is the number of nodes in each array
    public static boolean sameBSTHelper(int indexA, int indexB, List<Integer> arrayA, List<Integer> arrayB, int min, int max){
        if((indexA == -1 && indexB != -1) || (indexA != -1 && indexB == -1)) return false;
        if(indexA == -1 && indexB == -1) return true;
        if(!arrayA.get(indexA).equals(arrayB.get(indexB))) return false;
        int leftA = -1, rightA = -1, leftB = -1, rightB = -1;
        for(int i = indexA + 1; i < arrayA.size(); i++){
            if(arrayA.get(i) < arrayA.get(indexA) && arrayA.get(i) >= min){
                leftA = i;
                break;
            }
        }

        for(int i = indexB + 1; i < arrayB.size(); i++){
            if(arrayB.get(i) < arrayB.get(indexB) && arrayB.get(i) >= min){
                leftB = i;
                break;
            }
        }

        for(int i = indexA + 1; i < arrayA.size(); i++){
            if(arrayA.get(i) >= arrayA.get(indexA) && arrayA.get(i) < max){
                rightA = i;
                break;
            }
        }

        for(int i = indexB + 1; i < arrayB.size(); i++){
            if(arrayB.get(i) >= arrayB.get(indexB) && arrayB.get(i) < max){
                rightB = i;
                break;
            }
        }

        return sameBSTHelper(leftA, leftB, arrayA, arrayB, min, arrayA.get(indexA))
                && sameBSTHelper(rightA, rightB, arrayA, arrayB, arrayA.get(indexA), max);

    }
}