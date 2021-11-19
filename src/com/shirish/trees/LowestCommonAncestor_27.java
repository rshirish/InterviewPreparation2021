package com.shirish.trees;

import java.util.List;

public class LowestCommonAncestor_27 {

    /*
                    1
                   /  \
                  2    3
                 / \   / \
                4   5  7  8
                    /     / \
                   6     9   10
     */
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        Node result = lowestCommonAncestor(root, root.left.left , root.left.right.left);
        System.out.println("Result : " + result.data);

    }

    private static Node lowestCommonAncestor(Node node, Node p, Node q) {

        if(node == null || p == node || q == node) {
            return node;
        }
        Node leftNode = lowestCommonAncestor(node.left , p , q);
        Node rightNode = lowestCommonAncestor(node.right, p, q);

        if(leftNode == null)
            return rightNode;
        else if (rightNode == null)
            return leftNode;
        else
            return node;

    }
}
