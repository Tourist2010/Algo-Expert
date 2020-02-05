package BinaryTree;

/*Difficulty - Medium*/
public class InvertBinaryTree {
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

    //Time O(n) | Space O(d) where n is the number of the nodes and d is depth of binary tree
    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null || (tree.left == null && tree.right == null)) return;
        BinaryTree helper = tree.right;
        tree.right = tree.left;
        tree.left = helper;
        if (tree.left != null)
            invertBinaryTree(tree.left);
        if(tree.right != null)
            invertBinaryTree(tree.right);
    }
}