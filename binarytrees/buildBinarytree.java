package binarytrees;

import java.util.*;

public class buildBinarytree {
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

    static class  buildBtree {
        static int idx = -1;
        public Node buildTree (int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public void treePreorder (Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            treePreorder(root.left);
            treePreorder(root.right);
        }

        public void treeInorder (Node root) {
            if (root == null) {
                return;
            }
            treeInorder(root.left);
            System.out.print(root.data + " ");
            treeInorder(root.right);
        }

        public void treePostorder (Node root) {
            if (root == null) {
                return;
            }
            treePostorder(root.left);
            treePostorder(root.right);
            System.out.print(root.data + " ");
        }

        public void treeLevelorder (Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }
                    else {
                        q.add(null);
                    }

                }
                else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
            
        }

        public static int heightOfTree(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public int totalNodes(Node root) {
            if (root == null ) {
                return 0;
            }

            int leftNodes = totalNodes(root.left);
            int rightNodes = totalNodes(root.right);
            return leftNodes + rightNodes + 1;
        }

        public int sumOfNodes (Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        public int diameterOftree (Node root) { // O(n^2) approach1
            if (root == null) {
                return 0;
            }

            int leftdiam = diameterOftree(root.left);
            int leftHt = heightOfTree(root.left);
            int rightdiam = diameterOftree(root.right);
            int rightHt = heightOfTree(root.right);

            int selfDia = leftHt + rightHt + 1;

            return Math.max(selfDia, Math.max(rightdiam, leftdiam));
        }

        static class info {
            int hight;
            int diameter;

            info(int hight, int diameter) {
                this.hight = hight;
                this.diameter = diameter;
            }
        }

        public info diameterOftree2(Node root) { // O(n) approach2
            if (root == null) {
                return new info(0, 0);
            }

            info leftInfo = diameterOftree2(root.left);
            info rightInfo = diameterOftree2(root.right);

            int selfHeight = Math.max(leftInfo.hight, rightInfo.hight) + 1;
            int selfDiameter = Math.max(leftInfo.hight + rightInfo.hight + 1, Math.max(leftInfo.diameter, rightInfo.diameter));

            return new info(selfHeight, selfDiameter);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        buildBtree tree = new buildBtree();
        Node root = tree.buildTree(nodes);
        tree.treeLevelorder(root);
        System.out.println("total nodes in tree: " + tree.totalNodes(root));
        System.out.println("sum of nodes: "+ tree.sumOfNodes(root));
        System.out.println("diameter of tree: "+ tree.diameterOftree2(root).diameter);
    }
}
