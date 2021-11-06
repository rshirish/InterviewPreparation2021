package com.shirish.trees;


public class SymmetricTree_25 {
    /*
                  1
                 /  \
                2    2
               / \   / \
              3   4  4  3

   */
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);


        root.right.left = new Node(3);
        root.right.right = new Node(4);


        boolean flag = symmetricTree(root);
        System.out.println("Result : " + flag);
    }

    private static boolean symmetricTree(Node root) {
        return root == null || symmetricTreeHelp(root.left, root.right);
    }

    private static boolean symmetricTreeHelp(Node leftNode, Node rightNode) {
        if(leftNode == null || rightNode == null)
            return leftNode == rightNode;

        if(leftNode.data != rightNode.data)
            return false;
        return symmetricTreeHelp(leftNode.left, rightNode.right) && symmetricTreeHelp(leftNode.right, rightNode.left) ;
    }
}
