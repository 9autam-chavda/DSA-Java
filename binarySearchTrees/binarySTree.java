package binarySearchTrees;

public class binarySTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }   
    }

    public static Node insert (Node root, int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }

        if(root.data > value) {
            root.left = insert(root.left, value);
        }
        else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void inorder (Node root) {
        if(root == null ) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " \t");
        inorder(root.right);
    }

    public static boolean search (Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        }
        else {
            return search(root.right, key);
        }
    }

    public static Node findinordersuccessor (Node root) {
        while (root.left == null) {
            root = root.left;
        }
        return root;
    }


    public static Node delete (Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else { // found case

            // first condition (not have any child)
            if (root.left == null || root.right == null) {
                return null;
            }

            // second condition (have one child)
            if(root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // third condition (have two child) 
             Node IS = findinordersuccessor(root.right);
             root.data = IS.data;
             root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        
        delete(root, 4);
        inorder(root);
    }
}