import java.util.HashSet;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class BSTPairSum {
    private TreeNode root;

    public BSTPairSum() {
        root = null;
    }

    // Insert a node into the BST
    private TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Helper function to check if a pair with the given sum exists in BST
    private boolean findPairUtil(TreeNode root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (findPairUtil(root.left, sum, set)) {
            return true;
        }

        if (set.contains(sum - root.val)) {
            System.out.println("Pair found: " + root.val + " + " + (sum - root.val) + " = " + sum);
            return true;
        } else {
            set.add(root.val);
        }

        return findPairUtil(root.right, sum, set);
    }

    // Function to find a pair with the given sum in BST
    public void findPair(TreeNode root, int sum) {
        HashSet<Integer> set = new HashSet<>();
        if (!findPairUtil(root, sum, set)) {
            System.out.println("No pair found with sum " + sum + " in the BST.");
        }
    }

    public static void main(String[] args) {
        // Create a Binary Search Tree
        BSTPairSum bst = new BSTPairSum();
        bst.root = bst.insert(bst.root, 6);
        bst.root = bst.insert(bst.root, 3);
        bst.root = bst.insert(bst.root, 9);
        bst.root = bst.insert(bst.root, 2);
        bst.root = bst.insert(bst.root, 4);
        bst.root = bst.insert(bst.root, 7);
        bst.root = bst.insert(bst.root, 10);

        int sum = 13;
        bst.findPair(bst.root, sum);
    }
}
