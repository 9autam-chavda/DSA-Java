package binarytrees;

import java.util.*;

public class topViewOfTree {

    static class  Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
    }

    static class info {
        Node node;
        int horizontalDistance;

        info(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    public static void topView(Node root) {
        if (root == null) {
            return;
        }
  
        Map<Integer, Node> map = new TreeMap<>();
        Queue<info> queue = new LinkedList<>();
        queue.add(new info(root, 0));

        while (!queue.isEmpty()) {
            info current = queue.remove();
            Node currentNode = current.node;
            int horizontalDistance = current.horizontalDistance;

            if (!map.containsKey(horizontalDistance)) {
                map.put(horizontalDistance, currentNode);
            }

            if (currentNode.left != null) {
                queue.add(new info(currentNode.left, horizontalDistance - 1));
            }
            if (currentNode.right != null) {
                queue.add(new info(currentNode.right, horizontalDistance + 1));
            }
        }

        for (Node node : map.values()) {
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}
