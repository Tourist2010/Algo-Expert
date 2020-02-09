package BinaryTree;

public class MaxPathSum {
    public static int maxPathSum(BinaryTree tree) {
        return maxPathSumHelper(tree)[1];
    }

    public static int[] maxPathSumHelper(BinaryTree tree){
        if (tree == null) return new int[]{0,0};
        int[] leftSum = maxPathSumHelper(tree.left);
        int[] rightSum = maxPathSumHelper(tree.right);

        int maxOfLeftRightBranch = Math.max(leftSum[0], rightSum[0]);
        int maxOfLeftRightOverall = Math.max(leftSum[1], rightSum[1]);

        int maxWithRoot = Math.max(maxOfLeftRightBranch + tree.value, leftSum[0] + tree.value + rightSum[0]);
        int totalMax = Math.max(maxWithRoot, maxOfLeftRightOverall);
        return new int[]{maxOfLeftRightBranch + tree.value, totalMax};
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
