package BinaryTree;


import java.util.ArrayList;
import java.util.List;

/*Difficulty - Medium*/
public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        findSum(root, res, 0);
        return res;
    }

    //Time - O(n) | Space - O(n) where n is the number of nodes
    public static void findSum(BinaryTree root, List<Integer> arrayList, int sum){
        if(root == null) return;
        sum = sum + root.value;
        if(root.left != null)
            findSum(root.left, arrayList, sum);
        if(root.right != null)
            findSum(root.right, arrayList, sum);
        if(root.left == null && root.right == null)
            arrayList.add(sum);
    }
}