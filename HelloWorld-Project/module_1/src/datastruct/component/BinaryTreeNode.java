package datastruct.component;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int z) {
        data = z;
        left = null;
        right = null;
    }

    ;

	/**
	 * Insertion rule
	 * smaller elements inserted on right side
	 * greater elements on left side
	 */
    public void insert(int z) {
        BinaryTreeNode t = new BinaryTreeNode(z);

        if (data > z) {
            if (right == null)
                right = t;
            else
                right.insert(z);
        } else {
            if (left == null)
                left = t;
            else
                left.insert(z);
        }

        return;
    }

    public BinaryTreeNode find(int z) {
        BinaryTreeNode t = this;

        if (data == z) return this;

        if (data > z)
            if (right == null)
                t = null;
            else
                t = right.find(z);
        else if (left == null)
            t = null;
        else
            t = left.find(z);

        return t;
    }
}
