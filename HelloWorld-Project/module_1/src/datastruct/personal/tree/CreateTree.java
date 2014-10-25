package datastruct.personal.tree;

//Definition for binary tree
class BinaryNode {
	int val;
	BinaryNode left;
	BinaryNode right;
	BinaryNode(int x) { val = x; }
}

//Create binary tree using in-order and post-order tree
public class CreateTree {

	public static void main(String[] main) {
		int[] in_order =   {4, 2, 5, 1,  6, 7, 3, 8};
		int[] post_order = {4, 5, 2 , 6, 7, 8, 3, 1}; // left -> right -> root

	}

	public BinaryNode buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length-1;
		int postStart =0;
		int postEnd = postorder.length-1;

		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public BinaryNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if(inStart > inEnd || postStart > postEnd) return null;

		int rootValue = postorder[postEnd];
		BinaryNode root = new BinaryNode(rootValue);

		int k=0;
		for(int i=0; i < inorder.length; i++){
			if(inorder[i]==rootValue){
				k = i;
				break;
			}
		}

		// inEnd => k - 1 ;
		// postEnd => postStart + k - (inStart + 1)
		root.left = buildTree(inorder, inStart, k-1, postorder, postStart, postStart+k-(inStart+1));
		// Because k is not the length, it it need to -(inStart+1) to get the length

		root.right = buildTree(inorder, k+1, inEnd, postorder, postStart+k-inStart, postEnd-1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1

		return root;
	}
}