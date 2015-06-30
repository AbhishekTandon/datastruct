package com.tandon.datastruct.personal.tree;

import com.tandon.datastruct.component.BinaryTreeNode;

import java.util.*;

public class DepthFirst
{
    private static void depth(ArrayList<BinaryTreeNode> Q)
    {
        ArrayList<BinaryTreeNode> T = new ArrayList<BinaryTreeNode>();

        for(BinaryTreeNode t:Q)
        {
            System.out.println(t.data);

            if (t.right!=null) T.add(t.right);
            if (t.left!=null) T.add(t.left);
        }

        if (T.size()>0) depth(T);

        return;
    }

    public static void main(String[] args)
    {
        int[] A = {10, 5, 30, 3, 7, 20, 40, 1, 4, 6, 8, 15, 25, 35, 45};

        BinaryTreeNode root = new BinaryTreeNode(A[0]);

        for(int i=1; i < A.length; i++) {
            root.insert(A[i]);
        }

        ArrayList<BinaryTreeNode> R = new ArrayList<BinaryTreeNode>(1);
        R.add(root);
        depth(R);

        return;
    }
}