package datastruct.tree;

/**
 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 */
import java.util.HashMap;
import java.util.Map;

// Class for a tree node
class TreeNode {

	// data members
	private int key;
	private TreeNode left;
	private TreeNode right;

	// Accessor methods
	public int key()        { return key; }
	public TreeNode left()  { return left; }
	public TreeNode right() { return right; }

	// Constructor
	public TreeNode(int key) { this.key = key; left = null; right = null; }

	// Methods to set left and right subtrees
	public void setLeft(TreeNode left)   { this.left = left; }
	public void setRight(TreeNode right) { this.right = right; }
}

// Class for a Binary Tree
class Tree {

	private TreeNode root;

	// Constructors
	public Tree() { root = null; }
	public Tree(TreeNode n) { root = n; }

	// Method to be called by the consumer classes like Main class
	public void verticalSumMain() { verticalSum(root); }

	// A wrapper over verticalSumUtil()
	private void verticalSum(TreeNode root) {

		// base case
		if (root == null) { return; }

		// Creates an empty hashMap hM
		HashMap<Integer, Integer> map = new HashMap();

		// Calls the verticalSumUtil() to store the vertical sum values in hM
		verticalSumUtil(root, 0, map);

		// Prints the values stored by verticalSumUtil()
		if (map != null) {
			System.out.println(map.entrySet());
		}
	}

	// Traverses the tree in Inoorder form and builds a hashMap hM that
	// contains the vertical sum
	private void verticalSumUtil(TreeNode root, int horizontalDistance, Map<Integer, Integer> hM) {

		// base case
		if (root == null) {  return; }

		// Store the values in hM for left subtree
		verticalSumUtil(root.left(), horizontalDistance - 1, hM);

		// Update vertical sum for hD of this node
		int prevSum = (hM.get(horizontalDistance) == null) ? 0 : hM.get(horizontalDistance);
		hM.put(horizontalDistance, prevSum + root.key());

		// Store the values in hM for right subtree
		verticalSumUtil(root.right(), horizontalDistance + 1, hM);
	}
}

// Driver class to test the verticalSum methods
public class VerticalSum {

	public static void main(String[] args) {
        /* Create following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        */
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.left().setLeft(new TreeNode(4));
		root.left().setRight(new TreeNode(5));
		root.right().setLeft(new TreeNode(6));
		root.right().setRight(new TreeNode(7));
		Tree t = new Tree(root);

		System.out.println("Following are the values of vertical sums with "
				+ "the positions of the columns with respect to root ");
		t.verticalSumMain();
	}
}