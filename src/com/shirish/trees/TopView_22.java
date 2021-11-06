package com.shirish.trees;

import java.util.*;

public class TopView_22 {

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

        List<Integer> preorder = topView(root);
        System.out.println("Result : " + preorder);

    }

    private static List<Integer> topView(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Integer> resultMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.remove();
            Node tempNode = temp.node;
            Integer line = temp.line;
            if (resultMap.get(line) == null) {
                resultMap.put(line, tempNode.data);
            }

            if (tempNode.left != null) {
                queue.add(new Pair(tempNode.left, line - 1));
            }
            if (tempNode.right != null) {
                queue.add(new Pair(tempNode.right, line + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;


    }

    static class Pair {

        public Pair(Node node, Integer line) {
            this.node = node;
            this.line = line;
        }

        Node node;
        Integer line;


    }
}
